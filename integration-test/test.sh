#!/bin/sh
NUMBER_OF_ATTEMPTS=20
INTERVAL_BETWEEN_ATTEMPTS=3
i=1;
while [ $i -le $NUMBER_OF_ATTEMPTS ]; do
    i=$((i+1));
    FIRST_LINE=$(curl -I -X GET -m 1 -H "Host: $BACKEND_DOMAIN" http://sample-load-balancer:80/health | tac | tac | head -n 1)
    IS_NOT_200_OK=$(echo ${FIRST_LINE} | grep 200)
    if [ -z "$IS_NOT_200_OK" ]
    then
        echo "sleeping"
        sleep ${INTERVAL_BETWEEN_ATTEMPTS}
    else
        exit 0
    fi
done
TOTAL_WAIT_TIME=$(( NUMBER_OF_ATTEMPTS*INTERVAL_BETWEEN_ATTEMPTS ))
echo "failed reaching the service for $TOTAL_WAIT_TIME seconds"
exit 1