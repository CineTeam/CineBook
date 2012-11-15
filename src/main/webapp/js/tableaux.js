$(document).ready(function() {
    $(".clickable").click(function() {
        $("#cpt").val($(this).attr('id'));
        $("#bouton").click();
   });
});
