package Test;


import Modele.Sexe;
import Modele.Utilisateur;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        a.setMail("mat.lioret@gmail.com");

        b=new Utilisateur();
        d=new Utilisateur();
        c=new Utilisateur();
        d.setIdUtilisateur(7);


    }

    @After
    public void tearDown() throws Exception {
        a=null;
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
    public void testRegister() throws Exception {
        c.register("test","test","mail","mdp", Sexe.HOMME,"25/06/1965",1,"logtest");
        assertEquals(c.getIdUtilisateur(),d.getIdUtilisateur());

    }
}