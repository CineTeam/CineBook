<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CinéBook</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        
        <form action="ServletVisiteur?action=rechercherCinemaAction" method="post">
            <input type="submit" name="envoyer" value="Valider"/>
        </form>
    </body>
</html>
