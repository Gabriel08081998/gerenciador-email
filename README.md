# Gerenciamento Email

Este é um projeto Java desenvolvido para criar um sistema de gerenciamento de e-mails, onde os usuários podem enviar, receber, visualizar e excluir e-mails. O projeto utiliza o framework Spring Boot e um banco de dados H2 em memória para armazenar dados temporários.

# Funcionalidades Principais:

**Consultar Todos os E-mails**:
Endpoint: GET /email
Descrição: Retorna uma lista de todos os e-mails no sistema.

**Consultar E-mail por ID**:
Endpoint: GET /email/{id}
Descrição: Retorna um e-mail específico com base no ID fornecido.

**Consultar E-mails Enviados por um Usuário**:
Endpoint: GET /email/{email}
Descrição: Retorna uma lista de e-mails enviados por um remetente específico.

**Enviar E-mail**:
Endpoint: POST /email
Descrição: Permite aos usuários enviar um novo e-mail. Os detalhes do e-mail são fornecidos no corpo da solicitação.

**Excluir E-mail por ID**:
Endpoint: DELETE /email/{id}
Descrição: Exclui um e-mail específico com base no ID fornecido.

**Consultar Todos os Usuários**:
Endpoint: GET /usuario
Descrição: Retorna uma lista de todos os usuários registrados no sistema.

**Consultar Usuário por ID**:
Endpoint: GET /usuario/{id}
Descrição: Retorna um usuário específico com base no ID fornecido.

**Consultar E-mails Enviados por um Usuário**:
Endpoint: GET /usuario/emails/enviados/{id}
Descrição: Retorna uma lista de e-mails enviados por um usuário específico.

**Consultar E-mails Recebidos por um Usuário**:
Endpoint: GET /usuario/emails/recebidos/{id}
Descrição: Retorna uma lista de e-mails recebidos por um usuário específico.

**Cadastrar Novo Usuário**:
Endpoint: POST /usuario
Descrição: Permite aos usuários criar um novo perfil. Os detalhes do usuário são fornecidos no corpo da solicitação.

**Editar Usuário Existente**:
Endpoint: PUT /usuario/{id}

Descrição: Permite aos usuários editar suas informações de perfil. Os detalhes atualizados são fornecidos no corpo da solicitação.

**Excluir Usuário por ID**:
Endpoint: DELETE /usuario/{id}

Descrição: Exclui um usuário específico com base no ID fornecido.

# Tecnologias Utilizadas:

**Linguagem utilizada**: Java

**Spring Boot**: Framework Java utilizado para construir aplicativos robustos e escaláveis.

**H2 Database**: Banco de dados em memória utilizado para armazenar temporariamente dados da aplicação.

**Validação de Dados**:
Utilização de validação de dados com anotações para garantir a integridade dos dados.

**DTO (Data Transfer Object)**: Utilização de objetos DTO para transferência eficiente de dados entre a camada de controle e serviço.

**Spring Data JPA**: Facilita a interação com o banco de dados por meio de interfaces de repositório.

**Lombok**: Biblioteca Java que simplifica o desenvolvimento eliminando a necessidade de escrever métodos getters, setters e outros métodos comuns.

# Exceção 

E realizado o tratamento de exceção ao realizar consulta do usuario por id. Os endpoints que tem esse tratamento são :

* consultar usuario por id
* consultar emails recebidos 
* consultar emails enviados


 # Executando o Projeto Localmente:
Para executar o projeto localmente, siga estas etapas:

Clone este repositório em sua máquina local.
Abra o projeto em sua IDE Java favorita.
Certifique-se de ter o Java e o Maven instalados em seu sistema.
Configure o arquivo application.properties com suas configurações de banco de dados, se necessário.
Execute o aplicativo Spring Boot. Você pode fazer isso usando a IDE ou executando mvn spring-boot:run no terminal na pasta raiz do projeto.
O aplicativo estará acessível em http://127.0.0.1:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/.

# Diagrama de classe

Usuario
-------------------------------------
- id: long
- nome: String
- email: String
- senha: String
-------------------------------------
+ getters/setters
-------------------------------------

Email
-------------------------------------
- id: long
- remetente: String
- destino: String
- assunto: String
- corpoEmail: String
- dataRecebimento: LocalDateTime
-------------------------------------
+ getters/setters
-------------------------------------


# Melhorias  

Realizar tratamentos de exceções em todos os metodos que realizam consulta por id.