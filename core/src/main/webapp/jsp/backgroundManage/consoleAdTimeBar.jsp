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
  filter: alpha(opacity =                                         50);
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
    <form action="/manage/consoleAd" method="post">
      <table>
        <tr>
          <td>起始时间</td>
          <td>结束时间</td>
          <td>广告类型</td>
        </tr>
        <tr>
          <td><input type="text" name="startTime"></td>
          <td><input type="text" name="endTime"></td>
          <td><select name="type">
              <option value=0 selected>- 请选择 -</option>
              <option value=1>一手货源</option>
              <option value=2>用户中心</option>
              <option value=3>搜索结果</option>
              <option value=4>市场商家</option>
          </select></td>
        </tr>
      </table>
    <input type="submit" value="生成广告" />
  </form>
</div>
  <!--私有js  -->
  <script type="text/javascript" src="/resources/js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="/js/background/navConfigure.js"></script>
</body>
</html>