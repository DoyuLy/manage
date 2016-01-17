<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="../common/taglibs.jspf"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<title>气象设备管理系统</title>
<%@include file="../common/import-css.jspf"%>
<link rel="stylesheet" type="text/css"
    href="${ctx}/css/inventory/style.css">
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="${ctx}/resources/js/html5shiv.min.js"></script>
      <script src="${ctx}/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

    <!-- 导航
    ==========================================-->
    <%@include file="../common/nav.jsp"%>
    <div class="container-fluid mainPage">
        <h4 class="text-center text-primary">库存管理</h4>
        <hr />
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="input-group">
                    <input type="text" class="form-control"
                        placeholder="输入备件型号" value="HY1301"> <span
                        class="input-group-btn">
                        <button class="btn btn-default" type="button">查找...</button>
                    </span>
                </div>
            </div>
        </div>
        <br />
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-4 text-right">型号 :
                            </div>
                            <div class="col-md-8 text-left">
                                HY1301</div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 text-right">名称 :
                            </div>
                            <div class="col-md-8 text-left">
                                HY1300扩展板</div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 text-right">类型 :
                            </div>
                            <div class="col-md-8 text-left">采集器</div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 text-right">厂家 :
                            </div>
                            <div class="col-md-8 text-left">华云</div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 text-right">优惠 :
                            </div>
                            <div class="col-md-8 text-left">-</div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 text-right">库存数量
                                :</div>
                            <div class="col-md-8 text-left">3</div>
                        </div>

                        <div class="row">
                            <div class="col-md-4 text-right">库存历史
                                :</div>
                            <div class="col-md-8 text-left">
                                <pre>
2015年10月01日   入库   1
2015年10月02日   入库   3
2015年10月01日   出库   1
                            </pre>
                            </div>
                        </div>
                        <hr />
                        <div class="row">
                            <div class="col-md-6  col-md-offset-3 text-center">
                                <div class="btn-group btn-group-lg"
                                    role="group" aria-label="">
                                    <button class="btn btn-success">
                                        <i class="fa fa-sign-in"></i> 入库
                                    </button>
                                    <button class="btn btn-danger">
                                        <i class="fa fa-sign-out"></i> 出库
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="height: 1000px;"></div>
    <%@include file="../common/footer.jsp"%>
    <%@include file="../common/import-js.jspf"%>
</body>
</html>