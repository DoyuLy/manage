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
        <h4 class="text-center text-primary">监测站管理</h4>
        <hr />
        <div class="row">
            <div class="col-md-2">
                <div class="list-group">
                    <a href="#" class="list-group-item">绵竹金花文河村</a> <a
                        href="#" class="list-group-item"> 中江永兴响滩子水库
                    </a> <a href="#" class="list-group-item"> 旌阳八角 </a> <a
                        href="#" class="list-group-item"> 广汉松林 </a> <a
                        href="#" class="list-group-item active"> 什邡莹华 </a> <a
                        href="#" class="list-group-item"> 什邡洛水 </a> <a
                        href="#" class="list-group-item"> 中江双河口 </a> <a
                        href="#" class="list-group-item"> 中江集风 </a> <a
                        href="#" class="list-group-item"> 广汉南丰 </a> <a
                        href="#" class="list-group-item"> 广汉连山 </a> <a
                        href="#" class="list-group-item"> 旌阳风光 </a> <a
                        href="#" class="list-group-item"> 旌阳新中 </a> <a
                        href="#" class="list-group-item"> 旌阳孝泉 </a> <a
                        href="#" class="list-group-item"> 绵竹遵道 </a> <a
                        href="#" class="list-group-item"> 什邡隐峰 </a> <a
                        href="#" class="list-group-item"> 罗江鄢家 </a> <a
                        href="#" class="list-group-item"> 旌阳通江 </a> <a
                        href="#" class="list-group-item"> 广汉滴水岸 </a> <a
                        href="#" class="list-group-item"> 旌阳东山 </a> <a
                        href="#" class="list-group-item"> 什邡八角 </a> <a
                        href="#" class="list-group-item"> 中江黄鹿 </a> <a
                        href="#" class="list-group-item"> 中江龙台 </a> <a
                        href="#" class="list-group-item"> 中江仓山 </a> <a
                        href="#" class="list-group-item"> 中江石泉 </a> <a
                        href="#" class="list-group-item"> 罗江新盛 </a> <a
                        href="#" class="list-group-item"> 罗江略坪 </a> <a
                        href="#" class="list-group-item"> 广汉高坪 </a> <a
                        href="#" class="list-group-item"> 旌阳天元 </a> <a
                        href="#" class="list-group-item"> 中江辑庆 </a> <a
                        href="#" class="list-group-item"> 什邡双盛 </a> <a
                        href="#" class="list-group-item"> 什邡灵杰 </a> <a
                        href="#" class="list-group-item"> 绵竹绵远 </a> <a
                        href="#" class="list-group-item"> 绵竹清道 </a> <a
                        href="#" class="list-group-item"> 中江清河 </a> <a
                        href="#" class="list-group-item"> 中江永太 </a> <a
                        href="#" class="list-group-item"> 中江冯店 </a> <a
                        href="#" class="list-group-item"> 广汉三星 </a> <a
                        href="#" class="list-group-item"> 绵竹广济镇 </a> <a
                        href="#" class="list-group-item"> 绵竹天池楠木沟 </a> <a
                        href="#" class="list-group-item"> 绵竹观鱼 </a> <a
                        href="#" class="list-group-item"> 旌阳秦宓村 </a> <a
                        href="#" class="list-group-item"> 绵竹孝德 </a> <a
                        href="#" class="list-group-item"> 绵竹拱星 </a> <a
                        href="#" class="list-group-item"> 绵竹九龙白水河 </a> <a
                        href="#" class="list-group-item"> 绵竹老熊沟 </a> <a
                        href="#" class="list-group-item"> 绵竹土门 </a> <a
                        href="#" class="list-group-item"> 绵竹清平圆包村 </a> <a
                        href="#" class="list-group-item"> 绵竹汉旺 </a> <a
                        href="#" class="list-group-item"> 什邡马祖 </a> <a
                        href="#" class="list-group-item"> 什邡湔氐 </a> <a
                        href="#" class="list-group-item"> 什邡红白 </a> <a
                        href="#" class="list-group-item"> 什邡师古 </a> <a
                        href="#" class="list-group-item"> 什邡禾丰 </a> <a
                        href="#" class="list-group-item"> 什邡马井 </a> <a
                        href="#" class="list-group-item"> 什邡皂角镇古蔺村 </a>
                    <a href="#" class="list-group-item"> 广汉和兴 </a> <a
                        href="#" class="list-group-item"> 广汉小汉 </a> <a
                        href="#" class="list-group-item"> 广汉雒城 </a> <a
                        href="#" class="list-group-item"> 旌阳开发区 </a> <a
                        href="#" class="list-group-item"> 罗江白马关 </a> <a
                        href="#" class="list-group-item"> 罗江金山 </a> <a
                        href="#" class="list-group-item"> 中江和兴 </a> <a
                        href="#" class="list-group-item"> 中江广福 </a> <a
                        href="#" class="list-group-item"> 中江永兴 </a> <a
                        href="#" class="list-group-item"> 中江柏树 </a> <a
                        href="#" class="list-group-item"> 中江积金 </a> <a
                        href="#" class="list-group-item"> 中江继光 </a> <a
                        href="#" class="list-group-item"> 中江回龙 </a> <a
                        href="#" class="list-group-item"> 中江富兴 </a> <a
                        href="#" class="list-group-item"> 中江通济 </a> <a
                        href="#" class="list-group-item"> 中江普兴 </a> <a
                        href="#" class="list-group-item"> 中江元兴 </a> <a
                        href="#" class="list-group-item"> 中江万福 </a> <a
                        href="#" class="list-group-item"> 中江太安 </a> <a
                        href="#" class="list-group-item"> 中江永安 </a> <a
                        href="#" class="list-group-item"> 中江瓦店 </a> <a
                        href="#" class="list-group-item"> 旌阳区黄许 </a> <a
                        href="#" class="list-group-item"> 局大院 </a>
                </div>
            </div>
            <div class="col-md-10">
                <div class="panel panel-default contentPanel">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">所属地区</span>
                                    <input type="text"
                                        class="form-control" value="什邡"></input>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">区站号</span>
                                    <input type="text"
                                        class="form-control" value="S1906"></input>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">名称</span>
                                    <input type="text"
                                        class="form-control" value="什邡莹华"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">建站时间</span>
                                    <input type="text"
                                        class="form-control" value="2001-09-22"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-4">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">经度</span>
                                    <input type="text"
                                        class="form-control" value="1040018"/>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">纬度</span>
                                    <input type="text"
                                        class="form-control" value="311911"/>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">海拔高度</span>
                                    <input type="text"
                                        class="form-control" value="781"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">观测要素</span>
                                    <input type="text"
                                        class="form-control" value="温度、雨量"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">是否考核</span>
                                    <input type="text"
                                        class="form-control" value="否"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">通信电话号码</span>
                                    <input type="text"
                                        class="form-control" value="13980110986"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">主要号码</span>
                                    <input type="text"
                                        class="form-control" value=""/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">联通号码</span>
                                    <input type="text"
                                        class="form-control" value=""/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">电信号码</span>
                                    <input type="text"
                                        class="form-control" value=""/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon">备注</span>
                                    <input type="text"
                                        class="form-control" value=""/>
                                </div>
                            </div>
                        </div>
                        <hr/>
                        
                        <div class="row">
                            <div class="col-md-6 text-left">
                                <button class="btn btn-info"><i class="fa fa-plus"></i> 添加一个监测站</button>
                                <button class="btn btn-info"><i class="fa fa-save"></i> 保存</button>
                            </div>
                            <div class="col-md-6 text-right">
                                <button class="btn btn-danger"><i class="fa fa-trash"></i> 删除</button>
                            </div>
                        </div>




                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../common/footer.jsp"%>
    <%@include file="../common/import-js.jspf"%>
</body>
</html>