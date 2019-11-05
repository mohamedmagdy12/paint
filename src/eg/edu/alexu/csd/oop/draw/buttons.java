package eg.edu.alexu.csd.oop.draw;

import org.json.simple.parser.ParseException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class buttons extends JPanel {
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    public JButton btn9, btn10, btn11, btn12, btn13,btn14,btn15;
    private paintpanel panel;
    Class t;
    List<Shape> s;
    JColorChooser jcc;

    public buttons(paintpanel panel) {
        jcc = new JColorChooser();
        this.btn1 = new JButton("circle");
        this.add(btn1);
        this.panel = panel;
        s = panel.s;


        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = jcc.showDialog(null, "please select a color", Color.red);
                mouselisetner h = new mouselisetner(panel, "circle", c);
                panel.addMouseListener(h);
                panel.addMouseMotionListener(h);
                panel.h = h;
            }

        });




        this.btn3 = new JButton("rectangle");
        this.add(btn3);
        this.panel = panel;
        btn3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = jcc.showDialog(null , "please select a color", Color.red);
                mouselisetner h = new mouselisetner(panel,"rectangle",c);
                panel.addMouseListener(h);
                panel.addMouseMotionListener(h);
                panel.h = h;
            }

        });

        this.btn4 = new JButton("ellipse");
        this.add(btn4);
        this.panel = panel;
        btn4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = jcc.showDialog(null , "please select a color", Color.red);
                mouselisetner h = new mouselisetner(panel,"ellipse",c);
                panel.addMouseListener(h);
                panel.addMouseMotionListener(h);
                panel.h = h;
            }

        });

        this.btn5 = new JButton("square");
        this.add(btn5);
        this.panel = panel;
        btn5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = jcc.showDialog(null , "please select a color", Color.red);
                mouselisetner h = new mouselisetner(panel,"square",c);
                panel.addMouseListener(h);
                panel.addMouseMotionListener(h);
                panel.h = h;
            }

        });

        this.btn6 = new JButton("line");
        this.add(btn6);
        this.panel = panel;
        btn6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = jcc.showDialog(null , "please select a color", Color.red);
                mouselisetner h = new mouselisetner(panel,"line",c);
                panel.addMouseListener(h);
                panel.addMouseMotionListener(h);
                panel.h = h;
            }

        });

        this.btn7 = new JButton("triangle");
        this.add(btn7);
        this.panel = panel;
        btn7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = jcc.showDialog(null , "please select a color", Color.red);
                mouselisetner h = new mouselisetner(panel,"triangle",c);
                panel.addMouseListener(h);
                panel.addMouseMotionListener(h);
                panel.h = h;
            }

        });
        this.btn2 = new JButton("move");
        this.add(btn2);
        this.panel = panel;
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                movelisetner h = new movelisetner(panel);
                panel.addMouseListener(h);
                panel.addMouseMotionListener(h);
                panel.g= h;
            }

        });

        this.btn10 = new JButton("resize");
        this.add(btn10);
        this.panel = panel;
        btn10.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resize h = new resize(panel);
                panel.addMouseListener(h);
                panel.addMouseMotionListener(h);
                panel.x= h;
            }

        });
        this.btn13 = new JButton("repaint");
        this.add(btn13);
        this.panel = panel;
        btn13.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = jcc.showDialog(null , "please select a color", Color.red);
                repaint x=new repaint(panel,c);
                panel.addMouseListener(x);
                panel.addMouseMotionListener(x);
                panel.t= x;

            }

        });

        this.btn8 = new JButton("undo");
        this.add(btn8);
        this.panel = panel;
        btn8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               panel.undo();
            }

        });

        this.btn9 = new JButton("redo");
        this.add(btn9);
        this.panel = panel;
        btn9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.redo();
            }

        });

        this.btn11 = new JButton("save");
        this.add(btn11);
        this.panel = panel;
        btn11.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               panel.save("./person.xml");
                panel.saveas();
               panel.repaint();

               /*
                try {
                    panel.saveasjson();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                */


            }

        });


        this.btn12 = new JButton("load");
        this.add(btn12);
        this.panel = panel;
        btn12.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.load("./person.xml");
                panel.loadfrom();
                panel.repaint();
               /*
                try {
                   panel.loadfromJson();
                    panel.update();
                } catch (IOException | ParseException ex) {
                    ex.printStackTrace();
                }

                */
            }



        });
        this.btn15 = new JButton("plugin");
        btn14 = new JButton("Round Rectangle");
        this.add(btn15);
        this.panel = panel;
        btn15.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    t=panel.plugin();
                   if(t.getName().equals("eg.edu.alexu.csd.oop.draw.RoundRectangle")){
                       panel.add(btn14);
                   }
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });


        btn14.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = jcc.showDialog(null , "please select a color", Color.red);
                Color h = jcc.showDialog(null , "please select a fill color", Color.red);
                String x = JOptionPane.showInputDialog("enter position x");
                String y = JOptionPane.showInputDialog("enter position y");
                String y1 = JOptionPane.showInputDialog("enter width");
                String y2 = JOptionPane.showInputDialog("enter length");
                String y3 = JOptionPane.showInputDialog("enter arcWidth");
                String y4 = JOptionPane.showInputDialog("enter arclength");
              RoundRectangle R = new RoundRectangle();
              R.setColor(c);
              R.setFillColor(h);
              R.setPosition(new Point(Integer.parseInt(x),Integer.parseInt(y)));
              Map<String, Double> p = new HashMap<>();
                p.put("Width", Double.parseDouble(y1));
                p.put("Length", Double.parseDouble(y2));
                p.put("ArcWidth", Double.parseDouble(y3));
                p.put("ArcLength", Double.parseDouble(y4));
              R.setProperties(p);
              panel.addShape(R);
              panel.update();
            }

        });



    }






}


