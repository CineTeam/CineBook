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
        <c:import url="header_javascript.jsp" />
    </head>
    <body id="inscription">
        <div id="wrapper">
            <c:import url="header.jsp" />

            <div id="page">
                <div id="content">
                    <div class="post">
                        <div id="entete">
                            <h1>Profil</h1>
                        </div>
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                             <c:if test = "${requestScope.message != null}">                                                
                                 <p>${requestScope.message}</p>
                             </c:if>
                            <c:if test = "${sessionScope.utilisateur!=null}">
                                <c:choose>
                                    <c:when test="${empty sessionScope.utilisateur}">
                                        Aucun profil ne correspond à ce pseudo
                                    </c:when>
                                    <c:otherwise>
                                        <div align="center">
                                            <form action="ServletMembre?action=modifierUtilisateurAction" method="post" class="form_modifier_utilisateur">
                                                <table>  
                                                    <tr>
                                                        <td>Pseudo :</td>
                                                        <td ><span name="pseudo" id="inputText">${sessionScope.utilisateur.pseudo}</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Login :</td>
                                                        <td><span name="login" id="inputText">${sessionScope.utilisateur.login}</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Adresse :</td>
                                                        <td><input type="text" name="adresse" id="inputText" value="${sessionScope.utilisateur.adresse}"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Code postal :</td>
                                                        <td><input type="text" name="code_postal" id="inputText" value="${sessionScope.utilisateur.code_postal}"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Ville :</td>
                                                        <td><input type="text" name="ville" id="inputText" value="${sessionScope.utilisateur.ville}"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center" colspan="2">
                                                            <br/>
                                                            <a href="ServletMembre?action=supprimerUtilisateurAction">Supprimer mon compte</a>
                                                            <input type="submit" id="bouton_modifier" name="modifier" value="Valider" class='button_clickable'/>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <br/>
                                            </form>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                                <br/><br/>
                            </c:if>
                             <c:if test = "${sessionScope.utilisateur == null}">  
                                Aucun profil ne correspond.
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
