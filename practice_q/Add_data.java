package practice_q;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add_data {
    private Connection con;

    public Add_data() throws ClassNotFoundException, SQLException {
    	this.con = DatabaseConnection.getConnection();
    }

    public void insertStudent(int rollNumber, String name, String level, String division, String major) {
        String sql = "INSERT INTO student (roll_number, name, Level, division, major) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, rollNumber);
            stmt.setString(2, name);
            stmt.setString(3, level);
            stmt.setString(4, division);
            stmt.setString(5, major);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student Data Inserted Successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
