import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

public class Swing extends JFrame implements ActionListener {
    static JButton btn1, btn2, btn3;
    
    public Swing(){
        super("My first GUI");
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==btn1){
            System.out.println("Button 1 clicked");
            btn1.setEnabled(false); // disables the button after 1 click
        }
        if(e.getSource()==btn2){
            System.out.println("Button 2 clicked");
        }
        if(e.getSource()==btn3){
            System.out.println("Button 3 clicked");
        }
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

        // JButton
        btn1= new JButton("Button 1");
        btn1.setBounds(250,10,100,50);
        btn1.setFocusable(false);
        btn2= new JButton("Button 2");
        btn2.setBounds(250,100,100,50);
        btn2.setFocusable(false);
        btn3= new JButton();
        btn3.setBounds(250,250,200,200);
        btn3.setFocusable(false);
        ImageIcon icon= new ImageIcon("java.png");
        btn3.setIcon(icon);

        btn1.addActionListener(frame); // in bracket comes the object which receives the event
        btn2.addActionListener(frame);
        btn3.addActionListener(frame);

        //frame.add(label); 
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        ImageIcon img= new ImageIcon("supra.jpg");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // frame.pack(); // sets size of frame which is enough to display label
        // frame.setResizable(false);
        // frame.add(redPanel);
        // frame.add(grayPanel);
        // frame.add(bluePanel);
        // frame.add(yellowPanel);
        //redPanel.add(label);

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
    }
}
