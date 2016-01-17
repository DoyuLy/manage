<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<%-- 不忽略EL表达式 --%>
<%@page isELIgnored="false"%>
<%-- 核心标签 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 国际化标签 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- 常用函数标签 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext['request'].contextPath}" />
<!-- 私有样式==========================================-->

<!-- 页面标题==========================================-->
<title>积分统计详情</title>

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
	<div id="mbox_center">
        <table class="table">
            <tr>
                <td style="height: 20px;line-height: 20%;">
                    <a href="${ctx}/promotion/billboard" > 返回 </a>
                </td>
            </tr>
        </table>
        <c:choose>
			<c:when test="${!empty msg}">
			<table class="table">
            	<tr>
                <th style="height: 100px;line-height: 200%;">
                    <p>${msg}</p>
                </th>
                </tr>
            </table>
			</c:when>
			<c:otherwise>
				 <table width="100%" cellspacing="1" cellpadding="5" style="background: #DDDDDD;">
                <tr style="background: #F6F6F6">
                    <th align="center" colspan="2">积分统计详情</th>
                </tr>
                <c:set var="total_score" value="0" />
                <c:forEach items="${totalMap}" var="totalMap">
                	<tr style="background: #FFFFFF">
                    <td width="150"  align="right">${totalMap.key}</td>
                    <td><c:if test="${totalMap.value>0}">+</c:if>${totalMap.value}</td>
                    <c:set var="total_score" value="${total_score+totalMap.value}" />
                	</tr>
                </c:forEach>
                <tr style="background: #F6F6F6">
                    <td align="right">合计：</td>
                    <td>${total_score}</td>
                </tr>
            </table>
			</c:otherwise>
		</c:choose>
    </div>
    
	<!-- 页脚==========================================-->
	<%@include file="/jsp/common/footer.jsp"%>

	<!-- 私有js==========================================-->

</body>
</html>