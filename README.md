# Restful-API-P3

Prototype to exemplify a backend with restful API and OAuth2 authentication. Project developed for Programming 3 class at FURB.

# Build & Run
```java
mvn clean install spring-boot:run
```
# GET in public route
```sh
curl -i http://localhost:8080/api/hello

Hello User!
```
# GET in private route without authentication
```sh
curl -i http://localhost:8080/api/secure

{"timestamp":1444985908768,"status":401,"error":"Unauthorized","message":"Access Denied","path":"/api/secure"}
```

# Getting authentication token
```sh
curl -vu teste:123 'http://localhost:8080/api/oauth/token?username=admin&password=admin&grant_type=password'

{"access_token":"91202244-431f-444a-b053-7f50716f2012","token_type":"bearer","refresh_token":"e6f8624f-213d-4343-a971-980e83f734be","expires_in":1738,"scope":"read write"}
```

# Getting a new token with the refresh token
```sh
curl -vu teste:123 'http://localhost:8080/api/oauth/token?grant_type=refresh_token&refresh_token=<refresh_token>'

{"access_token":"821c99d4-2c9f-4990-b68d-18eacaff54b2","token_type":"bearer","refresh_token":"e6f8624f-213d-4343-a971-980e83f734be","expires_in":1799,"scope":"read write"}
```

# GET in private route with authentication
```sh
curl -i -H "Authorization: Bearer <access_token>" http://localhost:8080/api/secure

Secure Hello!
```

Authors
> [Hugo Marcel Larsen](https://github.com/HMLarsen) <br>
> [Lucas Vanderlinde](https://github.com/LucasVander) <br>
