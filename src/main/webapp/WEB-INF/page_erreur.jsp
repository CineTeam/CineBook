<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CinéBook</title>
        <c:import url="header_javascript.jsp" />
        <link href="style/slider.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
         <div id="wrapper">
            <div id="header-wrapper">
                <div id="banner">
                    <div class="content"><img src="images/logo.jpg" width="1000" height="200" alt=""/></div>
                </div>
            </div> 
            <div id="page">
                <div id="content">
                    <div class="post">
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            <h1>Pose des petits cailloux si tu est perdu !!</h1>
                            <div style="clear: both;">&nbsp;</div>
                            <a href="ServletMembre?vue=index.jsp" class="lien">Retour au site</a>
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
