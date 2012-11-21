<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                            <h1>Détail du film</h1>
                        </div>                        
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            <c:if test = "${requestScope.film != null}">
                                <c:choose>
                                    <c:when test = "${empty requestScope.film}">
                                        Aucun film ne correspond à votre recherche
                                    </c:when>
                                    <c:otherwise>
                                        <div class="bandeau_film">
                                            <div id="film_infos">
                                                <div class="img_film">
                                                    <c:choose>
                                                        <c:when test = "${film.url_affiche !=null}">
                                                            <img src="${film.url_affiche}"/>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <img src="images/image-film-non-dispo.jpg"/>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="short_desc_film">
                                                    <p class="titre_film">${film.titre}</p>
                                                    <p class="p_desc_film">Sortie le <f:formatDate value="${film.date_sortie}" type="date" dateStyle="default" /></p>
                                                    <p class="p_desc_film">Réalisé par ${film.realisateur}</p>
                                                    <p class="p_desc_film">Avec ${film.acteurs}</p>
                                                    <p class="p_desc_film">Genre 
                                                        <c:forEach var="genre" items="${film.genres}">
                                                            <c:when test = "${film.genres[0]} == ${genre}">
                                                                ${genre}
                                                            </c:when>
                                                            <c:otherwise>
                                                                , ${genre}
                                                            </c:otherwise>
                                                        </c:forEach>
                                                    </p>
                                                    <p class="p_desc_film">Nationalité 
                                                        <c:forEach var="nationalite" items="${film.nationalites}">
                                                            <c:when test = "${film.nationalites[0]} == ${nationalite}">
                                                                ${nationalite}
                                                            </c:when>
                                                            <c:otherwise>
                                                                , ${nationalite}
                                                            </c:otherwise>
                                                        </c:forEach>
                                                    </p>
                                                    <p class="p_desc_film"> ${film.acteurs}</p>
                                                    <p class="titre_film">Durée ${film.duree}</p>
                                                    <p class="titre_film">Presse ${film.note_presse}</p>
                                                    <p class="titre_film">Spectateurs ${film.note_utilisateurs}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </c:otherwise>                                            
                                </c:choose>
                            </c:if>
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
