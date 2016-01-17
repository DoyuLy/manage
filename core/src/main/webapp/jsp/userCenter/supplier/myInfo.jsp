<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css"/>
<link rel="stylesheet" href="/css/userCenter/supplier/myInfo.css"/>

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
	<%@include file="/jsp/userCenter/supplier/subNav.jsp"%>
    <div id="mbox_right" class="right-con">
      <form:form modelAttribute="supplierForm" action="/userCenter/supplier/myInfo" method="POST" commandName="supplierForm">
        <p class="nowrite">
          <label class="f16 bold">登录用户名<em class="normal f12">不能修改</em></label> <span class="fy20 bold c-ff6c00">www.go2.cn</span>
        </p>
        <p class="nowrite">
                <label class="f16 bold">网站访问网址<em class="normal f12">不能修改</em></label>
                <span class="fy20 bold c-ff6c00">http://ssssss.go2.cn</span>
        </p>
        <p>
          <label class="f16 bold">厂名</label>
          <span><form:input path="title" /></span><span class="stau1" id="checkspan">输入厂名</span>
        </p>
        <p> 
          <label class="f16 bold">品牌<em>请勿在品牌中包含“真皮”、“鞋业”、“女鞋”、“金花”、“西河”等字样</em></label>
          <span><form:input path="brand" /></span><span class="stau1" id="brandspan">输入品牌</span>
        </p>  
        <p> 
          <label class="f16 bold">联系人</label>
          <span><form:input path="contact" /></span><span class="stau1">输入联系人</span>
        </p>      
        <p> 
          <label class="f16 bold">备用联系电话</label>
          <span><form:input path="phone" /></span><span class="stau1">输入备用联系电话</span>
        </p>
        <p> 
          <label class="f16 bold">QQ号码<em>请填写你的常用QQ号码！</em></label>
          <span><form:input path="qq" /></span><span class="stau1">输入qq</span>
        </p>       
        <p style="border-bottom:1px solid #C0C0C0;">
          <label class="f16 bold">门市地址<em></em></label>
          <span><form:input path="address" /></span><span class="stau1">输入门市地址</span>
        </p>     
        <div><form:input path="userId" type="hidden"/></div>
        <p> 
          <span>
            <input type="submit" class="sub-btn" value="确认并提交表单" />
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