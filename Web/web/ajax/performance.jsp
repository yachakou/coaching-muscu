<%@ page import="Modele.Utilisateur" %>
<%@ page import="Utilitaire.Json" %>
<%@ page import="Utilitaire.Serie" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="Modele.Authentification" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: Mathieu
  Date: 16/03/2015
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
Utilisateur u= (Utilisateur) session.getAttribute("user");

Json j=new Json("rm.json");
//valeur par défaut

Serie x=new Serie("date");
Serie t=new Serie("temps","line");
Serie to=new Serie("temps Objectif","line");
Serie tratio=new Serie("temps ratio","column",1);
Serie d=new Serie("distance","line");
Serie dob=new Serie("distance Objectif","line");
Serie dratio=new Serie("distance ratio","column",1);
Serie r=new Serie("repetition","line");
Serie ro=new Serie("repetition Objectif","line");
Serie rratio=new Serie("repetition ratio","column",1);



int idExercice=Integer.parseInt(request.getParameter("id"));
Connection conn=  Authentification.getConnection();
PreparedStatement pstmt = null;
try {
pstmt = conn.prepareStatement("SELECT s.date, s.temps, s.distance, s.repetition, e.repetition as repetitionObjectif, e.distance as distanceObjectif, e.temps as tempsObjectif" +
        " from Seance s, Exercice e where Utilisateur_idUtilisateur = ? and Exercice_idExercice=? and s.Exercice_idExercice=e.idExercice");
pstmt.setInt(1, u.getIdUtilisateur());
pstmt.setInt(2,idExercice);

ResultSet rs=pstmt.executeQuery();
while (rs.next()) {


x.add(""+rs.getTimestamp("date"));
to.add(rs.getFloat("tempsObjectif"));
t.add(rs.getFloat("temps"));
tratio.add(rs.getFloat("temps")/rs.getFloat("tempsObjectif")*100);
d.add(rs.getFloat("distance"));
dob.add(rs.getFloat("distanceObjectif"));
dratio.add(rs.getFloat("distance")/rs.getFloat("distanceObjectif")*100);
r.add(rs.getInt("repetition"));
ro.add(rs.getInt("repetitionObjectif"));
rratio.add(rs.getFloat("repetition")/rs.getFloat("repetitionObjectif")*100);


}
} catch (SQLException e) {
e.printStackTrace();
System.out.println("Erreur lors de du chargement des seances");


}
//Sjson+="]);";

j.add(x);
    int indicator=Integer.parseInt(request.getParameter("indicator"));
    if(indicator==0)
    {
        j.add(dratio);
        j.add(d);
        j.add(dob);

    }
    else if(indicator==1)
    {
        j.add(tratio);
        j.add(t);
        j.add(to);

    }
    else if(indicator==2)
    {
        j.add(rratio);
        j.add(r);
        j.add(ro);

    }

//j.add(t);
//j.add(d);
//j.add(r);




// out.println(Sjson);
out.println(j.genererJsonString());
    %>