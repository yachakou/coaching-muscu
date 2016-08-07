package Vue;

import Modele.Authentification;

import java.sql.Connection;


/**
 * Created by Mathieu on 11/02/2015.
 */
public class Client {


    public static void main(String[] args) {


        Connection cx =  Authentification.getConnection();

        System.out.printf(cx.toString());
        


    }

}
