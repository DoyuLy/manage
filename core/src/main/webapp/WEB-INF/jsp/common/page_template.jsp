<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="../common/taglibs.jspf"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<title>_________________</title>
<%@include file="../common/import-css.jspf"%>
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="${ctx}/resources/js/modernizr.custom.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="${ctx}/resources/js/html5shiv.min.js"></script>
      <script src="${ctx}/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

  <!-- 导航
    ==========================================-->
  <%@include file="../common/nav.jsp"%>
  <h1>helloword!!!</h1>
  <div style="height: 1000px;"></div>
  <%@include file="../common/footer.jsp"%>
  <%@include file="../common/import-js.jspf"%>
</body>
</html>