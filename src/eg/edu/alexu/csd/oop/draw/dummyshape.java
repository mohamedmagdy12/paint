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
import java.util.Map;
@XmlRootElement
public class dummyshape implements Shape {
    int x;
    int y;
    int current;
    boolean first;
    Color color;
    String type;

    public dummyshape(){

    };

    public dummyshape(int x, int y, int current, boolean first, Color color, String type) {
        this.x = x;
        this.y = y;
        this.current = current;
        this.first = first;
        this.color = color;
        this.type = type;
    }


    public dummyshape(int x, int y, Color color, String type) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.type = type;
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
    public void setPosition(Point position) {
        this.x = position.x;
        this.y = position.y;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Point getPosition() {
        Point p = new Point(this.x,this.y);
        return p;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {

    }

    @Override
    public Map<String, Double> getProperties() {
        return null;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Color color) {

    }

    @Override
    public Color getFillColor() {
        return null;
    }

    @Override
    public void draw(Graphics g) {

    }
    public boolean in(int a,int b){
        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }
}
