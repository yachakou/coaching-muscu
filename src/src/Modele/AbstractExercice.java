package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yacine on 04/02/2015.
 */
public abstract class AbstractExercice {
    private String titre;
    
    private String desc;
    private float duree;
    private int id;
    private float tempsMoyen;
    private float distanceMoyenne;
    private float repetition;
    private float repetitionMoyenne;
    private int type;

    public abstract int getType();

    public abstract float getDistance();

    public abstract int getRepetition();

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTempsMoyen() {
        return tempsMoyen;
    }

    public float getDistanceMoyenne() {
        return distanceMoyenne;
    }
    
    public float GetRepetition(){
        
        return repetition;
        
    }

    public void setDistanceMoyenne(float distanceMoyenne) {
        this.distanceMoyenne = distanceMoyenne;
    }

    public void setRepetition(float repetition) {
        this.repetition = repetition;
    }

    public int GetType(){
        
        return type;
        
        
    }



    public AbstractExercice(String titre, String desc, float duree) {
        this.titre = titre;
        this.desc = desc;
        this.duree = duree;

    }

    public AbstractExercice(){}
    

    public abstract void remove();
    public abstract void update();
    //chargement exercice
    public void loadExercice(int id){

        Connection connection = Authentification.getConnection();

        PreparedStatement query = null;
        
        try{
            query = connection.prepareStatement("SELECT * FROM Exercice WHERE idExercice = ?");
            query.setInt(1,id);

            ResultSet rs = query.executeQuery();
            
            while(rs.next()){
                
                this.titre = rs.getString("titre");
                System.out.println(""+titre);
                this.desc = rs.getString("description");
                System.out.println(""+desc);
                this.duree = rs.getFloat("temps");
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur chargement exercice");
        }

    }
    
    public int statistiqueExercice(int idUtilisateur){
        
        Connection connection = Authentification.getConnection();
        PreparedStatement statement = null;
        int typeExercice = 0;
        
        try{
            
            statement = connection.prepareStatement("SELECT TypeExercice_idTypeExercice, AVG(Seance.temps)AS temps_moyen, AVG(Seance.distance)AS distance_moyenne, AVG(Seance.repetition)AS moyenne_repetition" +
                    " FROM Seance, Exercice, Utilisateur, PlanEntrainementExercice, PlanEntrainementUtilisateur, PlanEntrainement" +
                    " WHERE Seance.Exercice_idExercice = Exercice.idExercice" +
                    " AND Seance.Utilisateur_idUtilisateur = Utilisateur.idUtilisateur" +
                    " AND Exercice.idExercice = PlanEntrainementExercice.Exercice_idExercice" +
                    " AND PlanEntrainementExercice.PlanEntrainement_idPlanEntrainement = PlanEntrainement.idPlanEntrainement" +
                    " AND PlanEntrainementUtilisateur.Utilisateur_idUtilisateur = Utilisateur.idUtilisateur" +
                    " AND Utilisateur.idUtilisateur = ?" +
                    " AND Exercice.idExercice = ? " +
                    "AND PlanEntrainementUtilisateur.actif = 1");
            
            statement.setInt(1, idUtilisateur);
            statement.setInt(2,this.getId());
            ResultSet res = statement.executeQuery();
            
            while(res.next()){
                
                this.repetition = res.getFloat("moyenne_repetition");
                this.tempsMoyen = res.getFloat("temps_moyen");
                this.distanceMoyenne = res.getFloat("distance_moyenne");
                this.repetitionMoyenne = res.getFloat("moyenne_repetition");
                typeExercice = res.getInt("TypeExercice_idTypeExercice");
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return typeExercice;

    }


    public String affichageStatistiqueAerobis(){

        return "\n Statistique exercice Aerobis :{"+
                "\n titre :"+this.getTitre()+
                "\n description : "+this.getDesc()+
                "\n temps : "+this.getDuree()+
                "\n temps moyen :"+this.getTempsMoyen()+
                "\n distance :"+this.getDistance()+
                "\n distance moyenne : "+this.getDistanceMoyenne()+
                "\n"+
                '}';

    }


    public String affichageStatistiqueAnaerobis(){

        return "\n Statistique exercice Anaerobis :{"+
                "\n titre :"+this.getTitre()+
                "\n description : "+this.getDesc()+
                "\n temps : "+this.getDuree()+
                "\n temps moyen :"+this.getTempsMoyen()+
                "\n repetition :"+this.getRepetition()+
                "\n repetition moyenne : "+this.getRepetitionMoyenne()+
                "\n"+
                '}';

    }

    public abstract void Edit(String titre, String desc, float duree, int repetition,float distance);


    public abstract int addExercice();

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getDuree() {
        return duree;
    }

    /*public void setDistanceMoyenne(float distanceMoyenne) {
        this.distanceMoyenne = distanceMoyenne;
    }*/

   /* public void setRepetition(float repetition) {
        this.repetition = repetition;
    }*/

    public float getRepetitionMoyenne() {
        return repetitionMoyenne;
    }
}
