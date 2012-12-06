$(document).ready(function() {    
    $("#bouton_recherche_cinema").click( function(){
        var select = document.getElementById("select_recherche_cinema");
        if(select.options[select.selectedIndex].value == "Mot clé")
        {
            $(document.getElementById("form_recherche_cinema")).attr("action","ServletVisiteur?action=rechercherCinemaAction");
        }
        else if(select.options[select.selectedIndex].value == "Code postal")
        {
            $(document.getElementById("form_recherche_cinema")).attr("action","ServletVisiteur?action=rechercherCinemaParCPAction");
        }
    });
});