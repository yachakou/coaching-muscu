package Modele;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Mathieu on 09/03/2015.
 */
public class Seance implements Comparable{

    private int id;
    private int idExercice;
    private Date date;
    private int type;

    public Seance(int idExercice, float temps, float distance, int repetition) {

        this.idExercice = idExercice;
        this.temps = temps;
        this.distance = distance;
        this.repetition = repetition;
        this.date = this.obtenirDate();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private float temps;
    private float distance;
    private int repetition;
    private float objectifTemps;
    private float objectifDistance;
    private float objectifRepetition;
    private String description;
    private String titre;

    public Seance()
    {

    }


    public int compareTo(Object other) {
        Date date1 = ((Seance) other).getDate();
        Date date2 = this.getDate();
        if (date1.after(date2))  return -1;
        else if(date1 == date2) return 0;
        else return 1;
    }

    public Date obtenirDate(){

        Date date = new Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime());

        return date1;
    }
    @Override
    public String toString() {
        return "Seance{" +
                "id=" + id +
                ", idExercice=" + idExercice +
                ", date=" + date +
                ", temps=" + temps +
                ", distance=" + distance +
                ", repetition=" + repetition +
                ", objectifTemps=" + objectifTemps +
                ", objectifDistance=" + objectifDistance +
                ", objectifRepetition=" + objectifRepetition +
                ", description='" + description + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getObjectifRepetition() {
        return objectifRepetition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdExercice(int idExercice) {
        this.idExercice = idExercice;
    }

    public void setObjectifRepetition(float objectifRepetition) {
        this.objectifRepetition = objectifRepetition;
    }

    public float getObjectifTemps() {
        return objectifTemps;
    }

    public void setObjectifTemps(float objectifTemps) {
        this.objectifTemps = objectifTemps;
    }

    public float getObjectifDistance() {
        return objectifDistance;
    }

    public void setObjectifDistance(float objectifDistance) {
        this.objectifDistance = objectifDistance;
    }


    public int getId() {
        return id;
    }


    public int getIdExercice() {
        return idExercice;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTemps() {
        return temps;
    }

    public void setTemps(float temps) {
        this.temps = temps;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }



    public void insererSeance(int idUtilisateur){

        Connection connection = Authentification.getConnection();
        PreparedStatement statement = null;

        try{
            statement=connection.prepareStatement("INSERT INTO Seance(Exercice_idExercice, Utilisateur_idUtilisateur, date, temps, distance, repetition) VALUES (?,?,?,?,?,?)");
            statement.setInt(1,this.getIdExercice());
            statement.setInt(2,idUtilisateur);
            statement.setDate(3, (java.sql.Date) this.getDate());
            statement.setFloat(4, this.getTemps());
            statement.setFloat(5, this.getDistance());
            statement.setInt(6, this.getRepetition());

            int res = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
