# L.O.R.A backend

Backend для игры  L.O.R.A.

## Table of Contents

- [Technology stack](#technology-stack)
- [Configuration](#configuration)
- [Usage](#usage)

## Technology stack

- Maven
- Java 1.8
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Liquibase

## Configuration

To set up a configuration you have to add values to Environment variables.

### Configuration Values

- `SPRING_DATASOURCE_URL` - Postgres database url
- `SPRING_DATASOURCE_USERNAME` - Postgres database username
- `SPRING_DATASOURCE_PASSWORD` - Postgres database password

## Usage

#### Run through Maven
```sh
./mvnw spring-boot:run
```

#### Run through Docker compose
```sh
docker compose build
docker compose up -f
```
