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



    public abstract int getType();

    public abstract float getDistance();
    public abstract void setDistance(float distance);

    public abstract int getRepetition();
    public abstract void setRepetition(int repetition);

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
