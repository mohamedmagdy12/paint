package eg.edu.alexu.csd.oop.draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class movelisetner extends MouseAdapter implements MouseListener, MouseMotionListener {

    boolean dragged = false;
    paintpanel panel;
    Shape n;
    Shape g;

    public movelisetner(paintpanel panel) {
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
        panel.endmovelistener();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if (dragged) {
            int x = e.getX();
            int y = e.getY();
            if(n.getClass() == circle.class){
                ((circle)n).move(x,y);
                panel.update();
            }else if(n.getClass() == rectangle.class){
                ((rectangle)n).move(x,y);
                panel.update();
            }if(n.getClass() == ellipse.class){
                ((ellipse)n).move(x,y);
                panel.update();
            }if(n.getClass() == square.class){
                ((square)n).move(x,y);
                panel.update();
            }if(n.getClass() == triangle.class){
                ((triangle)n).move(x,y);
                panel.update();
            }

        }
    }


}

