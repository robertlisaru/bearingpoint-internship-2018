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

@WebServlet("/updatetask")
public class UpdateTaskServlet extends HttpServlet {
    TaskDAOInterface taskDAO = new TaskDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskID = req.getParameter("taskID");
        if (taskID == null) {
            resp.sendRedirect("/index");
            return;
        }
        User user = (User) req.getSession(false).getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }

        String name = req.getParameter("taskName");
        // int projectID = (Integer.parseInt(req.getParameter("projectId")));
        String dueDate = req.getParameter("dueDate");
        String status = req.getParameter("status");
        Task task = new Task(taskID, name, dueDate, status);
        taskDAO.updateTask(task);
        resp.sendRedirect("task?taskID=" + taskID);
    }
}
