import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SampleGraphics extends JComponent {
	public void paint(Graphics g) {
		Graphics2D graphics = (Graphics2D) g; 
		graphics.drawRect(10, 10, 100, 100);
		graphics.drawOval(300, 20, 100, 100);
		
		int x [] = {400, 400, 500};
		int y [] = {100,200, 200};
		graphics.setColor(Color.green);
		graphics.fillPolygon(x,y,3);
		
		int x1 []  = {300, 400, 450, 350, 250};
        int y1 []  = {200, 200, 300, 400, 300};
        graphics.setColor(Color.MAGENTA);
        graphics.fillPolygon(x1, y1, 5);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("this is graphics");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new SampleGraphics());
		frame.setSize(800, 800);
		frame.setVisible(true);
	}
}
