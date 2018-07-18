package com.omatechnology.servlets;

import com.omatechnology.dataaccess.TaskDAOImpl;
import com.omatechnology.dataaccess.TaskDAOInterface;
import com.omatechnology.entities.Task;
import com.omatechnology.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task")
public class ViewTaskServlet extends HttpServlet {
    TaskDAOInterface taskDAO = new TaskDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskID = req.getParameter("taskID");
        if (taskID == null) {
            resp.sendRedirect("/project");
            return;
        }
        User user = (User) req.getSession(false).getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }
        Task task = taskDAO.getTaskByID(taskID);
        task.setId(taskID);
        req.setAttribute("task", task);

        req.getRequestDispatcher("/task.jsp").forward(req, resp);
    }
}
