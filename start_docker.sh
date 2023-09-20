#!/bin/bash
pushd docker

docker rm -f $(docker ps -aq) 2>&1 /dev/null && docker-compose up -d db && docker-compose up -d

popd