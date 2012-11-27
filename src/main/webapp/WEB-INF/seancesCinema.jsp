<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html> 
    <head>
    </head>
    <body>
        <form action="ServletVisiteur?action=consulterDetailFilmAction" method="post">
            <table>
                <c:if test = "${requestScope.cinema.seances_films != null}">
                    <c:choose>
                        <c:when test = "${empty requestScope.cinema.seances_films}">
                            <tr> Aucune séance n'est disponible pour ce cinema </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="seances_film" items="${requestScope.cinema.seances_films}" varStatus="status1">
                                <tr>
                                    <a href='#' id="${seances_film.film.id}" class='clickable'>
                                        <div class="short_film short_film_seance">
                                            <div class="short_img_film">
                                                <c:choose>
                                                    <c:when test = "${seances_film.film.url_affiche !=null}">
                                                        <img src="${seances_film.film.url_affiche}"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <img src="images/image-film-non-dispo.jpg"/>
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                            <div class="short_desc_film size_desc_film_cinema">
                                                <p class="titre_film">${seances_film.film.titre}</p>
                                                <c:if test = "${seances_film.film.date_sortie !=null}">Sorti le <f:formatDate value="${seances_film.film.date_sortie}" type="date" dateStyle="default" /> <br></c:if>
                                                <c:if test = "${seances_film.film.realisateur !=null}">Par ${seances_film.film.realisateur} <br></c:if>
                                                <c:if test = "${seances_film.film.acteurs !=null}">Avec ${seances_film.film.acteurs}</c:if>
                                            </div>   
                                        </div>
                                    </a>
                                    <div class="details_seance">
                                        <p class="titre_seance">Détails de la séance :</p>
                                        <c:forEach var="seance" items="${seances_film.seances}" varStatus="status2">
                                                <c:if test = "${status2.count==1}">
                                                    <div class="formats">
                                                        <c:forEach var="seance1" items="${seances_film.seances}" varStatus="status3">
                                                            <p class="format format_clickable" id="${status1.count}_${status3.count}">
                                                                <c:if test = "${!empty seance.format}">
                                                                     ${seance1.format}
                                                                </c:if>
                                                                <c:if test = "${empty seance.format}">
                                                                     Inconnu
                                                                </c:if>
                                                            </p>
                                                        </c:forEach>
                                                    </div>
                                                </c:if>
                                                <div id="details_${status1.count}_${status2.count}" class="details_format details_format_${status1.count}">
                                                    <c:if test = "${seance.langue!=null}">Langue : ${seance.langue} <br></c:if>
                                                    <c:if test = "${!empty seance.horaires}">
                                                        Horaires :<br>
                                                        <c:forEach var="horaire" items="${seance.horaires}">
                                                            - Pour le <f:formatDate value="${horaire.jour}" type="date" dateStyle="default" /> : <br>
                                                                <c:forEach var="heure" items="${horaire.heures}" varStatus="status">
                                                                    <c:choose>
                                                                            <c:when test = "${status.first}">
                                                                                ${heure}
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                | ${heure}
                                                                            </c:otherwise>
                                                                    </c:choose>
                                                                </c:forEach><br>
                                                        </c:forEach>
                                                    </c:if>
                                                </div>
                                        </c:forEach>
                                    </div>
                                </tr>
                                <tr>
                                    <br><br>
                                </tr>
                            </c:forEach>
                        </c:otherwise>                                            
                    </c:choose>
                </c:if>
            </table>
            <div class="invisible">
                <input id="cpt" type="text" value="test" name="cpt"/>
                <input id="bouton" type="submit" />
            </div>
        </form>
    </body>
</html>