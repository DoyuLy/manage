<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="my" uri="http://www.changtusoft.cn/test/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<script type="text/javascript" src="/js/common/jquery-1.9.1.min.js"></script>
<script charset="utf-8" src="/js/background/supplier/editor/kindeditor-min.js"></script>
<script charset="utf-8" src="/js/background/supplier/zh_CN.js"></script>
<script type="text/javascript" src="/js/background/supplier/handlers.js"></script>
<script type="text/javascript" src="/js/common/go2.js"></script>
<script type="text/javascript" src="/resources/js/zClip.js"></script>
<script>
	$(function(){ link.init() })
	var link = {
		editor: null,
		init: function(){
			var _this = this;
			KindEditor.ready(function(K) {
				_this.editor = K.create('textarea[name="ProductMemo"]', {
					resizeType : 1,	
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'source','|','forecolor', 'hilitecolor','fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'image']
				});
			});
			
			$('#cp_btn').zclip({
                path: '/resources/js/ZeroClipboard.swf',
                copy: function() {
                    return GO2.htmlDecode(_this.editor.html());
                },
                beforeCopy: function() {
                },
                afterCopy: function(e1) {
                    alert("已经复制到剪贴板！")
                }
            });
		}
	}
</script>
<style type="text/css">
body{margin:0;padding:0;font-family:"微软雅黑";line-height:16px;background:#F5F5F5;}
#copyproduct{
	width:998px;
	margin:10px auto;
	padding-bottom:10px;
	border:5px solid #ECB2B2;
	background:#fff;
	overflow:hidden;
}
#copyproduct h1{
	margin:0;
	margin-top:10px;
	padding:6px;
	padding-left:8px;
	font-size:16px;
}
#copyproduct ul{
	margin:0;
	padding:10px;
	padding-right:0;
	margin-left:9px;
	margin-top:10px;
	margin-bottom:10px;
	width:910px;
	border:1px solid #e0e0e0;
	list-style-type:none;
	overflow:hidden;
}
#copyproduct ul li{
	float:left;
	width:120px;
	height:120px;
	margin-right:10px;
	margin-bottom:10px;
	text-align:center;
	overflow:hidden;
}
#copyproduct ul li img{
	height:120px;
}
#copyproduct #cp_btn{
	float:left;
	width:163px;
	height:42px;
	margin-left:7px;
	margin-bottom:10px;
	background:url(/img/copyproduct_button.gif) no-repeat;
}
#copyproduct em{
	float:left;
	font-size:15px;
	font-style:normal;
	color:#999;
	padding-left:10px;
	padding-top:10px;
}
#copyproduct label{
	float:left;
	margin-left:9px;
}
#copyproduct textarea{
	width:972px;
	height:650px;
}
</style>
</head>
<body>
<div id="copyproduct">
	<h1>下载首图（图片上单击鼠标右键选择“图片另存为...”，可下载全尺寸首图）</h1>
	<ul>
		<c:forEach var="img" items="${imgsArr}" end="34">
			<li><img src="${img}"></li>
		</c:forEach>
	</ul>
	<a href="javascript:void(0)" id="cp_btn"></a><em>请注意，复制下来的内容为代码模式，在淘宝上需要选择为代码模式并粘贴才行！</em>
	<form name="addproduct" style="margin:0;width:752px;">
	<label><textarea name="ProductMemo" id="ProductMemo">${product.productMeta.descriptionBin}</textarea></label>
	</form>
</div>
</body>
</html>