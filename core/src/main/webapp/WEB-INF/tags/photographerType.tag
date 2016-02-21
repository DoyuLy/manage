<%@ tag import="com.go2plus.core.common.enums.PhotographerType" %>
<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="photographerType" type="java.lang.String" required="true" description="模特类型" %>
<%
try{
  PhotographerType type = PhotographerType.valueOf(photographerType);
	if(type == PhotographerType.person){
	  out.print("<span class=\'btn btn-warning btn-xs\' style='line-height:1.0;'>"+type.getInfo()+"</span>");
	}
	else{
	  out.print("<span class=\'btn btn-info btn-xs\' style='line-height:1.0;'>"+type.getInfo()+"</span>");
	}
	
}catch (Exception e){
  	out.print("<span class=\'btn btn-danger btn-xs\' style='line-height:1.0;'>错误</span>");
}
%>