package com.project.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import com.project.Dao.UserDao;
import com.project.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(email, password);
        
        UserDao userDao = new UserDao();
        boolean isValid = userDao.validateUser(user);

        System.out.println("User tried login with: " + email + " / " + password + " → Result: " + isValid);
        
        if (isValid) {
            HttpSession session = request.getSession();
            String[] split = user.getEmail().split("@");
            String name = split[0];
            session.setAttribute("email", name);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("employees");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("error", "Invalid Email or Password!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
            requestDispatcher.forward(request, response);
        }
    }
}
