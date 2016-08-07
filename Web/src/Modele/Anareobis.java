package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Yacine on 04/02/2015.
 */
public class Anareobis extends AbstractExercice{
    private int repetition;
    private final int idtype=1;

    @Override
    public int getType() {
        return idtype;
    }

    @Override
    public float getDistance() {
        return 0;
    }

    @Override
    public void setDistance(float distance) {

    }


    public Anareobis(String titre, String desc, float duree, int repetition) {
        super(titre, desc, duree);

        this.repetition = repetition;
    }

    public Anareobis(){}

    @Override
    public void remove() {
        Connection cx = Authentification.getConnection();
        PreparedStatement ps = null;
        try {
            ps = cx.prepareStatement("delete from Exercice where TypeExercice_idTypeExercice=1 and idExercice=?");
            ps.setInt(1, this.getId());
            int r = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("erreur lors de la suppression de l'exercice");
            e.printStackTrace();
        } finally {
            try {
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void update() {
        Connection cx= Authentification.getConnection();
        PreparedStatement ps=null;
        try {
            ps=cx.prepareStatement("update Exercice set titre=? and temps=? and description=? and repetition=? where idExercice=? and TypeExercice_idTypeExercice = 1");
            ps.setString(1,this.getTitre());
            ps.setFloat(2, this.getDuree());
            ps.setString(3,this.getDesc());
            ps.setInt(4,this.getRepetition());
            ps.setInt(5, this.getId());
            int r = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("erreur lors de la mise a jour de l'exercice");
            e.printStackTrace();
        }
        finally
        {
            try {
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public int getRepetition() {
        return repetition;
    }

    @Override
    public void setRepetition(int repetition) {
        this.repetition=repetition;
    }



    @Override
    public String toString() {
        return "exercice type anareobis{" +
                "\n ID = "+this.getId()+
                "\n titre="+ this.getTitre()+
                "\n description="+this.getDesc()+
                "\n durée="+this.getDuree()+
                "\n repetition=" + repetition +
                '}';
    }

    @Override
    public int addExercice() {
        Connection connection = Authentification.getConnection();

        PreparedStatement query = null;

        try{

            query = connection.prepareStatement("INSERT INTO Exercice(TypeExercice_idTypeExercice, titre, temps, description, repetition, distance) values(?,?,?,?,?,?)");
            query.setInt(1, idtype);
            query.setString(2, this.getTitre());
            query.setFloat(3, this.getDuree());
            query.setString(4, this.getDesc());
            query.setInt(5, this.repetition);
            query.setFloat(6, 0);

            int res = query.executeUpdate();

            ResultSet id = query.getGeneratedKeys();

            if(id.next()){

                this.setId(id.getInt(1));
                return id.getInt(1);
            }
            else{

                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur insertion exercice");
            return 0;
        }

    }

    public void loadExercice(int id){

        Connection connection = Authentification.getConnection();

        PreparedStatement query = null;

        try{
            query = connection.prepareStatement("SELECT * FROM Exercice WHERE idExercice = ?");
            query.setInt(1,id);

            ResultSet rs = query.executeQuery();

            while(rs.next()){

                this.setTitre(rs.getString("titre"));
                this.setDesc(rs.getString("description"));
                this.setDuree(rs.getInt("temps"));
                this.repetition=rs.getInt("repetition");
                this.setId(id);


            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur chargement exercice");
        }

    }
}
