import java.applet.Applet; // import java.applet.* will import everything
import java.awt.Graphics; // same for this
import java.awt.Color;

public class HelloWorld extends Applet {
    public void init(){
        //resize(200,200);
        setBackground(Color.YELLOW);
    }
    public void paint(Graphics g){

        int x=0;
        int y=0;
        String msg= "";

        x= Integer.parseInt(getParameter("xPos"));
        y= Integer.parseInt(getParameter("yPos"));
        msg= getParameter("msg");

        g.drawString(msg,x,y);
    }
}

// Note : we can write the applet code and the html code in the same file

/*
<applet code ="HelloWorld.class" width="1000" height= "1000">
<param name="xPos" value="250">
<param name="yPos" value="250">
<param name="msg" value="Hello Pulkit">
</applet>
 */
