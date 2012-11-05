<div id="header-wrapper">
    <div id="banner">
        <div class="content"><img src="images/logo.jpg" width="1000" height="300" alt="" /></div>
    </div>
    <div id="header" class="container">
        <div id="menu">
            <ul>
                <li class="current_page_item"><a href="index.html">Accueil</a></li>
                <li><a href="#">Cinéma</a></li>
                <li><a href="#">Films</a></li>
                <li><a href="#">Autre</a></li>
            </ul>
        </div>
        <div id="recherche">
            <form action="ServletVisiteur?action=rechercherCinemaAction" method="post">
                Recherche :
                <select name="critere">
                    <option value="cinema">Cinéma</option>
                </select>
                <input type="text" name="valeur" />
                <input type="submit" id="bouton_valider" name="envoyer" value="Valider"/>
            </form>
        </div>
    </div>
</div>	