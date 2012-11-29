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
        <link href="style/profil.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/menu.js"></script>
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
                            
                            <div class="mini_profil">
                                <div class="photo_profil">
                                    <img src="images/alexis.jpg"/>
                                </div>
                                <div class="details_profil">
                                    Identité : Alexis Léauté <br>
                                    Rôle : Product Owner <br>
                                    Email : aleaute@epsi.fr <br>
                                </div>
                            </div>
                            
                            <div class="mini_profil decalage">
                                <div class="photo_profil">
                                    <img src="images/krikri.jpg"/>
                                </div>
                                <div class="details_profil">
                                    Identité : Ikram Chraibi <br>
                                    Rôle : <br>
                                    Email : ichraibi@epsi.fr <br>
                                </div>
                            </div>
                            
                            <div class="mini_profil">
                                <div class="photo_profil">
                                    <img src="images/berangere.jpg"/>
                                </div>
                                <div class="details_profil">
                                    Identité : Bérangère Noiraud <br>
                                    Rôle : Développeuse <br>
                                    Email : bnoiraud@epsi.fr <br>
                                </div>
                            </div>
                            
                            <div class="mini_profil decalage">
                                <div class="photo_profil">
                                    <img src="images/vivien.jpg"/>
                                </div>
                                <div class="details_profil">
                                    Identité : Vivien Poirier <br>
                                    Rôle : <br>
                                    Email : vpoirier@epsi.fr <br>
                                </div>
                            </div>
                            
                            <div class="mini_profil">
                                <div class="photo_profil">
                                    <img src="images/cedric.png"/>
                                </div>
                                <div class="details_profil">
                                    Identité : Cédric Fongue <br>
                                    Rôle : <br>
                                    Email : cfongue@epsi.fr <br>
                                </div>
                            </div>
                            
                            <div class="mini_profil decalage">
                                <div class="photo_profil">
                                    <img src="images/image-film-non-dispo.jpg"/>
                                </div>
                                <div class="details_profil">
                                    Identité : Ahmed Mehdi Ben Jemaa <br>
                                    Rôle : <br>
                                    Email : abenjemaa@epsi.fr <br>
                                </div>
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
