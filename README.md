# Criando e testando containers Docker

## Criar rede docker para sistema hr
```
docker network create hr-net
	@@ -55,7 +27,7 @@ mvnw clean package
docker build -t hr-config-server:v1 .
docker run -p 8888:8888 --name hr-config-server --network hr-net -e GITHUB_USER=acenelio -e GITHUB_PASS= hr-config-server:v1
```

## hr-eureka-server
	@@ -71,7 +43,7 @@ mvnw clean package
docker build -t hr-eureka-server:v1 .
docker run -p 8761:8761 --name hr-eureka-server --network hr-net hr-eureka-server:v1
```

## hr-worker
	@@ -86,5 +58,94 @@ mvnw clean package -DskipTests
docker build -t hr-worker:v1 .
docker run -P --network hr-net hr-worker:v1
```

## hr-user
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-user-0.0.1-SNAPSHOT.jar hr-user.jar
ENTRYPOINT ["java","-jar","/hr-user.jar"]
``` 
```
mvnw clean package -DskipTests
docker build -t hr-user:v1 .
docker run -P --network hr-net hr-user:v1
```

## hr-payroll
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-payroll-0.0.1-SNAPSHOT.jar hr-payroll.jar
ENTRYPOINT ["java","-jar","/hr-payroll.jar"]
``` 
```
mvnw clean package -DskipTests
docker build -t hr-payroll:v1 .
docker run -P --network hr-net hr-payroll:v1
```

## hr-oauth
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-oauth-0.0.1-SNAPSHOT.jar hr-oauth.jar
ENTRYPOINT ["java","-jar","/hr-oauth.jar"]
``` 
```
mvnw clean package -DskipTests
docker build -t hr-oauth:v1 .
docker run -P --network hr-net hr-oauth:v1
```

## hr-api-gateway-zuul
```
FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/hr-api-gateway-zuul-0.0.1-SNAPSHOT.jar hr-api-gateway-zuul.jar
ENTRYPOINT ["java","-jar","/hr-api-gateway-zuul.jar"]
``` 
```
mvnw clean package -DskipTests
docker build -t hr-api-gateway-zuul:v1 .
docker run -p 8765:8765 --name hr-api-gateway-zuul --network hr-net hr-api-gateway-zuul:v1
```

## Alguns comandos Docker
Criar uma rede Docker
```
docker network create <nome-da-rede>
```
Baixar imagem do Dockerhub
```
docker pull <nome-da-imagem:tag>
```
Ver imagens
```
docker images
```
Criar/rodar um container de uma imagem
```
docker run -p <porta-externa>:<porta-interna> --name <nome-do-container> --network <nome-da-rede> <nome-da-imagem:tag> 
```
Listar containers
```
docker ps
docker ps -a
```
Acompanhar logs do container em execução
```
docker logs -f <container-id>