<%@ page import="java.util.*, com.project.model.*" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees</title>
<style>
    body { 
        font-family: Arial, sans-serif; 
        margin: 30px; 
    }
    table { 
        border-collapse: collapse;     
        width: 100%; 
    }
    th, td { 
        border: 1px solid black;     
        padding: 8px; 
        text-align: center;     
    }
    th { 
        background-color: #f2f2f2; 
    }
    a { 
        text-decoration: none; 
        color: blue;     
    }
    marquee { 
        color: green;     
        font-weight: bold; 
        }
</style>
</head>
<body>
<marquee>Welcome <%= session.getAttribute("email") %></marquee><hr>
<a href="addEmployee.jsp">Add New Employee</a><hr>

<table>
<tr> 
    <th>Employee ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Email</th>
    <th>Phone Number</th>
    <th>Salary</th>
    <th>Update</th>
    <th>Delete</th>
</tr>

<% List<Employee> empList = (List<Employee>) request.getAttribute("empList"); 
   for(Employee emp : empList){ %>
<tr>
    <td><%= emp.getEmpId() %></td>
    <td><%= emp.getName() %></td>
    <td><%= emp.getAge() %></td>
    <td><%= emp.getEmail() %></td>
    <td><%= emp.getPhoneNum() %></td>
    <td><%= emp.getSalary() %></td>
    <td><a href="updateEmp.jsp?id=<%= emp.getEmpId() %>">Update Emp</a></td>
    <td><a href="delete?id=<%= emp.getEmpId() %>">Delete Emp</a></td>
</tr>
<% } %>

</table>
<hr>
</body>
</html>

