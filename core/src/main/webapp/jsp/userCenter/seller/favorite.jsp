<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />
<link rel="stylesheet" href="/css/userCenter/seller/favorite.css" />

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
	<%@include file="/jsp/userCenter/seller/subNav.jsp"%>
    
    <div class="right-con">
         
		<h6>你用手机APP收藏的产品列表 ( 总计：8 个产品 )</h6>	
    	
		     <ul class="pro-ul">           
            <li id="dltitle">
               <span class="mysapn" style="border:none;">货物信息</span>
                <em>价格</em>
                <code>收藏时间</code>
            </li>
            <c:forEach var="favorite" items="${paginationData.list}">
            <li>
                <label>
                    <div><a href="/product/eqomi.go" target="_blank"><img src="http://thumb.ximgs.net${ fn:replace(favorite.product.indexImage, '.', '_80x80.')}"  style="max-width:80px;max-height:80px;" /></a></div>
                    <dl>
                        <dt>商家编码：<a href="/product/eqomi.go" target="_blank">${favorite.supplier.title }${favorite.product.articleNumber }</a></dt>
                        <dd>电话：${favorite.user.mobile } / ${favorite.supplier.phone } QQ：${favorite.supplier.qq }</dd>
                        <dd>地址：${favorite.supplier.address }</dd>
                        <dd>产品状态：${favorite.product.state }<strong>厂家删除了该产品</strong></dd>                    </dl>
                </label>
                <em>&yen;${favorite.product.price }</em>
                <p class="time-ago">${favorite.createTime }</p>
            </li>
            </c:forEach>
                       
         </ul>              
            <!--------分页条-------->
              <%@include file="/jsp/common/pagination.jsp"%>
            <!--------分页条-------->
          
                        
    </div>
    
  </div>
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  <script type="text/javascript" src="/js/common/timeFunction.js"></script>
  
</body>
</html>