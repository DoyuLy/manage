<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/common/sub-nav.css" />

<!-- 二级导航==========================================-->
<div class="sub-nav">
  <c:forEach var="subNav" items="${navigationBars}">
    <a href="/firsthand/${subNav.navigationSubdomain}" class="sub-link">${subNav.navigationName}</a>
  </c:forEach>
</div>
