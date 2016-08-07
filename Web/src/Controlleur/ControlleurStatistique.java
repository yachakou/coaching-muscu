package Controlleur;

import Modele.Authentification;
import Modele.Seance;
import Modele.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by malioret on 17/03/2015.
 */
public class ControlleurStatistique extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session=request.getSession();
        Utilisateur u= (Utilisateur) session.getAttribute("user");



        /* -----------------------------------------------------Graphe camembert proportion aerobis anaerobis*/
        int compteurAnaerobis=0;
        int compteurAerobis=0;
        List<Seance> seances=u.getSeances();
        for(Seance s:seances)
        {

            if(s.getType()==0)
                compteurAerobis++;
            else
                compteurAnaerobis++;
        }

        String dataCamembert="[['anaerobis',"+compteurAnaerobis+"],['aerobis',"+compteurAerobis+"]]";
        request.setAttribute("dataCamembert",dataCamembert);
        /* fin graphe camembert*/



        /*------------------------------------------------------------- graphe camembert 2*/
        List<Seance> seances2=u.getSeancesPlanEntrainementActif();
        Hashtable<String,Integer> h = new Hashtable<String,Integer>();
        for(Seance s2: seances2)
        {
            h.put(s2.getTitre(),0);
        }

        for(Seance s2: seances2)
        {
            h.put(s2.getTitre(),h.get(s2.getTitre()).intValue()+1);
        }
        //out.println(h.toString());

        String dataCamembert2="[";
        for(int i=0;i<h.size();i++)
        {
            Object[] value=h.values().toArray();


            Object[] keys=h.keySet().toArray();

            dataCamembert2+="['"+keys[i]+"',"+value[i]+"]";
            if(i<h.size()-1)
                dataCamembert2+=",";
        }
        dataCamembert2+="]";
        //out.println(dataCamembert2);
        request.setAttribute("dataCamembert2",dataCamembert2);





        /*------------------------------------------------------------------------------ select seance performance */
        String seance="Veuillez choisir une seance : <select name='seance' id='seance'>";

        Connection conn=  Authentification.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT distinct idExercice,titre, TypeExercice_idTypeExercice as type from Seance s, Exercice e where Utilisateur_idUtilisateur = ? and s.Exercice_idExercice=e.idExercice");
            pstmt.setInt(1, u.getIdUtilisateur());

            ResultSet rs=pstmt.executeQuery();
            while (rs.next()) {
                seance+="<option data_type="+rs.getInt("type")+" value="+rs.getInt("idExercice")+">"+rs.getInt("idExercice")+": "+rs.getString("titre")+"</option>";

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de du chargement des seances");


        }
        seance+="</select>";
        request.setAttribute("seance",seance);



        /* -----------------------------------graphe RM------------------------------*/
        int p=10;

        if(request.getParameter("poids")!=null)
            p=Integer.parseInt(request.getParameter("poids"));

        request.setAttribute("p",p);



        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("statistiques.jsp");
        dispatcher.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        HttpSession session=request.getSession();
        Utilisateur u= (Utilisateur) session.getAttribute("user");



        /* -----------------------------------------------------Graphe camembert proportion aerobis anaerobis*/
        int compteurAnaerobis=0;
        int compteurAerobis=0;
        List<Seance> seances=u.getSeances();
        for(Seance s:seances)
        {

            if(s.getType()==0)
                compteurAerobis++;
            else
                compteurAnaerobis++;
        }

        String dataCamembert="[['anaerobis',"+compteurAnaerobis+"],['aerobis',"+compteurAerobis+"]]";
        request.setAttribute("dataCamembert",dataCamembert);
        /* fin graphe camembert*/



        /*------------------------------------------------------------- graphe camembert 2*/
        List<Seance> seances2=u.getSeancesPlanEntrainementActif();
        Hashtable<String,Integer> h = new Hashtable<String,Integer>();
        for(Seance s2: seances2)
        {
            h.put(s2.getTitre(),0);
        }

        for(Seance s2: seances2)
        {
            h.put(s2.getTitre(),h.get(s2.getTitre()).intValue()+1);
        }
        //out.println(h.toString());

        String dataCamembert2="[";
        for(int i=0;i<h.size();i++)
        {
            Object[] value=h.values().toArray();


            Object[] keys=h.keySet().toArray();

            dataCamembert2+="['"+keys[i]+"',"+value[i]+"]";
            if(i<h.size()-1)
                dataCamembert2+=",";
        }
        dataCamembert2+="]";
        //out.println(dataCamembert2);
        request.setAttribute("dataCamembert2",dataCamembert2);





        /*------------------------------------------------------------------------------ select seance performance */
        String seance="Veuillez choisir une seance : <select name='seance' id='seance'>";

        Connection conn=  Authentification.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("SELECT distinct idExercice,titre,TypeExercice_idTypeExercice as type from Seance s, Exercice e where Utilisateur_idUtilisateur = ? and s.Exercice_idExercice=e.idExercice");
            pstmt.setInt(1, u.getIdUtilisateur());

            ResultSet rs=pstmt.executeQuery();
            while (rs.next()) {
                seance+="<option data-type="+rs.getInt("type")+" value="+rs.getInt("idExercice")+">"+rs.getInt("idExercice")+": "+rs.getString("titre")+"</option>";

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de du chargement des seances");


        }
       seance+="</select>";
        request.setAttribute("seance",seance);



        /* -----------------------------------graphe RM------------------------------*/
        int p=10;

        if(request.getParameter("poids")!=null)
            p=Integer.parseInt(request.getParameter("poids"));

        request.setAttribute("p",p);



        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("statistiques.jsp");
        dispatcher.forward(request,response);



    }
}
