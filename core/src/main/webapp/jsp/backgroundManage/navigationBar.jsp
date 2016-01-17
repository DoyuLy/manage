<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- 私有样式==========================================-->

<style>
.body {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 12px;
  margin: 0;
}

#main {
  height: auto;
  padding-top: 90px;
  text-align: center;
}

#fullbg {
  background-color: gray;
  left: 0;
  opacity: 0.5;
  position: absolute;
  top: 0;
  z-index: 3;
  filter: alpha(opacity =                                       50);
  -moz-opacity: 0.5;
  -khtml-opacity: 0.5;
}

#dialog {
  background-color: #fff;
  border: 5px solid rgba(0, 0, 0, 0.4);
  height: 400px;
  left: 50%;
  margin: -200px 0 0 -200px;
  padding: 1px;
  position: fixed !important; /* 浮动对话框 */
  position: absolute;
  top: 50%;
  width: 400px;
  z-index: 5;
  border-radius: 5px;
  display: none;
}

#dialog p {
  margin: 0 0 12px;
  height: 24px;
  line-height: 24px;
  background: #CCCCCC;
}

#dialog p.close {
  text-align: right;
  padding-right: 10px;
}

#dialog p.close a {
  color: #fff;
  text-decoration: none;
}
</style>

<html>
<head>
<title>导航列表</title>

</head>
<body>
  <div>
    <a href="/manage/addNavBar">添加新的导航栏</a>
  </div>
  <div>
    <table>
      <tr>
        <td>版块名</td>
        <td>导航栏域名</td>
        <td>导航栏名称</td>
        <td>导航栏权重</td>
        <td>备注</td>
        <td>创建时间</td>
        <td>修改时间</td>
        <td>删除操作</td>
        <td>修改操作</td>
      </tr>
      <c:forEach var="navigationBar" items="${ navigationBarList}">
        <tr class="nr">
          <td class="area">${navigationBar.area }</td>
          <td class="navigationSubdomain">${navigationBar.navigationSubdomain }</td>
          <td class="navigationName">${navigationBar.navigationName }</td>
          <td class="navigationWeights">${navigationBar.navigationWeights }</td>
          <td class="content">${navigationBar.content }</td>
          <td class="createTime">${navigationBar.createTime }</td>
          <td class="updateTime">${navigationBar.updateTime }</td>
          <td><a class="nav_del" href="javascript:void(0);" data-id='${navigationBar.id}'>删除</a></td>
          <td><a class="nav_update" href="javascript:void(0)" data-id='${navigationBar.id}'>修改</a></td>
        </tr>
      </c:forEach>
    </table>
  </div>

  <!-- 弹出层 -->
  <div id="main">
    <div id="fullbg"></div>
    <div id="dialog">
      <p class="close">
        <a href="" onclick="navConfigure.closeBg()">关闭</a>
      </p>
      <div id="b"></div>
      <input type="submit" id="add" value="更新" />
    </div>
  </div>

  <!--私有js  -->
  <script type="text/javascript" src="/resources/js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="/js/background/navConfigure.js"></script>
</body>
</html>