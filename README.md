# Prog3Trab3

Trabalho realizado na disciplina Programação III (trabalho 3).<br>
Implementação de um protótipo para exemplificar um backend com API restful e autenticação OAuth2.

# Build e Run
```java
mvn clean install spring-boot:run
```
# Get em uma rota pública
```sh
curl -i http://localhost:9191/api/hello

Hello User!
```
# Get em uma rota segura sem autenticação
```sh
curl -i http://localhost:9191/api/secure

{"timestamp":1444985908768,"status":401,"error":"Unauthorized","message":"Access Denied","path":"/api/secure"}
```

# Obtendo token de autenticação
```sh
curl -vu teste:123 'http://localhost:9191/api/oauth/token?username=admin&password=admin&grant_type=password'

{"access_token":"91202244-431f-444a-b053-7f50716f2012","token_type":"bearer","refresh_token":"e6f8624f-213d-4343-a971-980e83f734be","expires_in":1738,"scope":"read write"}
```

# Obtendo um novo token através do token de atualização
```sh
curl -vu teste:123 'http://localhost:9191/api/oauth/token?grant_type=refresh_token&refresh_token=<refresh_token>'

{"access_token":"821c99d4-2c9f-4990-b68d-18eacaff54b2","token_type":"bearer","refresh_token":"e6f8624f-213d-4343-a971-980e83f734be","expires_in":1799,"scope":"read write"}
```

# Get em uma rota segura com autenticação
```sh
curl -i -H "Authorization: Bearer <access_token>" http://localhost:9191/api/secure

Secure Hello!
```

# Autores
Hugo Marcel Larsen<br>
Lucas Vanderlinde