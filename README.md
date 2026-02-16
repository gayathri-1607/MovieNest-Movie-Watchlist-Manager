🎬 MovieNest – Movie Watchlist Manager

![Java](https://img.shields.io/badge/Java-17-orange)
![JDBC](https://img.shields.io/badge/JDBC-Enabled-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Architecture](https://img.shields.io/badge/Architecture-DAO%20Pattern-green)
![Status](https://img.shields.io/badge/Project-Completed-success)

---

📌 Overview

CineVault is a console-based Movie Watchlist Management System developed using Java and JDBC.
It demonstrates clean layered architecture using the DAO pattern, service abstraction, and custom exception handling.

The application allows users to manage their personal movie collection stored in a MySQL database.

---

🚀 Key Features

* 🎥 Add new movies
* 📋 View all movies
* 🔍 Find movie by ID
* ✏ Update movie details
* ❌ Delete movie
* 🗄 Auto table creation
* ⚠ Custom exception handling
* 🏗 Clean layered architecture

---

🏗 Architecture

This project follows a Layered Architecture:

```
Controller  →  Service  →  DAO  →  Database
```

Package Structure

```
com.movie
│
├── connection
│   └── ConnectionFactory.java
│
├── model
│   └── Movie.java
│
├── dao
│   ├── MovieDao.java
│   └── MovieDaoImpl.java
│
├── service
│   ├── MovieService.java
│   └── MovieServiceImpl.java
│
├── exception
│   └── MovieNotFoundException.java
│
└── controller
    └── MainProgram.java
```

---

🛠️ Technologies Used

| Technology         | Purpose               |
| ------------------ | --------------------- |
| Java 8+            | Core Programming      |
| JDBC               | Database Connectivity |
| MySQL              | Relational Database   |
| Eclipse / IntelliJ | IDE                   |
| DAO Pattern        | Data Abstraction      |
| OOP                | Design Principles     |

---

🗄️ Database Configuration

Step 1: Create Database

```sql
CREATE DATABASE advancejava;
```

Step 2: Table (Auto-created by program)

```sql
CREATE TABLE IF NOT EXISTS movie (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    genre VARCHAR(50),
    rating DOUBLE,
    status VARCHAR(20)
);
```

---

⚙️ Application Configuration

Update your `ConnectionFactory.java`:

```java
private static final String url = "jdbc:mysql://localhost:3306/advancejava";
private static final String user = "root";
private static final String pass = "YOUR_PASSWORD";
```

---

📦 Dependency Setup

🔹 If Using Maven

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.3.0</version>
</dependency>
```

---

🔹 If Not Using Maven

1. Download MySQL Connector JAR
2. Add to project:

```
Right Click Project → Build Path → Add External JARs
```

---

▶️ How to Run

1. Ensure MySQL server is running
2. Create database `advancejava`
3. Add MySQL connector dependency
4. Run:

```
MainProgram.java → Run As → Java Application
```

---

🖥 Sample Console Output

```
Table Created Successfully
Movie Added Successfully
Movie Added Successfully
Movie Added Successfully

All Movies:
Movie [id=1, title=Inception, genre=Sci-Fi, rating=9.0, status=Watched]
Movie [id=2, title=Interstellar, genre=Sci-Fi, rating=9.2, status=Watched]

Find Movie By ID:
Movie [id=1, title=Inception, genre=Sci-Fi, rating=9.0, status=Watched]
```

---

🧠 Concepts Demonstrated

* JDBC Connection Management
* PreparedStatement vs Statement
* DAO Design Pattern
* Service Layer Abstraction
* Custom Exception Handling
* Clean Code Structure
* Separation of Concerns

---

🔮 Future Enhancements

* 🔹 Auto-increment ID
* 🔹 Menu-driven console UI
* 🔹 Search by Genre
* 🔹 Filter by Rating
* 🔹 REST API using Spring Boot
* 🔹 Frontend Integration
* 🔹 Unit Testing (JUnit)

---




