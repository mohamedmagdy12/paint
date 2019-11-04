package eg.edu.alexu.csd.oop.draw;
import eg.edu.alexu.csd.oop.test.DummyShape;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mouselisetner extends MouseAdapter implements MouseListener, MouseMotionListener {
    int size =0;
    public Shape c;
    public Shape h;
    private String type;
    private paintpanel panel;
    int startx;
    int starty;
    int minx;
    int miny;
    int maxx;
    int maxy;
    Color color;

    public mouselisetner(paintpanel panel, String type,Color color) {
        super();
        this.color = color;
        this.panel = panel;
        this.type = type;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        startx = e.getX();
        starty = e.getY();
        if(type.equals("circle")){
           c= new circle(startx,starty,color,color,0);
        }
        else if(type.equals("rectangle")){
            c=new rectangle(startx,starty,color,0,0);
        }

        else if(type.equals("ellipse")){
            c=new ellipse(startx,starty,color,0,0);
        }

        else if (type.equals("square")){
            c=new square(startx,starty,color,color,0);
        }

        else if (type.equals("line")){
            c=new line(startx,starty,color,startx,starty);
        }

        else if (type.equals("triangle")){
            c=new triangle(startx,starty,color,color,startx,starty);
        }

        panel.addshapee(c);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if (type.equals("circle")) {

            minx = Math.min(e.getX(), startx);

            miny = Math.min(e.getY(), starty);
            maxx = Math.max(e.getX(), startx);
            maxy = Math.max(e.getY(), starty);

            size = Math.min(maxx - minx, maxy - miny);
            if (minx < startx) {
                minx = startx - size;
            }
            if (miny < starty) {
                miny = starty - size;
            }
            c.setPosition(new Point(minx, miny));
            ((circle) c).setDiameter(size);
            panel.update();
        } else if (type.equals("rectangle")) {
            if (e.getX() >= startx) {
                ((rectangle) c).setLength((e.getX() - startx));

            } else {
                c.setPosition(new Point(e.getX(), c.getPosition().y));
                ((rectangle) c).setLength(Math.abs(e.getX() - startx));
            }

            if (e.getY() >= starty) {
                ((rectangle) c).setWidth((e.getY() - starty));

            } else {
                c.setPosition(new Point(c.getPosition().x, e.getY()));
                ((rectangle) c).setWidth(Math.abs(e.getY() - starty));
            }
            panel.update();
        } else if (type.equals("ellipse")) {
            if (e.getX() >= startx) {
                ((ellipse) c).setA((e.getX() - startx));

            } else {
                c.setPosition(new Point(e.getX(), c.getPosition().y));
                ((ellipse) c).setA(Math.abs(e.getX() - startx));
            }

            if (e.getY() >= starty) {
                ((ellipse) c).setB((e.getY() - starty));
            } else {
                c.setPosition(new Point(c.getPosition().x, e.getY()));
                ((ellipse) c).setB(Math.abs(e.getY() - starty));
            }
            panel.update();
        } else if (type.equals("square")) {
            if (e.getX() >= startx) {
                ((square) c).setLength((e.getX() - startx));
            } else {
                c.setPosition(new Point(e.getX(), c.getPosition().y));
                ((square) c).setLength(Math.abs(e.getX() - startx));
            }


            panel.update();
        } else if (type.equals("line")) {
            ((line) c).setEndX(e.getX());
            ((line) c).setEndY(e.getY());
            panel.update();
        } else if (type.equals("triangle")) {
            if (e.getX() >= startx) {
                ((triangle) c).endx = e.getX();

            } else {
                c.setPosition(new Point(e.getX(), c.getPosition().y));
                ((triangle) c).endx = startx;
            }

            if (e.getY() >= starty) {
                ((triangle) c).endy = e.getY();
            } else {
                c.setPosition(new Point(c.getPosition().y, e.getY()));
                ((triangle) c).endy = starty;
            }
            panel.update();
        }


    }


    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        panel.endlistener();
    }

    public String getType() {
        return type;
    }
    /*
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if(type.equals("circle")) {
            String x= (String) JOptionPane.showInputDialog(null,"Please Enter Radius:",
                   "Radius",JOptionPane.QUESTION_MESSAGE);

            int t=Integer.parseInt(x);
            panel.addshape(new circle(e.getX() - t , e.getY() -t , Color.BLACK , 2*t));
}


        else if(type.equals("square"))
        {  String x= (String) JOptionPane.showInputDialog(null,"Please Enter Length:",
                "Length of Square",JOptionPane.QUESTION_MESSAGE);
            int t=Integer.parseInt(x);
            panel.addshape(new square(e.getX() - t/2 , e.getY() -t/2 , Color.BLACK , t));}


       else if(type.equals("rectangle"))
        {  JTextField getX = new JTextField();
            JTextField getY = new JTextField();
            Object[] message = {
                    "X:", getX,
                    "Y:", getY
            };
            int x = JOptionPane.showConfirmDialog(null, message, "Width and Height",
                    JOptionPane.OK_CANCEL_OPTION);
            int X=Integer.parseInt(getX.getText());
            int Y=Integer.parseInt(getY.getText());
            panel.addshape(new rectangle(e.getX() - X/2 , e.getY() -Y/2 , Color.BLACK , X,Y));}

        else if(type.equals("ellipse"))
        {  JTextField getX = new JTextField();
            JTextField getY = new JTextField();
            Object[] message = {
                    "X:", getX,
                    "Y:", getY
            };
            int x = JOptionPane.showConfirmDialog(null, message, "Width and Height for ellipse",
                    JOptionPane.OK_CANCEL_OPTION);
            int X=Integer.parseInt(getX.getText());
            int Y=Integer.parseInt(getY.getText());
            panel.addshape(new ellipse(e.getX() - X/2 , e.getY() -Y/2 , Color.BLACK , X,Y));}
    }
}
*/
/*
JTextField getX = new JTextField();
    JTextField getY = new JTextField();
    Object[] message = {
            "X:", getX,
            "Y:", getY
    };
int x = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
 */


}