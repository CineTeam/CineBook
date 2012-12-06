<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CinéBook</title>
        <link rel="icon" type="image/x-icon" href="images/favicon.ico" />
        <link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Abel' rel='stylesheet' type='text/css'>
        <link href="style/style.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="style/slider.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="style/profil.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/menu.js"></script>
        <script type="text/javascript" src="js/easySlider1.7.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $("#slider").easySlider({
                    auto: true,
                    continuous: true,
                    numeric: false,
                    speed:800,
                    prevId:'prevBtn',
                    prevText:'<<&nbsp;&nbsp;',
                    nextId: 'nextBtn',
                    nextText: '&nbsp;&nbsp;>>',
                    pause:2500
                });
            });
        </script>
    </head>
    <body id="Accueil">
        <div id="wrapper">
            <c:import url="header.jsp" />
            <div id="page">
                <div id="content">
                    <div class="post">
                        <h1>Bienvenue sur CineBook</h1>
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            
                            <p class="titre_accueil">Le site de référencement des cinemas et des films vous présente son équipe ! </p>
                            <div id="slider">       
                                <ul>
                                    <li>
                                        <div class="mini_profil">
                                            <div class="photo_profil">
                                                <img src="images/alexis.jpg"/>
                                            </div>
                                            <div class="details_profil size_desc_mini_profil_slider">
                                                Identité : Alexis Léauté <br>
                                                Rôle : Product Owner <br>
                                                Email : aleaute@epsi.fr <br>
                                            </div>   
                                        </div>
                                    </li>                 
                                    <li>
                                        <div class="mini_profil">
                                            <div class="photo_profil">
                                                <img src="images/krikri.jpg"/>
                                            </div>
                                            <div class="details_profil size_desc_mini_profil_slider">
                                                Identité : Ikram Chraibi <br>
                                                Rôle : Développeuse <br>
                                                Email : ichraibi@epsi.fr <br>
                                            </div>   
                                        </div>
                                    </li>           
                                    <li>
                                        <div class="mini_profil">
                                            <div class="photo_profil">
                                                <img src="images/berangere.jpg"/>
                                            </div>
                                            <div class="details_profil size_desc_mini_profil_slider">
                                                Identité : Bérangère Noiraud <br>
                                                Rôle : Développeuse <br>
                                                Email : bnoiraud@epsi.fr <br>
                                            </div>   
                                        </div>
                                    </li>        
                                    <li>
                                        <div class="mini_profil">
                                            <div class="photo_profil">
                                                <img src="images/vivien.jpg"/>
                                            </div>
                                            <div class="details_profil size_desc_mini_profil_slider">
                                                Identité : Vivien Poirier <br>
                                                Rôle : Développeur <br>
                                                Email : vpoirier@epsi.fr <br>
                                            </div>   
                                        </div>
                                    </li> 
                                    <li>
                                        <div class="mini_profil">
                                            <div class="photo_profil">
                                                <img src="images/cedric.png"/>
                                            </div>
                                            <div class="details_profil size_desc_mini_profil_slider">
                                                Identité : Cédric Fongue <br>
                                                Rôle : Développeur <br>
                                                Email : cfongue@epsi.fr <br>
                                            </div>   
                                        </div>
                                    </li>
                                    <li>
                                        <div class="mini_profil">
                                            <div class="photo_profil">
                                                <img src="images/ahmed.png"/>
                                            </div>
                                            <div class="details_profil size_desc_mini_profil_slider">
                                                Identité : Ahmed Mehdi Ben Jemaa <br>
                                                Rôle : Développeur <br>
                                                Email : abenjemaa@epsi.fr <br>
                                            </div>   
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div style="clear: both;">&nbsp;</div>
                </div>
                <div style="clear: both;">&nbsp;</div>
            </div>
        </div>
        <c:import url="footer.jsp" />
    </body>
</html>
