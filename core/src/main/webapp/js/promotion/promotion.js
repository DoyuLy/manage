$(function() {
  jQuery.browser={};(function(){jQuery.browser.msie=false; jQuery.browser.version=0;if(navigator.userAgent.match(/MSIE ([0-9]+)./)){ jQuery.browser.msie=true;jQuery.browser.version=RegExp.$1;}})();
  // 禁用F5页面刷新
  $(document).on("keydown", function(e) {
    if((e.which || e.keyCode)==116) {
      e.preventDefault();
    }
  });

  // 获取系统公告
  var $get_user_type = function() {
    var strCookie = document.cookie;
    var arrCookie = strCookie.split('; ');
    for(var i=0; i<arrCookie.length; i++) {
      var arr = arrCookie[i].split('=');
      if(arr[0]=='user_type') return arr[1];
    }
  };
  var user_type = $get_user_type();
  if(user_type=='') user_type = -1;
  $.get("/note/detail/"+user_type, {}, function(data){
    if(data) $('#emergency_ad').css('display','block').html(data);
  });

  // 广告订购弹窗
  $('.jwin').click(function() {
    //访问后台生成图片，与值作为校验
    var title = $(this).attr('data-title');
    var url   = $(this).attr('data-url');
    new $.Message({
      title:title,
      ismask:true,
      icon:'none',
      content:'<iframe src="modalOut.action"  width="778" frameborder="0" height="500"></iframe>',
      width:788,
      height:537,
      button:{
        ok:false,
        cancel:true
      }
    });
  });
//我的广告订购弹窗 <!-- <input type="hidden"  name="promotionId" value=promotionId.val()> -->
  $('.mjwin').click(function() {
    //访问后台生成图片，与值作为校验
    var title = $(this).attr('data-title');
    var url   = $(this).attr('data-url');
    var promotionId = $("#promotionId").val();
    new $.Message({
      title:title,
      ismask:true,
      icon:'none',
      content:'<iframe src="mModalOut.action?promotionId='+promotionId+'"  width="778" frameborder="0" height="500"></iframe>',
      width:788,
      height:537,
      button:{
        ok:false,
        cancel:true
      }
    });
  });
  // 一条广告高亮显示
  $( ".table_list td" ).mouseover(function() {
    if(!$(this).parent().hasClass('nohover')) {
      $(this).parent().toggleClass( 'highlight' );
    }
  }).mouseout(function() {
    if(!$(this).parent().hasClass('nohover')) {
      $(this).parent().toggleClass( 'highlight' );
    }
  });
});
