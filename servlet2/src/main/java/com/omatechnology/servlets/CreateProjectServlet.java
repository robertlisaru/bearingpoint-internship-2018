package com.omatechnology.servlets;

import com.omatechnology.entities.Project;
import dataaccess.ProjectDAOImpl;
import dataaccess.ProjectDAOInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreateProject")
public class CreateProjectServlet extends HttpServlet {
    ProjectDAOInterface projectDAO = new ProjectDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String projectName = request.getParameter("projectName");
        String manager = request.getParameter("manager");
        String client = request.getParameter("client");
        String releaseDate = request.getParameter("releaseDate");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        Project project = new Project(projectName, manager, client, releaseDate, description, status);
        projectDAO.insert(project);
        response.sendRedirect("/PanelWeb/index2.html");
    }
}
