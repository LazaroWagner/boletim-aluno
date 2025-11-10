# boletim-aluno — Desafio técnico Fullstack

Este projeto é um MVP para lançamento de notas escolares com cálculo de média ponderada.

---

## Tecnologias

### Backend
- Spring Boot 3
- Java 17
- H2 Database (pode ser adaptado para PostgreSQL)
- Spring Data JPA
- Bean Validation

### Frontend
- Angular 16
- Angular Material
- TypeScript
- RxJS

---

## Estrutura de Pastas

- `backend/boletim-api: API REST com endpoints para alunos, avaliações e notas
- `frontend/boletim-web: Interface web para lançamento de notas

## Como Executar

### Backend

1. Navegue até a pasta `backend/boletim-api`
2. Execute o projeto com sua IDE ou terminal:

```bash
./mvnw spring-boot:run
ou 
./runapp.sh

### A API estará disponível em http://localhost:8080


### Frontend

- Navegue até a pasta frontend/boletim-web
- Instale as dependências:

'
    npm install
'

- Rode o servidor Angular:
'
    ng serve

'

## Estrutura de Pastas

- Listagem de alunos, turmas, disciplinas, avaliações e notas
- Cadastro, edição e exclusão de registros
- Cálculo de médias por aluno, turma e disciplina
- Consumo de API REST com Angular Services

## Observações
- Os componentes estão organizados por entidade para facilitar manutenção
- Os serviços Angular estão tipados com interfaces baseadas nos DTOs do backend
- O projeto segue boas práticas de arquitetura e separação de responsabilidades


