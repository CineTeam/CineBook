$(document).ready(function() {    
    $("#bouton_valider").click( function(){
        var select = document.getElementById("select");
        if(select.options[select.selectedIndex].value == "Mot clé")
        {
            $(document.getElementById("form")).attr("action","ServletVisiteur?action=rechercherCinemaAction");
        }
        else if(select.options[select.selectedIndex].value == "Code postal")
        {
            $(document.getElementById("form")).attr("action","ServletVisiteur?action=rechercherCinemaParCPAction");
        }
    });
});