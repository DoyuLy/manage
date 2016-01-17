<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="../common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="description"
  content="" />
<meta name="keywords"
  content="" />
<meta name="author" content="Freeman" />

<title>_________________</title>
<%@include file="../common/import-css.jspf"%>
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

  <!-- 导航
    ==========================================-->
  <%@include file="../common/nav.jsp"%>
  <div class="pt-triggers">
    <button id="iterateEffects" class="pt-touch-button">显示下一页切换</button>
    <div id="dl-menu" class="dl-menuwrapper">
      <button class="dl-trigger">选择切换效果</button>
      
      <div class="footer-banner"
        style="position: absolute; bottom: -350px; left: -200px; width: 728px; margin: 30px auto"></div>
    </div>
    <!-- /dl-menu-wrapper-->
  </div>
  <div id="pt-main" class="pt-perspective">
    <div class="pt-page pt-page-1">
      <h4>
        <span>A collection of</span>页面切换效果1
        
        <hr>
        <hr>
        <hr>
        <br><br><br><br>
        
        
      </h4>
      
      高峰
    </div>
    <div class="pt-page pt-page-1">
      <h4>
        <span>A collection of</span>页面切换效果2
      </h4>
    </div>
    <div class="pt-page pt-page-3">
      <h4>
        <span>A collection of</span>页面切换效果3
      </h4>
    </div>
    <div class="pt-page pt-page-4">
      <h4>
        <span>A collection of</span>页面切换效果4
      </h4>
    </div>
    <div class="pt-page pt-page-5">
      <h4>
        <span>A collection of</span>页面切换效果5
      </h4>
    </div>
    <div class="pt-page pt-page-6">
      <h4>
        <span>A collection of</span>页面切换效果6
      </h4>
    </div>
  </div>
  
  

  <div class="pt-message">
    <p>亲，你的浏览器不支持 CSS 动画，请使用 Chrome,Firefox,Safari 等浏览器浏览.</p>
  </div>
  <%@include file="../common/footer.jsp"%>
  <%@include file="../common/import-js.jspf"%>
  <script src="${ctx}/resources/page-transitions/js/pagetransitions.js"></script>
  <script type="text/javascript"> </script>
</body>
</html>


