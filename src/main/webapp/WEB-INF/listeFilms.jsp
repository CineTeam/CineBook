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
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/tableaux.js"></script>
        <script type="text/javascript" src="js/menu.js"></script>
    </head>
    <body id="Films">
        <div id="wrapper">
            <c:import url="header.jsp" />
            <div id="page">
                <div id="content">
                    <div class="post">
                        <div id="entete">
                            <h1>Liste des films !</h1>
                            <c:import url ="barreRechercheFilms.jsp" />
                        </div>
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            <form action="ServletVisiteur?action=consulterDetailFilmAction" method="post">

                                <table>  
                                    <c:if test = "${requestScope.filmsParNom != null}">
                                        <c:choose>
                                            <c:when test = "${empty requestScope.filmsParNom}">
                                                <tr>Aucun film ne correspond à votre recherche</tr>
                                            </c:when>
                                            <c:otherwise>
                                                <c:forEach var="film" items="${requestScope.filmsParNom}">
                                                    <tr>
                                                        <a href='#' id="${film.id}" class='clickable'>
                                                            <div class="short_film">
                                                                <div class="short_img_film">
                                                                    <c:choose>
                                                                        <c:when test = "${film.url_affiche !=null}">
                                                                            <img src="${film.url_affiche}"/>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <img src="images/image-film-non-dispo.jpg"/>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </div>
                                                                <div class="short_desc_film size_desc_film">
                                                                    <p class="titre_film">${film.titre}</p>
                                                                    <c:if test = "${film.date_sortie !=null}">Sorti le <f:formatDate value="${film.date_sortie}" type="date" dateStyle="default" /> </c:if><br>
                                                                    <c:if test = "${film.realisateur !=null}">Par ${film.realisateur} </c:if><br>
                                                                    <c:if test = "${film.acteurs !=null}">Avec ${film.acteurs}</c:if>
                                                                </div>   
                                                            </div>
                                                        </a>
                                                    </tr>
                                                    <tr>
                                                        <br><br>
                                                    </tr>
                                                </c:forEach>
                                            </c:otherwise>                                            
                                        </c:choose>
                                    </c:if>
                                    <c:if test = "${requestScope.filmsParNom == null}">                                                
                                        <tr>Veuillez saisir un paramètre de recherche !</tr>
                                    </c:if>
                                </table>
                                <div class="invisible">
                                    <input id="cpt" type="text" value="test" name="cpt"/>
                                    <input id="bouton" type="submit" />
                                </div>
                            </form>
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
