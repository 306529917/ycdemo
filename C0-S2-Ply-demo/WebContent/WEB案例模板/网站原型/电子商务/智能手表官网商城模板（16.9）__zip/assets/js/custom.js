/*
-PrettyPhoto
-Preloader
-Slider-pro
-Back-to-top
-Counter
-View-360
-Search
-FilterSlider
-Slick-slider
-color_product
*/


$(document).ready(function() {

    "use strict";

  
    /*-----------------------------
            PrettyPhoto
      -------------------------------*/
     $("a[data-rel^='prettyPhoto[videos]']").prettyPhoto({
            animation_speed:'normal',
            theme:'light_square',
            social_tools: false,
            allow_resize: true, /* Resize the photos bigger than viewport. true/false */
            default_width: 800,
            default_height: 450,
        }); 

      /*-----------------------------
          Preloader
      -------------------------------*/
      $(window).on('load', function() {
        $("#preloader").delay(200).fadeOut();
      });

     /*-----------------------------
          Slider-pro
      -------------------------------*/
      if ($('.my-slider').length > 0) {
          var sliderWidth = $("#my-slider-1").data("slider-width");
          var sliderHeigth = $("#my-slider-1").data("slider-height");

          $( '#my-slider-1' ).sliderPro({
              width:  sliderWidth,
              height: sliderHeigth,
              fade: true,
              arrows: true,
              buttons: false,
              waitForLayers: false,
              thumbnailPointer: false,
              touchSwipe: false,
              autoplay: true,
              autoScaleLayers: true
          });
      }

      /*-----------------------------
          Back-to-top
      -------------------------------*/
      $(window).on('scroll', function (e) {
          e.preventDefault();
        if ($(this).scrollTop() > 100) $('#back-to-top').fadeIn();
         else $('#back-to-top').fadeOut();
        });
        $('#back-to-top').on('click', function(e) {
          e.preventDefault();
          $('body,html').animate({scrollTop: 0}, 'slow');
      });

      // View-360
      $(function() {
          $('.spritespin').spritespin({
              source: [
                'assets/images/360_view/7_0.jpg',
                'assets/images/360_view/7_1.jpg',
                'assets/images/360_view/7_2.jpg',
                'assets/images/360_view/7_3.jpg',
                'assets/images/360_view/7_4.jpg',
                'assets/images/360_view/7_5.jpg',
                'assets/images/360_view/7_6.jpg',
                'assets/images/360_view/7_7.jpg',
                'assets/images/360_view/7_8.jpg',
                'assets/images/360_view/7_9.jpg',
                'assets/images/360_view/7_10.jpg',
                'assets/images/360_view/7_11.jpg',
                'assets/images/360_view/7_12.jpg',
                'assets/images/360_view/7_13.jpg',
                'assets/images/360_view/7_14.jpg',
                'assets/images/360_view/7_15.jpg',

              ],
             width: 500,
              height: 500,
              frame: 0,
              stopFrame: 1,
              animate   : false
            });
      })

      /*-----------------------------
          Search
      -------------------------------*/
      function search() {
        var searchOpen = $('.ps-search-btn'),
            searchClose = $('.ps-search__close'),
            searchbox = $('.ps-search');
        searchOpen.on('click', function(e) {
            e.preventDefault();
            searchbox.addClass('open');
        });
        searchClose.on('click', function(e) {
            e.preventDefault();
            searchbox.removeClass('open');
        });
      }

      /*-----------------------------
          FilterSlider
      -------------------------------*/
      function filterSlider() {
        var el = $('.ps-slider');
        var min = el.siblings().find('.ps-slider__min');
        var max = el.siblings().find('.ps-slider__max');
        var defaultMinValue = el.data('default-min');
        var defaultMaxValue = el.data('default-max');
        var maxValue = el.data('max');
        var step = el.data('step');
        if (el.length > 0) {
            el.slider({
                min: 0,
                max: maxValue,
                step: step,
                range: true,
                values: [defaultMinValue, defaultMaxValue],
                slide: function(event, ui) {
                    var values = ui.values;
                    min.text('$' + values[0]);
                    max.text('$' + values[1]);
                }
            });
            var values = el.slider("option", "values");
            console.log(values[1]);
            min.text('$' + values[0]);
            max.text('$' + values[1]);
        }
        else {
            // return false;
        }
    }
    $(function() {
       search();
       filterSlider();
    });  


    $(".owl-carousel").each( function(){

      var slidesToShow    =     $(this).data('items'); 


        if ($(this).data('large')) {
            var desktop = $(this).data('large');
        } else {
            var desktop = slidesToShow;
        }
        if ($(this).data('medium')) {
            var medium = $(this).data('medium');
        } else {
            var medium = slidesToShow;
        }
        if ($(this).data('smallmedium')) {
            var smallmedium = $(this).data('smallmedium');
        } else {
            var smallmedium = slidesToShow;
        }
        if ($(this).data('extrasmall')) {
            var extrasmall = $(this).data('extrasmall');
        } else {
            var extrasmall = 2;
        }
        if ($(this).data('verysmall')) {
            var verysmall = $(this).data('verysmall');
        } else {
            var verysmall = 2;
        }


      var _config = [];

      _config.dots             = $(this).data( 'pagination' );
      _config.arrows           = $(this).data( 'nav' );
      _config.infinite         = true;
      _config.speed            = 500;
      _config.autoplay         = $(this).data('autoplay');
      _config.cssEase          = 'linear';
      _config.slidesToShow     = slidesToShow;
      _config.slidesToScroll   = 1;
      _config.mobileFirst      = true;
      _config.vertical         = false;


      _config.responsive       = [
         {
            breakpoint: 1500,
            settings: { 
              slidesToShow: slidesToShow,
              slidesToScroll: slidesToShow,
            }
          },
          {
            breakpoint: 1280,
            settings: { 
              slidesToShow: desktop,
              slidesToScroll: desktop,
            }
          },
          {
            breakpoint: 980,
            settings: {
              slidesToShow: medium,
              slidesToScroll: medium,
            }
          },
          {
            breakpoint: 767,
            settings: {
              slidesToShow:smallmedium,
              slidesToScroll: smallmedium,
              infinite: false,
            }
          },                
          {
            breakpoint: 479,
            settings: {
              slidesToShow:extrasmall,
              slidesToScroll: extrasmall,
              infinite: false,
              unslick: true,
            },
          },                
          {
            breakpoint: 0,
            settings: {
              slidesToShow:verysmall,
              slidesToScroll: verysmall,
              infinite: false,
            },
          }
      ];  

      $(this).slick( _config );
    });

    $('.featuredPostSlider').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        fade: true,
        autoplay: false,
        adaptiveHeight: true,
        asNavFor: '.slick-pager'
    }); 
    $('.slick-pager').slick({
        slidesToShow: 4,
        slidesToScroll: 1,
        nextArrow: $('.pagerNavigation .bottom'),
        prevArrow: $('.pagerNavigation .top'),
        asNavFor: '.featuredPostSlider',
        focusOnSelect: true,
        vertical: true,
        responsive: [{
            breakpoint: 767,
            settings: {
                vertical: false
            }
        }]
    });
    slickHeight();

    function slickHeight() {
      var winWidth = $(window).width();
      if (winWidth > 767) {
        var sliderHeight = $('.slick-slider').height();
        $('#slick-pager .slick-pager').css('height', sliderHeight - 60);
      }
    }
    $( window ).resize(function() {
      slickHeight();
    });

    /*-----------------------------
        color product_1
    -------------------------------*/
    $( ".product_1 .color_selector > .swatch-color" ).on('click', function(e) {
      e.preventDefault();
     var color = $(this).data('value');
      if(color == 'blue'){
        $( ".product_1 .swatch-blue").addClass( "selected" );
         $ ('.product_1 .product-featured-image').attr('src','assets/images/product/product_12.jpg');
      }
      else {
        $( ".product_1 .swatch-blue").removeClass( "selected" );
      }
     
     if(color == 'orange'){
        $( ".product_1 .swatch-orange").addClass( "selected" );
        $('.product_1 .product-featured-image').attr('src','assets/images/product/product_2.jpg');
      }
      else {
        $( ".product_1 .swatch-orange").removeClass( "selected" );
      }

     if(color == 'purple'){
      $( ".product_1 .swatch-purple").addClass( "selected" );
      $('.product_1 .product-featured-image').attr('src','assets/images/product/product_9.jpg');
     }
     else {
        $( ".product_1 .swatch-purple").removeClass( "selected" );
      }
     
     if(color == 'red'){
      $( ".product_1 .swatch-red").addClass( "selected" );
      $('.product_1 .product-featured-image').attr('src','assets/images/product/product_5.jpg');
     }
     else {
        $( ".product_1 .swatch-red").removeClass( "selected" );
      }

   });

    /*-----------------------------
        color product_2
    -------------------------------*/
    $( ".product_2 .color_selector > .swatch-color" ).on('click', function(e){
      e.preventDefault();
     var color = $(this).data('value');
      if(color == 'blue'){
        $( ".product_2 .swatch-blue").addClass( "selected" );
        $('.product_2 .product-featured-image').attr('src','assets/images/product/product_8.jpg');
      }
      else {
        $( ".product_2 .swatch-blue").removeClass( "selected" );
      }
     
     if(color == 'green'){
        $( ".product_2 .swatch-green").addClass( "selected" );
        $('.product_2 .product-featured-image').attr('src','assets/images/product/product_4.jpg');
     }
      else {
        $( ".product_2 .swatch-green").removeClass( "selected" );
      }
     if(color == 'purple'){
        $( ".product_2 .swatch-purple").addClass( "selected" );
        $('.product_2 .product-featured-image').attr('src','assets/images/product/product_7.jpg');
     }
      else {
        $( ".product_2 .swatch-purple").removeClass( "selected" );
      }
      if(color == 'red'){
        $( ".product_2 .swatch-red").addClass( "selected" );
        $('.product_2 .product-featured-image').attr('src','assets/images/product/product_5.jpg');
     }
      else {
        $( ".product_2 .swatch-red").removeClass( "selected" );
      }
    });

   


    // color_selector product-single
    $( ".product-info .color_selector > .swatch-color" ).on('click', function(e) {
      e.preventDefault();
     var color = $(this).data('value');
     if(color == 'blue'){
        $( ".product-info .swatch-blue").addClass( "selected" );
      $('.product_selector_1').attr('src','assets/images/product_single/product_single_6.jpg');
     }
      else {
        $( ".product-info .swatch-blue").removeClass( "selected" );
      }
     
     if(color == 'green'){
       $( ".product-info .swatch-green").addClass( "selected" );
      $('.product_selector_1').attr('src','assets/images/product_single/product_single_2.jpg');
     }
     else {
        $( ".product-info .swatch-green").removeClass( "selected" );
      }
     if(color == 'purple'){
      $( ".product-info .swatch-purple").addClass( "selected" );
      $('.product_selector_1').attr('src','assets/images/product_single/product_single_3.jpg');
     }
     else {
        $( ".product-info .swatch-purple").removeClass( "selected" );
      }
      if(color == 'orange'){
      $( ".product-info .swatch-orange").addClass( "selected" );
      $('.product_selector_1').attr('src','assets/images/product_single/product_single_5.jpg');
     }
     else {
        $( ".product-info .swatch-orange").removeClass( "selected" );
      }
     
     if(color == 'red'){
      $( ".product-info .swatch-red").addClass( "selected" );
      $('.product_selector_1').attr('src','assets/images/product_single/product_single_4.jpg');
     }
     else {
        $( ".product-info .swatch-red").removeClass( "selected" );
      }
     console.log(color);
   });

    // size_selector  product-single
    $( ".product-info #size_selector > .swatch-label" ).on('click', function(e){
      e.preventDefault();
      var size = $(this).data('value');
      if(size == 'l'){
        $( ".product-info .swatch-l").addClass( "selected" );
        $('.product_selector_1').attr('src','assets/images/product_single/product_single_2.jpg');
      }
      else {
        $( ".product-info .swatch-l").removeClass( "selected" );
      }

      if(size == 'm'){
        $( ".product-info .swatch-m").addClass( "selected" );
        $('.product_selector_1').attr('src','assets/images/product_single/product_single_3.jpg');
      }
      else {
        $( ".product-info .swatch-m").removeClass( "selected" );
      }

      if(size == 's'){
        $( ".product-info .swatch-s").addClass( "selected" );
        $('.product_selector_1').attr('src','assets/images/product_single/product_single_4.jpg');
      }
      else {
        $( ".product-info .swatch-s").removeClass( "selected" );
      }
      if(size == 'xl'){
        $( ".product-info .swatch-xl").addClass( "selected" );
        $('product_selector_1').attr('src','assets/images/product_single/product_single_5.jpg');
      }
      else {
        $( ".product-info .swatch-xl").removeClass( "selected" );
      }
       if(size == 'xxl'){
        $( ".product-info .swatch-xxl").addClass( "selected" );
        $('product_selector_1').attr('src','assets/images/product_single/product_single_6.jpg');
      }
      else {
        $( ".product-info .swatch-xxl").removeClass( "selected" );
      }
       console.log(size);
   });
   
});








