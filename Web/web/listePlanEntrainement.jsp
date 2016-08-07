<%@ page import="Modele.Utilisateur" %>
<%@ page import="Modele.PlanEntrainement" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: yachakou
  Date: 04/03/2015
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<%

   



%>

<style>
    input.etoile
    {
        background-image: url("/images/etoile.png");
        width:50px;

    }

</style>

<div class="row contenu" >


    <div class="col-md-12 bloc">
        <div style="background: #4390c8;border-radius:3px;margin-bottom: 6px;"><center><h1 style="color:white;padding: 10px;">Vos plan d'entrainements  : </h1></center></div>


        <%
   Utilisateur u= (Utilisateur) session.getAttribute("user");
    u.loadPlanentrainement();
    //out.println(u.toString());

    out.println(" <table class=\"table table-bordered table-striped table-hover\" style=\"margin-top:15px;\">");

    out.println("<thread><tr>\n" +
            "    <th>#</th>\n" +
            "    <th>difficulté</th>\n" +
            "    <th>durée  (minutes)</th>\n" +
            "    <th>actif</th>\n" +
            "    <th>detail</th>\n" +
            "    <th>action</th>\n" +
            "    </tr></thread>");

    out.println("<tbody>");
    List<PlanEntrainement> plans=u.getPlans();
    for (PlanEntrainement c : plans) {
        out.println("<tr>");
        out.println("<td>"+c.getId()+"</td>");
        //out.println("<td>"+c.getDifficulte()+"</td>");
        out.println("<td>");

        for(int i=0;i<c.getDifficulte() && i<5;i++)
        {
            out.println("<img width='35px' src='/images/etoile.png'>");
        }
        out.println("</td>");
        out.println("<td>"+c.getDuree()+"</td>");
        String actif="<td>";

        if(c.isActif()==false)
        {
            actif+="<form method='POST' action='ControlleurActif'>"+c.isActif();
            actif+="<input name='id' type='hidden' value='"+c.getId()+"'/>";
            actif+="<input style='margin-left:5%;' class=\"btn btn-info\" type='submit' value='activer'/>";
            actif+="</form>";
        }
        else
            actif+=c.isActif();
        actif+="</td>";
        out.println(actif);


        out.println("<td><form method='POST' action='affichagePlanEntrainement.jsp'>" +
                "<input name='id' type='hidden' value='"+c.getId()+"'/>" +
                "<input class=\"btn btn-info\" type='submit' value='voir'/>" +
                "</form></td>" );

        out.println("<td>");
        out.print("<form method='POST' action='ControlleurSuppressionPlan'><span class='glyphicon glyphicon-trash'></span><input name='id' type='hidden' value='"+c.getId()+"'/> <input  style='margin-left:5%;'value='suppression' type='submit'/> </form>");
        out.println("</td>");
    }
        out.println("</tr>");

    out.println("</tbody>");
    out.println("</table>");


    out.println("<p>");
    out.println("");
    out.println("</p>");
            out.println("<form method='POST' action='ControlleurGenerationPlan'>");
            out.println("<center><input type='submit' value='Generer un plan d entrainement' class='btn btn-info' /></center>");
            out.println("</form>");
            out.println("<br><center><button id='ajoutPL' type='button' value='Creer un plan d entrainement' class='btn btn-primary'>Creer un plan d'entrainement</button></center>");
%>



        <div id="ajout" style="display:none;">
            <br>
            <br>
            <div style="background: #4390c8;border-radius:3px;"><center><h1 style="color:white;padding: 10px;">Ajout d'un plan d'entrainement :</h1></center></div>

            <div id='form' >
                <br/>
                <form action="http://localhost:8080/ControlleurAjoutPlanEntrainement" role="form"  method="POST" >

                   <!-- <div class="form-group">
                        <label for="title" >Entrez un titre : </label><input type="text" name="title" id="title" >
                     </div>-->

                    <div class="form-group">
                        choisir un niveau de difficulté (de 1 à 5) :
                        <div>
                        1 : <input type="radio"   class="etoile"  name="difficulte"   value="1">
                        2 : <input type="radio"   class=" etoile" name="difficulte"  value="2">
                        3 : <input type="radio"   class=" etoile" name="difficulte"  value="3">
                        4 : <input type="radio"   class=" etoile" name="difficulte"  value="4">
                        5 : <input type="radio"   class=" etoile" name="difficulte"  value="5">
                        </div>
                    </div>


                    <button type="submit" class="btn btn-default">Ajouter le plan d'entrainement</button>

                </form>
            </div>
        </div>


        </div>



</div>
    <script>
        $("#ajoutPL").click(function(){ document.getElementById("ajout").style.display="block"; });



    </script>
<%@include file="footer.jsp"%>



