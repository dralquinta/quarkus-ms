# quarkus-ms

Quarkus microservice PoC with:

- `GET /api/v1/something`
- PostgreSQL datasource wiring (configurable with environment variables)
- Mock repository implementation to avoid requiring a live DB in this stage
- OpenAPI + Swagger UI (`/q/openapi`, `/swagger-ui`)
- Kubernetes deployment target configuration
- ARM64 container image buildx target (`linux/arm64`)

## Run

```bash
./mvnw quarkus:dev
```
