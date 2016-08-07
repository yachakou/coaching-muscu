<%--
  Created by IntelliJ IDEA.
  User: Mathieu
  Date: 26/02/2015
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!----start-container----->

<style>

    .nav li a
      {
          color:white;
      }

    .nav li a:hover
    {
        color: rgb(233, 235, 246);
        background-color: rgb(133,185,229);
    }

    .nav li
    {
        border-bottom-color: white;
        border-bottom:1px solid;
        padding:2px;

    }

    a.list-group-item
    {
        background-color: rgb(133,185,229);
        color:white;
        border:0px solid;
        margin-bottom: 5px;
    }

    .panel
    {
        border:0px solid;
        background-color: rgb(133,185,229) ;
    }

    a.list-group-item.mitem
    {
        border-bottom:1px solid white;
    }

    a.list-group-item.sitem
    {
        padding-left:35px;
    }
</style>
<div class="container-fluid">
    <div class="row" style="background-color: rgb(133,185,229) ;">

        <div class="col-md-2" >


            <div id="MainMenu"  style="display:block;color:white;">
                <div class="list-group panel">
                    <a href="#demo3" class="list-group-item mitem" data-toggle="collapse" data-parent="#MainMenu"><span class="glyphicon glyphicon-list-alt"></span> Vos plans d'entrainements </a>
                    <div class="collapse" id="demo3">
                        <a href="listePlanEntrainement.jsp" class="list-group-item sitem"><span class="glyphicon glyphicon-chevron-right"></span> Gérer vos plans d'entrainements <i class="fa fa-caret-down"></i></a>
                        <a href="affichagePlanEntrainementActif.jsp" class="list-group-item sitem"><span class="glyphicon glyphicon-chevron-right"></span> Votre plan d'entrainement actif</a>

                    </div>
                    <a href="ControlleurStatistique" class="list-group-item mitem" ><span class="glyphicon glyphicon-stats"></span> Vos statistiques</a>



                    <a href="seances.jsp" class="list-group-item mitem"  ><span class="glyphicon glyphicon-time"></span> Votre historique de vos séances</a>



                    <a href="profile.jsp#objectifs" class="list-group-item mitem" ><span class="glyphicon glyphicon-check"></span> Vos objectifs</a>

                    <!--
                    <a href="#demo7" class="list-group-item mitem" data-toggle="collapse" data-parent="#MainMenu"><span class="glyphicon glyphicon-book"></span> Information</a>
                    <div class="collapse" id="demo7">
                        <a href="" class="list-group-item sitem"><span class="glyphicon glyphicon-chevron-right"></span>Sécurité</a>
                        <a href="" class="list-group-item sitem"><span class="glyphicon glyphicon-chevron-right"></span> Subitem 14</a>
                        <a href="" class="list-group-item sitem"><span class="glyphicon glyphicon-chevron-right"></span> Subitem 15</a>
                    </div>
                    -->
                </div>
            </div>







        </div>


        <div class="col-md-10" style="background-color: white;">











