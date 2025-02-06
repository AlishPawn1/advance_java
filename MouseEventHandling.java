import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MouseEventHandling extends JFrame implements MouseListener {

    private JTextField textField;
	
	public MouseEventHandling() {
		setTitle("Mouse Listerner Frame");
		setSize(600, 600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.red);
        textField = new JTextField();
        textField.setBounds(100, 100, 100, 30);
        add(textField);
        setVisible(true);
        textField.addMouseListener(this);
	}
	
	public static void main(String [] args) {
		new MouseEventHandling();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		getContentPane().setBackground(Color.gray);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		getContentPane().setBackground(Color.green);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		getContentPane().setBackground(Color.blue);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		getContentPane().setBackground(Color.black);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		getContentPane().setBackground(Color.lightGray);
		
	}

}
