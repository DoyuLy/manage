<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />

<!-- 页面标题==========================================-->
<title>用户中心-服务承诺</title>

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
    这里是内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容
    <div id="mbox_center">
      <table class="table">
        <tr>
          <th style="height: 50px; line-height: 100%;"><c:choose>
              <c:when test="${supplierRank != null }"> 您的排名为：第 <font color=red>${supplierRank.rank}</font> 名，您的评分为：<font color=red>${supplierRank.score}</font> 分(<a
                  href="/manage/promotion/scoredetail">详情</a>)，对应级别为&nbsp;<img
                  src="/images/slevel/s_{($supplierRank->score|ceil)|level}.gif" />
              </c:when>
              <c:otherwise>
                <p>目前您还没有您的积分记录!</p>
              </c:otherwise>
            </c:choose></th>
        </tr>
      </table>

      <c:choose>
        <c:when test="${msg != null }">
          <table width="100%" class="billboard">
            <thead>
              <tr>
                <th colspan="10" style="font-size: 32px; height: 60px; color: yellow">购途供应商TOP500</th>
              </tr>
            </thead>
            <tr align="center">
              <th width="70">排名</th>
              <th>供应商</th>
              <th width="100">评分</th>
              <th width="200">评级</th>
            </tr>
            <tbody>
              <c:forEach var="supplierRank" items="${supplierRankList }">
                <tr class="{cycle values='odd,even'}">
                  <td>${supplierRank.rank }.</td>
                  <td>*****</td>
                  <td>${supplierRank.score }</td>
                  <td><img src="/images/slevel/s_{($v->score|ceil)|level}.gif" /></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </c:when>

        <c:otherwise>
          <table class="table">
            <tr>
              <th style="height: 100px; line-height: 200%;">
                <p>${msg }</p>
              </th>
            </tr>
          </table>
        </c:otherwise>
      </c:choose>
    </div>

  </div>

  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>

  <!-- 私有js==========================================-->

</body>
</html>