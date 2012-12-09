<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html> 
    <head></head>
    <body>
        <br><hr />
        
        <div id="recherche_seances">
            <form action="ServletVisiteur?action=consulterDetailFilmAction" method="post">
                Trouvez la prochaine séance la plus proche de chez vous ! <br>
                Saisir un code postal :
                <input type="text" name="cpt" value="${film.id}" style="display:none;"/>
                <input type="text" name="recherche" />                     
                <input type="submit" name="envoyer" value="Valider" />
            </form>
        </div>
        <div class="seances_film">
            <form action="ServletVisiteur?action=consulterDetailCinemaAction" method="post">
                <table>  
                    <c:if test = "${requestScope.cinemas != null}">
                        <c:choose>
                            <c:when test = "${empty requestScope.cinemas}">
                                <tr>Aucun cinema ne correspond à votre recherche</tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="cinema" items="${requestScope.cinemas}" varStatus="status1">
                                      <c:if test = "${cinema.seances_films != null}">
                                            <c:choose>
                                                <c:when test = "${empty cinema.seances_films}">
                                                     Aucune séance n'est disponible pour ce film 
                                                </c:when>
                                                <c:otherwise>
                                                    <c:forEach var="seances_film" items="${cinema.seances_films}">
                                                        <tr>
                                                           <a href='#' id="${cinema.id}" class='clickable'>
                                                               <div class="img_cinema_seance">
                                                                    <c:choose>
                                                                        <c:when test = "${cinema.url_image !=null}">
                                                                            <img src="${cinema.url_image}"/>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <img src="images/image-film-non-dispo.jpg"/>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                               </div>
                                                           </a>
                                                           <div class="detail_cinema_seance">
                                                                <a href='#' id="${cinema.id}" class='clickable'>
                                                                     <div class="short_desc_cinema_film ">
                                                                         <p class="titre_cinema">${cinema.nom}</p>
                                                                         <c:if test = "${cinema.adresse!=null}">${cinema.adresse}<br></c:if>
                                                                         <c:if test = "${cinema.code_postal!=null}">${cinema.code_postal}</c:if> 
                                                                         <c:if test = "${cinema.ville!=null}">${cinema.ville}</c:if>
                                                                     </div>
                                                                </a>   
                                                                <div class="details_seance">
                                                                    Les séances : <br>
                                                                    <c:forEach var="seance" items="${seances_film.seances}" varStatus="status2">
                                                                            <c:if test = "${status2.count==1}">
                                                                                <div class="formats" id="formats_${status1.count}">
                                                                                    <c:forEach var="seance1" items="${seances_film.seances}" varStatus="status3">
                                                                                        <p class="format format_clickable" id="${status1.count}_${status3.count}">
                                                                                            <c:if test = "${!empty seance1.format}">${seance1.format} - </c:if>
                                                                                            <c:if test = "${!empty seance1.langue}">${seance1.langue}</c:if>
                                                                                        </p>
                                                                                    </c:forEach>
                                                                                </div>
                                                                            </c:if>
                                                                            <div id="details_${status1.count}_${status2.count}" class="details_format details_format_${status1.count}">
                                                                                <c:if test = "${!empty seance.horaires}">
                                                                                    Horaires :<br>
                                                                                    <c:forEach var="horaire" items="${seance.horaires}">
                                                                                        - Pour le <f:formatDate value="${horaire.jour}" type="date" dateStyle="default" /> :
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
                                                           </div>                                                   
                                                        </tr>
                                                    </c:forEach>
                                                </c:otherwise>                                            
                                            </c:choose>
                                        </c:if>
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
        </div>
    </body>
</html>