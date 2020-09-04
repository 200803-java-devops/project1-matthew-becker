#!/bin/bash
# the first arg passsed in is filename = $1

echo $1

#this will search and find .jar file
jarFilePath=$(ls $1/target | grep .jar | tail -1)

echo $jarFilePath

#This calls docker build
docker build --build-arg PROJECT_NAME=$1 --build-arg PROJECT_JAR=$jarFilePath -t mattbecker5/$1:latest .
docker run --rm --name $1 -it -p 8081:8081 -e PROJECT_NAME=$1 -e PROJECT_JAR=$jarFilePath mattbecker5/$1:latest