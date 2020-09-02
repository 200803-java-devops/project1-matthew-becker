FROM openjdk:12
# FROM openjdk:8-jre-alpine
# RUN apk --no-cache add curl
COPY . /usr/share/robotap/
EXPOSE 8080
COPY entrypoint.sh /usr/share/scripts/entrypoint.sh
ENTRYPOINT ["sh", "/usr/share/scripts/entrypoint.sh"]
# ENTRYPOINT [ "/usr/bin/java", "-jar", "/usr/share/robotap/target/robo-1.0.1.jar" ]
