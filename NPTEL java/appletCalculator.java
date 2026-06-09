import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class appletCalculator extends Applet implements ActionListener{
    String msg= " ";
    int v1,v2,result;
    TextField t1;
    Button b[]= new Button[10];
    Button add, sub, mul, div, clear, mod, EQ;
    char OP;
    public void init(){
        Color k= new Color(120,89,90);
        setBackground(k);
        t1= new TextField(10);
        GridLayout g1= new GridLayout(5,4);
        setLayout(g1);
        add(t1);
        for (int i = 0; i < b.length; i++) {
            b[i]= new Button(""+i);
        }
        add= new Button("+");
        sub= new Button("-");
        mul= new Button("X");
        div= new Button("/");
        mod= new Button("%");
        clear= new Button("CLEAR");
        EQ= new Button("=");
        t1.addActionListener(this);
        for (int i = 0; i < b.length; i++) {
            add(b[i]);
        }
        add(add);
        add(sub);
        add(mul);
        add(div);
        add(mod);
        add(clear);
        add(EQ);

        for (int i = 0; i < b.length; i++) {
            b[i].addActionListener(this);
        }

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        mod.addActionListener(this);
        clear.addActionListener(this);
        EQ.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
    String str = ae.getActionCommand();
    System.out.println("Button clicked: " + str); // Keep this line for debugging.

    if (str.equals("CLEAR")) {
        t1.setText("");
        return;
    }
    
    if (Character.isDigit(str.charAt(0))) {
        t1.setText(t1.getText() + str);
    } else if (str.equals("+")) {
        v1 = Integer.parseInt(t1.getText());
        OP = '+';
        t1.setText("");
    } else if (str.equals("-")) {
        v1 = Integer.parseInt(t1.getText());
        OP = '-';
        t1.setText("");
    } else if (str.equals("X")) {
        v1 = Integer.parseInt(t1.getText());
        OP = 'X';
        t1.setText("");
    } else if (str.equals("/")) {
        v1 = Integer.parseInt(t1.getText());
        OP = '/';
        t1.setText("");
    } else if (str.equals("%")) {
        v1 = Integer.parseInt(t1.getText());
        OP = '%';
        t1.setText("");
    } else if (str.equals("=")) {
        v2 = Integer.parseInt(t1.getText());
        if (OP == '+') {
            result = v1 + v2;
        } else if (OP == '-') {
            result = v1 - v2;
        } else if (OP == 'X') {
            result = v1 * v2;
        } else if (OP == '/') {
            result = v1 / v2;
        } else if (OP == '%') {
            result = v1 % v2;
        }
        t1.setText("" + result);
    }
}
}

/*
<html>
    <body>
        <applet code ="appletCalculator.class" width="500" height= "500">
        </applet>
    </body>
</html>
 */