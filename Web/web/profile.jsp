<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: malioret
  Date: 11/03/2015
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<%
    Utilisateur u = (Utilisateur) session.getAttribute("user");




%>
<div class="row contenu" >


    <div class="col-md-12 bloc">
        <div style="background: #4390c8;border-radius:3px;margin-bottom: 6px;"><center><h1 style="color:white;padding: 10px;">Votre profil  : </h1></center></div>

            <div style="margin-left: 5%;">

                <p>
                    <h1>Vos données personnelles :</h1>
                <br>
                   <form method="POST" action="ControlleurProfile">


                <label for="nom">Votre nom :</label>
                    <input type="text" id="nom" name="nom" placeholder="Votre nom" value="<%= u.getNom()%>">
                <br>
                       <br>
                <label for="nom">Votre prénom :</label>
                    <input type="text" id="prenom"  name="prenom" placeholder="Votre prénom" value="<%= u.getPrenom()%>">
                <br>
                       <br>
                <label for="nom">Votre adresse mail  :</label>
                    <input type="text"  id="mail"  name="mail" placeholder="Votre adresse mail" value="<%= u.getMail()%>">
                <br>
                       <br>

                <label for="sexe">Sexe :</label>
                <select name="sexe" id="sexe">
                    <option value="h">Homme</option>
                    <option value="f">Femme</option>
                </select>
                <br>
                       <br>
                <label for="birthdate">Date de naissance (au format jj/mm/yyyy):</label>
                <input type="text" class="form-control" name="date" id="birthdate" placeholder="Entrez votre date de naissance" value="<%=u.getDateNaissance()%>">
                <br>
                       <br>
                <label for="taille">Taille (en cm):</label>
                <input type="number"  step="any" class="form-control" id="taille" name="taille" value="<%= u.getTaille()%>">
                <br>
                       <br>
                       <input type="hidden" name="form" value="1"/>
               <center><input type="submit" value='modifier votre profile' class="btn btn-primary"/></center>



                   </form>



                </p>
                <br>
                <br>
                </div>
                <div style="background: #4390c8;border-radius:3px;margin-bottom: 6px;"><center><h1 style="color:white;padding: 10px;">Vos objectifs : </h1></center></div>

               <div style="margin-left: 5%;"> <p id="objectifs">

                <br/>
                <form method="POST" action="ControlleurProfile">
                    <label for="sommeil">Votre temps de sommeil (en heure):</label>
                    <input type="number"  step="any" class="form-control" id="sommeil" name="sommeil" value="<%=u.getSomeil()%>"> <br>
                    <br>
                    <label for="poids">Votre poids (en kg):</label>
                    <input type="number"  step="any" class="form-control" id="poids" name="poids" value="<%=u.getPoids()%>"> <br>
                    <br>
                    <label for="poidsObjectif">Votre poids désiré(en kg):</label>
                    <input type="number"  step="any" class="form-control" id="poidsObjectif" name="poidsObjectif" value="<%=u.getPoidsObjectif()%>"> <br>
                    <br>
                    <input type="hidden" name="form" value="0"/>
                   <center> <input type="submit" value='enregistrer vos données' class="btn btn-primary"/></center>

                </form>

                   <form method="POST" action="ControlleurProfile">
                       <input type="hidden" name="form" value="2"/>
                     <center>  <input type="submit" value='Desactiver votre compte' class="btn btn-danger" style="margin-top:10px;"/></center>
                   </form>

                </p>

            </div>
    </div>


</div>

<%@include file="footer.jsp"%>