<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />
<link rel="stylesheet" href="/css/userCenter/seller/taobaoItem.css" />

<!-- 页面标题==========================================-->
<title>在淘宝的商品</title>

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
      <h6>
        （<span style="color: #d30000">2015</span> 年）淘宝产品 &nbsp; <em><a
          href="/manage/seller/taobao_item/1/%E7%9B%BE%E7%9A%84%E5%9B%9E%E5%BF%86">盾的回忆[9]</a></em>
      </h6>
      <form action="/api/taobao/shelfOnOffList?y=2015" method="post" id='sheiffrom'>
        <input type="hidden" name="sheifOnOrOff" id="sheifOnOrOff" value="" /> <input type="hidden" name="hiddenPage" value="1" />
        <ul class="pro-ul">
          <li id="dltitle"><strong><input type="checkbox" style="font-size: 12px;" id="select-all" /></strong> <span class="mysapn"
            style="border: none;">货物信息&nbsp;<input type="button" name="shangjia" id="shangjia" value="批量上架" />&nbsp;<input
              type="button" name="xiajia" id="xiajia" value="批量下架" /><input type="hidden" id="myref"
              value="L21hbmFnZS9zZWxsZXIvdGFvYmFvX2l0ZW0vMQ=="></span> <em>价格</em> <code>发布时间</code></li>

          <c:forEach var="taobaoItem" items="${paginationData.list}">
            <li id="iid_43481710756"><strong><input type="checkbox" class='id-checkbox' value="${taobaoItem.id }" /></strong>
              <label>
                <div>
                  <a href="/product/ogimkg.go" target="_blank"><img
                    src="http://thumb.ximgs.net${ fn:replace(taobaoItem.product.indexImage, '.', '_80x80.')}"
                    style="max-width: 80px; max-height: 80px;" /></a>
                </div>
                <dl>
                  <dt>
                    商家编码：<a href="/product/ogimkg.go" target="_blank">${taobaoItem.supplier.title }${taobaoItem.product.articleNumber }</a>&nbsp;&nbsp;淘宝编码：豪丽鞋厂-1544805&HL059
                  </dt>
                  <dd>${taobaoItem.user.mobile } / ${taobaoItem.supplier.phone } QQ：${taobaoItem.supplier.qq }</dd>
                  <dd>地址：${taobaoItem.supplier.address }</dd>
                  <dd>
                    产品状态：${taobaoItem.product.state }<strong>厂家删除了该产品</strong>
                  </dd>
                </dl>
            </label> <em>&yen;${taobaoItem.price }</em>
              <p class="time-ago">${taobaoItem.createTime }</p> <span>店铺：<a href="http://item.taobao.com/item.htm?id=43481710756"
                target="_blank">盾的回忆</a> <a class="deleteItem" href="javascript:void(0)">删除记录</a>
            </span> <span>对产品操作：<a href="/api/taobao/shelfoffone/43481710756/1?y=2015" class="taobaobtn">下架到仓库</a></span> <span><a
                href="/manage/seller/wireless/43481710756/盾的回忆/2015">生成无线详情</a></span></li>

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
      var url = "/userCenter/seller/delTaobaoItem/";
      $('.deleteItem').on('click', function() {
        if (!confirm("确定删除？")) {
          return;
        }
        var id = $(this).parents('li').find('.id-checkbox').val();
        sellerList.ids = [ id ];
        sellerList.deleteItem(url);
      });
    </script>
</body>
</html>