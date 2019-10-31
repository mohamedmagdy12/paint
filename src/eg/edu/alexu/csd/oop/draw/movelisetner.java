package eg.edu.alexu.csd.oop.draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class movelisetner extends MouseAdapter implements MouseListener, MouseMotionListener {
    boolean dragged = false;
      paintpanel panel;
      dummyshape n;
    public movelisetner(paintpanel panel) {
        this.panel = panel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        int x = e.getX();
        int y = e.getY();
        for(dummyshape c : panel.s) {
            dragged = c.in(x, y);
            if(dragged){
                n = c;
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        super.mouseReleased(mouseEvent);
        panel.endmovelistener();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if(dragged){
            int x = e.getX();
            int y = e.getY();
           if(n.type == "circle") {
               n.x = x - ((circle) n).diameter / 2;
               n.y = y - ((circle) n).diameter / 2;
               panel.update();
           }
           if(n.type == "square"){
               n.x = x-((square) n).getLength()/2;
               n.y = y-((square) n).getLength()/2;
               panel.update();
           }
            if(n.type == "rectangle"){
                n.x = x-((rectangle) n).getLength()/2;
                n.y = y-((rectangle) n).getWidth()/2;
                panel.update();
            }
            if(n.type == "ellipse"){
                n.x = x-((ellipse) n).getA()/2;
                n.y = y-((ellipse) n).getB()/2;
                panel.update();
            }
            if(n.type == "triangle"){
                int l = ((triangle) n).getLength();
                int w = ((triangle) n).getWidth();
                n.x = x-l/2;
                n.y = y-w/2;
                ((triangle) n).endx = n.x + l;
                ((triangle) n).endy = n.y + w;
                panel.update();
            }
        }
    }
}



