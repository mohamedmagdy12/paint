package eg.edu.alexu.csd.oop.draw;

import sun.awt.image.ImageWatched;

import java.awt.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class JAXBExample {
 paintpanel p;
File n;
 public JAXBExample(paintpanel panel){
     this.p = panel;
     n = new File("./person.xml");
 }
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream(n);
            XMLEncoder encoder = new XMLEncoder(fos);
            for(dummyshape s : p.s) {
                if(s.type == "circle")
                    encoder.writeObject(new circle(s.x,s.y,s.current,s.first,s.color,s.type,((circle)s).diameter));
                else if(s.type == "square")
                    encoder.writeObject(new square(s.x,s.y,s.current,s.first,s.color,s.type,((square)s).getLength()));
                else if(s.type == "line")
                    encoder.writeObject(new line(s.x,s.y,s.current,s.first,s.color,s.type,((line)s).endX,((line)s).endY));
                else if(s.type == "ellipse")
                    encoder.writeObject(new ellipse(s.x,s.y,s.current,s.first,s.color,s.type,((ellipse)s).getA(),((ellipse)s).getB()));
                else if(s.type == "rectangle")
                    encoder.writeObject(new rectangle(s.x,s.y,s.current,s.first,s.color,s.type,((rectangle)s).getLength(),((rectangle)s).getWidth()));
                else if(s.type == "triangle")
                    encoder.writeObject(new triangle(s.x,s.y,s.current,s.first,s.color,s.type,((triangle)s).endx,((triangle)s).endy));

            }
            encoder.close();
            fos.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void load() {
        try {
            FileInputStream fis = new FileInputStream(n);
            XMLDecoder decoder = new XMLDecoder(fis);
            try {
                while (true) {
                    p.s.add((dummyshape) decoder.readObject());
                }
            }catch(ArrayIndexOutOfBoundsException e){
            }

            decoder.close();
            fis.close();
            p.load();
        }catch (IOException ex){
               ex.printStackTrace();
        }
    }
}
