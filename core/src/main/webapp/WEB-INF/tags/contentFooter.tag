<%@tag pageEncoding="UTF-8"%>
<%@attribute name="admin" type="java.lang.Boolean" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</body>
<%-- <%@include file="/WEB-INF/jsp/common/import-js.jspf"%>
<%@include file="/WEB-INF/jsp/common/import-validation-js.jspf"%>
<c:if test="${admin }">
	<%@include file="/WEB-INF/jsp/common/import-datetimepiker-js.jspf"%>
    <%@include file="/WEB-INF/jsp/common/import-nicescroll-js.jspf"%>
    <%@include file="/WEB-INF/jsp/common/import-admin-js.jspf"%>
    </c:if> --%>
</html>