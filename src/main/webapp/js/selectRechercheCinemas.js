$(document).ready(function() {
    $("#select").change(function() {
        var select = document.getElementById("select");
        if(select.options[select.selectedIndex].value != "Selectionnez")
        {
            document.getElementById("inputText").disabled= false;
            document.getElementById("bouton_valider").disabled= '';
            $(document.getElementById("bouton_valider")).addClass("button_clickable");
        }
        else
        {
            document.getElementById("inputText").disabled= true;
            document.getElementById("bouton_valider").disabled= 'disabled';
            $(document.getElementById("bouton_valider")).removeClass("button_clickable");
        }
    });
    
    $("#bouton_valider").click( function(){
        var select = document.getElementById("select");
        if(select.options[select.selectedIndex].value == "Tous")
        {
            $(document.getElementById("form")).attr("action","ServletVisiteur?action=rechercherCinemaAction");
        }
        else if(select.options[select.selectedIndex].value == "Code postal")
        {
            $(document.getElementById("form")).attr("action","ServletVisiteur?action=rechercherCinemaAction");
        }
    });
});