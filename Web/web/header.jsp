<%@ page import="Modele.Utilisateur" %>
<%--
  Created by IntelliJ IDEA.
  User: Mathieu
  Date: 26/02/2015
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    if(session.getAttribute("user")==null)
    {
       RequestDispatcher dispatcher = request.getRequestDispatcher("accueil.jsp");
        dispatcher.forward(request,response);
    }

%>



<!DOCTYPE HTML>
<html>
<head>
    <title>Miage Coaching ! </title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>

    <link href="css/theme.css" rel='stylesheet' type='text/css' />

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script src="js/css3-mediaqueries.js"></script>
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

    <script src="js/fwslider.js"></script>
    <!--end slider -->
    <!--  jquery plguin -->
    <script src="js/login.js"></script>
    <script src="js/modernizr.custom.js"></script>


    <!--scroll-->
    <script type="text/javascript">
        $(document).ready(function() {

            var defaults = {
                containerID: 'toTop', // fading element id
                containerHoverID: 'toTopHover', // fading element hover id
                scrollSpeed: 1200,
                easingType: 'linear'
            };


            $().UItoTop({ easingType: 'easeOutQuart' });

        });
    </script>
    <!--//scroll-->
    <!-- scroll_top_btn -->
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event){
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
            });
        });
    </script>



</head>

<style>
    .contenu h1
    {
        color:#428bca;
        font-size: 20px;

    }


    .bloc
    {
        padding:10px;
        border:1px solid rgb(211, 220, 226);
        border-bottom: 0px solid black;
        min-height: 435px;
    }

    th{
        font-weight: bold;
    }

    .gras
    {
        font-weight: bold;
    }
</style>
<body>


<div class="header-bg" id="home">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4">
                <div class="logo"><h1><a href="accueil.jsp">Miage Coaching </a> <a href="dashboard.jsp"><span style="color:black">- Dashboard</span></a></h1></div>
            </div>
            <div class="col-md-8">

                <!--<div class="row">

                    <div class="col-md-8">
                        <!--
                        <div style="background-color: rgb(133, 185, 229);
padding: 10px;
border-radius: 5px;margin:-8px;">
                            <center> <h1 style="color:white"> Vos objectifs</h1></center>
                            <p>Poids actuels </p>

                        </div>
                    </div>
                    <div class="col-md-4">
-->


                <div class="h_right">


                    <div class="left">
                        <ul class="menu list-unstyled">
                            <!--
                            <li class="active"><a href="#home" class="scroll">Accueil</a></li>
                            <li><a href="#features" class="scroll">Caractéristiques</a></li>
                            !-->

                        </ul>
                    </div>
                    <div class="right">
                        <ul class="menu list-unstyled">
                            <li class="login"><div class="log_box">
                                <div id="loginContainer">
                                    <span class="glyphicon glyphicon-user"></span><a href="#" id="loginButton" class=""><span><%= ((Utilisateur)session.getAttribute("user")).getLogin() %></span></a>
                                    <div id="loginBox" style="display: none;">
                                        <div id="loginForm" style="width:200px;padding:5px;-moz-box-shadow: 5px 5px 5px 0px #656565;
-webkit-box-shadow: 5px 5px 5px 0px #656565;
-o-box-shadow: 5px 5px 5px 0px #656565;
box-shadow: 5px 5px 5px 0px #656565;
filter:progid:DXImageTransform.Microsoft.Shadow(color=#656565, Direction=134, Strength=5);
-moz-border-radius: 10px;
-webkit-border-radius: 10px;
border-radius: 10px;">
                                        <a href="profile.jsp">Votre profil</a><br>
                                        <a href="/ControlleurDeconnexion">Se déconnecter</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                                <!-- end_login_box --></li>
                        </ul>
                    </div>
                    <!-- start login_box -->
              <!--  </div>


                    </div>-->

                    <!-- start smart_nav *
                    <nav class="nav">
                        <ul class="nav-list">
                            <li class="nav-item"><a href="#home">Home</a></li>
                            <li class="nav-item"><a href="#features" class="scroll">Caractéristiques</a></li>

                            <div class="clearfix"></div>
                        </ul>

                        <div class="nav-mobile"></div></nav>

                    <script type="text/javascript" src="js/responsive.menu.js"></script>
                    <!-- end smart_nav * -->
                </div>

            </div>
        </div>
    </div>
</div>

<%@include file="menu.jsp"%>