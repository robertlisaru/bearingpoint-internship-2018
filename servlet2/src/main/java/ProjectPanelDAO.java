import java.sql.*;

public class ProjectPanelDAO {
    private Connection con = null;
    private Statement stm = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/project";


    public void insert(AddProject newAddProject) {

        //TABEL
        try {
            connect();
            String sql = "INSERT INTO projectabel(projectName,manager,client,releaseDate,description,status) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = pstm = con.prepareStatement(sql);

            pstm.setString(1, newAddProject.getProjectName());
            pstm.setString(2, newAddProject.getManager());
            pstm.setString(3, newAddProject.getClient());
            pstm.setString(4, newAddProject.getReleaseDate());
            pstm.setString(1, newAddProject.getStatus());
        } catch (Exception ex) {

        } finally {
            close();
        }


    }

    private void connect() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DATABASE_URL, "root", "");


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            if (rs != null)
                rs.close();
            if (stm != null)
                stm.close();
            if (pstm != null)
                pstm.close();
            if (con != null)
                con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
