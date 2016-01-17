<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css"/>
<link rel="stylesheet" href="/css/userCenter/seller/downloadSupplier.css"/>
<link rel="stylesheet" href="/css/userCenter/seller/blackList.css" />

<!-- 页面标题==========================================-->
<title>下载过的厂家</title>
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
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
	<%@include file="/jsp/userCenter/seller/subNav.jsp"%>
    <div class="right-con">
		<h6>下载过产品的厂家名单 ( 总计：${dowloadNum}个厂家 )</h6>
         <ul>
           <li id="dltitle">
               <strong class="tab-title num-title">序号</strong>
               <label class="tab-title name-title">厂家名称</label>
               <label class="tab-title phone-title">手机号</label>
               <label class="tab-title qq-title">腾讯QQ</label>
               <em class="tab-title addr-title">地址</em>
               <span class='tab-title number-title'>代理</span>
               <span class='tab-title ope-title'>加为黑名单</span>
           </li>
           
           <c:forEach var="downloadSupplier" items="${paginationData.list}"  varStatus="status">        
             <li class="one-con" data-id="${downloadSupplier.supplierUserId }">
               <strong class="tab-con num-title">${status.index + 1}.</strong>
               <label class="tab-con name-title"><a href="/shop/${downloadSupplier.site.subdomain }" target="_blank" title="${downloadSupplier.supplier.title }">${downloadSupplier.supplier.title }</a>&nbsp;</label>
               <label class="tab-con phone-title">${downloadSupplier.user.mobile }&nbsp;</label>
               <label class="tab-con qq-title">${downloadSupplier.supplier.qq }&nbsp;</label>
               <em class="tab-con addr-title">${downloadSupplier.supplier.address }&nbsp;</em>
               <span class="tab-con number-title">${downloadSupplier.downloadProductNum }款&nbsp;</span>
               <span class="tab-con ope-title add_black" lang="46424">
               <c:choose>
               <c:when test="${downloadSupplier.sellerBlackList.id==null}">
                <a class="add-blackList" href="javascript:void(0)">加为黑名单</a>
               </c:when>
               <c:otherwise>
               <lable>已添加黑名单</lable>
               </c:otherwise>
               </c:choose>
            
               </span>
             </li>
           </c:forEach>
          
           <!--------分页条-------->
             <%@include file="/jsp/common/pagination.jsp"%>
           <!--------分页条-------->    
               
         </ul>

                        
    </div>
    
  </div>
  
  <!-- 添加黑名单弹出层 -->
  <div id="main">
    <div id="fullbg"></div>
    <div id="dialog">
      <p class="close">
        <a href="" onclick="blackListModal.closeBox()">关闭</a>
      </p>
      <div id="b"></div>
    </div>
  </div>
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  <script type="text/javascript" src="/js/userCenter/blackListModal.js"></script>
  
  <script type="text/javascript">
    $('.add-blackList').on('click', function() {
      var supplierId=$(this).parents('li').data('id');
      var supplierTitle=$(this).parents('li').find('label').find('a').attr('title');
      blackListModal.modal(supplierId,supplierTitle);
    });
  </script>
</body>
</html>