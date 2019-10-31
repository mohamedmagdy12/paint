package eg.edu.alexu.csd.oop.draw;

import java.awt.*;

public class rectangle extends dummyshape {
    private int length;
    private int width;
    public rectangle(int x, int y, Color color,int length,int width){
        super(x,y,color,"rectangle");
        this.length=length;
        this.width=width;

    }
    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fill3DRect(this.x,this.y,length,width,true);
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
    @Override
    public boolean in(int a,int b){
        if(a-this.x <= this.length && a-this.x >=0 && b-this.y <= this.width && b-this.y >=0)return true;
        else return false;
    }
}
