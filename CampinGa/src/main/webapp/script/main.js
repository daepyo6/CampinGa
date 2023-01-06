$(function() {
	$('.newCampImgs').mouseenter(function() {
		$(this).children('.imgCover').animate({ top: 0 }, 1500)
	})
	$('.newCampImgs').mouseleave(function() {
		$(this).children('.imgCover').animate({ top: 300 }, 1500)
	})

	let num = 0;
	let dist;
	$('#btnL').click(function() {
		if (num == 0) return;
		num--;
		dist = -1 * 253 * num;
		$('.cards').animate({ left: dist }, 500)
	})
	$('#btnR').click(function() {
		if (num == 4) return;
		num++;
		dist = -1 * 253 * num;
		$('.cards').animate({ left: dist }, 500)
	})
})