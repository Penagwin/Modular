//Created by Penagwin, October 30
$(document).ready(function() {
     $("ul.content").snapscroll();
    $("h1").wrap("<div class='header-0 '></div>");
    $("h2").wrap("<div class='header-1 centerW'></div>");
    $(".header").wrapInner("<div class='container'></div>");
    $('h1').fitText(.75);
    $('h2').fitText(1.5);


    $("code").each(function() {
        $(this).text((($(this).html()).trim()));
    });
    // Navbar Collapse

    //On resize style the nav bars
    $(window).resize(function() {
        $(".nav").each(function() {
            if ($(this).outerWidth() <= 300) {
                $(this).children('.collapse').children('li').css({
                    "display": "block"
                });
                $(this).children('.collapse').css({
                    "display": "none"
                });
                $(this).children('.hide').css({
                    "display": "inline-block"
                });
            } else {
                $(this).children('.collapse').children('li').css({
                    "display": "inline-block"
                });
                $(this).children('.collapse').css({
                    "display": "inline-block"
                });
                $(this).children('.hide').css({
                    "display": "none"
                });

            }
        });


        $(".centerW").each(function() {

            $(this).css({
                left: ($(window).width() - $(this).outerWidth()) / 2
            });
        });
        $(".centerH").each(function() {

            $(this).css({
                top: ($(window).height() - $(this).outerHeight()) / 2
            });
        });
    });

    //On Expand Pressed
    $(".nav").click(function() {
        if ($(this).children(".hide").css('display') != "none")
            $(this).children('.collapse').slideToggle('medium');
    });

    //Force a resize to init.
    $(window).resize();
});