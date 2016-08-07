package Controlleur;


import Modele.PlanEntrainement;
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
public class ControlleurAjoutPlanEntrainement extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        Utilisateur u= (Utilisateur) session.getAttribute("user");

        PlanEntrainement p = new PlanEntrainement();

        if(request.getParameter("difficulte")!=null)
        {
            int difficulte=Integer.parseInt(request.getParameter("difficulte"));
            p.setDifficulte(difficulte);
            p.addPlanEntrainement();
            p.insererPlanEntrainementUtilisateur(u.getIdUtilisateur());

        }
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("listePlanEntrainement.jsp");
        dispatcher.forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
