<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/specialTopic/specialTopic.css" />
<!-- 页面标题==========================================-->
<title>一手货源</title>

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
    <!-- 左侧专题导航内容 -->
    <div class="left-spe">
	    <c:forEach var="specialNew" items="${specialTopicList}">
	      <div class="activity">
	        <span class="date_det">${specialNew.topicStartTime}</span> <a href="/specialTopic/display/${specialNew.id }" class="act_link" target="_blank"
	          style="background-image: url(${specialNew.backgroundImage});"></a>
	        <p class="title">${specialNew.title }</p>
	        <p class="comment">${specialNew.specialComment }</p>
	      </div>
	    </c:forEach>
	</div>
  </div>

  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>

  <!-- 私有js==========================================-->

</body>
</html>