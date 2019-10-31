package eg.edu.alexu.csd.oop.draw;

import java.awt.*;
import java.util.Map;

public class dummyshape implements Shape {
    int x;
    int y;
    private Color color;
     String type;

    public dummyshape(){};
    public dummyshape(int x,int y,Color color,String type) {
        this.color = color;
        this.x = x;
        this.y =y;
        this.type=type;
    }

    @Override
    public void setPosition(Point position) {
        this.x = position.x;
        this.y = position.y;
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
