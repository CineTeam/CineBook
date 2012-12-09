<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test ="${sessionScope.utilisateur != null}">
         <div id="recherche">
            <form action="#" method="post" id="form_recherche_cinema">
                Rechercher un cinéma par :
                <select name="parametre" id="select_recherche_cinema" >
                    <option>Mot clé</option>
                    <option selected="selected">Code postal</option>
                </select>
                <input type="text" name="recherche" id="inputText" value="${sessionScope.utilisateur.code_postal}"/>
                <input type="submit" id="bouton_recherche_cinema" value="Valider" class='button_clickable'/>
            </form>
        </div>      
    </c:when>
    <c:otherwise>
        <div id="recherche">
            <form action="#" method="post" id="form_recherche_cinema">
                Rechercher un cinéma par :
                <select name="parametre" id="select_recherche_cinema" >
                    <option selected="selected" >Mot clé</option>
                    <option>Code postal</option>
                </select>
                <input type="text" name="recherche" id="inputText" />
                <input type="submit" id="bouton_recherche_cinema" value="Valider" class='button_clickable'/>
            </form>
        </div>
    </c:otherwise>
</c:choose>  

