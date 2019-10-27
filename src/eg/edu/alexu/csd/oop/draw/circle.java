package eg.edu.alexu.csd.oop.draw;


import java.awt.*;

public class circle extends dummyshape{
    private int diameter;

    public circle(int x, int y, Color color, int diameter) {
        super(x, y, color);
        this.diameter = diameter;
    }


    public void draw(Graphics g){
        g.setColor(Color.black);
        g.drawOval(this.x,this.y,diameter,diameter);
    }
}
