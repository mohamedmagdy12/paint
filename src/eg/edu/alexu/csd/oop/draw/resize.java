package eg.edu.alexu.csd.oop.draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class resize extends MouseAdapter implements MouseListener, MouseMotionListener {
    boolean dragged = false;
    paintpanel panel;
    dummyshape n;
    public resize(paintpanel panel) {
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

        panel.endresizelistener();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if(dragged){
            int x = e.getX();
            int y = e.getY();
            if(n.type == "circle") {
                ((circle)n).diameter = x - ((circle) n).diameter / 2;

                panel.update();

            }
            if(n.type == "square"){
                ((square) n).setLength(Math.max(Math.abs(n.x-x),Math.abs(n.y-y)));
                panel.update();
            }
            if(n.type == "rectangle"){
             ((rectangle) n).setLength(Math.abs(e.getX() - n.x));
             ((rectangle) n).setWidth(Math.abs(e.getY() - n.y));
                panel.update();
            }
            if(n.type == "ellipse"){
                ((ellipse) n).setA(Math.abs(e.getX() - n.x));
                ((ellipse) n).setB(Math.abs(e.getY() - n.y));
                panel.update();
            }
            if(n.type == "triangle"){
                if(x>=n.x&&y>=n.y){
                    ((triangle)n).endx=e.getX();
                    ((triangle)n).endy=e.getY();
                    panel.update();
                }
            }
        }
    }
}
