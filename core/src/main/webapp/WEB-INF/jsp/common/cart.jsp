<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<style>
#cartPanel {
	z-index: 9998;
	position: fixed;
	height: 60px;
	width: 60px;
	right: 0px;
	top: 200px;
	cursor: pointer;
}

#cartSize {
	z-index: 9999;
	top: -49px;
	left: 24px;
	position: relative;
	font-family: "Arial";
	font-size: 22px;
	font-weight: 700;
	color: rgb(253, 253, 253);
}

#cartTable td,th {
	vertical-align: middle
}

#cartTable input {
	height: 20px;
	width: 20px;
}
</style>
<div id="cartPanel">
  <i class="fa fa-shopping-cart fa-4x"></i> <span id="cartSize"></span>
</div>

<div class="modal fade" id="myCart" tabindex="-1" role="dialog"
  aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog"
    style="width: 70%; margin: 100px auto 0 auto;">
    <div class="modal-content">
      <div class="modal-header">
        <h3>资源车</h3>
        <!--          2015-8-6 16:24:10 魏涛要求改成资源车 -->
      </div>
      <div class="modal-body">
        <table id="cartTable" class="table table-striped table-hover">
          <thead>
            <tr>
              <th style="width: 10%"><input type="checkbox" checked>全部</input></th>
              <th style="width: 10%">类别</th>
              <th style="width: 35%">名称</th>
              <th style="width: 10%">提供方</th>
              <th style="width: 30%">描述</th>
              <th style="width: 5%">操作</th>
            </tr>
          </thead>
          <tbody>

          </tbody>
        </table>

      </div>
      <div class="modal-footer">
        <div class="row">
          <div class="col-md-4 col-md-offset-8">
            <button id="model_submit" type="button"
              class="btn btn-success">申 请</button>
            <button id="model_cancel" type="button"
              class="btn btn-default" data-dismiss="modal">关 闭</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="${ctx }/page/common/cart.js">
  
</script>