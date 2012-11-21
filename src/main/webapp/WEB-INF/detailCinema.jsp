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
                            <h1>Détail du cinéma</h1>
                        </div>                        
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            <table>  
                                <c:if test = "${requestScope.cinema != null}">
                                    <c:choose>
                                        <c:when test = "${empty requestScope.cinema}">
                                            <tr>Aucun cinema ne correspond à votre recherche</tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                                <td rowspan="5"><img src="${cinema.url_image}" width='200'/></td>
                                                <td>Nom : </td>
                                                <td>${cinema.nom}</td>
                                                <td rowspan="3">googlemap à mettre</td>
                                            </tr>
                                            <tr>
                                                <td>Adresse :</td>
                                                <td>${cinema.adresse}</td>
                                            </tr>
                                            <tr>
                                                <td>Code postal :</td>
                                                <td>${cinema.code_postal}</td>
                                            </tr>
                                            <tr>
                                                <td>Ville :</td>
                                                <td>${cinema.ville}</td>
                                            </tr>
                                            <tr>
                                                <td>Nombre de salles :</td>
                                                <td>${cinema.nombre_salles}</td>
                                            </tr>
                                        </c:otherwise>                                            
                                    </c:choose>
                                </c:if>
                            </table>
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
