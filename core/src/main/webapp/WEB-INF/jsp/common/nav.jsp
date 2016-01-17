<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<style>
.subMenu { /*   position:absolute; */
  overflow: hidden;
  padding-left: 20px;
  display: none;
  list-style: none;
}
</style>
<!-- CTX ${ctx} -->
<div class="container">
  <div class="navbar-header">
  	<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">QQ交谈</button>
    <a class="navbar-brand" href="${ctx }/">建议意见</a>
    <div>账户名</div>
    <a class="navbar-brand" href="${ctx }/">退出</a>
  </div>
  <div class="collapse navbar-collapse" role="navigation" id="bs-example-navbar-collapse-1">
    <ul id="mainMenu" class="nav navbar-nav ">
      <li class="liItem"><a href="${ctx } " class="page-scroll">首页</a></li>
      <li class="liItem"><a href="${ctx }/checkpoint/index" class="page-scroll">独家</a></li>
      <li class="liItem"><a href="${ctx }/module/index" class="page-scroll">一手货源</a></li>
      <li class="liItem"><a href="${ctx }/inventory/index" class="page-scroll">聚潮货</a></li>
      <li class="liItem"><a href="${ctx }/" class="page-scroll">认证厂商</a></li>
      <li class="liItem"><a href="${ctx }/" class="page-scroll">厂商直供</a></li>
      <li class="liItem"><a href="${ctx }/" class="page-scroll">一件代发</a></li>
      <li class="liItem"><a href="${ctx }/" class="page-scroll">摄影服务</a></li>
      <li class="liItem"><a href="${ctx }/" class="page-scroll">购商学院</a></li>
    </ul>
  </div>
</div>