<%@ tag import="com.go2plus.core.common.enums.ModelType" %>
<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="modelType" type="java.lang.String" required="true" description="模特类型" %>
<%
try{
	ModelType type = ModelType.valueOf(modelType);
	if(type == ModelType.parttime){
	  out.print("<span class=\'btn btn-warning btn-xs\' style='line-height:1.0;'>"+type.getInfo()+"</span>");
	}
	else{
	  out.print("<span class=\'btn btn-info btn-xs\' style='line-height:1.0;'>"+type.getInfo()+"</span>");
	}
	
}catch (Exception e){
  	out.print("<span class=\'btn btn-danger btn-xs\' style='line-height:1.0;'>错误</span>");
}
%>