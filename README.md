## FrontEnd
# Tecnologias utilizadas:
Angula version 19.2.6.


1- Iniciando o front-end
   npm run start 
   Browser: http://localhost:4200/


Usando in-memory-web-api para simular mock da apis.

2- Para roda a cobertura de testes com Jasmine e Karma.
   ng test --code-coverage
   Projeto com 100% de cobertura de testes.



# BackEnd
# Tecnologias utilizadas:
Java 17
Spring 3.4.4
Postgres 15

Passos para iniciar o projeto:
1- Iniciar o container docker para criar o banco e rodas o script
   -Acessar o diretório:
    consulta-credito/consulta-credito-api/src/main/resources/docker

   -Executar o comando abaixo:
    docker-compose up -d

2- Após subir o container, iniciar o spring localmente atraves da classe CreditoApplication.

Apis rest para consumo do front:
 http://localhost:4200/api/creditos/1122334
 http://localhost:4200/api/creditos/credito/654321
