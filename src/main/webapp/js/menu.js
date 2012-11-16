$(document).ready(function() {
   var titre = $(document.getElementsByTagName("body")[0]).attr("id");
   var li = document.getElementById("ul_menu").getElementsByTagName("li");
   
   for(i=0; i<li.length; i++){
       if($(li[i]).text() == titre){
           $(li[i]).addClass("current_page_item");
       }
   }
});
