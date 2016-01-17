/**
 * 公共函数
 */
$.util =
{
  /**
   * 设置cookie 使用方法：setCookie('username','Darren',30)
   */
  setCookie : function(c_name, value, expiredays, path, domain)
  {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + expiredays);
    var cookieStr = c_name
        + "="
        + escape(value)
        + ((expiredays == null) ? "" : ";expires="
            + exdate.toGMTString());
    // 判断是否有路径
    cookieStr = cookieStr + ((path == null) ? "" : ";path=" + path);
    // 判断是否有域名
    cookieStr = cookieStr + ((domain == null) ? "" : ";domain=" + path);
    document.cookie = cookieStr;
  },
  /**
   * 读取cookie
   */
  getCookie : function(c_name)
  {
    if (document.cookie.length > 0)
    {
      c_start = document.cookie.indexOf(c_name + "=");
      if (c_start != -1)
      {
        c_start = c_start + c_name.length + 1;
        c_end = document.cookie.indexOf(";", c_start);
        if (c_end == -1)
          c_end = document.cookie.length;
        return unescape(document.cookie.substring(c_start, c_end));
      }
    }
    return "";
  },
  /**
   * 日期格式化函数
   */
  formatDate : function(value, format)
  {
    if (value == null)
    {
      return "";
    }
    var date = new Date(value);
    if (arguments.length < 2 && !date.getTime)
    {
      format = date;
      date = new Date();
    }
    typeof format != 'string' && (format = 'YYYY年MM月DD日 hh时mm分ss秒');
    var week =
    [ 'Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday',
        'Saturday', '日', '一', '二', '三', '四', '五', '六' ];
    return format.replace(/YYYY|YY|MM|DD|hh|mm|ss|星期|周|www|week/g,
        function(a)
        {
          switch (a)
          {
          case "YYYY":
            return date.getFullYear();
          case "YY":
            return (date.getFullYear() + "").slice(2);
          case "MM":
            return date.getMonth() + 1;
          case "DD":
            return date.getDate();
          case "hh":
            return date.getHours();
          case "mm":
            return date.getMinutes();
          case "ss":
            return date.getSeconds();
          case "星期":
            return "星期" + week[date.getDay() + 7];
          case "周":
            return "周" + week[date.getDay() + 7];
          case "week":
            return week[date.getDay()];
          case "www":
            return week[date.getDay()].slice(0, 3);
          }
        });
  },
  jsonp : function(url, data, successFunction, errorFunction)
  {
    $.ajax(
    {
      url : url,
      data : data,
      dataType : 'jsonp',
      jsonp : "jsonpcallback",
      success : function(data)
      {
        successFunction(data)
      },
      error : function(response)
      {
        errorFunction(response);
      },
      timeout : 10000
    });
  },
  json : function(url, data, successFunction, errorFunction)
  {
    $.ajax(
    {
      url : url,
      data : data,
      dataType : 'json',
      success : function(data)
      {
        successFunction(data)
      },
      error : function(response)
      {
        errorFunction(response);
      },
      timeout : 10000
    });
  },
  ajax : function(url, data, successFunction, errorFunction)
  {
    $.ajax(
    {
      url : url,
      data : data,
      dataType : 'text',
      success : function(data)
      {
        successFunction(data)
      },
      error : function(response)
      {
        errorFunction(response);
      },
      timeout : 10000
    });
  },
  /**
   * 获取Url请求参数
   * 
   * @param name
   * @returns
   */
  getParameter : function(name)
  {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); // 匹配目标参数
    if (r != null)
      return unescape(r[2]);
    return null; // 返回参数值
  }
}

/**
 * 返回到页面顶部或指定位置
 * @param {top:xx, left:xx ,speed: xx, time:xx}
 * @returns null
 */
//(function ($) {
//    $.fn.backTop = function (options) {
//        var opts = $.extend({ top: 0, time: 500 }, options);
//        $(this).click(function () {
//            $.backTop(opts.top, opts.time);
//        });
//    };
//    $.extend({
//        backTop: function (args) {
//            $("html,body").animate({ scrollTop: arguments.length >= 1 ? arguments[0] : 0 }, arguments.length == 2 ? arguments[1] : 500);
//        }
//    });
//})(jQuery);


//QQ客服
$("body").on('click',".j_qq",function(event) {
  event.preventDefault();
  var url = 'http://wpd.b.qq.com/cgi/get_sign.php?na=4006611603&kfuin=938062714&aty=0&a=2&sid=1340311&uid=428083200&url=http%3A%2F%2Fwww.go2.cn%2F&title=&dm=go2.cn&clkSrc=&cb=QQ_CALLBACK';
  $.ajax({
    url       : url,
    dataType    : 'jsonp',
    jsonpCallback : "QQ_CALLBACK",
    success     : function(obj) {
      var url = obj.data.sign;location.href = url;
    }
  });
  return false;
});


/**
 * 时间格式化
 * @param string
 * @returns format string
 */
Date.prototype.Format = function(fmt) {
    var o =
    {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};


Date.prototype.addDays = function(d)
{
    this.setDate(this.getDate() + d);
};


Date.prototype.addWeeks = function(w)
{
    this.addDays(w * 7);
};


Date.prototype.addMonths= function(m)
{
    var d = this.getDate();
    this.setMonth(this.getMonth() + m);

    if (this.getDate() < d)
        this.setDate(0);
};


Date.prototype.addYears = function(y)
{
    var m = this.getMonth();
    this.setFullYear(this.getFullYear() + y);

    if (m < this.getMonth()) 
     {
        this.setDate(0);
     }
};

$(function(){
  ps=$.util.getParameter('_ps');
  if(!ps||'null'==ps){
    ps=20;
  }
  $('#pageSizeChooser button').html(ps+'&nbsp;<span class="caret"></span>');
  $('#pageNumForJump').keyup(function(){
    if(event.keyCode==13){
      window.location.href='?_pn='+$('#pageNumForJump').val()+'&_ps='+$.util.getParameter('_ps');
    }
  });
  $('#pageNumForJumpBtn').click(function(){
    window.location.href='?_pn='+$('#pageNumForJump').val()+'&_ps='+$.util.getParameter('_ps');
  });
  $('#pageSizeChooser a').click(function(){
    window.location.href='?_pn=1&_ps='+$(this).attr('s');
  });
  $('.pagination a').click(function(){
    window.location.href='?_pn='+$(this).attr('pn')+'&_ps='+$.util.getParameter('_ps');
  });
});