<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css"/>
<link rel="stylesheet" href="/css/userCenter/supplier/promise.css"/>

<!-- 页面标题==========================================-->
<title>用户中心-服务承诺</title>

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
      <form:form modelAttribute="pageForm" action="/userCenter/supplier/promise" method="POST" commandName="pageForm">
        <label class="pro-title f16 bold">承诺内容<em class="f12 normal">请在下面写上你的服务承诺信息。</em></label>
        <div>
          <form:textarea class="pro-con" path="content" />
        </div>
        <div><form:input path="userId" type="hidden"/></div>
        <input type="submit" class="sub-btn" value="确定并提交表单"/>
      </form:form>
    </div>

    
  </div>
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  
</body>
</html>