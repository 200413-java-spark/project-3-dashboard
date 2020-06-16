FROM postgres
ENV POSTGRES_DB adatabase
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD noyce
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432
