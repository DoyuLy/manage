<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />
<link rel="stylesheet" href="/css/userCenter/supplier/myAnnounce.css" />

<!-- 页面标题==========================================-->
<title>用户中心-厂家公告</title>

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
		<div class="right-con">
			<form method="post" onsubmit="check_msg()" class="msg-form">
				<textarea id="id_msg_notice" name="msg_notice"></textarea>
				<input type="submit" value="发布消息" class="sub-btn f16 bold" />
			</form>
			<p class="f16 bold">最近消息:</p>
			<c:forEach var="supplierAnnounce" items="${supplierAnnounceList}">
				<p class="one-announce">
					<c:out value="${supplierAnnounce.content}" />
				</p>
			</c:forEach>
		</div>
	</div>

	<!-- 页脚==========================================-->
	<%@include file="/jsp/common/footer.jsp"%>

	<!-- 私有js==========================================-->

	<!-- 消息框验证 -->
	<script>
		function check_msg() {
			var flag = true;
			var areaNode = document.getElementById('id_msg_notice');
			var newscheck = /^(\s)*$/gi;
			if (newscheck.test(areaNode.value)) {
				//if(areaNode.value == ''){
				var flag = false;
				alert('发布的消息不能为空！');
				document.getElementById('id_msg_notice').focus();
			}
			return flag;
		}
	</script>

</body>
</html>
