import java.awt.*;
import javax.swing.*;

public class PanelTest extends JFrame {
    
    PanelTest(){
    	setTitle("Panel Grid");
        setSize(500, 500);
        getContentPane().setBackground(Color.red);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3)); 
        getPanels();

        setVisible(true);
    }

    public void getPanels(){
        for(int i = 0; i < 9; i++) {
            JPanel panel = new JPanel();
            getButtonComponets(panel);
            add(panel);
        }
    }

    private void getButtonComponets(JPanel panel) {
        for(int i = 0; i < 3; i++) {
            panel.add(new JButton("Button " + i));
        }
    }
    public static void main(String[] args) {
        new PanelTest();
    }   
}
