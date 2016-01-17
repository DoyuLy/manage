$(function(){
	$('#subPanel>div:gt(0)').hide();
	
	$('#subMenu a').click(function(){
		$('#subMenu>li.active').removeClass('active');
		$(this).parent().addClass('active');
		var target=$(this).attr('t');
		$('#subPanel div').fadeOut(200,function(){
			setTimeout(function(){
				$('#subPanel div#'+target).fadeIn(800);
			},100);
		});
	});
});