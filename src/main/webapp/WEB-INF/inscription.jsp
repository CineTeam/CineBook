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
        <script type="text/javascript" src="js/menu.js"></script>
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
                            <form action="ServletMembre?action=sinscrireAction" method="post" id="form_inscription">
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
                                        <td></td>
                                        <td align ="right"><br/><input type="submit" id="bouton_inscription" name="inscription" value="Valider" /></td>
                                    </tr>
                                </table>
                            </form>
                            * Ces champs sont obligatoires !
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
