package eg.edu.alexu.csd.oop.draw;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class repaint extends MouseAdapter implements MouseListener, MouseMotionListener {
    boolean dragged = false;
    paintpanel panel;
    dummyshape n;
    dummyshape G;
    Color color;
    public repaint(paintpanel panel,Color color) {
        this.panel = panel;
        this.color=color;
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
                    g = new circle(n.x, n.y, n.color, ((circle) n).diameter);
                    g.first = false;
                    g.current = n.current;
                    n.color=color;
                    g.color = color;
                    G=((circle)g);
                }
                else if(n.type == "rectangle"){

                    rectangle g = new rectangle(n.x,n.y,n.color,((rectangle)n).getLength(),((rectangle)n).getWidth());
                    g.first = false;
                    g.current = n.current;
                    panel.history[++panel.n1] = g;
                     g = new rectangle(n.x,n.y,n.color,((rectangle)n).getLength(),((rectangle)n).getWidth());
                    g.first = false;
                    g.current = n.current;
                    n.color=color;
                    g.color=color;
                    G=((rectangle)g);
                }
                else if(n.type == "triangle"){

                    triangle g = new triangle(n.x,n.y,n.color);
                    g.setEndx(((triangle)n).getEndx());
                    g.setEndy(((triangle)n).getEndy());
                    g.first = false;
                    g.current = n.current;
                    panel.history[++panel.n1] = g;
                     g = new triangle(n.x,n.y,n.color);
                    g.setEndx(((triangle)n).getEndx());
                    g.setEndy(((triangle)n).getEndy());
                    g.first = false;
                    g.current = n.current;
                    n.color=color;
                    g.color=color;
                    G=((triangle)g);
                }
                else if(n.type == "square"){

                    square g = new square(n.x,n.y,n.color,((square)n).getLength());
                    g.first = false;
                    g.current = n.current;
                    panel.history[++panel.n1] = g;
                     g = new square(n.x,n.y,n.color,((square)n).getLength());
                    g.first = false;
                    g.current = n.current;
                    n.color=color;
                    g.color=color;
                    G=((square)g);
                }
                else if(n.type == "ellipse"){
                    ellipse g = new ellipse(n.x,n.y,n.color,((ellipse)n).getA(),((ellipse)n).getB());
                    g.first = false;
                    g.current = n.current;
                    panel.history[++panel.n1] = g;
                     g = new ellipse(n.x,n.y,n.color,((ellipse)n).getA(),((ellipse)n).getB());
                    g.first = false;
                    g.current = n.current;
                    n.color=color;
                    g.color=color;
                    G=((ellipse)g);
                }
                panel.update();
                break;
            }
        }
    }


    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        super.mouseReleased(mouseEvent);

        panel.endrepaintlistener();
    }


}
