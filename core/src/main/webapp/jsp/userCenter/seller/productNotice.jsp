<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />
<link rel="stylesheet" href="/css/userCenter/seller/message.css" />
<!-- 页面标题==========================================-->
<title>产品公告</title>
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
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
    <%@include file="/jsp/userCenter/seller/subNav.jsp"%>
    <div class="right-con">
      <div class="recent-box">
        <p class="recent f16 text-center bold">最近消息</p>
        <c:forEach var="message" items="${paginationData.list}">
          <p class="m-con f14">${message.content}</p>
          <label class="m-time"><span class="time-ago">${message.createTime}</span>来自厂家<a href="/shop/${message.site.subdomain}/" class="fac-from">${message.supplier.title}</a>
            信息 </label>
        </c:forEach>
        <!--------分页条-------->
        <%@include file="/jsp/common/pagination.jsp"%>
        <!--------分页条-------->
      </div>
    </div>

  </div>

  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>

  <!-- 私有js==========================================-->
  <script type="text/javascript" src="/js/common/timeFunction.js"></script>
</body>
</html>