<%@ page import="java.util.List" %>
<%@ page import="Modele.Seance" %>
<%@ page import="java.util.Collections" %>
<%--
  Created by IntelliJ IDEA.
  User: Mathieu
  Date: 15/03/2015
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%

    Utilisateur u = (Utilisateur) session.getAttribute("user");
    List<Seance> seances=u.getSeances();
    Collections.sort(seances,Collections.reverseOrder());


%>

<div class="row contenu" >


    <div class="col-md-12 bloc">
        <div style="background: #4390c8;border-radius:3px;margin-bottom: 6px;"><center><h1 style="color:white;padding: 10px;">Votre historique de vos séances : </h1></center></div>


        <%
            //id,type, titre,temps, description,repetition,distance
            out.println(" <table class=\"table table-bordered table-striped table-hover\" style=\"margin-top:15px;\">");

            out.println("<thread><tr>\n" +
                    "    <th>#</th>\n" +
                    "    <th>type</th>\n" +
                    "    <th>titre</th>\n" +
                    "    <th>temps</th>\n" +
                    "    <th>temps Objectif</th>\n" +
                    "    <th>description</th>\n" +
                    "    <th>repetition</th>\n" +
                    "    <th>repetition Objectif</th>\n" +
                    "    <th>distance</th>\n" +
                    "    <th>distance Objectif</th>\n" +
                    "    <th>date</th>\n" +
                    "    </tr></thread>");

            out.println("<tbody>");



            for (Seance s : seances) {
                out.println("<tr>");
                out.println("<td>"+s.getId()+"</td>");
                out.println("<td>");
                if(s.getType()==1)
                    out.println("anaerobis");
                else
                    out.println("aerobis");
                out.println("</td>");
                out.println("<td>"+s.getTitre()+"</td>");
                out.println("<td>"+s.getTemps()+"</td>");
                out.println("<td>"+s.getObjectifTemps()+"</td>");
                out.println("<td>"+s.getDescription()+"</td>");
                out.println("<td>"+s.getRepetition()+"</td>");
                out.println("<td>"+s.getObjectifRepetition()+"</td>");
                out.println("<td>"+s.getDistance()+"</td>");
                out.println("<td>"+s.getObjectifDistance()+"</td>");
                out.println("<td>"+s.getDate()+"</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");


        %>


    </div>


</div>

<%@include file="footer.jsp"%>