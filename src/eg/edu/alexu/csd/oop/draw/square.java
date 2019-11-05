package eg.edu.alexu.csd.oop.draw;

import java.awt.*;
import java.util.Map;

public class square implements Shape{
    public Point position;
    private Map<String, Double> properties;
    private Color color;
    private Color fColor;
    private int length;

    public square() {
    }

    public square(int x, int y, Color color,Color fColor, int length) {
        this.position = new Point(x,y);
        this.color = color;
        this.fColor = fColor;
        this.length = length;
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
        g.fill3DRect(position.x,position.y,length,length,true);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean in(int a,int b){
        if(a-this.position.x <= this.length && a-this.position.x >=0 && b-this.position.y <= this.length && b-this.position.y >=0)return true;
        else return false;
    }


    public void move(int x, int y) {
        position.x = x-this.getLength()/2;
        position.y = y-this.getLength()/2;
    }


}
