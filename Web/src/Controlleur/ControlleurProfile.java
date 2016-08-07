package Controlleur;

import Modele.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by malioret on 11/03/2015.
 */
public class ControlleurProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        HttpSession session=request.getSession();
        dispatcher = request.getRequestDispatcher("profile.jsp");
        Utilisateur u = (Utilisateur) session.getAttribute("user");
        if(request.getParameter("form")!=null) {
            int form = Integer.parseInt(request.getParameter("form"));

            if(form==0)
            {
                if(request.getParameter("sommeil")!=null && request.getParameter("poids")!=null && request.getParameter("poidsObjectif")!=null) {
                    float poids=Float.parseFloat(request.getParameter("poids"));
                    float poidsObjectif=Float.parseFloat(request.getParameter("poidsObjectif"));;
                    int sommeil=Integer.parseInt(request.getParameter("sommeil"));;
                    u.updateDonnee(poids,sommeil,poidsObjectif);
                    session.setAttribute("user",u);
                }
            }
            else if(form==1)
            {

                    String nom=request.getParameter("nom");
                    String prenom=request.getParameter("prenom");
                    String mail=request.getParameter("mail");
                    String sexe=request.getParameter("sexe");
                    String date=request.getParameter("date");
                    Float taille=Float.parseFloat(request.getParameter("taille"));
                    u.updateDonneeUser(nom,prenom,mail,sexe,date,taille);
                    session.setAttribute("user",u);


            }
            else if(form==2)
            {
                session.removeAttribute("user");
                session.removeAttribute("user_valid");
                u.suppressionProfil();
                dispatcher = request.getRequestDispatcher("accueil.jsp");

            }
            else
            {

            }



        }


        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
