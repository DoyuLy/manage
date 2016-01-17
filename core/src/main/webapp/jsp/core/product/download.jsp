<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="my" uri="http://www.changtusoft.cn/test/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
body {margin: 0;}
#islink{margin:0 auto;margin-top:15px;width:770px;padding:0;overflow:hidden;font-family:"微软雅黑";text-decoration:none;}
#islink ul{float:left;margin:0;padding:0;padding-bottom:10px;list-style:none;border:solid #ddd;border-width:1px 0;}
#islink ul li{float:left;display:inline;width:190px;height:270px;margin:0;margin-left:2px;padding-bottom:10px;overflow:hidden;}
#islink ul li img{border:none;}
#islink ul li span{float:left;width:160px;height:160px;padding:14px;padding-right:4px;margin:5px;text-align:center;}
#islink ul li table{background:#fff;width:160px;height:160px;}
#islink ul li strong{float:left;font-size:12px;font-weight:normal;color:#333;width:160px;margin:0 10px;margin-right:9px;height:20px;line-height:16px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;}
#islink ul li strong a{text-decoration:none;}
#islink ul li label{float:left;font-size:18px;font-family:Georgia;font-weight:bold;color:#080;margin:5px 10px;margin-right:9px;width:160px;}
#islink ul li code{float:left;font-size:15px;font-weight:bold;color:#080;margin:5px 10px;margin-right:9px;width:160px;}
#islink ul li em{float:left;width:178px;margin:0px 10px;font-style:normal;font-size:12px;color:#666;font-weight:normal;}
#islink ul .recomm{color:#ff0000;}
#islink ul .recomm a{color:#ff0000;}
#gonggao_div {background-color: #367DB1;width: 100%;}
#gonggao {display: block;width: 1195px;margin: 0 auto;font-size: 12px;color: white;font-family: 'SimSun','宋体';line-height: 20px;margin-bottom: 5px;}
</style>
<title>download</title>
</head>
<body>
<div id="gonggao_div">
	<p id="gonggao">近期由于数据量巨大,导致一小部分发布无法正常,如果您在使用“发布到淘宝”或”下载“功能时遇到无图片、无内容的情况，请关闭该页，重新发布一次，我们会尽快的处理，给您带来不便，敬请谅解，感谢您的理解和支持。</p>
</div>
<div id="link_container" style="padding:20px;border:1px solid #ddd;font-size:16px;font-weight:bold;margin:0 auto;width:500px;font-family:微软雅黑;">
	<c:if test="${curProduct != null}">
		数据包加载成功，如果没有提示下载，请点击下方下载连接。<br /><br /><br />
		<span style="color:#999;font-size:12px;">压缩包类型：ZIP，文件大小：{$file_size}M</span>
		<br /><br />
		<a href="#" id='changeDownload' mytitle='${pid}' mylink='http://dl.f.go2.cn${curProduct.file}'>点击下载本款</a>
	</c:if>
	<c:if test="${curProduct == null}">
		<img src="/img/ajax-loader.gif">正在努力为您准备数据包，请稍后……
	</c:if>
</div>
<div id="islink">
	<ul>
		<c:if test="${products!=null && products.size()>0 }">
		  <c:forEach var="product" items="${products}">
			<li>
				<span>
				<table cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td><a href="/product/${product.id}" target="_blank"><img src="http://thumb.ximgs.net${fn:substringBefore(product.indexImage, '.')}_160x160.jpg" alt="{$product->supplier_title}&{$product->article_number}" /></a></td>
					</tr>
				</table>
				</span>
				<strong><a href="/product/${product.id}" target="_blank">${product.supplier.title}&${product.articleNumber}</a>
				
				</strong>
				<label class="${my:encodeId(product.id)}_price"></label>
				<em class="${my:encodeId(product.id)}_characters"></em>
			</li>
		  </c:forEach>
		</c:if>
	</ul>
</div>	
<script type="text/javascript" src="/resources/js/jquery.js"></script>
<script type="text/javascript" src="/js/common/go2.min.js"></script>
<script type="text/javascript"> window.pid = ${pid}</script>
<script type="text/javascript">
	$(function(){
		download.init();
	});
	
	var download = {
		init: function(){
			if(window.pid)
				this.createUrl();
		},
		createUrl: function(){
			var html = '数据包加载成功，如果没有提示下载，请点击下方下载连接。<br />'+
			//'<span style="font-size:14px;font-weight:normal;color:#f00;">你已经下载过本产品了，确认重新下载吗？上次下载时间：{$last_download}！</span>'+
			'<br/><br/>'+
			'<span style="color:#999;font-size:12px;">压缩包类型：zip，文件大小：{0}</span>'+
			'<br/><br/>'+
			'<a href="#" id="changeDownload" mytitle="{1}" mylink="{2}">点击下载本款</a>';
			
			$.ajax({
				url:"/product/getfile/"+ window.pid +"?t=" + Math.random(),
				async:false,
				contentType: "application/x-www-form-urlencoded; charset=utf-8",
				success:function(data){
					//$("#link_container").html(data);
					if(data){
						data = JSON.parse(data);
						if(data.fileInfo && JSON.parse(data.fileInfo)){
							var size = GO2.TransferSize(JSON.parse(data.fileInfo).size)
							$('#link_container').html(html.format(size, window.pid, 'http://dl.f.go2.cn' + data.file));
						}
						
					}
				},
				error: function(data){
					if(data.responseText)
						alert(data.responseText)
				}
			});
		}
	}
</script>
</body>
</html>