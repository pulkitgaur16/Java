import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;


public class Destination extends JFrame implements ActionListener{
        JButton btnOpenPrevWindow;

        public Destination(){
            initComponents();
        }
        
        private void initComponents(){
            setTitle("Destination window");
            setSize(500,500);
            setLayout(null);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            btnOpenPrevWindow= new JButton("Open Source Window");
            btnOpenPrevWindow.setBounds(50,50,200,40);
            btnOpenPrevWindow.setFocusable(false);
            btnOpenPrevWindow.addActionListener(this);

            add(btnOpenPrevWindow);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent e){
            if(e.getSource() == btnOpenPrevWindow){
                Source source= new Source();
                dispose();
            }
        }
    }