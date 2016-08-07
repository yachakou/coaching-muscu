package Controlleur;
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
 * Created by Mathieu on 18/02/2015.
 */
public class ControlleurLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Test du COntrolleurLogin</h1>");
        out.println("<p>");
        String username=request.getParameter("email");
        String mdp=request.getParameter("password");
        out.println(" username : "+username);
        out.println(" mdp : "+mdp);

        Utilisateur u=new Utilisateur();
        out.println("avant");
        int valide=u.chargerInformations(username,mdp);
        out.println(u.getMail());
        out.println("après chargement information");
        out.println("</p>");
        out.println("</body></html>");

        RequestDispatcher dispatcher;
        HttpSession session=request.getSession();
        if(valide==1) {

            dispatcher = request.getRequestDispatcher("dashboard.jsp");
            session.setAttribute("user",u);
            session.setAttribute("user_valid","true");
        }
        else {
            dispatcher = request.getRequestDispatcher("accueil.jsp");
            session.setAttribute("user_valid","false");
        }
        dispatcher.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
