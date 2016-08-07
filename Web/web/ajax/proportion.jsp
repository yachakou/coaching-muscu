<%@ page import="Modele.Utilisateur" %>
<%@ page import="Modele.Seance" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.List" %>
<%@ page import="Utilitaire.Json" %>
<%@ page import="Utilitaire.Serie" %>
<%@ page import="Utilitaire.MyArray" %>

<%
    Utilisateur u= (Utilisateur) session.getAttribute("user");
    List<Seance> seances2=u.getSeancesPlanEntrainementActif();
    Hashtable<String,Integer> h = new Hashtable<String,Integer>();
    for(Seance s2: seances2)
    {
         h.put(s2.getTitre(),0);
    }

    for(Seance s2: seances2)
    {
         h.put(s2.getTitre(),h.get(s2.getTitre()).intValue()+1);
    }
    //out.println(h.toString());

    Json j=new Json("rm.json");
   Serie x=new Serie("proportion");


    for(int i=0;i<h.size();i++)
    {
        Object[] value=h.values().toArray();
        Object[] keys=h.keySet().toArray();
        MyArray a=new MyArray();
        a.add(keys[i]);
        a.add(value[i]);
        x.add(a);
    }




    j.add(x);
    out.println(j.genererJsonString());

%>