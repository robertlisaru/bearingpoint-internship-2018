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

        String projectName = req.getParameter("projectName");
        String manager = ((User) req.getSession(false).getAttribute("user")).getUsername();
        String client = req.getParameter("client");
        String releaseDate = req.getParameter("releaseDate");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        Project project = new Project(projectName, manager, client, releaseDate, description, status);
        projectDAO.updateProject(project);
        resp.sendRedirect("/project?projectID=" + projectID);
    }
}
