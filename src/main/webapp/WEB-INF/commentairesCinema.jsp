<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <h3>Commentaires :</h3><br>
        <c:if test = "${sessionScope.utilisateur != null}">
            <form action="ServletMembre?action=deposerCommentaireCinemaAction" method="post" id="form_commentaire">
                <input type="hidden" name="cpt" value="${requestScope.cinema.id}" />
                Déposez un commentaire : <br>
                <textarea id="champ_commentaire" name="champ_commentaire"></textarea><br>
                <input type="submit" id="bouton_valider_commentaire" value="Valider" /><br><br>
            </form>
        </c:if>
        <c:if test = "${sessionScope.utilisateur == null}">
            Connectez vous pour déposer un commentaire ! <br>
        </c:if>
        
        <c:if test = "${requestScope.commentaires != null}">
            <c:choose>
                <c:when test = "${empty requestScope.commentaires}">
                    Aucun commentaire<br><br>
                </c:when>
                <c:otherwise>
                    <c:forEach var="commentaire" items="${requestScope.commentaires}" varStatus="status">
                        <div class="commentaire_cinema 
                             <c:if test = "${status.count%2==1}">commentaire_cinema_decale_droite</c:if> 
                             <c:if test = "${status.count%2==0}">commentaire_cinema_decale_gauche</c:if> 
                         ">
                            <c:if test = "${commentaire.utilisateur.pseudo!=null}"><p class="titre_commentaire"> ${commentaire.utilisateur.pseudo} </p> </c:if>
                            <c:if test = "${commentaire.date!=null}"> Le ${commentaire.date} : <br></c:if>
                            <c:if test = "${commentaire.texte!=null}">${commentaire.texte}</c:if>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </c:if>
    </body>
</html>
