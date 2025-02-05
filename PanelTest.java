import java.awt.*;
import javax.swing.*;

public class PanelTest extends JFrame {
    private JPanel panel1, panel2;
    
    PanelTest(){
        setSize(500, 500);
        getContentPane().setBackground(Color.red);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1 = new JPanel();
        getButtonComponets(panel1);
        panel2 = new JPanel();  
        getButtonComponets(panel2);

        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void getButtonComponets(JPanel panel) {
        for(int i = 0; i < 10; i++) {
            panel.add(new JButton("Button " + i));
        }
    }
    public static void main(String[] args) {
        new PanelTest();
    }   
}
