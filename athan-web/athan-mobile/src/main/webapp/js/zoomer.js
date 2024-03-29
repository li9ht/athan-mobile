(function($) {
	$.fn.Zoomer = function(b) {
		var c = $.extend({
			speedView : 200,
			speedRemove : 400,
			altAnim : false,
			speedTitle : 400,
			b_W : "100px",
			b_H : "100px",
			h_W : "200px",
			h_H : "200px",
			debug : false
		}, b);
		var d = $.extend(c, b);
		function e(s) {
			if (typeof console != "undefined"
					&& typeof console.debug != "undefined") {
				console.log(s)
			} else {
				alert(s)
			}
		}
		if (d.speedView == undefined || d.speedRemove == undefined
				|| d.altAnim == undefined || d.speedTitle == undefined) {
			e('speedView: ' + d.speedView);
			e('speedRemove: ' + d.speedRemove);
			e('altAnim: ' + d.altAnim);
			e('speedTitle: ' + d.speedTitle);
			e('b_W: ' + d.b_W);
			e('b_H: ' + d.b_H);
			e('h_W: ' + d.h_W);
			e('h_H: ' + d.h_H);
			return false
		}
		if (d.debug == undefined) {
			e('speedView: ' + d.speedView);
			e('speedRemove: ' + d.speedRemove);
			e('altAnim: ' + d.altAnim);
			e('speedTitle: ' + d.speedTitle);
			e('b_W: ' + d.b_W);
			e('b_H: ' + d.b_H);
			e('h_W: ' + d.h_W);
			e('h_H: ' + d.h_H);
			return false
		}
		if (typeof d.speedView != "undefined"
				|| typeof d.speedRemove != "undefined"
				|| typeof d.altAnim != "undefined"
				|| typeof d.speedTitle != "undefined") {
			if (d.debug == true) {
				e('speedView: ' + d.speedView);
				e('speedRemove: ' + d.speedRemove);
				e('altAnim: ' + d.altAnim);
				e('speedTitle: ' + d.speedTitle);
				e('b_W: ' + d.b_W);
				e('b_H: ' + d.b_H);
				e('h_W: ' + d.h_W);
				e('h_H: ' + d.h_H);
			}
			$(this)
					.hover(
							function() {
								$(this).css({
									'z-index' : '10'
								});
								$(this).find('img').addClass("hover").stop()
										.animate({
											marginTop : '-110px',
											marginLeft : '-110px',
											top : '50%',
											left : '50%',
											width : d.h_W,
											height : d.h_H,
											padding : '5px'
										}, d.speedView);
								if (d.altAnim == true) {
									var a = $(this).find("img").attr("alt");
									if (a.length != 0) {
										$(this).prepend(
												'<span class="title">' + a
														+ '</span>');
										$('.title').animate({
											marginLeft : '-42px',
											marginTop : '90px'
										}, d.speedTitle).css({
											'z-index' : '10',
											'position' : 'absolute',
											'float' : 'left'
										})
									}
								}
							},
							function() {
								$(this).css({
									'z-index' : '0'
								});
								$(this).find('img').removeClass("hover").stop()
										.animate({
											marginTop : '0',
											marginLeft : '0',
											top : '0',
											left : '0',
											width : d.b_W,
											height : d.b_H,
											padding : '5px'
										}, d.speedRemove);
								$(this).find('.title').remove()
							})
		}
	}
})(jQuery);