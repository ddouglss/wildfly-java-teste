
# Mini Agenda Java Web

Sistema web simples para gerenciar uma lista de pessoas (nome, idade etc), desenvolvido em Java com JSP, MySQL e WildFly (JBoss).

---

## Funcionalidades

- Cadastrar e listar pessoas
- Persistência de dados em banco MySQL via JDBC
- Interface web com JSP
- API REST simples para listar e adicionar pessoas em formato JSON

---

## Tecnologias utilizadas

- Java 8+
- Servlets e JSP
- JDBC para conexão com MySQL
- WildFly (JBoss) como servidor de aplicação
- Biblioteca Gson para JSON
- MySQL para banco de dados

---

## Estrutura do projeto

- `model/` — classes modelo (ex: `Pessoa`)
- `dao/` — classes de acesso a dados (ex: `PessoaDAO`)
- `servlet/` — servlets para controlar a aplicação (ex: `PessoaServlet`, API REST)
- `util/` — utilitários, como fábrica de conexão com banco
- `webapp/` — arquivos JSP, formulários e páginas públicas

---

## Pré-requisitos

- Java JDK 8 ou superior
- WildFly ou outro servidor de aplicação compatível com Java EE
- MySQL instalado e rodando localmente (ou via container)
- Biblioteca MySQL Connector/J adicionada ao classpath do projeto

---

## Configuração do banco de dados

1. Criar banco `minha_agenda` no MySQL:

```sql
CREATE DATABASE minha_agenda;
USE minha_agenda;

CREATE TABLE pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL
);
```

2. Ajustar credenciais no arquivo `util/ConnectionFactory.java`:

```java
String url = "jdbc:mysql://localhost:3306/minha_agenda";
String user = "root";
String password = "sua_senha";
```

---

## Como executar

1. Importar o projeto em sua IDE (Eclipse, IntelliJ etc)
2. Configurar o WildFly e adicionar o projeto como aplicação web
3. Rodar o servidor WildFly
4. Acessar:

- Formulário para cadastro: `http://localhost:8080/seu-contexto/cadastrar.jsp`
- Lista de pessoas: `http://localhost:8080/seu-contexto/pessoas`
- API REST: `http://localhost:8080/seu-contexto/api/pessoas`

---

## API REST (exemplo básico)

- **GET** `/api/pessoas` — lista todas pessoas em JSON
- **POST** `/api/pessoas` — adiciona pessoa, enviando JSON:

```json
{
  "nome": "Maria",
  "idade": 30
}
```

---

## Melhorias futuras

- Autenticação de usuários  
- Validação avançada dos dados no backend  
- Frontend com frameworks modernos (Angular, React)  
- Testes automatizados  
- Deploy em nuvem  

---

## Contato

Se quiser trocar ideias ou colaborar, me envie uma mensagem!
Douglas Souza
