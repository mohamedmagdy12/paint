package eg.edu.alexu.csd.oop.draw;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_HARD_LIGHTPeer;
import eg.edu.alexu.csd.oop.test.DummyShape;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.List;

public class paintpanel extends JPanel implements DrawingEngine {
    public mouselisetner h;
    public movelisetner g;
    public resize x;
    public repaint t;
    // dummyshape arr[] = new dummyshape[100];
    int n1 = 0;
    int present = 0;
    int current = 0;
    Shape n;
    public List<Shape> s = new LinkedList<Shape>();
    // public  dummyshape shapes[] = new dummyshape[100];
    int n2 = 0;
    public List<Shape> arr[] = new LinkedList[100];


    public void addshapee(Shape c) {
        s.add(c);
    }

    public void update() {
        repaint();
    }

    public void endlistener() {
      /*  history[++n1] = h.h;
        redo[n1] = h.h;
        h.h.first = true;
        h.h.current = h.c.current;
           current++;
        */
        this.removeMouseListener(h);
        this.removeMouseMotionListener(h);
        takecopy();
    }

    public void endmovelistener() {
       /* redo[n1] = g.g;
        g.g.current = g.n.current;
        g.g.first = false;
        */

        this.removeMouseListener(g);
        this.removeMouseMotionListener(g);
        takecopy();
    }


    public void endresizelistener() {
        /*redo[n1] = x.g;
        x.g.current = x.n.current;
        x.g.first = false;*/
        this.removeMouseListener(x);
        this.removeMouseMotionListener(x);
        takecopy();
    }

    public void endrepaintlistener() {
       /* redo[n1] = t.G;
        t.G.current = t.n.current;
        t.G.first = false;
        */
        this.removeMouseListener(t);
        this.removeMouseMotionListener(t);
        takecopy();
    }

    /*
        @Override
        public void refresh(Graphics canvas) {
            repaint();
        }

        @Override
        public void addShape(Shape shape) {
            s.add((dummyshape) shape);
        }

        @Override
        public void removeShape(Shape shape) {
          s.remove(shape);
        }

        @Override
        public void updateShape(Shape oldShape, Shape newShape) {
           s.set(s.indexOf(oldShape),(dummyshape) newShape);
        }

        @Override
        public Shape[] getShapes() {
            return (dummyshape[])s.toArray();
        }

        @Override
        public List<Class<? extends Shape>> getSupportedShapes() {
            List<Class<? extends Shape>> classList = new ArrayList<Class<? extends Shape>>();

            classList.add(circle.class);
            classList.add(triangle.class);
            classList.add(square.class);
            classList.add(rectangle.class);
            classList.add(line.class);
            classList.add(ellipse.class);
            return classList;
        }
        */
    @Override
    public void undo() {
        System.out.println(s.size());
        if (n1 != 0) {
            n1--;
            takecopy2(n1);
            repaint();
        }
    }

    @Override
    public void redo() {
        System.out.println(s.size());
        if (arr[n1 + 1] != null) {
            n1++;
            takecopy2(n1);
            repaint();
        }
    }

    @Override
    public void save(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(path));
            XMLEncoder encoder = new XMLEncoder(fos);
            for (Shape c : s) {
                encoder.writeObject(c);
            }
            encoder.close();
            fos.close();

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void load(String path) {
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            XMLDecoder decoder = new XMLDecoder(fis);
            try {
                while (true) {
                    s.add((Shape) decoder.readObject());
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }

            decoder.close();
            fis.close();
            //load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void load() {
        repaint();
    }


    public void takecopy() {
        n1++;
        arr[0] = new LinkedList<Shape>();
        arr[n1] = new LinkedList<Shape>();
        arr[n1 + 1] = null;
        for (Shape c : s) {
            if (c.getClass() == circle.class) {
                circle g = new circle(c.getPosition().x, c.getPosition().y, c.getColor(), c.getFillColor(), ((circle) c).getDiameter());
                arr[n1].add(g);
            } else if (c.getClass() == rectangle.class) {
                arr[n1].add(new rectangle(c.getPosition().x, c.getPosition().y, c.getColor(), ((rectangle) c).getLength(), ((rectangle) c).getWidth()));
            } else if (c.getClass() == square.class) {
                arr[n1].add(new square(c.getPosition().x, c.getPosition().y, c.getColor(), c.getFillColor(), ((square) c).getLength()));
            } else if (c.getClass() == line.class) {
                arr[n1].add(new line(c.getPosition().x, c.getPosition().y, c.getColor(), c.getFillColor(), ((line) c).endX, ((line) c).endY));
            } else if (c.getClass() == ellipse.class) {
                arr[n1].add(new ellipse(c.getPosition().x, c.getPosition().y, c.getColor(), c.getFillColor(), ((ellipse) c).getA(), ((ellipse) c).getB()));
            } else if (c.getClass() == triangle.class) {
                arr[n1].add(new triangle(c.getPosition().x, c.getPosition().y, c.getColor(), c.getFillColor(), ((triangle) c).getEndx(), ((triangle) c).getEndy()));
            } else {
                arr[n1].add(c);
            }
        }

    }

    public void takecopy2(int h) {
        s = new LinkedList<Shape>();
        for (Shape c : arr[h]) {
            if (c.getClass() == circle.class) {
                circle g = new circle(c.getPosition().x, c.getPosition().y, c.getColor(), c.getFillColor(), ((circle) c).getDiameter());
                s.add(g);
            } else if (c.getClass() == rectangle.class) {
                s.add(new rectangle(c.getPosition().x, c.getPosition().y, c.getColor(), ((rectangle) c).getLength(), ((rectangle) c).getWidth()));
            } else if (c.getClass() == square.class) {
                s.add(new square(c.getPosition().x, c.getPosition().y, c.getColor(), c.getFillColor(), ((square) c).getLength()));
            } else if (c.getClass() == line.class) {
                s.add(new line(c.getPosition().x, c.getPosition().y, c.getColor(), c.getFillColor(), ((line) c).endX, ((line) c).endY));
            } else if (c.getClass() == ellipse.class) {
                s.add(new ellipse(c.getPosition().x, c.getPosition().y, c.getColor(), c.getFillColor(), ((ellipse) c).getA(), ((ellipse) c).getB()));
            } else if (c.getClass() == triangle.class) {
                s.add(new triangle(c.getPosition().x, c.getPosition().y, c.getColor(), c.getFillColor(), ((triangle) c).getEndx(), ((triangle) c).getEndy()));
            } else {
                s.add(c);
            }
        }

    }

    public void saveas() {
        JFileChooser fileChooser = new JFileChooser();
        Component modalToComponent = null;
        if (fileChooser.showSaveDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            save(file.getPath());
        }
    }

    public void saveasjson() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        Component modalToComponent = null;
        if (fileChooser.showSaveDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            JSON s = new JSON(this, file.getPath());
            s.save(file.getPath());
        }
    }

    public void loadfrom() {
        JFileChooser fileChooser = new JFileChooser();
        Component modalToComponent = null;
        if (fileChooser.showOpenDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            load(file.getPath());
        }
    }

    public void loadfromJson() throws IOException, ParseException {
        JFileChooser fileChooser = new JFileChooser();
        Component modalToComponent = null;
        if (fileChooser.showOpenDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            JSON s = new JSON(this, file.getPath());
            s.load(file.getPath());
        }
    }


    public void paint(Graphics graphics) {
        super.paint(graphics);
        for (Shape c : s) {
            c.draw(graphics);
        }
    }


    @Override
    public void refresh(Graphics canvas) {
         paint(canvas);
    }

    @Override
    public void addShape(Shape shape) {
        s.add(shape);
        takecopy();
    }

    @Override
    public void removeShape(Shape shape) {
        s.remove(shape);
        takecopy();
    }

    @Override
    public void updateShape(Shape oldShape, Shape newShape) {
        s.set(s.indexOf(oldShape), newShape);
    }

    @Override
    public Shape[] getShapes() {

        Shape y[] = new Shape[s.size()];
        int i = 0;
        for (Shape c : s)
            y[i++] = c;

        return y;

    }

    @Override
    public List<Class<? extends Shape>> getSupportedShapes() throws MalformedURLException, ClassNotFoundException {
        List<Class<? extends Shape>> classList = new ArrayList<Class<? extends Shape>>();
        classList.add(circle.class);
        classList.add(rectangle.class);
        classList.add(triangle.class);
        classList.add(square.class);
        classList.add(line.class);
        classList.add(ellipse.class);

        File dir = new File("C:\\Users\\magdy\\drawoop\\RoundRectangle.jar");
        URL loadPath = dir.toURI().toURL();
        URL[] classUrl = new URL[]{loadPath};
        ClassLoader cl = new URLClassLoader(classUrl);
        Class loadedClass = cl.loadClass("eg.edu.alexu.csd.oop.draw.RoundRectangle"); // must be in package.class name format
        classList.add(loadedClass);


        return classList;
    }

    public Class plugin() throws MalformedURLException, ClassNotFoundException {
        File file = null;
        JFileChooser fileChooser = new JFileChooser();
        Component modalToComponent = null;
        if (fileChooser.showOpenDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        File dir = file;
        URL loadPath = dir.toURI().toURL();
        URL[] classUrl = new URL[]{loadPath};
        ClassLoader cl = new URLClassLoader(classUrl);
        Class loadedClass = cl.loadClass("eg.edu.alexu.csd.oop.draw.RoundRectangle"); // must be in package.class name format
        return loadedClass;
    }


}