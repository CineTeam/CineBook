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
    </head>
    <body>
        <div id="wrapper">
            <c:import url="header.jsp" />

            <div id="page">
                <div id="recherche">
                    <form action="ServletVisiteur?action=rechercherFilmAction" method="post">
                        Rechercher un film :
                        <input type="text" name="recherche" />
                        <input type="submit" id="bouton_valider" name="envoyer" value="Valider"/>
                    </form>
                </div>
                <div id="content">
                    <div class="post">
                        <h1>Accueil Films</h1>

                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            <table>  
                                <c:if test = "${requestScope.derniersFilmsSortis != null}">
                                    <c:choose>
                                        <c:when test = "${empty requestScope.derniersFilmsSortis}">
                                            <tr>Aucun film</tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                                <th>Titre : </th>
                                                <th>Réalisateur :</th>
                                                <th>Date de sortie : </th>
                                            </tr>
                                            <c:forEach var="film" items="${requestScope.derniersFilmsSortis}" varStatus="status">
                                                <tr id="${status.count}" class='clickable'>
                                                <td>${film.titre}</td>
                                                <td>${film.realisateur}</td>
                                                <td>${film.date_sortie}</td> 
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
