package eg.edu.alexu.csd.oop.draw;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class paintpanel extends JPanel {
    public  mouselisetner h;


    List<dummyshape>  s = new LinkedList<dummyshape>();

    public void addshape(dummyshape c) {
        s.add(c);
        repaint();
        this.removeMouseListener(h);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for(dummyshape c : s){
            c.draw(graphics);
        }
    }
}
