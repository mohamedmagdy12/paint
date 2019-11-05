package eg.edu.alexu.csd.oop.draw;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class line implements Shape {
    public Point position;
    private Map<String, Double> properties = new HashMap();;
    private Color color;
    private Color fColor;
    int endX, endY;
    public boolean tryDraw;
    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public line() {
        properties.put("endX",0D);
        properties.put("endY",0D);
    }

    public line(int x , int y, Color color, int endX,int endY) {
        this.position = new Point(x,y);
        this.color = color;
        this.fColor = color;
        this.endX = endX;
        this.endY = endY;
    }

    public line(int x , int y, Color color, Color fColor,int endX,int endY) {
        this.position = new Point(x,y);
        this.color = color;
        this.fColor = fColor;
        this.endX = endX;
        this.endY = endY;
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
        g.drawLine(this.position.x, this.position.y, endX, endY);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }


    public boolean in(int a, int b) {
        return false;
    }


    public void move(int x, int y) {
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }


}