$(document).ready(function() {

	$('.js-alternar').bind('click', function() {
		$('.js-barra-lateral').toggleClass('is-opend');
		$('.js-conteudo').toggleClass('is-opend');
	})

})

$(document).ready(function (argument) {
	$('.menu li:has(ul)').click(function(e){
		e.preventDefault();

		if ($(this).hasClass('ativo')) {
			$(this).removeClass('ativo');
			$(this).children('ul').slideUp('fast');
		} else {
			$('.menu li ul').slideUp('fast');
			$('.menu li').removeClass('ativo');
			$(this).addClass('ativo');
			$(this).children('ul').slideDown('fast');
		}
	});

	/*$('.btn-menu').click(function(){
		$('.barra-menu .menu').slideToggle();
	});*/

	/*$(window).resize(function(){
		if ($(document).width() > 960) {
			$('.barra-menu .menu').css({'display' : 'block'});
		}

		if ($(document).width() < 960) {
			$('.barra-menu .menu').css({'display' : 'none'});
			$('.menu li ul').slideUp();
			$('.menu li').removeClass('ativo');
		}
	});*/

	$('.menu li ul a').click(function(){
		window.location.href = $(this).attr("href");
	});
});