# Spring Boot "Microserviço" Gestor de incidentes
Esse projeto tem a função de organizar e gerenciar novos incidentes.

# Como rodar

* Clone o repositório.
* JDK 19 e Maven 4.x
* Você pode construir o projeto e rodar todos os testes unitário usando o comando ```mvn clean package```
* Após o projeto ter sido construido com sucesso, você pode pressionar o comando ```shift + f10``` para rodar.

Com a aplicação rodando com sucesso, você deverá ver uma mensagem como essa:

```
2023-07-01 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2023-07-01 17:31:23.097  INFO 19387 --- [           main] com.khoubyari.example.Application        : Started Application in 22.285 seconds (JVM running for 23.032)
```
* Após a mensagem, navegue até a URL ```localhost:8080/swagger-ui.html``` onde todos os endpoints podem ser testados e apresentam correta anotação.
* Para o acesso e autorização de uso da aplicação, ela deve ser acessada através da role 'ADMIN' através dos dados: ```Usuário:diazero``` e ```Senha: security```, quaisquer outros logins não irão ter seu acesso autorizado.
## Sobre a aplicação 

* O serviço consiste em uma simples aplicação REST. Utilizando o banco de dados H2 para facilitar possíveis aplicações e avaliações. Porém pode ser aplicado em quaisquer outros banco de dados, alterando a file localizada em ./src/resource/application.proprerties .
* A fim de facilitar os testes de endpoint da aplicação, foi utilizado o SWAGGER, que deve ser acessado através do endpoint ```localhost:8080/swagger-ui.html```
* Para controle de acesso, foi utilizado o SpringSecurity, somente autorizando a interação com a aplicação através da role 'ADMIN' informada a cima.

Aqui estão listadas as funções contempladas pela aplicação:
(Todas as funcionalidades apresentam testes unitários dentro da pasta ```./src/test```)
* Cadastrar incidentes.
* Atualizar incidentes.
* Deletar incidentes.
* Listar todos os incidentes.
* Listar incidentes por ID.
* Listar os últimos 20 incidentes ordenados por ordem decrescente.

## ⚙ Tecnologias Utilizadas
* Spring
* Maven
* Swagger
* Spring Security
* jUnit
* Mockito 

# Quaisquer dúvidas ou questionamentos, me coloco a disposição : rafaelabres@gmail.com

