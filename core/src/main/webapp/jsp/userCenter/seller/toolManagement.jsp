<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->

<!-- 页面标题==========================================-->
<title>用户中心</title>

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
    这里是内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容


    <div id="sitebody">
      <ul class="list_wrap">
        <li>
          <p class="load_tt">购途大数据</p>
          <p class="load_icon">
            <a href="http://www.go2.cn/images/logo2.png"> <img src="/images/logo2.png" /></a>
          </p>
          <p class="load_discrip">购途大数据专业版关键词提供了海量淘宝女鞋类关键字指数，热度等数据指标，为淘宝店家提供完善的数据方向指导。</p>
          <p class="load_use">
            <span class="five_star"><img src="http://www.go2.cn/images/logo1.png" /></span> <a class="but" href="/manage/data_cube/getData">点击使用</a>
          </p>
        </li>
        <li>
          <p class="load_tt">甩手工具箱</p>
          <p class="load_icon">
            <a href="http://shuaishou.com/products/ToolBox/" target="_blank"> <img src="/images/logo1.png" /></a>
          </p>
          <p class="load_discrip">20大功能助力分销卖家赚钱，多平台任意复制，生成100%优质手机详情页，100%完整属性，跨平台智能数据转换。</p>
          <p class="load_use">
            <span class="five_star"><img src="http://www.go2.cn/images/logo3.jpg" /></span> <a class="but" href="http://shuaishou.com/products/ToolBox/"
              target="_blank">点击使用</a>
          </p>
        </li>
        <li>
          <p class="load_tt">知己知彼</p>
          <p class="load_icon">
            <a href="http://www.zhibi365.com/index.htm?fui=239407128&qudao=jiangshi&qp=go2" target="_blank"> <img
              src="/images/logo3.jpg" /></a>
          </p>
          <p class="load_discrip">信息时代最庞大的运营数据软件，实时有效监控淘宝天猫所有卖家的所有细微动态。让你坐在电脑前，将整个淘宝尽收眼底。</p>
          <p class="load_use">
            <span class="five_star"><img src="http://www.go2.cn/images/logo4.png" /></span> <a class="but"
              href="http://www.zhibi365.com/index.htm?fui=239407128&qudao=jiangshi&qp=go2" target="_blank">点击使用</a>
          </p>
        </li>
        <li>
          <p class="load_tt">淘宝发布插件</p>
          <p class="load_icon">
            <a href="https://fuwu.taobao.com/ser/detail.html?service_code=ts-18774&qq-pf-to=pcqq.c2c" target="_blank"><img
              src="/images/logo4.png" /></a>
          </p>
          <p class="load_discrip">一键发布商品到淘宝，省时省力，淘宝官方认可插件，安全可靠免费试用15天。</p>
          <p class="load_use">
            <span class="five_star"><img src="/images/five_star.png" /></span> <a class="but"
              href="https://fuwu.taobao.com/ser/detail.html?service_code=ts-18774&qq-pf-to=pcqq.c2c" target="_blank">点击使用</a>
          </p>
        </li>


      </ul>


    </div>


  </div>

  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>

  <!-- 私有js==========================================-->

</body>
</html>