package eg.edu.alexu.csd.oop.draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class resize extends MouseAdapter implements MouseListener, MouseMotionListener {
    boolean dragged = false;
    paintpanel panel;
    dummyshape n;
    dummyshape g;
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
                if(n.type == "circle") {
                    circle g = new circle(n.x, n.y, n.color, ((circle) n).diameter);
                    g.first = false;
                    g.current = n.current;
                    panel.history[++panel.n1] = g;

                }
                else if(n.type == "rectangle"){
                    rectangle g = new rectangle(n.x,n.y,n.color,((rectangle)n).getLength(),((rectangle)n).getWidth());
                    g.first = false;
                    g.current = n.current;
                    panel.history[++panel.n1] = g;
                }
                else if(n.type == "triangle"){
                    triangle g = new triangle(n.x,n.y,n.color);
                    g.first = false;
                    g.current = n.current;
                    panel.history[++panel.n1] = g;
                }
                else if(n.type == "square"){
                    square g = new square(n.x,n.y,n.color,((square)n).getLength());
                    g.first = false;
                    g.current = n.current;
                    panel.history[++panel.n1] = g;
                }
                else if(n.type == "ellipse"){
                    ellipse g = new ellipse(n.x,n.y,n.color,((ellipse)n).getA(),((ellipse)n).getB());
                    g.first = false;
                    g.current = n.current;
                    panel.history[++panel.n1] = g;
                }
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
                g=(circle)g;
                g = new circle(n.x, n.y, n.color, ((circle) n).diameter);
                ((circle)n).diameter = x - ((circle) n).diameter / 2;
                ((circle)g).diameter = x - ((circle) g).diameter / 2;
                panel.update();
            }
            if(n.type == "square"){
                g=new square(n.x,n.y,n.color,((square)n).getLength());
                ((square) n).setLength(Math.max(Math.abs(n.x-x),Math.abs(n.y-y)));
                ((square) g).setLength(Math.max(Math.abs(n.x-x),Math.abs(n.y-y)));
                panel.update();
            }
            if(n.type == "rectangle"){
                g = (rectangle)g;
                g = new rectangle(n.x,n.y,n.color,((rectangle)n).getLength(),((rectangle)n).getWidth());
                ((rectangle) n).setLength(Math.abs(e.getX() - n.x));
                ((rectangle) n).setWidth(Math.abs(e.getY() - n.y));
                ((rectangle) g).setLength(Math.abs(e.getX() - g.x));
                ((rectangle) g).setWidth(Math.abs(e.getY() - g.y));
                panel.update();
            }
            if(n.type == "ellipse"){
                g=new ellipse(n.x,n.y,n.color,((ellipse)n).getA(),((ellipse)n).getB());
                ((ellipse) n).setA(Math.abs(e.getX() - n.x));
                ((ellipse) n).setB(Math.abs(e.getY() - n.y));
                ((ellipse) g).setA(Math.abs(e.getX() - n.x));
                ((ellipse) g).setB(Math.abs(e.getY() - n.y));
                panel.update();
            }
            if(n.type == "triangle"){
                if(x>=n.x&&y>=n.y){
                    g=new triangle(n.x,n.y,n.color);

                    ((triangle)n).endx=e.getX();
                    ((triangle)n).endy=e.getY();
                    ((triangle)g).endx=e.getX();
                    ((triangle)g).endy=e.getY();
                    panel.update();
                }
            }
        }
    }
}
