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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/CreateProject")
public class CreateProjectServlet extends HttpServlet {
    ProjectDAOInterface projectDAO = new ProjectDAOImpl();

    public CreateProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        String projectName = request.getParameter("projectName");
        String manager = ((User)request.getSession(false).getAttribute("user")).getUsername();
        String client = request.getParameter("client");

        String releaseDate = request.getParameter("releaseDate");

        String description = request.getParameter("description");
        String status = request.getParameter("status");
        Project project = new Project(projectName, manager, client, releaseDate, description, status);
        projectDAO.insert(project);
        response.sendRedirect("project.jsp");
    }
}
