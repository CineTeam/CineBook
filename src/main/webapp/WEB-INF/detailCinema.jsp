<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr-FR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CinéBook</title>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                var latitude = '${requestScope.cinema.position.latitude}';
                var longitude = '${requestScope.cinema.position.longitude}';
                initialize(latitude, longitude);
            });
        </script>
        <c:import url="header_javascript.jsp" />
    </head>
    <body id="Cinémas">
        <div id="wrapper">
            <c:import url="header.jsp" />
            <div id="page">
                <div id="content">
                    <div class="post">
                        <div id="entete">
                            <h1>Détail du cinéma</h1>
                             <c:import url="barreRechercheCinemas.jsp" />
                        </div>                        
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            <c:if test = "${requestScope.cinema != null}">
                                <c:choose>
                                    <c:when test = "${empty requestScope.cinema}">
                                        Aucun cinema ne correspond à votre recherche
                                    </c:when>
                                    <c:otherwise>
                                        <div class="bandeau_cinema">
                                            <div id="cinema_infos">
                                                <div class="img_cinema">
                                                    <c:choose>
                                                        <c:when test = "${cinema.url_image !=null}">
                                                            <img src="${cinema.url_image}"/>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <img src="images/image-cinema-non-dispo.jpg"/>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="short_desc_cinema">
                                                    <p class="titre_cinema">${cinema.nom}</p>
                                                    <c:if test = "${cinema.adresse!=null}">${cinema.adresse}<br></c:if>
                                                    <c:if test = "${cinema.code_postal!=null}">${cinema.code_postal} ${cinema.ville}<br></c:if>
                                                    <c:if test = "${cinema.nombre_salles!=null}">Nombre de salles : ${cinema.nombre_salles}<br></c:if>
                                                    <br>
                                                    <c:if test ="${sessionScope.utilisateur != null}">
                                                        <form action="ServletMembre?action=ajouterCinemaAuxCinemasFrequentesAction" method="post">
                                                            <input type="hidden" name="cpt" value="${requestScope.cinema.id}" />
                                                            <input type="submit" value="Je suis allé dans ce cinéma !" class='button_clickable'/>
                                                        </form>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <div id="googlemap"></div>
                                        </div>
                                        <div class="seances_cinema">
                                            <c:import url="seancesCinema.jsp"/>
                                        </div>
                                        <div class="commentaires">
                                            <c:import url="commentairesCinema.jsp"/>
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
