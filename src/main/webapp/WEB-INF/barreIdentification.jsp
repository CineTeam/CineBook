<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>    
    </head>
    <body>
        <c:choose>
            <c:when test ="${sessionScope.login != null}">
                Bienvenue ${sessionScope.login}
            </c:when>
            <c:otherwise>
               <form action="ServletMembre?action=sidentifierAction" method="post" id="form_connexion">
                    Login : 
                    <input type="text" name="login" id="inputText" />
                    Mot de passe :
                    <input type="password" name="motDePasse" id="inputText" />
                    <input type="submit" id="bouton_connexion" name="connexion" value="Connexion" />
                </form> <br/>
                <c:if test = "${requestScope.echec_connexion}">
                    Login ou mot de passe inconnu
                </c:if>
                <a href="">
                    Inscription
                </a>
            </c:otherwise>
        </c:choose>  
    </body>
</html>
