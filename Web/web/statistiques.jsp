<%@ page import="Modele.Seance" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="Modele.Authentification" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: Mathieu
  Date: 04/03/2015
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<div class="row contenu" >



    <div class="col-md-12 bloc">

        <div style="background: #4390c8;border-radius:3px;margin-bottom: 6px;"><center><h1 style="color:white;padding: 10px;">Vos statistiques :  </h1></center></div>


        <br>
        <div class="row">

            <div class="col-lg-6">
                <h1>Proportions des séances enregistrés :</h1>

                <%
                    Utilisateur u= (Utilisateur) session.getAttribute("user");
                %>
                <div id="camembert" ></div>

            </div>
            <div class="col-lg-6">



                <div id="camembert2" ></div>

            </div>

        </div>


        <br>
        <br>
        <h1>Vos performances : </h1>
        <%
            String seance= (String) request.getAttribute("seance");
            out.println(seance);
        %>
        indicateur :

        <select id="indicator" name="indicator">
            <option value="1">temps</option>
            <!--<option value="1">temps</option>
            <option value="2">repetition</option>-->
        </select>
        <div id="performance"></div>


        <br>
        <br>
        <h1>Vos objectifs : </h1>
        <div id="objectif"></div>

        <br>
        <br>
        <h1>Graphe RM : </h1>

        <p>
            Un élément essentiel en musculation est de connaitre la charge maximale qui peut être portée, tirée ou encore soulevée.

            Le 1RM correspond à la charge que vous pourrez répéter une seule fois. C’est donc bien votre maximum, à une période donnée (votre 1 RM pourra évoluer au fil des années)

            Cette mesure est très utile pour les sportifs et les entraineurs car elle permet de bien doser l’entrainement en musculation.
        </p>

        <%
            Object po=request.getAttribute("p");
        %>

        Entrez le poids soulevé (kg): <input id="vg" type="number" min="0" name="poids" value="<%=po%>"/>
        <input id="bg" type="button" name="envoyer" value="valider"/>


        <div id="g" ></div>

    </div>


</div>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script>
    $(document).ready(function() {
        $("#seance").change(function()
        {
            texte = document.getElementById("seance").options[document.getElementById('seance').selectedIndex];
            var type=($(texte).attr("data-type"));
            if(type==0)
            {
                $("#indicator").html("<option value='0'>distance</option><option value='1'>temps</option>");
            }
            else
            {
                $("#indicator").html("<option value='2'>repetition</option><option value='1'>temps</option>");
            }
        })
    });
</script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script type="text/javascript" src="/js/graph/objectif.js"></script>
<script type="text/javascript" src="/js/graph/performance.js"></script>
<script type="text/javascript" src="/js/graph/rm.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        // Radialize the colors
        Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {
            return {
                radialGradient: { cx: 0.5, cy: 0.3, r: 0.7 },
                stops: [
                    [0, color],
                    [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
                ]
            };
        });
        var optionsCamembert={
            chart: {
                renderTo: 'camembert',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: 'Pourcentages des types de seances effectués'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}% ' +
                        '</br> value : {point.y}</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %  ',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        },
                        connectorColor: 'silver'
                    }
                }
            },
            series: [{
                type: 'pie',
                name: 'Nombres de seances réalisés',
                data: <%=(String) request.getAttribute("dataCamembert")%>
            }]
        }
        chart2 = new Highcharts.Chart(optionsCamembert);
        var optionsCamembert2={
            chart: {
                renderTo: 'camembert2',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: "Proportions des séances enregistrés du plan d'entrainement actif:"
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}% ' +
                        '</br> value : {point.y}</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %  ',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        },
                        connectorColor: 'silver'
                    }
                }
            },
            series: [{
                type: 'pie',
                name: 'Nombres de seances réalisés',
                data: <%=(String)request.getAttribute("dataCamembert2")%>
            }]
        }
        chart3 = new Highcharts.Chart(optionsCamembert2);
    })
</script>
<script src="http://code.highcharts.com/highcharts-more.js"></script>
<%@include file="footer.jsp"%>