* docker run -d --name article-db -p 5432:5432 -e POSTGRES_DB=article -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password postgres:16.4
* docker run -d --name vay-keycloak -p 9080:9080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -v ./config/keycloak/import:/opt/keycloak/data quay.io/keycloak/keycloak:25.0.5 start-dev --import-realm
* docker run -d --name feedback-db -p 27017:27017 mongo:7