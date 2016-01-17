<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />
<link rel="stylesheet" href="/css/userCenter/supplier/vipLoad.css" />

<!-- 页面标题==========================================-->
<title>用户中心-产品下载记录</title>

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
      <p class="f16 bold">产品下载记录</p>
      <table class="gridtable">
        <tr>
          <th>会员号</th>
          <th>所在地区</th>
          <th>产品</th>
          <th>下载时间</th>
        </tr>
        <c:forEach var="productMap" items="${paginationData.list}">
          <tr>
            <c:forEach var="product" items="${productMap}">
              <td>${product.value}</td>
            </c:forEach>
          </tr>
        </c:forEach>
      </table>
      <!--------分页条-------->
      <%@include file="/jsp/common/pagination.jsp"%>
      <!--------分页条-------->
    </div>
  </div>

  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>

  <!-- 私有js==========================================-->

</body>
</html>