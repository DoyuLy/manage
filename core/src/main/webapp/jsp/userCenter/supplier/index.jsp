<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css"/>
<link rel="stylesheet" href="/css/userCenter/supplier/index.css"/>

<!-- 页面标题==========================================-->
<title>用户中心</title>

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
  
	<!-- 二级导航和左侧导航==========================================-->
	<%@include file="/jsp/userCenter/supplier/subNav.jsp"%>
	  	<div class="con-left pull-left">
	  		<p>
	  			<span class="fy36">酷购女鞋</span>
	  			<span class="f26">${certifiedType }</span>
	  		</p>
	  		<div>
	  			<p class="tab-head f14">运营详情</p>
	  			<div class="det-box">
	  				<div class="one-tr">
	  					<span class="tab-title">产品</span>
	  					<span class="tab-detail">您最近一周没有发布新款::::${weekPublish }</span>
	  				</div>
	  				<div class="one-tr">
	  					<span class="tab-title">发布到淘宝</span>
	  					<span class="tab-detail">最近一周您没有产品被发布到淘宝</span>
	  				</div>
	  				<div class="one-tr">
	  					<span class="tab-title">下载数据包</span>
	  					<span class="tab-detail">最近一周您没有产品被下载</span>
	  				</div>
	  			</div>
	  		</div>
	  		<div>
	  			<p class="tab-head f14">卖家详情</p>
	  			<div class="det-box">
	  				<div class="one-tr">
	  					<span class="tab-title">购途用户</span>
	  					<span class="tab-detail">最近90天没有购途网站用户下载或发布过您的产品</span>
	  				</div>
	  				<div class="one-tr">
	  					<span class="tab-title">淘宝卖家</span>
	  					<span class="tab-detail">暂时没有淘宝卖家发布过您的产品（自您加入购途网以来）</span>
	  				</div>
	  			</div>
	  		</div>
	  	</div>
	  	<div class="con-right pull-right">
  		<a class="publish-link" href="/userCenter/supplier/fastPublish">发布产品</a>
  		<p class="platform-msg">平台公告</p>
  		<p class="det-msg">2015-10-22</p>
  		<p class="det-msg">
  			尊敬的各位厂商，请及时查看顶部购途厂商经营攻略，并仔细查阅，违规处罚部分会在2015年10月16日开始实施
  		</p>
  	</div>
  	</div>
  </div>
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  
</body>
</html>