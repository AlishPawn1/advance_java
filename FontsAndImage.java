import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.*;

public class FontsAndImage implements ActionListener {
	
	private JFrame jFrame;
	private JLabel label, label1;
	private JButton button;
	
	FontsAndImage(){
		jFrame = new JFrame("Fonts and Imagas");
		jFrame.setSize(600, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        label = new JLabel("This is newari");
        Font font = new Font(Font.SERIF, Font.PLAIN, 50);
        label.setFont(font);
        jFrame.add(label,BorderLayout.NORTH);

        try{
            BufferedImage image = ImageIO.read(new File("C:\\Users\\alish\\Downloads\\mission-Rdc.jpg"));
            label1 = new JLabel(new ImageIcon(image));
            jFrame.add(label1,BorderLayout.CENTER);
        }catch(Exception e){
            System.out.println(e);
        }
        
        button = new JButton("click me"); 
        jFrame.add(button, BorderLayout.SOUTH);
        button.addActionListener(this);
      
        
        jFrame.setVisible(true);
	}

    public static void main(String [] abc){
        new FontsAndImage();
    }
    
    public void actionPerformed(ActionEvent e) {
    	JOptionPane.showMessageDialog(label, "click done");
    }
}
