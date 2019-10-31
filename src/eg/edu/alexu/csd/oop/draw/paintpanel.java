package eg.edu.alexu.csd.oop.draw;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class paintpanel extends JPanel {
    public  mouselisetner h;
    public  movelisetner g;
    dummyshape arr[] = new dummyshape[100];
    int n1 = 0;
    int last = 0;
    dummyshape n;
    public List<dummyshape>  s = new LinkedList<dummyshape>();


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
    public void undo() {
        if (s.size() == 0) return;
        else {
            dummyshape h = s.remove(s.size() - 1);
            arr[n1++] = h;
            repaint();
        }
    }

        public void redo(){
        if(n1 != 0) {
            s.add(arr[--n1]);
            repaint();
        }
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
