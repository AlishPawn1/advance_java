import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionExample {

	MySqlConnectionExample() throws Exception, SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql//localhost:3306/advance_java", "root", "");
	}

    public static void main(String[] args) throws Exception {
        new MySqlConnectionExample();
    }

}
