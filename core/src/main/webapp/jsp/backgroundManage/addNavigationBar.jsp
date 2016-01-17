<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/backgroundManage/formStyle.css" />
<!--私有js  -->
<script type="text/javascript" src="/jquery/lib/jquery-1.11.3.min.js"></script>
<html>
<head>
<title>添加导航栏</title>

</head>
<body>
  <div id="div_form">

  <form id="ajax-form" action="/backgroundManage/saveNavigationBar" method="post">

    <div>
      <label for="area">板块</label> <input type="text" name="area" value="<c:if test="${area!=null}">${area}</c:if>" required>
    </div>
    <div>
      <label for="navigationSubdomain">导航栏域名</label> <input type="text" name="navigationSubdomain" value="<c:if test="${subdomain!=null}">${subdomain}</c:if>" required>
    </div>

    <div>
      <label for="navigationName">导航栏名称</label> <input class="textarea" type="text" name="navigationName" value="<c:if test="${name!=null}">${name}</c:if>" required>
    </div>

    <div>
      <label for="navigationWeights">导航栏排序权重</label> <input type="text" name="navigationWeights" value="<c:if test="${weights!=null}">${weights}</c:if>" required>
    </div>

    <div>
      <label for="content">备注</label> <input type="text" name="content" value="">
    </div>

    <div class="field">
      <button type="submit">确定</button>
    </div>
  </form>
</div>
</body>
</html>