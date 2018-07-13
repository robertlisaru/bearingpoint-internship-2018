import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 161772151)
public class uploadServlet extends HttpServlet {
    Connection conn =  null;
    PreparedStatement statement =null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // gets values of text fields
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        ; // input stream of the upload file

        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
        }
        byte[] inputStream = filePart.getInputStream().readAllBytes();

        //Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =DriverManager.getConnection( "jdbc:mysql://localhost:3306/appdb","root","");

            // constructs SQL statement
            String sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);

            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
               // statement.setBlob(3, inputStream);
                statement.setBytes(3,inputStream);
            }

            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("Message", message);

        // forwards to the message page
        getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
