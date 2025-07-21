import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StudentDBGUI extends JFrame {
    JTextField cidField, nameField, emailField, ageField, addressField;
    DefaultTableModel tableModel;
    JTable table;

    final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    final String DB_USER = "root";
    final String DB_PASS = "";

    Connection conn;

    public StudentDBGUI() {
        setTitle("Student Database");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + ex.getMessage());
            System.exit(1);
        }

        // Create Table in DB if it doesn't exist
        createStudentTable();

        // Input Panel
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("CID:"));
        cidField = new JTextField(); panel.add(cidField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField(); panel.add(nameField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField(); panel.add(emailField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField(); panel.add(ageField);

        panel.add(new JLabel("Address:"));
        addressField = new JTextField(); panel.add(addressField);

        JButton addButton = new JButton("Add Student");
        panel.add(addButton);

        add(panel, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel(new String[]{"CID", "Name", "Email", "Age", "Address"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Load data
        loadStudents();

        // Add button listener
        addButton.addActionListener(e -> addStudent());

        setVisible(true);
    }

    // Method to create student table if not exists
    private void createStudentTable() {
        try{
            String createSQL = """
                CREATE TABLE IF NOT EXISTS student (
                    cid INT PRIMARY KEY,
                    name VARCHAR(100),
                    email VARCHAR(100),
                    age INT,
                    address VARCHAR(200)
                );
            """;
            Statement stmt = conn.createStatement();
            stmt.execute(createSQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error creating table: " + ex.getMessage());
        }
    }

    // Insert data
    private void addStudent() {
        try{
            String sql = "INSERT INTO student (cid, name, email, age, address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(cidField.getText()));
            ps.setString(2, nameField.getText());
            ps.setString(3, emailField.getText());
            ps.setInt(4, Integer.parseInt(ageField.getText()));
            ps.setString(5, addressField.getText());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Student added!");
            loadStudents();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Insert Error: " + ex.getMessage());
        }
    }

    // Load records to JTable
    private void loadStudents() {
        tableModel.setRowCount(0); // clear table
        try {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM student");
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("cid"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age"),
                        rs.getString("address")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Load Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentDBGUI();
    }
}
