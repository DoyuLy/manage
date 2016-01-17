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

<title>气象设备管理系统</title>
<%@include file="../common/import-css.jspf"%>
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
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
    <section id="main"
        style="width:100%;height:; ">
        <div style="padding: 500px 0 300px 0; color: #ffffff;">
            <div id="tt" style="display: none">
                <h1 class="text-center" style="font-size: 75px">
                    <i class="fa fa-cloud fa-spin" style="font-size: 90px"></i>气象设备管理系统
                </h1>
                <h2 class="text-center">简单,清晰,高效...</h2>
            </div>
        </div>
    </section>
    <%@include file="../common/footer.jsp"%>
    <%@include file="../common/import-js.jspf"%>
    <script src="${ctx }/js/portal/index.js"></script>
</body>
</html>