package Utilitaire;






import org.json.simple.JSONObject;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mathieu on 04/03/2015.
 */
public class Serie {



    private List data;
    private String name;
    private String type;
    private int yAxis;
    public Serie(String name)
    {
        this.type="line";
        this.name=name;
        this.data=new ArrayList();
        this.yAxis=0;
    }

    public Serie(String name, String type)
    {
        this.type=type;
        this.name=name;
        this.data=new ArrayList();
    }

    public Serie(String name, String type,int yAxis)
    {
        this.type=type;
        this.name=name;
        this.data=new ArrayList();
        this.yAxis=yAxis;
    }
    public void add(String s)
    {
        this.data.add(s);
    }
    public void add(Object s)
    {
        this.data.add(s);
    }
    public void add(int n)
    {
        this.data.add(n);
    }
    public void add(float n)
    {
        this.data.add(n);
    }
    public void add(java.sql.Date d)
    {
        this.data.add(d);
    }
    public void add(Timestamp d)
    {
        this.data.add(d);
    }

    public List getData() {
        return data;
    }

    public String getName() {
        return name;
    }


    public JSONObject json()  {
        JSONObject obj = new JSONObject();
        obj.put("type", this.type);
        obj.put("yAxis", this.yAxis);
        obj.put("name", this.name);
        obj.put("data", this.data);

        System.out.print(obj);
        return obj;
    }
}
