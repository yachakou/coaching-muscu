<%--
  Created by IntelliJ IDEA.
  User: Mathieu
  Date: 26/02/2015
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>

<style>

    .bloc2
    {
        padding:10px;

        border-bottom: 0px solid black;
        min-height: 500px;
        border-right:1px solid rgb(211, 220, 226);

    }

    .bloc3
    {
        padding:10px;

        border-bottom: 0px solid black;
        min-height: 500px;

    }
</style>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<div class="row contenu bloc" >

    <div style="background: #4390c8;border-radius:3px;margin-bottom: 6px;"><center><h1 style="color:white;padding: 10px;">Vos statistiques</h1></center></div>
    <div class="col-md-6 bloc2">



            <!--
            <center><h1>Votre séance du jour</h1></center>

            <p>
                <br>
                <span class="gras">Titre </span>:  Footing level 1
                <br><br>
                <span class="gras">Description </span> :
                Cet exercice consiste à courir pendant 5 kilomètres et un chrono de 10 minutes serait très apprécié.
            </p>
            <br>
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="distance" class="col-sm-2 control-label">Distance</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="distance" placeholder="Distance">
                    </div>
                </div>
                <div class="form-group">
                    <label for="temps" class="col-sm-2 control-label">temps</label>
                    <div class="col-sm-10">
                        <input type="temps" class="form-control" id="temps" placeholder="temps">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-info" style="float:none;">Enregistrer votre séance</button>
                    </div>
                </div>
            </form>
            -->
        <!--
          <center><h1>Proportion des types d'exercices : </h1></center>
           <center> <img class="img-responsive"  style="height:300px;" src="images/camembert.PNG"></center>
-->
        <center>  <div id="camembert2" ></div></center>



    </div>


    <div class="col-md-6 bloc3" style="min-height: 374px;">
       <!-- <center><h1>Représentation de y en fonction de x</h1></center>
        <img src="images/graphe.PNG">-->
        <center><h1>Vos objectifs : </h1></center>
        <center><div id="objectif"></div></center>

    </div>

    <center><a href="ControlleurStatistique" class="btn btn-info" style="float:none;">Consulter plus de statistiques</a></center>
    <br>

    <div class="">
        <%@include file="planEntrainementActif.jsp"%>
        <center><a href="listePlanEntrainement.jsp" class="btn btn-info" style="margin-top:10px;float:none;">Gérer vos plans d'entrainements</a></center>
    </div>

</div>








<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script type="text/javascript" src="/js/graph/objectif.js"></script>
<script type="text/javascript" src="/js/graph/proportion.js"></script>
<%@include file="footer.jsp"%>