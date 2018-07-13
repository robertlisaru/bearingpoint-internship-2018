

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginCheck
 */
@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            String username = request.getParameter("username");
            String pass = request.getParameter("pass");
            try {
                if (username != null) {

                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                    Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/proiect","root","");
                    String sql = "SELECT * FROM users where username=? AND pass=?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1,username);
                    pst.setString(2,pass);
                    ResultSet rs = pst.executeQuery();
                    if(rs.next())
                    {
                        response.sendRedirect("PanelWeb/index.html");
                    }
                    else{
                        response.sendRedirect("welcome.jsp");
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            } catch (Exception e) {
                System.out.println("Exception: :" + e.getMessage());
            }


    }
}
