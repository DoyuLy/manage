<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />

<!-- 页面标题==========================================-->
<title>用户中心-服务承诺</title>

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

  <!-- 内容==========================================-->
  <div class="content">

    <!-- 二级导航和左侧导航==========================================-->
    <%@include file="/jsp/userCenter/supplier/subNav.jsp"%>
    这里是内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容


    <div id="sitebody">
      <div id="mbox_left">{include file="manage/promotion/sidebar.inc.html"}</div>
      <div id="mbox_center">
        <c:choose>
			<c:when test="${msg ne null}">
				<table class="table">
					<tr>
						<th style="height: 100px; line-height: 200%;">
							<p>${msg }</p>
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
                <td style="text-align: left; line-height: 150%; padding: 10px 20px 10px 20px; font-size: 12px;"><span
                  style="color: red">★★★★</span></td>
              </tr>
              <tr>
                <th width="80">订购价格</th>
                <td style="text-align: left; line-height: 150%; padding: 10px 20px 10px 20px; font-size: 12px;"><span
                  style="color: red">300元/7天</span></td>
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
                    <li>在此订购的广告，可在 {$smarty.const.SELF_DELETE_PROMOTION_TIMELIMIT/60}分钟 内到【<a href="/manage/promotion/myfps">我订购的广告</a>】取消，自助取消将不影响评分
                    </li>
                    <li>厂家退订的广告将于每日下午14点整向国际商贸城高级认证女鞋类厂家开放订购，先到先得</li>
                    <li>确定要退订相关广告位置，请联系客服办理，QQ：4006611603</li>
                  </ol>
                </td>
              </tr>
            </table>
            <!-- <br> {if $smarty.now|date_format:"%w" eq '2'} {$offset=$smarty.now|date_format:"%Y-%m-%d 14:00:00"|strtotime-$smarty.now} {if
        $offset gt 0}
        <div align="center">
          <div style="margin: 0px; height: 120px; padding: 0px; font-size: 16px; font-family: 微软雅黑;">
            <p style="color: red;">距今日搜索结果广告订购开始还有</p>
          </div>
        </div>
        {/if}
        {/if} -->
            <table class="table table_list">
              <c:choose>
                <c:when test="${reason != null }">
                  <tr>
                    <th style="padding: 50px; background: white; line-height: 200%;">{$reason}</th>
                  </tr>
                </c:when>

                <c:otherwise>
                  <c:choose>
                    <c:when test="${promotions != null }">
                      <tr>
                        <th width="40">#.</th>
                        <th width="120">开始日期</th>
                        <th width="140">结束日期</th>
                        <th width="50">时间</th>
                        <th width="100">价格</th>
                        <th>备注</th>
                        <th width="150">操作</th>
                      </tr>
                      
                      <c:forEach var="promotion" items="promotionList" varStatus="counter">
                        <tr class='{cycle values="odd,odd"}'>
                          <td align="center">${counter.count }.</td>
                          <td align="center">${promotion.start_time }</td>
                          <td align="center">${promotion.end_time) }</td>
                          <td align="center">7天</td>
                          <td align="center">&yen;${promotion.price * promotion.discount }</td>
                          <td align="center"><font color="blue">搜索结果广告</font></td>
                          <td align="center">
                            <!--
                            {if ($smarty.now|date_format:"%w" eq '1') or ($smarty.now|date_format:"%w" eq '2' and
                            $smarty.now|date_format:"%H" lt 14)} {if $smarty.now|date_format:"%w" eq '2'} 今日14点开放 {else} 本周二14点开放 {/if}
                            {else} <a href="#" class="jwin" data-title="订购广告"
                            data-url="/manage/promotion/order_sp/{$promotion.pos_x}/{$promotion.start_time}/{$promotion.price}/{$promotion.discount}/{$promotion.hash}">订购</a>
                            {/if}
                            -->
                          </td>
                        </tr>
                      </c:forEach>
                    </c:when>

                    <c:otherwise>
                      <tr>
                        <th colspan="8" style="height: 100px; background: #FFFFFF; line-height: 150%;">对不起，本期<font color="red">
                            搜索结果广告 </font>已售罄，谢谢参与。<br> 网站市场商家广告位尚有少量空余时段，如需购买请联系客服QQ 400 6611 603 办理
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

  <!-- 私有js==========================================-->

</body>
</html>