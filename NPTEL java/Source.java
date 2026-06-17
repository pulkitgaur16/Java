import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;


public class Source extends JFrame{
        JButton btnOpenNextWindow;

        public Source(){
            initComponents();
        }
        
        private void initComponents(){
            setTitle("Source window");
            setSize(500,500);
            setLayout(null);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            btnOpenNextWindow= new JButton("Open destination Window");
            btnOpenNextWindow.setBounds(50,50,200,40);
            btnOpenNextWindow.setFocusable(false);

            btnOpenNextWindow.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e){
                dispose();
                Destination destination = new Destination();
            }
            });

            add(btnOpenNextWindow);
            setVisible(true);

        }
    }
