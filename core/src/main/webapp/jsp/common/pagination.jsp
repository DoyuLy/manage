<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<nav class="page-box">
  <ul class="pagination pull-left">
    <c:if test="${paginationData.prePage>0 }">
      <li><a pn="${paginationData.prePage}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
    </c:if>
    <c:if test="${paginationData.prePage<=0 }">
      <li class="disabled"><a aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
    </c:if>
    <c:forEach var="pageNum" items="${paginationData.navigatepageNums }">
      <c:if test="${pageNum==paginationData.pageNum }">
        <li class="page-active"><a href="#">${pageNum }</a></li>
      </c:if>
      <c:if test="${pageNum!=paginationData.pageNum }">
        <li><a pn="${pageNum }">${pageNum }</a></li>
      </c:if>
    </c:forEach>
    <c:if test="${paginationData.nextPage>0 }">
      <li><a pn="${paginationData.nextPage}" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
    </c:if>
    <c:if test="${paginationData.nextPage<=0 }">
      <li class="disabled"><a aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
    </c:if>
  </ul>
  <div class="input-group pull-left">
    <span class="input-group-btn">
      <button id="pageNumForJumpBtn" style="font-size: 12px" class="btn btn-default" type="button">前往</button>
    </span> <input id="pageNumForJump" type="text" class="form-control"
      placeholder="共 ${paginationData.pages} 页">
  </div>

  <div id="pageSizeChooser" class="dropup pull-left">
    <button class="now-number pull-left" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
      aria-expanded="false" style="font-size: 12px">
      
    </button>
    <ul class="dropdown-menu pull-left" aria-labelledby="dropdownMenu2">
      <li><a s="20">20条</a></li>
      <li><a s="50">50条</a></li>
      <li><a s="100">100条</a></li>
      <li><a s="200">200条</a></li>
    </ul>
  </div>
</nav>
