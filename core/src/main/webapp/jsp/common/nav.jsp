<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="top-nav">
  <div class="toolbar">
    <div class="W">
      <div class="u-info fl">
        <ul class="u-info-list">
          <c:if test="${sessionScope.user != '' && sessionScope.user != null}">
            <li>你好， <a
              <c:choose>
               <c:when test="${sessionScope.userType eq '0'}"> href="/userCenter/seller" </c:when>
               <c:when test="${sessionScope.userType eq '1'}"> href="/userCenter/supplier"</c:when>
               <c:otherwise> href="/userCenter/seller"</c:otherwise>
               </c:choose>
              class="cf0 fw">${sessionScope.username}</a><span class="cb6">&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href="/logout" class="c96">退出</a></li>
          </c:if>
          <c:if test="${sessionScope.user == '' || sessionScope.user == null}">
            <li><a href="/login">请登录</a><span class="cb6">&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href="/register" class="c96">注册</a></li>
          </c:if>
          <li class="u-mygo2" style="height: 37px; float: left; margin: 0px 5px; cursor: pointer; position: relative; overflow: hidden;"
            onmouseover="this.style.overflow='visible'" onmouseout="this.style.overflow='hidden'"><a href="javascript:;"> <span>我的购途</span>
          </a> <c:choose>
              <c:when test="${sessionScope.userType eq '0'}">
                <div class="clientmsg">
                  <p>
                    <a href="/userCenter/seller" class="clientdet">用户中心</a>
                  </p>
                  <p>
                    <a href="/userCenter/seller/password" class="clientdet">修改密码</a>
                  </p>
                  <p>
                    <a href="/userCenter/seller/myInfo" class="clientdet">设置</a>
                  </p>
                </div>
              </c:when>
              <c:when test="${sessionScope.userType eq '0'}">
                <div class="clientmsg">
                  <p>
                    <a href="/userCenter/supplier" class="clientdet">用户中心</a>
                  </p>
                  <p>
                    <a href="/userCenter/supplier/password" class="clientdet">修改密码</a>
                  </p>
                  <p>
                    <a href="/userCenter/supplier/myInfo" class="clientdet">设置</a>
                  </p>
                </div>
              </c:when>
              <c:otherwise>
                <div class="clientmsg">
                  <p>
                    <a href="/userCenter/supplier" class="clientdet">用户中心</a>
                  </p>
                  <p>
                    <a href="/userCenter/supplier/password" class="clientdet">修改密码</a>
                  </p>
                  <p>
                    <a href="/userCenter/supplier/myInfo" class="clientdet">设置</a>
                  </p>
                </div>
              </c:otherwise>
            </c:choose></li>
          <li class="u-safety"><a href="javascript:;"><em></em><span>安全担保代发</span></a></li>
        </ul>
      </div>
      <div class="u-short fr">
        <ul class="u-short-list">
          <li>咨询 <a href="javascript:;" class="j_qq s_chat J_ServerQQ"></a>
          </li>
          <li>客服热线<span class="f16 fw c34 arial">400-6611-603</span></li>
          <li class="s_course"><a href="javascript:;">新手教程</a></li>
          <li class="s_issue-tb"><a href="javascript:;">一键发布淘宝</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="header">
    <div class="W">
      <div class="l-logo fl">
        <a href="javascript:;" class="logo"></a>
      </div>
      <div class="l-tsearch fl">
        <div class="lu-tsearch fl">
          <form action="/search" method="get" id="J_TSearchForm">
            <div class="wraper">
              <div class="fl tog-wraper" id="J_HeaderSearchTab">
                <div class="triggers">
                  <a href="javascript:;" class="trigger selected" data-searchtype="shop">货号</a> <a href="javascript:;" class="trigger"
                    data-searchtype="item">厂商</a>
                </div>
                <i class="arrow icon-btn-arrow"></i>
              </div>
              <!-- type -->
              <input type="hidden" name="type" value="shop" id="J_SearchType">
              <!-- q -->
              <input type="text" name="keyword" placeholder="直接输入商家名@货号找款" autocomplete="off" class="form-search fl" id="J_SearchTxt">
              <!-- btn -->
              <input type="submit" value="搜索" class="form-btn cff f14 fw fl">
            </div>
          </form>
          <div id="hotwords">
            <a href="javascript:;" class="under" target="_blank">秋冬女鞋</a> <a href="javascript:;" class="under" target="_blank">雪地鞋</a> <a
              href="javascript:;" class="under" target="_blank">男士钱包</a> <a href="javascript:;" class="under" target="_blank">童装</a> <a
              href="javascript:;" class="under" target="_blank">马丁靴</a> <a href="javascript:;" class="under" target="_blank">超高跟</a> <a
              href="javascript:;" class="under" target="_blank">反皮短靴</a> <a href="javascript:;" class="under" target="_blank">厚底靴</a>
          </div>
        </div>
      </div>
      <div class="l-dimension fr"></div>
    </div>
  </div>
  <div class="nav">
    <div class="W">
      <ul class="fl l-nav f14 fw">
        <li <c:if test="${nav eq 'index' }">class="l-nactive"</c:if>><a href="/"><span><i class="icon-h-nav"></i>首页</span></a></li>
        <li <c:if test="${nav eq 'unique' }">class="l-nactive"</c:if>><a href="/unique"><span>独家</span></a></li>
        <li <c:if test="${nav eq 'firsthand' }">class="l-nactive"</c:if>><a href="/firsthand"><span>一手货源</span></a></li>
        <li <c:if test="${nav eq 'guang' }">class="l-nactive"</c:if>><a href="/guang"><span>逛逛</span></a></li>
        <li><a href="http://www.go2.cn/merchant/" target="_blank"><span>实力质造</span></a></li>
        <li <c:if test="${nav eq 'supplier' }">class="l-nactive"</c:if>><a href="/supplier"><span>认证厂商</span></a></li>
        <li <c:if test="${nav eq 'dropshipper' }">class="l-nactive"</c:if>><a href="/dropshipper"><span>一件代发</span></a></li>
        <li <c:if test="${nav eq 'cameraman' }">class="l-nactive"</c:if>><a href="/cameraman"><span>摄影市场</span></a></li>
      </ul>
      <ul class="fr r-nav f14 fw">
        <li><a href="/logistics"><span>购途物流</span></a></li>
        <li><a href="/store"><span>天马到店</span></a></li>
        <li><a href="http://edu.go2.cn/" target="_blank"><span class="bno">购商学院</span></a></li>
      </ul>
    </div>
  </div>
  <div class="top-sub-nav">
    <div class="W f12">
      <dl class="l-sub-nav fl">
        <c:if test="${navigationBars != null && navigationBars != ''}">
          <c:forEach var="subNav" items="${navigationBars}">
            <dd>
              <a href="${subNav.navigationSubdomain}" target="_self">${subNav.navigationName}</a>
            </dd>
          </c:forEach>
        </c:if>

      </dl>
      <!--      <div class="l-hotnav fr">
        <a href="javascript:;" target="_blank" class="cff0000">每日签到免费快递券</a> <a href="javascript:;" target="_blank" class="c489800">2015秋冬爆款杂志</a>
         <a href="javascript:;" target="_blank" class="c0085ff">魔方数据下载</a>
      </div> -->
    </div>
  </div>
</div>
