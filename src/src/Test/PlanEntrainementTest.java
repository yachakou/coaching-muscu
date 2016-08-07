package Test;

import Modele.AbstractExercice;
import Modele.Aerobis;
import Modele.Anareobis;
import Modele.PlanEntrainement;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlanEntrainementTest {
    
    private PlanEntrainement planEntrainement;
    private AbstractExercice exercice;
    private List<AbstractExercice> exercices = new ArrayList<AbstractExercice>();
    private List<AbstractExercice>exercices2 = new ArrayList<AbstractExercice>();

    
    @Test
    public void testLoadPlanEntrainementActif() throws Exception {

        planEntrainement = new PlanEntrainement(5,30);
        int idUtilisateur = 1;
        
        PlanEntrainement planEntrainementTest = new PlanEntrainement();
        planEntrainementTest.loadPlanEntrainementActif(idUtilisateur);
        
        assertEquals(planEntrainement.getDifficulte(), planEntrainementTest.getDifficulte(), 5);
        assertEquals(planEntrainement.getDuree(), planEntrainementTest.getDuree(),30);
    }

    @Test
    public void testLoadPlanEntrainement() throws Exception {
        
        planEntrainement = new PlanEntrainement(5,30);
        int idPlanEntrainement = 1;
        
        PlanEntrainement planEntrainementTest = new PlanEntrainement();
        planEntrainementTest.loadPlanEntrainement(idPlanEntrainement);
        
        assertEquals(planEntrainement.getDifficulte(), planEntrainementTest.getDifficulte(), 5);
        assertEquals(planEntrainement.getDuree(), planEntrainementTest.getDuree(), 30);

    }

    @Test
    public void testLoadExercicesPlanEntrainement() throws Exception {

        planEntrainement = new PlanEntrainement(2,20);
        int idUtilisateur = 1;
        int idPlanEntrainement = 3;
       
        /*exercices = (List<AbstractExercice>) new Anareobis("test2", "test",30,20);
        exercices = (List<AbstractExercice>) new Aerobis("test", "monTest",20,30);*/

        PlanEntrainement planEntrainementTest = new PlanEntrainement();
        
        planEntrainementTest.loadPlanEntrainementActif(idUtilisateur);
        planEntrainementTest.loadExercicesPlanEntrainement();
        System.out.println("-------------------------");
        planEntrainement.loadPlanEntrainement(idPlanEntrainement);
        planEntrainement.loadExercicesPlanEntrainement();
        exercices2 = planEntrainementTest.getExercices();
        exercices = planEntrainement.getExercices();
        

        for(int i= 0; i < exercices2.size(); i++){
            
            assertEquals(exercices2.get(i).getDuree(), exercices.get(i).getDuree(), exercices2.get(i).getDuree());
            assertEquals(exercices2.get(i).getDesc(), exercices.get(i).getDesc(), exercices2.get(i).getDesc());
            assertEquals(exercices2.get(i).getTitre(), exercices.get(i).getTitre(), exercices2.get(i).getTitre());
        }

    }

}