package eg.edu.alexu.csd.oop.draw;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class movelisetner extends MouseAdapter implements MouseListener, MouseMotionListener {
    boolean dragged = false;
      paintpanel panel;
    public movelisetner(paintpanel panel) {
        this.panel = panel;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        int x = e.getX();
        int y = e.getY();
        dragged = panel.n.in(x,y);
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
            panel.n.x = x - panel.n.diameter/2;
            panel.n.y = y - panel.n.diameter/2;
            panel.update();
        }
    }
}



