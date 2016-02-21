<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>
<pho:contentHeader/>
<div class="panel">
    <br/>
    <pho:showMessage errorMessage="${error.message}"/>
    <c:set var="stackTrace" value="${error.stackTrace}"/>
    <%@include file="exceptionDetails.jsp"%>
</div>
<pho:contentFooter/>
