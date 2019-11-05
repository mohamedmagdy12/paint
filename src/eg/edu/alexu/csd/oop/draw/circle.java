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
import java.util.HashMap;
import java.util.Map;
import java.awt.*;

@XmlRootElement
public class circle implements Shape{
    public Point position;
    private Map<String, Double> properties  = new HashMap();;
    private Color color;
    private Color fColor;
    public int diameter;
    public boolean tryDraw;


    public circle() {
        properties.put("diameter",0D);
    }




    public circle(int x , int y, Color color, int diameter) {
        this.position = new Point(x,y);
        this.color = color;
        this.diameter = diameter;
        this.fColor = color;
    }

    public circle(int x , int y, Color color, Color fColor, int diameter) {
        this.position = new Point(x,y);
        this.color = color;
        this.fColor = fColor;
        this.diameter = diameter;
    }


    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
    public int getDiameter() {
        return diameter;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {

       this.properties = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return properties;
    }

    @Override
    public void setColor(Color color) {
      this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(Color color) {
       this.fColor = color;
    }

    @Override
    public Color getFillColor() {
        return fColor;
    }

    public void draw(Graphics g){
        g.setColor(this.getColor());
        g.drawOval(position.x,position.y,diameter,diameter);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }


    public boolean in(int a , int b){
        double dist = ((double)this.position.x+(double)diameter/2.0 - a)*((double)this.position.x+ (double)diameter/2 - a) + ((double)this.position.y+(double)diameter/2 -b)*((double)this.position.y+(double)diameter/2 -b);
        if(dist <= (diameter*diameter)/4)return true;
        else return false;
    }

    public void move(int x, int y){
        position .x = x - this.diameter / 2;
        position .y = y - this.diameter / 2;
    }

}
