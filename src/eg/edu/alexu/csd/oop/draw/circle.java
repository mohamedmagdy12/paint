package eg.edu.alexu.csd.oop.draw;
import javax.xml.bind.annotation.XmlAttribute;
import java.lang.Math;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.awt.*;
import javax.crypto.Cipher;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;
import java.awt.*;

@XmlRootElement
public class circle extends dummyshape{
    public int diameter;

    public circle() {
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public circle(int x, int y, Color color, int diameter) {
        super(x, y, color,"circle");
        this.diameter = diameter;
    }

    public circle(int x, int y, int current, boolean first, Color color, String type, int diameter) {
        this.x =x;
        this.y=y;
        this.current = current;
        this.first = first;
        this.color = color;
        this.type = type;
        this.diameter=
                this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
    @Override
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Color getColor() {
        return this.color;
    }


    public void draw(Graphics g){
        g.setColor(this.getColor());
        g.drawOval(this.x,this.y,diameter,diameter);
    }
    @Override
    public boolean in(int a , int b){
        double dist = ((double)this.x+(double)diameter/2.0 - a)*((double)this.x+ (double)diameter/2 - a) + ((double)this.y+(double)diameter/2 -b)*((double)this.y+(double)diameter/2 -b);
        if(dist <= (diameter*diameter)/4)return true;
        else return false;
    }
}
