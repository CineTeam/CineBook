<html> 
    <head>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/selectRechercheCinemas.js"></script>
    </head>
    <body>
        <div id="recherche">
            <form action="#" method="post" id="form">
                Rechercher un cinéma :
                <select name="parametre" id="select" >
                    <option selected="selected">Selectionnez</option>
                    <option>Tous</option>
                    <option>Code postal</option>
                </select>
                <input type="text" name="recherche" disabled="disabled" id="inputText" />
                <input type="submit" id="bouton_valider" name="envoyer" value="Valider" disabled="disabled" />
            </form>
        </div>
    </body>
</html>