<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css"/>
<link rel="stylesheet" href="/css/userCenter/supplier/mobile.css"/>

<!-- 页面标题==========================================-->
<title>用户中心-登记手机</title>

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
      <form:form modelAttribute="userForm" action="/userCenter/supplier/mobile" method="POST" commandName="userForm">
        <p class="mobile-title bold">手机号码</p>
        <div><form:input class="input" path="mobile" /><span class="tip-in">输入登记手机</span></div>
        <div><form:input path="id" type="hidden"/></div>
        <input type="submit" class="sub-btn" value="确定并提交表单"/>
      </form:form>
    </div>
  </div>
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  
</body>
</html>