package eg.edu.alexu.csd.oop.draw;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class paintpanel extends JPanel {
    public  mouselisetner h;
    public  movelisetner g;
    int last = 0;
    dummyshape n;
    List<dummyshape>  s = new LinkedList<dummyshape>();

    public void addshape(dummyshape c) {
        s.add(c);
    }
    public void update(){
        repaint();
    }
    public void endlistener(){
        this.removeMouseListener(h);
        this.removeMouseMotionListener(h);
    }
    public void endmovelistener(){
        this.removeMouseListener(g);
        this.removeMouseMotionListener(g);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for(dummyshape c : s){
            c.draw(graphics);
            if(c.type=="circle"){

            n =(circle)c;
            }
            else if (c.type=="rectangle"){

                n=(rectangle)c;
            }
            else if (c.type=="ellipse"){

                n=(ellipse)c;
            }
        }
    }
}
