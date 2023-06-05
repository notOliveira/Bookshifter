# Backend do Projeto Bookshifter

<br>

### Esta aplicação deve ser inicializada junto com o [frontend](https://github.com/Bookshifter/Bookshifter/tree/main/frontend).
- Aplicação rodando por padrão na porta 8080. Caso queira alterar, altere a porta no arquivo [application.properties](/src/main/resources/application.properties), na seguinte linha:
```
server.port=<porta desejada>
```
- Importante lembrar que, caso haja alteração na porta do servidor, altere também os arquivos onde há fetchs das APIs no [frontend](https://github.com/Bookshifter/Bookshifter/tree/main/frontend), para que não haja erros durante a execução das aplicações.
<br>

### Dependências

- [JDK-20](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) (Opcional, para aqueles que não gostam de mexer no shell)
<br>

### Importante

- Mudar as configurações do [application.properties](/src/main/resources/application.properties) para seu login do MySQL nas seguintes linhas:
```
spring.datasource.username=<seu usuário/root>
spring.datasource.password=<sua senha>
```
- Crie uma base de dados no MySQL chamada 'books', para isto utilize o comando:

```
mysql> CREATE DATABASE books;
```
