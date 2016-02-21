<%@tag pageEncoding="UTF-8"%>
<%@attribute name="title" type="java.lang.String" required="false" %>
<%@attribute name="index" type="java.lang.Boolean" required="false" %>
<%@attribute name="admin" type="java.lang.Boolean" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en" xmlns="http://www.w3.org/1999/html"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
<!--    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">-->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache-Control" content="no-store" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />
    <title>${title}</title>
	<link rel="icon" href="${ctx}/static/images/favicon.ico">
	<link rel="shortcut icon" href="${ctx}/static/images/favicon.ico">
    <%-- <%@include file="/WEB-INF/jsp/common/import-css.jspf"%>
    <%@include file="/WEB-INF/jsp/common/import-validation-css.jspf"%>
    <c:if test="${admin }">
    	<%@include file="/WEB-INF/jsp/common/import-admin-css.jspf"%>
    	<%@include file="/WEB-INF/jsp/common/import-datetimepiker-css.jspf"%>
    </c:if> --%>
    <script type="text/javascript">
        var currentURL = "${requestScope.currentURL}";
    </script>
</head>
<body>