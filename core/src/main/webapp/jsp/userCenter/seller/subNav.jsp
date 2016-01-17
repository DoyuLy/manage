<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 二级导航==========================================-->
<div class="sub-nav">
	<a href="/userCenter/seller/" class="sub-link <c:if test='${subNav eq "seller" }'>sub-link-active</c:if>">用户中心首页</a>
	<a href="/userCenter/seller/picPackage" class="sub-link <c:if test='${subNav eq "index" }'>sub-link-active</c:if>">销售产品列表</a>
	<a href="/userCenter/seller/sellerBlackList" class="sub-link <c:if test='${subNav eq "sellerBlackList" }'>sub-link-active</c:if>">黑名单管理</a>
	<a href="/userCenter/seller/supplier" class="sub-link <c:if test='${subNav eq "supplier" }'>sub-link-active</c:if>">关注管理</a>
	<a href="/userCenter/seller/productNotice" class="sub-link <c:if test='${subNav eq "productNotice" }'>sub-link-active</c:if>">消息管理</a>
	<a href="/userCenter/seller/myInfo" class="sub-link <c:if test='${subNav eq "myInfo" }'>sub-link-active</c:if>">资料管理</a>
	<a href="http://df.go2.cn" class="sub-link" target="_blank">代发管理</a>
	<a href="/userCenter/seller/tools" class="sub-link <c:if test='${subNav eq "tool" }'>sub-link-active</c:if>">工具管理</a>  
</div>
<!-- 左侧导航==========================================-->
<c:choose>
	<c:when test="${subNav=='index' }">
		<div class="left-menu">
			<a class="left-link <c:if test='${page eq "index" }'>left-link-active</c:if>" href="/userCenter/seller/picPackage">图片数据包</a>
			<a class="left-link <c:if test='${page eq "taobaoItem" }'>left-link-active</c:if>" href="/userCenter/seller/taobaoItem">在淘宝的商品</a>
			<a class="left-link <c:if test='${page eq "aliItem" }'>left-link-active</c:if>" href="/userCenter/seller/aliItem">在阿里的商品</a>
			<a class="left-link <c:if test='${page eq "favorite" }'>left-link-active</c:if>" href="/userCenter/seller/favorite">APP收藏列表</a>
		</div>
	</c:when>
	<c:when test="${subNav=='sellerBlackList' }">
		<div class="left-menu">
			<a class="left-link <c:if test='${page eq "supplier" }'>left-link-active</c:if>" href="/userCenter/seller/supplier">下载过的厂家</a>
			<a class="left-link <c:if test='${page eq "sellerBlackList" }'>left-link-active</c:if>" href="/userCenter/seller/sellerBlackList">厂家黑名单</a>
		</div>
	</c:when>
	<c:when test="${subNav=='supplier' }">
		<div class="left-menu">
			<a class="left-link <c:if test='${page eq "supplier" }'>left-link-active</c:if>" href="/userCenter/seller/supplier">下载过的厂家</a>
			<a class="left-link <c:if test='${page eq "sellerBlackList" }'>left-link-active</c:if>" href="/userCenter/seller/sellerBlackList">厂家黑名单</a>
		</div>
	</c:when>
	<c:when test="${subNav=='productNotice' }">
		<div class="left-menu">
			<a class="left-link <c:if test='${page eq "productNotice" }'>left-link-active</c:if>" href="/userCenter/seller/productNotice">产品公告</a>
			<a class="left-link <c:if test='${page eq "supplierNotice" }'>left-link-active</c:if>" href="/userCenter/seller/supplierNotice">厂家公告</a>
		</div>
	</c:when>
  <c:when test="${subNav=='myInfo' }">
    <div class="left-menu">
      <a class="left-link <c:if test='${page eq "myInfo" }'>left-link-active</c:if>" href="/userCenter/seller/myInfo">资料管理</a>
      <a class="left-link <c:if test='${page eq "password" }'>left-link-active</c:if>" href="/userCenter/seller/password">修改密码</a>
      <a class="left-link <c:if test='${page eq "mobile" }'>left-link-active</c:if>" href="/userCenter/seller/mobile">登记手机</a>
      <a class="left-link <c:if test='${page eq "wireless" }'>left-link-active</c:if>" href="/userCenter/seller/taobao/wireless/">设置无线详情</a>
    </div>
  </c:when>
</c:choose>
