<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="status" type="java.lang.String" required="true" description="审核状态" %>
<%
try{
	if(status.equals("")||status==null){
	  out.print("<span class=\'btn btn-warning btn-xs\' style='line-height:1.0;'>未审核</span>");
	}
	else if(status.equals("true")){
	  out.print("<span class=\'btn btn-info btn-xs\' style='line-height:1.0;'>审核通过</span>");
	}
	else {
	  out.print("<span class=\'btn btn-danger btn-xs\' style='line-height:1.0;'>审核未通过</span>");
	}
	
}catch (Exception e){
  	out.print("<span class=\'btn btn-danger btn-xs\' style='line-height:1.0;'>错误的类型</span>");
}
%>