!function(){
	storage.remove('area')
	$(".wrapper").on("click", function(e) {
		e.stopPropagation();
	});
}.call()