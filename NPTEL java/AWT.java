import java.awt.*;
import java.awt.event.*;
public class AWT {
    public static void main(String str[]){
        // Frame frame = new Frame("Frame in Pulkit's PC");
        // Panel panel= new Panel();
        // frame.setSize(500, 500);
        // frame.setBackground(Color.blue);
        // frame.setLayout(null);
        // panel.setSize(100,100);
        // panel.setBackground(Color.yellow);
        // frame.add(panel);
        // frame.setVisible(true);

        Frame f= new Frame("My Frame");

        Label l1= new Label("First");
        Label l2= new Label("Second");

        TextField t1= new TextField(10);
        TextField t2= new TextField(10);

        Button b= new Button("OK");

        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(b);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                String temp= t1.getText();
                t1.setText(t2.getText());
                t2.setText(temp);
            }
        });

        f.setLayout(new FlowLayout());
        f.setSize(350,350);
        f.setVisible(true);
    } 
}
