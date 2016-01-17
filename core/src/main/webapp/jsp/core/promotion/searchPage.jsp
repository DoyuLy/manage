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
<title>搜索结果页广告</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/css.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/prompt.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/splist.css" />
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
        <li><a href="/promotion/index">一手货源广告</a></li>
        <li><a href="/promotion/uclist">用户中心广告</a></li>
        <li class="mlm_select"><a href="/promotion/searchResult">搜索结果广告</a></li>
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
              <th colspan="2" style="height: 50px; background: #B000FF; color: white;">Go2.CN搜索结果广告</th>
            </tr>
            <tr>
              <th width="80">位置说明</th>
              <td style="text-align: left; line-height: 150%; padding: 10px 20px 10px 20px; font-size: 12px;">
                <p style="text-indent: 24px;">搜索结果页广告，是显示在搜索结果页的产品推荐广告（搜索积分排名前500厂商的品牌时不会显示），搜索结果页的PV与网站一手货源页相当，目前每期销售 36
                  个，每次随机轮播显示，提前两周在线订购。根据三个月的试运行数据分析，搜索结果页广告点击量与用户中心广告点击量基本持平。</p>
              </td>
            </tr>
            <tr>
              <th width="80">推广效果</th>
              <td style="text-align: left; line-height: 150%; padding: 10px 20px 10px 20px; font-size: 12px;"><span style="color: red">★★★★</span>
              </td>
            </tr>
            <tr>
              <th width="80">订购价格</th>
              <td style="text-align: left; line-height: 150%; padding: 10px 20px 10px 20px; font-size: 12px;"><span style="color: red">300元/7天</span>
              </td>
            </tr>
            <tr>
              <th width="80">订购规则</th>
              <td style="text-align: left; line-height: 150%; padding: 10px 20px 10px 20px; font-size: 12px;">
                <ol>
                  <li>仅成都国际商贸城女鞋类高级认证商家能订购本段位广告</li>
                  <li>同一厂商每周最多只能订购一个搜索结果广告位或用户中心广告位</li>
                  <li>订购时排名在 100 名(含）以内的厂商<b> 不能 </b>订购本推广位
                  </li>
                </ol>
              </td>
            </tr>
            <tr>
              <th width="80">加分规则</th>
              <td style="text-align: left; line-height: 150%; padding: 5px 20px 5px 20px; font-size: 20px;">
                <ol style='margin: 0px; padding: 0px 0px 0px 0px;'>
                  <li><b>广告定购成功后八小时内付款每个位置加50分</b></li>
                </ol>
              </td>
            </tr>
            <tr>
              <th width="80">退订须知</th>
              <td style="text-align: left; line-height: 150%; padding: 10px 20px 10px 20px; font-size: 12px;">
                <ol>
                  <li>退订广告将影响到厂家评分、下次订购广告的机会和价格，以及专题活动的参与</li>
                  <li>在此订购的广告，可在${SELF_DELETE_PROMOTION_TIMELIMIT/60}分钟 内到【<a href="/promotion/myPromotion">我订购的广告</a>】取消，自助取消将不影响评分
                  </li>
                  <li>厂家退订的广告将于每日下午14点整向国际商贸城高级认证女鞋类厂家开放订购，先到先得</li>
                  <li>确定要退订相关广告位置，请联系客服办理，QQ：4006611603</li>
                </ol>
              </td>
            </tr>
          </table>
          <br>
          <c:set var="day" value="<%=Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1%>" />
          <c:if test="${day eq 2}">
            <%
              SimpleDateFormat dateFormat = new SimpleDateFormat(
            								"yyyy-MM-dd");
            						SimpleDateFormat dateFormat2 = new SimpleDateFormat(
            								"yyyy-MM-dd HH:mm:ss");
            						Date now = new Date();
            						String time = dateFormat.format(now) + " 14:00:00";
            						Date date = dateFormat2.parse(time);
            						long offset = date.getTime() - now.getTime();
            						request.setAttribute("offset", offset);
            %>
            <c:if test="${offset>0}">
              <div align="center">
                <div style="margin: 0px; height: 120px; padding-left: 259px; font-size: 16px; font-family: 微软雅黑;">
                  <p style="color: red;">距今日用户中心广告订购开始还有</p>
                  <script type="text/javascript" src="${ctx}/js/plugin/countdown.js"></script>
                  <script>
									var myCount = new Countdown({
										time: ${offset}, 
										width: 230, 
										height: 60, 
										rangeHi:"hour", 
										style: "flip", 
										labels: {
											font 	: "微软雅黑",
											color	: "#000000",
											weight	: "bold",
										},	
										onComplete: countdownComplete
									});
									function countdownComplete() {
										window.location.href = "/promotion/searchResult";
									}
								</script>
                </div>
              </div>
            </c:if>
          </c:if>
          <table class="table table_list">
            <c:choose>
              <c:when test="${!empty reason}">
                <tr>
                  <th style="padding: 50px; background: white; line-height: 200%;">${reason}</th>
                </tr>
              </c:when>
              <c:otherwise>
                <c:choose>
                  <c:when test="${!empty promotions}">
                    <tr>
                      <th width="40">#.</th>
                      <th width="120">开始日期</th>
                      <th width="140">结束日期</th>
                      <th width="50">时间</th>
                      <th width="100">价格</th>
                      <th>备注</th>
                      <th width="150">操作</th>
                    </tr>
                    <c:forEach items="${promotions}" var="hashPromotion" varStatus="status">
                      <tr class='{cycle values="odd,odd"}'>
                        <td align="center">${status.index+1}.</td>
                        <td align="center"><fmt:formatDate var="startTime" value="${hashPromotion.promotion.startTime}"
                            pattern="yyyy-MM-dd" /> ${startTime}</td>
                        <td align="center"><c:set var="endTime" value="${hashPromotion.promotion.endTime}" scope="request" /> <%
   Date endTime = (Date) request
 												.getAttribute("endTime");
 										long time = endTime.getTime();
 										request.setAttribute("endTimeValue",
 												new Date(time));
 %> <fmt:formatDate var="endTimeStr" value="${endTimeValue}" pattern="yyyy-MM-dd" /> ${endTimeStr}</td>
                        <td align="center">7天</td>
                        <td align="center">&yen;${hashPromotion.promotion.totalFee*hashPromotion.promotion.discount}</td>
                        <td align="center"><font color="blue">搜索结果广告</font></td>
                        <td align="center">
                          <%
                            Calendar calendar = Calendar
                          												.getInstance();
                          										int day = calendar
                          												.get(Calendar.DAY_OF_WEEK) - 1;
                          										int hour = calendar
                          												.get(Calendar.HOUR_OF_DAY);
                          										request.setAttribute("day", day);
                          										request.setAttribute("hour", hour);
                          %> <c:choose>
                            <c:when test="${day eq 1 or (day eq 2 and hour lt 14)}">
                              <c:choose>
                                <c:when test="${day eq 2}">
		                                					今日14点开放
		                                				</c:when>
                                <c:otherwise>
		                                					本周二14点开放
		                                				</c:otherwise>
                              </c:choose>
                            </c:when>
                            <c:otherwise>
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
			                                			function order(posX, startTime,totalFee,discount,hash){
			                                				window.open("${ctx}/promotion/toSearchPage?posX="+posX+"&startTime="+startTime+"&totalFee="+totalFee+"&discount="+discount+"&hash="+hash,"订购广告","width=800, height=400");
		                                				}	    
		                                			</script>
                              <%--
		                                			<a href="#" class="jwin" data-title="订购广告" data-url="${ctx}/promotion/order_uc/${promotion.posX}/${promotion.startTime}/${promotion.totalFee}/${promotion.discount}/${hash[status.index]}">订购</a>	
		                                			 --%>

                              <a class="jwin" href="javascript:void(0);"
                                onclick="order('${hashPromotion.promotion.posX}','${startTime}','${hashPromotion.promotion.totalFee}','${hashPromotion.promotion.discount}','${hashPromotion.hash}');">订购</a>
                            </c:otherwise>
                          </c:choose>
                        </td>
                      </tr>
                    </c:forEach>
                  </c:when>
                  <c:otherwise>
                    <tr>
                      <th colspan="8" style="height: 100px; background: #FFFFFF; line-height: 150%;">对不起，本期<font color="red">
                          用户中心广告位 </font>已售罄，谢谢参与。<br> 网站市场商家广告位尚有少量空余时段，如需购买请联系客服QQ 400 6611 603 办理
                      </th>
                    </tr>
                  </c:otherwise>
                </c:choose>
              </c:otherwise>
            </c:choose>
          </table>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
  </div>
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-ui.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-message.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/countdown.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/public/public.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/promotion/splist.js"></script>
</body>
</html>
