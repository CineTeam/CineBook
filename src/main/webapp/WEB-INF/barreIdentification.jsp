<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<c:choose>
    <c:when test ="${sessionScope.utilisateur != null}">
        <div id="identification_membre">
            <div class="bienvenue">
                Bienvenue ${sessionScope.utilisateur.pseudo} &nbsp;<img src="images/fleche_menu.png" id="fleche_menu_membre" class="img_clickable"/>
            </div>
            <div id="menu_membre">
                <a href="ServletMembre?vue=profilUtilisateur.jsp">Mon compte</a>
                <a href="ServletMembre?action=recupererFilmsVusAction">Mes films</a>
                <a href="ServletMembre?action=recupererCinemasFrequentesAction">Mes cinémas</a>
                <form action="ServletMembre?action=seDeconnecterAction" method="post" >
                    <a href="#" class='lien_clickable'>
                        <c:import url ="champs_redirection.jsp" />
                        Déconnexion
                    </a>
                    <div class="invisible">
                        <input id="bouton_deconnexion" type="submit" />
                    </div>
                </form>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div id="identification">
            <form action="ServletMembre?action=sidentifierAction" method="post" id="form_connexion">
                Login : 
                <input type="text" name="login" id="inputText" />
                Mot de passe :
                <input type="password" name="mdp" id="inputText" />
                <c:import url ="champs_redirection.jsp" />
                <input type="submit" id="bouton_connexion" name="connexion" value="Connexion" class='button_clickable'/>
            </form>
            <br/>
            <c:if test = "${requestScope.echec_connexion}">
                <div class="erreur_connexion">
                    Login et/ou mot de passe erronés ou vides !
                </div>
            </c:if>
            <a href="ServletMembre?vue=inscription.jsp" class="lien_inscription">
                Inscription
            </a>
        </div>
    </c:otherwise>
</c:choose>  
