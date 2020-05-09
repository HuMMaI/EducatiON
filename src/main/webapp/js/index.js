$(window).on('scroll', function () {
    if ($(window).scrollTop() > 0) {
        $('.header_area').addClass('sticky');
    } else {
        $('.header_area').removeClass('sticky');
    }
});

$(window).on('load', function () {
    $('#preloader').fadeOut('slow', function () {
        $(this).remove();
    });
});
