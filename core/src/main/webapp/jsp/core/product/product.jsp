<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="my" uri="http://www.changtusoft.cn/test/functions" %> 

<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link href="/css/common/common.css" rel="stylesheet" type="text/css" />
<link href="/css/core/product/newcss.css" rel="stylesheet" type="text/css" />
<link href="/css/core/product/product.css" rel="stylesheet" type="text/css" />
<link href="/css/core/product/prompt.css" rel="stylesheet" media="all" />
<link rel="stylesheet" type="text/css" href="/css/core/product/3d-corner-ribbons.css">
<link rel="stylesheet" type="text/css" href="/css/core/product/prettify.css">
<link rel="stylesheet" href="/css/core/product/tips.css" />
<script type="text/javascript" src="//a.tbcdn.cn/libs/jquery/1.7.1/jquery.js"></script>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<!-- 页面标题==========================================-->
<head>
<title>${supplier.title }&${productDetail.articleNumber }-购途市场(go2.cn)</title>

<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.min.js"></script>
      <script src="/resources/js/respond.min.js"></script>
    <![endif]-->

<link rel="Shortcut Icon" href="/img/favicon.ico">


<style type='text/css'>
#promise {
  padding: 10px;
  background-color: #FDF0F0;
  text-indent: 2em;
  line-height: 25px;
  font-size: 14px;
}

#promise-box {
  margin-top: 10px;
}

#label-pic {
  position: absolute;
  z-index: 1000;
  width: 100px;
  left: 0;
}

.ribbon .banner::after,.ribbon .banner::before {
  width: 0px;
}

#biinfo dd .pbtn_bg {
  float: left;
  width: 99px;
  height: 31px;
  margin: 0;
  padding-top: 11px;
  font-size: 14px;
  line-height: 18px;
  font-weight: bold;
  text-align: center;
  color: #fff;
  background: url(/img/product/product_login.jpg) no-repeat;
}

#biinfo dd .pbtn_bg_over {
  float: left;
  width: 99px;
  height: 31px;
  margin: 0;
  padding-top: 11px;
  font-size: 14px;
  line-height: 18px;
  font-weight: bold;
  text-align: center;
  color: #fff;
  background: url(/img/product/product_btn_bg_over.jpg) no-repeat;
}

.promise_label {
  display: inline-block;
  margin-right: 10px;
  padding: 3px 5px;
  font-weight: bold;
  color: white;
  background-color: #1FA5E8
}

#discription {
  position: fixed;
  top: 0px;
  left: 0px;
  z-index: 10001;
  display: none;
  padding: 5px;
  max-width: 600px;
  height: auto;
  color: #666;
  font-size: 12px;
  background-color: #F6F797;
  border: 1px #999 solid;
}

/*顶部悬浮*/
.top_float {
  width: 100%;
  position: fixed;
  top: 0px;
  left: 0px;
  height: 55px;
  background-color: #fff;
  border-bottom: 2px solid #eee;
  z-index: 100;
  display: none;
}

.content {
  width: 1195px;
  margin: 0 auto;
}

.content .left {
  float: left;
  width: 1000px;
  line-height: 55px;
}

.content .left img {
  vertical-align: middle;
  padding: 0;
  margin: 0;
}

.content .left a:link {
  text-decoration: none;
}

.content .left a.but:hover {
  background: #5f5f5f;
}

.content .left a.c_value:hover {
  border-bottom: 1px solid #5f5f5f;
}

.content .left .c_name {
  color: #737373;
  font-size: 15px;
  font-weight: bold;
}

.content .left .c_value {
  color: #ff6100;
  padding-left: 4px;
  padding-right: 8px;
}

.content .left .but {
  margin-right: 0px;
  padding: 5px 7px;
  background: #ff6100;
  color: #fff;
  font-size: 15px;
}

.content .left .but1 {
  background: #5f5f5f;
  margin-right: 0px;
  padding: 5px 7px;
  color: #fff;
  font-size: 15px;
}

.content .right {
  float: right;
  width: 195px;
}

.content .right .box1,.content .right .box2 {
  font-size: 15px;
  position: relative;
  color: #636363;
  font-weight: bold;
  display: inline-block;
  text-align: center;
  line-height: 55px;
  width: 83px;
}

.content .right .box1,.content .right .box2 {
  *display: inline;
  line-height: 55px;
  *zoom: 1;
  vertical-align: middle;
}

.content .right .box1:hover {
  border: 2px solid #ff6100;
  border-bottom: none;
  color: #ff6100;
  background: url("/img/product/jtou_n.jpg") no-repeat center;
}

.content .right .box2:hover {
  border: 2px solid #ff6100;
  border-bottom: none;
  color: #ff6100;
  background: url("/img/product/jtou_n.jpg") no-repeat center;
}

.info1 {
  z-index: 9999;
  display: none;
  color: #36353b;
  position: absolute;
  top: 55px;
  right: -2px;
  width: 338px;
  height: 160px;
  padding-left: 20px;
  text-align: left;
  border: 2px solid #ff6100;
  background: #fff;
}

.info2 {
  z-index: 9999;
  display: none;
  color: #36353b;
  position: absolute;
  top: 55px;
  right: -2px;
  width: 337px;
  height: 215px;
  padding-left: 20px;
  font-size: 12px;
  text-align: left;
  border: 2px solid #ff6100;
  background: #fff;
}

.info1 p {
  font-weight: normal;
  height: 30px;
  line-height: 30px;
  font-size: 14px;
  font-family: "微软雅黑"
}

.info2 p {
  font-weight: normal;
  width: 300px;
  margin: 0px;
  line-height: 25px;
  color: #707070;
  font-size: 12px;
}

.info2 p a {
  text-decoration: none;
  color: #707070;
  padding: 0 5px;
}

.info2 p a:hover {
  color: #36353b;
  border-bottom: 1px solid #ff6100;
}

.info2 p b {
  color: #707070;
  font-size: 16px;
}

.link1 {
  color: #ff6100 !important;
  padding: 0 3px;
}

.info1 h2 {
  font-size: 18px;
  height: 40px;
}

.info2 h2 {
  font-size: 16px;
  height: 40px;
}

.zhegai {
  height: 4px;
  width: 83px;
  float: right;
  margin-top: -3px;
  background: #fff;
}

.face {
  padding: 6px 15px;
  text-align: center;
  font-size: 14px;
  font-weight: bold;
  color: #fff;
  background: #C9C9C9;
  margin-top: 30px;
}

.face_name .face_img {
  margin-top: 40px;
  margin-left: 30px;
  margin-bottom: 40px;
  border-radius: 100px;
  max-width: 70px;
  max-height: 70px;
  float: left;
}

.face_name img {
  float: left;
}

.row {
  border-left: 1px solid #dddddd;
  height: 110px;
  float: left;
  margin-top: 20px;
  margin-left: 10px;
}

.sub {
  margin-left: 10px;
  margin-top: 20px;
}

.sup {
  margin-top: 105px;
  margin-left: 5px;
}

.face_content {
  float: left;
  line-height: 16px;
  padding-left: 10px;
}

.face_content font {
  font-family: '宋体';
  opacity: 0.5;
  font-size: 15px;
}

.face_nick {
  float: left;
  margin-top: 63px;
  margin-left: 10px;
  font-size: 16px;
  color: red;
}

</style>
</head>
<body>

  <!--T1-->

  <!--div id="corptopbg" style="background:#FE8008;">
  <div id="corptop" style="background:url(images/skmy_top_bg.jpg) repeat-x;"-->
  <div class="top_float">
    <div class="content">
      <div class="left">

        <img src="/img/product/product_login.jpg"> <a href="http://www.go2.cn" target="_blank"><img src="/img/product/goutuxg.jpg" /></a>
        <span class="c_name" style="margin-left: 8px;">商家:</span> <a href="http://${supplier.site.subdomain}.go2.cn/" class='c_value'
          target="_blank">${supplier.title} </a> <span class="c_name">编号:</span><span class='c_value'>${productDetail.articleNumber}</span>
        <span class="c_name">批发价:</span><span class='c_value'>&yen;${productDetail.price} <font color="#737373">&nbsp;元 </font> <!-- 发布 -->
          <c:choose>
            <c:when test="${userOpers.contains('hasDownloaded') }">
              <a href="/product/publish/${productDetail.id}" target="_blank" class="but1" style="margin-left: 10px;">已发布到淘宝</a>
            </c:when>
            <c:otherwise>
              <a href="/product/publish/1/${productDetail.id}" target="_blank" class="but" style="margin-left: 10px;">发布到淘宝</a>
            </c:otherwise>
          </c:choose> <!-- 下载 --> <c:choose>
            <c:when test="${userOpers.contains('hasPublished') }">
              <a class="but1" href="/product/download/${productDetail.id}" target="_blank" class="but1">已下载图片包</a>
            </c:when>
            <c:otherwise>
              <a href="/product/download/${productDetail.id}" target="_blank" class="but">下载图片包</a>
            </c:otherwise>
          </c:choose> <!-- 外链 --> <c:choose>
            <c:when test="${userOpers.contains('hasLinked') }">
              <a href="/product/link/${productDetail.id}" target="_blank" class="but1">已外联本款图片</a>
            </c:when>
            <c:otherwise>
              <a href="/product/link/${productDetail.id}" target="_blank" class="but">外联本款图片</a>
            </c:otherwise>
          </c:choose> <!-- 发布到阿里 --> <a href="/api/ali/publish/${productDetail.id}" target="_blank" class="but">发布到阿里</a>
      </div>

      <!-- 商家信息 -->
      <div class="right">
        <div class="box1">
          <div>拿货信息</div>

          <div class="info1">
            <div class="zhegai"></div>
            <h2>上门拿货方式</h2>
            <p>拿货地址：${supplier.address}</p>
            <p>联系电话：${supplier.phone}</p>
            <p>
              厂家联系人QQ：${supplier.qq}<a class="qq" href="http://wpa.qq.com/msgrd?v=3&uin=${supplier.qq}&site=qq&menu=yes"
                style="height: 20px;" target="_blank" title="QQ联络${supplier.title }"> </a>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- 网站顶部信息 -->
  <div id="corptopbg">
    <div id="corptop">
      <div id="corptopnotes">
        <div id="top_left">
          <em><img class="supplierlogo top" />&nbsp;<a href="http://special.ximgs.net/logo/${supplier.userId}.png">${supplier.title}</a></em> <label><a
            href="http://special.ximgs.net/logo/${supplier.userId}.png">http://${supplier.site.subdomain }.go2.cn</a> <br /> <!--商家认证  --> <c:choose>
              <c:when test="${ supplier.certifiedType eq 2}">
                <c:choose>
                  <c:when test="${supplier.marketId eq 5}">
                    <span class="gaospan">高级认证</span>
                  </c:when>
                  <c:when test="${supplier.marketId eq 6 }">
                    <span class="gaospan" style="background: #FFFFFF">网货街商家</span>
                  </c:when>
                </c:choose>
              </c:when>
              <c:when test="${supplier.certifiedType eq 1 }">
                <span class="chuspan">初级认证</span>
              </c:when>
              <c:otherwise>
                <span>非认证,不支持一站式服务</span>
              </c:otherwise>
            </c:choose> <!-- 生产厂家 --> <c:if test="${supplier.isManufacturer eq 1}">
              <span
                class=<c:choose>
                  <c:when test="${ supplier.certifiedType eq 2}">
                  'gaospan'
                  </c:when>
                  <c:otherwise>
                  'chuspan'
                  </c:otherwise>
                  </c:choose>>生产厂家</span>
            </c:if>
        </div>
        <div id="top_right">
          <h2>
            ${supplier.user.mobile}
            <c:if test="${supplier.qq }"> "/"${supplier.qq }</c:if>
          </h2>
          <label>${supplier.address}</label>
        </div>
      </div>

      <!--供应商商品信息 -->
      <h1>
        <dl>
          <dd>
            <a href="/shop/${supplier.site.subdomain}" />所有产品</a>
          </dd>

          <!-- 厂家公告 -->
          <c:if test="${messages.size() gt 0 }">
            <dd>
              <a href="javascript:jwin('商家动态','/shop/notice/${supplier.site.subdomain }');">商家动态</a>
            </dd>
          </c:if>

          <!-- 服务描述 -->
          <dd>
            <a href="javascript:jwin('服务描述','/shop/brief/${supplier.site.subdomain }');">服务描述</a>
          </dd>
          <!-- 产品分类 -->
          <c:forEach var="productCategory" items="${productCategories }">
            <a href="/shop/${supplier.site.subdomain }/${productCategory.categoryId}/0/0">${productCategory.category.title}(${productCategory.categoryNum})
            </a>
          </c:forEach>

          <!-- 尾货 -->
          <dd class="label2-dd <c:if test="tailGoodsCount>0">classselect</c:if>">
            <a href="/shop/${supplier.site.subdomain }/0/0/1">尾货(<span class="label2-num">${tailGoodsCount}</span>)
            </a>
          </dd>

          <dd class="classselect">
            <a href="#top">商品详情</a>
          </dd>
        </dl>
      </h1>
    </div>
  </div>

  <!--产品详情  -->
  <div id="productinfo">
    <div id="newsmessagebox"></div>

    <div id="pinfoleft">
      <!-- 新款 -->
      <c:if test="${newProducts.size()>0 }">
        <ul class="products">
          <li class="ph1">新品推荐</li>
          <c:forEach var="newProduct" items="${newProducts }">
            <li><span>
                <table cellpadding="0" cellspacing="0" border="0">
                  <tr>
                    <td><a href="/product/${newProduct.id }" target="_blank"><img
                        src="http://thumb.ximgs.net${fn:substringBefore(newProduct.indexImage, '.')}_160x160.jpg"
                        alt="${newProduct.supplier.title }&${newProduct.articleNumber}" /></a></td>
                  </tr>
                </table>
            </span> <strong>ID:<a href="/product/${newProduct.id }">${newProduct.supplier.title }&amp;${newProduct.articleNumber}</a></strong> <label
              class="${ newProduct.price}">${ newProduct.price}</label> <em class="${ newProduct.characters}">${ newProduct.characters}</em></li>
          </c:forEach>
        </ul>
      </c:if>

      <!--热款  -->
      <c:if test="${hotProducts.size()>0 }">
        <ul class="products">
          <li class="ph1">爆款热卖</li>
          <c:forEach var="hotProduct" items="${hotProducts }">
            <li><span>
                <table cellpadding="0" cellspacing="0" border="0">
                  <tr>
                    <td><a href="/product/${hotProduct.id }" target="_blank"><img
                        src="http://thumb.ximgs.net${fn:substringBefore(hotProduct.indexImage, '.')}_160x160.jpg"
                        alt="${hotProduct.supplier.title }&${hotProduct.articleNumber}" /></a></td>
                  </tr>
                </table>
            </span> <strong>ID:<a href="/product/${hotProduct.id }">${hotProduct.supplier.title }&amp;${hotProduct.articleNumber}</a></strong> <label
              class="${ hotProduct.price}">${ hotProduct.price}</label> <em class="${ hotProduct.characters}">${ hotProduct.characters}</em></li>
          </c:forEach>
        </ul>
      </c:if>
    </div>

    <!-- 产品详情主题页面 -->

    <div id="pinfobody">
      <div id="basicinfo">
        <div id="propic" class="czbox <c:if test='${productDetail.labelId gt 0}'>ribbon-tag</c:if>">
          <!-- 产品标签 -->
          <div id="picbox">
            <!-- 显示产品首图 -->
            <div id="imgs0">
              <a class="cloud-zoom"> <img
                <c:choose>
                            <c:when test="${fn:startsWith(productDetail.indexImage, 'ttp')}">
                            src="http://thumb.ximgs.net${fn:substringBefore(productDetail.indexImage, '.')}_750x750.jpg"
                            </c:when>
                            <c:otherwise>
                            src="http://thumb.ximgs.net${fn:substringBefore(productDetail.indexImage, '.')}_310x310.jpg"
                            </c:otherwise>
                            </c:choose> />
              </a>
            </div>

            <!-- 四张次图 -->
            <c:if test="${taobaoImgImages.size() gt 0 }">
              <c:forEach var="taobaoImg" varStatus="status" items="${taobaoImgImages }">
                <div id="imgs${(status.index + 1)}">
                  <a class="cloud-zoom"> <img src="http://thumb.ximgs.net${fn:substringBefore(taobaoImg.itemValue, '.')}_310x310.jpg" />
                  </a>
                </div>
              </c:forEach>
            </c:if>

            <!--次图标签  -->
            <div style="float: left; width: 310px; text-align: center; font-size (): 12px; padding-top: 15px; color: #999;"
              title="${productDetail.createTime }">
              最近更新：
              <fmt:formatDate value="${productDetail.updateTime}" type="both" />
            </div>

            <!-- 首图缩略图 -->
            <div id="smallimg">
              <a lang="0"><img
                <c:choose>
                            <c:when test="${fn:startsWith(productDetail.indexImage, 'ttp')}">
                            src="http://thumb.ximgs.net${fn:substringBefore(productDetail.indexImage, '.')}_50x50.jpg"
                            </c:when>
                            <c:otherwise>
                            src="http://thumb.ximgs.net${fn:substringBefore(productDetail.indexImage, '.')}_50x50.jpg"
                            </c:otherwise>
                   </c:choose> />
              </a>

              <!-- 次图缩略图 -->
              <c:if test="${taobaoImgImages.size() gt 0 }">
                <c:forEach var="taobaoImg" varStatus="status" items="${taobaoImgImages }">
                  <a lang="${status.index + 1}"> <img
                    src="http://thumb.ximgs.net${fn:substringBefore(taobaoImg.itemValue, '.')}_50x50.jpg" />
                  </a>
                </c:forEach>
              </c:if>

              <div style="float: left; width: 310px; text-align: center; font-size (): 12px; padding-top: 15px; color: #999;"
                title="${productDetail.createTime }" id="${productDetail.id }_modify_time">最近更新：${productDetail.updateTime}</div>
            </div>
          </div>
        </div>

        <!-- 右侧描述 -->
        <div id="basicitem">
          <ul>
            <li id="pl1" class="plselect"><a href="javascript:;" onClick="setmlabel('pl1','biinfo');">基本信息</a></li>
            <li id="pl4"><a href="javascript:;" onClick="setmlabel('pl4','reviewproduct');">投诉反馈</a></li>
            <li id="pl2"><a href="javascript:;" onClick="setmlabel('pl2','getproduct');">拿货咨询</a></li>
            <li id="pl3"><a href="#downlist">商品人气</a></li>
          </ul>
          <div id="biinfo">
            <h5>
              <span>商家编码： <c:if test="${not empty supplier.title}">
              ${supplier.title}&${productDetail.articleNumber }
              </c:if>
              </span>
              <c:if test="${productDetail.characters }">
                <em title="${productDetail.characters }">${productDetail.characters }</em>
              </c:if>
            </h5>
            <dl>
              <dt>
                <span>厂家批发价：<strong>&yen;</strong></span><em id="${productDetail.id}_price"></em><label>零售价在此基础上加价！</label>
              </dt>
              <dd>
                产品类型：<strong>${productDetail.category.title}</strong>， 货源类型：<strong> <c:choose>
                    <c:when test="${productDetail.isDirectSale eq 1}">
                                                  厂家自产销
                </c:when>
                    <c:otherwise>
                                                  经销代理
                </c:otherwise>
                  </c:choose>
                </strong>
              </dd>
              <dd>
                总人气：<span id="${productDetail.id }_stats"> <c:choose>
                    <c:when test="${not empty productDetail.isHideStats}">
                                                                 商家隐藏本款产品下载人气显示!
                      </c:when>
                    <c:otherwise>
                      <c:out value="${productDetail.taobaoCountAlltime}"></c:out>
                    </c:otherwise>
                  </c:choose>
                </span>
              </dd>

              <!-- 尺码说明  分类号为8,9,11,12,14,16,17的，不显示尺码，此逻辑已经在sql中实现了-->
              <c:if test="${not empty productDetail.categoryId}">
                <dd>
                  尺码说明：<strong class="${productDetail.id}_size">${productDetail.size}</strong>
                </dd>
              </c:if>

              <!--发布到淘宝、下载信息  -->
              <c:choose>
                <c:when test="${productDetail.state eq 0}">
                  <dd id="productbtn">
                    <a class=pbtn_bg_over>本产品已下架</a>
                  </dd>
                </c:when>
                <c:otherwise>
                  <dd id="productbtn">
                    <!-- 发布 -->
                    <c:choose>
                      <c:when test="${userOpers.contains('hasDownloaded') }">
                        <a href="javascript:void(0)" onclick="publish('${productDetail.id}', 1)" target="_blank" class="but1" style="margin-left: 10px;">已发布到淘宝</a>
                      </c:when>
                      <c:otherwise>
                        <a href="javascript:void(0)" onclick="publish('${productDetail.id}', 1)" target="_blank" class="but" style="margin-left: 10px;">发布到淘宝</a>
                      </c:otherwise>
                    </c:choose>

                    <!-- 下载 -->
                    <c:choose>
                      <c:when test="${userOpers.contains('hasPublished') }">
                        <a class="but1" href="/product/download/${my:encodeId(productDetail.id)}" target="_blank" class="but1">已下载图片包</a>
                      </c:when>
                      <c:otherwise>
                        <a href="/product/download/${my:encodeId(productDetail.id)}" target="_blank" class="but">下载图片包</a>
                      </c:otherwise>
                    </c:choose>

                    <!-- 外链 -->
                    <c:choose>
                      <c:when test="${userOpers.contains('hasLinked') }">
                        <a href="/product/link/${my:encodeId(productDetail.id)}" target="_blank" class="but1">已外联本款图片</a>
                      </c:when>
                      <c:otherwise>
                        <a href="/product/link/${my:encodeId(productDetail.id)}" target="_blank" class="but">外联本款图片</a>
                      </c:otherwise>
                    </c:choose>
                    <!-- 发布到阿里 -->
                    <a href="javascript:void(0)" onclick="publish('${productDetail.id}', 2)" target="_blank" class="but">发布到阿里</a>
                  </dd>
                </c:otherwise>
              </c:choose>
            </dl>
          </div>
          <div id="getproduct" style="display: none;">
            <h6>上门拿货方式：</h6>
            <p>拿货地址：${supplier.address}</p>
            <p>
              联系电话：${supplier.user.mobile}
              <c:if test="${supplier.phone}">"/ ${supplier.phone}"</c:if>
            </p>
            <c:if test="${supplier.qq }">
              <p>厂家联系人QQ：${supplier.qq}</p>
            </c:if>

            <h6>远程一件代发：</h6>
            <p style="margin-left: 0;">
              <a href="http://df.go2.cn/" target="_blank"><img src="/img/product/daifabtn.gif" /></a>
            </p>
            <p id="notes">联系我们时，请说明来自"go2.cn平台"！</p>
          </div>

          <!-- 投诉反馈 -->
          <div id="reviewproduct" style="display: none;">
            <h7>提示：投诉举报产品成功会直接影响该产品的排名权重，以及对其评估分值产生重要影响，请谨慎处理!另，系统不会显示投诉人信息，所以不必担心资料安全。</h7>
            <p>
              <label>投诉类型：</label> <span> <select name="complain_category_id" id="complain_category_id">
                  <option value="">请选择投诉类别</option>
                  <c:forEach var="complainCategory" items="${complainCategories }">
                    <option value="${complainCategory.id}">${complainCategory.title}</option>
                  </c:forEach>
              </select> <input type="button" value="附件" onclick="$('#complain_imgs').click();" /> <span id="complain_imgs_msg"
                style="display: inline; float: none;">上传图片</span> <input type="hidden" id="complain_imgs_path" value="" />
              </span>
            </p>
            <form id="complain_img_upload" style="display: none;">
              <input type="file" id="complain_imgs" accept=".jpg" onchange="upload_img()" multiple="multiple" />
            </form>
            <p>
              <label>投诉理由：</label> <span> <textarea id="review"></textarea>
              </span>
            </p>
            <p>
              <label><img src="/img/product/span.gif" /></label> <span><input type="button" value="提交投诉" id="reviewbtn" /></span>
            </p>
            <p>
              <label><img src="/img/product/span.gif" /></label> <span>我们会审核每一次投诉，请尽量客观公证。</span>
            </p>
          </div>
        </div>
        <div style="float: left; margin-top: 5px;">

          <!-- 广告 -->
          <c:forEach var="promotion" items="${promotions }">
            <c:choose>
              <c:when test="${promotion gt '0' }">
                <a href="/promotion/track/${promotion.id }" target="_blank"><img
                  src="http://thumb.ximgs.net${fn:substringBefore(promotion.image, '.')}_160x160.jpg" /></a>
              </c:when>
              <c:otherwise>
                <a href="/unique/" target="_blank"><img src="http://image.go2.cn/webfile/showpicture/unique.gif" /></a>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </div>
      </div>
      <div id="moreinfo">
        <h5>
          <a href="#" class="miselect">商品详细信息</a> <a href="javascript:jwin('服务描述','/shop/brief/${supplier.site.subdomain }');"
            class="milink">服务描述</a>
        </h5>
        <div id="productshow">
          <div id="propshowbox">
            <ul id="propsul">
              <!-- 尺码说明  分类号为8,9,11,12,14,16,17的，不显示尺码，此逻辑已经在sql中实现了-->
              <c:if test="${productSizeShow eq 1 }">
                <dd>
                  尺码说明：<strong class="${productDetail.id}_size"></strong>
                </dd>
              </c:if>
            </ul>

          </div>
          <div id="islink">
            <ul>
              <c:if test="${productLinks.size()>0 }">
              <c:forEach var="product" items="${ productLinks}">
              <li>
                <span>
                <table cellspacing="0" cellpadding="0" border="0">
                  <tbody><tr>
                    <td><a href="/product/${product.id}" target="_blank"><img src="http://thumb.ximgs.net${fn:substringBefore(product.indexImage, '.')}_160x160.jpg" alt="${product.supplier.title}&${product.articleNumber}" /></a></td>
                  </tr>
                </tbody></table>
                </span>
                <strong>ID:<a target="_blank" href="/product/${product.id}">${product.supplier.title}&amp;${product.articleNumber}</a></strong>
                <label>&yen;${product.price}</label>
                <em>${product.characters}</em>
              </li>
              </c:forEach>
              </c:if>
              </ul>
          </div>
          <c:if test="${productDetail.productComment.content>''}">
            <div style="display: inline; float: left; margin-top: 30px; width: 100%;" class="chose">
              <span class="face" style="color: black;">精选好评</span>
              <h2 style="border-bottom: 1px solid #DDD; margin-top: 5px;"></h2>
              <div class="face_name">
                <img class="face_img" src="/img/product/face/${productDetail.productComment.face}" /> <span class="face_nick">${productDetail.productComment.name}</span>
                <span class="row"></span> <img src="/img/product/dou_sub.png" class="sub" /> <span class="face_content"> <font>${productDetail.productComment.content}</font></span>
                <img src="/img/product/dou_sup.png" class="sup" /> <span
                  style="border-top: 1px solid #DDD; float: left; width: 100%; margin-bottom: 20px;"></span>
              </div>
            </div>
          </c:if>
          <script>
                    $(function(){
                        var Height = $(".face_content font").height();
                        var h1 = $(".face_img").width();
                        var h2 = $(".face_nick").width();
                        var h3 = $(".row").width();
                        var h4 = $(".sub").width();
                        var totalH = $(".chose").width();
                        var contHight = totalH-h1-h2-h3-h4-110;
                        var auto = (120-Height)/2;
                        $(".face_content").css("margin-top",parseInt(auto)+'px');
                        $(".face_content").css("width",parseInt(contHight)+'px');
                    });
                </script>
          <!--产品详情描述  -->
          <div id="productmemo">${productDetail.productMeta.descriptionBin}</div>
        </div>
      </div>
      <div id="downlist" name="downlist">
        <h5 class="dlh5">
          <a href="javascript:;" id="dl1" class="dlselect" onClick="setdlabel('dl1','dlst1');">发布到淘宝记录</a> <a href="javascript:;" id="dl2"
            onClick="setdlabel('dl2','dlst2');">下载数据包记录</a>
        </h5>

        <!-- 下载发布记录 -->
        <!-- 发布到淘宝 -->
        <c:if test="${taobaoLists.size() gt 0}">
          <h6 class="dlh6">最近数据：</h6>
          <ul class="dlul" id="dlst1">
            <li id="dltitle"><label>昵称</label> <label>卖家级别</label> <label>发布时间</label></li>
            <c:forEach var="taobaoList" items="${taobaoLists }">
              <li><label>${taobaoList.taobaoNick}</label> <label> <c:choose>
                    <c:when test="${taobaoList.seller.taobaoSellerCreditLevel eq 0}">
                              新卖家
          </c:when>
                    <c:otherwise>
                      <img src="/img/slevel/s_${taobaoList.seller.taobaoSellerCreditLevel}.gif" />
                    </c:otherwise>
                  </c:choose>
              </label> <label><fmt:formatDate value="${taobaoList.createTime}" type="both" /></label></li>
            </c:forEach>
          </ul>
        </c:if>

        <!-- 下载图片包 -->
        <c:if test="${downloadLists.size() gt 0 }">

          <ul class="dlul" id="dlst2" style="display: none;">
            <li id="dltitle"><label>用户名</label> <label>地区</label> <label>下载时间</label></li>
            <c:forEach var="downList" items="${downloadLists }">
              <li><label>${downList.user.username}</label> <label>${downList.userMeta.laddress}</label> <label><fmt:formatDate
                    value="${downList.createTime}" type="both" /></label></li>
            </c:forEach>
          </ul>
        </c:if>
      </div>
    </div>
    <div id="pinforight">
      <div style="margin-top: 10px;">
        <c:forEach var="promotion" items="${promotions}">
          <c:choose>
            <c:when test="${promotion.link ne '#' }">
              <a href="${promotion.link}" target="_blank"><img
                src="http://thumb.ximgs.net${fn:substringBefore(promotion.image, '.')}_50x50.jpg" /></a>
            </c:when>
            <c:otherwise>
              <a href="/help/qrCode" target="_blank"><img src="http://image.go2.cn/webfile/${promotion.image}"></a>
            </c:otherwise>
          </c:choose>
        </c:forEach>
      </div>

      <c:if test="${messages.size() gt 0 }">
        <ul id="newslist">
          <li class="ph2">厂家公告</li>
          <c:forEach var="message" items="${messages }">
            <li>${message.content}<br /> <span>[<fmt:formatDate value="${message.createTime }" type="both" />]
            </span></li>
          </c:forEach>
        </ul>
      </c:if>
    </div>
  </div>
  <div id="sitebody_bottom">
    <div id="sb_left">
      <img class="supplierlogo down" />
      <div id="sldown">
        <h3>
          <a href="http://${supplier.site.subdomain}.go2.cn/">${supplier.title}</a><span>(<a
            href="http://${supplier.site.subdomain}.go2.cn/">http://${supplier.site.subdomain}.go2.cn/</a>)
          </span>
        </h3>
        <p>
          手机：${supplier.phone}
          <c:if test="$supplier.phone }">
          ${$supplier.phone }
          </c:if>
          <c:if test="${supplier.qq }">
          ${supplier.qq}
          </c:if>
          </a> <br /> 地址：${ supplier.address} <a name="downlist"></a>
        </p>
      </div>
    </div>
    <c:if test="${supplier.state eq 1}">
      <div id="sb_right">
        <c:if test="${supplier.certifiedType eq 2}">
          <img src="/img/product/site_renzhen.gif" style="margin-right: 20px;" />
        </c:if>
        <img src="/img/product/site_renzhen.gif" />
      </div>
    </c:if>
  </div>
  <!-- ribbon start -->
  <div class="ribbon ribbon-orange" style="display: none; z-index: 9999;">
    <div class="banner">
      <div class="text" style="text-align: center">尾 货</div>
    </div>
  </div>

  <!-- ie7、8使用 -->
  <div class="ie-ribbon ie-show" style="display: none; z-index: 9999;">
    <div class="banner">
      <div class="ie-text">尾 货</div>
    </div>
  </div>
  <!-- ribbon end -->
  <input type="hidden" value="{$product->id|encode_id}" id="product_id" />
  <input type="hidden" value="{$user_user_id}" id="user_user_id" />

  <script type="text/javascript" src="/js/product/cloud-zoom.1.0.2.js"></script>
  <script type="text/javascript" src="/js/product/jquery.scrollLoading.js"></script>
  <script type="text/javascript" src="/js/product/ribbon.js"></script>
  <script type="text/javascript" src="/js/product/prettify.js"></script>
  <script type='text/javascript' src='/js/product/public.js'></script>
  <script type="text/javascript" src="/js/product/jquery.ui.core.js"></script>
  <script type="text/javascript" src="/js/product/jquery.ui.widget.js"></script>
  <script type="text/javascript" src="/js/product/jquery.ui.mouse.js"></script>
  <script type="text/javascript" src="/js/product/jquery.ui.draggable.js"></script>
  <script type="text/javascript" src="/js/product/jquery.message.js"></script>
  <script type="text/javascript" src="/js/product/crypt.js"></script>

  <!--jQuery函数  -->
  <script type="text/javascript">
  
  //js函数
  function jwin(tstr,url){
    new $.Message({
        title:tstr,
        ismask:true,
        icon:'none',
        content:'<iframe src="'+url+'" width="778" frameborder="0" height="500"></iframe>',
        width:788,
        height:537,
        button:{ ok:false,cancel:false}
    });
  }
  
    //发布
    function setdlabel(n,l){
      document.getElementById('dl1').className='';
      if(document.getElementById('dlst1')) {
          document.getElementById('dlst1').style.display='none';
      }
      document.getElementById('dl2').className='';
      if(document.getElementById('dlst2')) {
          document.getElementById('dlst2').style.display='none';
      }
      document.getElementById(n).className='dlselect';
      if(document.getElementById(l)) {
          document.getElementById(l).style.display='';
      }
    }
    
    function publish(id, type){
    	$.ajax({
    		url: "/product/publish/" + type + "/"+ id,
    		type: "GET",
    		success: function(data){
    			if(data){
    				location.href=data;
    			}
    		},
    		error: function(data){
    			if(data.responseText) alert(data.responseText);
    			else location.href = "/login";
    		}
    	})
    }
      
//投诉
  function setmlabel(n,l){
    document.getElementById('pl1').className='';
    document.getElementById('biinfo').style.display='none';
    document.getElementById('pl2').className='';
    document.getElementById('getproduct').style.display='none';
    document.getElementById('pl4').className='';
    document.getElementById('reviewproduct').style.display='none';
    document.getElementById(n).className='plselect';
    document.getElementById(l).style.display='';
  }
  
  //jquery函数
$(document).ready(function(){
 
  $("#reviewbtn").click(function(){
    if(complain_imgs) {
        $('#complain_imgs_path').val(complain_imgs);
    }
    $.ajax({
        type: "POST",
        url: "/product/complain",
        data:{
          complainCategoryId:$("#complain_category_id").val(),
           productId:${productDetail.id}, 
           review:$("#review").val(),
           images:$("#complain_imgs_path").val()
        },
        dataType: 'json',
        success: function(data) {
           if(data==1){
             alert('投诉成功！');
           }
        }
    });
  });
  
})
</script>
