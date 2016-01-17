<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />

<!-- 页面标题==========================================-->
<title>用户中心-操作日志</title>

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
			<p class="bold f16">最新消息:</p>
			<c:forEach var="operationLog" items="${operationLogList}">
				<p class="f14"><c:out value="${operationLog.content}" /></p>
        <p class="f14"><fmt:formatDate value="${operationLog.createTime}" pattern="yyyy-MM-dd"/></p>
			</c:forEach>
		</div>
	</div>

	<!-- 页脚==========================================-->
	<%@include file="/jsp/common/footer.jsp"%>

	<!-- 私有js==========================================-->

</body>
</html>