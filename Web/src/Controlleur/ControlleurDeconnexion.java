package Controlleur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Mathieu on 04/03/2015.
 */
public class ControlleurDeconnexion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        HttpSession session=request.getSession();
            dispatcher = request.getRequestDispatcher("accueil.jsp");
            session.removeAttribute("user");
            session.removeAttribute("user_valid");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        HttpSession session=request.getSession();
        dispatcher = request.getRequestDispatcher("accueil.jsp");
        session.removeAttribute("user");
        session.removeAttribute("user_valid");
        dispatcher.forward(request,response);
    }
}
