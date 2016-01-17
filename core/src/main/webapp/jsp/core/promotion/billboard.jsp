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
<title>供应商排行榜</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/css.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/common.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/prompt.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/billboard.css"/>
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
<div id='emergency_ad' style="display:none;"></div>
<div id="sitetop">
  <%@include file="/jsp/common/sidebar.jsp"%>
</div>
<div id="sitebody">
    <div id="mbox_left">
      <ul id="ml_menu">        
      <li><a href="/promotion/index">一手货源广告</a></li>     
      <li><a href="/promotion/uclist">用户中心广告</a></li>                  
      <li><a href="/promotion/searchResult">搜索结果广告</a></li>                  
      <li><a href="/promotion/marketBusiness">市场商家广告</a></li>                  
      <li><a href="/promotion/myPromotion">我订购的广告</a></li>    
      <li class="mlm_select"><a href="/promotion/billboard">供应商排名榜</a></li>
      <li><a id="qq_link" target="_blank" style="font-size:14px;color:#999;" href="#">帮助:<img style="margin-left:5px;cursor:pointer" class="qq" src="http://test.go2.cn/images/qq_buttom.png"></a></li>
    </ul>
    </div>
    <div id="mbox_center">
            <table class="table">
               <tr>
				<th style="height: 50px; line-height: 100%;"><c:choose>
						<c:when test="${!empty supplierRank}">
							您的排名为：第 <font color=red>${supplierRank.rank}</font> 名，您的评分为：<font
								color=red>${supplierRank.score}</font>
						分(<a href="${ctx}/promotion/scoredetail">详情</a>)，对应级别为&nbsp;<img src="${ctx}/img/slevel/s_${supplierLevel}.gif" />
						</c:when>
						<c:otherwise>
							<p>目前您还没有您的积分记录!</p>
						</c:otherwise>
					</c:choose></th>
			</tr>
            </table>
            <c:choose>
        <c:when test="${!empty msg}">
            <table class="table">
                <tr>
                    <th style="height: 100px;line-height: 200%;">
                        <p>{$msg}</p></th>
                </tr>
            </table>
       </c:when>
			<c:otherwise>
        <table  width="100%" class="billboard">
            <thead>
                <tr>
                    <th colspan="10" style="font-size: 32px;height:60px;color:yellow">购途供应商TOP500</th>
                </tr>
            </thead>
            <tr align="center">
                <th width="70">排名</th>
                <th>供应商</th>                
        				<th width="100">评分</th>
        				<th width="200">评级</th>				
            </tr>
        <tbody>
            <c:forEach items="${supplierRanks}" var="sr" varStatus="status">
							<c:if test="${status.count%2 == 0}"><tr class="even"></c:if>
              <c:if test="${status.count%2 != 0}"><tr class="odd"></c:if>
								<td align="center">#${sr.rank}.</td>
								<td align="center">*****</td>
								<td align="center">${sr.score}</td>
								<td align="center"><img src="${ctx}/img/slevel/s_${levels[status.index]}.gif" /></td>
							</tr>
						</c:forEach>
        </tbody>
        </table>
        </c:otherwise>
    </c:choose>
    </div>
</div>

	<!-- 页脚==========================================-->
	<%@include file="/jsp/common/footer.jsp"%>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-ui.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-message.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/countdown.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/public/public.js"></script>
	<!-- 私有js==========================================-->

</body>
</html>