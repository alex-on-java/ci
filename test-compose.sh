#!/usr/bin/env bash
DOMAIN=${1?Ops. Argument missing. Please provide the full domain that should be checked}
docker network create lb_main-net
docker-compose up -d
sleep 30
FIRST_LINE=$(curl -I -X GET http://$DOMAIN:1080/health | head -n 1)
IS_NOT_200_OK=$(echo ${FIRST_LINE} | grep 200)
if [ -z "$IS_NOT_200_OK" ]
then
    echo "service is not accessible"
    echo ${FIRST_LINE}
    echo "exiting"
    exit 1
else
    exit 0
fi