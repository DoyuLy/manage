<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->

<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />
<link rel="stylesheet" href="/css/userCenter/seller/myInfo.css" />

<!-- 页面标题==========================================-->
<title>用户中心-修改资料</title>

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

      <form:form modelAttribute="userForm" action="/userCenter/seller/myInfo" method="POST" commandName="userForm">
        <p class="nowrite">
          <label class="f16 bold">登录用户名<em>不能修改</em></label> <span>seekos</span>
        </p>
        <p>
          <label class="f16 bold">店铺网址</label> <span><form:input path="shopUrl" /></span><span
            class="stau1">输入店铺地址</span>
        </p>
        <p>
          <label class="f16 bold">真实姓名</label> <span><form:input path="title" /></span><span class="stau1">输入真实姓名</span>
        </p>
        <p>
          <label class="f16 bold">备用联系电话</label> <span><form:input path="phone" /></span><span
            class="stau1">输入备用联系电话</span>
        </p>
        <p>
          <label class="f16 bold">QQ号码<em>请填写你的常用QQ号码！</em></label> <span><form:input path="qq" /></span><span
            class="stau1">输入qq号</span>
        </p>
        <p style="border-bottom: 1px solid #C0C0C0;">
          <label class="f16 bold">邮箱地址<em>请输入您的常用邮箱地址！</em></label> <span><form:input path="email" /></span><span class="stau1">输入邮箱</span>
        </p>
        <p><form:input path="userId" type="hidden"/></p>
        <p>
         <span> <input type="submit" class="sub-btn" value="确认并提交表单" />
          </span>
        </p>
      </form:form>
    </div>
  </div>

  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>

  <!-- 私有js==========================================-->

</body>
</html>