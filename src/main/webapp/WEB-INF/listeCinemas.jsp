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
    <body id="Cinémas">
        <div id="wrapper">
            <c:import url="header.jsp" />
            <div id="page">
                <div id="content">
                    <div class="post">
                        <div id="entete">
                            <h1>Liste des cinemas !</h1>
                            <div id="recherche">
                                <form action="ServletVisiteur?action=rechercherCinemaAction" method="post">
                                    Rechercher un cinéma :
                                    <input type="text" name="recherche" />
                                    <input type="submit" id="bouton_valider" name="envoyer" value="Valider" class='clickable'/>
                                </form>
                            </div>
                        </div>                        
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            <form action="ServletVisiteur?#" method="post">

                                <table>  
                                    <c:if test = "${requestScope.cinemasParNom != null}">
                                        <c:choose>
                                            <c:when test = "${empty requestScope.cinemasParNom}">
                                                <tr>Aucun cinema ne correspond à votre recherche</tr>
                                            </c:when>
                                            <c:otherwise>
                                                <tr>
                                                    <th>Nom : </th>
                                                    <th>Adresse :</th>
                                                    <th>CP : </th>
                                                    <th>Ville : </th>
                                                </tr>
                                                <c:forEach var="cinema" items="${requestScope.cinemasParNom}" varStatus="status">
                                                    <tr id="${status.count}" class='clickable'>
                                                        <td>${cinema.nom}</td>
                                                        <td>${cinema.adresse}</td>
                                                        <td>${cinema.code_postal}</td> 
                                                        <td>${cinema.ville}</td>
                                                    </tr>
                                                </c:forEach>
                                            </c:otherwise>                                            
                                        </c:choose>
                                    </c:if>
                                    <c:if test = "${requestScope.cinemasParNom == null}">                                                
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
