package Test;

import Modele.Seance;
import Modele.Sexe;
import Modele.Utilisateur;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UtilisateurTest {
    private Utilisateur a;
    private Utilisateur b;
    private Utilisateur c;
    private Utilisateur d;


    @Before
    public void setUp() throws Exception {
        a = new Utilisateur();
        a.setIdUtilisateur(1);
        a.setNom("Mathieu");
        a.setPrenom("Lioret");
        a.setMail("mathieu.lioret@hotmail.fr");
        
        b=new Utilisateur();
        d=new Utilisateur();
        c=new Utilisateur();
        d.setIdUtilisateur(1);

        
    }

    @After
    public void tearDown() throws Exception {
        a= null;
        b=null;
        c=null;
    }

    @Test
    public void testChargerInformations() throws Exception {
        b.chargerInformations("mat","motdepasse");
        assertEquals(b.getNom(), a.getNom());
        assertEquals(b.getPrenom(), a.getPrenom());
        assertEquals(b.getMail(), a.getMail());
        assertEquals(b.getIdUtilisateur(),a.getIdUtilisateur());
    }

   @Test
   public void testDureePlanEntrainement(){
       
       float sum = a.dureePlanEntrainement(a.getIDPlanEntrainementActif());
       float sumTest = d.dureePlanEntrainement(d.getIDPlanEntrainementActif());

       assertEquals(sum, sumTest, sum);
       
   }
    
   @Test
   public void testGetSeances(){

       List<Seance> seances = a.getSeances();
       List<Seance> seances2 = d.getSeances();
       
       for(int i = 0; i < seances.size(); i++){
           
           assertEquals(seances.get(i).getTemps(), seances2.get(i).getTemps(), seances.get(i).getTemps());
           assertEquals(seances.get(i).getRepetition(), seances2.get(i).getRepetition(), seances.get(i).getRepetition());
           assertEquals(seances.get(i).getDistance(), seances2.get(i).getDistance(), seances.get(i).getDistance());
           assertEquals(seances.get(i).getIdExercice(), seances2.get(i).getIdExercice(), seances.get(i).getIdExercice());
       }
       
   }
    
   @Test
   public void testGetSeancesPlanEntrainementActif(){

       List<Seance> seances = a.getSeancesPlanEntrainementActif();
       List<Seance> seances2 = d.getSeancesPlanEntrainementActif();

       for(int i = 0; i < seances.size(); i++){

           assertEquals(seances.get(i).getTemps(), seances2.get(i).getTemps(), seances.get(i).getTemps());
           assertEquals(seances.get(i).getRepetition(), seances2.get(i).getRepetition(), seances.get(i).getRepetition());
           assertEquals(seances.get(i).getDistance(), seances2.get(i).getDistance(), seances.get(i).getDistance());
           assertEquals(seances.get(i).getIdExercice(), seances2.get(i).getIdExercice(), seances.get(i).getIdExercice());
       }
       
   }
}