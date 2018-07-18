package com.omatechnology.servlets;

import com.omatechnology.dataaccess.UserDAOImpl;
import com.omatechnology.dataaccess.UserDAOInterface;
import com.omatechnology.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logincheck")
public class LoginCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAOInterface userDAO = new UserDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("user") != null) {
            response.sendRedirect(request.getContextPath() + "/index");
            return;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDAO.getUserByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            request.setAttribute("userWarning", new String("Login failed."));
            getServletContext().getRequestDispatcher("/login.jsp").
                    forward(request, response);
            return;
        }

        HttpSession newSession = request.getSession();
        newSession.setAttribute("user", user);
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
