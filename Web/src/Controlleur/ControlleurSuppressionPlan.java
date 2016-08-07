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
public class ControlleurSuppressionPlan extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id=0;
        if(request.getParameter("id")!=null) {
            id = Integer.parseInt(request.getParameter("id"));


            PlanEntrainement p = new PlanEntrainement();
            p.load(id);
            p.removePlanEntrainement();
        }

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("listePlanEntrainement.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
