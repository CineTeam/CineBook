$(document).ready(function() {
    $(".clickable").click(function() {
        $("#cpt").val($(this).attr('id'));
        $("#bouton").click();
   });
   
   
    $(".clic").click(function(){
       var input = $(this).attr('id');
        $("#cptALaUne").val(input);
        $("#boutonDetail").click();
    });
   
});
