# Essa api consome outra api que fornece dados meteorológicos e com base nisso fornece uma mensagem personalizada para cada temperatura.
Path para consumo da api

![image](https://github.com/DanielFreitassc/ProjetoIntermediarioBackend/assets/129224303/d19432d2-5644-4d18-8d7c-995eee4d05a9)

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
http://localhost:8080/usuario/{id}
```
```
{
    "nome":"nome sobrenome atualizado"
}
```
# Remover usuario
DELETE
```
http://localhost:8080/usuario/{id}
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
# Caso Queira ver a doc e usar o swagger para as requisições: [LINK](http://localhost:8080/swagger-ui/index.html#/)🚀

