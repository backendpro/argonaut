# Argonauts

- REST API

## Stack

- Gradle 7.4
- Java 11
- Spring Boot 2.6.3
- MySQL 5.6

## Port

- default port 8080

## Endpoints

- POST /argonauts -> create
- GET /argonauts -> getAll
- GET /argonauts/{id} -> get
- PUT /argonauts/{id} -> update
- DELETE /argonauts/{id} -> delete
- GET /argonauts/{active} -> getByStatus

## Model

``` json
student {
  "id": "Long",
  "name": "String",
  "identityNumber": "String",
  "studentSince": "LocalDate",
  "birthdate": "LocalDate",
  "cellphone": "Long",
  "email": "String",  
  "postalCode": "String",
  "addressLine": "String",
  "monthlyBill": "double",
  "lastPayDate": "LocalDate"
}
```

# Continua