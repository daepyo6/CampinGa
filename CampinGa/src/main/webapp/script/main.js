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
		dist = -1 * 252 * num;
		$('.cards').animate({ left: dist }, 500)
	})
	$('#btnR').click(function() {
		if (num == 4) return;
		num++;
		dist = -1 * 252 * num;
		$('.cards').animate({ left: dist }, 500)
	})
	
	$('.icons').mouseenter(function(){
		$(this).children('.iconImg1').animate({opacity:"0"}, 500)
		$(this).children('.iconImg2').animate({opacity:"1"}, 500)
	})
	$('.icons').mouseleave(function(){
		$(this).children('.iconImg1').animate({opacity:"1"}, 500)
		$(this).children('.iconImg2').animate({opacity:"0"}, 500)
	})
	$("#file").on('change',function(event){
	  	var fileName = $("#file").val();
	  	$(".upload-name").val(fileName);
    
		var file = event.target.files[0];

	    var reader = new FileReader(); 
	    reader.onload = function(e) {	
	        $("#previewImg").attr("src", e.target.result);
	    }
	
	    reader.readAsDataURL(file);
	});
	
	
})