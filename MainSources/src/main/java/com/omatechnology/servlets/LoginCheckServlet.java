package com.omatechnology.servlets;

import com.omatechnology.entities.User;
import dataaccess.UserDAOImpl;
import dataaccess.UserDAOInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginCheck")
public class LoginCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAOInterface userDAO = new UserDAOImpl();

    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (userDAO.verifyUserLogin(user)) {
            response.sendRedirect("PanelWeb/index.html");
        } else {
            response.sendRedirect("welcome.jsp");
        }
    }
}
