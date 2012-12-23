<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CinéBook</title>
        <c:import url="header_javascript.jsp" />
    </head>
    <body id="Cinémas">
        <div id="wrapper">
            <c:import url="header.jsp" />
            <div id="page">
                <div id="content">
                    <div class="post">
                        <div id="entete">
                            <h1>Liste des cinemas <c:if test ="${pageContext.request.getParameter('action') eq 'recupererCinemasFrequentesAction'}" > fréquentés </c:if>!</h1>
                             <c:import url="barreRechercheCinemas.jsp" />
                        </div>                        
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            <form action="ServletVisiteur?action=consulterDetailCinemaAction" method="post">

                                <table>  
                                    <c:if test = "${requestScope.cinemas != null}">
                                        <c:choose>
                                            <c:when test = "${empty requestScope.cinemas}">
                                                <tr>Aucun cinema ne correspond à votre recherche</tr>
                                            </c:when>
                                                                                               
                                                <c:otherwise>
                                                <c:forEach var="cinema" items="${requestScope.cinemas}">
                                                    <tr>
                                                        <a href='#' id="${cinema.id}" class='clickable'>
                                                                <div class="liste_desc_cinema">
                                                                    <p class="titre_cinema">${cinema.nom}</p>
                                                                    <c:if test = "${cinema.code_postal!=null}">${cinema.code_postal} ${cinema.ville}<br></c:if>
                                                                    <br>
                                                                </div>
                                                         </a>
                                                    </tr>
                                                </c:forEach>
                                            </c:otherwise>                                                  
                                        </c:choose>
                                    </c:if>
                                    <c:if test = "${requestScope.cinemas == null}">                                                
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
