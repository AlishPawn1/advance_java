package datebaseMVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	
	public Connection con;
	
	private String formTable = "users";
	

	public DBConnect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "");
		System.out.println("Database Connection");
		String sql = "CREATE TABLE IF NOT EXISTS " + formTable +" (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30), email VARCHAR(30), height DECIMAL(3,2), phone varchar(30))";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.execute();
		System.out.println("Table Created");
	}
	
	public void insertUser(UserData user, DatabaseCallback callback) {
		try {
			String sql = "insert into " + formTable + "(name, email, height, phone) VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setFloat(3, user.getHeight());
			stmt.setString(4, String.valueOf(user.getPhone()));
			int check = stmt.executeUpdate();
			if(check != -1) {
				callback.onDataEntrySuccess();
			}else {
				callback.onDataEntryFailure("Unable to entry sql data");
			}
		} catch(Exception e) {
			callback.onDataEntryFailure(String.valueOf(e));
		}
	}
	public ResultSet retriveUserList() throws SQLException {
		String sql = "select * from " + formTable;
		Statement stmt = con.createStatement();
		return  stmt.executeQuery(sql);		
	}
	public ResultSet retriveUserSetUsers() throws Exception {
		String query = "select * from " + formTable;
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(query);		
		return rs;
	}
}
