package datebaseMVC;

import javax.swing.JFrame;

public class MainClass extends JFrame{
	
	public MainClass() {
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new DataForm());
		setVisible(true);
	}

	public static void main(String[] args) {

		new MainClass();
	}

}
