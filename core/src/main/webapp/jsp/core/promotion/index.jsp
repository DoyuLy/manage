<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<%-- 不忽略EL表达式 --%>
<%@page isELIgnored="false"%>
<%-- 核心标签 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 国际化标签 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- 常用函数标签 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext['request'].contextPath}" />
<c:set var="SELF_DELETE_PROMOTION_TIMELIMIT" value="1800" />
<!-- 私有样式==========================================-->

<!-- 页面标题==========================================-->
<title>一手货源广告</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/css.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/prompt.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/index.css" />
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
  <div id='emergency_ad' style="display: none;"></div>
  <div id="sitetop">
    <%@include file="/jsp/common/sidebar.jsp"%>
  </div>
  <div id="sitebody">
    <div id="mbox_left">
      <ul id="ml_menu">
        <li class="mlm_select"><a href="/promotion/index">一手货源广告</a></li>
        <li><a href="/promotion/uclist">用户中心广告</a></li>
        <li><a href="/promotion/searchResult">搜索结果广告</a></li>
        <li><a href="/promotion/marketBusiness">市场商家广告</a></li>
        <li><a href="/promotion/myPromotion">我订购的广告</a></li>
        <li><a href="/promotion/billboard">供应商排名榜</a></li>
        <li><a id="qq_link" target="_blank" style="font-size: 14px; color: #999;" href="#">帮助:<img
            style="margin-left: 5px; cursor: pointer" class="qq" src="http://test.go2.cn/images/qq_buttom.png"></a></li>
      </ul>
    </div>
    <div id="mbox_center">
      <c:choose>
        <c:when test="${!empty msg}">
          <table class="table">
            <tr>
              <th style="height: 100px; line-height: 200%;">
                <p>${msg}</p>
              </th>
            </tr>
          </table>
        </c:when>
        <c:otherwise>
          <table class="table" style="z-index: 1;">
            <tr>
              <th colspan="2" style="height: 50px; background: #0088E4; color: white;">Go2.CN一手货源广告</th>
            </tr>
            <tr>
              <th width="80">位置说明</th>
              <td style="text-align: left; line-height: 150%; padding: 5px 20px 5px 20px; font-size: 12px;">
                <p style="text-indent: 24px;">一手货源广告，又叫一手货源产品推荐位，是指位于网站一手货源栏目首页的前 60 个产品推广位展示 120
                  个产品。该段位广告采取轮播显示的方式，以最大限度保障每个推广产品的曝光率，理论上该位置的每个产品都有同等的推广机会。</p>
              </td>
            </tr>
            <tr>
              <th width="80">推广效果</th>
              <td style="text-align: left; line-height: 150%; padding: 5px 20px 5px 20px; font-size: 12px;"><span style="color: red">★★★★</span>
              </td>
            </tr>
            <tr>
              <th width="80">订购价格</th>
              <td style="text-align: left; line-height: 150%; padding: 5px 20px 5px 20px; font-size: 12px;"><span style="color: red">500元/7天(84小时)</span>
              </td>
            </tr>
            <tr>
              <th width="80">订购规则</th>
              <td style="text-align: left; line-height: 150%; padding: 5px 20px 5px 20px; font-size: 12px;">
                <ol style='margin: 0px; padding: 0px 0px 0px 20px;'>
                  <li>同一厂商同一时间订购的广告段位不能超过两个</li>
                  <li>同一厂商的两个相邻广告的连续时间不能超过十天</li>
                </ol>
              </td>
            </tr>
            <tr>
              <th width="80">加分规则</th>
              <td style="text-align: left; line-height: 150%; padding: 5px 20px 5px 20px; font-size: 20px;">
                <ol style='margin: 0px; padding: 0px 0px 0px 20px;'>
                  <li><b>广告定购成功后八小时内付款每个位置加50分</b></li>
                </ol>
              </td>
            </tr>
            <tr>
              <th width="80">退订须知</th>
              <td style="text-align: left; line-height: 150%; padding: 10px 20px 10px 20px; font-size: 12px;">
                <ol style='margin: 0px; padding: 0px 0px 0px 20px;'>
                  <li>退订广告将影响到厂家评分、下次订购广告的机会和价格，以及专题活动的参与</li>
                  <li>付款后退订申请，请提前至少3天联系在线客服办理只扣分不扣款，否则扣分扣款。</li>
                  <li>在此订购的广告，可在 ${SELF_DELETE_PROMOTION_TIMELIMIT/60}分钟 内到【<a href="/promotion/myPromotion">我订购的广告</a>】取消，自助取消将不影响评分
                  </li>
                  <li>厂家退订的广告将于每日下午14点整向国际商贸城认证鞋类厂家开放订购，先到先得</li>
                  <li>确定要退订相关广告位置，请联系客服办理，QQ：4006611603</li>
                </ol>
              </td>
            </tr>
          </table>
          <br>
          <c:choose>
            <c:when test="${supplier.certifiedType ne 2}">
              <table class="table table_list">
                <tr class="nohover">
                  <td align="center" style="height: 60px; background: #FFFFFF; color: blue; text-align: center">很遗憾，您当前为<font
                    color="#FFC266">初级认证</font>，不能订购广告，请加油吧。
                  </td>
                </tr>
              </table>
            </c:when>
            <c:otherwise>
              <fmt:parseDate var="time1" value="2015-05-29 14:00:00" pattern="yyyy-MM-dd HH:mm:ss" />
              <%
                SimpleDateFormat dateFormat = new SimpleDateFormat(
              									"yyyy-MM-dd HH:mm:ss");
              							long time1 = dateFormat
              									.parse("2015-05-29 14:00:00").getTime() / 1000;
              							long time2 = new Date().getTime() / 1000;
              							request.setAttribute("time", time1 - time2);
              %>
              <c:choose>
                <c:when test="${time>0}">
                  <div align="center">
                    <div style="margin: 0px; height: 120px; padding: 0px; font-size: 16px; font-family: 微软雅黑;">
                      <p style="color: red;">距2015年6月1日~2015年12月31日一手货源推荐广告位订购开始还有</p>
                      <script src="${ctx}/js/plugin/countdown.js"></script>
                      <script>
										  var myCount = new Countdown({
										    time: ${time}, 
										    width: 300, 
										    height: 60, 
										    rangeHi:"day", 
										    style: "flip", 
										    labels: {
										      font   : "微软雅黑",
										      color  : "#000000",
										      weight : "bold",
										    },  
										    onComplete: countdownComplete
										  });
										  function countdownComplete() {
										    window.location.href = "${ctx}/promotion/index";
										  }
										</script>
                    </div>
                  </div>
                </c:when>
                <c:otherwise>
                  <table class="table table_list">
                    <c:choose>
                      <c:when test="${!empty promotions}">
                        <tr>
                          <th width="40">#.</th>
                          <th width="120">开始日期</th>
                          <th width="120">结束日期</th>
                          <th width="160">价格</th>
                          <th>备注</th>
                          <th width="120">操作</th>
                        </tr>
                        <c:forEach items="${promotions}" var="hashPromotion" varStatus="status">
                          <tr class='{cycle values="odd,even"}'>
                            <td align="center">${status.index+1}.</td>
                            <td align="center"><fmt:formatDate var="startTime" value="${hashPromotion.promotion.startTime}"
                                pattern="yyyy-MM-dd" /> ${startTime}</td>
                            <td align="center"><c:set var="endTime" value="${hashPromotion.promotion.endTime}" scope="request" /> <%
   Date endTime = (Date) request
 														.getAttribute("endTime");
 												request.setAttribute(
 														"endTimeValue",
 														new Date(
 																endTime.getTime()));
 %> <fmt:formatDate var="endTimeStr" value="${endTimeValue}" pattern="yyyy-MM-dd" /> ${endTimeStr}</td>
                            <td align="center">500元/7天(84小时)</td>
                            <td align="center"><font color="blue">一手货源产品推荐位</font></td>
                            <td align="center">
                              <%
                                Calendar calendar = Calendar
                              														.getInstance();
                              												int day = calendar
                              														.get(Calendar.DAY_OF_WEEK) - 1;
                              												int hour = calendar
                              														.get(Calendar.HOUR_OF_DAY);
                              												request.setAttribute("day", day);
                              												request.setAttribute("hour",
                              														hour);
                              %> <c:choose>
                                <c:when test="${hour eq 14}">
                                  <script type="text/javascript">
			                                			document.onkeydown = function (e) {
			                                        var ev = window.event || e;
			                                        var code = ev.keyCode || ev.which;
			                                        if (code == 116) {
			                                            ev.keyCode ? ev.keyCode = 0 : ev.which = 0;
			                                            cancelBubble = true;
			                                            return false;
	    		                                        }
	    		                                    }  
				                                			function order(posX,startTime,hash){
				                                				window.open("${ctx}/promotion/toOrder?posX="+posX+"&startTime="+startTime+"&hash="+hash,"订购广告","width=800, height=400");
			                                				}	 
				                                			
			                                			</script>
                                  <%--
			                                			<a class="jwin" href="#" data-title="广告订购" data-url="/manage/promotion/order/{$promotion.pos_x}/{$promotion.start_time}/{$promotion.hash}">按此订购</a>
			                                			--%>
                                  <a class="jwin" href="javascript:void(0);"
                                    onclick="order('${hashPromotion.promotion.posX}','${startTime}','${hashPromotion.hash}');">订购</a>
                                </c:when>
                                <c:when test="${hour lt 14}">
			                                			今日14点开放
			                                		</c:when>
                                <c:when test="${hour gt 14}">
			                                			明日14点开放
			                                		</c:when>
                                <c:otherwise>
			                     						-
			                                		</c:otherwise>
                              </c:choose>
                            </td>
                          </tr>
                        </c:forEach>
                      </c:when>
                      <c:when test="${fn:length(list) eq 60 }">
                        <tr class="nohover">
                          <td colspan="8">
                            <div style="height: 100px; padding-top: 40px;" align="center">
                              <a href="/promotion/index?t={$smarty.now|md5}" class="button">按此刷新查看其它可用位置</a>
                            </div>
                          </td>
                        </tr>
                      </c:when>
                      <c:otherwise>
                        <tr class="nohover">
                          <th colspan="8" style="height: 100px; # F7F7F7; line-height: 150%; text-align: center;">对不起，本期<b>
                              一手货源推荐广告位 </b>(截至2015-12-31)已售罄，谢谢参与。<br> 网站市场商家广告位尚有少量空余时段，如需购买请联系客服QQ 400 6611 603 办理
                          </th>
                        </tr>
                      </c:otherwise>
                    </c:choose>
                  </table>
                </c:otherwise>
              </c:choose>
            </c:otherwise>
          </c:choose>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-ui.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-message.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/countdown.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/public/public.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/promotion/index.js"></script>
</body>
</html>
