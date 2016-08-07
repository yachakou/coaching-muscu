<%@ page import="jdk.nashorn.internal.ir.RuntimeNode" %>
<%--
  Created by IntelliJ IDEA.
  User: yachakou
  Date: 11/03/2015
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<%
    int type=Integer.parseInt(request.getParameter("type"));
    String id=request.getParameter("id");
    out.println(type);
    if (type==1) {
        out.println("<div style=\"background: #4390c8;border-radius:3px;\"><center><h1 style=\"color:white;padding: 10px;\">Saisie d'un exercice de type anaerobis :</h1></center></div>\n");
    }
else {
        out.println("<div style=\"background: #4390c8;border-radius:3px;\"><center><h1 style=\"color:white;padding: 10px;\">Saisie d'un exercice de type aerobis :</h1></center></div>\n");
}

out.println("<form action=\"http://localhost:8080/ControlleurSaisieExo\" role=\"form\"  method=\"POST\"  >\n" +
        "        <div class=\"form-group\">\n" +
        "            <label for=\"time\">Temps (en minutes) :</label>\n" +
        "            <input type=\"number\"  class=\"form-control\" id=\"time\" name=\"time\" placeholder=\"Durée de la seance \" required>\n" +
        "        </div>");

        if (type==1) {
        out.println(" <div class=\"form-group\">\n" +
                "            <label for=\"rep\">Repetitions:</label>\n" +
                "            <input type=\"number\" class=\"form-control\" id=\"rep\" name=\"rep\" placeholder=\"Nombre de repetitions \" required>\n" +
                "            </div>");
            }

            else {
            out.println("  <div class=\"form-group\">\n" +
             "            <label for=\"rep\">Distances:</label>\n" +
             "            <input type=\"number\" class=\"form-control\" id=\"dist\" name=\"dist\" placeholder=\"Distance\" required>\n" +
             "        </div>");
            }
        %>
        <input type='hidden' name='id' value=<%out.println(id);%> />
        <input type='hidden' name='type' value=<%out.println(type);%> />
        <center><input type='submit' value='Enregistrer' class='btn btn-danger' /></center>

    </form>

<%@include file="footer.jsp"%>
