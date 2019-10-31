package eg.edu.alexu.csd.oop.draw;

import java.awt.*;
import java.lang.Math;

public class triangle extends dummyshape {
    int endx,endy;
    public triangle(int x , int y ,Color color){
        super(x,y,color,"triangle");
        this.setColor(color);
    }



    public void draw(Graphics g){
        g.setColor(this.getColor());
        g.drawLine(x,y+Math.abs(y-endy),x+Math.abs(x-endx),y+Math.abs(y-endy));
        g.drawLine(x,y+Math.abs(y-endy),x+Math.abs(x-endx)/2,y);
        g.drawLine(x+Math.abs(x-endx),y+Math.abs(y-endy),x+Math.abs(x-endx)/2,y);
    }

    public int getWidth() {
        return Math.abs(y-endy);
    }

    public int getLength() {
        return Math.abs(x-endx);
    }


    @Override
public boolean in(int a , int b){
        return inside(this.x ,y+Math.abs(y-endy),x+Math.abs(x-endx),y+Math.abs(y-endy),x+Math.abs(x-endx)/2, this.y,a,b);
}
    boolean inside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y)
    {
        /* Calculate area of triangle ABC */
        float A = area (x1, y1, x2, y2, x3, y3);

        /* Calculate area of triangle PBC */
        float A1 = area (x, y, x2, y2, x3, y3);

        /* Calculate area of triangle PAC */
        float A2 = area (x1, y1, x, y, x3, y3);

        /* Calculate area of triangle PAB */
        float A3 = area (x1, y1, x2, y2, x, y);

        /* Check if sum of A1, A2 and A3 is same as A */
        return (A == A1 + A2 + A3);
    }
    float area(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        return (float)Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
    }
}
