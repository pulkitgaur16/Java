import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.*;

public class Swing extends JFrame {
    
    public Swing(){
        super("My first GUI");
    }

    public static void main(String args[]){
        // JFrame : to create a container window
        Swing frame= new Swing();
        
        //frame.getContentPane().setBackground(Color.gray);

        // JLabel: to add text or image in the JFrame
        // JLabel label = new JLabel();
        // label.setText("Hello");
        //ImageIcon car= new ImageIcon("supra.jpg");
        //label.setIcon(car);
        // label.setHorizontalTextPosition(JLabel.CENTER);
        // label.setVerticalTextPosition(JLabel.BOTTOM); // these are wrt image
        // label.setHorizontalAlignment(JLabel.CENTER);
        // label.setVerticalAlignment(JLabel.TOP);
        // label.setForeground(Color.MAGENTA);
        // label.setFont(new Font("MV Boli", Font.ITALIC, 20));
        // label.setBackground(Color.black);
        // label.setOpaque(true);
        // Border border= BorderFactory.createLineBorder(Color.yellow, 4);
        // label.setBorder(border); 
        //label.setBounds(0,0,350,350);

        // JPanel: a GUI component that function as container to hold other components
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0,0,250,250);

        JPanel grayPanel = new JPanel();
        grayPanel.setBackground(Color.gray);
        grayPanel.setBounds(250,0,250,250);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(0,250,250,250);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.yellow);
        yellowPanel.setBounds(250,250,250,250);

        //frame.add(label); 
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        ImageIcon img= new ImageIcon("supra.jpg");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // frame.pack(); // sets size of frame which is enough to display label
        // frame.setResizable(false);
        frame.add(redPanel);
        frame.add(grayPanel);
        frame.add(bluePanel);
        frame.add(yellowPanel);
        //redPanel.add(label);
    }
}
