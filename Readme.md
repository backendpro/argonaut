# Argonauts
- REST API

## Stack
- Gradle 6.7
- Java 11
- Spring Boot 2.6.3
- MySQL 5.6

## Port
- default port 8080

## Endpoints

- POST /argonauts -> create
- GET	/argonauts -> getAll
- GET /argonauts/{id} -> get
- PUT /argonauts/{id} -> update
- DELETE /argonauts/{id} -> delete

## Model

``` json
student {
  "id": "Long",
  "name": "String",
  "document": "String",
  "studentSince": "LocalDate",
  "birthdate": "LocalDate",
  "cellphone": "Long",
  "email": "String",  
  "postalCode": "String",
  "addressLine": "String",
  "bill": "String",
  "lastPayDate": "LocalDate"
}
```

# Continua