## Quarkus API Rest 

##### Sobre mim

- Quarkus rest API
- Openapi
- Schedule
- Panache mongo repository
- Loggin filter
- Tests
- Native image

##### Play no app

```bash
mvn quarkus:dev
```

##### Trabalhando com imagens
```bash
mvn package -Pnative -Dquarkus.native.container-build=true

docker build -f src/main/docker/Dockerfile.native -t quarkus-rest .

docker run -i --rm -p 8080:8080 quarkus-rest
```

##### Endpoint do swagger

```bash
http://localhost:8080/swagger
```
