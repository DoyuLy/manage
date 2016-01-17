<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/common/wide.css" />
<link rel="stylesheet" href="/css/core/welcome/index.css" />

<!-- 页面标题==========================================-->
<title>首页</title>

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

  <%@include file="/jsp/common/nav.jsp"%>

  <div class="content">
    
    <!-------- 橱窗位 -------->
    <div class="t4">
      <ul>
        <c:forEach var="item" varStatus="status" items="${banner1}">
          <li class="pull-left">
          	<a href="${item.link}?pos=${item.posX}" target="blank" title="${item.title}">
				<img src="${item.image}" style="" />
          	</a>
          </li>
        </c:forEach>
      </ul>
    </div> 

<!-------- 产品展示 -------->
<div class="pro-show">
    <!-------- 广告列表 -------->
    <c:if test="${category == 'all'}">
    	<c:forEach var="item" items="${promotions}" varStatus="status">
    		 <div class="list <c:if test='${((status.index + 1) mod 5) eq 0 }'>list-end</c:if> <c:if test='${((status.index + 1) mod 6) eq 0 }'>list-ends</c:if>">
                <a class="pro-img" href="/product/${item.id}" target="_blank">
                  <img class="lazy" src="http://thumb.ximgs.net${fn:substringBefore(item.product.indexImage, '.')}_160x160.jpg" alt="${item.supplier.title}&${item.product.articleNumber}" width="160" height="160" />
                </a>
                <ul>
                    <li class="list01 fy18 bold ${item.id}_p">&yen;${item.product.price}.00</li>
                    <li class="list02 fy12 clear ${item.id}_c" style="font-size:12px;"><c:if test="${item.product.characters != null}">${item.product.characters}</c:if></li>
                  <li class="list03">
                    <a class="art-no" href="/product/${item.id }" target="_blank" title="${item.supplier.title}&amp;${item.product.articleNumber}">
                      <span class="factory">${item.supplier.title}</span>
                        <span class="pro-number">${item.product.articleNumber}</span>
                    </a>
                    <div class="auth-icon pull-right">
                        <img alt="" src="/img/common/pho_i.png">
                        <img alt="" src="/img/common/qua_i.png">
                        <img alt="" src="/img/common/fac_i.png">
                    </div>
                  </li> 
                </ul>
          </div>
    	</c:forEach>
    	<c:if test="${key == 4}">
    		<div class="list_ad list_end"><a href="http://search2.cn/search/firsthand-all-2015%E7%A7%8B%E5%86%AC%E6%96%B0%E6%AC%BE--1-0?w=1&pos=A6-1" target="_blank"><img src="/images/img/index_gg_01.jpg" /></a></div>
    	</c:if>
    	<c:if test="${key == 6}">
	    	<div class="list_ad"><a href="/firsthand/dc-1-0?w=5" target="_blank"><img src="/images/img/index_gg_02.jpg" /></a></div>
	    </c:if>
    </c:if>
</div>
  	
  	<c:if test="${category != 'all'}">
	 <div class="list">
        <ul>
            <li class="list01 fy14 bold">
                <a href="/product/${item.id}" target="_blank"  title="${item.supplier.title}&amp;${item.product.articleNumber}">
                    ${item.supplier.title}&amp;${item.product.articleNumber}
                </a>
            </li>
            <li>
                <a href="/product/${item.id}" target="_blank">
                    <img class="lazy" src="http://thumb.ximgs.net${fn:substringBefore(item.product.indexImage, '.')}_160x160.jpg"  data-url="http://thumb.ximgs.net${fn:substringBefore(item.product.indexImage, '.')}_160x160.jpg" alt="${item.supplier.title}&${item.product.articleNumber}" width="160" height="160" />
                </a>
            </li>
            <li class="list02 fy12 clear ${item.id}_c" style="font-size:12px;">${item.product.characters}</li>
            <li class="list03 fy18 bold ${item.id}_p">&yen;${item.product.price}.00</li>
        </ul>
     </div>
  	</c:if>
  	
  	<!--AD Banner 01-->
	<div class="banner01">
	    <div class="img-slider">
	        <ul>
	          <c:forEach var="item" items="${banner2}">
		        <li><a href="${item.link}">
		              <img src="${item.image}" title="${item.title}" alt=""/>
	            </a></li>
	          </c:forEach>
	        </ul>
	    </div>
	</div>


	<div class="pro-show">
	<c:forEach var="item" items="${selections}" varStatus="status">
		<div class="list <c:if test='${((status.index + 1) mod 5) eq 0 }'>list-end</c:if>">
				<a class="pro-img" href="/product/${item.id}" target="_blank">
                  <img class="lazy" src="http://thumb.ximgs.net${fn:substringBefore(item.product.indexImage, '.')}_160x160.jpg" alt="${item.supplier.title}&${item.product.articleNumber}" width="160" height="160" />
                </a>
                <ul>
                    <li class="list01 fy18 bold ${item.id}_p">&yen;${item.product.price}.00</li>
                    <li class="list02 fy12 clear ${item.id}_c" style="font-size:12px;"><c:if test="${item.product.characters != null}">${item.product.characters}</c:if></li>
                  <li class="list03">
                    <a class="art-no" href="/product/${item.id }" target="_blank" title="${item.supplier.title}&amp;${item.product.articleNumber}">
                      <span class="factory">${item.supplier.title}</span>
                        <span class="pro-number">${item.product.articleNumber}</span>
                    </a>
                    <div class="auth-icon pull-right">
                        <img alt="" src="/img/common/pho_i.png">
                        <img alt="" src="/img/common/qua_i.png">
                        <img alt="" src="/img/common/fac_i.png">
                    </div>
                  </li> 
				<!-- <li>
					<a href="/product/${item.id}" target="_blank">
						<img src="http://thumb.ximgs.net${fn:substringBefore(item.product.indexImage, '.')}_160x160.jpg" alt="${item.supplier.title}&amp;${item.product.articleNumber}" width="160" height="160" />
					</a>
				</li>
				<li class="list03 fy18 bold">¥${item.product.price}.00</li> -->
			</ul>
		</div>
	</c:forEach>
	</div>
	
	<%@include file="/jsp/common/pagination.jsp"%>

  <%@include file="/jsp/common/footer.jsp"%>


</body>
</html>