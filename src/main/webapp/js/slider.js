$(document).ready(function(){
    $("#slider").easySlider({
        auto: true,
        continuous: true,
        numeric: false,
        speed:800,
        prevId:'prevBtn',
        prevText:'<<&nbsp;&nbsp;',
        nextId: 'nextBtn',
        nextText: '&nbsp;&nbsp;>>',
        pause:2500
    });
});