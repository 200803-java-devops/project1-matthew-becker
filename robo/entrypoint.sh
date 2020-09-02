#!/bin/bash

export PORT=8081
echo starting server on port $PORT
cd /usr/share/robotap/
java -jar /usr/share/robotap/target/robo-1.0.1.jar
