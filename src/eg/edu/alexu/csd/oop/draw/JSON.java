package eg.edu.alexu.csd.oop.draw;
import java.awt.*;
import java.io.*;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;

public class    JSON {

    paintpanel p;
    File n=new File("./test.JSON");
    FileWriter file;
    FileReader read;
    FileWriter write;

    int i=1,x;

    JSONObject obj = new JSONObject();

    public JSON(paintpanel panel){
        this.p = panel;

    }

    public void save() throws IOException {

        for (Shape c : p.s) {
            obj.put(i, c);
            this.i++;
        }
        this.x=this.i-1;
        obj.put(0,this.x);


        System.out.println(obj.toJSONString());
        this.write=new FileWriter(this.n);
            write.write(obj.toJSONString());

            JFileChooser fileChooser = new JFileChooser();
            Component modalToComponent = null;
             if (fileChooser.showSaveDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
            this.n = fileChooser.getSelectedFile();
                 System.out.println(n.getPath());
        }
    }
    public void load() throws IOException {
       // System.out.println("hey "+n.toString());
        JFileChooser fileChooser = new JFileChooser();
        Component modalToComponent = null;
        if (fileChooser.showOpenDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
            this.n = fileChooser.getSelectedFile();
        }
                this.x=(int)obj.get(0);
       // System.out.printf("%d",this.x);
        for(int z=1;z<=x;z++){
            Shape q=(Shape) obj.get(z);
          p.s.add(q);
            System.out.println(p.s);
        }

    }


}

