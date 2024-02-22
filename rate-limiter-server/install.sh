#!/bin/bash

docker build -t rate-limiter .
docker run -p 8080:8080 rate-limiter
