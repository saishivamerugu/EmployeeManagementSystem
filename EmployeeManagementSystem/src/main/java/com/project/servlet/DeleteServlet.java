package com.project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.project.Dao.EmployeeDao;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("id"));
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.deleteEmployee(empId);
		
		response.sendRedirect("employees");
	}
}
