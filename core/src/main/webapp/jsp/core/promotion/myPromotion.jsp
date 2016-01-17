<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/jsp/common/head.jsp"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<title>购途市场(go2.cn)-用户中心</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/css.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/common.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/prompt.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/promotion/myfps.css" />
</head>
<body>
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
        <li><a href="/promotion/searchResult">搜索结果广告</a></li>
        <li><a href="/promotion/marketBusiness">市场商家广告</a></li>
        <li class="mlm_select"><a href="/promotion/myPromotion">我订购的广告</a></li>
        <li><a href="/promotion/billboard">供应商排名榜</a></li>
        <li><a id="qq_link" target="_blank" style="font-size: 14px; color: #999;" href="#">帮助:<img
            style="margin-left: 5px; cursor: pointer" class="qq" src="http://test.go2.cn/images/qq_buttom.png"></a></li>
      </ul>
    </div>
    <div id="mbox_center">
      <table class="table" style="z-index: 1;">
        <tbody>
          <tr>
            <th colspan="2" style="height: 50px; background: #ccc;">付款方式提示（付款确认联络客服QQ：4006611603，客服电话：4006611603）</th>
          </tr>
          <tr>
            <td colspan="2" style="padding: 5px; padding-left: 10px;"><strong>支付宝付款：</strong>
              <p>支付宝帐号：pay@go2.cn (户名：*辉琴)</p></td>
          </tr>
          <tr>
            <td colspan="2" style="padding: 5px; padding-left: 10px;"><strong>招商银行卡转账：</strong>
              <p>帐号：6214 8612 8877 7786 (户名：杨辉琴)</p></td>
          </tr>
        </tbody>
      </table>
      <table class="table table_list">
        <tr>
          <th colspan="9" style="height: 50px;background: red;color:yellow;text-align:center;">已购精品广告</th>
        </tr>
        <tr>
          <th width="40">#.</th>
          <th width="100">开始日期</th>
          <th width="50">时间</th>
          <th width="100">产品</th>
          <th>类型</th>
          <th width="50">价格</th>
          <th width="100">订购日期</th>
          <th width="70">状态</th>
          <th width="70">操作</th>
        </tr>
        <c:forEach items="${promotion}" var="p" varStatus="c">
          <tr class='{cycle values="odd,odd"}'>
            <td align="center">${c.count}.</td>
            <td align="center"><fmt:formatDate var="startTime" value="${p.stStartTime}"
                            pattern="yyyy-MM-dd" /> ${startTime}</td>
            <td align="center">56小时</td>
            <td align="center"><c:if test="${!empty p.productId}">${p.productId}</c:if>
              <c:if test="${empty p.productId}">
              </c:if><a href="" target="_blank">${p.articleNumber}</a></td>
            <td align="center"><c:if test="${!empty p.posX}">${p.posX}</c:if>
              <c:if test="${empty p.posX}">${p.pType}</c:if></td>
            <td align="center">&yen;${p.totalFee}</td>
            <td align="center"><fmt:formatDate var="addTime" value="${p.addTime}"
                            pattern="yyyy-MM-dd" />${addTime}</td>
            <fmt:formatDate var="nowTime" value="<%=new Date()%>"
                            pattern="yyyy-MM-dd" />                
            <fmt:formatDate var="endTime" value="${p.stEndTime}"
                            pattern="yyyy-MM-dd" />
            <c:choose>                
              <c:when test="${nowTime ge startTime && nowTime lt endTime}">
                <td style="background: #0055CC; color: white; text-align: center">投放中</td>
              </c:when>
              <c:when test="${p.payState eq 1}">
                <td align="center" style="background: #FF9900; color: white;">已订购</td>
              </c:when>
              <c:when test="${p.payState eq 2}">
                <td align="center" style="background: #FFDDDD; color: black;">已开票</td>
              </c:when>
              <c:when test="${p.payState eq 3}">
                <td align="center" style="background: #00CC99; color: white;">已支付</td>
              </c:when>
            </c:choose>
            
            <td align="center">
              <c:choose> 
                <c:when test="${p.payState eq 1}">
                  <a href="/promotion/cancelAd?id=${p.id}" onclick="javascript:return confirm('你确定要取消该广告【取消后将不能恢复】？');">取消</a>
                </c:when>
                <c:otherwise>
                  <c:choose> 
                  <c:when test="${p.payState gt 1}">
                    <a href="#" class="mjwin" data-title="设置广告"  >设置</a>
                  </c:when>
                  <c:otherwise>
                    -
                  </c:otherwise>
                  </c:choose>
                </c:otherwise>
              </c:choose>
            </td>
              <input type="hidden"  id="promotionId" value="${p.id}">
          </tr>
        </c:forEach>
        <tr>
          <td colspan="20" align="right"><b>合计待支付：&yen; 元</b> &nbsp;</td>
        <tr>
        <tr>
          <td colspan="12" style="height: 25px; background: #FFFFFF; text-indent: 5px; font-size: 10px; color: red;">备注：此处只显示 一手货源广告位 、
            精品版块广告位 和 2014-03-10以后的 用户中心广告位、搜索结果广告位，如需查询其他位置广告信息请联系客服办理</td>
        </tr>
      </table>
    </div>
  </div>
  <%@include file="/jsp/common/footer.jsp"%>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-ui.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-message.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/countdown.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/public/public.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/promotion/promotion.js"></script>
</body>
</html>
