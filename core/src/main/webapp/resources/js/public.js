//登陆状态
$.ajax({
  url : '/user/status?t=' + Math.random(),
  success : function(data) {
    $("#user_status").html(data);
  }
});

// 客服QQ对话窗
$("body")
    .on(
        'click',
        ".qq",
        function(event) {
          event.preventDefault();
          var url = 'http://wpd.b.qq.com/cgi/get_sign.php?na=4006611603&kfuin=938062714&aty=0&a=2&sid=1340311&uid=428083200&url=http%3A%2F%2Fwww.go2.cn%2F&title=&dm=go2.cn&clkSrc=&cb=QQ_CALLBACK';
          $.ajax({
            url : url,
            dataType : 'jsonp',
            jsonpCallback : "QQ_CALLBACK",
            success : function(obj) {
              var url = obj.data.sign;
              location.href = url;
            }
          });
          return false;
        });

function getCookie(name) {
  var strCookie = document.cookie;
  var arrCookie = strCookie.split("; ");
  for ( var i = 0; i < arrCookie.length; i++) {
    var arr = arrCookie[i].split("=");
    if (arr[0] == name)
      return arr[1];
  }
  return "";
}

var user_type = getCookie('user_type');
if (user_type == "") {
  user_type = -1;
}
$.get("/note/detail/" + user_type, {}, function(data) {
  if (data) {
    $('#emergency_ad').css('display', 'block').html(data);
    $('#gonggao').css('display', 'block');
    var height = $('#gonggao').outerHeight();
    $('#gonggao002').css('height', height + 'px');
    $('body').css('background-position', '0 ' + height + 'px');
  }
});
