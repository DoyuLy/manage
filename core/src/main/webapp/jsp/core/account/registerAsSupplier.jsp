<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<style>
<!--
body{font-family:"微软雅黑";background:#F3F3F3 url(/img/login/body_bg_01.gif) repeat;}
#regbox{width:970px;margin:0 auto;overflow:hidden;position: relative;}
#rbleft{float:left;width:610px;}
#reglogo{float:left;margin:0;padding:0;margin-top:5px;}
#reglogo img{float:left;border:none;}
#reglogo h1{float:left;font-weight:normal!important;font-weight:bold;margin:0;margin-top:9px;margin-left:8px;padding:0;font-size:26px;}
#reglogo h1 span{font-family:"Verdana";color:#A3A3A3;vertical-align: text-bottom;font-size:24px;font-weight:normal;}
#rbleft form{float:left;margin:0;padding:0;margin-top:15px;width:605px;background:#fff;border:1px solid #E8E8E8;}
#rbleft h2{height:auto!important;height:50px;margin:0;padding:0;font-weight:normal;font-size:14px;color:#666;padding-bottom:10px;border-bottom:1px solid #E8E8E8;overflow:hidden;}
#rbleft h2 a{float:left;margin-top:15px;margin-left:60px;}
#rbleft h2 img{border:none;}
#rbleft h2 span{float:left;margin-top:20px;margin-left:10px;}
#rbleft form p{height:auto!important;height:63px;margin:0;margin-top:5px;overflow:hidden;}
#rbleft p label{float:left;width:544px;margin-left:50px;font-weight:bold;font-size:15px;}
#rbleft p span{margin-left:10px;font-weight:normal;font-size:12px;color:#999;}
#rbleft p input{float:left;margin:5px;margin-bottom:10px;margin-left:60px;font-size:15px;font-weight:bold;font-family:"微软雅黑";padding:3px;border: 0px;outline: 1px solid #999999;}
#rbleft #setdomain{height:auto!important;height:88px;}
#rbleft #setdomain strong{float:left;color:#fff;height:auto!important;height:43px;margin-left:60px;margin-top:10px;margin-bottom:10px;padding:5px 13px 0;background:#D70000;}
#rbleft #setdomain em{float:left;font-size:18px;font-weight:normal;font-style:normal;padding-top:7px;}
#rbleft #setdomain input{float:left;width:100px;margin-left:5px;font-family:Verdana;}
#rbleft p #reg_button{float:left;padding:0;width:164px;height:33px;border:none;background:url(/img/login/reg_button_01.gif) no-repeat;}
#rbleft p img{margin-top:8px;}
.formline{border-bottom:1px solid #E8E8E8;}
#reg_bottom{float:left;margin:10px;line-height:24px;font-size:15px;}
#rgright{float:right;}
#rgright .qq{position: absolute;right:90px;bottom: 210px;display: block;width: 180px;height: 40px;}
#errmsg{background:#999;color:#fff;padding:10px;margin:0 20px;margin-bottom:10px;font-size:15px;line-height:20px;}

#rbleft form #jump_link{
	width:605px; height:60px; margin-top: 0px; padding-top: 0px; text-align: left; margin-bottom: 10px;
}
#rbleft form #jump_link .a_left{
	width:300px; height:60px; padding:0px; margin:0px;display:inline-block; float: left; color:#EF0000;
	line-height: 60px;  text-align: center;	font-size: 30px; 
}
#rbleft form #jump_link .a_right{
	width:300px; height:60px; padding:0px; margin:0px;display:inline-block; float: right; color:#666666;background:#EDEDED;
	line-height: 60px;  text-align: center;	font-size: 30px; 
}

#rbleft p .stau1{
	color:#666;
}
#rbleft p .stau2{
	color:#000;
}
#rbleft p .stau3{
	color:#F00;
}
#rbleft p .stau4{
	color:#0C0;
	/*color:#1A4A88;*/
}
-->
</style>
<!-- 页面标题==========================================-->
<title>欢迎注册</title>

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
  	<div id="regbox">
		<div id="rbleft">
			<form method="post" onSubmit="return regs('cli')">
				<h2><a href="{$smarty.const.MAIN_URL_PREFIX}/user/login"><img src="/img/login/login_button.gif" /></a><span>如果你已经入驻了，请直接点此登录网站后台。</span></h2>
				<div id='jump_link'>
					<a href="/user/register_as_supplier" class='a_left'>注册成为厂家</a>
					<a href="/user/register_as_seller" class='a_right'>注册成为用户</a>
				</div>
				
				<p id="setdomain">
					<label>网站直达域名<span>3-16位英文或数字，越简单易记最好！仅填写网址前缀，如填写“baili”！</span></label>
					<strong><em>http://</em><input type="text" name="subdomain" id="subdomain" value="" /><em>.go2.cn</em></strong><span class="stau1" id="subspan"></span>
				</p>
				<!-- {if $errorMsg}
				<div id="errmsg">{$errorMsg}</div>
				{/if} -->
				<p>
					<label>登录用户名<span>可以是中文也可以是英文，但简单易记最好！</span></label>
					<input type="text" name="username" value="" id="chkusername" /><span class="stau1" id='chkuspan'>输入用户名</span>
				</p>
				<p>
					<label>登录密码<span>6-16位之间。</span></label>
					<input type="password" name="password" value="" id='password' onblur="checkpwd(1)" /><span class="stau1" id='passwordspan'>输入密码</span>
				</p>
				<p class="formline">
					<label>确认登录密码<span>6-16位之间，两次密码要一致。</span></label>
					<input type="password" name="password2" value="" id='password2' /><span class="stau1" id='passwordspan2'>输入确认密码</span>
				</p>			
				<p>
					<label>厂家名称<span>请输入您的厂名(汉字、字母或数字)</span></label>
					<input type="text" name="title" value="" id="suppliertitle" /><span class="stau1" id="supplierspan">输入厂家名称</span>
				</p>
				<p>
					<label>手机号码<span>请输入您的手机号码。</span></label>
					<input type="text" name="mobile" value="" id="chkmobile" maxlength="11" /><span class="stau1" id='chkspan'>输入常用手机号</span>
				</p>
				<p>
					<label>备用手机号码<span>请再输入一个可以联系的手机号码。</span></label>
					<input type="text" name="phone" value=""/><span class="stau1">输入备用联系电话</span>
				</p>
				<p>
					<label>QQ号码<span></span></label>
					<input type="text" name="qq" value="" id='userqq' /><span class="stau1">输入qq</span>
				</p>
				<p>
					<label>门市地址<span>请一定要输入你的拿货门市的地址。</span></label>
					<input type="text" name="address" size="35" value=""/><span class="stau1">输入门市地址</span>
				</p>
				<p class="formline">
					<label>验证码<span>按照图片填写正确的验证码。</span></label>
					<input type="text" name="vcode" id="vcode" size="5" />
					<span id="vcode_container" title="看不清？点击图片更换"><img src="/login/verify" onclick="this.src='/login/verify?t='+Math.random()"></img></span>
				</p>
				<p>
					<input type="submit" id="reg_button" value="　" onclick='return checkpwd(2)' />
				</p>
			</form>
		</div>
		<div id="rgright"><img src="/img/login/reg_img_01.gif" />
	        <a class="qq" target="_blank" href="#"></a>
	    </div>
	</div>
  </div>
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  
</body>
</html>