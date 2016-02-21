<%@ tag import="com.go2plus.core.common.enums.DepositType" %>
<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="depositType" type="java.lang.String" required="true" description="保证金类型" %>
<%
try{
  DepositType type = DepositType.valueOf(depositType);
	if(type == DepositType.apply){
	  out.print("<span class=\'btn btn-warning btn-xs\' style='line-height:1.0;'>"+type.getInfo()+"</span>");
	}
	else{
	  out.print("<span class=\'btn btn-info btn-xs\' style='line-height:1.0;'>"+type.getInfo()+"</span>");
	}
	
}catch (Exception e){
  	out.print("<span class=\'btn btn-danger btn-xs\' style='line-height:1.0;'>错误的类型</span>");
}
%>