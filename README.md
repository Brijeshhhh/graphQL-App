# GraphQL Spring Boot CRUD Application

## Overview
This project is a GraphQL-based CRUD application built using Spring Boot. It provides efficient management of `Product` and `Category` entities with operations like create, update, delete, and retrieval using GraphQL queries and mutations.

## Features
- Fully integrated GraphQL API for managing products and categories.
- Uses Spring Boot and Spring Data JPA for seamless database interactions.
- Supports H2 database by default, with easy configuration for MySQL or PostgreSQL.
- Implements pagination and filtering for better query performance.
- Provides clear API documentation and testing endpoints.
- Includes GraphiQL interface for easy query execution and testing.
- Swagger-style API documentation for testing GraphQL endpoints.

## Prerequisites
To run this application, ensure you have the following installed:
- Java 11 or higher
- Maven
- Postman or GraphiQL for API testing
- A database (H2 by default, MySQL or PostgreSQL as alternatives)

## Tech Stack
- **Spring Boot** - Framework for building Java-based backend applications.
- **Spring Data JPA** - ORM tool for database management.
- **GraphQL Java Tools** - Enables GraphQL support in Spring Boot.
- **H2 Database** - In-memory database for quick testing (can be switched to other databases).

## Project Structure
```
src/main/java/com/excelacom/graphql_demo
│── config (Configuration classes)
│── model (Entity classes for database mapping)
│── repository (Database interaction interfaces)
│── resolver (GraphQL query and mutation handlers)
│── service (Business logic implementations)
│── GraphQLDemoApplication.java (Main application entry point)
resources/graphql/schema.graphqls (GraphQL schema definition)
```

## Understanding GraphQL Integration
GraphQL in Spring Boot is structured into several components:
### 1. Model Layer
Defines entities for `Product` and `Category` mapped to the database.

### 2. Repository Layer
Uses Spring Data JPA to interact with the database efficiently.

### 3. Service Layer
Contains business logic for handling product and category operations.

### 4. GraphQL Schema Definition
Located in `resources/graphql/schema.graphqls`, it defines query and mutation structures.

### 5. Resolvers
Resolvers map GraphQL queries and mutations to Java service methods, making GraphQL requests functional.

## Testing GraphQL with GraphiQL
**GraphiQL** is a web-based interactive tool that allows developers to test GraphQL queries and mutations easily. In Spring Boot, GraphiQL can be enabled by adding the following dependency to `pom.xml`:
```xml
<dependency>
    <groupId>com.graphql-java-kickstart</groupId>
    <artifactId>graphiql-spring-boot-starter</artifactId>
    <version>11.1.0</version>
</dependency>
```
Once added, run the application and open `http://localhost:8080/graphiql` in your browser to access the GraphiQL interface. Here, you can execute GraphQL queries, test mutations, and explore the schema interactively.

## Running the Application
1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using:
   ```sh
   mvn spring-boot:run
   ```
4. Use GraphiQL or Postman to test the API endpoints.

## API Documentation
### Queries
- **Fetch all products**  
  ```graphql
  query {
    allProducts {
      id
      name
      price
    }
  }
  ```
- **Fetch product by ID**  
  ```graphql
  query {
    productById(id: 1) {
      id
      name
      price
    }
  }
  ```
- **Fetch all categories**  
  ```graphql
  query {
    allCategories {
      id
      name
    }
  }
  ```
- **Fetch category by name**  
  ```graphql
  query {
    categoryByName(categoryName: "Electronics") {
      id
      name
    }
  }
  ```

### Mutations
- **Create a new product**  
  ```graphql
  mutation {
    createProduct(name: "Laptop", price: "1200", categoryId: 1) {
      id
      name
      price
    }
  }
  ```
- **Update an existing product**  
  ```graphql
  mutation {
    updateProduct(id: 1, name: "Gaming Laptop", price: "1500", categoryId: 1) {
      id
      name
      price
    }
  }
  ```
- **Delete a product**  
  ```graphql
  mutation {
    deleteProduct(id: 1)
  }
  ```
- **Create a new category**  
  ```graphql
  mutation {
    createCategory(name: "Appliances") {
      id
      name
    }
  }
  ```
- **Update an existing category**  
  ```graphql
  mutation {
    updateCategory(id: 1, name: "Home Appliances") {
      id
      name
    }
  }
  ```
- **Delete a category**  
  ```graphql
  mutation {
    deleteCategory(id: 1)
  }
  ```

## Why Use GraphQL?
Unlike traditional REST APIs, GraphQL allows clients to fetch only the data they need, reducing over-fetching and under-fetching of data. This improves application performance and efficiency.

## Conclusion
This project demonstrates the power of GraphQL with Spring Boot, providing a flexible and efficient way to manage APIs. Its modular architecture ensures scalability and maintainability, making it a great addition to any developer’s portfolio.

