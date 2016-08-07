package Modele;

/**
 * Created by philprat on 04/02/2015.
 */
public interface IService {


    public void affichagePlanEntrainement();

     public void affichageStatistiques();

    public void ajouterExercice(String titre, String description, int temps);

    public void creerProgramme(float difficulte, int duree);

     public void entrerDonneesSeance();

    public void genererExercice();

    public void exerciceAccepte(AbstractExercice exercice);

    public void refutExercice(AbstractExercice exercice);

    public void modifierDonneesUtilisateur();

    public void supprimerProfil();

    public void supprimerExercice(AbstractExercice exercice);
}
