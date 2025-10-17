# 💻 TesteVendas: Backend de Vendas (Spring Boot)

Este projeto implementa um serviço de backend para um sistema de vendas, utilizando Spring Boot, Spring Data JPA e um banco de dados H2. O objetivo é demonstrar a modelagem de dados relacional e a configuração de um ambiente de desenvolvimento.

## 🎯 Desafio

Desenvolver uma API REST com dois serviços principais:
1.  Criar uma nova venda (POST).
2.  Retornar métricas de vendas por vendedor (Total vendido e Média diária) em um período específico (GET).

## 📊 Modelagem do Banco de Dados (H2)

O banco de dados foi modelado seguindo o padrão Header/Detail (4 tabelas) para garantir a integridade transacional:
- **VENDEDOR**
- **PRODUTO**
- **VENDA** (Transação mestre: id, data, vendedor_id, valor_total_venda)
- **ITEM_VENDA** (Detalhe da transação: venda_id, produto_id, quantidade, preco_venda)

O script `src/main/resources/data.sql` é executado automaticamente na inicialização do Spring Boot, criando todas as tabelas e inserindo dados de teste.

## ⚙️ Como Rodar o Projeto

1. **Pré-requisitos:** Certifique-se de ter o Java (JDK) instalado.
2. **Clonar o Repositório:** O repositório já está clonado.
3. **Executar:** Abra o projeto no IntelliJ e rode a classe `VendasApplication.java`.
4. **Acessar o H2 Console (Opcional):**
   Com a aplicação rodando, acesse: `http://localhost:8080/h2-console`
    - **JDBC URL:** `jdbc:h2:mem:vendasdb;DB_CLOSE_DELAY=-1`
    - **User:** `ingridfti` 