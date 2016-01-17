<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <#setting number_format = "#" />
  <div class="W sub-search mt15 clearfix">
        <div class="s_sub-ibute">
            <dl class="f12">
                <dt class="f14 c7e fw">属性</dt>
                <dd class="s_ibute-at">
                  <a href="javascript:;">价格范围</a>
                    <ul class="s_ibute-more f12">
                        <li><a href="javascript:;" data-id="price:x30">30元以下</a></li>
                        <li><a href="javascript:;" data-id="price:30x60">30-60元</a></li>
                        <li><a href="javascript:;" data-id="price:100x150">60-100元</a></li>
                        <li><a href="javascript:;" data-id="price:150x200">150-200元</a></li>
                        <li><a href="javascript:;" data-id="price:200x300">200-300元</a></li>
                        <li><a href="javascript:;" data-id="price:300x">300元以上</a></li>
                    </ul>
                </dd>
                <dd class="s_ibute-at">
                  <a href="javascript:;">尺码</a>
                    <ul class="s_ibute-more f12">
                        <li><a href="javascript:;" data-id="size:28">28</a></li>
                        <li><a href="javascript:;" data-id="size:29">29</a></li>
                        <li><a href="javascript:;" data-id="size:30">30</a></li>
                        <li><a href="javascript:;" data-id="size:31">31</a></li>
                        <li><a href="javascript:;" data-id="size:32">32</a></li>
                        <li><a href="javascript:;" data-id="size:33">33</a></li>
                        <li><a href="javascript:;" data-id="size:34">34</a></li>
                        <li><a href="javascript:;" data-id="size:35">35</a></li>
                        <li><a href="javascript:;" data-id="size:36">36</a></li>
                        <li><a href="javascript:;" data-id="size:37">37</a></li>
                        <li><a href="javascript:;" data-id="size:39">39</a></li>
                        <li><a href="javascript:;" data-id="size:40">40</a></li>
                        <li><a href="javascript:;" data-id="size:41">41</a></li>
                        <li><a href="javascript:;" data-id="size:42">42</a></li>
                        <li><a href="javascript:;" data-id="size:43">43</a></li>
                    </ul>
                </dd>
                <#list props as prop> 
                <dd class="s_ibute-at">
                    <a href="javascript:;" class="">${prop.name}</a>
                    <ul class="s_ibute-more f12">
                      <#if (prop.prop_values.prop_value?size > 0)  >
                         <#list prop.prop_values.prop_value as prop_value>
                          <li><a href="javascript:;" data-id="${prop.pid}:${prop_value.vid}">${prop_value.name}</a></li>
                         </#list> 
                      </#if>
                    </ul>
                </dd>
                </#list> 
            </dl>
        </div>
    </div>
   <script type="text/javascript">
     if(typeof jQuery == 'undefined'){
       var addFiler = document.createElement('script');        //创建标签
       addFiler.setAttribute("type", "text/javascript");           //定义属性type的值为text/javascript
       addFiler.setAttribute("src", "/resources/js/jquery.js");                   //文件的地址
  
       if (typeof addFiler != "undefined") {
         document.getElementsByTagName("head")[0].appendChild(addFiler);
       }
       else{
         alert('应用组件加载错误，部分功能可能无法使用，请刷新再试');
       }
   	 }
     
     setTimeout(function(){
       $('.s_ibute-more a').click(function(){
         var props = $(this).attr('data-id');
         goSearch('','','',props,'');
       });
     },1000);
     
     
     function goSearch(channel, cid, keyword, props, pid){
      var url = "/search?channel=" + channel + '&cid=' + cid + '&keyword=' + keyword + '&props=' + props + '&pid=' + pid;
       
      window.open(url); 
     };
   </script>
  