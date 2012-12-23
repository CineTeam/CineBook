<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CinéBook</title>
        <c:import url="header_javascript.jsp" />
    </head>
    <body id="inscription">
        <div id="wrapper">
            <c:import url="header.jsp" />

            <div id="page">
                <div id="content">
                    <div class="post">
                        <div id="entete">
                            <h1>Mon Compte</h1>
                        </div>
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                             <c:if test = "${requestScope.message != null}">                                                
                                 <p>${requestScope.message}</p>
                             </c:if>
                            <c:if test = "${sessionScope.utilisateur!=null}">
                                <c:choose>
                                    <c:when test="${empty sessionScope.utilisateur}">
                                        Aucun compte ne correspond a ce pseudo
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
                                                            <input type="submit" id="bouton_modifier" name="modifier" value="Valider" class='button_clickable'/>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td align="center" colspan="2">
                                                            <br/>
                                                            <a href="ServletMembre?action=supprimerUtilisateurAction" class="lien_suppr_compte">Supprimer mon compte</a>
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
                                Aucun compte ne correspond.
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
