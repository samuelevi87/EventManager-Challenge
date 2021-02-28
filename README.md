# EventManager-Challenge
Selection Challenge

# Desafio do Gerenciador de Eventos
## Sobre o projeto

Este projeto foi criado como requisito avaliativo de um processo seletivo.

### Tecnologias empregadas no projeto

- Java SE 11 (LTS);
- Spring Boot Framework v.2.4.3;
- Banco de Dados h2 *(Em memória, para testes e com persistência para desenvolvimento)*. (https://h2database.com/html/main.html);
- Projeto criado com o Spring Initializr (https://start.spring.io/);
- Desenvolvido com SpringToolSuite4 e IntelliJ IDEA Community;
- Postman v8.0 - Para teste dos endpoints criados;
- JPA/Hibernate para implementar o conceito de mapeamento objeto-relacional (ORM);
- Maven como gerenciador de dependências;
- GitHub para versionamento do código;
- Separação em camadas de Service, Repository e Controller;
- Organização de arquivos do projeto seguindo o padrão Feature Folders Structure.

### Requisitos para uso
- Uma IDE de sua preferência.
- Alguma ferramenta de teste de API's, como Postman ou Imsomnia

## O Desafio

Criar um sistema para gerenciar um treinamento que será realizado em 2 etapas e as pessoas serão divididas em salas com lotação variável. Serão realizados também dois intervalos de café em 2 espaços distintos. O sistema precisa permitir:

- O cadastro de pessoas, com **nome** e **sobrenome**;
- O cadastro das salas do evento, com **nome** e **lotação**;
- O cadastro dos espaços de café pelo **nome**;

A diferença de pessoas em cada sala deverá ser de no **máximo 1 pessoa**. Para estimular a troca de conhecimentos, metade das pessoas precisam trocar de sala entre as duas etapas do treinamento.
Ao consultar uma pessoa cadastrada no treinamento, o sistema deverá retornar à sala em que a pessoa ficará em cada etapa e o espaço onde ela realizará cada intervalo de café.
Ao consultar uma sala cadastrada ou um espaço de café, o sistema deverá retornar uma lista das pessoas que estarão naquela sala ou espaço em cada etapa do evento.

## Padrão de Camadas e Fluxo de requisição e resposta

![Spring Data JPA - Guide](https://s3.amazonaws.com/stackabuse/media/guide-spring-data-jpa-2.png)
## Documentação da API
[Challenge Collection - Postman](https://documenter.getpostman.com/view/12402887/TWDdiDTv)
