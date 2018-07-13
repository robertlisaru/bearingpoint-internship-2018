import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

	
	private Connection con = null;
	private Statement stm = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/proiect";

	
	public void  insert(User newUser)
	{
		try {

			connect();
			
			String sql = "INSERT INTO users (username,pass,email,gender) VALUES(?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, newUser.getUsername());
			pstm.setString(2, newUser.getPassword());
			pstm.setString(3, newUser.getEmail());
			pstm.setString(4, newUser.getGender());
		
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		close();
		}
		
	}
	
	

		
		private void connect(){

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(DATABASE_URL,"root","");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	
	private void close(){
		
			try {
				if(rs!=null)
					rs.close();
				if(stm!=null)
					stm.close();
				if(pstm!=null)
					pstm.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
