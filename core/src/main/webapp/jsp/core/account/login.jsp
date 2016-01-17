<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- JSTL===========================================-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/core/account/login.css"/>
<style type="text/css">

</style>
<!-- 页面标题==========================================-->
<title>首页</title>

<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.min.js"></script>
      <script src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

  <!-- 导航==========================================-->
  <%@include file="/jsp/common/nav.jsp"%>

  <!-- 内容==========================================-->
  <div class="message">
      <a class="logo" href="" target="_blank"></a>
      <div class="about_us">
      <p class="fy24 welcome">欢迎登录</p>
      <p class="f12 aaaaaa">中国最大女鞋商货源市场/一只也批发</p>
    </div>
  </div>
  <!-- 注册模块 -->
  <div class="content">
    <img class="b2" src="${ctx }/img/b2.jpg">
    <div class="po">
      <div class="login">
        <p class="l_t fy18">
          go2会员
          <a class="rin f14 ff6c00" href="/register">免费注册</a>
        </p>
        <c:if test="${errorCode == '1'}"><p class="back-error">用户名账号或密码不能为空</p></c:if>
        <c:if test="${errorCode == '2'}"><p class="back-error">用户名或密码错误</p></c:if>
        <c:if test="${errorCode == '3'}"><p class="back-error">用户名或密码错误</p></c:if>
        <c:if test="${errorCode == '6'}"><p class="back-error">非法登录</p></c:if>
        
        <form id="login_form" action="/login" method='post' onSubmit="return login.validate()">
          <div class="det_message">
            <div class="input_r name_r"></div>
            <div class="login_l name_l"></div>
            <input type="text" name="username" id='username' value="test110" class="input f14" placeholder="请输入用户名">
          </div>
          <div class="det_message">
            <div class="login_l pass_l"></div>
            <input type="password" name="password" id='password' value="111" class="input" placeholder="请输入密码">
          </div>
			<div class="det_message qr-box">
				<input type="text" name="verifycode" class="input qr-input" id="verifycode">
                <img id="captcha" src="/login/verify" onclick="this.src='/login/verify?t='+Math.random()">
				<span>看不清楚？</span>
				<a class="refimg f12 captcha">换一张</a>
			</div>
          <div class="sto f12">
          <span id="errorMsg">
                  <c:if test="${errorCode == '4'}">验证码过期</c:if>
                  <c:if test="${errorCode == '5'}">验证码错误</c:if>
          </span>
            <a class="fp" href="/forgetPassword">忘记登录密码？</a>
          </div>
          <input type="submit" class="sub fy18" value="登&nbsp;录">
        </form>
      </div>
    </div>
  </div>

  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>

  <!-- 私有js==========================================-->
  <script src="/js/common/jquery.validate.js"></script>
  <script type="text/javascript">
      //验证码判断是否正确
      $('.input').keyup(function () {
        var value = $(this).val();
        if (value) {
          $('.name_r').css('display','block');
        } else {
          $('.name_r').css('display','none');
        };
      });

      $(function() {
        $('.ope').mouseover(function(){
          $(this).addClass('mouseon');
        });
        $('.ope').mouseout(function(){
          $(this).removeClass('mouseon');
        });
        //输入框聚焦样式
        $('.input').focus(function () {
          $(this).parent('.det_message').addClass('focusin');
        });
        $('.input').blur(function () {
          $(this).parent('.det_message').removeClass('focusin');
        });
        //增加验证规则
        
        
        // 验证码错误验证
        $.validator.addMethod("isVerifycode",function(value,element,params){
            if (value === '') {
              return true;
            }
            var send_data = {'code':value};
            var result;
            $.ajax({
                   type: "post",
                   url: "/validateCode",
                   data: send_data,
                   dataType: "json",
                   async: false,
                   success: function(data){
                if(data){
                  result = true;
                }else{
                  result = false;
                }
              }
            })
            return result;
        });      
        //验证密码合法性
        $.validator.addMethod("isPassword",function(value,element){
          var password = /^[A-Za-z0-9]{6,20}$/;
          var len = value.length;
          var strongele = $(element).parent('.det_message').children('.reminder');
          if (len <6 || len > 20) {
            strongele.css('display','none');
          }
          return this.optional(element) || password.test(value);
        },"请输入6-20位大小写字母和数字的组合");
        //设置验证规则
        var optional = {
          rules:
          {
            username: {
              required: true,
              //isPassword:true          
            },
            password:
            {
              required: true,
              //isPassword:true
            },
            verifycode: {
    			  required: true,
    			  isVerifycode:true
    		  }
          },
          messages:
          {
            username: {
              required: "请输入用户名",
              isPassword: '用户名输入不正确，请检查'
            },
            password: {
              required: "请输入密码",
              isPassword: '密码输入不正确，请检查'
            },
            verifycode: {
    			  required: "请输入验证码",
    			  isVerifycode: '验证码错误，请重新输入'
    		  }
          },
          highlight: function( element, errorClass, validClass ) {
            if ( element.type === "radio" ) {
              this.findByName(element.name).addClass(errorClass).removeClass(validClass);
            } else {
              $(element).addClass(errorClass).removeClass(validClass);
            }
            $(element).parent('.det_message').addClass(errorClass);
          },
          unhighlight: function( element, errorClass, validClass ) {
            if ( element.type === "radio" ) {
              this.findByName(element.name).removeClass(errorClass).addClass(validClass);
            } else {
              $(element).removeClass(errorClass).addClass(validClass);
            }
            $(element).parent('.det_message').removeClass(errorClass);
          }
        }
        //  开启验证
        var validator = $('#login_form').validate(optional);
        });
        //清楚用户名输入框
        $('.name_r').click(function () {
          $(this).parent('.det_message').children('.input').val('');
        })

      
      // 刷新验证码
      $('.captcha').click(function() {
          $.get('/login/verify?refresh=1', function(str) {
              $('#captcha').attr("src","/login/verify?res="+ Math.random());
          });
      }).css('cursor', 'pointer');
  </script>
</body>
</html>