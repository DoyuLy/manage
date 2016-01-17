<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />
<link rel="stylesheet" href="/css/userCenter/seller/blackList.css" />

<!-- 页面标题==========================================-->
<title>厂家黑名单</title>
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.min.js"></script>
      <script src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
  <!------------- 导航 -------------->
  <%@include file="/jsp/common/nav.jsp"%>

  <!------------- 内容 ------------->
  <div class="content">

    <!-- 二级导航和左侧导航==========================================-->
    <%@include file="/jsp/userCenter/seller/subNav.jsp"%>
    <div class="right-con">
      <strong style="display: none;"> </strong>
      <h6>
        黑名单厂家列表( 总计：${blackTotalNum}个厂家 )&nbsp;&nbsp;&nbsp; <a class="add-black" href="javascript:void(0)">增加黑名单</a>
      </h6>
      <table class="gridtable">
        <tr>
          <th>厂家</th>
          <th>电话</th>
          <th>地址</th>
          <th>操作</th>
        </tr>
        <c:forEach var="blackList" items="${paginationData.list}">
          <tr>
            <td>${blackList.supplier.title}</td>
            <td>${blackList.user.mobile}</td>
            <td>${blackList.supplier.address}</td>
            <td><a class="deleteBlack" href="javascript:void(0)" data-id="${blackList.id}">取消</a></td>
          </tr>
        </c:forEach>

      </table>
      <!--------分页条-------->
      <%@include file="/jsp/common/pagination.jsp"%>
      <!--------分页条-------->
    </div>
  </div>

  <!-- 添加黑名单弹出层 -->
  <div id="main">
    <div id="fullbg"></div>
    <div id="dialog">
      <p class="close">
        <a href="" onclick="blackListModal.closeBox()">关闭</a>
      </p>
      <div id="b"></div>
    </div>
  </div>

  <!-- 私有js -->
  <script type="text/javascript" src="/resources/js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="/js/userCenter/blackListModal.js"></script>

  <!------------- 页脚 -------------->
  <%@include file="/jsp/common/footer.jsp"%>

  <!------------- 私有js -------------->
  <script type="text/javascript">
      $('.deleteBlack').on('click', function() {
        if (!confirm("是否取消？")) {
          return;
        }

        var _this = this;
        var id = $(this).data("id");
        $.ajax({
          url : '/userCenter/seller/deleteBlackList/' + id,
          type : 'POST',
          dataType : 'json',
          data : {
            id : id
          },
          success : function(data) {
            if (data > 0) {
              $(_this).parents('tr').remove();
            }
          }
        })
      });

      //添加黑名单弹出框
      $('.add-black').on('click', function() {
        blackListModal.modal(this);
      });
    </script>
</body>
</html>