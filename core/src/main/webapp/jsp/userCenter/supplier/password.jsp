<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css"/>
<link rel="stylesheet" href="/css/userCenter/supplier/password.css"/>

<!-- 页面标题==========================================-->
<title>用户中心-修改密码</title>

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
      <form:form modelAttribute="userForm" action="/userCenter/supplier/password" method="POST" commandName="userForm">
        <p>
          <label>原密码<em>请输入当前使用的密码！</em></label>
          <span><input type="password" name="oldpassword" size="16" maxlength="20"></span><span class="stau1">输入旧密码</span>
        </p>
        
        <p>
          <label>新密码</label>
          <span><form:input path="password" /></span>
          <span class="stau3">不能为空,6-16位之间</span>
        </p>
        
        <p>
          <label>确认新密码<em>请确认本次输入和刚刚输入的新密码相同。</em></label>
          <span><input type="password" name="password2" size="16" maxlength="20"></span><span class="stau1">确认新密码</span>
        </p> 
        
        <div><form:input path="id" type="hidden"/></div>
        <p style="color: red">${msg }</p>
        <input type="submit" class="sub-btn" value="确定并提交表单"/>
      </form:form>
    </div>
  </div>
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  
</body>
</html>