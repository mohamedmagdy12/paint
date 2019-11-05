package eg.edu.alexu.csd.oop.draw;

import java.awt.*;
import java.lang.Math;
import java.util.Map;

public class triangle implements  Shape {
    public Point position;
    private Map<String, Double> properties;
    private Color color;
    private Color fColor;
    int endx,endy;




    public int getEndx() {
        return endx;
    }

    public void setEndx(int endx) {
        this.endx = endx;
    }

    public int getEndy() {
        return endy;
    }

    public void setEndy(int endy) {
        this.endy = endy;
    }

    public triangle() {

    }


    public triangle(int x , int y, Color color, int endX,int endY) {
        this.position = new Point(x,y);
        this.color = color;
        this.fColor = color;
        this.endx = endX;
        this.endy = endY;
    }

    public triangle(int x , int y, Color color, Color fColor,int endX,int endY) {
        this.position = new Point(x,y);
        this.color = color;
        this.fColor = fColor;
        this.endx = endX;
        this.endy = endY;
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

    public int getWidth() {
        return Math.abs(position.y-endy);
    }

    public int getLength() {
        return Math.abs(position.x-endx);
    }



    public boolean in(int a , int b){
        return inside(this.position.x ,position.y+Math.abs(position.y-endy),position.x+Math.abs(position.x-endx),position.y+Math.abs(position.y-endy),position.x+Math.abs(position.x-endx)/2, this.position.y,a,b);
    }


    public void move(int x, int y) {
        int l = this.getLength();
        int w = this.getWidth();
        position.x = x-l/2;
        position.y = y-w/2;
        this.endx = position.x + l;
       this.endy = position.y + w;
    }

    public void draw(Graphics g){
        int x = position.x;
        int y = position.y;
        g.setColor(this.getColor());
        g.drawLine(x,y+Math.abs(y-endy),x+Math.abs(x-endx),y+Math.abs(y-endy));
        g.drawLine(x,y+Math.abs(y-endy),x+Math.abs(x-endx)/2,y);
        g.drawLine(x+Math.abs(x-endx),y+Math.abs(y-endy),x+Math.abs(x-endx)/2,y);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }


    boolean inside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y)
    {

        float A = area (x1, y1, x2, y2, x3, y3);


        float A1 = area (x, y, x2, y2, x3, y3);


        float A2 = area (x1, y1, x, y, x3, y3);


        float A3 = area (x1, y1, x2, y2, x, y);


        return (A == A1 + A2 + A3);
    }
    float area(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        return (float)Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
    }



}
