<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<p>设置须知</p> 
<ol>  
    <li>正在推荐位广告投放中的产品将不能再次设置到其他广告上</li>    
    <li>设置投放中的广告产品后，网站首页有缓存，通常可能需要在6-12分钟才能生效,</li>                 
</ol>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.min.js"></script>
<script type="text/javascript">
     $(function(){
       //提交，最终验证。
        $('#mSend').click(function(){
          document.getElementById("formid").submit();
        });
     })
</script>
<form id="formid" method="post" action="/promotion/setPromotion" >  
    <label>请选择产品</label>
    <input type="hidden"  name="promotionId" value="${promotionId}">
    <select name="productId"  >
        <option value="" selected> - 请选择 - </option>
        <c:forEach items="${product}" var="p" >
          <option value="${p.id}" >${p.articleNumber}</option>
        </c:forEach>      
    </select>
    <input type="button" id="mSend" value=" 提交 ">
</form>