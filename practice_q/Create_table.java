package practice_q;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create_table {
	
	public Connection con;
	
	private String formTable = "student";
	

	public Create_table() throws ClassNotFoundException, SQLException {
		this.con = DatabaseConnection.getConnection();
		String sql = "CREATE TABLE IF NOT EXISTS " + formTable +" (id INT PRIMARY KEY AUTO_INCREMENT, roll_number int(11), name VARCHAR(30), Level VARCHAR(30), division VARCHAR(30), major VARCHAR(30))";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.execute();
//		System.out.println("Table Created");
	}
	
}
