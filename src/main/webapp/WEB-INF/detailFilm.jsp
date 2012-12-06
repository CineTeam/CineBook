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
        <c:import url="header_javascript.jsp" />
    </head>
    <body id="Films">
        <div id="wrapper">
            <c:import url="header.jsp" />
            <div id="page">
                <div id="content">
                    <div class="post">
                        <div id="entete">
                            <h1>Détail du film</h1>
                             <c:import url ="barreRechercheFilms.jsp" />
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
                                                    <c:if test = "${film.realisateur!=null}">Réalisé par ${film.realisateur}<br></c:if>
                                                    <c:if test = "${film.date_sortie!=null}">Sortie le <f:formatDate value="${film.date_sortie}" type="date" dateStyle="default" /><br></c:if>
                                                    <c:if test = "${film.acteurs!=null}">Avec ${film.acteurs}<br></c:if>
                                                    <c:if test = "${film.genres!=null}">
                                                        Genre(s) : 
                                                        <c:forEach var="genre" items="${film.genres}" varStatus="status">
                                                            <c:choose>
                                                                <c:when test = "${status.first}">
                                                                    ${genre}
                                                                </c:when>
                                                                <c:otherwise>
                                                                    , ${genre}
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach><br>
                                                    </c:if>
                                                    <c:if test = "${film.pays!=null}">
                                                        Nationalité(s) : 
                                                        <c:forEach var="pays" items="${film.pays}" varStatus="status">
                                                            <c:choose>
                                                                <c:when test = "${status.first}">
                                                                    ${pays}
                                                                </c:when>
                                                                <c:otherwise>
                                                                    , ${pays}
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach><br>
                                                    </c:if>
                                                    <c:if test = "${film.duree!=null}">Durée : ${film.duree}<br></c:if>
                                                    <c:if test = "${film.note_presse!=null}">Presse : <f:formatNumber value="${film.note_presse}" maxFractionDigits="1" /> / 5<br></c:if>
                                                    <c:if test = "${film.note_utilisateurs!=null}">Spectateurs : <f:formatNumber value="${film.note_utilisateurs}" maxFractionDigits="1" /> / 5</c:if>
                                                </div>
                                            </div>
                                            <div class='bande_annonce'>
                                                <c:if test = "${film.url_bande_annonce!=null}">
                                                    <object width='100%' height='100%'>
                                                        <param name='movie' value='${film.url_bande_annonce}'/>
                                                        <param name='allowFullScreen' value='true'/>
                                                        <param name='allowScriptAccess' value='always'/>
                                                        <embed src='${film.url_bande_annonce}' type='application/x-shockwave-flash' width='100%' height='100%' allowFullScreen='true' allowScriptAccess='always'/>
                                                    </object>
                                                </c:if>
                                           </div>
                                        </div>
                                        <div class="synopsis">
                                             ${film.synopsis}
                                        </div>
                                         <div>
                                            <c:import url="seancesFilm.jsp"/>
                                        </div>
                                    </c:otherwise>                                            
                                </c:choose>
                            </c:if>  
                            <c:if test = "${requestScope.film == null}">  
                                Aucun film ne correspond à votre recherche
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
