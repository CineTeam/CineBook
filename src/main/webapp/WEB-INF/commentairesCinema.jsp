<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Commentaires :</h3><br>
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
