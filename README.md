#  RESTful Bookstore API

A simple REST API built using **Spring Boot** for managing **Books** and **Authors**, demonstrating CRUD operations, pagination, filtering, sorting, and API documentation with Swagger.  
This project uses an **in-memory H2 Database** for easy setup and testing.

---

##  Tech Stack

| Tool | Purpose |
|------|----------|
| **Java 17** | Core Programming Language |
| **Spring Boot 3.3.2** | Backend Framework |
| **Spring Data JPA** | ORM & Database Layer |
| **H2 Database** | In-memory Database |
| **Swagger / OpenAPI** | API Documentation |
| **Maven** | Build Tool |
| **VS Code / IntelliJ IDEA** | IDE |

---

##  Project Setup

###  Create the Project
Generate a Spring Boot application from [Spring Initializr](https://start.spring.io/) with the following dependencies:
- Spring Web  
- Spring Data JPA  
- H2 Database  
- Spring Boot DevTools  

![Spring Initializr Setup](./Screenshot%202025-10-21%20173823.png)

---

###  Project Structure

```
bookstore/
 ├── src/
 │   ├── main/java/com/example/bookstore/
 │   │   ├── model/
 │   │   │   ├── Author.java
 │   │   │   └── Book.java
 │   │   ├── controller/
 │   │   │   ├── AuthorController.java
 │   │   │   └── BookController.java
 │   │   ├── repository/
 │   │   │   ├── AuthorRepository.java
 │   │   │   └── BookRepository.java
 │   │   └── BookstoreApplication.java
 │   └── resources/
 │       └── application.properties
 └── pom.xml
```

---

##  Run the Application

### Using Maven
```bash
mvn clean install
mvn spring-boot:run
```

Once started, the application runs at:  
 [http://localhost:8080](http://localhost:8080)

---

##  API Documentation (Swagger)

Access the interactive Swagger UI at:  
 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

![Swagger UI Overview](./Screenshot%202025-10-21%20173845.png)

---

##  Database Console (H2)

You can view live data using the **H2 Console**:  
 [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

| Field | Value |
|--------|--------|
| **JDBC URL** | `jdbc:h2:mem:bookstoredb` |
| **Username** | `sa` |
| **Password** | *(leave empty)* |

---

#  Execution Steps & Screenshots

| Step | Command / Action | Expected Result | Screenshot |
|------|------------------|------------------|-------------|
| **1** | **Run Spring Boot Application**<br>`mvn spring-boot:run` | Application starts successfully at port **8080** | ![Swagger UI Overview](./Screenshot%202025-10-21%20173845.png) |
| **2** | **Create an Author**<br>POST `/authors` <br>Body:<br>```json<br>{<br> "name": "Robert Martin",<br> "biography": "Author of Clean Code"<br>}``` | Author created successfully | ![POST Author Response](./Screenshot%202025-10-21%20174048.png) |
| **3** | **Create a Book (linked to Author)**<br>POST `/books` <br>Body:<br>```json<br>{<br>"title": "Clean Code",<br>"isbn": "9780132350884",<br>"price": 29.99,<br>"publishedDate": "2008-08-01",<br>"author": { "id": 1 }<br>}``` | Book added successfully | ![POST Book Response](./Screenshot%202025-10-21%20174141.png) |
| **4** | **Verify Author Table (H2)**<br>`SELECT * FROM AUTHOR;` | Displays author details | ![H2 Author Table](./Screenshot%202025-10-21%20174235.png) |
| **5** | **Verify Book Table (H2)**<br>`SELECT * FROM BOOK;` | Displays book with linked author | ![H2 Book Table](./Screenshot%202025-10-21%20174251.png) |
| **6** | **API Controller View** | Swagger shows all CRUD endpoints for Books & Authors | ![Swagger Controller View](./Screenshot%202025-10-21%20174347.png) |

---

##  Sample API Requests

###  Add Author
```json
{
  "name": "Robert Martin",
  "biography": "Author of Clean Code"
}
```

###  Add Book
```json
{
  "title": "Clean Code",
  "isbn": "9780132350884",
  "price": 29.99,
  "publishedDate": "2008-08-01",
  "author": {
    "id": 1
  }
}
```

###  View Books
```bash
GET /books
```

---

##  Future Improvements
- Add DTOs and Validation  
- Include Exception Handling (Global Error Handler)  
- Implement MySQL Database for Persistence  
- Add Unit Tests with JUnit and Mockito  

---


