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
 * Created by Mathieu on 25/03/2015.
 */
public class ControlleurGenerationPlan extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        HttpSession session=request.getSession();
        dispatcher = request.getRequestDispatcher("listePlanEntrainement.jsp");
        Utilisateur u = (Utilisateur) session.getAttribute("user");
        u.genererPlanENtrainement(1);
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
