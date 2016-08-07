<%--
  Created by IntelliJ IDEA.
  User: yachakou
  Date: 03/03/2015
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="headerAccueil.jsp"%>

<div class="container">
    <div id="error"></div>
    <div class="row">
        <title><i>Page d'inscription</i></title>
        <h1>Page d'inscription</h1>
        <div class="container">
            <form role="form"  method="POST" action="http://localhost:8080/ControlleurInscription" onsubmit="return oncheck(this);" >
                <div class="form-group">
                    <label for="login">Login*:</label>
                    <input type="login" class="form-control" id="login" name="login" placeholder="Entrez votre login" required>
                </div>
                <div class="form-group">
                    <label for="pwd">Mot de passe*:</label>
                    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Entrez votre mot de passe" required>
                </div>
                <div class="form-group">
                    <label for="pwd2">Mot de passe*:</label>
                    <input type="password" class="form-control" id="pwd2" name="pwd2" placeholder="Entrez votre mot de passe à nouveau" required>
                </div>
                <div class="form-group">
                    <label for="prenom">Prenom:</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Entrez votre prenom">
                </div>
                <div class="form-group">
                    <label for="name">Nom:</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="Entrez votre nom">
                </div>
                <div class="form-group">
                    <label for="email">Mail:</label>
                    <input type="mail" class="form-control" id="email" name="email" placeholder="Entrez votre mail">
                </div>
                <div class="form-group">
                <label for="sexe">Sexe:</label>
                    <select id="sexe">
                    <option value="h">Homme</option>
                    <option value="f">Femme</option>
                </select>
                </div>

                <div class="form-group">
                    <label for="birthdate">Date de naissance (au format jj/mm/yyyy):</label>
                    <input type="text" class="form-control" name="birthdate" id="birthdate" placeholder="Entrez votre date de naissance">
                </div>

                <div class="form-group">
                    <label for="taille">Taille (en cm):</label>
                    <input type="number" min=0 value=0 class="form-control" id="taille" name="taille">
                </div>



                <button type="submit" class="btn btn-default">S'inscrire</button>

            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
function oncheck(form)
{

    var pwd = document.getElementById("pwd");
    var pwd2 = document.getElementById("pwd2");
    var error = document.getElementsByName("error");

    if(pwd.value != "" && pwd.value != pwd2.value) {

        $("#error").html("<p><span>Erreur : Les mots de passes  ne correspondent pas ! </span></p>");
        //error.html("<p><b>Erreur sur les mot de passes ! </b></p>");
        return false;
    }
    else return true;
 }
</script>
<%@include file="footerAccueil.jsp"%>

