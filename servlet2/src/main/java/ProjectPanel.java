import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/ProjectPanel")
public class ProjectPanel extends HttpServlet {
    Connection conn =  null;
    PreparedStatement statement =null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String projectName = request.getParameter("projectName");
        String manager = request.getParameter("manager");
        String client = request.getParameter("client");
        String releaseDate = request.getParameter("releaseDate");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        AddProject addProject = new AddProject(projectName,manager,client,releaseDate,description,status);
        new ProjectPanelDAO().insert(addProject);
        response.sendRedirect("message.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
