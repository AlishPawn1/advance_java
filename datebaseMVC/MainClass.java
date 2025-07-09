package datebaseMVC;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class MainClass extends JFrame{
	private DataForm dataform;
	public MainClass() {
		dataform =new DataForm();
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new DataForm());
		add(dataform);
		setVisible(true);
		dataform.listUsers.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(dataform);
				setBackground(Color.white);
				add(new ListUsers());
				setVisible(true);
			}
		});
		dataform.UpdateUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Data inserted successfully");
			}
		});
	}
	public static void main(String[] args) {
		new MainClass();
	}
}
