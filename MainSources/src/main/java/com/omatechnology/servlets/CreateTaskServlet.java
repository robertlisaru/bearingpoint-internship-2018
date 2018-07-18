package com.omatechnology.servlets;

import com.omatechnology.dataaccess.TaskDAOImpl;
import com.omatechnology.dataaccess.TaskDAOInterface;
import com.omatechnology.entities.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreateTask")
public class CreateTaskServlet extends HttpServlet {
    TaskDAOInterface taskDAO = new TaskDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("taskName");
        int projectID = (Integer.parseInt(request.getParameter("projectId")));
        String estimatedDate = request.getParameter("timeOfCompl");
        String status = request.getParameter("status");

        Task task = new Task(name, projectID, estimatedDate, status);
        taskDAO.insert(task);
        response.sendRedirect("/project?projectID=" + projectID);
    }
}
