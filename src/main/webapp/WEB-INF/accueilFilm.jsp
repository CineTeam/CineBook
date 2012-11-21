<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CinéBook</title>
        <link rel="icon" type="image/x-icon" href="images/favicon.ico" />
        <link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Abel' rel='stylesheet' type='text/css'>
        <link href="style/style.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="style/slider.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/tableaux.js"></script>
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
    <body id="Films">
        <div id="wrapper">
            <c:import url="header.jsp" />

            <div id="page">
                <div id="content">
                    <div class="post">
                        <div id="entete">
                            <h1>Accueil Films - A la une !</h1>
                            <c:import url ="barreRechercheFilms.jsp" />
                        </div>
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            <div id="slider">
                                <form action="ServletVisiteur?action=consulterDetailFilmAction" method="post">
                                    <ul>
                                        <c:if test = "${requestScope.derniersFilmsSortis != null}">
                                            <c:choose>
                                                <c:when test = "${empty requestScope.derniersFilmsSortis}">
                                                    <li>Aucun film</li>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:forEach var="film" items="${requestScope.derniersFilmsSortis}">                           
                                                        <li>
                                                            <a href='#' id="${film.id}" class='clickable'>
                                                                <div class="short_film">
                                                                    <div class="short_img_film">
                                                                        <img src="${film.url_affiche}"/>
                                                                    </div>
                                                                    <div class="short_desc_film size_desc_film_slider">
                                                                        <p class="titre_film">${film.titre}</p>
                                                                        <c:if test = "${film.date_sortie !=null}">Sorti le <f:formatDate value="${film.date_sortie}" type="date" dateStyle="default" /> <br> </c:if>
                                                                        <c:if test = "${film.realisateur !=null}">Par ${film.realisateur} <br></c:if>
                                                                        <c:if test = "${film.acteurs !=null}">Avec ${film.acteurs}</c:if>
                                                                    </div>   
                                                                </div>
                                                            </a>
                                                        </li>
                                                    </c:forEach>
                                                </c:otherwise>                                            
                                            </c:choose>
                                        </c:if>
                                    </ul>
                                    <div class="invisible">
                                        <input id='cpt' type='text' value='test' name='cpt'/>
                                        <input id='bouton' type='submit' />
                                    </div>
                                </form>
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
