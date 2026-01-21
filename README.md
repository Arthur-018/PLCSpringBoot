# 📊 CBL Contabil - API de Plano de Contas

API REST desenvolvida em **Java** com **Spring Boot** para o gerenciamento de contas contábeis (Plano de Contas). O projeto segue uma arquitetura em camadas e utiliza boas práticas de desenvolvimento moderno.

## 🚀 Tecnologias Utilizadas

O projeto foi desenvolvido com as seguintes tecnologias e bibliotecas:

* **Java 21**: Linguagem de programação.
* **Spring Boot 3**: Framework principal.
* **Spring Data JPA**: Para persistência de dados e ORM.
* **H2 Database**: Banco de dados em memória (para desenvolvimento/testes).
* **Flyway**: Ferramenta de migração e versionamento de banco de dados.
* **Lombok**: Para redução de código boilerplate.
* **SpringDoc OpenAPI (Swagger)**: Para documentação viva da API.
* **Maven**: Gerenciamento de dependências e build.

## ⚙️ Configuração e Execução

### Pré-requisitos
* Java 21 instalado.
* Maven instalado (ou usar o wrapper `./mvnw` incluso).

### Variáveis de Ambiente
O arquivo `application.properties` utiliza variáveis de ambiente para conexão com o banco. Para rodar localmente, certifique-se de configurar as seguintes variáveis ou substituí-las por valores fixos no arquivo de propriedades:

* `DATABASE_URL` (Ex: `jdbc:h2:mem:testdb`)
* `DATABASE_USERNAME` (Ex: `sa`)
* `DATABASE_PASSWORD` (Ex: `password` ou vazio)

### Como rodar
1.  Clone o repositório:
    ```bash
    git clone [https://github.com/seu-usuario/PLCSpringBoot.git](https://github.com/seu-usuario/PLCSpringBoot.git)
    ```
2.  Acesse a pasta do projeto:
    ```bash
    cd PLCSpringBoot
    ```
3.  Execute o projeto via Maven:
    ```bash
    ./mvnw spring-boot:run
    ```

## 📚 Documentação da API (Swagger)

Com a aplicação rodando, você pode acessar a interface interativa do Swagger para testar os endpoints:

* **URL Local:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---


## 🔌 Endpoints

Abaixo estão os principais endpoints disponíveis no **PlanoDeContasController**, seguindo o padrão RESTful:

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `GET` | `/planodecontas/boasvindas` | Retorna uma mensagem de boas-vindas. |
| `POST` | `/planodecontas` | Cria uma nova conta contábil. |
| `GET` | `/planodecontas` | Lista todas as contas cadastradas. |
| `GET` | `/planodecontas/{codigo}` | Busca uma conta específica pelo seu código ID. |
| `PUT` | `/planodecontas/{codigo}` | Atualiza os dados de uma conta existente. |
| `DELETE` | `/planodecontas/{codigo}` | Remove uma conta pelo código. |

### Exemplo de JSON (Criação/Atualização)
Corpo da requisição (`PlanoDeContasDTO`):
```json
{
  "codigo": 101,
  "descricao": "Caixa",
  "tipo": "ATIVO",
  "aceitaLancamentos": true
}
```

## 🗂 Estrutura do Projeto
O projeto segue uma arquitetura em camadas (Monólito em Camadas):

Controller: Camada de entrada (REST), validação e resposta HTTP.

Service: Regras de negócio.

Repository: Acesso a dados (Spring Data JPA).

Model/Entity: Representação das tabelas do banco.

DTO (Data Transfer Object): Objeto para transporte de dados entre camadas.

Mapper: Conversão entre Entidade e DTO.

## 📦 Banco de Dados e Migrations
O projeto utiliza Flyway para gerenciar a evolução do esquema do banco de dados.

Os scripts SQL de migração ficam em: src/main/resources/db/migrations

O console do H2 pode ser acessado em: http://localhost:8080/h2-console (Certifique-se que a propriedade spring.h2.console.enabled está true).

