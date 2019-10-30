package eg.edu.alexu.csd.oop.draw;

import java.awt.*;

public class square extends dummyshape {
    private int length;
    public square(int x, int y, Color color,int length) {
        super(x, y, color,"square");
        this.length = length;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(this.x,this.y,length,length);
    }

    public void setLength(int length) {
        this.length = length;
    }
}
