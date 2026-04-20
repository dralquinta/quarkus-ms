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

## OKE deployment manifests

Kubernetes manifests for Oracle Kubernetes Engine (OKE) are available in:

- `k8s/oke/namespace.yaml`
- `k8s/oke/configmap.yaml`
- `k8s/oke/deployment.yaml`
- `k8s/oke/service.yaml`
- `k8s/oke/ingress.yaml`

Apply them in order:

```bash
kubectl apply -f k8s/oke/namespace.yaml
kubectl apply -f k8s/oke/configmap.yaml
kubectl -n quarkus-ms create secret generic quarkus-ms-secrets \
  --from-literal=DB_USERNAME='quarkus' \
  --from-literal=DB_PASSWORD='<your-db-password>'
kubectl apply -f k8s/oke/deployment.yaml
kubectl apply -f k8s/oke/service.yaml
kubectl apply -f k8s/oke/ingress.yaml
```

Update the ingress host in `k8s/oke/ingress.yaml` to your DNS name.
