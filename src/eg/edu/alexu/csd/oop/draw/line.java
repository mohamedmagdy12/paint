package eg.edu.alexu.csd.oop.draw;

import javax.swing.*;
import java.awt.*;

public class line extends dummyshape {
    int endX, endY;

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public line() {

    }

    public line(int x, int y, int current, boolean first, Color color, String type, int endX, int endY) {
        super(x, y, current, first, color, type);
        this.endX = endX;
        this.endY = endY;
    }

    public line(int x, int y, Color color, int endX, int endY) {
        super(x, y, color, "line");
        this.endX = endX;
        this.endY = endY;


    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawLine(this.x, this.y, endX, endY);
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }
}