<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- JSTL===========================================-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<style type="text/css">
<!--
#login_body{width:970px;height:480px;margin:30px auto;overflow:hidden;}
#lb_left{float:left;}
#login_box{float:right;display:inline;width:328px;margin:30px;margin-left:0;border:1px solid #E8E8E8;background:#fff;overflow:hidden;}
#login_box h1{float:none;margin:0;padding:10px;padding-top:18px;border-bottom:1px solid #E8E8E8;overflow:hidden;font-size:16px;}
#login_box h1 span{margin-left:10px;font-weight:normal;font-family:Verdana;}
#login_box form{margin:0 15px;padding:0;padding-top:15px;}
#login_box form p{width:290px;margin:0;padding:8px 5px;font-size:15px;font-weight:bold;overflow:hidden;}
#login_box form p label{float:left;width:70px;padding-top:6px;text-align:right;}
#login_box form p input{float:left;margin-left:5px;font-size:15px;font-weight:bold;padding:2px;font-family:"微软雅黑","Verdana";width:120px;}
#login_box form p #vcode{width:50px;}
#login_box form p img{float:right;width:65px;height:25px;border:1px solid #E8E8E8;margin-left:10px;margin-top:3px;}
#login_box form p .login_button{float:left;padding:0;width:80px;height:33px;border:none;background:url(/images/login_button.gif) no-repeat;}
#login_box form #loginerror{margin-left:9px;margin-bottom:10px;background:#BF0000;color:#fff;font-size:13px;}
#login_notes{margin:20px;margin-top:10px;padding-top:18px;padding-bottom:18px;font-size:15px;text-align:center;border-top:1px solid #E8E8E8;}
#login_notes a{margin:0 8px;}
.btn_active {border-bottom: 2px solid #0066CC; color:#0066CC;}
.kus01 {font-size: 16px;font-weight: normal;height:20px;font-family:宋体;padding-bottom: 6px;cursor:pointer;}
.kus02 {font-size: 16px;height:20px;font-weight: normal;font-family:宋体;padding-bottom: 6px;cursor:pointer;}
.xpcnt {font-size: 12px;font-weight:normal;padding-left: 50px;color:gray;font-family:宋体}   
.xplong {background:url(/images/dlbont_c1.gif) no-repeat; width:228px;height:28px;line-height:100%;padding: 12px 4px 0px 4px;font-size: 16px;margin: 10px 0px 0px 40px;color:#FFFFFF;text-align:center;margin-bottom: 20px;cursor:pointer;};
-->
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
  <div id="login_body">
	<div id="lb_left"><a href="/user/register"><img src="/img/login/login_ad.jpg" /></a></div>
	<div id="login_box">
        <h1>登录市场<span>Member Login</span></h1> 
            
		<form action="/user/login" method="post" onSubmit="return regs('cli')">
		<input type="hidden" name="ref" value="">
            <p>
                <label>用户名</label>
                <input type="text" name="username" id='username' />&nbsp;<span id='userspan' class="stau1" style="font-size:12px;"></span>
            </p>
            <p>
                <label>登录密码</label>
                <input type="password" name="password" id='password' />&nbsp;<span id='passspan' class="stau1" style="font-size:12px;"></span>
            </p>
            <p>
                <label>验证码</label>			
                <input type="text" name="vcode" id="vcode" style="margin-top:3px;" maxlength="4" /><span id="vcode_container" title="看不清？点击图片更换"></span>					
            </p>
            <p>
                <label></label>
                <input type="submit" class="login_button" value="" />
            </p>
            </form>
        </div>    
        
        <div id="login_notes">
        <a href="/findpsw">忘记密码了？</a><font style="color:#0066CC;">请联系</font><img style="margin-left:5px;cursor:pointer" class="qq" src="/img/login/qq_buttom.png">
        </div>
	</div>

  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>

  <!-- 私有js==========================================-->
  <script>
      
    </script>
</body>
</html>