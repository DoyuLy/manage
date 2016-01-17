<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<style type="text/css">
        * {margin: 0;padding: 0;border:0;text-decoration: none;outline: none;}
        .f12{font-size:12px!important}
        .f13{font-size:13px!important}
        .f14{font-size:14px!important}
        .fy12{font-size:12px!important;font-family:"Microsoft YaHei",微软雅黑,"Microsoft JhengHei";}
        .fy14{font-size:14px!important;font-family:"Microsoft YaHei",微软雅黑,"Microsoft JhengHei";}
        .fy16{font-size:16px!important;font-family:"Microsoft YaHei",微软雅黑,"Microsoft JhengHei";}
        .fy18{font-size:18px!important;font-family:"Microsoft YaHei",微软雅黑,"Microsoft JhengHei";}
        .fy20{font-size:20px!important;font-family:"Microsoft YaHei",微软雅黑,"Microsoft JhengHei";}
        .fy24{font-size:24px!important;font-family:"Microsoft YaHei",微软雅黑,"Microsoft JhengHei";}
        .fy30{font-size:30px!important;font-family:"Microsoft YaHei",微软雅黑,"Microsoft JhengHei";}
    .fa26{font-size: 26px;font-family: arial;}
        .bold{font-weight:bold}
        .normal{font-weight:normal}
        .aaaaaa{color: #aaaaaa;}
        .ff6c00{color: #ff6c00;}
        .separate{margin: 0 5px;color: #cbcbcb;}
    .pull-left{float: left}
    .pull-right{float: right}
        /*header*/
        .head_container{width: 100%;padding-top: 1px;border-bottom: 1px solid #e6e6e6;height: 34px;background-color: #f3f3f3;}
            .user_status{width: 1164px;height: 34px;margin: 0 auto;color: #818181;line-height: 34px;}
                .users{float: left;border-left: 1px solid #e6e6e6;border-right: 1px solid #e6e6e6;padding: 0 20px;}
                    .userscenter{float: left;cursor: pointer;}
                        .users span{float: left;}
                        .tri_gray{display: block;width: 8px;height: 5px;background-image: url(/img/b1.png);background-repeat: no-repeat;bacground-position: 0 0;margin-top: 14px;margin-left: 5px;}
                    .exit{color: #818181;margin-left: 5px;cursor: pointer;float: left;line-height: 34px;background-color: transparent;}
                .head-left{padding: 0 10px;border-left: 1px solid #e6e6e6;height: 34px;float: left;position: relative;box-sizing: border-box;text-align: center}
        .head-left a{color: #818181;display: block;padding: 0 10px;}
        .head-left a:hover{color: #ff6c00}
        .borr1{border-right: 1px solid #e6e6e6}
        .hnav{float: right;height: 34px;border-right: 1px solid #e6e6e6;}
                    .det_nav{padding: 0 10px;border-left: 1px solid #e6e6e6;height: 34px;float: left;position: relative;box-sizing: border-box;width: 83px;text-align: center}
                        .det_nav a{color: #818181;float: left;}
                        .det_nav a:hover{color: #ff6c00;}
                        .tri_black{display: block;width: 8px;height: 6px;background-image: url(/img/b1.png);background-repeat: no-repeat;background-position: 0 -6px;margin-top: 14px;margin-left: 5px;float: left;}
                        .fd{z-index: 99;display: none;padding: 0 10px 10px;background-color: white;width: 84px;box-sizing: border-box;-moz-box-sizing: border-box;-webkit-box-sizing: border-box;position: absolute;top: 34px;right: -1px;border: 1px solid #e6e6e6;border-top: 0;line-height: 22px;}
                        .fdl{float: none!important;width: 50px;display: inline-block;line-height: 22px;text-align: left}
            .w100p{width: 100%}
                    .mouseon{background-color: white;}
                    .mouseon .tri_black{background-position: 0 -12px;background-image: url("/img/b1.png")}
                    .mouseon .fd{display: block}
                    .qq{cursor: pointer}
        div.error .login_l{border-color: red;}
        input.error{border-color: red;}
        label.error{color: red;font-size: 12px;position: relative;bottom: 2px;margin-left: 10px;}
        div.focusin .login_l{border-color: #ff6c00;}
        div.focusin .name_l{background-image: url(/img/h_i_o.jpg);background-position: 0 0;}
        div.focusin .pass_l{background-image: url(/img/p_i_o.jpg);background-position: 0 0;}
        div.focusin .input{border-color: #ff6c00;}
        /*logo*/
        .message{height: 43px;width: 1164px;margin: 36px auto 0;}
            .logo{width: 107px;height: 43px;background-image: url(/img/logo_03.png);background-repeat: no-repeat;float: left;}
            .about_us{float: left;height: 43px;border-left: 1px solid #d9d9d9;margin-left: 11px;padding-left: 10px;}
                .welcome{line-height: 43px;}
    /*content*/
    .contentPs{width: 1190px;margin: 80px auto 0;}
    .focusin{border-color: #ff6c00!important;}
    /*状态示意图*/
    .statusbox{width: 989px;margin: 0 auto;height: 95px;margin-bottom: 80px}
    .start-line{width: 61px;height: 13px;border-bottom-left-radius: 5px;border-top-left-radius: 5px;margin-top: 21px;}
    .completed-line{background-color: #ffa115;}
    .uncompleted-line{background-color: #d3d3d3;}
    .status-det{line-height: 55px;text-align: center;width: 55px;height: 55px;margin-left: -1px;}
    .completed-status{background-image: url("/img/stepok.png");color: #ffa115}
    .mid-line{width: 217px;height: 13px;margin-top: 21px;margin-left: -1px;}
    .uncompleted-status{background-image: url("/img/stepun.png");color: #c4c4c4}
    .end-line{width: 61px;height: 13px;border-bottom-right-radius: 5px;border-top-right-radius: 5px;margin-top: 21px;margin-left: -2px;}
    .status-text{clear: both;overflow: hidden;padding-top: 26px}
    .status-text p{color: #848484;font-size: 12px}
    .step1{padding-left: 57px;}
    .step2{padding-left: 216px;}
    .step3{padding-left: 216px;}
    .step4{padding-left: 229px;}
    /*输入信息模块*/
    .ope-step1{overflow: hidden}
    .username{height: 39px;line-height: 39px;margin-bottom: 33px}
    .intitle{float: left;width: 420px;font-size: 14px;font-weight: bold;color: #6b6b6b;text-align: right;margin-right: 15px;}
    .inputtext{border: 1px solid #c4c4c4;height: 39px;line-height: 39px;box-sizing: border-box;padding-left: 5px;font-size: 14px;color: #6b6b6b;width: 311px;float: left}
    .qr-code{width: 146px;margin-right: 10px;}
    .qr-img{float: left;display: block;margin-right: 15px}
    .change-qr{line-height: 39px;float: left;color: #0072ff;font-size: 12px;cursor: pointer}
    .btn-con{overflow: hidden}
    .subbtn{margin-left: 435px;width: 133px;height: 43px;background-image: url("/img/btnback.jpg");border-radius: 4px;color: white;margin-bottom: 112px;cursor: pointer}
    /*验证方式选择*/
    .auth-way{margin-right: 40px;font-size: 14px;color: #737373}
    .email-auth{display: none}
    .auth-link{color: #ff6c00}
    .get-auth{box-sizing: border-box;height: 39px;border: 1px solid #e8e8e8;background-color: #f8f8f8;color: #545454;width: 129px;text-align: center;margin-left: 10px;float: left;cursor: pointer}
    /*验证完成*/
    .back-ok{padding-left: 400px;overflow: hidden;padding-bottom: 112px;}
    .okicon{display: block;float: left;}
    .ok-msg{float: left}
    .ok-title{color: #3d3d3d;font-size: 20px;line-height: 40px}
    .go-login{font-size: 14px;color: #2962d6;line-height: 22px}
  </style>
<!-- 页面标题==========================================-->
<title>找回密码</title>

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
  <div class="content">
  	<div class="message">
        <a class="logo" href=""></a>
        <div class="about_us">
            <p class="fy24 welcome">找回密码</p>
        </div>
    </div>
    <!-- 找回密码 -->
    <div class="contentPs">
    <c:choose>
      <c:when test="${step=='1'}">
          <!-- 状态1-->
          <div class="status-box1">
            <div class="statusbox">
              <div class="start-line pull-left completed-line">
              </div>
              <div class="status-det pull-left completed-status fa26">
                1
              </div>
              <div class="mid-line pull-left uncompleted-line">
              </div>
              <div class="status-det pull-left uncompleted-status fa26">
                2
              </div>
              <div class="mid-line pull-left uncompleted-line">
              </div>
              <div class="status-det pull-left uncompleted-status fa26">
                3
              </div>
              <div class="mid-line pull-left uncompleted-line">
              </div>
              <div class="status-det pull-left uncompleted-status fa26">
                4
              </div>
              <div class="end-line pull-left uncompleted-line">
              </div>
              <div class="status-text">
                <p class="pull-left step1">填写用户名</p>
                <p class="pull-left step2">验证身份</p>
                <p class="pull-left step3">设置新密码</p>
                <p class="pull-left step4">完成</p>
              </div>
            </div>
            <div class="ope-step1">
              <form id="step-01" action="/forgetPassword/getname" method="post">
                <div class="username">
                  <p class="intitle">用户名</p>
                  <input type="text" name="username" class="inputtext" placeholder="请输入您要找回的用户名">
                </div>
                <div class="username">
                  <p class="intitle">验证码</p>
                  <input type="text" name="code" class="inputtext qr-code" placeholder="请按右侧图片填写">
                  <img src="/login/verify" class="qr-img">
                  <a class="change-qr">看不清，换一张</a>
                </div>
                <div class="btn-con">
                  <input type='submit' class="subbtn fy18" value="下一步"></input>
                </div>
              </form>
            </div>
          </div>
      </c:when>
      <c:when test="${step=='2'}">
      <!-- 状态2-->
        <div class="status-box2">
          <div class="statusbox">
            <div class="start-line pull-left completed-line">
            </div>
            <div class="status-det pull-left completed-status fa26">
              1
            </div>
            <div class="mid-line pull-left completed-line">
            </div>
            <div class="status-det pull-left completed-status fa26">
              2
            </div>
            <div class="mid-line pull-left uncompleted-line">
            </div>
            <div class="status-det pull-left uncompleted-status fa26">
              3
            </div>
            <div class="mid-line pull-left uncompleted-line">
            </div>
            <div class="status-det pull-left uncompleted-status fa26">
              4
            </div>
            <div class="end-line pull-left uncompleted-line">
            </div>
            <div class="status-text">
              <p class="pull-left step1">填写用户名</p>
              <p class="pull-left step2">验证身份</p>
              <p class="pull-left step3">设置新密码</p>
              <p class="pull-left step4">完成</p>
            </div>
          </div>
          <div class="ope-step1">
            <form id="step-02" action="/forgetPassword/checkMobile" method="post">
              <div class="username">
                <p class="intitle">验证方式</p>
                <input type="radio" name="ways" value="0" checked class="auth-radio">
                <label class="auth-way">手机号:${mobile }</label>
                <c:if test="${!empty email }">
                  <input type="radio" name="ways" value="1" class="auth-radio">
                  <label class="auth-way">邮箱:${email }</label>
                </c:if>
                
              </div>
              <div class="phone-auth">
                <div class="username">
                  <p class="intitle">手机号</p>
                  <span class="auth-link bold">
                  <input type="hidden" id="mobile" value="${mobileTrue }" name="mobile">
                  ${mobile }
                  </span>
                </div>
                <div class="username">
                  <p class="intitle">验证码</p>
                  <input type="text"  name="code_phone" class="inputtext qr-code" placeholder="请输入验证码">
                  <p class="f14 get-auth" id="mymobile">获取短信验证码</p>
                </div>
              </div>
              <div class="email-auth">
                <div class="username">
                  <p class="intitle">邮箱地址</p>
                  <input type="hidden" id="email" value="${emailTrue }" name="email">
                  <span class="auth-link bold">
                  ${email }
                  </span>
                </div>
                <div class="username">
                  <p class="intitle">验证码</p>
                  <input type="text" name="code_email" class="inputtext qr-code" placeholder="请输入验证码">
                  <p class="f14 get-auth" id="myemail">发送验证码到邮箱</p>
                </div>
              </div>
              <div class="btn-con">
                <input type='submit' class="subbtn fy18" value="下一步"></input>
              </div>
            </form>
          </div>
    </div>
      </c:when>
      <c:when test="${step=='3'}">
          <!-- 状态3-->
          <div class="status-box3">
            <div class="statusbox">
              <div class="start-line pull-left completed-line">
              </div>
              <div class="status-det pull-left completed-status fa26">
                1
              </div>
              <div class="mid-line pull-left completed-line">
              </div>
              <div class="status-det pull-left completed-status fa26">
                2
              </div>
              <div class="mid-line pull-left completed-line">
              </div>
              <div class="status-det pull-left completed-status fa26">
                3
              </div>
              <div class="mid-line pull-left uncompleted-line">
              </div>
              <div class="status-det pull-left uncompleted-status fa26">
                4
              </div>
              <div class="end-line pull-left uncompleted-line">
              </div>
              <div class="status-text">
                <p class="pull-left step1">填写用户名</p>
                <p class="pull-left step2">验证身份</p>
                <p class="pull-left step3">设置新密码</p>
                <p class="pull-left step4">完成</p>
              </div>
            </div>
            <div class="ope-step1">
              <form id="step-03" action="/forgetPassword/setNewpassword" method='post'>
                <div class="username">
                  <p class="intitle">新密码</p>
                  <input type="password" name="password01" class="inputtext" placeholder="请输入6-20位新密码">
                </div>
                <div class="username">
                  <p class="intitle">重复新密码</p>
                  <input type="password" name="password02" class="inputtext" placeholder="请再次输入密码，并保持两次输入一致">
                </div>
                <div class="btn-con">
                  <button class="subbtn fy18">下一步</button>
                </div>
              </form>
            </div>
          </div>
      </c:when>
      <c:when test="${step=='4'}">
      <!-- 状态4-->
        <div class="status-box4">
          <div class="statusbox">
            <div class="start-line pull-left completed-line">
            </div>
            <div class="status-det pull-left completed-status fa26">
              1
            </div>
            <div class="mid-line pull-left completed-line">
            </div>
            <div class="status-det pull-left completed-status fa26">
              2
            </div>
            <div class="mid-line pull-left completed-line">
            </div>
            <div class="status-det pull-left completed-status fa26">
              3
            </div>
            <div class="mid-line pull-left completed-line">
            </div>
            <div class="status-det pull-left completed-status fa26">
              4
            </div>
            <div class="end-line pull-left completed-line">
            </div>
            <div class="status-text">
              <p class="pull-left step1">填写用户名</p>
              <p class="pull-left step2">验证身份</p>
              <p class="pull-left step3">设置新密码</p>
              <p class="pull-left step4">完成</p>
            </div>
          </div>
          <div class="ope-step1">
            <div class="back-ok">
              <img src="/img/okicon.jpg" class="okicon">
              <div class="ok-msg">
                <p class="ok-title">设置新密码成功</p>
                <a href="/login" class="go-login">现在去登录</a>
              </div>
            </div>
          </div>
        </div>
      </c:when>
      <c:otherwise>
      </c:otherwise>
    </c:choose>
		
		
		
		
    </div>
  </div>
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  <script src="/js/common/jquery.validate.js"></script>
  <script type="text/javascript">
      $(function() {
        $('.ope').mouseover(function(){
            $(this).addClass('mouseon');
        });
        $('.ope').mouseout(function(){
            $(this).removeClass('mouseon');
        });
      
        
      
      $('.auth-radio').click(function () {
      	var auth = $(this).val();
      	if (auth == 0) {
      		$('.phone-auth').css('display','block');
      		$('.email-auth').css('display','none');
      	}else if (auth == 1) {
      		$('.phone-auth').css('display','none');
      		$('.email-auth').css('display','block');
      	}
      });
      //输入框聚焦样式
      $('.inputtext').focus(function () {
          $(this).addClass('focusin');
      });
      $('.inputtext').blur(function () {
          $(this).removeClass('focusin');
      });
      
      //刷新验证码
      $('.qr-img, .change-qr').click(function() {
         $(".qr-img").attr("src","/login/verify?res="+ Math.random());
      }).css('cursor', 'pointer'); 
      
      // 发送短信功能
      $('#mymobile').click(function(){
      	var send_data = {'mobile':$('#mobile').val(),'_csrf':"<?= $_csrf ?>"};
      	$.post('/mobileCode',send_data,function(data){
      			alert(data);
      	});
      })
      
      // 发送邮件功能
      $('#myemail').click(function(){
      	var send_data = {'email':$('#email').val()};
      	$.post('/eamilCode',send_data,function(data){
                alert(data);
      	})
      })
      //增加验证规则
      //验证密码合法性
      $.validator.addMethod("isPassword",function(value,element){
          var password = /^[A-Za-z0-9]{6,20}$/;
          var len = value.length;
          return this.optional(element) || password.test(value);
      },"请输入6-20位大小写字母和数字的组合");
      
      //验证重复输入密码是否正确
      $.validator.addMethod("eqPassword",function(value,element){
      	var pass_01 = $('input[name=password01]').val();
      	return this.optional(element) || (pass_01 === value);
      }, "两次输入的密码不相同，请检查");
      
          // 手机号码合法性
      $.validator.addMethod("isMobile",function(value,element){
      	var length = value.length;
      	var mobile = /^[1][34578][0-9]{9}$/;
      	return this.optional(element) || (length == 11 && mobile.test(value));
      }, "请正确填写您的手机号码");     		    
      
      // 检测用户名是否存在
      $.validator.addMethod("checkname",function(value,element){
      if (value === '') {
      	return true;
      }
      var self = $(element);
      var send_data = {'username':value,'_csrf':"<?= $_csrf ?>"};
      var result;
      $.ajax({
             type: "post",
             url: "/register/ajaxname",
             data: send_data,
             dataType: "json",
             async: false,
             success: function(data){
      		if(!data){
      			result = false;
      		}else{
                  result = true;
      		}
      	}
      })
      return result;	    	
      });
      
      // 检测图片验证码
      $.validator.addMethod("checkpiccode",function(value,element){
      if (value === '') {
      	return true;
      }
      var self = $(element);
      var send_data = {'code':value,'_csrf':"<?= $_csrf ?>"};
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
      
      // 检测短信码是否正确
      $.validator.addMethod("checkmobilecode",function(value,element){
      if (value === '') {
      	return true;
      }
      var self = $(element);
      var send_data = {'code':value,'mobile':$('#mobile').val(),'_csrf':"<?= $_csrf ?>"};
      var result;
      $.ajax({
             type: "post",
             url: "/forgetPassword/ajaxmobilecode",
             data: send_data,
             //dataType: "json",
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
      
      // 检测短信码和邮箱码是否正确
      $.validator.addMethod("checkemailcode",function(value,element){
      if (value === '') {
      	return true;
      }
      var self = $(element);
      var send_data = {'code':value,'email':$('#email').val()};
      var result;
      $.ajax({
             type: "post",
             url: "/forgetPassword/ajaxemailcode",
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
      
      //设置验证规则
      var optional = {
          rules:
          {
              username: {
                  required: true,
                  checkname: true
              },
              mobile: {
              	required: true,
              	isMobile: true
              },
              email: {
              	required: true,
              },
              password01:
              {
                  required: true,
                  isPassword: true
              },
      password02:
      {
      	required: true,
      	isPassword: true,
      	eqPassword: true
      },
      code: {
      	required: true,
      	checkpiccode: true
      },
      code_phone: {
      	required: true,
      	checkmobilecode: true
      },
      code_email: {
      	required: true,
      	checkemailcode: true
      }
          },
          messages:
          {
              username: {
                  required: "请输入用户名",
                  checkname: '用户名不存在'
              },
              email:{
                  required: '请输入邮箱',
                  isEmail: '邮箱格式错误'
              },
              mobile: {
                  required: '请输入手机号',
                  isMobile: '手机号格式不正确'
              },
              password01: {
                  required: "请输入密码",
                  isPassword: "密码由字母，数字组成，长度6-16位"
              },
      password02:
      {
      	required: "请再次输入密码",
      	 isPassword: "密码由字母，数字组成，长度6-16位",
      	 eqPassword: "两次密码不一致"
      },
      code: {
      	required: "请输入验证码",
      	checkpiccode: '验证码错误'
      },
      code_phone: {
      	required: "请输入短信验证码",
      	checkmobilecode: '短信验证码错误'
      },
      code_email: {
      	required: "请输入邮箱验证码",
      	checkemailcode: '邮箱验证码错误'
      }
          }
      }
      //  开启验证
      var validator = $('#step-01').validate(optional);
      var validator = $('#step-02').validate(optional);
      var validator = $('#step-03').validate(optional);
      });
    </script>
</body>
</html>