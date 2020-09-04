# FROM openjdk:12
# FROM openjdk:8-jre-alpine
# RUN apk --no-cache add curl
# RUN yum -y install git

FROM debian:latest
RUN apt-get -y update
RUN apt-get -y install openjdk-11-jdk-headless
RUN apt-get -y install git
RUN apt-get -y install maven
RUN apt-get -y install sysstat
COPY . /usr/share/robotap/
EXPOSE 8080
COPY entrypoint.sh /usr/share/scripts/entrypoint.sh
ENTRYPOINT ["sh", "/usr/share/scripts/entrypoint.sh"]
# ENTRYPOINT [ "/usr/bin/java", "-jar", "/usr/share/robotap/target/robo-1.0.1.jar" ]
