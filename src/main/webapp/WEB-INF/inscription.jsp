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
                            <h1>Inscription</h1>
                        </div>
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            <c:if test = "${requestScope.messageErreur!=null}">
                                ${requestScope.messageErreur} <br/><br/>
                            </c:if>
                            <div align="center">
                                <form action="ServletMembre?action=sinscrireAction" method="post" class="form_sinscrire">
                                    <table>  
                                        <tr>
                                            <td>Pseudo* :</td>
                                            <td><input type="text" name="pseudo" id="inputText" /></td>
                                        </tr>
                                        <tr>
                                            <td>Login* :</td>
                                            <td><input type="text" name="login" id="inputText" /></td>
                                        </tr>
                                        <tr>
                                            <td>Mot de passe* :</td>
                                            <td><input type="password" name="mdp" id="inputText" /></td>
                                        </tr>
                                        <tr>
                                            <td>Confirmation mot de passe* :</td>
                                            <td><input type="password" name="mdpConfirmation" id="inputText" /></td>
                                        </tr>
                                        <tr>
                                            <td>Adresse :</td>
                                            <td><input type="text" name="adresse" id="inputText" /></td>
                                        </tr>
                                        <tr>
                                            <td>Code postal :</td>
                                            <td><input type="text" name="code_postal" id="inputText" /></td>
                                        </tr>
                                        <tr>
                                            <td>Ville :</td>
                                            <td><input type="text" name="ville" id="inputText" /></td>
                                        </tr>
                                        <tr>
                                            <td align="center" colspan="2">
                                                <br/>
                                                <input type="submit" id="bouton_inscription" name="inscription" value="Valider" class='button_clickable'/>
                                            </td>
                                        </tr>
                                    </table>
                                    <br/>
                                    * Ces champs sont obligatoires !
                                </form>
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
