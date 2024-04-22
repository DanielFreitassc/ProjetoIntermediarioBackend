# Essa api consome outra api que fornece dados meteorológicos e com base nisso fornece uma mensagem personalizada para cada temperatura.
Path para consumo da api

![image](https://github.com/DanielFreitassc/ProjetoIntermediarioBackend/assets/129224303/d19432d2-5644-4d18-8d7c-995eee4d05a9)

# Cadastro de usuario para receber um mensagem personalizada
POST
```json
http://localhost:8080/usuario
```
> Body Parameters
```json
{
    "nome":"Fulano de Tal"
}
```
> Response (201 CREATED)
---
# Atualiza dados do usuario.
PUT
```json
http://localhost:8080/usuario/{id}
```
> Body Parameters
```json
{
    "nome":"Bertrano de Tal"
}
```
> Response (200 OK)
---
# Remover usuario
DELETE
```json
http://localhost:8080/usuario/{id}
```
> Response (204 NO CONTENT)
---
# Buscar a messagem personalizada
GET
```json
http://localhost:8080/tempo
```
> Response (200 OK)
> 
**Olá, Fulano de Tal! Temperatura atual: -0.1°C. Está muito frio lá fora. Vista-se com roupas quentes!**

---
# Busca o aluno e o tema da api
GET
```json
http://localhost:8080/ajuda
```
> Response (200 OK)
```json
{
    "nome": "Daniel Freitas",
    "projeto": "Serviço de meteorologia"
}
```
# Caso Queira ver a doc e usar o swagger para as requisições: [LINK](http://localhost:8080/swagger-ui/index.html#/)🚀

