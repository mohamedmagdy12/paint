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
        g.setColor(this.getColor());
        g.fillOval(this.x,this.y,a,b);
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
    @Override
    public boolean  in(int A , int B){
        double h=this.x+a/2;
        double k=this.y+b/2;
        if((Math.pow(A-h,2)/Math.pow(a/2,2)+Math.pow(B-k,2)/Math.pow(b/2,2))<=1){
            return true;
        }
        else return false;
    }
}
