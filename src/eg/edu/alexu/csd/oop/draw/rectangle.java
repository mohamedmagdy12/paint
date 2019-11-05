package eg.edu.alexu.csd.oop.draw;

import java.awt.*;
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

public class rectangle implements Shape{
    private Point position;
    private Map<String, Double> properties = new HashMap();
    private Color color;
    private Color fColor;
    private int length;
    private int width;
    public boolean tryDraw;

    public rectangle() {
        properties.put("length",0D);
        properties.put("width",0D);
    }

    public rectangle(int x , int y, Color color, Color fColor, int length, int width) {
        this.position= new Point(x,y);
        this.length = length;
        this.width = width;
        this.color=color;
        this.fColor=fColor;
    }

    public rectangle(int x, int y, Color color, int length, int width){
        this.position= new Point(x,y);
        this.length=length;
        this.width=width;
        this.color = color;
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
        this.color=color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Color color) {
        this.fColor=color;
    }

    @Override
    public Color getFillColor() {
        return this.fColor;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawRect(this.position.x,this.position.y,length,width);
        g.fill3DRect(this.position.x,this.position.y,length,width,true);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public boolean in(int a,int b){
        if(a-this.position.x <= this.length && a-this.position.y >=0 && b-this.position.y <= this.width && b-this.position.y >=0)return true;
        else return false;
    }


    public void move(int x, int y) {
        position.x = x-this.getLength()/2;
        position.y = y-this.getLength()/2;
    }


}
