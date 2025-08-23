<%@page import="com.project.model.Employee"%>
<%@page import="com.project.Dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
<style>
    body { font-family: Arial, sans-serif; margin: 30px; }
    input { padding: 5px; margin: 5px; }
    h1 { color: orange; }
</style>
</head>
<body>

<%
    int empId = Integer.parseInt(request.getParameter("id"));
    EmployeeDao employeeDao = new EmployeeDao();
    Employee emp = employeeDao.getEmployee(empId);
%>

<h1>Update Employee Details</h1>
<form action="update" method="post">
    <input type="hidden" name="id" value="<%= empId %>">
    Name: <input type="text" name="name" value="<%= emp.getName() %>"><br>
    Age: <input type="number" name="age" value="<%= emp.getAge() %>"><br>
    Email: <input type="email" name="email" value="<%= emp.getEmail() %>"><br>
    Phone Number: <input type="number" name="phoneNumber" value="<%= emp.getPhoneNum() %>"><br>
    Salary: <input type="number" name="salary" value="<%= emp.getSalary() %>"><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
