# Sistema de Armazém com ORM e SQLite

## Objetivo

Desenvolver um sistema de gerenciamento de produtos de um armazém utilizando Java, ORMLite e SQLite, aplicando o padrão Repository e as operações CRUD.

## Tecnologias utilizadas

- Java
- BlueJ
- ORMLite
- SQLite
- JDBC

## Organização do projeto

- **Database:** gerencia a conexão com o banco de dados.
- **Produto:** representa os produtos do armazém e realiza o mapeamento para a tabela `produtos`.
- **ProdutoRepository:** implementa as operações de acesso aos dados.
- **TesteCRUD:** executa testes das operações CRUD.
- **Principal:** apresenta o menu de gerenciamento do armazém.

## Funcionalidades

### Create
Cadastra produtos com nome, categoria, preço e quantidade em estoque.

### Read
Permite consultar um produto pelo ID e listar todos os produtos cadastrados.

### Update
Atualiza os dados de um produto existente.

### Delete
Exclui um produto do banco de dados pelo ID.

## Persistência dos dados

O sistema utiliza o banco de dados SQLite, armazenado no arquivo `armazem.db`. Os registros permanecem salvos após o encerramento do programa.

## Testes

As operações CRUD devem ser testadas por meio da classe `TesteCRUD` e do menu da classe `Principal`. A persistência deve ser verificada encerrando e reiniciando o programa.

## Conclusão

O projeto demonstra a utilização de ORM para mapear objetos Java em tabelas de um banco de dados relacional. O padrão Repository centraliza as operações de persistência e facilita a organização do código.

## Referência

Tutorial de ORM disponibilizado pelo professor:

https://github.com/marceloakira/tutorials/blob/main/orm/README.md


<img width="1433" height="741" alt="Captura de tela 2026-10-27 162805" src="https://github.com/user-attachments/assets/9525f2ca-7106-4899-aa8c-91c9fc0d124d" />
<img width="903" height="532" alt="Captura de tela 2026-10-27 162814" src="https://github.com/user-attachments/assets/e7658684-c129-4b36-8c71-c088a6e92bd8" />
<img width="1438" height="727" alt="Captura de tela 2026-10-27 162748" src="https://github.com/user-attachments/assets/8eb7f2ab-a9f8-41b9-a792-53bd620dd6d4" />
