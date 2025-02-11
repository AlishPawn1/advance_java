package datebaseMVC;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DataForm extends JPanel implements ActionListener, FormViewInterface{
	
	private JLabel name, email, height, phone;
	private JTextField tname, temail, theight, tphone;
	private JButton submit;
	public JButton listUsers;
	private FormController controller;
	
	public DataForm() {
		setLayout(null);
		
		controller = new FormController();
		
		name = new JLabel("Full Name");
		name.setBounds(300, 200, 100, 30);
		tname = new JTextField();
		tname.setBounds(400, 200, 100, 30);
		
		email = new JLabel("Email");
		email.setBounds(300, 250, 100, 30);
		temail = new JTextField();
		temail.setBounds(400, 250, 100, 30);
		
		height = new JLabel("Your Height");
		height.setBounds(300, 300, 100, 30);
		theight = new JTextField();
		theight.setBounds(400, 300, 100, 30);
		
		phone = new JLabel("Phone");
		phone.setBounds(300, 350, 100, 30);
		tphone = new JTextField();
		tphone.setBounds(400, 350, 100, 30);
		
		submit = new JButton("Submit");
		submit.setBounds(400, 400, 100, 30);
		
		listUsers = new JButton("showUserList");
		listUsers.setBounds(400, 450, 100, 30);
		 
		
		add(name);add(tname);add(email);add(temail);add(height);
		add(theight);add(phone);add(tphone);add(submit);add(listUsers);
		
		submit.addActionListener(this);
//		listUsers.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit) {
			String name = tname.getText().toString();
			String email = temail.getText().toString();
			String phone = tphone.getText().toString();
			String height = theight.getText().toString();
			
			if(name.isEmpty()) {
				tname.setBackground(Color.red);
			}else if(email.isEmpty()) {
				temail.setBackground(Color.red);
			}else if(phone.isEmpty()) {
				tphone.setBackground(Color.red);
			}else if(height.isEmpty()) {
				theight.setBackground(Color.red);
			}else {
				UserData user = new UserData(name,email, Float.parseFloat(height), Long.parseLong(phone) );
				
				// call form controller submit method
				controller.submitData(user, this);
			}
		}
	}

	@Override
	public void onSucess() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(submit, "Data inserted successfully");
		tname.setText("");
		temail.setText("");
		theight.setText("");
		tphone.setText("");
		
	}

	@Override
	public void onFailure(String reason) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(submit, reason);
		
	}

	
}
