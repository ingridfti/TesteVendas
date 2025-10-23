Teste Prático de Programação Backend: Sistema de Gerenciamento de Vendas

Objetivo do Projeto
Desenvolver uma API REST em Spring Boot capaz de registrar transações de vendas e gerar um relatório agregado de desempenho dos vendedores por período.

Tecnologias Utilizadas
Linguagem: Java
Framework: Spring Boot (Web, Data JPA)
Banco de Dados: H2 Database (Em memória)
Migration: Flyway
Ferramentas: Lombok, Maven

Como Executar o Projeto:

1- Clone o Repositório
2- Compilação: Execute o comando Maven: mvn clean install
3- Execução: Inicie a aplicação Spring Boot através de um dos seguintes métodos:
    - Via IDE: Execute a classe principal VendasApplication.java.
    - Via Maven: mvn spring-boot:run

Instruções de Teste (Postman)
A aplicação está rodando na porta 8080

Método  |            Caminho/URL         |               Função             | DTO/Ação Necessária
POST    |/api/vendas                     | CRIAR VENDA (Registra transação) | Enviar vendedorId e itens no Body.
POST    |/vendedores/relatorio/quantidade| RELATÓRIO DE QUANTIDADE          | Enviar dataInicio e dataFim no Body (JSON).
POST    |/vendedores/relatorio           |RELATÓRIO DE VALOR (soma total)   | Enviar dataInicio e dataFim no Body (JSON).
GET     |/api/vendas                     |Buscar vendas por período (data)  | Usar Query Params.
GET     |/api/vendas/{id}                | Buscar venda por ID              | Usar o ID na URL.