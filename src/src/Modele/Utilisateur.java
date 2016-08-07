package Modele;

import java.beans.Statement;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yacine on 04/02/2015.
 */
public class Utilisateur implements IService {

    private int idUtilisateur;
    private String nom;
    private String prenom;
    private String mail;
    private String motdepasse;
    private Sexe sexe;
    private String dateNaissance;
    private float taille;
    private float poids;
    private int sommeil;
    private float poidsObjectif;
    private String login;
    private List<PlanEntrainement> plans = new ArrayList<PlanEntrainement>();

    public Utilisateur() {
    }

    public List<PlanEntrainement> getPlans() {
        return plans;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public void setSommeil(int sommeil) {
        this.sommeil = sommeil;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Utilisateur(String nom, String prenom, String motdepasse, Sexe sexe, String dateNaissance, float taille, String login, float poids) {
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = motdepasse;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.taille = taille;
        this.login = login;
        this.poids = poids;
    }




    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public int getSomeil() {
        return sommeil;
    }

    public void setSomeil(int sommeil) {
        this.sommeil = sommeil;
    }

    public float getPoidsObjectif() {
        return poidsObjectif;
    }

    public void setPoidsObjectif(float poidsObjectif) {
        this.poidsObjectif = poidsObjectif;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public float getTaille() {
        return taille;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    @Override
    public void affichagePlanEntrainement(){

        for(PlanEntrainement planEntrainement : plans){

            if(planEntrainement.isActif()){
                planEntrainement.toString();
                planEntrainement.affichageExercice();
            }
        }

    }

    @Override
    public void affichageStatistiques()
    {   
        
    }

  

    @Override
    public void ajouterExercice(String titre, String description, int temps){

    }

    @Override
    public void creerProgramme(float difficulte, int duree){

        PlanEntrainement a = new PlanEntrainement(difficulte,duree);
        plans.add(a);

    }

    @Override
    public void entrerDonneesSeance(){}

    @Override
    public void genererExercice(){}

    @Override
    public void exerciceAccepte(AbstractExercice exercice){}

    @Override
    public void refutExercice(AbstractExercice exercice){}

    @Override
    public void modifierDonneesUtilisateur(){}

    @Override
    public void supprimerProfil(){}

    @Override
    public void supprimerExercice(AbstractExercice exercice){}


    public int chargerInformations(String log, String mdp)  {
        Connection conn=  Authentification.getConnection();
        int valid=0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM Utilisateur u,DonneesUtilisateur d WHERE u.login=? AND u.password=? AND u.idUtilisateur=d.Utilisateur_idUtilisateur");
            pstmt.setString(1,log);
            pstmt.setString(2,mdp);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()) {
                valid+=1;
                this.setIdUtilisateur(rs.getInt("idUtilisateur"));
                this.nom = rs.getString("nom");
                this.prenom = rs.getString("prenom");
                this.mail = rs.getString("mail");
                this.dateNaissance = rs.getString("dateDeNaissance");
                this.taille = rs.getFloat("taille");
                this.sommeil = rs.getInt("sommeil");
                this.poidsObjectif = rs.getFloat("poidsObjectif");
                this.poids = rs.getFloat("poids");
                System.out.println("ID : "+this.getIdUtilisateur());
                this.login=log;
                this.motdepasse=mdp;
                //this.taille = rs.getInt("taille");
                //this.dateNaissance = rs.getString("dateNaissance");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'authentification");
            return valid;

        }

        System.out.println("Bienvenue "+this.prenom+" "+this.nom);


        return valid;
    }

    public void register(String nom, String prenom,String mail, String motdepasse, Sexe sexe, String dateNaissance, float taille, String login)
    {
        Connection conn=  Authentification.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO Utilisateur (nom,prenom,mail,login,password,sexe,dateDeNaissance,taille) values (?,?,?,?,?,?,?,?)");
            pstmt.setString(1,nom);
            pstmt.setString(2,prenom);
            pstmt.setString(3,mail);
            pstmt.setString(4,login);
            pstmt.setString(5,motdepasse);
            if(sexe.equals(Sexe.FEMME)) {
                pstmt.setString(6, "f");
            } else   pstmt.setString(6, "h");
            pstmt.setString(7, dateNaissance);
            pstmt.setFloat(8, taille);

            int res = pstmt.executeUpdate();
            ResultSet id = pstmt.getGeneratedKeys();
            if (id.next()) {
                this.idUtilisateur=id.getInt(1);
            }
            PreparedStatement psdt = null;
            psdt = conn.prepareStatement("INSERT INTO DonneesUtilisateur (Utilisateur_idUtilisateur) VALUES (?)");
            psdt.setInt(1,this.getIdUtilisateur());
            int res2 = psdt.executeUpdate();

            this.nom=nom;
            this.prenom=prenom;
            this.mail=mail;
            this.motdepasse=motdepasse;
            this.dateNaissance=dateNaissance;
            this.taille=taille;
            this.login=login;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'enregistrement");
        }
    }

    public void updateDonnee(float poids, int sommeil,float poidsObjectif)
    {
        Connection conn=  Authentification.getConnection();
        PreparedStatement psd = null;
        try {
            psd = conn.prepareStatement("UPDATE  DonneesUtilisateur set dateUpdate=?,sommeil=?,poids=?,poidsObjectif=? WHERE Utilisateur_idUtilisateur=?");
            psd.setInt(5,this.getIdUtilisateur());
            Date date=new Date();
            java.sql.Date d=new java.sql.Date(date.getTime());
            psd.setDate(1, d);
            psd.setInt(2, sommeil);
            psd.setFloat(3, poids);
            psd.setFloat(4, poidsObjectif);

            int res = psd.executeUpdate();
            this.sommeil=sommeil;
            this.poids=poids;
            this.poidsObjectif=poidsObjectif;


            psd = conn.prepareStatement("insert into DonneesUtilisateurGraphe(dateUpdate,sommeil,poids,poidsObjectif,idUtilisateur) values (?,?,?,?,?)"); psd.setInt(5,this.getIdUtilisateur());
            psd.setDate(1, d);
            psd.setInt(2, sommeil);
            psd.setFloat(3, poids);
            psd.setFloat(4, poidsObjectif);

            int res2 = psd.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la mis à jour des données");
        }


    }

    public void updateDonneeUser(String nom, String prenom,String mail, String sexe, String date, float taille)
    {
        Connection conn=  Authentification.getConnection();
        PreparedStatement psd = null;
        try {
            psd = conn.prepareStatement("UPDATE  Utilisateur set nom=?,prenom=?,mail=?,sexe=?,dateDeNaissance=?,taille=? WHERE idUtilisateur=?");
            psd.setString(1, nom);
            psd.setString(2, prenom);
            psd.setString(3, mail);
            psd.setString(4, sexe);
            psd.setString(5, date);
            psd.setFloat(6, taille);
            psd.setInt(7, this.idUtilisateur);


            int res = psd.executeUpdate();

            this.nom=nom;
            this.prenom=prenom;
            this.mail=mail;
            if(sexe=="h")
            {
                this.sexe=Sexe.HOMME;

            }
            else if(sexe=="f")
            {
                this.sexe=Sexe.FEMME;
            }
            else
            {
                this.sexe=null;
            }

            this.dateNaissance=date;
            this.taille=taille;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la mis à jour des données");
        }


    }

    public int loadPlanentrainement()
    {
        Connection conn=  Authentification.getConnection();
        PreparedStatement psd = null;
        this.plans=new ArrayList<PlanEntrainement>();

        try {
            psd = conn.prepareStatement("SELECT * FROM PlanEntrainementUtilisateur pu, PlanEntrainement pe Where pu.Utilisateur_idUtilisateur=? AND pe.idPlanEntrainement=pu.PlanEntrainement_idPlanEntrainement");
            psd.setInt(1,this.getIdUtilisateur());
            ResultSet res = psd.executeQuery();

            while(res.next())
            {
                boolean temp;
                if(res.getInt("actif")==1) temp=true;
                else temp=false;
                //System.out.println(res.getInt("idPlanEntrainement") +" "+res.getFloat("difficulte")+" "+res.getFloat("duree")+" "+temp);
                //PlanEntrainement a =  new PlanEntrainement(res.getInt("idPlanEntrainement"),res.getFloat("difficulte"),res.getFloat("duree"),temp);
                //  this.plans.add(a);
                this.plans.add(new PlanEntrainement(res.getInt("idPlanEntrainement"),res.getFloat("difficulte"),this.dureePlanEntrainement(res.getInt("idPlanEntrainement")),temp));


            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la mis à jour des données");
            return 0;
        }

        return 1 ;
    }

    public float dureePlanEntrainement(int idPlanEntrainement){

        Connection connection = Authentification.getConnection();
        PreparedStatement statement = null;
        float sum = 0;

        try{
            statement = connection.prepareStatement("SELECT SUM(temps) AS duree_planEntrainement FROM Exercice e, PlanEntrainementExercice pee, PlanEntrainement pe WHERE pe.idPlanEntrainement = pee.PlanEntrainement_idPlanEntrainement AND e.idExercice = pee.Exercice_idExercice AND pe.idPlanEntrainement = ?");
            statement.setInt(1, idPlanEntrainement);
            ResultSet res = statement.executeQuery();

            while(res.next()){

                sum = res.getFloat("duree_planEntrainement");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sum;

    }

    public void changerPlanEntrainementActif(){

        Scanner in = new Scanner(System.in);

        System.out.println("Entrer l'ID du plan d'entrainement qui doit devenir actif");

        for(PlanEntrainement c: plans){

            System.out.println(c.toString());
        }

        int choix = in.nextInt();

        this.updatePlanEntrainementActif(choix);

    }

    public int getIDPlanEntrainementActif(){

        int id = 0;

        for(PlanEntrainement c : plans){

            if(c.isActif()){
                id = c.getId();
            }
        }

        return id;

    }

    public void updatePlanEntrainementActif(int choix){

        Connection connection = Authentification.getConnection();
        PreparedStatement statement = null;

        try{
            statement = connection.prepareStatement("UPDATE PlanEntrainementUtilisateur SET actif = 0 WHERE PlanEntrainement_idPlanEntrainement = ?");
            statement.setInt(1, this.getIDPlanEntrainementActif());
            int res = statement.executeUpdate();

            statement = connection.prepareStatement("UPDATE PlanEntrainementUtilisateur SET actif = 1 WHERE PlanEntrainement_idPlanEntrainement = ?");
            statement.setInt(1, choix);
            res = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Seance> getSeances()
    {
        List<Seance> seances=new ArrayList<Seance>();

        Connection conn=  Authentification.getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement("SELECT idSeance, e.idExercice,e.TypeExercice_idTypeExercice as type,date,s.temps, e.temps as objectifTemps,s.distance,e.distance as objectifDistance, s.repetition, e.repetition as objectifRepetition, titre, description from Seance s, Exercice e where Utilisateur_idUtilisateur = ? and s.Exercice_idExercice=e.idExercice ");
            pstmt.setInt(1, idUtilisateur);

            ResultSet rs=pstmt.executeQuery();
            while (rs.next()) {

                Seance s=new Seance();
                s.setId(rs.getInt("idSeance"));
                s.setIdExercice(rs.getInt("idExercice"));
                s.setDate(rs.getDate("date"));
                s.setTemps(rs.getFloat("temps"));
                s.setObjectifTemps(rs.getFloat("objectifTemps"));
                s.setDistance(rs.getFloat("distance"));
                s.setObjectifDistance(rs.getFloat("objectifDistance"));
                s.setRepetition(rs.getInt("repetition"));
                s.setObjectifRepetition(rs.getInt("objectifRepetition"));
                s.setTitre(rs.getString("titre"));
                s.setDescription(rs.getString("description"));
                s.setType(rs.getInt("type"));
                seances.add(s);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de du chargement des seances");


        }

        return seances;

    }

    public List<Seance> getSeancesPlanEntrainementActif()
    {
        List<Seance> seances=new ArrayList<Seance>();

        Connection conn=  Authentification.getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement("SELECT idSeance, e.idExercice,e.TypeExercice_idTypeExercice as type,s.date,s.temps, e.temps as objectifTemps,s.distance,e.distance as objectifDistance, s.repetition, e.repetition as objectifRepetition, titre, description" +
                    " from Seance s, Exercice e, PlanEntrainement p, PlanEntrainementExercice pe, PlanEntrainementUtilisateur pu" +
                    " where s.Utilisateur_idUtilisateur = ?" +
                    " and s.Exercice_idExercice=e.idExercice" +
                    " and pu.actif=1 " +
                    "and pu.Utilisateur_idUtilisateur=s.Utilisateur_idUtilisateur" +
                    " and pe.Exercice_IdExercice=s.Exercice_IdExercice" +
                    " and p.idPlanEntrainement=pe.PlanEntrainement_idPlanEntrainement" +
                    " and pu.PlanEntrainement_idPlanEntrainement=p.idPlanEntrainement");
            pstmt.setInt(1, idUtilisateur);

            ResultSet rs=pstmt.executeQuery();
            while (rs.next()) {

                Seance s=new Seance();
                s.setId(rs.getInt("idSeance"));
                s.setIdExercice(rs.getInt("idExercice"));
                s.setDate(rs.getDate("date"));
                s.setTemps(rs.getFloat("temps"));
                s.setObjectifTemps(rs.getFloat("objectifTemps"));
                s.setDistance(rs.getFloat("distance"));
                s.setObjectifDistance(rs.getFloat("objectifDistance"));
                s.setRepetition(rs.getInt("repetition"));
                s.setObjectifRepetition(rs.getInt("objectifRepetition"));
                s.setTitre(rs.getString("titre"));
                s.setDescription(rs.getString("description"));
                s.setType(rs.getInt("type"));
                seances.add(s);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de du chargement des seances");


        }

        return seances;
    }




    public void supprimerPlanEntrainement(){

        plans.clear();

    }
    /****************************************************************/
    public void menu()
    {
        System.out.println("Bienvenue sur MiageCoaching!");
        System.out.println("Faite un choix : ");
        System.out.println("1 - S'identifier ");
        System.out.println("2 - S'inscrire ");
        Scanner in = new Scanner(System.in);
        int choix = in.nextInt();
        if(choix == 1) registerTest();
        if(choix == 2) inscriTest();
    }
    public void registerTest()
    {

        System.out.println("Entrez votre login");
        Scanner in = new Scanner(System.in);
        String login = in.nextLine();
        if (login == null){
            System.out.println("Erreur login invalide");
            System.exit(0);
        }
        System.out.println("Entrez votre mot de passe");
        String mdp = in.nextLine();
        if (mdp == null){
            System.out.println("Erreur mot de passe invalide");
            System.exit(0);
        }
        /*Utilisateur a = new Utilisateur();*/
        this.chargerInformations(login, mdp);
        this.loadPlanentrainement();

        int choix = 1;

        while(choix!=0) {
            System.out.println("\n");
            System.out.println("\n Que voulez vous faire ?  \n");
            System.out.println("1 - Afficher la liste des plan d'entrainements");
            System.out.println("2 - Afficher exercices du plan entrainement actif");
            System.out.println("3 - Changer plan entrainement actif");
            System.out.println("4 - Créer un plan d'entrainement");
            System.out.println("5 - Supprimer un plan d'entrainement");
            System.out.println("6 - Creer un exercice");
            System.out.println("7 - Supprimer un exercice du plan d'entrainement actif");
            System.out.println("8 - Ajouter une séance");
            System.out.println("9 - Afficher statistiques");
            System.out.println("10 - Générer plan d'entrainement");
            System.out.println("11 - Mettre à jour les données utilisateur");
            System.out.println("12 - Supprimer profil");
            System.out.println("0 - Quitter");

            in = new Scanner(System.in);
            choix = in.nextInt();
            switch (choix){
                case 1:
                    for (PlanEntrainement c : plans) {

                        System.out.println(c.toString());
                    }
                    break;

                case 2:

                    for(PlanEntrainement c : plans){

                        if(c.isActif()){

                            c.loadExercicesPlanEntrainement();
                        }
                    }
                    MajExercice();
                    break;
                case 3:

                    this.changerPlanEntrainementActif();
                    this.supprimerPlanEntrainement();
                    this.loadPlanentrainement();
                    break;
                case 4:
                    this.creationPlanEntrainement();
                    this.supprimerPlanEntrainement();
                    this.loadPlanentrainement();
                    break;
                case 5:
                    this.suppressionPlanEntrainement();

                    break;
                case 6:
                    this.creationExercice();
                    this.supprimerPlanEntrainement();
                    this.loadPlanentrainement();
                    break;
                case 7:
                    Scanner exercice=new Scanner(System.in);
                    for(PlanEntrainement planEntrainement : plans){

                        if(planEntrainement.isActif()){

                            planEntrainement.loadExercicesPlanEntrainement();
                            System.out.println("Entrer l'ID de l'exercice à supprimer");
                            int choixExercice = exercice.nextInt();
                            planEntrainement.suppressionExercice(choixExercice);
                        }
                    }
                    this.supprimerPlanEntrainement();
                    this.loadPlanentrainement();

                    break;
                case 8 :

                    this.ajouterSeance();
                    break;
                case 9 :
                    
                    this.affichageStatistiqueUtilisateur();
                    break;
                case 10: 
                    this.generationPlanEntrainement();
                    this.supprimerPlanEntrainement();
                    this.loadPlanentrainement();
                    break;
                case 11:
                        this.updateDonneesUtilisateur();
                        break;
                case 12:
                    this.suppressionProfil();
                    break;
            }
        }
    }
    
    public void updateDonneesUtilisateur(){
        
        Scanner in = new Scanner(System.in);

        System.out.println("\n Vos données actuel :");
        
        this.affichageDonneesUtilisateur();

        System.out.println("\n Entrer votre poids : ");
        float poids = in.nextFloat();
        System.out.println("Entrer votre poids objectif : ");
        float poidsObjectif = in.nextFloat();
        System.out.println("Entrer votre sommeil :");
        int sommeil = in.nextInt();
        
        this.updateDonnee(poids, sommeil, poidsObjectif);
        
    }
    
    public void affichageDonneesUtilisateur(){

        System.out.println("\n poids : "+this.getPoids()
        +"\n poids objectif : "+this.getPoidsObjectif()
        +"\n sommeil : "+this.getSomeil()); 
        
    }
    
    public void affichageStatistiqueUtilisateur(){

        for(PlanEntrainement planEntrainement : plans){
            
            if(planEntrainement.isActif()){
                planEntrainement.supprimerExercice();
                planEntrainement.loadExercicesPlanEntrainement2();
                planEntrainement.affichageStatistique(this.getIdUtilisateur());

            }
        }

    }
    
    public void generationPlanEntrainement(){
        
        Scanner in = new Scanner(System.in);
        System.out.printf("Entrer la difficulté du plan d'entrainement");
        int difficulte = in.nextInt();
        
        this.genererPlanENtrainement(difficulte);
        
        
    }
    
    public void suppressionProfil(){

        Connection connection = Authentification.getConnection();
        PreparedStatement statement = null;

        try{
            statement = connection.prepareStatement("DELETE FROM Utilisateur WHERE idUtilisateur = ?");
            statement.setInt(1, this.getIdUtilisateur());

            int res = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void ajouterSeance(){

        Scanner in = new Scanner(System.in);

        for(PlanEntrainement planEntrainement : plans){

            if(planEntrainement.isActif()){

                planEntrainement.loadExercicesPlanEntrainement();
                System.out.println("Entrer l'ID de l'exercice pour lequel vous voulez rentrer une séance");
                int choix = in.nextInt();
                planEntrainement.ajouterSeanceActif(choix, this.getIdUtilisateur());
            }
        }


    }


    public String getLogin() {
        return login;
    }

    public void suppressionPlanEntrainement(){

        Scanner in = new Scanner(System.in);

        System.out.println("Entrer l'id du plan d'entrainement que vous voulez supprimer");

        for(PlanEntrainement planEntrainement : plans){

            System.out.println(planEntrainement.toString());
        }
        int choix = in.nextInt();

        for(PlanEntrainement planEntrainement : plans){

            if(planEntrainement.getId() == choix){

                planEntrainement.removePlanEntrainement();

            }
        }

        this.supprimerPlanEntrainement();
        this.loadPlanentrainement();

    }

    public void creerPlanEntrainement(int difficulte, int duree)
    {
        PlanEntrainement planEntrainement = new PlanEntrainement(difficulte, duree);
        planEntrainement.addPlanEntrainement();
        planEntrainement.insererPlanEntrainementUtilisateur(this.getIdUtilisateur());
        plans.add(planEntrainement);
    }

    public void creationPlanEntrainement(){

        Scanner in = new Scanner(System.in);

        System.out.println("Entrer une difficulté");
        int difficulte = in.nextInt();


        int duree = 0;

        PlanEntrainement planEntrainement = new PlanEntrainement(difficulte, duree);
        planEntrainement.addPlanEntrainement();
        planEntrainement.insererPlanEntrainementUtilisateur(this.getIdUtilisateur());
        plans.add(planEntrainement);

    }

    public void creationExercice() {
        System.out.println("\n");
        System.out.println("\n Quel type d'exercice voulez vous créer ?\n");
        System.out.println("1 - Exercice Aerobis");
        System.out.println("2 - Exercice Anaerobis");
        System.out.println("3 - Editer un exercice");
        System.out.println("0 - Annuler");
        Scanner in = new Scanner(System.in);
        int choix = in.nextInt();

        if (choix == 1) {
            System.out.println("\n");
            System.out.println("Creation d'un exercice de type Aerobis \n");
            System.out.println("\n");
            System.out.println("Entrez un titre :\n");
            Scanner t = new Scanner(System.in);
            String titre = t.nextLine();
            if (titre == null) {
                System.out.println("Erreur titre invalide");
            }
            System.out.println("Entrez une descrpition de l'exercice:\n");
            Scanner d = new Scanner(System.in);
            String description = d.nextLine();
            if (description == null) {
                System.out.println("Erreur desciption invalide");
                System.exit(0);
            }
            System.out.println("Entrez la durée de l'exercice:\n");
            Scanner dr = new Scanner(System.in);
            float duree = dr.nextFloat();
            if (duree <= 0) {
                System.out.println("Erreur durée d'exercice invalide");
                System.exit(0);
            }
            System.out.println("Entrez la distance de l'exercice:\n");
            Scanner di = new Scanner(System.in);
            float distance = di.nextFloat();
            if (distance <= 0) {
                System.out.println("Erreur distance pour l'exercice invalide");
                System.exit(0);
            }
            Aerobis exercice = new Aerobis(description, titre, duree, distance);
            exercice.addExercice();
            for(PlanEntrainement planEntrainement : plans){
                if(planEntrainement.isActif()){
                    planEntrainement.insererPlanExerciceEntrainement(exercice.getId());
                }
            }
            System.out.println("Voici l'exercice crée :\n");
            System.out.println("Id : " + exercice.getId() +"\n");
            System.out.println("Titre : " + exercice.getTitre() + "\n");
            System.out.println("Desciption : " + exercice.getDesc() + "\n");
            System.out.println("Durée : " + exercice.getDuree() + "\n");
            System.out.println("Distance : " + exercice.getDistance() + "\n");
        } else if (choix == 2) {
            System.out.println("\n");
            System.out.println("Creation d'un exercice de type Anaerobis \n");
            System.out.println("\n");
            System.out.println("Entrez un titre :\n");
            Scanner t = new Scanner(System.in);
            String titre = t.nextLine();
            if (titre == null) {
                System.out.println("Erreur titre invalide");
                System.exit(0);
            }
            System.out.println("Entrez une descrpition de l'exercice:\n");
            Scanner d = new Scanner(System.in);
            String description = d.nextLine();
            if (description == null) {
                System.out.println("Erreur desciption invalide");
                System.exit(0);
            }
            System.out.println("Entrez la durée de l'exercice:\n");
            Scanner dr = new Scanner(System.in);
            float duree = dr.nextFloat();
            while (duree <= 0) {
                System.out.println("Erreur durée d'exercice invalide ");
            }
            System.out.println("Entrez le nombre de repetition l'exercice:\n");
            Scanner di = new Scanner(System.in);
            int repetition = di.nextInt();
            if (repetition <= 0) {
                System.out.println("Erreur nombre de répétiton pour l'exercice invalide");
                System.exit(0);
            }
            
            if (choix == 3){
                MajExercice();
            }
            if(choix == 0){
                menu();
            }
            Anareobis exercice = new Anareobis(titre, description, duree, repetition);
            exercice.addExercice();
            for(PlanEntrainement planEntrainement : plans){
                if(planEntrainement.isActif()){
                    planEntrainement.insererPlanExerciceEntrainement(exercice.getId());
                }
            }
            System.out.println("Voici l'exercice crée :\n");
            System.out.println("Id : " + exercice.getId() +"\n");
            System.out.println("Titre : " + exercice.getTitre() + "\n");
            System.out.println("Desciption : " + exercice.getDesc() + "\n");
            System.out.println("Durée : " + exercice.getDuree() + "\n");
            System.out.println("Nombre de repetition : " + exercice.getRepetition() + "\n");

        }
        menu();

    }


    public void MajExercice() {
        Connection conn = Authentification.getConnection();
        Connection conn1 = Authentification.getConnection();
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        int typeexo = 0;
        System.out.println("Mis a jour d'un exercice" + "\n");
        System.out.println("selectionnez l'id de l'exercice que vous voulez mettre a jour" + "\n");
        Scanner d = new Scanner(System.in);
        int id = d.nextInt();
                try {
                    statement = conn.prepareStatement("SELECT idExercice FROM Exercice");
                    ResultSet res = statement.executeQuery();
                    boolean isHere=false;
                    while (res.next()) {
                        if(res.getInt("idExercice")==id)
                        {
                            isHere=true;
                        }
                    }
                    System.out.println(isHere);
                    if(isHere) {
                        statement1 = conn1.prepareStatement("SELECT * FROM Exercice WHERE idExercice = ?");
                        statement1.setInt(1, id);
                        ResultSet res1 = statement1.executeQuery();
                        while (res1.next()) {
                            typeexo=res1.getInt("TypeExercice_idTypeExercice");
                        }
                            System.out.println("Type d'exo :" + typeexo);
                            switch (typeexo) {
                                case 0:
                                   
                                    System.out.println("entrez la nouvelle repetition" + "\n");
                                    Scanner rep = new Scanner(System.in);
                                    int repetition = rep.nextInt();
                                    System.out.println("entrez la nouvelle distance" + "\n");
                                    Scanner dis = new Scanner(System.in);
                                    float distance = dis.nextFloat();
                                    UpdateExercice(id,0, repetition, distance);
                                    registerTest();
                                    break;
                                

                                case 1:
                                    
                                    System.out.println("entrez la nouvelle repetition" + "\n");
                                    Scanner repe = new Scanner(System.in);
                                    int repetitions = repe.nextInt();
                                    System.out.println("entrez la nouvelle duréé" + "\n");
                                    Scanner dur = new Scanner(System.in);
                                    float duree = dur.nextFloat();
                                    UpdateExercice(id,duree, repetitions, 0);
                                    registerTest();
                                    break;
                            }
                        }

                    }catch(SQLException e){
                    
                    }
                }
    
    public void UpdateExercice(int id,float duree, int repetition,float distance){
        Connection cx= Authentification.getConnection();
        PreparedStatement ps=null;
        try {
            ps=cx.prepareStatement("update Exercice set  and temps=?  and repetition=? and distance=? where idExercice=? ");
            ps.setFloat(1, duree);
            ps.setInt(2, repetition);
            ps.setFloat(3,distance);
            ps.setInt(4, id);
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
    



    public void inscriTest()
    {
        System.out.println("Entrez votre login");
        Scanner in = new Scanner(System.in);
        String login = in.nextLine();
        if (login == null) {
            System.out.println("Erreur login invalide");
            System.exit(0);
        }
        System.out.println("Entrez votre mot de passe");
        String mdp1 = in.nextLine();
        if (mdp1 == null){
            System.out.println("Erreur mot de passe invalide");
            System.exit(0);
        }
        System.out.println("Entrez à nouveau votre mot de passe");
        String mdp2 = in.nextLine();
        if (mdp2 == null){
            System.out.println("Erreur mot de passe invalide");
            System.exit(0);
        }
        if(!mdp1.equals(mdp2)){
            System.out.println("Les mots de passe ne correspondent pas !");
            System.exit(0);
        }
        System.out.println("Entrez votre nom");
        String nom = in.nextLine();
        if (nom == null) {
            System.out.println("Erreur nom invalide");
            System.exit(0);
        }
        System.out.println("Entrez votre prénom");
        String prenom = in.nextLine();
        if (prenom == null) {
            System.out.println("Erreur prénom invalide");
            System.exit(0);
        }
        System.out.println("Entrez votre email");
        String mail = in.nextLine();
        if (mail == null) {
            System.out.println("Erreur email invalide");
            System.exit(0);
        }
        System.out.println("Entrez votre taille (en cm)");
        int taille = in.nextInt();

        System.out.println("Choisissez votre sexe");
        System.out.println("1 - Homme");
        System.out.println("2 - Femme");
        int s = in.nextInt();
        Sexe sexe;
        if(s==1){
            sexe=Sexe.HOMME;
        } else sexe=Sexe.FEMME;

        System.out.println("Entrez votre date de naissance au format JJ/MM/AAAA");
        String dateNaissance = in.next();
        if (dateNaissance == null) {
            System.out.println("Erreur date de naissance invalide");
            System.exit(0);
        }
        Utilisateur a = new Utilisateur();
        a.register(nom,prenom,mail,mdp1,sexe,dateNaissance,taille,login);
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUtilisateur=" + idUtilisateur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", motdepasse='" + motdepasse + '\'' +
                ", sexe=" + sexe +
                ", dateNaissance='" + dateNaissance + '\'' +
                ", taille=" + taille +
                ", poids=" + poids +
                ", sommeil=" + sommeil +
                ", poidsObjectif=" + poidsObjectif +
                ", login='" + login + '\'' +
                ", plans=" + plans +
                '}';
    }


    public void genererPlanENtrainement(int difficulte)
    {


        PlanEntrainement planEntrainement = new PlanEntrainement(difficulte, 0);
        planEntrainement.addPlanEntrainement();
        planEntrainement.insererPlanEntrainementUtilisateur(this.getIdUtilisateur());
        plans.add(planEntrainement);
        Connection cx = Authentification.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            ps = cx.prepareStatement("Select * FROM ExerciceDefaut");
            rs = ps.executeQuery();
            while(rs.next())
            {
                if(rs.getInt("TypeExercice_idTypeExercice")==1)
                {
                    Anareobis a = new Anareobis(rs.getString("titre"),rs.getNString("description"),rs.getFloat("temps"),rs.getInt("repetition"));
                    a.addExercice();
                    planEntrainement.insererPlanExerciceEntrainement(a.getId());
                }
                else
                {
                    Aerobis b= new Aerobis(rs.getString("titre"),rs.getNString("description"),rs.getFloat("temps"),rs.getInt("distance"));
                    b.addExercice();
                    planEntrainement.insererPlanExerciceEntrainement(b.getId());

                }

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
