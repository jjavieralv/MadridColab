#!/bin/bash
#################################
#                               #
# Dockerized Colab start script # 
#                               #
#################################


######## GLOBAL PARAMETERS ########
SQL_VERSION_MINIMUN=8.0
#### function parameters ####
  function parameters_script_version(){
    SCRIPT_VERSION=0.1
    CODE_REPO='https://github.com/luiscal4a/MadridColab'
    CONTAINERIZED_BY='jjavieralv'
  }

  function parameters_pass_db(){
    P_DB_ROOT_PASS=$(cat "$MYSQL_ROOT_PASSWORD_FILE")
    P_DB_USER_PASS=$(cat "$MYSQL_PASSWORD_FILE")
  }


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

#### script functions ####
  function show_version(){
    blue_messages "show version"
    echo -e "\n
    #################################
    #                               #
    # Dockerized Colab start script # 
    #                               #
    #################################
    "
    set -x
    parameters_script_version
    set +x
  }

  function print_usage(){
    blue_messages "print usage"
    echo "agregar ejemplos del uso"
  }

  function version_ge() { 
    test "$(echo "$@" | tr " " "\n" | sort -rV | head -n 1)" == "$1";
  }

#### database ####
  function create_database(){
    blue_messages "create database"
    parameters_pass_db
    mysql --host "$MYSQL_IP" --port "$MYSQL_PORT" --user root -p"$P_DB_ROOT_PASS" -e "CREATE DATABASE $1 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;"&>temp_resul
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

  function sql_check_connectivity(){
    blue_messages "sql check connectivity"
    parameters_pass_db
    mysqladmin --host "$MYSQL_IP" --port "$MYSQL_PORT" --user root -p"$P_DB_ROOT_PASS" ping
    if [[ $? -eq 0 ]];then
      green_messages "able to connect to mysql"
      return 0
    else
      red_messages "not able to connect to mysql"
      return 1
    fi

  }

  function sql_prestatus() {
    blue_messages "checho if sql accomplish the requirements"
    sql_check_connectivity
    if [[ $? -eq 0 ]];then
      SQL_VERSION=$(mysql --host "$MYSQL_IP" --port "$MYSQL_PORT" --user root -p"$P_DB_ROOT_PASS" -e 'STATUS;'|awk -F '\t' '$1 == "Server version:" { print $3 }'|cut -f 1 -d ' ')
      if [[ $? -eq 0 ]];then 
        echo "sql version is $SQL_VERSION"
        version_ge $SQL_VERSION $SQL_VERSION_MINIMUN
        if [[ $? -eq 0 ]];then
          green_messages "sql version is >= $SQL_VERSION_MINIMUN"
        else
          red_messages "sql version is < $SQL_VERSION_MINIMUN"
          exit 1
        fi
      else
        red_messages "unable to access to sql"
        exit 1
      fi
    else
      exit 1
    fi
  }

  function sql_exec_script(){
    blue_messages "executing $1"
    cat "$1" | mysql --host "$MYSQL_IP" --port "$MYSQL_PORT" --user root -p"$P_DB_ROOT_PASS" "$MYSQL_DATABASE_NAME"
    if [[ $? -eq 0 ]];then
      green_messages "script executed correctly"
    else
      red_messages "problem ocurred during script execution"
    fi
  }

#### java ####
  function java_prestatus(){
    # Check Java Version and check if Java is in Path
    blue_messages "check if java accomplish the requirements"
    if type -p java; then
        green_messages "Found java executable in PATH"
        _java=java
    elif [[ -n "$JAVA_HOME" ]] && [[ -x "$JAVA_HOME/bin/java" ]];  then
        green_messages "Found java executable in JAVA_HOME"     
        _java="$JAVA_HOME/bin/java"
    else
        red_messages "No Java installation found. Please make sure Java 1.8 is installed and set up in PATH."
        exit 1
    fi

    if [[ "$_java" ]]; then
        version=$("$_java" -version 2>&1 | awk -F '"' '/version/ {print $2}')
        echo "Java Version" "$version"
        if [[ "$version" > "1.8" ]]; then
            green_messages "Java version is sufficient (>=1.8)"
        else         
            red_messages "Java version is below 1.8. Please make sure Java 1.8 is installed and set up in PATH."
            exit 1
        fi
    fi
  } 

#### script ####
    function convert_endline(){
      blue_messages "convert files to linux endline format"
      find "$COLAB_PROYECT_MOUNTPOINT" \( -name "*.sh" -o -name "*.properties" \) -exec dos2unix {} \;
      dos2unix "$COLAB_PROYECT_MOUNTPOINT"/*
    }

    function give_permissions(){
      blue_messages "give permissions to all files needed"
      chown -R root:root "$COLAB_PROYECT_MOUNTPOINT"
      if [[ $? -eq 0 ]]; then
        green_messages "user and group reasigned to all files"
      else
        red_messages "user and group reasigned failed"
        exit 1
      fi
      echo "Now execution permissions to .sh files"
      find "$COLAB_PROYECT_MOUNTPOINT" -name "*.sh" -exec chmod +x {} \;
      chmod +x "$COLAB_PROYECT_MOUNTPOINT"/{mvnw,RUN.sh}
    }

    function create_properties_file(){
      blue_messages "create properties file"
      parameters_pass_db
      cp $COLAB_PROYECT_MOUNTPOINT$COLAB_DEFAULT_CONF_ROUTE tmp_file
      sed -i "/db.url.base=*/s/.*/db.url.base=jdbc:mysql:\/\/$MYSQL_IP:$MYSQL_PORT/" tmp_file
      sed -i "/db.password=*/s/.*/db.password=$P_DB_ROOT_PASS/" tmp_file
      cp tmp_file ~/.xcolab.application.properties

    }

    function sql_run_start_scripts(){
      blue_messages "executing start $COLAB_PROYECT_MOUNTPOINT$DB_SCRIPT_START_ROUTE scripts"
      for f in $COLAB_PROYECT_MOUNTPOINT$DB_SCRIPT_START_ROUTE/* ;do
          sql_exec_script "$f"
      done
    }


######## AGGREGATED FUNCTIONS ########
function check_scripts_prerequisites(){
  magenta_messages "check scripts prerequisites"
  give_permissions
  convert_endline
  create_properties_file
}

function check_prerequisites() {
  magenta_messages "check_prerequisites"
  java_prestatus
  sql_prestatus
}

function sql_initialization(){
  magenta_messages "sql sql_initialization"
  create_database "$MYSQL_DATABASE_NAME"
}

function colab_first_start(){
  magenta_messages " colab first start"
  cd $COLAB_PROYECT_MOUNTPOINT
  bash mvnw compile
  sql_run_start_scripts
  bash RUN.sh
}

function main(){
  magenta_messages "\n\nStarting main execution\n\n"
  check_scripts_prerequisites
  check_prerequisites
  sql_initialization
  colab_first_start

}



######## MAIN ########
while getopts 'vhp' OPTION; do
  case "$OPTION" in
    p)  check_prerequisites
        exit 0
        ;;
    v)  show_version
        exit 0
        ;;
    h)  print_usage
        exit 0
        ;;
    *)  echo "no se que me dices illo"
        ;;
  esac
done

main