<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 不忽略EL表达式 --%>
<%@page isELIgnored="false"%>
<%-- 核心标签 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 国际化标签 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- 常用函数标签 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext['request'].contextPath}" />
<c:set var="SELF_DELETE_PROMOTION_TIMELIMIT" value="1800" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${ctx}/resources/js/jquery-1.11.3.min.js"></script>
<title></title>
<script type="text/javascript">
	$(function() {
		$("#form").submit(function() {
			$.ajax({
				cache : false,
				type : "POST",
				url : "${ctx}/promotion/order_uc",
				data : $("#form").serializeArray(),
				dataType : "JSON",
				async : false,
				success : function(data) {
					alert(data.msg);
					if (data.success) {
						window.close();
					}
				}
			});
			return false;
		});
	});
</script>
</head>
<body>
	<c:choose>
		<c:when test="${!empty msg}">
			<table class="table">
				<tr>
					<th style="height: 100px; line-height: 200%;">
						<p>${msg}</p>
					</th>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<form id="form">
				<input type="hidden" name="x" value="${x}"> <input
					type="hidden" name="y" value="${y}"> <input type="hidden"
					name="operator" value="${operator}"> <input type="hidden"
					name="refer" value="${refer}}"> <input type="hidden"
					name="startTime" value="${startTime}"> <input type="hidden"
					name="posX" value="${posX}"> <input type="hidden"
					name="totalFee" value="${totalFee}"> <input type="hidden"
					name="discount" value="${discount}"> <input type="hidden"
					name="hash" value="${hash}"> 您正要订购 <b>${startTime}</b>
				开始的为期 <b>7天</b> 的用户中心广告位 <b>${fn:toUpperCase(posX)}</b>，价格为 <b>${totalFee*discount}</b>
				元<br> 请输入下列公式计算的结果后继续<br> <br> <span
					style="font-size: 36px; color: red;">${x} <b>${operator}</b>
					${y} = ?
				</span> <br> <input type="text" name="result"> <input
					type="submit" value="提交 ">
			</form>
			<p>退订须知</p>
			<ol>
				<li>退订广告将影响到厂家评分、下次订购广告的机会和价格，以及专题活动的参与</li>
				<li>在此订购的广告，可在 ${SELF_DELETE_PROMOTION_TIMELIMIT/60}分钟 内到【<a
					href="/manage/promotion/myfps" target="_top">我订购的广告</a>】取消，自助取消将不影响评分
				</li>
				<li>确定要退订相关广告位置，请联系客服办理，QQ：4006611603</li>
			</ol>
		</c:otherwise>
	</c:choose>
</body>
</html>