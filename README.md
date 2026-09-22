# DevShowcase API

API REST para uma plataforma de portfólio de desenvolvedores.

## Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven
- Bean Validation

## Relacionamentos

- Profile 1:N Project
- Project N:N Technology
- Project 1:N Feedback

## Como executar

1. Crie um banco PostgreSQL:

```sql
CREATE DATABASE devshowcase;
```

2. Confira usuário e senha em `src/main/resources/application.properties`.

3. Execute:

```bash
mvn spring-boot:run
```

A API ficará em:

`http://localhost:8080`

## Endpoints

### Profiles

POST `/api/profiles`

```json
{
  "name": "Maria Silva",
  "email": "maria@email.com",
  "bio": "Desenvolvedora Java e Spring Boot"
}
```

GET `/api/profiles/1`

### Technologies

POST `/api/technologies`

```json
{
  "name": "Java"
}
```

GET `/api/technologies`

### Projects

POST `/api/projects`

```json
{
  "title": "Sistema de Biblioteca",
  "description": "API para gerenciamento de livros e usuários.",
  "repositoryUrl": "https://github.com/exemplo/biblioteca",
  "deployUrl": "https://biblioteca.exemplo.com",
  "profileId": 1,
  "technologyIds": [1]
}
```

GET `/api/projects`

### Feedbacks

POST `/api/projects/{projectId}/feedbacks`

```json
{
  "comment": "Projeto muito bom!",
  "rating": 5,
  "projectId": 1
}
```

GET `/api/projects/{projectId}/feedbacks`

A avaliação deve estar entre 1 e 5.

A média das avaliações é calculada automaticamente e retornada no campo `averageRating` do projeto.


## Observação

Os IDs usados nos exemplos são criados conforme os registros inseridos no banco.
