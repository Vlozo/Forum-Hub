# Forum-Hub
## Descrição
Esse projeto foi desenvolvido para o desafio do curso de Spring Boot da Alura, é uma API REST que utiliza um sistema de autenticação stateless 
e permite o usuário através dos endpoints: ler, cadastrar, alterar e deletar tópicos. A API ainda está em desenvolvimento e em sua
versão final contará também com CRUD completo para respostas, cursos e usuários.

## Funcionalidades
- **Cadastro de usuários**: Usuários podem se cadastrar, e devem fazer login para criar e gerenciar os tópicos.
- **Autenticação e Segurança**: A autenticação é feita através do Spring Security e utiliza Token JWT para autorização aos Endpoints.
- **CRUD de Tópicos**: Usuários podem criar, ler, editar e deletar tópicos com a restrição de que o usuário só pode deletar e editar tópicos
que ele mesmo criou.
- **CRUD de Respostas**: (Em desenvolvimento)

## Tecnologias Utilizadas
- Java 17
- Maven
- Java Spring Boot 3
- JPA (Java Persistence API)
- MySQL
- JSON Web Tokens

## Como utilizar?

1. Certifique-se de ter o Java 17 instalado em seu sistema.
2. Certifique-se de ter o Maven instalado.
3. Certifique-se de ter o MySQL em seu sistema.
4. Clone este repositório.
```bash
git clone https://github.com/Vlozo/Forum-Hub.git
```
4. Configurando o Banco de Dados
    - Por padrão o projeto tentará criar o banco de dados no seu sistema com o nome de `forum_hub`. 
    - Garanta que as variáveis de ambiente `MySQL_USER` e `MySQL_PSWD` endereçadas em `src/main/resources/application.properties` estejam de acordo com suas credenciais do MySQL,
 caso o Spring não ache a variavel contendo as credenciais ele tentará logar no banco de dados com um usuário root padrão sem senha.
5. Configurando o Token de Segurança
   - Adicione as suas variaveis de ambiente uma variavel chamada `JWT_SECRET` contendo uma chave/segredo que será utilizado pela API para criptografar
o token de autorização.
   - Esta variável esta endereçada em `src/main/resources/application.properties` com o nome de `api.security.token.secret`.
6. Se for feito corretamente é só executar o pela sua IDE favorita.


