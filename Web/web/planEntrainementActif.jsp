<%@ page import="Modele.Utilisateur" %>
<%@ page import="Modele.PlanEntrainement" %>
<%@ page import="Modele.AbstractExercice" %>
<%@ page import="java.util.List" %>
<%

    Utilisateur u= (Utilisateur) session.getAttribute("user");
    u.loadPlanentrainement();
    PlanEntrainement p=new PlanEntrainement();
    int id=u.getIDPlanEntrainementActif();
    p.load(id);



%>

<div style="background: #4390c8;border-radius:3px;"><center><h1 style="color:white;padding: 10px;">Votre plan d'entrainement actif :</h1></center></div>


<%
    //id,type, titre,temps, description,repetition,distance
    out.println(" <table class=\"table table-bordered table-striped table-hover\" style=\"margin-top:15px;\">");

    out.println("<thread><tr>\n" +
            "    <th>#</th>\n" +
            "    <th>type</th>\n" +
            "    <th>titre</th>\n" +
            "    <th>temps (en minutes)</th>\n" +
            "    <th>description</th>\n" +
            "    <th>repetition</th>\n" +
            "    <th>distance</th>\n" +
            "    <th>Saisir une seance</th>\n" +
            "    </tr></thread>");

    out.println("<tbody>");

    List<AbstractExercice> exercices=p.getExercices();
    for (AbstractExercice e : exercices) {
        out.println("<tr>");
        out.println("<td>"+e.getId()+"</td>");

        out.println("<td>");
        if(e.getType()==1)
            out.println("anaerobis");
        else
            out.println("aerobis");
        out.println("</td>");
        out.println("<td>"+e.getTitre()+"</td>");
        out.println("<td>"+e.getDuree()+"</td>");
        out.println("<td>"+e.getDesc()+"</td>");
        out.println("<td>"+e.getRepetition()+"</td>");
        out.println("<td>"+e.getDistance()+"</td>");
        out.println("<td>");
        out.println("<form method='POST' action='saisieExercice.jsp'>");
        out.println("<input type='hidden' name='id' value='"+e.getId()+"' />");
        out.println("<input type='hidden' name='type' value='"+e.getType()+"' />");
        out.println("<input type='submit' value='Saisir' class='btn btn-danger' />");

        out.println("</form>");

        out.println("</td>");
        out.println("</tr>");
    }
    out.println("</tbody>");
    out.println("</table>");

    out.println("<form method='POST' action='ControlleurGenerationPlan'>");
    out.println("<center><input type='submit' value='Generer un plan d entrainement' class='btn btn-info' /></center>");
    out.println("</form>");

%>

<%@include file="ajoutExercice.jsp" %>