Clonar a aplicação no GIT

Utilizar o PostgresSql

Executar o script "Create_Database.sql" no PostgresSql no que se encontra no resources/db

No arquivo application.properties o username e o password estão:

spring.datasource.username=postgres
spring.datasource.password=postgres

Caso a instancia no postgress tenha sido criado com usuario ou senha diferentes, favor alterar para o funcionamento da aplicação.

Na pasta base do projeto, utilizar o comando ./mvnw spring-boot:run no Windows, ou mvn spring-boot:run no linux para rodar a aplicação

Assim que a aplicação é iniciada o hibernate recria as tabelas, e tem um loader para a criação dos dados basicos.

Com a aplicação iniciada, é possivel acessar a documentação do Swagger no endereço http://localhost:8080/api/swagger-ui.html
