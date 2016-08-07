<%@ page import="Utilitaire.Json" %>
<%@ page import="Utilitaire.Serie" %>
<%--
  Created by IntelliJ IDEA.
  User: Mathieu
  Date: 04/03/2015
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%


    int p=Integer.parseInt(request.getParameter("poids"));

    Json j=new Json("rm.json");
    //valeur par défaut

    Serie x=new Serie("repetitions");
    Serie y=new Serie("chargeRm");

    int nb=1;
    double rm=0;
    for(nb=1;nb<=100;nb++)
    {
        x.add(nb);
        rm=((0.033*nb)+1)*p;
        y.add((int)rm);
    }

    j.add(x);
    j.add(y);
    out.println(j.genererJsonString());



%>