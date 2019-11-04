package eg.edu.alexu.csd.oop.draw;

import eg.edu.alexu.csd.oop.test.DummyShape;
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
 String path = "./person.xml";
File n;
 public JAXBExample(paintpanel panel,String Path){
     this.p = panel;
     n = new File(path);
     this.path = path;
 }
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream(n);
            XMLEncoder encoder = new XMLEncoder(fos);
            for(Shape c : p.s) {
                encoder.writeObject(c);
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
                    p.s.add((Shape)decoder.readObject());
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
