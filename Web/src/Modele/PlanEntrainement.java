package Modele;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yacine on 04/02/2015.
 */
public class PlanEntrainement {
    private int id;
    private float difficulte;
    private float duree;
    private List<AbstractExercice> exercices = new ArrayList<AbstractExercice>();
    private boolean actif;


    public PlanEntrainement()
    {
        this.actif=false;
        this.exercices=new ArrayList<AbstractExercice>();
    }

    public PlanEntrainement(int id, float difficulte, float duree, boolean actif) {
        this.id = id;
        this.difficulte = difficulte;
        this.duree = duree;
        this.actif = actif;
    }

    public PlanEntrainement(float difficulte, float duree) {
        this.difficulte = difficulte;
        this.actif = false;
        this.duree = duree;
        this.exercices = new ArrayList<AbstractExercice>();
    }


    public float getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(float difficulte) {
        this.difficulte = difficulte;
    }

    public Float getDuree() {
        return duree;
    }

    public void setDuree(Float duree) {
        this.duree = duree;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addExercice(AbstractExercice exercice)
    {
        exercices.add(exercice);
    }

    public List<AbstractExercice> getExercices() {
        return exercices;
    }

    public void removeExercice(AbstractExercice a)
    {
        exercices.remove(a);
    }




    @Override
    public String toString() {
        return "PlanEntrainement{" +
                "id=" + id +
                ", difficulte=" + difficulte +
                ", duree=" + duree +
                ", exercices=" + exercices +
                ", actif=" + actif +
                '}';
    }

    public String type(int id)
    {
        if(id==0)
            return "aerobis";
        else if(id==1)
            return "anaerobis";
        else
            return "null";
    }

    public String tronquer(String s, int max)
    {
        String trq=" | ";

        //on tronque si supérieur au max
        int diff=max-s.length();
        if(s.length()>max)
        {
            trq+=s.substring(0,max-3);
            trq+="...";
        }
        else
        {
            trq+=s;
            for(int i=0;i<diff;i++)
            {
                trq+=" ";
            }
        }
        return trq;

    }

    public void affichageExercice()
    {


        String title="";
        title+=tronquer("id",3);
        title+=tronquer("type",10);
        title+=tronquer("titre",10);
        title+=tronquer("temps(min)",10);
        title+=tronquer("description",20);
        title+=tronquer("repetition",11);
        title+=tronquer("distance",8);
        System.out.println(title);
        for(AbstractExercice e:exercices)
        {
            String s="";
            s+=tronquer(""+e.getId(),3);
            s+=tronquer(type(e.getType()),10);
            s+=tronquer(e.getTitre(),10);
            s+=tronquer(""+e.getDuree(),10);
            s+=tronquer(""+e.getDesc(),20);
            s+=tronquer(""+e.getRepetition(),11);
            s+=tronquer(""+e.getDistance(),8);
            System.out.println(s);

        }
    }

    public void loadPlanEntrainementActif(int idUtilisateur){

        Connection connection = Authentification.getConnection();
        PreparedStatement query = null;
        try{
            query = connection.prepareStatement("SELECT idPlanEntrainement FROM Utilisateur u, PlanEntrainementUtilisateur pu, PlanEntrainement p WHERE pu.actif =1 AND u.idUtilisateur = ? AND u.idUtilisateur = pu.Utilisateur_idUtilisateur AND pu.planEntrainement_idPlanEntrainement = p.idPlanEntrainement ");
            query.setInt(1, idUtilisateur);

            ResultSet resultat = query.executeQuery();

            while(resultat.next()){

                this.setId(resultat.getInt("idPlanEntrainement"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur recherche plan entrainement actif");
            e.printStackTrace();
        }

        this.loadPlanEntrainement(this.getId());

    }

    public void loadPlanEntrainement(int id)
    {
        Connection cx =  Authentification.getConnection();
        ResultSet resultat=null;
        PreparedStatement ps=null;
        try {

            ps=cx.prepareStatement("select * from PlanEntrainement where idPlanEntrainement=?");
            ps.setInt(1,id);

            resultat = ps.executeQuery();
            while (resultat.next()) {
                this.id=resultat.getInt("idPlanEntrainement");
                this.difficulte=resultat.getFloat("difficulte");
                this.duree=resultat.getInt("duree");
                System.out.println("CHargement du planEntrainement reussi");

            };


        } catch (SQLException e) {
            System.out.println("erreur lors du chargement du planEntrainement");
            e.printStackTrace();
        }
        finally
        {
            try {
                ps.close();
                resultat.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }

    //charge les exercices du plan entrainement
    public void loadExercicesPlanEntrainement(){

        Connection connection = Authentification.getConnection();
        PreparedStatement query = null;
        try{

            query = connection.prepareStatement("SELECT distinct  TypeExercice_idTypeExercice, idExercice FROM Exercice e, PlanEntrainementExercice pe, PlanEntrainement p WHERE p.idPlanEntrainement = ? AND p.idPlanEntrainement = pe.PlanEntrainement_idPlanEntrainement  and e.idExercice=pe.Exercice_idExercice");

            query.setInt(1, this.getId());

            ResultSet rs = query.executeQuery();

            while(rs.next()){
                int type=rs.getInt("TypeExercice_idTypeExercice");

                if(type==0) {
                    Aerobis e = new Aerobis();
                    e.loadExercice(rs.getInt("idExercice"));
                    System.out.println(e.toString());
                    this.addExercice(e);
                }
                else if(type==1)
                {
                    Anareobis e=new Anareobis();
                    e.loadExercice(rs.getInt("idExercice"));
                    System.out.println(e.toString());
                    this.addExercice(e);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur Chargement exercice plan d'entrainement");
        }




    }

    public void suppressionExercice(int idExercice){

        Connection connection = Authentification.getConnection();
        PreparedStatement statement = null;

        try{

            statement = connection.prepareStatement("DELETE FROM Seance WHERE Exercice_idExercice = ?");
            statement.setInt(1,idExercice);
            int res = statement.executeUpdate();
            statement=connection.prepareStatement("DELETE FROM Exercice WHERE idExercice = ?");
            statement.setInt(1, idExercice);
            res = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //charge le plan entrainement et ses exercices
    public void load(int id)
    {
        //on charge le plan entrainement de id
        loadPlanEntrainement(id);
        //on charge ses exercices.
        loadExercicesPlanEntrainement();
    }

    //supprimer l'objet de la table
    public void removePlanEntrainement()
    {

        Connection cx= Authentification.getConnection();
        PreparedStatement ps=null;
        try {
            ps=cx.prepareStatement("delete from PlanEntrainement where idPlanEntrainement=?");
            ps.setInt(1, this.getId());
            int r = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("erreur lors de la suppression du planEntrainement");
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

    //met à jour les données du planEntrainement
    public void updatePlanEntrainement()
    {


        Connection cx= Authentification.getConnection();
        PreparedStatement ps=null;
        try {
            ps=cx.prepareStatement("update PlanEntrainement set difficulte=? and duree=? where idPlanEntrainement=?");
            ps.setFloat(1, this.getDifficulte());
            ps.setFloat(2, this.getDuree());
            ps.setInt(3, this.getId());
            int r = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("erreur lors de la mise a jour du planEntrainement");
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
    public int getTypeExercice(int idExercice){

        Connection connection = Authentification.getConnection();
        PreparedStatement statement = null;
        int typeExercice = 2;
        try{
            statement=connection.prepareStatement("SELECT TypeExercice_idTypeExercice FROM Exercice WHERE idExercice = ?");
            statement.setInt(1,idExercice);

            ResultSet rs = statement.executeQuery();

            while(rs.next()){

                typeExercice = rs.getInt("TypeExercice_idTypeExercice");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typeExercice;

    }
    public void ajouterSeanceActif(int idExercice, int idUtilisateur){

        Scanner in = new Scanner(System.in);

        int typeExercice = this.getTypeExercice(idExercice);

        int duree = 0; int distance = 0; int repetition = 0;

        if(typeExercice == 0){

            System.out.println("Entrer la durée passée à faire l'exercice");
            duree = in.nextInt();
            System.out.printf("Entrer la distance effectuée durant l'exercice");
            distance = in.nextInt();;

        }
        else if(typeExercice == 1){

            System.out.println("Entrer la durée passé à faire l'exercice");
            duree = in.nextInt();
            System.out.println("Entrer le nombre de répétition effectuée");
            repetition = in.nextInt();

        }
        else{

            System.out.println("exercice non trouvé!!");
        }

        Seance seance = new Seance(idExercice, duree, distance, repetition);
        seance.insererSeance(idUtilisateur);

    }


    //inserer dans la table Plan Entrainement
    public  void addPlanEntrainement()
    {

        Connection cx= Authentification.getConnection();
        PreparedStatement ps=null;
        try {
            ps=cx.prepareStatement("insert into PlanEntrainement(difficulte,duree)  values(?,?)");
            ps.setFloat(1, this.getDifficulte());
            ps.setFloat(2, this.getDuree());
            int r = ps.executeUpdate();
            //recuperer cle primaire auto_increment
            ResultSet id=ps.getGeneratedKeys();
            if (id.next()) {
                //System.out.println("id: " + id.getInt(1));
                this.id=id.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("erreur lors de la sauvegarde du planEntrainement");
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

    public void insererPlanEntrainementUtilisateur(int idUtilisateur){

        Connection connection = Authentification.getConnection();
        PreparedStatement statement=null;
        try{
            statement = connection.prepareStatement("INSERT INTO PlanEntrainementUtilisateur(Utilisateur_idUtilisateur, PlanEntrainement_idPlanEntrainement,actif) VALUES(?,?,0)");
            statement.setInt(1, idUtilisateur);
            statement.setInt(2, this.getId());
            int r = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //creer un exercice et l'ajoute au plan d'entrainement
    public void creerExercicePlanEntrainement(){

        Scanner sc = new Scanner(System.in);

        System.out.println("titre exercice ?");
        String titre = sc.next();
        System.out.println("temps exercice?");
        float temps = sc.nextFloat();
        System.out.println("Description?");
        String desc = sc.next();

        System.out.println("Type exercice \n 1: Aerobis \n 2: Anareobis \n");

        int typeExercice = sc.nextInt();
        int repetition = 0;
        float distance = 0;
        AbstractExercice e;
        switch (typeExercice){

            case 1:
                System.out.println("distance?");
                distance = sc.nextInt();
                repetition = 0;
                e=new Aerobis(titre,desc,temps,distance);
                e.addExercice();
                //insertion en base planEntraineemntExercice
                this.insererPlanExerciceEntrainement(e.getId());
                //ajoute a la liste des exercices.
                this.addExercice(e);
                break;

            case 2:
                System.out.println("repetition");
                repetition = sc.nextInt();
                distance = 0;
                e=new Anareobis(titre,desc,temps,repetition);
                //insertion en base
                e.addExercice();
                //insertion en base planEntraineemntExercice
                this.insererPlanExerciceEntrainement(e.getId());
                //ajoute a la liste des exercices.
                this.addExercice(e);
                break;
        }


    }

    public void insererPlanExerciceEntrainement(int idExercice){

        Connection connection = Authentification.getConnection();
        PreparedStatement query = null;

        try{

            query  =connection.prepareStatement("INSERT INTO PlanEntrainementExercice(PlanEntrainement_idPlanEntrainement,Exercice_idExercice) values(?,?)");
            query.setInt(1, this.getId());
            query.setInt(2, idExercice);

            int res = query.executeUpdate();
            System.out.println("creation reussi");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Echec creation");
        }

    }




    // associer un plan entrainement a un utilisateur.
    public void addPlanEntrainementUtilisateur(int idUtilisateur)
    {
        Connection cx= Authentification.getConnection();
        PreparedStatement ps=null;
        try {
            ps=cx.prepareStatement("insert into PlanEntrainementUtilisateur(Utilisateur_idUtilisateur,PlanEntrainement_idPlanEntrainement)  values(?,?)");
            ps.setFloat(1, id);
            ps.setFloat(2, this.getId());
            int r = ps.executeUpdate();


        } catch (SQLException e) {
            System.out.println("erreur lors de la sauvegarde du planEntrainement");
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


    public void recupExerciceDefaut(float difficulte)
    {
        Connection cx = Authentification.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        float ratio []= {0,0, (float) 0.5,0,0};
        ArrayList <AbstractExercice> listeExercices = new ArrayList();
        try {
            System.out.println("ok");
            ps = cx.prepareStatement("Select * FROM ExerciceDefaut");
            rs = ps.executeQuery();
            while(rs.next())
            {
                if(rs.getInt("TypeExercice_idTypeExercice")==1)
                {
                    listeExercices.add(new Anareobis(rs.getString("titre"),rs.getNString("description"),rs.getFloat("temps"),rs.getInt("repetition")));
                }
                else {
                    listeExercices.add(new Aerobis(rs.getString("titre"),rs.getNString("description"),rs.getFloat("temps"),rs.getInt("distance")));
                }
            }
            for(AbstractExercice a:listeExercices)
            {
                a.setDistance(a.getDistance()*(ratio[Math.round(difficulte)]+1));
                a.setRepetition(Math.round(a.getRepetition()*(ratio[Math.round(difficulte)]+1)));
                System.out.println(a.getRepetition()*(ratio[Math.round(difficulte)]+1));
                // System.out.println(a.toString()+"\n");
                System.out.println("\n");
            }

        }
        catch (SQLException e) {
            System.out.println("Erreur lors de la génération du plan d'entrainement");
            e.printStackTrace();
        }
        System.out.println("here");
    }
}
