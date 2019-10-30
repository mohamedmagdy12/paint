package eg.edu.alexu.csd.oop.draw;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ellipse extends dummyshape {
    private int a;
    private int b;
    public  ellipse(int x, int y, Color color, int a, int b){
        super(x,y,color,"ellipse");
        this.a=a;
        this.b=b;

    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        Graphics2D x=(Graphics2D) g;
        x.setColor(Color.black);
        x.draw(new Ellipse2D.Double(this.x,this.y,a,b));
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
}
