<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html> 
    <head>
    </head>
    <body>
        <table>
             <tr>
                 <td align="left">
                     Liste des cinemas ! 
                 </td>
                 <td align ="right">
                     <div id="recherche">
                        <form action="ServletVisiteur?action=consulterDetailFilmAction" method="post">
                            Rechercher par Code Postal:
                            <input type="text" name="cpt" value="${film.id}" style="display:none;"/>
                            <input type="text" name="recherche" />                     
                            <input type="submit" name="envoyer" value="Valider" />
                        </form>
                     </div>
                 </td>
             </tr>
        </table>
            
        <table>  
                <c:if test = "${requestScope.cinemas != null}">
                    <c:choose>
                        <c:when test = "${empty requestScope.cinemas}">
                            <tr>Aucun cinema ne correspond à votre recherche</tr>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <th>Nom : </th>
                                <th>Adresse :</th>
                                <th>CP : </th>
                                <th>Ville : </th>
                            </tr>
                            <c:forEach var="cinema" items="${requestScope.cinemas}">
                                <tr id="${cinema.id}" class='clickable'>
                                    <td><c:if test = "${cinema.nom!=null}">${cinema.nom}</c:if></td>
                                    <td><c:if test = "${cinema.adresse!=null}">${cinema.adresse}</c:if></td>
                                    <td><c:if test = "${cinema.code_postal!=null}">${cinema.code_postal}</c:if></td> 
                                    <td><c:if test = "${cinema.ville!=null}">${cinema.ville}</c:if></td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>                                            
                    </c:choose>
                </c:if>
                <c:if test = "${requestScope.cinemas == null}">                                                
                    <tr>Veuillez saisir un paramètre de recherche !</tr>
                </c:if>
            </table>
    </body>
</html>