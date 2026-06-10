import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Scribble extends Frame
        implements MouseListener, MouseMotionListener {

    private int last_x, last_y;

    public Scribble() {
        addMouseListener(this);
        addMouseMotionListener(this);

        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Scribble();
    }

    public void mousePressed(MouseEvent e) {
        last_x = e.getX();
        last_y = e.getY();
    }

    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        int x = e.getX();
        int y = e.getY();

        g.drawLine(last_x, last_y, x, y);

        last_x = x;
        last_y = y;
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
}

/*
<html>
<body>
<applet code ="Scribble.class" width="1000" height= "1000">
</applet>
</body>
</html>
 */