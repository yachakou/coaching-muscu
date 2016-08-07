package Controlleur;

import Modele.Aerobis;
import Modele.Anareobis;
import Modele.PlanEntrainement;
import Modele.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yachakou on 11/03/2015.
 */
public class ControlleurAjoutExercice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Test du COntrolleurInscription</h1>");





        String type=request.getParameter("type");
        String titre=request.getParameter("title");
        String temps=request.getParameter("time");
        String desc=request.getParameter("desc");
        int id=Integer.parseInt(request.getParameter("idPlan"));


        out.println("<p>");
        out.println("type "+type);
        out.println("</p>");


        HttpSession session=request.getSession();
        Utilisateur u= (Utilisateur) session.getAttribute("user");
        //int id=u.getIDPlanEntrainementActif();
        PlanEntrainement p = new PlanEntrainement();
        p.load(id);

        if(Integer.parseInt(type)==0)
        {
           String repetition=request.getParameter("rep");
            Anareobis a =new Anareobis(titre,desc,Float.parseFloat(temps),Integer.parseInt(repetition));
            int nb = a.addExercice();
            p.insererPlanExerciceEntrainement(nb);
        }
        else
        {
           String distance=request.getParameter("dist");
            Aerobis a = new Aerobis(titre,desc,Float.parseFloat(temps),Integer.parseInt(distance));
            int nb = a.addExercice();
            p.insererPlanExerciceEntrainement(nb);
        }

       /* out.println("après chargement information");
        out.println("</p>");
        out.println("</body></html>");*/

        RequestDispatcher dispatcher;

        dispatcher = request.getRequestDispatcher("listePlanEntrainement.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
