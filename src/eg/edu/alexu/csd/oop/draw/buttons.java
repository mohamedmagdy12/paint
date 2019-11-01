package eg.edu.alexu.csd.oop.draw;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class buttons extends JPanel{
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9,btn10;
    private paintpanel panel;
    List<dummyshape> s;
    JColorChooser jcc;
    public buttons(paintpanel panel) {
       jcc = new JColorChooser();
        this.btn1 = new JButton("circle");
        this.add(btn1);
        this.panel = panel;
        s=panel.s;

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = jcc.showDialog(null , "please select a color", Color.red);
                mouselisetner h = new mouselisetner(panel,"circle",c);
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
    }







}