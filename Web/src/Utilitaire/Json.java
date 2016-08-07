package Utilitaire;








import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mathieu on 04/03/2015.
 */
public class Json {


    private List<Serie> series;
    private String name;
    private String chemin;

    public Json(String name)
    {
        this.name=name;
        this.chemin="";
        this.series=new ArrayList();
    }

    public Json(String name, String chemin)
    {
        this.name=name;
        this.chemin=chemin;
        this.series=new ArrayList();
    }

    public void add(Serie s)
    {
        this.series.add(s);
    }


    public void genererJson()  {
        File file = new File(this.chemin+this.name);
        int compteur=0;
        String json="[";

        for(Serie s:series)
        {
            if(compteur!=0)
                json+=",";
            json+=s.json();
            compteur++;
        }
        json+="]";
        try {
            if (!file.exists())
                file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur: impossible de créer le fichier");
        }

    }

    public String genererJsonString()  {

        int compteur=0;
        String json="[";

        for(Serie s:series)
        {
            if(compteur!=0)
                json+=",";
            json+=s.json();
            compteur++;
        }
        json+="]";
        return json;

    }





}
