package practice_q;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class View_details {
    private Connection con;

    public View_details() throws ClassNotFoundException, SQLException {
    	this.con = DatabaseConnection.getConnection();
    }
    
    public void listUser() {
        String division = "Distinction";
        String sql = "SELECT * FROM student WHERE division = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, division);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                int rollNumber = rs.getInt("roll_number");
                String name = rs.getString("name");
                String level = rs.getString("Level");
                String div = rs.getString("division");
                String major = rs.getString("major");

                System.out.println("ID: " + id + ", Roll Number: " + rollNumber + ", Name: " + name + 
                                   ", Level: " + level + ", Division: " + div + ", Major: " + major);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
