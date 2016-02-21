<%@ tag import="com.go2plus.core.common.enums.ModelType"%>
<%@ tag pageEncoding="UTF-8"%>
<%@ attribute name="status" type="java.lang.String" required="true" description="摄影商信息状态"%>
<%
  int valuemax = 100;
  int step = 100 / 4;
  int valuenow = 0;
  if (status.charAt(0) == '1') {
    valuenow += step;
  }
  if (status.charAt(1) == '1') {
    valuenow += step;
  }
  if (status.charAt(2) == '1') {
    valuenow += step;
  }
  if (status.charAt(3) == '1') {
    valuenow += step;
  }
  out.print("<div class='progress'><div class='progress-bar progress-bar-success' role='progressbar' aria-valuenow='" + valuenow + "' "
      + "aria-valuemin='0' aria-valuemax='100' style='width: " + valuenow + "%;'><span class='sr-only'>" + valuenow
      + "% Complete</span></div></div>");
%>