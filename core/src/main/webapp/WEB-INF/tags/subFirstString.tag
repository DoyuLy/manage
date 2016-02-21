<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag import="java.lang.String"%>
<%@ tag import="org.apache.commons.lang3.StringUtils"%>
<%@ attribute name="str"  required="true"  type="java.lang.String" description="字符串逗分隔"%>
<%
	if(StringUtils.isEmpty(str)) {
	  out.write("");
	}
	else{
	  String strs[] = str.split(",");
	  out.write(strs[0].trim());
	}
%>
