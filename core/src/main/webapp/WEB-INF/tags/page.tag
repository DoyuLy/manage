<%--
 分页格式
   首页 <<   1   2   3   4   5   6   7   8   9   10  11>  >> 尾页
   首页 <<   1   2   3   4   5   6   7   8   9   ... 11  12 >  >> 尾页
   首页 <<   1   2  ...  4   5   6   7   8   9   10 ... 12  13 >  >> 尾页
   首页 <<   1   2  ...  5   6   7   8   9   10  11  12  13 >  >> 尾页
   首页 <<   1   2  ...  5   6   7   8   9   10  11  ... 13  14 >  >> 尾页
   首页 <<   1   2  ...  5   6   7   8   9   10  11  ...   21  22 >  >> 尾页

--%>
<%@tag pageEncoding="UTF-8" description="分页" %>
<%@ attribute name="page" type="com.github.pagehelper.PageInfo" required="true" description="分页" %>
<%@ attribute name="pageSize" type="java.lang.Integer" required="false" description="每页大小" %>
<%@ attribute name="simple" type="java.lang.Boolean" required="false" description="是否简单风格" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty pageSize}">
    <c:set var="pageSize" value="${paginationData.pageSize}"/>
</c:if>

<c:set var="displaySize" value="2"/>
<c:set var="current" value="${paginationData.pageNum}"/>

<c:set var="begin" value="${current - displaySize}"/>
<c:if test="${begin <= displaySize}">
    <c:set var="begin" value="${1}"/>
</c:if>
<c:set var="end" value="${current + displaySize}"/>
<c:if test="${end > paginationData.pages - displaySize}">
    <c:set var="end" value="${paginationData.pages - displaySize}"/>
</c:if>
<c:if test="${end < 0 or paginationData.pages < displaySize * 4}">
    <c:set var="end" value="${paginationData.pages}"/>
</c:if>

<div class="table-pagination form-inline <c:if test='${simple ne false}'> row tool ui-toolbar</c:if>">
<nav>

    <ul class="pagination">
        <c:choose>
            <c:when test="${paginationData.isFirstPage}">
                <li class="disabled"><a title="首页">首页</a></li>
                <li class="disabled"><a title="上一页">&lt;&lt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="#" onclick="$.table.turnPage('${pageSize}', 1, this);" title="首页">首页</a></li>
                <li><a href="#" onclick="$.table.turnPage('${pageSize}', ${current - 1}, this);" title="上一页">&lt;&lt;</a></li>
            </c:otherwise>
        </c:choose>

        <c:forEach begin="1" end="${begin == 1 ? 0 : 2}" var="i">
            <li <c:if test="${current == i}"> class="active"</c:if>>
                <a href="#" onclick="$.table.turnPage('${pageSize}', ${i}, this);" title="第${i}页">${i}</a>
            </li>
        </c:forEach>

        <c:if test="${begin > displaySize + 1}">
            <li><a>...</a></li>
        </c:if>

        <c:forEach begin="${begin}" end="${end}" var="i">
            <li <c:if test="${current == i}"> class="active"</c:if>>
                <a href="#" onclick="$.table.turnPage('${pageSize}', ${i}, this);" title="第${i}页">${i}</a>
            </li>
        </c:forEach>


        <c:if test="${end < paginationData.pages - displaySize}">
            <li><a>...</a></li>
        </c:if>

        <c:forEach begin="${end < paginationData.pages ? paginationData.pages - 1 : paginationData.pages + 1}" end="${paginationData.pages}" var="i">
            <li <c:if test="${current == i}"> class="active"</c:if>>
                <a href="#" onclick="$.table.turnPage('${pageSize}', ${i}, this);" title="第${i}页">${i}</a>
            </li>
        </c:forEach>

        <c:choose>
            <c:when test="${paginationData.isLastPage}">
                <li class="disabled"><a title="下一页">&gt;&gt;</a></li>
                <li class="disabled"><a title="尾页">尾页</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="#" onclick="$.table.turnPage('${pageSize}', ${current + 1}, this);" title="下一页">&gt;&gt;</a></li>
                <li><a href="#" onclick="$.table.turnPage('${pageSize}', ${paginationData.pages}, this);" title="尾页">尾页</a></li>
            </c:otherwise>
        </c:choose>


    </ul>
    </nav>
    <div>
        <span class="page-input">
            第&nbsp;<input type="text" class="form-control input-sm" style="width: 30px;" value="${current}" onblur="$.table.turnPage('${pageSize}', $(this).val(), this);"/>&nbsp;页
        </span>
        &nbsp;
        <select class="form-control input-sm" onchange="$.table.turnPage($(this).val(), ${current}, this);">
            <option value="10" <c:if test="${pageSize eq 10}">selected="selected" </c:if>>10</option>
            <option value="20" <c:if test="${pageSize eq 20}">selected="selected" </c:if>>20</option>
            <option value="30" <c:if test="${pageSize eq 30}">selected="selected" </c:if>>30</option>
            <option value="50" <c:if test="${pageSize eq 50}">selected="selected" </c:if>>50</option>
        </select>
        <span class="page-info">[共${paginationData.pages}页/${paginationData.total}条]</span >
    </div>
</div>
