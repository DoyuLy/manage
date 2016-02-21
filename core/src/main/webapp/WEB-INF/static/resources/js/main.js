/**
 * 公共函数
 */
$.util = {
  /**
   * 设置cookie 使用方法：setCookie('username','Darren',30)
   */
  setCookie : function(c_name, value, expiredays, path, domain) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + expiredays);
    var cookieStr = c_name + "=" + escape(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
    // 判断是否有路径
    cookieStr = cookieStr + ((path == null) ? "" : ";path=" + path);
    // 判断是否有域名
    cookieStr = cookieStr + ((domain == null) ? "" : ";domain=" + path);
    document.cookie = cookieStr;
  },
  /**
   * 读取cookie
   */
  getCookie : function(c_name) {
    if (document.cookie.length > 0) {
      c_start = document.cookie.indexOf(c_name + "=");
      if (c_start != -1) {
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
  formatDate : function(value, format) {
    if (value == null) {
      return "";
    }
    var date = new Date(value);
    if (arguments.length < 2 && !date.getTime) {
      format = date;
      date = new Date();
    }
    typeof format != 'string' && (format = 'YYYY年MM月DD日 hh时mm分ss秒');
    var week = [ 'Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', '日', '一', '二', '三', '四', '五', '六' ];
    return format.replace(/YYYY|YY|MM|DD|hh|mm|ss|星期|周|www|week/g, function(a) {
      switch (a) {
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
  jsonp : function(url, data, successFunction, errorFunction) {
    $.ajax({
      url : url,
      data : data,
      dataType : 'jsonp',
      jsonp : "jsonpcallback",
      success : function(data) {
        successFunction(data)
      },
      error : function(response) {
        errorFunction(response);
      },
      timeout : 10000
    });
  },
  json : function(url, data, successFunction, errorFunction) {
    $.ajax({
      url : url,
      data : data,
      dataType : 'json',
      success : function(data) {
        successFunction(data)
      },
      error : function(response) {
        errorFunction(response);
      },
      timeout : 10000
    });
  },
  ajax : function(url, data, successFunction, errorFunction) {
    $.ajax({
      url : url,
      data : data,
      dataType : 'text',
      success : function(data) {
        successFunction(data)
      },
      error : function(response) {
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
  getParameter : function(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); // 匹配目标参数
    if (r != null)
      return unescape(r[2]);
    return null; // 返回参数值
  }
}

$.util.setCookie('sUrl', sps + jsonpPrefix);

$(function() {
  $('.liItem').hover(function() {
    $(this).find('ul.subMenu').slideDown(300);
  }, function() {
    var target = $(this);
    setTimeout(function() {
      $(target).find('ul.subMenu').slideUp(400);
    }, 300);
  });
  // 下拉列表选择后 显示转中选项
  $('.dropdown').delegate('ul a', 'click', function() {
    value = $(this).text();
    $(this).parents('.dropdown').find('button').html(value + ' <span class="caret"></span>');
  });
  $('.menuPanel').delegate('a', 'click', function() {
    $(this).parent().find('a').removeClass('active');
    $(this).addClass('active');
  });
});

function updateRate(d) {
  switch (d) {
  case 0:
    return '实时更新';
  case 1:
    return '每天更新';
  case 2:
    return '每周更新';
  case 3:
    return '每月更新';
  case 4:
    return '每半年更新';
  case 5:
    return '每年更新';
  default:
    return '未知更新频率';
  }
}

function main() {

  (function() {
    'use strict';

    /*
     * ============================================== Testimonial Slider
     * ===============================================
     */

    $('a.page-scroll').click(function() {
      if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
        var target = $(this.hash);
        target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
        if (target.length) {
          $('html,body').animate({
            scrollTop : target.offset().top - 40
          }, 900);
          return false;
        }else{
          window.location.href=ctx+'/'+$(this).attr('href');
        }
      }
    });

    /*
     * ==================================== Show Menu on Book
     * ======================================
     */
    $(window).bind('scroll', function() {

      if ($(".navbar").offset().top > 50) {
        $('.navbar-default').addClass('on');
      } else {
        $('.navbar-default').removeClass('on');
      }
    });

    $('body').scrollspy({
      target : '.navbar-default',
      offset : 180
    // 被监听的元素离顶部还有180px时就出发事件
    })

    $(document).ready(function() {
    });

  }());

}
main();