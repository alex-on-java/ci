FROM nginx:1.16.0
ARG BACKEND_DOMAIN_VALUE
COPY nginx.conf /etc/nginx/nginx.conf
RUN sed -i "s/\${BACKEND_DOMAIN}/${BACKEND_DOMAIN_VALUE}/g" /etc/nginx/nginx.conf
RUN cat /etc/nginx/nginx.conf