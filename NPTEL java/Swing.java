import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Swing extends JFrame {
    
    public Swing(){
        super("My first GUI");
    }

    public static void main(String args[]){
        // JFrame : to create a container window
        Swing frame= new Swing();
        
        //frame.getContentPane().setBackground(Color.gray);

        // JLabel: to add text or image in the JFrame
        JLabel label = new JLabel();
        label.setText("Hello");
        //ImageIcon car= new ImageIcon("supra.jpg");
        //label.setIcon(car);
        // label.setHorizontalTextPosition(JLabel.CENTER);
        // label.setVerticalTextPosition(JLabel.BOTTOM); // these are wrt image
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setForeground(Color.MAGENTA);
        label.setFont(new Font("MV Boli", Font.ITALIC, 20));
        frame.add(label);

        frame.setSize(500,500);
        frame.setVisible(true);
        ImageIcon img= new ImageIcon("supra.jpg");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
