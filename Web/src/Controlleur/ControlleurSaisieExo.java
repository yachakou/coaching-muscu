package Controlleur;

import Modele.Seance;
import Modele.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yachakou on 17/03/2015.
 */
public class ControlleurSaisieExo extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    int id=Integer.parseInt(request.getParameter("id"));
    int type=Integer.parseInt(request.getParameter("type"));

    float temps=Float.parseFloat(request.getParameter("time"));
    int repetition=0;
    float distance=0;

        if(type==1)
        {
             repetition=Integer.parseInt(request.getParameter("rep"));
        }
        else
        {
             distance=Float.parseFloat(request.getParameter("dist"));
        }

        Seance a = new Seance(id,temps,distance,repetition);
        HttpSession session=request.getSession();
        Utilisateur u= (Utilisateur) session.getAttribute("user");
        a.insererSeance(u.getIdUtilisateur());

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request,response);

    }





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
