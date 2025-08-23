<%@page import="com.project.utils.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
<style>
    body { font-family: Arial, sans-serif; margin: 30px; }
    input { padding: 5px; margin: 5px; }
    h1 { color: blue; }
</style>
</head>
<body>
<h1>Add New Employee</h1>
<form action="addEmployee" method="post">
    Name: <input type="text" name="name"><br>
    Age: <input type="number" name="age"><br>
    Email: <input type="email" name="email"><br>
    Phone Number: <input type="number" name="phoneNumber"><br>
    Salary: <input type="number" name="salary"><br>
    <input type="submit" value="Add">
</form>
</body>
</html>
