package com.omatechnology.servlets;

import com.omatechnology.dataaccess.ProjectDAOImpl;
import com.omatechnology.dataaccess.ProjectDAOInterface;
import com.omatechnology.entities.Project;
import com.omatechnology.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateproject")
public class UpdateProjectServlet extends HttpServlet {
    ProjectDAOInterface projectDAO = new ProjectDAOImpl();

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
        if (project.getManager() == user.getUsername()) {
            String projectName = req.getParameter("projectName");
            project.setName(projectName);
            String client = req.getParameter("client");
            project.setClient(client);
            String releaseDate = req.getParameter("releaseDate");
            project.setReleaseDate(releaseDate);
            String description = req.getParameter("description");
            project.setDescription(description);
            String status = req.getParameter("status");
            project.setStatus(status);
            projectDAO.updateProject(project);
        }
        resp.sendRedirect("/project?projectID=" + projectID);
    }
}
