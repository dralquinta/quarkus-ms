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
- `k8s/oke/secret.yaml`
- `k8s/oke/deployment.yaml`
- `k8s/oke/service.yaml`
- `k8s/oke/ingress.yaml`

Apply them in order:

```bash
kubectl apply -f k8s/oke/namespace.yaml
kubectl apply -f k8s/oke/configmap.yaml
# Edit k8s/oke/secret.yaml with your real credentials before applying it.
kubectl apply -f k8s/oke/secret.yaml
kubectl apply -f k8s/oke/deployment.yaml
kubectl apply -f k8s/oke/service.yaml
kubectl apply -f k8s/oke/ingress.yaml
```

Do not commit real secret values to version control.
Update the ingress host in `k8s/oke/ingress.yaml` to your DNS name.
Update the image tag in `k8s/oke/deployment.yaml` to your released container version before production rollout.
