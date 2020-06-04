FROM postgres
ENV POSTGRES_DB testDB
ENV POSTGRES_USER testDB
ENV POSTGRES_PASSWORD testDB
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432
