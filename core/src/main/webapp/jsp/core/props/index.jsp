<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>

<link rel="stylesheet" href="/css/common/common.css"/>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
  <h1>props test page</h1>
  

  <c:if test="${1==1}"> 
	  <div style="width: 60%;">
	  	<%@include file="/jsp/common/propStatic.html"%>
	  </div>
  </c:if>
<button class="publishTo" data-id="168298">发布到</button>
</body>
<script src="http://static.www.net.cn/js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="/js/plugin/underscore-min.js"></script>
<script src="/js/plugin/jquery.cookie.js"></script>
<script src="/js/common/go2Action.js"></script>
</html>