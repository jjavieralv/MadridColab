FROM ubuntu:20.04
MAINTAINER jjavieralv <github jjavieralv>

RUN apt-get update && \
	apt-get install -y openjdk-8-jdk ant ca-certificates-java mysql-client dos2unix && \
	apt-get clean && \
        update-ca-certificates -f && \
        rm -rf /var/lib/apt/lists/* && \ 
        rm -rf /var/cache/oracle-jdk8-installer

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
RUN export JAVA_HOME
