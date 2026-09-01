# Gestor de Biblioteca

Spring Boot backend for managing a library (authors, books and loans), with loan availability logic.

## Overview

REST API built with Spring Boot to manage a small library system: authors, books and loans, with a core business rule that prevents lending out a book that is already on loan.

## Tech Stack

- Java 25
- Spring Boot 4
- Spring Data JPA / Hibernate
- MySQL 8
- Lombok
- Bean Validation (Jakarta Validation)
- JUnit 5 + Mockito (unit tests)
- Docker & Docker Compose

## Features

- Full CRUD for Author, Book and Loan
- Author (1) – Book (N) and Book (N) – Loan (N) relationships
- Business rule: a book cannot be loaned again while it already has an active (not returned) loan
- Response DTOs and mappers to control exactly what each endpoint returns, avoiding exposing full JPA entities
- Bean Validation on entity input (required fields, positive numbers, age range, etc.)
- Centralized exception handling (`@RestControllerAdvice`) returning consistent JSON error responses for validation errors, not-found resources and business rule violations
- Unit tests for the service layer with Mockito

## Project Structure

```
src/main/java/com/dani/gestor_biblioteca/
├── models/          # JPA entities (Author, Book, Loan)
├── repositories/     # Spring Data JPA repositories
├── services/          # Business logic
├── controllers/       # REST controllers
├── dto/               # Response DTOs
├── mappers/            # Entity -> DTO mapping
└── exceptions/          # Global exception handler
```

## Getting Started

### Option 1 — Docker (recommended)

```bash
docker-compose up --build
```

This starts the application together with a MySQL container. The API will be available at `http://localhost:8081`.

### Option 2 — Local

1. Have a local MySQL instance running.
2. Configure your credentials in `src/main/resources/application.properties`.
3. Run the application:

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

## Main Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/api/authors` | Create an author |
| GET    | `/api/authors` | List all authors |
| GET    | `/api/authors/{id}` | Get an author by id |
| DELETE | `/api/authors/{id}` | Delete an author |
| POST   | `/api/books` | Create a book |
| GET    | `/api/books` | List all books |
| GET    | `/api/books/{id}` | Get a book by id |
| DELETE | `/api/books/{id}` | Delete a book |
| POST   | `/api/loans` | Create a loan (fails if the book is already on loan) |
| GET    | `/api/loans` | List all loans |
| GET    | `/api/loans/{id}` | Get a loan by id |
| DELETE | `/api/loans/{id}` | Delete a loan |

### Example — create a book

```json
POST /api/books
{
  "title": "La casa de los espíritus",
  "numberOfPages": 448,
  "price": 19.9,
  "author": {
    "id": 1
  }
}
```

## Author

Dani (Daniel Juan Lician) — [danijuan.com](https://danijuan.com) · [GitHub](https://github.com/dannijl88)
