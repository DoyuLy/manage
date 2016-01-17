<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />
<link rel="stylesheet" href="/css/userCenter/supplier/selfPublish.css" />

<!-- 页面标题==========================================-->
<title>用户中心-自助发布产品</title>

<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script type="text/javascript" src="/resources/resources/html5shiv.min.js"></script>
    <script type="text/javascript" src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<!-- 导航==========================================-->
	<%@include file="/jsp/common/nav.jsp"%>

	<!-- 内容==========================================-->
	<div class="content">

		<!-- 二级导航和左侧导航==========================================-->
		<%@include file="/jsp/userCenter/supplier/subNav.jsp"%>
		<div class="right-con" id="mbox-right">
			<form action="" method="post" action="/userCenter/supplier/selfPublish/upload" name="modproduct" onsubmit="return selfPublishView.Submit();">
            <input type="hidden" name="index_image" value="" />
            <p> 
                <label>商品类别</label>
                <span>
	                <em>
	                	<select name="category_id" style="padding: 3px; width: 100px;">
							<c:forEach var="item" varStatus="status" items="${data.resultVo.result}">
								<c:if test="${item.id != 12 }">
									<option value="${item.id}">${item.title}</option>
								</c:if>
							</c:forEach>
						</select>
					</em>
                </span>
            </p>
            <p> 
                <label>商品货号<em>请注意商品货号的唯一性！</em></label>
                <span><em><input type="text" name="ItemID" size="15" maxlength="15" value="" id='checkArticleNumber' /></em></span><span class="stau3" id="articleNumberSpan" >输入商品货号</span>
            </p>
            <p> 
                <label>材质特点<em>请尽量简短，如：真皮！</em></label>
                <span><em><input type="text" name="goods" size="30" maxlength="30" value="" /></em></span>
            </p>
            <!--p> 
                <label>产品产地<em>请如实描述产品产地，如：成都金花、成都西河、广东惠东、浙江温州、浙江台州</em></label>
                

                <span><em><input type="text" name="productaddress" size="30" maxlength="5" value="" /></em></span>
            </p-->
            <p> 
                <label>尺码范围<em>每个尺码用逗号隔开，如：34,35,36,37,38,39</em></label>
                <span><em><input type="text" name="size" size="40" maxlength="150" value="" /></em></span>
            </p>
            <p> 
                <label>产品首图<em>尺寸推荐800*800，用于淘宝商品首图！只支持jpg格式</em></label>
                <!--
                <span>
                    <em><img {if !empty($product)} {if $product->index_image neq ''} src="{$smarty.const.THUMB_URL_PREFIX}/{$product->index_image|thumb_img_replace:'160x160'}"{/if}{else}src="/images/load_img.gif"{/if} id="iPicture" style="border:1px solid #ccc;max-width:160px;max-height:160px;" /></em>
                    <span id="spanButtonPlaceHolder"></span>
                </span>-->
                <span>
                    <em><imgsrc="/images/load_img.gif" id="iPicture" style="border:1px solid #ccc;max-width:160px;max-height:160px;" /></em>
                    <span id="spanButtonPlaceHolder"></span>
                </span>                
            </p>
            <p> 
                <label>批发价格</label>
                <span><em><input type="text" name="price" size="16" value="" /> 元</em></span>
            </p>
            <p> 
                <label>产品数据包<em>压缩文件格式，所有本产品图片打包！</em></label>
                <span style="padding-left:0;">
                    <em><input type="text" name="file" size="35" value="" /></em>
                   <span id="spanButtonPlaceHolder_zip"></span>
                </span>
            </p>
            <div id="pshow"> 
                <label>商品详情<em>商品基本信息描述！也可以上传图片方便买家察看！</em></label>
		
                <span style="float:left;margin:6px 0;">
                	<textarea name="ProductMemo" id="ProductMemo" style="width:774px;"></textarea>
                </span>
            </div>
            <div class="btnbox"> 
                <span><input type="submit" class="regbutton f16 bold" value="确认并发布"/></span>
            </div>
        </form>
		</div>
	</div>

	<!-- 页脚==========================================-->
	<%@include file="/jsp/common/footer.jsp"%>

	<!-- 私有js==========================================-->
 	<script type="text/javascript" charset="utf-8" src="/resources/js/editor/kindeditor-min.js"></script>
	<script type="text/javascript" charset="utf-8" src="/resources/js/editor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="/resources/js/swfupload.js"></script>
	<script type="text/javascript" src="/resources/js/handlers.js"></script>
	<script type="text/javascript" src="/js/common/request.js"></script>
	<script type="text/javascript" src="/js/userCenter/selfPublishView.js"></script>
</body>
</html>