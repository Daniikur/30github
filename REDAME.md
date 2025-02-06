# Demo Spring Boot Application

This is a simple demo Spring Boot application connected to a PostgreSQL database.

## Prerequisites

- **Java 17+** (or any other compatible version)
- **PostgreSQL** installed and running
- **Maven** for building the project

## Setup PostgreSQL

1. Install PostgreSQL and create a database and user:

```sql
CREATE DATABASE demo_db;
CREATE USER demo_user WITH ENCRYPTED PASSWORD 'demo_password';
GRANT ALL PRIVILEGES ON DATABASE demo_db TO demo_user;
