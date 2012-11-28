<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CinéBook</title>
        <link rel="icon" type="image/x-icon" href="images/favicon.ico" />
        <link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Abel' rel='stylesheet' type='text/css'>
        <link href="style/style.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/menu.js"></script>
    </head>
    <body id="Accueil">
        <div id="wrapper">
            <c:import url="header.jsp" />

            <div id="page">
                <div id="content">
                    <div class="post">
                        <h1>Bienvenue sur CineBook</h1>
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            <p>Le site de référencement des cinemas et des films !! </p>
                            <p>Veuillez consulter la partie qui vous intéresse.</p>
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
