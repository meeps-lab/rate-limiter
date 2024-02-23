#!/bin/bash

./gradlew clean build
docker build -t test-api .
docker run --name test-api -d -p 8090:8090 test-api
