package com.project.utils;

public class Constants {

    public static final String URL = "jdbc:mysql://localhost:3306/webprojects";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    // Users queries
    public static final String INSERT_USER = "INSERT INTO USERS(email, password) VALUES(?, ?)";
    public static final String GET_USER = "SELECT * FROM USERS WHERE email=?";

    // Employees queries
    public static final String GET_ALL_EMPLOYEES = "SELECT * FROM EMPLOYEES";
    public static final String GET_EMPLOYEE = "SELECT * FROM EMPLOYEES WHERE empId=?";
    public static final String SAVE_EMPLOYEE = "INSERT INTO EMPLOYEES(name, email, phone_number, age, salary) VALUES(?,?,?,?,?)";
    public static final String UPDATE_EMPLOYEE = "UPDATE EMPLOYEES SET name=?, email=?, phone_number=?, age=?, salary=? WHERE empId=?";
    public static final String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEES WHERE empId=?";
}
