(function($) {
	"use strict";

	jQuery(document).ready(function() {
		$("#contactform").on('submit',function(){
			var e = $(this).attr("action");
			return $("#message").slideUp(750, function() {
				$("#message").hide(), $("#submit").attr("disabled", "disabled"), $.post(e, {
					name: $("#name").val(),
					email: $("#email").val(),
					comments: $("#comments").val(),
					verify: $("#verify").val()
				}, function(e) {
					document.getElementById("message").innerHTML = e;
					$("#message").slideDown("slow");
					$("#contactform img.loader").fadeOut("slow", function() {
						$(this).remove();
					});
					$("#submit").removeAttr("disabled");
					null != e.match("success") && $("#contactform").slideUp("slow");
				})
			}), !1
		});

	});

})(jQuery);
