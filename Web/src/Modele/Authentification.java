package Modele;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Mathieu on 04/02/2015.
 */
public class Authentification {


    static final String url = "jdbc:mysql://mysql1.alwaysdata.com/miagecoaching_database";
    static final String login = "103185";
    static final String passeword = "commit";
    public static Connection cx;


    private Authentification()
    {

        Connection();

    }

    public static void Connection() {
        // TODO Auto-generated method stub

        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("ça marche ");
        }
        catch (Exception ex){
            System.err.println( "Erreur lors du chargement du driver" );
            System.err.println(ex);

            System.exit(1);
        }
        //connexion a la bdd
        try {

            cx = DriverManager.getConnection(url, login, passeword);
            System.out.println("Connexion etablie");



        }
        catch (Exception ec) {
            System.err.println( "Erreur lors de la connexion" );
            System.err.println(ec);

            System.exit(1);

        }


    }

    public static Connection getConnection(){

        if(cx == null){

            Authentification.Connection();
        }

        return cx;

    }

}
