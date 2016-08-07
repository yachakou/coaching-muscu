<%--
  Created by IntelliJ IDEA.
  User: Mathieu
  Date: 18/02/2015
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="headerAccueil.jsp"%>

<!----start-images-slider---->
<div class="images-slider">
    <!-- start slider -->
    <div id="fwslider">
        <div class="slider_container">
            <div class="slide">
                <!-- Slide image -->
                <img src="images/banner2.jpg" alt=""/>
                <!-- /Slide image -->
                <!-- Texts container -->
                <div class="slide_content">
                    <div class="slide_content_wrap">
                        <!-- Text title -->
                        <h4 class="title">Suivez vos performances</h4>
                        <h4 class="title">Accomplisez vos objectifs ! </h4>
                        <!-- /Text description -->
                        <div class="slide-btns description">
                        </div>
                       <!-- <a class="popup-with-zoom-anim jp-video-play-icon" href="#small-dialog1"><img src="images/play.png" alt=""></a>
-->

                        <!-- start magnific-->
                        <!--
                        <div id="small-dialog1" class="mfp-hide">
                            <div class="pop_up">
                                <iframe src="//player.vimeo.com/video/70332985?title=0&amp;byline=0&amp;portrait=0&amp;badge=0" width="100%" height="260" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe> <p><a href="http://vimeo.com/70332985">Reed</a> from <a href="http://vimeo.com/dorianwarneck">Dorian Warneck</a> on <a href="https://vimeo.com">Vimeo</a>.</p>
                            </div>
                        </div>
                        <!-- end magnific-->

                            <!--
                        <div class="buttons">
                            <button class="btn btn-2 btn-2b">Start using now!</button>
                            <button class="btn1 btn-2 btn-2b">Features you get</button>
                            <div class="clearfix"></div>
                        </div>
                        -->
                    </div>
                </div>
                <!-- /Texts container -->
            </div>
            <!-- /Duplicate to create more slides -->
            <div class="slide">
                <img src="images/banner3.jpg" alt=""/>
                <div class="slide_content">
                    <div class="slide_content_wrap">
                        <!-- Text title -->
                        <h4 class="title">Libre à vous de progresser</h4>
                        <h4 class="title">Dépassez vous ! </h4>
                        <!-- /Text description -->
                        <div class="slide-btns description">
                        </div>
                       <!-- <a class="popup-with-zoom-anim jp-video-play-icon" href="#small-dialog1"><img src="images/play.png" alt=""></a>
-->
                        <!-- start magnific-->
                        <div id="small-dialog1" class="mfp-hide">
                            <div class="pop_up">
                            <!--    <iframe src="//player.vimeo.com/video/70332985?title=0&amp;byline=0&amp;portrait=0&amp;badge=0" width="100%" height="260" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe> <p><a href="http://vimeo.com/70332985">Reed</a> from <a href="http://vimeo.com/dorianwarneck">Dorian Warneck</a> on <a href="https://vimeo.com">Vimeo</a>.</p>
                           --> </div>
                        </div>
                        <!-- end magnific-->
                        <!--
                        <div class="buttons">
                            <button class="btn btn-2 btn-2b">Start using now!</button>
                            <button class="btn1 btn-2 btn-2b">Features you get</button>
                            <div class="clearfix"></div>
                        </div>
                        -->
                    </div>
                </div>
            </div>
            <!--/slide -->
        </div>
        <div class="timers"> </div>
        <div class="slidePrev"><span> </span></div>
        <div class="slideNext"><span> </span></div>
    </div>
    <!--/slider -->
</div>

<!--- features--->
<div class="container">
    <div class="row">
        <div class="content-feature-grids" id="features">
            <h3> Caractéristiques</h3>
            <p><b>Miage coaching !</b> vous permet de suivre vos performances et votre évolution dans la pratique d'un sport.</p>
            <div class="col-md-6">

                <div class="feature-grid">
                    <div class="feature-grid-left icon2">
                        <span> </span>
                    </div>
                    <div class="feature-grid-right">
                        <h2>Des plan entrainements adaptés</h2>
                        <p> Nous vous proposons des plan entrainements adaptés en fonction de votre performance. Vous avez la liberté de choisir et de personnaliser votre entrainement tout en progressant.</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="feature-grid">
                    <div class="feature-grid-left icon3">
                        <span> </span>
                    </div>
                    <div class="feature-grid-right">
                        <h2>   Historique</h2>
                        <p> Vous pouvez consulter l' historique de vos performances et chaque jour enregistrer une séance  </p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="col-md-6">

                <div class="feature-grid">
                    <div class="feature-grid-left icon5">
                        <span> </span>
                    </div>
                    <div class="feature-grid-right">
                        <h2>Vos objectifs</h2>
                        <p> Vous pouvez déterminer des objectifs et les accomplir. Nous suivons également le temps de sommeil et votre poids pour vous aider de notre mieux.</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="feature-grid">
                    <div class="feature-grid-left icon6">
                        <span> </span>
                    </div>
                    <div class="feature-grid-right">
                        <h2>Statistiques</h2>
                        <p>Nous vous proposons des graphiques et des statistques de vos performances. Vous pouvez ainsi suivre votre évolution et améliorer votre entrainement.</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

<%@include file="footerAccueil.jsp"%>

