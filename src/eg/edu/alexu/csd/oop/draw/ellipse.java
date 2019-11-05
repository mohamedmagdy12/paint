package eg.edu.alexu.csd.oop.draw;
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
import java.awt.geom.Ellipse2D;

public class ellipse implements Shape{
    public Point position;
    private Map<String, Double> properties = new HashMap();;
    private Color color;
    private Color fColor;
    private int a;
    private int b;
    public boolean tryDraw;

    public ellipse() {
        properties.put("a",0D);
        properties.put("b",0D);
    }


    public ellipse(int x , int y, Color color, int a,int b) {
        this.position = new Point(x,y);
        this.color = color;
        this.fColor = color;
        this.a = a;
        this.b = b;
    }

    public ellipse(int x , int y, Color color, Color fColor,int a,int b) {
        this.position = new Point(x,y);
        this.color = color;
        this.fColor = fColor;
        this.a = a;
        this.b = b;
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

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fillOval(this.position.x,this.position.y,a,b);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
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

    public boolean  in(int A , int B){
        double h=this.position.x+a/2;
        double k=this.position.y+b/2;
        if((Math.pow(A-h,2)/Math.pow(a/2,2)+Math.pow(B-k,2)/Math.pow(b/2,2))<=1){
            return true;
        }
        else return false;
    }


    public void move(int x, int y) {
        position.x = x-this.getA()/2;
        position.y = y-this.getB()/2;
    }


}
