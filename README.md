# Hibernate 5 CRUD

## Setup

In [`persistence.xml`](./src/main/resources/persistence.xml), update the following:

- Database username and password.

Also, connect to your local MySQL server and execute [`schema.sql`](./sql/schema.sql) to create the database.

## Build and run

After doing the setup, execute:

If you are in Windows using CMD:

```text
gradlew.bat shadowJar && java -jar build\libs\hibernate-5-crud-1.0.0-SNAPSHOT-all.jar
```

If you are in Linux or macOS (or using GitBash in Windows):

```text
./gradlew shadowJar && java -jar build/libs/*-all.jar
```