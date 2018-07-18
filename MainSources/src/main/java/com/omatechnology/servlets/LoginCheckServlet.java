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

        if (request.getSession(false).getAttribute("user") != null) {
            response.sendRedirect(request.getContextPath() + "/index");
            return;
        }

        if (userDAO.verifyPassword(user)) {
            HttpSession newSession = request.getSession();
            newSession.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/index");
        } else {
            request.setAttribute("userWarning", new String("Login failed."));
            getServletContext().getRequestDispatcher("/login.jsp").
                    forward(request, response);
        }
    }
}
