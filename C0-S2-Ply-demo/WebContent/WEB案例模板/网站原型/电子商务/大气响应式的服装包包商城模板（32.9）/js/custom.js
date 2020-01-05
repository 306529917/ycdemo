(function($) {

    "use strict";

    $(document).ready(function($) {

        // Trigger mobile menu.
        $('#mobile-trigger').sidr({
            timing: 'ease-in-out',
            speed: 500,
            source: '#mob-menu',
            renaming: false,
            name: 'mob-menu'
        });

        $('#mobile-trigger-quick').sidr({
            timing: 'ease-in-out',
            side: 'right',
            speed: 500,
            source: '#mob-menu-quick',
            name: 'sidr-quick'
        });

        $('#mob-menu').find('.sub-menu,.flat-mega-memu').before('<span class="dropdown-toggle"><strong class="dropdown-icon"></strong>');

        $('#mob-menu').find('.dropdown-toggle').on('click', function(e) {
            e.preventDefault();
            $(this).next('.sub-menu,.flat-mega-memu').slideToggle();
            $(this).toggleClass('toggle-on');
        });

        //Fixed header.
        $(window).on('scroll', function() {
            if ($(window).scrollTop() > $('.sticky-enabled').offset().top && !($('.sticky-enabled').hasClass('sticky-header'))) {
                $('.sticky-enabled').addClass('sticky-header');
            } else if (0 === $(window).scrollTop()) {
                $('.sticky-enabled').removeClass('sticky-header');
            }
        });


	    // Single product gallery
	    $('.single-main-thumb').slick({
	      slidesToShow: 1,
	      slidesToScroll: 1,
	      autoplay:true,
	      arrows: false,
	      fade: true,
	      asNavFor: '.pager-thumbnail'

	    });

	    // Product gallery
	    $('.pager-thumbnail').slick({
	      slidesToShow: 3,
	      slidesToScroll: 1,
	      asNavFor: '.single-main-thumb',
	      dots: false,
	      centerMode: true,
	      focusOnSelect: true,
	                  prevArrow: '<span data-role="none" class="slick-prev" tabindex="0"><i class="fas fa-angle-left" aria-hidden="true"></i></span>',
            nextArrow: '<span data-role="none" class="slick-next" tabindex="0"><i class="fas fa-angle-right" aria-hidden="true"></i></span>'
	    });
        // Slick carousel column 1.
        $(".iteam-col-1.section-carousel-enabled").slick({
            dots: true,
            infinite: true,
            slidesToShow: 1,
            slidesToScroll: 1,
            dots: false,
            prevArrow: '<span data-role="none" class="slick-prev" tabindex="0"><i class="fas fa-angle-left" aria-hidden="true"></i></span>',
            nextArrow: '<span data-role="none" class="slick-next" tabindex="0"><i class="fas fa-angle-right" aria-hidden="true"></i></span>'
        });
        // Slick carousel column 2.
        $(".iteam-col-2.section-carousel-enabled").slick({
            dots: true,
            infinite: true,
            slidesToShow: 2,
            slidesToScroll: 2,
            dots: false,
            responsive: [{
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1,
                        infinite: true
                    }
                },
                {
                    breakpoint: 600,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1
                    }
                }
            ],
            prevArrow: '<span data-role="none" class="slick-prev" tabindex="0"><i class="fas fa-angle-left" aria-hidden="true"></i></span>',
            nextArrow: '<span data-role="none" class="slick-next" tabindex="0"><i class="fas fa-angle-right" aria-hidden="true"></i></span>'
        });

        // Slick carousel column 3.
        $(".iteam-col-3.section-carousel-enabled").slick({
            dots: true,
            infinite: true,
            slidesToShow: 3,
            slidesToScroll: 3,
            dots: false,
            responsive: [{
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2,
                        infinite: true
                    }
                },
                {
                    breakpoint: 500,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1
                    }
                }
            ],
            prevArrow: '<span data-role="none" class="slick-prev" tabindex="0"><i class="fa fa-angle-left" aria-hidden="true"></i></span>',
            nextArrow: '<span data-role="none" class="slick-next" tabindex="0"><i class="fa fa-angle-right" aria-hidden="true"></i></span>'
        });

        // Slick carousel column 4
        $(".iteam-col-4.section-carousel-enabled").slick({
            dots: true,
            infinite: true,
            slidesToShow: 4,
            slidesToScroll: 4,
            dots: false,
            responsive: [{
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2,
                        infinite: true
                    }
                },
                {
                    breakpoint: 500,
                    settings: {
                        slidesToShow: 1,
                        slidesToScroll: 1
                    }
                }
            ],
            prevArrow: '<span data-role="none" class="slick-prev" tabindex="0"><i class="fa fa-angle-left" aria-hidden="true"></i></span>',
            nextArrow: '<span data-role="none" class="slick-next" tabindex="0"><i class="fa fa-angle-right" aria-hidden="true"></i></span>'
        });

        // Slick carousel column 5
        $(".iteam-col-5.section-carousel-enabled").slick({
            dots: true,
            infinite: true,
            slidesToShow: 5,
            slidesToScroll: 5,
            dots: false,
            responsive: [{
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3,
                        infinite: true
                    }
                },
                {
                    breakpoint: 600,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2
                    }
                }
            ],
            prevArrow: '<span data-role="none" class="slick-prev" tabindex="0"><i class="fa fa-angle-left" aria-hidden="true"></i></span>',
            nextArrow: '<span data-role="none" class="slick-next" tabindex="0"><i class="fa fa-angle-right" aria-hidden="true"></i></span>'
        });
        // Slick carousel column 6
        $(".iteam-col-6.section-carousel-enabled").slick({
            dots: true,
            infinite: true,
            slidesToShow: 6,
            slidesToScroll: 6,
            dots: false,
            responsive: [{
                    breakpoint: 1024,
                    settings: {
                        slidesToShow: 3,
                        slidesToScroll: 3,
                        infinite: true
                    }
                },
                {
                    breakpoint: 600,
                    settings: {
                        slidesToShow: 2,
                        slidesToScroll: 2
                    }
                }
            ],
            prevArrow: '<span data-role="none" class="slick-prev" tabindex="0"><i class="fa fa-angle-left" aria-hidden="true"></i></span>',
            nextArrow: '<span data-role="none" class="slick-next" tabindex="0"><i class="fa fa-angle-right" aria-hidden="true"></i></span>'
        });


        // Implement go to top.
        var $scroll_obj = $('#btn-scrollup');
        $(window).on('scroll', function() {
            if ($(this).scrollTop() > 100) {
                $scroll_obj.fadeIn();
            } else {
                $scroll_obj.fadeOut();
            }
        });

        $scroll_obj.on('click', function() {
            $('html, body').animate({
                scrollTop: 0
            }, 600);
            return false;
        });


        $('a[href*="#demosz"]:not([href=""])').on('click', function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html, body').animate({
                        scrollTop: target.offset().top - 0
                    }, 1000);
                    return false;
                }
            }
        });

       // FAQ Accordion.
		$('.faq-accordion').accordionjs();

	    // Price range slider
	    $( "#slider-range" ).slider({
	        range: true,
	        min: 0,
	        max: 1000,
	        values: [ 40, 800 ],
	        slide: function( event, ui ) {
	          $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
	        }
	      });

	    $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
	      " - $" + $( "#slider-range" ).slider( "values", 1 ) );

	    // Tabs and Accordian Call
	       $( "#tabs" ).tabs();


    });

	$(document).ready(function(){

		setTimeout(function(){
			$('.ad-wrapper').slideDown('slow');
		}, 5000);
		$('.ad-wrapper .close').on('click',function(){
			$('.ad-wrapper').hide().addClass('hide');
		});

		$('.quick-view-link,.login-popup-btn').magnificPopup({
			type: 'inline',
		});
		if( $('#subscribe-popup' ).length > 0 ) {
			$(window).load(function () {
		        // retrieved this line of code from http://dimsemenov.com/plugins/magnific-popup/documentation.html#api
		        $.magnificPopup.open({
		            items: {
		                src: '#subscribe-popup'
		            },
		            type: 'inline'

		          // You may add options here, they're exactly the same as for $.fn.magnificPopup call
		          // Note that some settings that rely on click event (like disableOn or midClick) will not work here
		        }, 0);
		    });
		}

 	 });

})(jQuery);
