package Vue;

import Modele.PlanEntrainement;


/**
 * Created by Mathieu on 11/02/2015.
 */
public class Client {


    public static void main(String[] args) {


        PlanEntrainement p=new PlanEntrainement();
        p.load(1);
        p.affichageExercice();
        


    }

}
