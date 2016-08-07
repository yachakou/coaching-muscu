<%@ page import="java.util.List" %>
<%@ page import="Modele.PlanEntrainement" %>
<%@ page import="Modele.AbstractExercice" %>
<%--
  Created by IntelliJ IDEA.
  User: malioret
  Date: 09/03/2015
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<%


    PlanEntrainement p=new PlanEntrainement();
    int id=Integer.parseInt(request.getParameter("id"));
   // out.println(id);
    p.load(id);



%>


<div class="row contenu" >
    <div class="col-md-12 bloc">
        <div style="background: #4390c8;border-radius:3px;margin-bottom: 6px;"><center><h1 style="color:white;padding: 10px;">Le plan d'entrainement  : </h1></center></div>


        <%
            //id,type, titre,temps, description,repetition,distance
            out.println(" <table class=\"table table-bordered table-striped table-hover\" style=\"margin-top:15px;\">");

            out.println("<thread><tr>\n" +
                    "    <th>#</th>\n" +
                    "    <th>type</th>\n" +
                    "    <th>titre</th>\n" +
                    "    <th>temps</th>\n" +
                    "    <th>description</th>\n" +
                    "    <th>repetition</th>\n" +
                    "    <th>distance</th>\n" +
                    "    <th>action</th>\n" +
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
                out.println("<form method='POST' action='ControlleurSuppressionExercice'><span class='glyphicon glyphicon-trash'></span><input name='idExercice' type='hidden' value='"+e.getId()+"'/><input name='idPlan' type='hidden' value='"+p.getId()+"'/> <input  style='margin-left:5%;'value='suppression' type='submit'/></form>");
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</tbody>");
            out.println("</table>");


        %>






    </div>


</div>
<%@include file="ajoutExercice.jsp" %>

<%@include file="footer.jsp"%>