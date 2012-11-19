<html> 
    <head>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/selectRechercheCinemas.js"></script>
    </head>
    <body>
        <div id="recherche">
            <form action="#" method="post" id="form">
                Rechercher un cinéma par :
                <select name="parametre" id="select" >
                    <option selected="selected" >Mot clé</option>
                    <option>Code postal</option>
                </select>
                <input type="text" name="recherche" id="inputText" />
                <input type="submit" id="bouton_valider" name="envoyer" value="Valider" />
            </form>
        </div>
    </body>
</html>