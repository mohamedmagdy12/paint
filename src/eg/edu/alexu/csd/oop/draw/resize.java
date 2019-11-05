package eg.edu.alexu.csd.oop.draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class resize extends MouseAdapter implements MouseListener, MouseMotionListener {

    boolean dragged = false;
    paintpanel panel;
    Shape n;

    public resize(paintpanel panel) {
        this.panel = panel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        int x = e.getX();
        int y = e.getY();
        for (Shape c : panel.s) {
            if(c.getClass() == circle.class){
                dragged = ((circle)c).in(x,y);
                if (dragged) {
                    n = c;
                    break;
                }
            } else if(c.getClass() == rectangle.class){
                dragged = ((rectangle)c).in(x,y);
                if (dragged) {
                    n = c;
                    break;
                }
            } if(c.getClass() == square.class){
                dragged = ((square)c).in(x,y);
                if (dragged) {
                    n = c;
                    break;
                }
            } if(c.getClass() == ellipse.class){
                dragged = ((ellipse)c).in(x,y);
                if (dragged) {
                    n = c;
                    break;
                }
            } if(c.getClass() == triangle.class){
                dragged = ((triangle)c).in(x,y);
                if (dragged) {
                    n = c;
                    break;
                }
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
            if(n.getClass()==circle.class) {
                ((circle)n).diameter = x - ((circle) n).diameter / 2;
                panel.update();
            }
            if(n.getClass()==square.class){
                ((square) n).setLength(Math.max(Math.abs(n.getPosition().x-x),Math.abs(n.getPosition().y-y)));
                panel.update();
            }
            if(n.getClass()==rectangle.class){
                ((rectangle) n).setLength(Math.abs(e.getX() - n.getPosition().x));
                ((rectangle) n).setWidth(Math.abs(e.getY() - n.getPosition().y));
                panel.update();
            }
            if(n.getClass()==ellipse.class){
                ((ellipse) n).setA(Math.abs(e.getX() - n.getPosition().x));
                ((ellipse) n).setB(Math.abs(e.getY() - n.getPosition().y));

                panel.update();
            }
            if(n.getClass()==triangle.class){
                if(x>=n.getPosition().x&&y>=n.getPosition().y){
                    ((triangle)n).endx=e.getX();
                    ((triangle)n).endy=e.getY();
                    panel.update();
                }
            }
        }
    }


}
