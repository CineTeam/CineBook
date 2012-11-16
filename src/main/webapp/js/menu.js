$(document).ready(function() {
   var titre = document.getElementsByTagName("title")[0].firstChild.nodeValue;
   var li = document.getElementById("ul_menu").getElementsByTagName("li");
   
   for(i=0; i<li.length; i++){
       if($(li[i]).text() == titre){
           $(li[i]).addClass("current_page_item");
       }
   }
});
