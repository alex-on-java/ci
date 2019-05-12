FROM byrnedo/alpine-curl:0.1.7
WORKDIR /test
COPY test.sh /test/test.sh
ARG BACKEND_DOMAIN_VALUE
ENV BACKEND_DOMAIN=$BACKEND_DOMAIN_VALUE
ENTRYPOINT ["/bin/sh"]
CMD ["/test/test.sh"]