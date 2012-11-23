<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html> 
    <head>
    </head>
    <body>
        <%--<form action="ServletVisiteur?action=consulterDetailFilmAction" method="post">
            <table>
                <c:if test = "${requestScope.cinema.seances != null}">
                    <c:choose>
                        <c:when test = "${empty requestScope.cinema.seances}">
                            <tr> Aucune séance n'est disponible pour ce cinema </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="seance" items="${requestScope.cinema.seances}">
                                <tr>
                                    <a href='#' id="${seance.film.id}" class='clickable'>
                                        <div class="short_film short_film_seance">
                                            <div class="short_img_film">
                                                <c:choose>
                                                    <c:when test = "${seance.film.url_affiche !=null}">
                                                        <img src="${seance.film.url_affiche}"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <img src="images/image-film-non-dispo.jpg"/>
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                            <div class="short_desc_film size_desc_film">
                                                <p class="titre_film">${seance.film.titre}</p>
                                                <c:if test = "${seance.film.date_sortie !=null}">Sorti le <f:formatDate value="${seance.film.date_sortie}" type="date" dateStyle="default" /> <br></c:if>
                                                <c:if test = "${seance.film.realisateur !=null}">Par ${seance.film.realisateur} <br></c:if>
                                                <c:if test = "${seance.film.acteurs !=null}">Avec ${seance.film.acteurs}</c:if>
                                            </div>   
                                        </div>
                                    </a>
                                    <div class="details_seance">
                                        <p class="titre_seance">Détails de la séance :</p>
                                        <c:if test = "${seance.format!=null}">Format : ${seance.format} <br></c:if>
                                        <c:if test = "${seance.langue!=null}">Langue : ${seance.langue} <br></c:if>
                                        <c:if test = "${!empty seance.horaires}">
                                            Horaires :
                                            <c:forEach var="horaire" items="${seance.horaires}">
                                                -Pour le <f:formatDate value="${horaire.jour}" type="date" dateStyle="default" /> : 
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
        </form>--%>
    </body>
</html>