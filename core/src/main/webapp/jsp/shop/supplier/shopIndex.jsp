<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>

<head>
<title>厂家店铺</title>
<!-- 样式 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="dns-prefetch" href="//thumb.ximgs.net">
<script type="text/javascript" src="http://a.tbcdn.cn/libs/jquery/1.7.1/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="/css/shop/supplier/ribbons.css">
<link rel="stylesheet" type="text/css" href="/css/shop/supplier/prettify.css">
<link rel="stylesheet" type="text/css" href="/css/shop/supplier/css.css">
<link rel="stylesheet" type="text/css" href="/css/shop/supplier/common.css">
<link rel="stylesheet" type="text/css" href="/css/shop/supplier/corpindex.css">
<link rel="stylesheet" type="text/css" href="/css/shop/supplier/prompt.css">
</head>

<body>
  <div id="corptopbg">
    <div id="corptop">
      <div id="corptopnotes">
        <div id="top_left">
          <em><img class="supplierlogo top" />&nbsp;<a href="/shop/${shopUrl}/">${supplier.title }</a></em> <label> <a
            href="/shop/${shopUrl}/">http://${shopUrl}.go2.cn/</a> <br /> <span class="gaospan">${certifiedType }</span> <span
            class='gaospan'>${membershipType }</span> <span class='gaospan' title="评分：${supplier.supplierRank.score }"> 等级：
              ${supplierScoreLevel}</span> <span onclick="javascript:share(${supplier.userId });" class="gaospan">分享店铺</span>
          </label>
        </div>
        <div id="top_right">
          <h2>
            手机：${supplier.user.mobile } / QQ：${supplier.qq }<a href="http://wpa.qq.com/msgrd?v=3&uin=${supplier.qq}&site=qq&menu=yes"
              target="_blank" title="QQ联络${supplier.title }"><img src="http://wpa.qq.com/pa?p=2:${supplier.qq }:41" align="absmiddle" /></a>
          </h2>
          <label>${supplier.address }</label>
        </div>
      </div>
      <h1>
        <dl>
          <dd>
            <a href="/shop/${shopUrl}">所有产品</a>
          </dd>
          <dd>
            <a href="/shop/notice/${shopUrl}">商家动态</a>
          </dd>
          <dd>
            <a href="/shop/brief/${shopUrl}">服务描述</a>
          </dd>

          <c:forEach var="productCategory" items="${productCategoryList}">
            <dd>
              <a href="/shop/${shopUrl}/${productCategory.categoryId}/0/0">${
                productCategory.category.title}(${productCategory.categoryNum})</a>
            </dd>
          </c:forEach>
          <dd class="label2-dd <c:if test="tailGoodsCount>0">classselect</c:if>">
            <a href="/shop/${shopUrl}/0/0/1">尾货(<span class="label2-num">${tailGoodsCount}</span>)
            </a>
          </dd>

          <dd class="label2-dd">
            <a href="/shop/${shopUrl}/card/businessCard">名片</a>
          </dd>
          <dd>
            <select onChange="js_sort(this.value);">
              <option value="0">选择排序规则</option>
              <option value="1">最近更新</option>
              <option value="2">人气产品</option>
              <option value="3">价格由高到低</option>
              <option value="4">价格由低到高</option>
              <option value="5">最新发布</option>
            </select>
          </dd>
        </dl>
      </h1>
    </div>
  </div>
  <!-- 产品列表 -->
  <div id="productlist">
    <div id="newsmessagebox"></div>
    <ul id="products">
      <c:forEach var="product" items="${paginationData.list}">
        <li <c:if test="${product.productStats.promotionWeight >0 }"> class="recomm"</c:if> >
          <span>
	        <table cellpadding="0" cellspacing="0" border="0">
	          <tr>
	            <td style="position: relative; display: inline-block" class="<c:if test="${product.categoryId ==12}">label-2</c:if>
	              <c:if test="${product.labelId==2 }">label-2</c:if>">
	              <a href="/product/${product.id }" target="_blank">
	                <img src="http://thumb.ximgs.net${fn:substringBefore(product.indexImage, '.')}_160x160.jpg" alt="${product.supplier.title}&${product.articleNumber}" /> 
	  	          </a>
	           </td>
	          </tr>
	        </table>
      	  </span>
          <strong>
	        <a href="/product/${product.id }">${product.supplier.title }&${product.articleNumber}</a> 
	        <c:if test="${product.productStats.promotionWeight>0 }"><img  src="/img/supplier/recomm.gif" title="推荐新款单品" align="absmiddle" /> </c:if> 
	      </strong>
          <label class="{${product.id }|encode_id}_price">${product.price }</label>
          <em class="{${product.id }|encode_id}_characters">${product.characters }</em>
          </li>
      </c:forEach>
      <!--------分页条-------->
      <%@include file="/jsp/common/pagination.jsp"%>
      <!--------分页条-------->
    </ul>
  </div>

  <!-- 页面底部 -->
  <div id="sitebody_bottom">
    <div id="sb_left">
      <img class="supplierlogo down" />
      <div id="sldown">
        <h3>
          <a href="/shop/${shopUrl}/">${supplier.title }</a>
        </h3>
        <p>
          手机：${supplier.user.mobile } / QQ：${supplier.qq }<br /> 地址：${supplier.address}<a name="downlist"></a>
        </p>
      </div>
    </div>
    <div id="sb_right">
      <img src="/img/supplier/site_renzhen.gif" />
    </div>
  </div>
  <!-- 私有的js -->
  <script type="text/javascript">
  function js_sort(val) {
        if(${tailGoodsCount}>0){
          window.location = "/shop/${shopUrl}/${categoryId}" + "/" + val + "/1";
        }else{
          window.location = "/shop/${shopUrl}/${categoryId}" + "/" + val + "/0";
        }
      }
  
		 function share(id) {
        new $.Message({
            title:'分享',
            ismask:true,
            icon:'none',
            content:'<iframe src="'+"/shop/supplier/" + id + '" width="505" frameborder="0" height="540"></iframe>',
      			js_sortcontent:'<iframe src="'+"/shop/supplier/" + id + '" width="505" frameborder="0" height="540"></iframe>',
            width:505,
            height:540,
            button:{ ok:false,cancel:false}
        });
    }
    </script>
</body>

</html>
