package eg.edu.alexu.csd.oop.draw;
import java.awt.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.jws.soap.SOAPBinding;
import javax.swing.*;

public class    JSON {

    paintpanel p;
    File n;
    FileWriter file;
    FileReader read;
    FileWriter write;

    int i=1,x;

    JSONObject obj = new JSONObject();

    public JSON(paintpanel panel , String path){
        this.p = panel;
        n = new File(path);
    }

    public void save(String path) throws IOException {

        for (Shape c : p.s) {
            obj.put(i, c);
            this.i++;
        }
        this.x=this.i-1;
        obj.put(0,this.x);

        System.out.println(obj.toJSONString());
        this.write=new FileWriter(n);
        write.write(obj.toJSONString());
        System.out.println(n.toString());
    }

    public void load(String path) throws IOException, ParseException {
        read = new FileReader(n);
        System.out.println(n.toString());
        JSONParser P=new JSONParser();
        obj=(JSONObject)P.parse(read);

        this.x=(int)obj.get(0);
       System.out.printf("ss%d",this.x);
        for(int z=1;z<=x;z++){
            Shape q=(Shape) obj.get(z);
            p.s.add(q);
            System.out.println(p.s);
        }

    }


}

