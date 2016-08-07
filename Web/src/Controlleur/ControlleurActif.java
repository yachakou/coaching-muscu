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
public class ControlleurActif extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        HttpSession session=request.getSession();
        dispatcher = request.getRequestDispatcher("listePlanEntrainement.jsp");

        if(request.getParameter("id")!=null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Utilisateur u = (Utilisateur) session.getAttribute("user");
            u.updatePlanEntrainementActif(id);

        }


        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
