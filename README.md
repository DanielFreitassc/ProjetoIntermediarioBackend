# Essa api consome outra api que fornece dados meteorológicos e com base nisso fornece uma mensagem personalizada para cada temperatura.
Path para consumo da api

# Cadastro de usuario para receber um mensagem personalizada
POST
```
http://localhost:8080/usuario
```
```
{
    "nome":"nome sobrenome"
}
```
# Atualiza dados do usuario.
PUT
```
http://localhost:8080/usuario/1
```
```
{
    "nome":"nome sobrenome atualizado"
}
```
# Buscar a messagem personalizada
GET
```
http://localhost:8080/tempo
```
# Busca o aluno e o tema da api
GET
```
http://localhost:8080/ajuda
```
