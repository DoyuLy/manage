<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css"/>
<link rel="stylesheet" href="/css/userCenter/supplier/fastPublish.css"/>

<!-- 页面标题==========================================-->
<title>用户中心-快速发布产品</title>

<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.min.js"></script>
      <script src="/resources/js/respond.min.js"></script>
      <script src="/resources/js/jquery.js"></script>
      <script src="/js/userCenter/fastPublishView.js"></script>
    <![endif]-->
<script src="/resources/js/AC_RunActiveContent.js" type="text/javascript"></script>
</head>
<body>

  <!-- 导航==========================================-->
  <%@include file="/jsp/common/nav.jsp"%>
  
  <!-- 内容==========================================-->
  <div class="content">
  
  	<!-- 二级导航和左侧导航==========================================-->
	<%@include file="/jsp/userCenter/supplier/subNav.jsp"%>
  	<div class="right-con">
  		<div class="right-warper">
  		<h2>快速发布产品<span>(本站客服代发布，客服QQ：4006688702<img style="margin-left:5px;cursor:pointer" class="qq" src="http://www.go2.cn/images/qq_buttom.png">)</span></h2>
        <div class="tips"><strong>重点提示：</strong>本功能是你将<strong><font color="red">产品压缩包</font></strong>在这里上传以后，由我们客服免费帮你发布出来，客服发布的数据更准确，但是您需要保证每个产品都有对应的文字说明，文字说明包含（货号、价格、尺码、颜色、材质）等基本信息，<strong><font color="red">文字说明必须是TXT文件</font></strong>，否则无法正确发布。</div>
        <p>
			<input type="hidden" id="path" value=""><!-- {$supplier->subdomain} -->
<!-- 			{if !empty($t)}<input type="hidden" id="t" value="{$t}">{/if} -->
<!-- 			{if !empty($hash)}<input type="hidden" id="hash" value="{$hash}">{/if} -->
            <script type="text/javascript">
                AC_FL_RunContent( 'codebase','http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0','width','580','height','550','id','update_','align','middle','src','/resources/js/update','quality','high','bgcolor','#ffffff','name','update','allowscriptaccess','always','allowfullscreen','false','pluginspage','http://www.macromedia.com/go/getflashplayer','movie','/resources/js/update' ); //end AC code
            </script>
            <noscript>
                <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=10,0,0,0" width="580" height="550" id="update_" align="middle">
                    <param name="allowFullScreen" value="false" />
                    <param name="allowScriptAccess" value="always" />
                    <param name="movie" value="/resources/js/update.swf" />
                    <param name="quality" value="high" />
                    <param name="bgcolor" value="#ffffff" />
                    <embed src="/resources/js/update.swf" quality="high" bgcolor="#ffffff" width="580" height="550" name="update" align="middle" allowScriptAccess="always" allowFullScreen="false" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />
                </object>
            </noscript>
        </p>
  	</div>
  	 <div class="detail-right">
        <h2>使用说明</h2>
        <ul>
            <li>1、使用方法：点击上图的“选择文件”按钮，找到你所有需要发布的产品图片压缩包，然后点右边的“上传”按钮，等待上传完成，在上传完成前，请不要关闭窗口，也不要切换到其它页面。</li>
            <li>2、通过邮件发送，邮箱地址：<br/>cs@3e3e.cn</li>
            <li>3、快速发布产品是将你所有的款式通过这里上传到服务器，我们人工为你发布。省去你去编辑的麻烦。</li>
            <li>4、人工发布效率有差异，一般上传成功后最长24小时内完成发布！</li>
        </ul>
    </div>
  	</div>
  </div>
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  <script src="/js/userCenter/fastPublishView.js" type="text/javascript"></script>
</body>
</html>