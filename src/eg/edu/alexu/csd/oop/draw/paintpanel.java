package eg.edu.alexu.csd.oop.draw;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class paintpanel extends JPanel {
    public  mouselisetner h;
    public  movelisetner g;
    public resize x;
    public repaint t;
    dummyshape arr[] = new dummyshape[100];
    int n1 = -1;
    int present =0;
    int current = 0;
    dummyshape n;
    public List<dummyshape>  s = new LinkedList<dummyshape>();
    public dummyshape[] history = new dummyshape[100];
    public dummyshape[] redo = new dummyshape[100];




    public void addshape(dummyshape c) {
        c.current = current;
        s.add(c);
    }

    public void update(){
        repaint();
    }
    public void endlistener(){
        history[++n1] = h.h;
        redo[n1] = h.h;
        h.h.first = true;
        h.h.current = h.c.current;
        current++;
        this.removeMouseListener(h);
        this.removeMouseMotionListener(h);
    }
    public void endmovelistener(){
        this.removeMouseListener(g);
        this.removeMouseMotionListener(g);
    }
    public void endresizelistener(){
        redo[n1] = x.g;
        x.g.current = x.n.current;
        x.g.first = false;
        this.removeMouseListener(x);
        this.removeMouseMotionListener(x);
    }
    public void endrepaintlistener() {
        redo[n1] = t.G;
        t.G.current = t.n.current;
        t.G.first = false;
        this.removeMouseListener(t);
        this.removeMouseMotionListener(t);
    }
    public void undo() {
        System.out.println(n1);
        if(n1 >=0) {
            if (history[n1].first == false) {
                s.set(history[n1].current, history[n1]);
            } else {
                s.remove(history[n1].current);
                current--;
            }
            n1--;
        }
        repaint();


    }

    public void redo(){
        if(redo[n1+1] != null ) {
            System.out.println(n1);
            n1++;
            if (redo[n1].first == false) {
                s.set(redo[n1].current, redo[n1]);
            } else {
                s.add(redo[n1]);
            }
        }
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for(dummyshape c : s){
            c.draw(graphics);

        }
    }


}