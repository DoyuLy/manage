<%@page import="java.awt.PageAttributes"%>
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!-- JSTL===========================================-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css"/>
<link rel="stylesheet" href="/css/userCenter/supplier/productList.css"/>

<!-- 页面标题==========================================-->
<title>用户中心-产品列表</title>

<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.min.js"></script>
      <script src="/resources/js/respond.min.js"></script>
      <script src="/resources/js/jquery.js"></script>
      <script src="/js/userCenter/productListView.js"></script>
    <![endif]-->
</head>
<body>

  <!-- 导航==========================================-->
  <%@include file="/jsp/common/nav.jsp"%>
  
  <!-- 内容==========================================-->
	<div class="content">
  
	  	<!-- 二级导航和左侧导航==========================================-->
		<%@include file="/jsp/userCenter/supplier/subNav.jsp"%>
		<div class="right-con">
			<!-- 搜索 -->
			<div id="search-div">
				<a href='/userCenter/supplier/productList' class="fast-rank <c:if test="${searchType == 'all'}">rank-active</c:if>"  >全部显示</a>
				<a href='/userCenter/supplier/productList/price' class="fast-rank <c:if test="${searchType == 'price'}">rank-active</c:if>" >商品价格</a>
				<a href='/userCenter/supplier/productList/createtime' class="fast-rank <c:if test="${searchType == 'createtime'}">rank-active</c:if>" >发布时间</a>
				<a href='/userCenter/supplier/productList/modifytime' class="fast-rank <c:if test="${searchType == 'modifytime'}">rank-active</c:if>" >刷新时间</a>
				<a href='/userCenter/supplier/productList/recommend' class="fast-rank <c:if test="${searchType == 'recommend'}">rank-active</c:if>" >推荐产品</a>
				<a href='/userCenter/supplier/productList/shelfon' class="fast-rank <c:if test="${searchType == 'shelfon'}">rank-active</c:if>" >上架产品</a>
				<a href='/userCenter/supplier/productList/shelfoff' class="fast-rank <c:if test="${searchType == 'shelfoff'}">rank-active</c:if>" >下架产品</a>
				<a href='/userCenter/supplier/productList/violation' class="fast-rank <c:if test="${searchType == 'violation'}">rank-active</c:if>" >违规产品</a>
				<a href="javascript:void(0)"  class="fast-rank rank-active btn sort-switch" >开启排序</a>
				<a href="javascript:void(0)" class="fast-rank rank-active searchselect " onclick="javascript:introJs().start();" data-step="6" data-intro="基本操作完毕！在此可重新观看排序教程！">排序引导</a>
			</div>
			<!-- 产品列表标题头部 -->
			<h5 class="search-boxs c-34 f16 text-left">
              <form action="/userCenter/supplier/productList/all">
	          	货号: 
	          	<input type="text" id="num" class="search-num" name="key" value="${key}">
	          	<button id="search" class="search-btns text-center"> 搜索 </button>
              </form>
	        </h5>
	        <!-- 热搜入口 -->
	        <p class="keywords f14">
				本周热门关键词：
				<a href="/search/firsthand-all-大货--1-0" target="_blank">大货</a>
				<a href="/search/firsthand-all-短靴--1-0" target="_blank">短靴</a>
				<a href="/search/firsthand-all-雪地靴--1-0" target="_blank">雪地靴</a>
				<a href="/search/firsthand-all-包退换--1-0" target="_blank">包退换</a>
				<a href="/search/firsthand-all-秋冬新品--1-0" target="_blank">秋冬新品</a>
				<a href="/search/firsthand-all-马丁靴--1-0" target="_blank">马丁靴</a>
				<a href="/search/firsthand-all-单鞋--1-0" target="_blank">单鞋</a>
				<a href="/search/firsthand-all-真皮--1-0" target="_blank">真皮</a>
				<a href="/search/firsthand-all-内增高--1-0" target="_blank">内增高</a>
				<a href="/search/firsthand-all-长靴--1-0" target="_blank">长靴</a>
				请根据实际情况填写关键词，违者必罚。
	        <!-- 产品列表 -->
	        <div class="list">
	        	<div class="tab-head">
	        		<span class="pro-total">您目前在售的商品列表(总计${paginationData.total}个产品)</span>
	        		<span class="pro-price">价格</span>
	        		<span class="pro-spend">最低零售价</span>
	        		<span class="pro-upload">发布时间</span>
	        	</div>
	        	<ul class="drag-ul">
	        		<c:forEach var="item" varStatus="status" items="${paginationData.list}">
						<%-- <c:if test="${item.state == 1}"> --%>
							<li class="liwist" data-productId="${item.id}">
								<c:choose>
									<c:when test="${item.indexImage != ''}">
										<a target="_blank" class="img-link" href='<c:if test="${item.id!=''}" >/product/${item.id}.go</c:if>'>
											<c:url value="${item.indexImage}" var="imgSrc" scope="session"></c:url>
											<img src="http://thumb.ximgs.net${fn:substringBefore(item.indexImage, '.')}_80x80.jpg"/>
										</a>
									</c:when>
									<c:otherwise>
										<a href="#" class="img-link" target="_blank"><img src="/images/load_img.gif"/></a>
									</c:otherwise>
								</c:choose>
								<div class="pro-msg">
									<div class="msg-show">
										<div class="pro-show">
											<div class="pro-num">
												<strong class="f14 normal">商品货号:</strong>
												<a class="f14" target="_blank" href="/product/${item.id}.go">
													<em>${item.articleNumber}</em>
													<i class="goods_id">${item.id}</i>
												</a>
												<c:choose>
													<c:when test="${item.state==0}">
														已下架,等待上架
													</c:when>
													<c:when test="${item.isDirectSale==1}">
														厂家直销供货款
													</c:when>
												</c:choose>
											</div>
											<div class="pro-moods">
												人气: ${item.productStats.totalperson} 
												淘宝: ${item.productStats.taobaoCountAlltime}
												下载: ${item.productStats.downCountAlltime}
											</div>
										</div>
										<span class="price-show f20 text-center" data-price="${item.price}">
											<c:if test="${item.price!=''}">&yen;${item.price}</c:if>
										</span>
										<!-- 建议零售价 -->
										<span class="price-spend f20 text-center">
                            <c:if test="${item.minSalePrice!=''}">
                                &yen;${item.minSalePrice}
                            </c:if>
										</span>
										<div class="time-msg">
											<p>发布：2015-10-15</p>
											<p>最近更新：2015-10-15</p>
										</div>
									</div>
                  <div style="margin-top: 20px;margin-left: 300px">
                    <a href="javacript:void(0)" class="up-stair" data-productId="${item.id}">上移</a>
                    <a href="javacript:void(0)" class="down-stair" data-productId="${item.id}">下移</a>
                     <a href="javacript:void(0)">请添加属性</a>
                     <select class="pro-label">
                     <option value="0">-标签</option>
                     <c:choose>
                      <c:when test="${item.labelId == 2 }">
                        <option value="2" selected="selected">尾货</option>
                      </c:when>
                      <c:otherwise>
                        <option value="2">尾货</option>
                      </c:otherwise>
                     </c:choose>
                     </select>
                    <a href="javacript:void(0)">分享</a>
                    <a href="/manage/supplier/editProduct/${item.id}">编辑</a>
                    <c:if test="${item.state==1}">
                      <a class="added">下架</a>
                    </c:if>
                    <c:if test="${item.state==0}">
                      <a class="added">上架</a>
                      <a class="added">删除</a>
                    </c:if>
                    <c:if test="${item.isHighlight==1}">
                      <a class="relative" data-relative="${item.isHighlight}">取消关联</a>
                    </c:if>
                    <c:if test="${item.isHighlight==0}">
                      <a class="relative" data-relative="${item.isHighlight}">关联</a>
                    </c:if>
                    <a href="javacript:void(0)" onclick="setTop(${item.id})">置顶</a>
                   </div>
								</div>
							</li>
						<%-- </c:if> --%>
					</c:forEach>
	        	</ul>
	        </div>
			<%@include file="/jsp/common/pagination.jsp"%>
		</div>
	</div>
	
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  <script src="/js/common/jquery-ui.min.js"></script>
<script type="text/javascript">
  //商品置顶
  function setTop(productId){
    $.ajax({
      type:"POST",
      url:"/userCenter/supplier/productSetTop",
      data:"productId="+productId,
      success:function(res){
        if(res.data == false){
          alert("置顶失败!");
        }else if(res.data == true){
          window.location.href="/userCenter/supplier/productList/all";
        }
      }
    });
  }

  //商品上架下架删除
  $('.added').click (function () {
	  var _this = $(this);
	  var flag;
		var productId = _this.closest('.liwist').attr('data-productid');
		var oprStr = _this.text();
		if (oprStr == '下架') {
			flag = 0;
		} else if (oprStr == '上架') {
			flag = 1;
		} else if (oprStr == '删除') {
			flag = -1;
		}
		$.ajax({
		      type:"POST",
		      url:"/userCenter/supplier/added",
		      data:{"productId":productId,"flag":flag},
		      success:function(res){
		        if(res.data == true){
		          	window.location.reload();
		        }else{
		          alert(data.msg);
		        }
		      }
		    });
  });

 	//关联与取消关联
 	$('.relative').click(function () {
 		var _this = $(this);
 		var productId = $(this).closest('.liwist').attr('data-productid');
 		var flag = parseInt($(this).attr('data-relative'));
 		flag = !flag+0;
 		GO2.ajax("/userCenter/supplier/highLight",
 				{"productId":productId,"flag":flag},
				'POST',
				function(res){
 					if(res.data === true){
 						if (flag == 0) {
 							_this.text('关联');
 							_this.attr('data-relative',0);
 						} else {
 							_this.text('取消关联');
 							_this.attr('data-relative',1);
 						}
		     	}else{
		      	alert(res.message);
		      }
			  }
		);
 		
 	});

 	//点击上移
 	$('.up-stair').click(function () {
 		var page = parseInt($('.page-active').children('a').text());
 		var goodsNum = $('.liwist').length;
 		var productId = $(this).attr('data-productId');
 		var productIds = [];
 		for (var i = 0;i < goodsNum;i++) {
 			productIds.push($('.up-stair').eq(i).attr('data-productId'));
 		}
 		var rank = productIds.indexOf(productId);
 		if (rank == 0) {
 			return;
 		}
 		var productIdMid = productIds[rank-1];
 		productIds[rank-1] = productId;
 		productIds[rank] = productIdMid;
 		var goodsId = productIds.toString();
 		sortProduct(goodsId,page,goodsNum,$(this),0);
 	});

 	//点击下移
 	$('.down-stair').click(function () {
 		var page = parseInt($('.page-active').children('a').text());
 		var goodsNum = $('.liwist').length;
 		var productId = $(this).attr('data-productId');
 		var productIds = [];
 		for (var i = 0;i < goodsNum;i++) {
 			productIds.push($('.up-stair').eq(i).attr('data-productId'));
 		}
 		var rank = productIds.indexOf(productId);
 		if (rank == goodsNum-1) {
 			return;
 		}
 		var productIdMid = productIds[rank+1];
 		productIds[rank+1] = productId;
 		productIds[rank] = productIdMid;
 		var goodsId = productIds.toString();
 		sortProduct(goodsId,page,goodsNum,$(this),1);
 	});

	//排序提交后台,三个参数goodsId:商品id字符串，“，”隔开,例如"123,234,345" page:页数 goodsNum 产品数
 	function sortProduct(goodsId,page,goodsNum,_this,flag){
		GO2.ajax("/userCenter/supplier/productSort",
				{"goodsId":goodsId,"page":page,"goosNum":goodsNum},
				'',
				function(res){
			       //操作成功后返回字符串success
			       if(res.data == true){
			    	  var proBox = _this.closest('.liwist');
			    	  if (!flag) {
				 		  proBox.prev('.liwist').before(proBox);
			    	  } else {
			    		  proBox.next('.liwist').after(proBox);
			    	  }
			       }
				}
		);
	}

	//输入最低零售价
	$('.price-spend').click(function () {
		var productId = $(this).closest('.liwist').attr('data-productid');
		var price = parseFloat($(this).prev('.price-show').attr('data-price'));
		price = parseFloat(price);
		var param = {'productId':productId, 'price':price, '_this':$(this)};
		GO2.prompt('请输入最低零售价',
				function (result, param) {
					if (result === null) {
						return;
					}
					if (result === '') {
						result = 0;
					}
					var minPrice = parseFloat(result);
					if (isNaN(minPrice)) {
						GO2.wrong('输入有误，请重新输入！');
						return;
					}
					if (param.price > minPrice && minPrice != 0) {
						GO2.wrong('最低零售价不能低于批发价！');
						return;
					}
					minSalePriceUpdate(param.productId, param.price,minPrice, param._this);
				},
				param
		);
	});

	//更新最低零售价
 	function minSalePriceUpdate(productId,price,minPrice,_this){
		GO2.ajax("/userCenter/supplier/updateMinPrice",
		  {"productId":productId,"price":price,"minPrice":minPrice},
		  "POST",
		  function (res) {
		      if (res.data == true) {
		    	   if (minPrice === 0) {
		    		   _this.text('');
		    	   } else {
		    		   _this.text("\u00A5"+minPrice.toFixed(1));
		    	   }
		    	   GO2.tips('最低零售价设置成功！', 800);
		       } else {
		         alert(res.message);
		       }
		     }
		  );
 	}

	//设置产品标签
	$('.pro-label').change(function () {
		var productId = $(this).parent().find('.up-stair').attr('data-productId');
		var label = parseInt($(this).val());
		GO2.ajax('/userCenter/supplier/changeLabel',
				{'productId':productId, 'label':label},
				'',
				function (res) {
					if (res.data == true) {
						GO2.tips('ok',800);
					} else {
						GO2.alert(res.message);
					}
				}
		);
	});
	
	//文档加载完成自执行
	$(function () {
		
		//初始化拖动排序
		$('.drag-ul').sortable({
		    group: 'drag_ul',
		    stop: function () {
		    	var page = parseInt($('.page-active').children('a').text());
		 			var liwist = $('.liwist');
		    	var goodsNum = liwist.length;
		      var atnum = [];
		      for (var i = 0;i < goodsNum;i++) {
		    	  atnum.push(liwist.eq(i).attr('data-productid'));
		      }
		      var goodsId = atnum.toString();
					GO2.ajax("/userCenter/supplier/productSort",
									{"goodsId":goodsId,"page":page,"goosNum":goodsNum},
									'',
									function (res) {
										if(res.data == true){
							    		GO2.tips('调整排序成功！', 800);
									  } else {
										  GO2.wrong(res.message);
									  }
									}
					)
		  }
		});
		//默认关闭拖动排序
		$('.drag-ul').sortable('disable');
		//手动开启、关闭拖动排序功能
		$('.sort-switch').click(function () {
			var _this = $(this);
			if (_this.hasClass('opened')) {
				$('.drag-ul').sortable('disable');
				_this.removeClass('opened');
				_this.text('开启排序');
			} else {
				$('.drag-ul').sortable('enable');
				_this.addClass('opened');
				_this.text('关闭排序');
			}
		});
		
		
		
		
		
		
	});
	
 	
 	
</script>
</body>
</html>
