<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- JSTL===========================================-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css"/>
<link rel="stylesheet" href="/css/userCenter/supplier/complaint.css"/>

<!-- 页面标题==========================================-->
<title>用户中心-收到投诉</title>

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
     	<c:if test="${paginationData.total == 0}">
     		<h6 class="com-title">暂无数据</h6>
     	</c:if>
     	<c:if test="${paginationData.total != 0}">
     		<h6 class="com-title">您被投诉的产品列表(总计:${paginationData.total}个产品)</h6>
     	<c:if test="${paginationData.list != null}">
     		<ul>
     			<li class="tab-head">
     				<label class="pro-serial">序号</label>
     				<label class="pro-msg">货物信息</label>
     				<label class="pro-price">价格</label>
     			</li>
     			<c:forEach var="item" items="${paginationData.list}" varStatus="status">
     				<li class="one-msg">
   						<p class="serial">${status.index + 1 }.</p>
						<c:if test="${item.product.indexImage != ''}"> 
  							<a href="/product/${item.product.id}.go" class="pro-link" target="_blank">
  								<img src="http://thumb.w3.ximgs.net/thumbs${fn:substringBefore(item.product.indexImage, '.')}_80x80.jpg" alt="product image"/>
  							</a>
						</c:if>
						<c:if test="${item.product.indexImage eq ''}">
   							没有图片
   						</c:if>
   						<dl class="pro-info">
   							<dt class="bold">
   								<span class="bold f14">商品编码:</span>
   								<a href="/product/${item.product.id}.go" class="number-link bold f14" target="_blank">${item.product.articleNumber}</a>
   								<span class="bold f14">处理结果是:</span>
   								<span class="number-link bold f14">
   									<c:choose>
   										<c:when test="${item.credit == 1 && item.isFixed == 1}">投诉成立</c:when>
   										<c:when test="${item.credit == 0 && item.isFixed == 1}">投诉不成立</c:when>
   										<c:when test="${item.credit == 0 && item.isFixed == 0}">待处理</c:when>
   										<c:when test="${item.credit == -1}">-</c:when>
   									</c:choose>
   								</span>
   							</dt>
   							<dd>投诉内容: ${item.review}</dd>
   							<dd>[投诉时间: ${item.createTime}][来自IP: ${item.ip}]</dd>
   							<dd>
   								<c:if test="item.product.state == 1">产品状态: <b>正常</b></c:if>
   								<c:if test="item.product.state == 0">产品状态: <b>已下架</b></c:if>
   								<c:if test="item.product.state == -1">产品状态: <b>已删除</b></c:if>
   							</dd>
   						</dl>
     					<em class="prices f18">&yen;${item.product.price}</em>
     				</li>
     			</c:forEach>
     		</ul>
     	</c:if>
    	</c:if>
    </div>
  </div>
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  
</body>
</html>