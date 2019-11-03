package eg.edu.alexu.csd.oop.draw;

import javax.swing.*;

public class paintframe {
    public static void main(String[] args) {
       JFrame f = new JFrame();
        f.setSize(900,650);
        paintpanel c = new paintpanel();
        f.setContentPane(c);
        f.add(new buttons(c));
        f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
        f.setVisible(true);

    }
}
