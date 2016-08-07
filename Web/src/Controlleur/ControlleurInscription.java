package Controlleur;

import Modele.Sexe;
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
 * Created by yachakou on 04/03/2015.
 */
public class ControlleurInscription extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       // out.println("<html><body>");
       // out.println("<h1>Test du COntrolleurInscription</h1>");
       // out.println("<p>");
        String mdp=request.getParameter("pwd");
        String mdp2=request.getParameter("pwd2");
        String login=request.getParameter("login");

       // out.println(" mdp : "+mdp+" "+mdp2);
       // out.println(" log : "+login+" ");

       // out.println("après chargement information");
       // out.println("</p>");
       // out.println("</body></html>");
        if(mdp!=mdp2 || login=="" ) //gerer les deux erreur princpale
        {

        }
        Sexe sexe;
        if(request.getParameter("sexe")=="h")
        {
            sexe = Sexe.HOMME;
        }
        else sexe = Sexe.FEMME;
        Utilisateur u=new Utilisateur();
        float taille = Float.parseFloat(request.getParameter("taille"));
        u.register(request.getParameter("name"),request.getParameter("prenom"),request.getParameter("email"),mdp,sexe,request.getParameter("birthdate"),taille,request.getParameter("login"));

        RequestDispatcher dispatcher;
        HttpSession session=request.getSession();
        session.setAttribute("user",u);
        session.setAttribute("user_valid","true");

        dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request,response);

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Test du COntrolleurInscription</h1>");
        out.println("<p>");
    }
}
