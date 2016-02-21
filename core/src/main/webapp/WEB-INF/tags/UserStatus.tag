<%@ tag import="com.go2plus.core.common.enums.UserStatus" %>
<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="status" type="java.lang.String" required="true" description="状态" %>
<%
try{
	UserStatus s = UserStatus.valueOf(status);
	if(s == (UserStatus.normal)){
	  out.print("<span class=\'btn btn-info btn-xs\' style='line-height:1.0;'>"+s.getInfo()+"</span>");
	}else{
	  out.print("<span class=\'btn btn-warning btn-xs\' style='line-height:1.0;'>"+s.getInfo()+"</span>");
	}
	
}catch (Exception e){
    out.print("<span class=\'btn btn-danger btn-xs\' style='line-height:1.0;'>错误</span>");
}
%>
