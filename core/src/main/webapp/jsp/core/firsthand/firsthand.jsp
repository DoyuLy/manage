
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/core/firsthand/firsthand.css" />

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

  <%@include file="/jsp/common/nav.jsp"%>
  <!-- 导航==========================================-->

  <!-- 二级导航==========================================-->
  <%-- <%@include file="/jsp/core/firsthand/subNav.jsp"%> --%>
  <div class="content">


    <!-------- 橱窗位 -------->
    <div class="t4">
      <ul>
        <c:forEach var="item" varStatus="status" items="${banner1}">
          <li class="pull-left"><a href="${item.link}?pos=${item.posX}" target="blank" title="${item.title}"> <img
              src="${item.image}" style="" />
          </a></li>
        </c:forEach>
      </ul>
    </div>

    <!-- classify search -->
    <div class="W sub-search mt15 clearfix">
      <div class="s_sub-design">
        <dl class="f12">
          <dt class="cf0 fw f14">款式：</dt>
          <dd>
            <a href="javascript:;">低帮鞋</a>
          </dd>
          <dd>
            <a href="javascript:;">高帮鞋</a>
          </dd>
          <dd>
            <a href="javascript:;">靴子</a>
          </dd>
          <dd>
            <a href="javascript:;">帆布鞋</a>
          </dd>
          <dd>
            <a href="javascript:;">凉鞋</a>
          </dd>
          <dd>
            <a href="javascript:;">拖鞋</a>
          </dd>
          <dd>
            <a href="javascript:;">雨鞋</a>
          </dd>
          <dd>
            <a href="javascript:;">乐福鞋</a>
          </dd>
          <dd>
            <a href="javascript:;">鱼嘴鞋</a>
          </dd>
          <dd>
            <a href="javascript:;">平底鞋</a>
          </dd>
          <dd>
            <a href="javascript:;">高跟鞋</a>
          </dd>
          <dd>
            <a href="javascript:;">休闲鞋</a>
          </dd>
          <dd class="cd0 f12">|</dd>
          <dd>
            <a href="javascript:;">秋冬新品</a>
          </dd>
          <dd>
            <a href="javascript:;">明星同款</a>
          </dd>
          <dd>
            <a href="javascript:;">高端品质</a>
          </dd>
          <dd>
            <a href="javascript:;">欧美风格</a>
          </dd>
          <dd>
            <a href="javascript:;">日韩风格</a>
          </dd>
          <dd>
            <a href="javascript:;">高街复古</a>
          </dd>
        </dl>
      </div>
      <%@include file="/jsp/common/propStatic.html"%>
    </div>
    <!-- End classify search -->

    <!--<div class="Attrback">
	  <div class="Attribute">
	    <div class="attrchoose"></div>
	    <div class="hotsearch">
	      <p class="attrtitle">热搜</p>
	        <a href="/search/firsthand-{$cat}-短靴--1-0?w=1&pos=A6-1" class="hotlink">短靴</a>
	        <a href="/search/firsthand-{$cat}-单鞋--1-0" class="hotlink">单鞋</a>
	        <a href="/search/firsthand-{$cat}-马丁靴--1-0" class="hotlink">马丁靴</a>
	        <a href="/search/firsthand-{$cat}-秋冬新品--1-0" class="hotlink">秋冬新品</a>
	        <a href="/search/firsthand-{$cat}-乐福鞋--1-0" class="hotlink">乐福鞋</a>
	        <a href="/search/firsthand-{$cat}-真皮--1-0" class="hotlink">真皮</a>
	        <a href="/search/firsthand-{$cat}-雪地靴--1-0" class="hotlink">雪地靴</a>
	        <a href="/search/firsthand-{$cat}-过膝长靴--1-0" class="hotlink">过膝长靴</a>
	        <a href="/search/firsthand-{$cat}-大货--1-0" class="hotlink">大货</a>
	        <a href="/search/firsthand-{$cat}-内增高--1-0" class="hotlink">内增高</a>
	    </div>
	
	    <div class="rank">
	      <a href="#" class="" onclick="rankin(0)">
	        综合
	      </a>
	      <a href="#" class="" onclick="rankin(1)">
	        新品
	      </a>
	      <a href="#" class="" onclick="rankin(2)">
	        <p>发布</p>
	      </a>
	      <a href="#" class="" onclick="rankin(3)">
	        <p>下载</p>
	      </a>
	      <a href="#" class="" onclick="rankin(4)">
	        <p>人气</p>
	      </a>
	      <a href="#" class="" onclick="">
	        <p>价格</p>
	      </a>
	    </div>
	    
	  </div>
	</div>-->

    <!--------- 列表  --------->
    <c:if test="${cthPromotions != null}">
    	<div class=pro-show>
        <c:forEach var="item" items="${cthPromotions}" varStatus="status">
          <div class="list <c:if test='${((status.index + 1) mod 5) eq 0 }'>list-end</c:if>">
            <a class="pro-img" href="/product/${item.id}" target="_blank"> <img class="lazy"
              src="http://thumb.ximgs.net${fn:substringBefore(item.indexImage, '.')}_160x160.jpg"
              alt="${item.supplier.title}&${item.articleNumber}" width="160" height="160" />
            </a>
            <ul>
              <li class="list01 fy18 bold ${item.id}_p">&yen;${item.price}.00</li>
              <li class="list02 fy12 clear ${item.id}_c" style="font-size: 12px;"><c:if test="${item.characters != null}">${item.characters}</c:if></li>
              <li class="list03"><a class="art-no" href="/product/${item.id }" target="_blank"
                title="${item.supplier.title}&amp;${item.articleNumber}"> <span class="factory">${item.supplier.title}</span> <span
                  class="pro-number">${item.articleNumber}</span>
              </a>
                <div class="auth-icon pull-right">
                  <img alt="" src="/img/common/pho_i.png"> <img alt="" src="/img/common/qua_i.png"> <img alt=""
                    src="/img/common/fac_i.png">
                </div></li>
            </ul>
          </div>
        </c:forEach>
      </div>
    </c:if>

    <%@include file="/jsp/common/pagination.jsp"%>
  </div>
  <%@include file="/jsp/common/footer.jsp"%>


</body>
</html>
