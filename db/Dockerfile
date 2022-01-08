FROM mysql:latest

ENV MYSQL_DATABASE=sport_calendar \
    MYSQL_ROOT_PASSWORD=root

WORKDIR /usr/src/app

ADD schema.sql /docker-entrypoint-initdb.d
