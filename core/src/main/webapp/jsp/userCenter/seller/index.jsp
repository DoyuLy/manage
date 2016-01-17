<%@page import="java.awt.PageAttributes"%>
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css"/>
<link rel="stylesheet" href="/css/userCenter/seller/index.css"/>
<!-- 页面标题==========================================-->
<title>用户中心-首页</title>
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.min.js"></script>
      <script src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
  <!------------- 导航 -------------->
  <%@include file="/jsp/common/nav.jsp"%>
  
  <!------------- 内容 ------------->
  <div class="content">
  	
  	<!-- 二级导航和左侧导航==========================================-->
	<%@include file="/jsp/userCenter/seller/subNav.jsp"%>
	  	<ul id="products">
	  		<c:forEach var="item" varStatus="status" items="${promotions.resultVo.result}">
	  			<li>
					<span>
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td>
								<a href="/product/${item.id}.go?_page=up" target="_blank">
								<img src="http://thumb.ximgs.net${fn:substringBefore(item.product.indexImage, '.')}_160x160.jpg" alt="${item.supplier.title}&${item.product.articleNumber}" />
								</a>
								</td>
							</tr>
						</table>
					</span>
					<strong><a href="/product/${item.id}.go?_page=up" target="_blank">${item.supplier.title}&${item.product.articleNumber}</a></strong>
					<label>${item.product.price}</label>
					<em>${item.product.characters}</em>
				</li>
	  		</c:forEach> 
	  	</ul>
	  	<div id="sitetop">
		  <dl>
		    <dd class="classselect"><a>新款推荐</a></dd>
		    <dd><a href="/firsthand/n3-1-0.go?_page=uindex">三日新款</a></dd>
		    <dd><a href="/firsthand/ds-1-0.go?_page=uindex">直销货源</a></dd>
		    <dd><a href="/firsthand/?_page=uindex">所有商品</a></dd>
		  </dl>
		</div>
		<ul id="products">
			<%-- <c:if test="recommends != null"> --%>
				<c:forEach var="item" items="${recommends.resultVo.result}" varStatus="status">
		         	<li <c:if test="item.productStats.promotionWeight == 1">class="recommend"</c:if> >
						<span>
							<table cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td><a href="/product/${item.id}.go?_page=uindex" target="_blank"><img src="http://thumb.ximgs.net${fn:substringBefore(item.indexImage, '.')}_160x160.jpg" alt="${item.supplier.title}&${item.articleNumber}" /></a></td>
								</tr>
							</table>
						</span>
						<strong>
							<a href="/product/${item.id}.go?_page=uindex" target="_blank">${item.supplier.title}&${item.articleNumber}</a>
							<c:if test="item.productStats == 1">
								<img src="/images/recomm.gif" title="推荐新款单品" align="absmiddle" />
							</c:if>
						</strong>
						<label>${item.price}</label>
						<em>${item.characters}</em>
					</li>
	         	</c:forEach>
			<%-- </c:if> --%>
		</ul>
  </div>

  <!------------- 页脚 -------------->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!------------- 私有js -------------->
</body>
</html>