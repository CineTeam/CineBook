$(document).ready(function() {
    $("#fleche_menu_membre").click(function() {
        var div = document.getElementById("menu_membre");
            if(div.style.display =="block")
                div.style.display ="none";
            else {
                div.style.display ="block";
            }
    });
    
    var liens_menu = document.getElementById("menu_membre").getElementsByTagName("a");
    for(i=0; i<liens_menu.length; i++){
        $(liens_menu[i]).mouseover(function(){
            this.style.backgroundImage = 'url(images/lien_menu_membre_hover.png)';
        });
        $(liens_menu[i]).mouseout(function(){
            this.style.backgroundImage = 'url(images/lien_menu_membre.png)';
        });
    }
    
});