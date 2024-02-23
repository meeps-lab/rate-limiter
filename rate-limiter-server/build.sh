#!/bin/bash

./gradlew clean build
docker build -t rate-limiter . --build-arg host_addr="${1}"
docker run --name rate-limiter -d -p 8080:8080 rate-limiter
