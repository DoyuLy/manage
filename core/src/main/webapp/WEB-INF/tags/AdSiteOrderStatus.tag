<%@ tag import="com.go2plus.core.common.enums.AdsiteOrderStatus" %>
<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="status" type="java.lang.String" required="true" description="模特类型" %>
<%=AdsiteOrderStatus.valueOf(status).getInfo()%>