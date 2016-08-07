package Utilitaire;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malioret on 24/03/2015.
 */
public class MyArray {

    private List chaine;


    public MyArray()
    {
        chaine=new ArrayList();
    }

    public void add(String s)
    {
        chaine.add(s);
    }

    public void add(int i)
    {
        chaine.add(i);
    }
    public void add(Object i)
    {
        chaine.add(i);
    }

    public String toString()
    {
        String s=" [";
        for(int i=0;i<chaine.size();i++)
        {
            if(chaine.get(i) instanceof String)
                s+="\"";
            s+=chaine.get(i);
            if(chaine.get(i) instanceof String)
                s+="\"";
            if(i<chaine.size()-1)
                s+=",";
        }
        s+="] ";
        return s;
    }

}
