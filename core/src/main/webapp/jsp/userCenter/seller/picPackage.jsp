<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />
<link rel="stylesheet" href="/css/userCenter/seller/userIndex.css" />

<!-- 页面标题==========================================-->
<title>图片数据包</title>

<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.min.js"></script>
      <script src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

  <!-- 导航==========================================-->
  <%@include file="/jsp/common/nav.jsp"%>

  <!-- 内容==========================================-->
  <div class="content">

    <!-- 二级导航和左侧导航==========================================-->
    <%@include file="/jsp/userCenter/seller/subNav.jsp"%>

    <div class="right-con">
      <strong></strong>
      <h6>
        （<span style="color: #d30000">2015</span> 年）下载产品 ( 总计：${picNum } 个产品 )
      </h6>
      <ul class="pro-ul">
        <li id="dltitle"><strong><input type="checkbox" class='select-all' style="font-size: 12px;" id="checked" /></strong> <span
          class="mysapn" style="border: none;">货物信息&nbsp;<input type="button" name="delall" class="batch-del" value="批量删除" /></span> <em>价格</em>
          <code>下载时间</code></li>
        <c:forEach var="logDownload" items="${paginationData.list}">
          <li><strong><input type="checkbox" class='id-checkbox' value="${logDownload.id}" /></strong> <label>
              <div>
                <a href="/product/qiscce.go" target="_blank"> <img
                  src="http://thumb.ximgs.net${ fn:replace(logDownload.product.indexImage, '.', '_80x80.')}"
                  style="max-width: 80px; max-height: 80px;" />
                </a>
              </div>
              <dl>
                <dt>
                  商家编码：<a href="/product/qiscce.go" target="_blank">${logDownload.supplier.title}${logDownload.product.articleNumber }
                    [投诉该产品]</a>
                </dt>
                <dd>电话：${logDownload.user.mobile} / ${logDownload.supplier.phone} QQ：${logDownload.supplier.qq }</dd>
                <dd>地址：${logDownload.supplier.address }</dd>
              </dl>
          </label> <em>&yen;${logDownload.product.price }</em> <code class="time-ago">${logDownload.createTime }</code> <span><a
              class="deleteItem" href="javascript:void(0)">删除</a></span></li>
        </c:forEach>
      </ul>
      <!--------分页条-------->
      <%@include file="/jsp/common/pagination.jsp"%>
      <!--------分页条-------->


    </div>

  </div>

  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>

  <!-- 私有js==========================================-->
  <script type="text/javascript" src="/js/common/timeFunction.js"></script>
  <script type="text/javascript" src="/js/userCenter/sellerList.js"></script>
  <script type="text/javascript">
      var url = "/userCenter/seller/delLogDownload/";
      $('.deleteItem').on('click', function() {
        if (!confirm("确定删除？")) {
          return;
        }
        var id = $(this).parents('li').find('.id-checkbox').val();
        sellerList.ids = [ id ];
        sellerList.deleteItem(url);
      });

      $('.batch-del').on('click', function() {
        if (!confirm("确定批量删除？")) {
          return;
        }
        sellerList.deleteItem(url);
      })
    </script>
</body>
</html>