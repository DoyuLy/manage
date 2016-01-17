<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/core/supplier/supplier.css"/>

<!-- 页面标题==========================================-->
<title>认证厂商</title>

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
  
  <!--T3 Search-->
  <div class="t3 fy14">
    <div class="hotkey">
      <ul>
        <li><span style="color: #ff6000">细分品类</span></li>
        <li><span><font color="#ff6000">|</font></span></li>
        <!-- <li><a href="#">雪地靴</a></li> -->
        <li><a href="/unique/c4-1-0.go?w=4">靴子</a></li>
        <li><a href="/unique/c3-1-0.go?w=3">低帮鞋</a></li>
        <li><a href="/unique/c5-1-0.go?w=5">高帮鞋</a></li>
        <!-- <li><a href="#">鱼嘴鞋</a></li>
            <li><a href="#">休闲鞋</a></li> -->
        <li><a href="/unique/c1-1-0.go?w=1">凉鞋</a></li>
        <li><a href="/unique/c2-1-0.go?w=2">拖鞋</a></li>
        <!-- <li><a href="#">雨鞋</a></li>
            <li><a href="#">内增高</a></li>
            <li><a href="#">单鞋</a></li> -->
      </ul>
    </div>
    <div class="flyd">
      <ul>
        <li><a href="/"><font color="#599200">秋冬新品</font></a></li>
        <li><a href="/"><font color="#ff115a">马丁靴</font></a></li>
        <li><a href="/"><font color="#0090ff">乐福鞋</font></a></li>
        <li><a href="/"><font color="#8e00c3">短靴</font></a></li>
        <li><a href="/"><font color="#6a6a6a">内增高</font></a></li>
        <li><a href="/"><font color="#ff3c00">专题活动</font></a></li>
      </ul>
    </div>
  </div>
  
  <!--T5 Menu-->
  <div class="t5 fy18 6a6a6a">
    <ul>
      <li class="active" style="margin-left: 0px;"><a href="/supplier/">市场商家</a></li>
      <li><a href="/supplier/99-0-1-all.go" style="color: #669933;">高级认证商家</a></li>
      <li><a class="fac-link" href="/supplier/88-0-1-all.go">生产厂家</a></li>
      <li><a href="/supplier/6-0-1-all.go">外网商家（网货街）</a></li>
    </ul>
  </div>

  <div class="attrback">
      <div class="Attribute">

        <div class="rank">
          <a href="/supplier/${marketId }-0-1-${keyword }" class="rankall rankcont"> 所有 </a> <a
            href="/supplier/${marketId }-${capital }-2-${keyword }" class="rankdet rankcont"> 最新入住 </a> <a
            href="/supplier/${marketId }-${capital }-3-${keyword }" class="rankdet rankcont"> 代理数量 </a> <a
            href="/supplier/${marketId }-${capital }-4-${keyword }" class="rankdet rankcont"> 产品数量 </a> <a
            href="/supplier/${marketId }-${capital }-5-${keyword }" class="rankdet rankcont"> 下载发布指数 </a>
        </div>


        <div class="rank-1">
          <p>按字母分类</p>
          <c:forEach var="capital" items="${capitalList }">
            <a
              href="/supplier/${marketId }-<c:choose><c:when test="${capital.capital.equals('0-9') }">9</c:when><c:otherwise>${capital.capital }</c:otherwise></c:choose>-${sort }-${keyword }"
              title=" 共${capital.num }个商家" class="ranklet" onclick="rank_letter({$number})">${capital.capital}
            </a>
          </c:forEach>
        </div>

      </div>
    </div>

    <!-- L1 Class 02 -->
    <div class="l1">
      <div class="allstore">
        <c:forEach var="supplier" items="${paginationData.list}">
          <div class="store">
            <div class="store-grade">
              <p class="text-center">店铺等级</p>
              <label
                title="评分：
              <c:choose>
                <c:when test="${(supplier.supplierRank.score > 0) }">${supplier.supplierRank.score }</c:when>
              <c:otherwise>暂无</c:otherwise></c:choose>             
              ">
                <span class="corpnum_${supplier.userId }"> <c:choose>
                    <c:when test="${(supplier.supplierRank.score > 0) && (supplier.marketId == 5)}">
                      <!-- <img src="/images/slevel/s_${supplier.supplierRank.converteScoreToLevel()}.gif" style="max-width: 66px;" />  -->
                      <img src="http://www.go2.cn/images/slevel/s_13.gif" style="max-width: 66px;" />
                    </c:when>
                    <c:otherwise>
                                     暂无
                </c:otherwise>
                  </c:choose>
              </span>
              </label>
            </div>
            
          <div class="message">
            <p
	            <c:choose>
	              <c:when test="${supplier.supplierStats.recommandWeight > 0 }">class="storename"</c:when>
	              <c:otherwise>class="storename-b"</c:otherwise>
	            </c:choose>>
            ${supplier.title}
            </p>

            <c:if test="${supplier.certifiedType == 2 }">
              <p class="orange appr">
                <c:choose>
                  <c:when test="${supplier.marketId == 5 }">
                    <em>高级认证</em>
                  </c:when>
                  <c:otherwise>
                    <em class="appr" style="background: #00CCCC;">网货街商家</em>
                  </c:otherwise>
                </c:choose>
              </p>
            </c:if>

            <c:if test="${supplier.supplierStats.recommandWeight > 0 }">
              <p class="orange appr">
                <em>推荐商家</em>
              </p>
            </c:if>

            <c:if test="${supplier.isManufacturer != null}">
              <p class="green appr">
                <em>生产厂家</em>
              </p>
            </c:if>

            <div class="sto_01">
              <p class="logo_instore">GO2</p>
              <a href="/shop/${supplier.site.subdomain}/" target="" class="webaddr">官方网址&nbsp;<span style="font-family: arial;">${supplier.site.subdomain }</span></a>
            </div>

            <p class="detmsg">
              联系电话：<font style="font-family: tahoma; line-height: 29px;">${supplier.user.mobile} ${supplier.phone}</font>
            </p>

			<p class="detmsg">
			经营模式：
            <c:choose>
              <c:when test="${supplier.isManufacturer } == 1">
            生产加工 / 经销代理
            </c:when>
              <c:otherwise>
            经销代理
            </c:otherwise>
            </c:choose>
			</p>
			
            <c:choose>
              <c:when test="${supplier.qq != null}">
                <p class="detmsg">
                  腾讯 <font style="font-family: arial; line-height: 29px;">QQ</font>：<font style="font-family: tahoma; line-height: 29px;">${supplier.qq}
                    &nbsp;&nbsp;${supplier.qq}</font>
                </p>
              </c:when>
              <c:otherwise>
                <p class="detmsg">拿货地址：${supplier.address}</p>
              </c:otherwise>
            </c:choose>

            <p class="detmsg">
              产品:<span class="number">${supplier.supplierStats.productCount}</span>款，会员:<span class="number">${supplier.supplierStats.userCount}</span>个，
              <c:choose>
                <c:when test="${supplier.settledIn() > 0 }">
                入驻:<span class="number">${supplier.settledIn() }</span>个月
              </c:when>
                <c:otherwise>
                新入驻
              </c:otherwise>
              </c:choose>
            </p>

            <c:if test="${supplier.address != null }">
              <p class="detaddr">拿货地址：${supplier.address }</p>
            </c:if>
          </div>

          <div class="productimg">
            <ul class="products_${supplier.userId }">
              <c:forEach var="product" items="${supplier.products }">
                <li>
                  <table cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                      <tr>
                        <td><a href="#" target="_blank"> <img
                            src="http://thumb.ximgs.net${ fn:replace(product.indexImage, '.', '_80x80.')}">
                        </a></td>
                      </tr>
                    </tbody>
                  </table>
                </li>
              </c:forEach>

              <li class="more picture">
	              <a href="http://kmd.go2.cn/" style="color: white;">
					<span style="font-family: arial; color: black;">more <br> 更多商品</span>
	              </a>
              </li>
            </ul>
          </div>
        </div>
        </c:forEach>

        <!--------分页条-------->
        <%@include file="/jsp/common/pagination.jsp"%>
        <!--------分页条-------->

      </div>

      <div class="sponsor">
        <p class="spo-title f20">赞助商家资源位</p>
        <c:forEach var="sponsor" items="${promotionList }">
          <a href="${sponsor.link }?pos=D2" class="spoadv" target="_blank"> <img
            src="<c:choose><c:when test="${fn:contains(sponsor.image, 'http')}">${sponsor.image }</c:when><c:otherwise>http://image.go2.cn/webfile${sponsor.image }</c:otherwise></c:choose>"
            alt="${sponsor.title }" />
          </a>
        </c:forEach>
      </div>
    </div>
    </div>
    <!-- 页脚==========================================-->
    <%@include file="/jsp/common/footer.jsp"%>

    <!-- 私有js==========================================-->
</body>
</html>