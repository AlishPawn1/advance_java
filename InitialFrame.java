import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class InitialFrame extends JFrame {
    public static void main(String[] args) {
        new InitialFrame();
    }

    private JLabel login, username, userpassword, gender, hobbies, country;
    private JTextField uname;
    private JButton submit;
    private JCheckBox music, sports;
    private JRadioButton male, female, other;
    private JPasswordField password;

    public InitialFrame() {
        setTitle("New Frame");
        setLayout(null);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.red);
        login = new JLabel("Login User");
        login.setBounds(250, 50, 100, 40);

        username = new JLabel("Username:");
        username.setBounds(150, 100, 100, 30);
        uname = new JTextField();
        uname.setBounds(250, 100, 150, 30);

        userpassword = new JLabel("Password:");
        userpassword.setBounds(150, 150, 100, 30);
        password = new JPasswordField();
        password.setBounds(250, 150, 150, 30);

        gender = new JLabel("Gender:");
        gender.setBounds(150, 200, 100, 30);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        male.setBounds(250, 200, 70, 30);
        female.setBounds(320, 200, 80, 30);
        other.setBounds(400, 200, 70, 30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        hobbies = new JLabel("Hobbies:");
        hobbies.setBounds(150, 250, 100, 30);
        music = new JCheckBox("Music");
        sports = new JCheckBox("Sports");
        music.setBounds(250, 250, 80, 30);
        sports.setBounds(330, 250, 80, 30);

        country = new JLabel("Country:");
        country.setBounds(150, 300, 100, 30);
        String[] countries = {"Nepal", "India", "USA", "UK"};
        JComboBox<String> countryBox = new JComboBox<>(countries);
        countryBox.setBounds(250, 300, 150, 30);

        submit = new JButton("Submit");
        submit.setBounds(250, 350, 100, 40);

        add(login);
        add(username);
        add(uname);
        add(userpassword);
        add(password);
        add(gender);
        add(male);
        add(female);
        add(other);
        add(hobbies);
        add(music);
        add(sports);
        add(country);
        add(countryBox);
        add(submit);

        setVisible(true);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = uname.getText();
                String pass = new String(password.getPassword());
        
                String selectedGender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : other.isSelected() ? "Other" : "Not Specified";

                String selectedHobbies = (music.isSelected() ? "Music " : "") + (sports.isSelected() ? "Sports" : "");
                selectedHobbies = selectedHobbies.trim().isEmpty() ? "None" : selectedHobbies;

                String selectedCountry = (String) countryBox.getSelectedItem();
        
                System.out.println("Username: " + name);
                System.out.println("Password: " + pass);
                System.out.println("Gender: " + selectedGender);
                System.out.println("Hobbies: " + selectedHobbies);
                System.out.println("Country: " + selectedCountry);
                
                add(new PanelTest());
            }
        });
        
    }
}
