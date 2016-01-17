<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->

<!-- 页面标题==========================================-->
<title>首页</title>

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
  <div class="content text-center">
    <h3 style="margin: 130px auto 0 auto">开发阶段模拟用户登录, 请选择登录用户:</h3>
    <div id="loginBtn" class="btn-group btn-group-lg" style="margin: 50px auto 200px auto" role="group">
      <button class="btn btn-default" userId="51" utype="1">1B用户</button>
      <button class="btn btn-default" userId="6937" utype="0">2B用户</button>
      <button class="btn btn-default" userId="" utype="3">代发商用户</button>
      <button class="btn btn-default" userId="" utype="2">摄影机构用户</button>
    </div>
  </div>

  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>

  <!-- 私有js==========================================-->
  <script>
      $(function() {
        $('#loginBtn>button').click(function() {
          window.location.href = "/signIn?userId=" + $(this).attr('userId')+"&userType="+$(this).attr('utype');
        });

      });
    </script>
</body>
</html>