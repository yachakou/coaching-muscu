<%--
  Created by IntelliJ IDEA.
  User: malioret
  Date: 03/03/2015
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Miage Coaching ! </title>
    <link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>

    <link href="css/theme.css" rel='stylesheet' type='text/css' />

    <!--start slider -->
    <link rel="stylesheet" href="css/fwslider.css" media="all">

    <!--//scroll-->
    <!-- Add fancyBox light-box -->
    <link rel="stylesheet" type="text/css" href="css/magnific-popup1.css">

</head>
<body>
<!-- start magnific-->
<div id="small-dialog1" class="mfp-hide">
    <div class="pop_up">
        <iframe src="//player.vimeo.com/video/70332985?title=0&amp;byline=0&amp;portrait=0&amp;badge=0" width="100%" height="260" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe> <p><a href="http://vimeo.com/70332985">Reed</a> from <a href="http://vimeo.com/dorianwarneck">Dorian Warneck</a> on <a href="https://vimeo.com">Vimeo</a>.</p>
    </div>
</div>
<!-- end magnific-->

<!----start-container----->
<div class="header-bg" id="home">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="logo"><h1><a href="accueil.jsp">Miage Coaching </a></h1></div>
            </div>
            <div class="col-md-8">
                <div class="h_right">
                    <div class="left">
                        <ul class="menu list-unstyled">
                            <li class="active"><a href="#home" class="scroll">Accueil</a></li>
                            <li><a href="#features" class="scroll">Caractéristiques</a></li>
                            <% if(session !=null && session.getAttribute("user_valid")=="true")
                                out.println("<li><a href='dashboard.jsp' class=''>Dashboard</a></li>");


                            %>

                            <%
                                if(session.getAttribute("user_valid")==null || session.getAttribute("user_valid")=="false")

                                    out.println("<li><a href='inscripion.jsp' class=''>Inscription</a></li>");

                            %>


                        </ul>


                    </div>
                    <%

                        String Formlogin=" <div class=\"right\">\n" +
                                "                        <ul class=\"menu list-unstyled\">\n" +
                                "\n" +
                                "                            <li class=\"login\"><div class=\"log_box\">\n" +
                                "                                <div id=\"loginContainer\">\n" +
                                "                                    <a href=\"#\" id=\"loginButton\" class=\"\"><span>LOGIN</span></a>\n" +
                                "                                    <div id=\"loginBox\" style=\"display: none;\">\n" +
                                "                                        <form id=\"loginForm\" method=\"POST\" action=\"http://localhost:8080/ControlleurLogin\" >\n" +
                                "                                            <fieldset id=\"body\">\n" +
                                "                                                <fieldset>\n" +
                                "                                                    <input type=\"text\"   name=\"email\" id=\"email\" value=\"Username\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Username';}\">\n" +
                                "                                                    <input type=\"password\" name=\"password\" class=\"textbox\" value=\"password\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'password';}\">\n" +
                                "                                                </fieldset>\n" +
                                "                                                <input type=\"submit\" id=\"log\" value=\"Sign in\">\n" +
                                "                                                " +
                                "                                            </fieldset>\n" +
                                "                                        </form>\n" +
                                "                                    </div>\n" +
                                "                                </div>\n" +
                                "                                <div class=\"clearfix\"></div>\n" +
                                "                            </div>\n" +
                                "                            </li>\n" +
                                "\n" +
                                "\n" +
                                "                        </ul>\n" +
                                "                    </div>";


                        String Formlogout=" <div class=\"right\">\n" +
                        "                        <ul class=\"menu list-unstyled\">\n" +
                        "\n" +
                        "                            <li class=\"login\"><div class=\"log_box\">\n" +
                        "                                <div id=\"loginContainer\">\n" +
                        "                                    <a href=\"#\" id=\"loginButton\" class=\"\"><span>Déconnexion</span></a>\n" +
                        "                                    <div id=\"loginBox\" style=\"display: none;\">\n" +
                        "                                        <form id=\"loginForm\" method=\"POST\" action=\"http://localhost:8080/ControlleurDeconnexion\" >\n" +
                        "                                            <fieldset id=\"body\">\n" +
                        "                                                <fieldset>\n" +
                        "                                                  </fieldset>\n" +
                        "                                              Etes vous sûre de vouloir vous déconnecté : ? </br><center><input type=\"submit\" id=\"log\" value=\"Yes\"></center>\n" +
                        "                                              " +
                        "                                            </fieldset>\n" +
                        "                                        </form>\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                                <div class=\"clearfix\"></div>\n" +
                        "                            </div>\n" +
                        "                            </li>\n" +
                        "\n" +
                        "\n" +
                        "                        </ul>\n" +
                        "                    </div>";


                        if(session.getAttribute("user_valid")==null || session.getAttribute("user_valid")=="false")
                            out.println(Formlogin);
                        else
                            out.println(Formlogout);

                    %>



                    <!-- start smart_nav * -->
                    <nav class="nav">
                        <ul class="nav-list">
                            <li class="nav-item"><a href="#home">Home</a></li>
                            <li class="nav-item"><a href="#features" class="scroll">Caractéristiques</a></li>

                            <div class="clearfix"></div>
                        </ul>

                        <div class="nav-mobile"></div></nav>


                    <!-- end smart_nav * -->
                </div>

            </div>
        </div>
    </div>
</div>