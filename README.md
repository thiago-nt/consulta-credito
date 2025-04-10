# 📊 Consulta de Créditos - Full Stack com Angular + Spring Boot + PostgreSQL + Kafka

Projeto full stack para consulta de créditos constituídos, utilizando Angular no front-end e Spring Boot no back-end, com comunicação assíncrona via Apache Kafka e persistência em PostgreSQL.

---

## 🐳 Subindo a stack completa com Docker Compose
### Passos para executar:

1. Acesse a raiz do projeto `consulta-credito` e execute:
   docker-compose up -d

# Acesse o front-end em:
 http://localhost:4200/

 Massa de testes:
 7891011
 1122334

✅ Containers esperados:
consulta-credito-frontend-1
consulta-credito-backend-1
consulta-credito-kafka-1
consulta-credito-db-1
consulta-credito-zookeeper-1

🛠️ Banco de Dados
URL: jdbc:postgresql://db:5432/credito_db
Usuário: postgres
Senha: root

💻 Front-end
Tecnologias utilizadas:
Angular 19.2.6
Express 4.17.17
Jasmine 5.1.0

#Subindo localmente:
 npm install
 npm run start

# Acesse via navegador:
 http://localhost:4200/


# Back-end
Tecnologias utilizadas:
Java 17
Spring Boot 3.4.4
Spring Data JPA
Lombok
Spring Kafka 3.1.3
PostgreSQL 15
Mockito para testes unitários

# Subindo localmente:
 Inicie o container do banco:
 cd consulta-credito/consulta-credito-api/src/main/resources/docker
 docker-compose up -d
 Em seguida, rode a aplicação localmente pela classe CreditoApplication.

# Endpoints disponíveis:
GET http://localhost:8080/api/v1/creditos/1122334
GET http://localhost:8080/api/v1/creditos/credito/654321


📂 Estrutura do projeto
consulta-credito/
├── consulta-credito-api/        # Back-end Spring Boot
├── consulta-credito-frontend/   # Front-end Angular
├── docker-compose.yml           # Orquestração dos serviços


🧪 Testes
Back-end: Testes unitários utilizando JUnit e Mockito
Front-end: Testes com Jasmine e Karma