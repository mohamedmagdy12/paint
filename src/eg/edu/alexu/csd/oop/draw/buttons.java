package eg.edu.alexu.csd.oop.draw;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class buttons extends JPanel{
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private paintpanel panel;

    public buttons(paintpanel panel) {
        this.btn1 = new JButton("circle");
        this.add(btn1);
        this.panel = panel;
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mouselisetner h = new mouselisetner(panel,"circle");
                panel.addMouseListener(h);
                panel.h = h;
            }

        });

        this.btn2 = new JButton("square");
        this.add(btn2);
        this.panel = panel;
        btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mouselisetner h = new mouselisetner(panel,"square");
                panel.addMouseListener(h);
                panel.h = h;
            }

        });
        this.btn3 = new JButton("rectangle");
        this.add(btn3);
        this.panel = panel;
        btn3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mouselisetner h = new mouselisetner(panel,"rectangle");
                panel.addMouseListener(h);
                panel.h = h;
            }

        });
        this.btn4 = new JButton("ellipse");
        this.add(btn4);
        this.panel = panel;
        btn4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mouselisetner h = new mouselisetner(panel,"ellipse");
                panel.addMouseListener(h);
                panel.h = h;
            }

        });
    }


}
