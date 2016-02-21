<%@ tag import="com.go2plus.core.common.utils.PrettyTimeUtils" %>
<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="date" type="java.util.Date" required="true" description="时间" %>
<%
if(null == date){
  out.print("");
}
else{
  out.print(PrettyTimeUtils.prettyTime(date));
}
%>