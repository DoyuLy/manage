$(function(){
	setWallpapper();
	
	setTimeout(function(){
		$('html,body').animate({scrollTop: $(document).height()}, 2000); 
		$('#tt').fadeIn(1000);
	},1000);
});

function setWallpapper(){
	var i=Math.random()*2;
	if(i>1){
		$('#main').css("background-image","url("+ctx+"/img/blue_sky.jpg)");
	}else{
		$('#main').css({"background-image":"url("+ctx+"/img/forest_sun.jpg)"});
	}
}

//test for commit