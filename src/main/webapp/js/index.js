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

$(document).ready(function () {
    $(".hero-slides").owlCarousel({
        items: 1,
        loop: true,
        autoplay: true,
        smartSpeed: 800,
        margin: 0,
        dots: false,
        nav: true,
        navText: ['<i class="fa fa-chevron-left" aria-hidden="true"></i>', '<i class="fa fa-chevron-right" aria-hidden="true"></i>']
    });

    if ($(window).width() > 767) {
        new WOW().init();
    }

    $('#bar1').barfiller({
        tooltip: true,
        duration: 3000,
        barColor: '#4a7aec',
        animateOnResize: true
    });
    $('#bar2').barfiller({
        tooltip: true,
        duration: 3000,
        barColor: '#4a7aec',
        animateOnResize: true
    });
    $('#bar3').barfiller({
        tooltip: true,
        duration: 3000,
        barColor: '#4a7aec',
        animateOnResize: true
    });
});
