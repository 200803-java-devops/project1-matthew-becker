#!/bin/bash
# the first arg passsed in is for filename

export PORT=8082
echo starting server on port $PORT
cd /usr/share/$PROJECT_NAME/
java -jar /usr/share/$PROJECT_NAME/target/$PROJECT_JAR
