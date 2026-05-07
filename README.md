# Gerenciador de Descontos API

API RESTful para gerenciamento de produtos com suporte a desconto global dinâmico.
Projeto desenvolvido para aprendizado de Spring Boot, aplicando boas práticas como arquitetura em camadas, DTOs, Bean Validation e tratamento global de exceções.

## Tecnologias

- Java 21
- Spring Boot 4.0.6
- Spring Data JPA
- PostgreSQL
- Lombok
- Bean Validation

## Como rodar localmente

### Pré-requisitos
- Java 21
- PostgreSQL instalado e rodando

### Passo a passo

1. Clone o repositório
2. Crie o banco de dados no PostgreSQL:
```sql
CREATE DATABASE gerenciador_descontos;
```
3. Crie um arquivo `.env` na raiz do projeto com suas credenciais:
```
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
```
4. Configure o `.env` nas variáveis de ambiente da sua IDE
5. Rode a classe `GerenciadorDescontosApiApplication`
6. A API estará disponível em `http://localhost:8080`

## Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/produtos` | Lista todos os produtos |
| GET | `/produtos/{id}` | Busca um produto por ID |
| GET | `/produtos/{id}/preco` | Retorna o preço final com desconto aplicado |
| POST | `/produtos/fisico` | Cadastra um produto físico |
| POST | `/produtos/digital` | Cadastra um produto digital |
| PATCH | `/produtos/desconto` | Atualiza o desconto global |

## Exemplos de uso

**Cadastrar produto físico**
```json
POST /produtos/fisico
{
    "nome": "Teclado",
    "precoBase": 150.00,
    "taxaFrete": 10.00
}
```

**Cadastrar produto digital**
```json
POST /produtos/digital
{
    "nome": "Curso de Java",
    "precoBase": 49.90
}
```

**Atualizar desconto global**
```json
PATCH /produtos/desconto
0.10
```

**Buscar preço final com desconto**
```json
GET /produtos/1/preco

{
    "nomeProduto": "Teclado",
    "precoFinal": 135.0
}
```