# [Bookshifter](https://github.com/Bookshifter/Bookshifter)

<br>

> ##### Este é um projeto que fiz no terceiro semestre da faculdade. Estou subindo o repositório no meu Github também, mas todos os links dos READMEs estão direcionados para o Github do projeto.

<br>

A aplicação [frontend](https://github.com/Bookshifter/Bookshifter/tree/main/frontend) está configurada para inicializar na porta <b>3000</b>.
<br>

- Caso queira alterar estas configurações, no frontend, altere a porta no arquivo [package.json](frontend/package.json), na seguinte linha:
  
  ```
  "serve": "vue-cli-service serve --host localhost --port <porta desejada>"
  ```
<br>

A aplicação [backend](https://github.com/Bookshifter/Bookshifter/tree/main/backend) está configurada para inicializar na porta <b>8080</b>.
<br>

- Caso queira alterar, altere a porta no arquivo [application.properties](backend/src/main/resources/application.properties), na seguinte linha:

```
server.port=<porta desejada>
```

Lembre-se: caso haja alteração em alguma dessas portas, você terá que alterar todas as linhas onde essas portas estão sendo referenciadas, de ambos os projetos.

#### As duas aplicações devem ser inicializadas em conjunto!
___

## Instruções - Frontend

<br>

### Instalando o Vue.js (Windows)

```
> npm install -g @vue/cli
```

### Instalando dependências do projeto
```
> npm install
```

### Para inicializar a aplicação
```
> npm run serve
```


### Para build de produção
```
> npm run build
```
<br>

___

## Instruções - Backend

<br>

### Dependências a serem instaladas

- [JDK 20](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)
- [Maven](https://maven.apache.org/download.cgi)
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) (Opcional, para aqueles que não gostam de mexer no shell)

### Importante

- Mude as configurações do [application.properties](backend/src/main/resources/application.properties) para seu login do MySQL nas seguintes linhas:
```
spring.datasource.username=<seu usuário/root>
spring.datasource.password=<sua senha>
```
- Crie uma base de dados no MySQL chamada 'books', para isto utilize o comando:

```
mysql> CREATE DATABASE books;
```
