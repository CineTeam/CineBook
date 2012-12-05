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
                    <c:forEach var="commentaire" items="${requestScope.commentaires}">
                        <strong>User</strong> : <br><br>
                        <c:if test = "${commentaire.texte!=null}">${commentaire.texte}<br><br></c:if>
                        <c:if test = "${commentaire.date!=null}">Posté le ${commentaire.date}<br><br></c:if>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </c:if>
    </body>
</html>
