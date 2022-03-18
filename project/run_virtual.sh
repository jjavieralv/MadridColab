#!/bin/bash
#script instalation in virtual ubuntu 20.04
#scripted by: jjavieralv


######## GLOBAL PARAMETERS ########
export MYSQL_DB_NAME=xcolab
export MYSQL_USER=colab
#if you define this file content manually, it will NOT be overwritten
export MYSQL_ROOT_PASSWORD_FILE="$(pwd)/DB_ROOT_PASSWORD_ROUTE"
P_DB_ROOT_PASS=perrochico
export MYSQL_PORT=3306
export MYSQL_IP=localhost

######## INDIVIDUAL FUNCTIONS ########

#### graphical functions ####
  function red_messages() {
    #crittical and error messages
    echo -e "\033[31m[ERROR]$1\e[0m"
  }
  function yellow_messages() {
    #warnings
    echo -e "\033[33m[WARNING] $1\e[0m"
  }
  function green_messages() {
    #ok
    echo -e "\033[32m[OK]$1\e[0m"
  }
  function blue_messages() {
    #function executing
    echo -e "\n\033[36m$1\e[0m"
  }
  function magenta_messages(){
    #what part which is executting
    echo -e "\n\e[45m\n$1\n\e[0m\n"
  }

function install_all_packages(){
	blue_messages "installing all packages"
	apt-get update
	apt-get install -y openjdk-8-jdk ant ca-certificates-java mysql-client dos2unix mysql-server
	apt-get clean
    update-ca-certificates -f
    rm -rf /var/lib/apt/lists/*
    rm -rf /var/cache/oracle-jdk8-installer
	export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/
}

function convert_files_to_unix(){
	blue_messages "convert files to unix format"
	find . \( -name "*.sh" -o -name "*.properties" \) -exec dos2unix {} \;
    dos2unix *
}

function give_permissions(){
      blue_messages "give permissions to all files needed"
      chown -R root:root .
      if [[ $? -eq 0 ]]; then
        green_messages "user and group reasigned to all files"
      else
        red_messages "user and group reasigned failed"
        exit 1
      fi
      echo "Now execution permissions to .sh files"
      find . -name "*.sh" -exec chmod +x {} \;
      chmod +x ./{mvnw,RUN.sh}
}

function check_if_root(){
	blue_messages "check if root"
	if [[ "root" == "$(whoami)" ]];then
		green_messages "executing as root"
	else
		red_messages "you need to be root to execute"
		exit 1
	fi
}
function sql_exec_script(){
    blue_messages "executing $1"
    cat "$1" | mysql --host "$MYSQL_IP" --port "$MYSQL_PORT" --user root -p"$P_DB_ROOT_PASS" "$MYSQL_DB_NAME"
    if [[ $? -eq 0 ]];then
      green_messages "script executed correctly"
    else
      red_messages "problem ocurred during script execution"
      exit 1
    fi
}

function sql_run_start_scripts(){
      blue_messages "executing start sql/starter/* scripts"
      for f in sql/starter/* ;do
          sql_exec_script "$f"
      done
}

function create_file_pass(){
	blue_messages "create file pass"
	if [[ -n "$P_DB_ROOT_PASS" ]];then
		echo "$P_DB_ROOT_PASS" > "$MYSQL_ROOT_PASSWORD_FILE"
	else
		echo "pass file has been set manually"
		P_DB_ROOT_PASS="$(cat "$MYSQL_ROOT_PASSWORD_FILE")"
	fi
}

function create_properties_file(){
      blue_messages "create properties file"
      cp ./conf/sample-application.properties tmp_file
      sed -i "/db.url.base=*/s/.*/db.url.base=jdbc:mysql:\/\/$MYSQL_IP:$MYSQL_PORT/" tmp_file
      sed -i "/db.password=*/s/.*/db.password=$P_DB_ROOT_PASS/" tmp_file
      cp tmp_file conf/application.properties
}

function create_database(){
    blue_messages "create database"
    mysql --host "$MYSQL_IP" --port "$MYSQL_PORT" --user root -p"$P_DB_ROOT_PASS" -e "CREATE DATABASE $MYSQL_DB_NAME CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;"&>temp_resul
    if [[ $? -eq 0 ]];then
      green_messages "succesfully db creation"
    else
      grep -q 'database exists' temp_resul
      if [[ $? -eq 0 ]]; then
        yellow_messages "database already exists"
      else
        red_messages "failed db creation"
        cat temp_resul
        exit 1
      fi
    fi

 }

 function install_script(){
 	blue_messages "install script"
 	bash INSTALL.sh
 	if [[ $? -eq 0 ]];then
      green_messages "script executed correctly"
    else
      red_messages "problem ocurred during script execution"
      exit 1
    fi
 }

 function compile_files(){
 	blue_messages "compile files"
 	bash mvnw compile
 	if [[ $? -eq 0 ]];then
      green_messages "script executed correctly"
    else
      red_messages "problem ocurred during script execution"
      exit 1
    fi
 }

function run_exec(){
	blue_messages " run execution"
	bash RUN.sh
	if [[ $? -eq 0 ]];then
      green_messages "script executed correctly"
    else
      red_messages "problem ocurred during script execution"
      exit 1
    fi
}

function change_sql_root_control(){
	blue_messages "change sql root properties in sql"
	mysql --host "$MYSQL_IP" --port "$MYSQL_PORT" --user root -p"$P_DB_ROOT_PASS" -e "ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '$P_DB_ROOT_PASS';FLUSH PRIVILEGES;"
	if [[ $? -eq 0 ]];then
      green_messages "root properties in sql executed correctly"
    else
      red_messages "problem ocurred during root properties in sql"
      exit 1
    fi
}

######## MAIN ########
function main(){
	check_if_root
	create_file_pass
	install_all_packages
	convert_files_to_unix
	give_permissions
	create_properties_file
	create_database
	change_sql_root_control
	install_script
	compile_files
	sql_run_start_scripts
	run_exec
}
main