package eg.edu.alexu.csd.oop.draw;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class repaint extends MouseAdapter implements MouseListener, MouseMotionListener {

    boolean dragged = false;
    paintpanel panel;
    Shape n;
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
        for (Shape c : panel.s) {
            if(c.getClass() == circle.class){
                dragged = ((circle)c).in(x,y);
                if (dragged) {
                    n = c;
                    n.setColor(color);
                    panel.update();
                    break;
                }
            } else if(c.getClass() == rectangle.class){
                dragged = ((rectangle)c).in(x,y);
                if (dragged) {
                    n = c;
                    n.setColor(color);
                    panel.update();
                    break;
                }
            } if(c.getClass() == square.class){
                dragged = ((square)c).in(x,y);
                if (dragged) {
                    n = c;
                    n.setColor(color);
                    panel.update();
                    break;
                }
            } if(c.getClass() == ellipse.class){
                dragged = ((ellipse)c).in(x,y);
                if (dragged) {
                    n = c;
                    n.setColor(color);
                    panel.update();
                    break;
                }
            } if(c.getClass() == triangle.class){
                dragged = ((triangle)c).in(x,y);
                if (dragged) {
                    n = c;
                    n.setColor(color);
                    panel.update();
                    break;
                }
            }
        }
    }


    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        super.mouseReleased(mouseEvent);

        panel.endrepaintlistener();
    }


}
