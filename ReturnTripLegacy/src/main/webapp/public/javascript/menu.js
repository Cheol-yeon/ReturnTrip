$(document).ready(function () {
    let toggle = false;
    $('#menu_button').on('click', function () {
        let menu = $('.menu');
        if (toggle == false) {
            menu.css('opacity', '1');
            toggle = true;
        }
        else {
            menu.css('opacity', '0');
            toggle = false;
        }
    })
});