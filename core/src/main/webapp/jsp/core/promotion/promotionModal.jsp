<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<p>设置须知</p> 
<ol>  
    <li>正在推荐位广告投放中的产品将不能再次设置到其他广告上</li>    
    <li>设置投放中的广告产品后，网站首页有缓存，通常可能需要在6-12分钟才能生效,</li>                 
</ol>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery.min.js"></script>
<script type="text/javascript">
    window.onload = function() {
     };
     $(function(){
       $("form :input.required").each(function(){
         var $required = $("<strong class='high'> *</strong>"); //创建元素
         $(this).parent().append($required); //然后将它追加到文档中
     });
     	//文本框进入焦点后
      $('form :input:eq(1)').mouseenter(function(){
        var $parent = $(this).parent();
        //验证
        if( $(this).is('.image') ){
             $parent.find('span').remove();
        }
   });
       //文本框失去焦点后
       $('form :input:eq(1)').mouseleave(function(){
         var $parent = $(this).parent();
         var imageHide = $('.imageHide').val();
         //验证
         if( $(this).is('.image') ){
                if( this.value==imageHide ){
                    var okMsg = '输入正确.';
                    $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
                }else{
                  var errorMsg = '请输入正确的验证码.';
                  $parent.append('<span class="formtips onError" style="color:red">'+errorMsg+'</span>');
                }
         }
    });
       //提交，最终验证。
        $('#send').click(function(){
          if($('.image').val()== $('.imageHide').val()){
            document.getElementById("formid").submit();
            System.exit(0);
          }
        });
     })
</script>
<form id="formid" method="post" action="/promotion/regPromotion?userId='12'&id='21'"  >        
    <label>请选择产品</label>
    <img src="identifyImg" id="createCheckCode">
    <input type="hidden" class="imageHide" value="${contents}">
    <input type="text" class="image" value="">
    <input type="button" id="send" value=" 提交 ">
</form>
