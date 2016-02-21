<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag import="java.util.Date"%>
<%@ tag import="org.apache.commons.lang3.StringUtils"%>
<%@ tag import="java.text.SimpleDateFormat"%>
<%@ attribute name="date"  required="true"  type="java.util.Date" description="日期字符串"%>
<%@ attribute name="formatStr"  required="false"  type="java.lang.String" description="日期格式"%>
<%
	if(date == null) {
	    return ;
	}
	if(StringUtils.isEmpty(formatStr))
	{
	  formatStr="yyyy-MM-dd HH:mm:ss";
	}
	SimpleDateFormat format=new SimpleDateFormat(formatStr);
	String result=format.format(date);
 	out.write(result);
%>
