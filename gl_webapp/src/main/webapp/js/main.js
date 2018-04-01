$(function(){
	$("#dashboard-menu li").click(function(){
		var url = $(this).find("a").attr("src");
		$("#contentMain").attr("src",url);
	});
	
	var height = $(window).height();
	$("#containerMain").height(height-120);
});