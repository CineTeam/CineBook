$(document).ready(function() {
    $(".format_clickable").click(function() {
        var id_format = $(this).attr('id');
        document.getElementById(id_format).style.backgroundImage = 'url(images/background-titre-format.png)';
        var count_seances_film = id_format.substring(0,id_format.indexOf('_'));
        var id_details = "details_"+id_format;
        document.getElementById(id_details).style.display = 'block';
        
        
        var id_formats = "formats_"+count_seances_film;
        var liste_formats = document.getElementById(id_formats).getElementsByTagName("p");
        for(i=0; i<liste_formats.length; i++){
            if($(liste_formats[i]).attr('id')!=id_format){
                liste_formats[i].style.backgroundImage = 'url(images/background-titre-format-non-selectionne.png)';
            }
        }
        
        var liste_details_format = $(".details_format_"+count_seances_film);
        for(i=0; i<liste_details_format.length; i++){
            if($(liste_details_format[i]).attr('id')!=id_details){
                liste_details_format[i].style.display = 'none';
            }
        }
   });
});