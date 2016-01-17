<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 二级导航==========================================-->
<div class="sub-nav">
	<c:if test="${subNav eq 'index' }">
		<a href="/userCenter/supplier" class="sub-link sub-link-active">首页</a>
	</c:if>
	<c:if test="${subNav ne 'index' }">
		<a href="/userCenter/supplier" class="sub-link">首页</a>
	</c:if>
	<c:if test="${subNav eq 'product' }">
		<a href="/userCenter/supplier/productList" class="sub-link sub-link-active">我的产品</a>
	</c:if>
	<c:if test="${subNav ne 'product' }">
		<a href="/userCenter/supplier/productList" class="sub-link">我的产品</a>
	</c:if>
	<c:if test="${supplier.certifiedType > 0 && supplier.marketId > 0}" >
		<a href="/userCenter/supplier/promotionIndex" style="color:#f00;">我的广告</a>
	</c:if>
	<c:if test="${supplier.certifiedType > 0 && supplier.marketId > 0}" >
		<a href="/userCenter/supplier/specialIndex">我的活动</a>
	</c:if>
  	<c:if test="${subNav eq 'info' }">
		<a href="/userCenter/supplier/myInfo" class="sub-link sub-link-active">我的资料</a>
	</c:if>
	<c:if test="${subNav ne 'info' }">
		<a href="/userCenter/supplier/myInfo" class="sub-link">我的资料</a>
	</c:if>
	<c:if test="${subNav eq 'msg' }">
		<a href="/userCenter/supplier/myAnnounce" class="sub-link sub-link-active">我的消息</a>
	</c:if>
	<c:if test="${subNav ne 'msg' }">
		<a href="/userCenter/supplier/myAnnounce" class="sub-link">我的消息</a>
	</c:if>
	<c:if test="${subNav eq 'seller' }">
		<a href="/userCenter/supplier/vipLoad" class="sub-link sub-link-active">我的卖家</a>
	</c:if>
	<c:if test="${subNav ne 'seller' }">
		<a href="/userCenter/supplier/vipLoad" class="sub-link">我的卖家</a>
	</c:if>
	<a href="test.go2.cn" class="sub-link" target="_blank">我的网站:http://test.go2.cn</a>
</div>
<!-- 左侧导航==========================================-->
<c:choose>
	<c:when test="${subNav=='product' }">
		<div class="left-menu">
			<a class="left-link <c:if test='${page eq "productList" }'> left-link-active </c:if>" href="/userCenter/supplier/productList">产品列表</a>
			<a class="left-link <c:if test='${page eq "fastPublish" }'> left-link-active </c:if>" href="/userCenter/supplier/fastPublish">发布新产品</a>
			<a class="left-link <c:if test='${page eq "selfPublish" }'> left-link-active </c:if>" href="/userCenter/supplier/selfPublish">自助发布产品</a>
			<a class="left-link <c:if test='${page eq "complaint" }'> left-link-active </c:if>" href="/userCenter/supplier/complaint">收到的投诉</a>
	</c:when>
	<c:when test="${subNav=='info' }">
		<div class="left-menu">
			<a class="left-link <c:if test='${page eq "authenticationType" }'> left-link-active </c:if>" href="/userCenter/supplier/authenticationType">认证类型</a>
			<a class="left-link <c:if test='${page eq "myInfo" }'> left-link-active </c:if>" href="/userCenter/supplier/myInfo">修改资料</a>
			<a class="left-link <c:if test='${page eq "password" }'> left-link-active </c:if>" href="/userCenter/supplier/password">修改密码</a>
			<a class="left-link <c:if test='${page eq "promise" }'> left-link-active </c:if>" href="/userCenter/supplier/promise">服务承诺</a>
			<a class="left-link <c:if test='${page eq "mobile" }'> left-link-active </c:if>" href="/userCenter/supplier/mobile">登记手机</a>
	</c:when>
	<c:when test="${subNav=='msg' }">
		<div class="left-menu">
			<a class="left-link <c:if test='${page eq "myAnnounce" }'> left-link-active </c:if>" href="/userCenter/supplier/myAnnounce">厂家公告</a>
			<a class="left-link <c:if test='${page eq "myOperation" }'> left-link-active </c:if>" href="/userCenter/supplier/myOperation">操作日志</a>
	</c:when>
	<c:when test="${subNav=='seller' }">
		<div class="left-menu">
			<a class="left-link <c:if test='${page eq "vipLoad" }'> left-link-active </c:if>" href="/userCenter/supplier/vipLoad">会员下载统计</a>
			<a class="left-link <c:if test='${page eq "productLoad" }'> left-link-active </c:if>" href="/userCenter/supplier/productLoad">产品下载记录</a>
			<a class="left-link <c:if test='${page eq "taobaoProduct" }'> left-link-active </c:if>" href="/userCenter/supplier/taobaoProduct">淘宝产品列表</a>
	</c:when>
</c:choose>
	<c:if test="${subNav ne 'index' }">
		<div class="left-qq">
			<span>帮助:</span>
			<button class="j_qq s_chat J_ServerQQ"></button>
		</div>
	</div>
	</c:if>