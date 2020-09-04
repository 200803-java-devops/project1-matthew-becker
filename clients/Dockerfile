FROM debian:latest
RUN apt-get -y update
RUN apt-get -y install openjdk-11-jdk-headless
RUN apt-get -y install git
RUN apt-get -y install maven
# COPY . /usr/share/robotap/
ARG PROJECT_NAME
ARG PROJECT_JAR
# RUN export PROJECT_NAME=$PROJECT_NAME
# RUN export PROJECT_JAR=$PROJECT_JAR
COPY $PROJECT_NAME /usr/share/$PROJECT_NAME/
EXPOSE 8080
COPY entrypoint.sh /usr/share/scripts/entrypoint.sh
ENTRYPOINT ["sh", "/usr/share/scripts/entrypoint.sh"]
# ENTRYPOINT [ "/usr/bin/java", "-jar", "/usr/share/$PROJECT_NAME/target/$PROJECT_JAR" ]