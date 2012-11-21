function initialize(latitude, longitude) {
    var latlng = new google.maps.LatLng(latitude, longitude);
    
    var myOptions = {
        zoom: 15,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    
    map = new google.maps.Map(document.getElementById("googlemap"),
        myOptions);
    
    var marker = new google.maps.Marker({
        position: latlng,
        map : map
    })
}