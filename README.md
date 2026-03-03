# mymonty Business Dashboard (Angular + Spring Boot + Liquibase)

This repository contains a complete starter implementation with:
- **Frontend**: Angular 17 + `ng-apexcharts`
- **Backend**: Spring Boot 3 (Java 21), layered architecture (controller/service/serviceImpl/repository/entity/enum/exception/mapper)
- **Database**: SQL Server + Liquibase migrations and seed data

## Project structure

- `frontend/` Angular app
- `backend/` Spring Boot API + Liquibase changelogs

---

## 1) Run SQL Server in Docker (if not already running)

```bash
docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=YourStrong@Passw0rd" \
  -p 1433:1433 --name sqlserver-mymonty -d mcr.microsoft.com/mssql/server:2022-latest
```

Create database:

```sql
CREATE DATABASE mymonty_business;
```

You can run this SQL from **SSMS** after connecting to your Docker SQL Server instance.

---

## 2) Connect from SSMS to Docker SQL Server

In SSMS:
1. Open **Connect > Database Engine**.
2. Server name: `localhost,1433` (or your host IP + published port).
3. Authentication: **SQL Server Authentication**.
4. Login: `sa`.
5. Password: `YourStrong@Passw0rd` (or your custom one).
6. Click Connect.

If connection fails:
- Verify container is running: `docker ps`
- Verify port mapping: should include `0.0.0.0:1433->1433/tcp`
- Verify password policy (SQL Server requires strong password)

---

## 3) Backend configuration (Spring Boot)

`backend/src/main/resources/application.yml` already supports env vars:
- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`

Default URL:

```text
jdbc:sqlserver://localhost:1433;databaseName=mymonty_business;encrypt=true;trustServerCertificate=true
```

Run backend:

```bash
cd backend
./mvnw spring-boot:run
```

Or using installed Maven:

```bash
cd backend
mvn spring-boot:run
```

On startup, Liquibase auto-runs and creates/seeds tables.

> On startup, the backend now automatically creates the configured SQL Server database (from `spring.datasource.url` `databaseName=...`) if it does not exist and if the login has permissions.


---

## 4) Frontend configuration (Angular)

API URL is in:
- `frontend/src/environments/environment.ts`

Default:

```ts
apiBaseUrl: 'http://localhost:8080/api'
```

Run frontend:

```bash
cd frontend
npm install
npm start
```

App runs on `http://localhost:4200`.

---

## 5) API endpoints

- `GET /api/dashboard` → complete dashboard payload
- `PATCH /api/transfers/{id}/status` with body `{ "status": "ACCEPTED" }` / `REJECTED` etc.

---

## 6) Best-practice notes included

- DTO layer for API contracts
- Mapper component to separate entity-to-DTO conversion
- Service interfaces + `impl` classes
- Global exception handling
- Enum-safe domain fields
- Liquibase versioned migrations with seed dataset
- Frontend componentized by layout/pages/components/services/models
- ApexCharts for dynamic graphs fed by API data
