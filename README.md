# EmployeeManagementSystem
A simple web-based Employee Management System built using Java Servlets, JSP, JDBC, and MySQL.  
This project allows you to add, update, delete, and view employees in a MySQL database and includes user authentication.

## Features

- User Signup and Login
- Add New Employee
- View All Employees
- Update Employee Details
- Delete Employee
- Simple styling using internal CSS

---

## Technologies Used

- Java SE
- Java Servlets
- JSP (JavaServer Pages)
- JDBC (Java Database Connectivity)
- MySQL Database
- Apache Tomcat (or any Java Servlet container)
- HTML/CSS (basic styling)

---

## Database Setup

**MySQL Database:** `webprojects`

**Users Table**
```sql
CREATE TABLE users (
    email VARCHAR(30) PRIMARY KEY,
    password VARCHAR(20)
);
````

**Employees Table**

```sql
CREATE TABLE employees (
    empId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    email VARCHAR(50) UNIQUE,
    phone_number VARCHAR(20),
    age INT,
    salary DECIMAL(10,2)
);
```

---

## Project Structure

```
EmployeeManagementSystem/
│
├── src/                   # Java source files
│   └── com/project/       # DAO, Model, Utils, Servlet classes
│
├── WebContent/            # JSP pages and HTML files
│   ├── index.html
│   ├── signup.jsp
│   ├── addEmployee.jsp
│   ├── updateEmp.jsp
│   └── employees.jsp
│
├── WEB-INF/
│   └── web.xml            # Deployment descriptor
│
└── README.md
```
## How to Run

1. Clone this repository:

```
git clone https://github.com/saishivamerugu/EmployeeManagementSystem.git
```

2. Import the project into **Eclipse / IntelliJ IDEA** as a **Dynamic Web Project**.

3. Add **MySQL JDBC Driver** (`mysql-connector-java`) to your project’s `lib` folder.

4. Configure the database connection in `DBConnection.java`:

```java
public static final String URL = "jdbc:mysql://localhost:3306/webprojects";
public static final String USERNAME = "root";
public static final String PASSWORD = "root";
```

5. Deploy the project on **Apache Tomcat**.

6. Open browser and navigate to:

```
http://localhost:8080/YourProjectName/index.html
```

7. Use signup to create a new user or login with existing credentials.

## Author

* Sai Shiva Merugu
* GitHub: [https://github.com/saishivamerugu](https://github.com/saishivamerugu)


