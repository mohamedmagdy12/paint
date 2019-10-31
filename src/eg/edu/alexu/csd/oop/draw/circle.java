package eg.edu.alexu.csd.oop.draw;
import java.lang.Math;

import java.awt.*;

public class circle extends dummyshape{
    public int diameter;

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public circle(int x, int y, Color color, int diameter) {
        super(x, y, color,"circle");
        this.diameter = diameter;
    }


    public void draw(Graphics g){
        g.setColor(this.getColor());
        g.drawOval(this.x,this.y,diameter,diameter);
    }

   public boolean in(int a , int b){
        double dist = ((double)this.x+(double)diameter/2.0 - a)*((double)this.x+ (double)diameter/2 - a) + ((double)this.y+(double)diameter/2 -b)*((double)this.y+(double)diameter/2 -b);
        if(dist <= (diameter*diameter)/4)return true;
        else return false;
   }
}
