package Controlleur;

import Modele.PlanEntrainement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by malioret on 17/03/2015.
 */
public class ControlleurSuppressionExercice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPlan=0;
        int idExercice=0;
        if(request.getParameter("idExercice")!=null && request.getParameter("idPlan")!=null) {
            idPlan = Integer.parseInt(request.getParameter("idPlan"));
            idExercice = Integer.parseInt(request.getParameter("idExercice"));


            PlanEntrainement p = new PlanEntrainement();
            p.load(idPlan);
            p.suppressionExercice(idExercice);

        }

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("listePlanEntrainement.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
