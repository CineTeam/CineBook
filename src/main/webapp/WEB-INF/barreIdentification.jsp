<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<c:choose>
    <c:when test ="${sessionScope.utilisateur != null}">
        <p>Bienvenue ${sessionScope.utilisateur.pseudo}</p>
        <form action="ServletMembre?action=seDeconnecterAction" method="post" >
            <a href="#" class='lien_clickable'>
                Déconnexion
            </a>
            <input type="text" name="page_courante_avant_deco" value="${pageContext.request.servletPath}" class="invisible"/>
            <div class="invisible">
                <input id="bouton_deconnexion" type="submit" />
            </div>
        </form>
    </c:when>
    <c:otherwise>
        <form action="ServletMembre?action=sidentifierAction" method="post" id="form_connexion">
            Login : 
            <input type="text" name="login" id="inputText" />
            Mot de passe :
            <input type="password" name="mdp" id="inputText" />
            <input type="text" name="page_courante" value="${pageContext.request.servletPath}" class="invisible"/>
            <input type="submit" id="bouton_connexion" name="connexion" value="Connexion" />
        </form>
        <br/>
        <c:if test = "${requestScope.echec_connexion}">
            <div class="erreur_connexion">
                Login et/ou mot de passe erronés ou vides !
            </div>
        </c:if>
        <a href="ServletMembre?vue=inscription.jsp">
            Inscription
        </a>
    </c:otherwise>
</c:choose>  
