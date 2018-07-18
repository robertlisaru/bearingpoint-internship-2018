package com.omatechnology.servlets;

import com.omatechnology.dataaccess.TaskDAOImpl;
import com.omatechnology.dataaccess.TaskDAOInterface;
import com.omatechnology.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletetask")
public class DeleteTaskServlet extends HttpServlet {
    TaskDAOInterface taskDAO = new TaskDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession(false).getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }
        String taskID = req.getParameter("taskID");
        if (taskID == null) {
            resp.sendRedirect("/project");
            return;
        }
        taskDAO.deleteTaskByID(taskID);
        resp.sendRedirect("/task");
    }
}

