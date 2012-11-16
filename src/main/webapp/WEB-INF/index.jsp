<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
        <link rel="icon" type="image/x-icon" href="images/favicon.ico" />
        <link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Abel' rel='stylesheet' type='text/css'>
        <link href="style/style.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/menu.js"></script>
    </head>

    <body>
        <div id="wrapper">
            <c:import url="header.jsp" />

            <div id="page">
                <div id="content">
                    <div class="post">
                        <h1>Bienvenue sur CineBook</h1>
                        <div style="clear: both;">&nbsp;</div>
                        <div class="entry">
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam eu blandit ante. Mauris faucibus felis egestas tortor aliquet pellentesque. Sed enim metus, viverra in dignissim in, laoreet et elit. Donec vestibulum interdum ornare. Curabitur dapibus, justo tempor ultricies ullamcorper, lacus leo ultrices libero, ac viverra risus mi ut dui. Nullam adipiscing tincidunt laoreet. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla interdum vestibulum augue sed consectetur. Maecenas urna risus, pretium elementum ornare id, varius eget velit. Duis condimentum, sapien ac condimentum fermentum, dui sapien consectetur risus, sed imperdiet turpis odio eu neque. Duis viverra, massa non volutpat gravida, dui dui porta est, vitae molestie augue ante ut erat. Mauris et felis vel arcu dapibus malesuada in at elit. Pellentesque vel est nulla, in dictum justo. Donec venenatis nisl eu ipsum pharetra molestie.</p>
                            <p>Aliquam tempor congue vehicula. Etiam a neque nec felis gravida ullamcorper. Cras iaculis feugiat dolor, vel mattis tortor pharetra at. Etiam congue dignissim ornare. Sed vel elit lorem. Aenean sed augue risus, ac elementum velit. In hac habitasse platea dictumst. Duis vulputate, leo ac commodo consequat, augue dui congue urna, a aliquet ipsum massa eu leo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam erat volutpat. Aenean interdum congue nisi, sit amet gravida dolor rutrum sed. Duis bibendum pellentesque risus, eget rhoncus metus elementum eu.</p>
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
