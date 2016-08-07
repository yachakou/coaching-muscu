<%@ page import="Utilitaire.Json" %>
<%@ page import="Utilitaire.Serie" %>
<%@ page import="Modele.Utilisateur" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="Modele.Authentification" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="Modele.Seance" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: malioret
  Date: 16/03/2015
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Utilisateur u= (Utilisateur) session.getAttribute("user");

    Json j=new Json("rm.json");
    //valeur par défaut

    Serie x=new Serie("date");
    Serie w=new Serie("poidsOptimale","line");
    Serie y=new Serie("poids");
    Serie s=new Serie("sommeil","column",1);



    Connection conn=  Authentification.getConnection();
    PreparedStatement pstmt = null;
    try {
        pstmt = conn.prepareStatement("SELECT distinct dateUpdate, poids, poidsObjectif,sommeil from DonneesUtilisateurGraphe d where idUtilisateur = ? order by dateUpdate asc");
        pstmt.setInt(1, u.getIdUtilisateur());

        ResultSet rs=pstmt.executeQuery();
        while (rs.next()) {


           x.add(""+rs.getDate("dateUpdate"));
            y.add(rs.getFloat("poids"));
            w.add(rs.getFloat("poidsObjectif"));
            s.add(rs.getInt("sommeil"));

        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erreur lors de du chargement des seances");


    }
    //Sjson+="]);";

    j.add(x);
    j.add(s);
    j.add(w);
    j.add(y);



   // out.println(Sjson);
    out.println(j.genererJsonString());






%>