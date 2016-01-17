<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="right-con">
  <h1>选择添加黑名单原因</h1>
  <form>
    <div id="supplier">
      <h3>厂家</h3>
      <select id="supplierId">
        <c:forEach var="varSupplier" items="${blackListSupplier}">
          <option class="supplier-title" value="${varSupplier.supplierUserId}">${varSupplier.supplier.title }</option>
        </c:forEach>
      </select>
    </div>

    <div id="reason">
      <h3>原因</h3>
      <select id="comment">
        <c:forEach var="reason" items="${blackListReason}">
          <option value=${reason.title }>${reason.title }</option>
        </c:forEach>
      </select>
    </div>

    <button type="button" class="sub-btn">添加</button>
  </form>
</div>


<script type="text/javascript" src="/js/userCenter/blackListModal.js">
</script>
