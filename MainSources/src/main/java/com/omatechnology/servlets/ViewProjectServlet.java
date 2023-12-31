package com.omatechnology.servlets;

import com.omatechnology.dataaccess.ProjectDAOImpl;
import com.omatechnology.dataaccess.ProjectDAOInterface;
import com.omatechnology.dataaccess.TaskDAOImpl;
import com.omatechnology.dataaccess.TaskDAOInterface;
import com.omatechnology.entities.Project;
import com.omatechnology.entities.Task;
import com.omatechnology.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/project")
public class ViewProjectServlet extends HttpServlet {
    ProjectDAOInterface projectDAO = new ProjectDAOImpl();
    TaskDAOInterface taskDAO = new TaskDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectID = req.getParameter("projectID");
        if (projectID == null) {
            resp.sendRedirect("/index");
            return;
        }
        User user = (User) req.getSession(false).getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }
        Project project = projectDAO.getProjectByID(projectID);
        project.setId(projectID);
        req.setAttribute("project", project);
        List<Task> taskList = taskDAO.getTasksByProjectId(projectID);
        req.setAttribute("taskList", taskList);
        req.getRequestDispatcher("/project.jsp").forward(req, resp);
    }
}
