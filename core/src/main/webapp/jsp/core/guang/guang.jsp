<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 私有样式==========================================-->
<link rel="stylesheet" href="/css/core/guang/guang.css" />

<!-- 页面标题==========================================-->
<title>逛逛</title>

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
  <!-- <div class="content"> -->
        <a id="zhuanti_link" href="/special_new/display/50" target="_blank">
            <img id="zhuantihui_int" src="http://special.ximgs.net/special/50/index_search_sp_50.jpg">
        </a>
       <div id="order">
            <span class="rank_title"></span>
            <span class="det_message clicked" onclick="orderby('none')" style="border-top-left-radius:2px;border-bottom-left-radius:2px;">默认</span>
            <span class="det_message" onclick="orderby('new')">新款</span>
        <!--<span class="det_message" onclick="orderby('like')">喜欢</span>-->
            <span class="det_message" onclick="orderby('hot')" style="border-top-right-radius:2px;border-bottom-right-radius:2px;">热销</span>
            <span class="rank_title price">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span class="det_price pr_clicked" onclick="chose_price(0.0)" style="border-top-left-radius:2px;border-bottom-left-radius:2px;">全部</span>
            <span class="det_price" onclick="chose_price(1.0)">0~100</span>
            <span class="det_price" onclick="chose_price(2.0)">101~200</span>
            <span class="det_price" onclick="chose_price(3.0)">201~500</span>
            <span class="det_price" onclick="chose_price(4.0)" style="border-top-right-radius:2px;border-bottom-right-radius:2px;">500元以上</span>
        </div>
        <div class="chose">
            <span id="condition">已选条件：</span>
            <div id="kinddisplay">
                  <span class="choose_con margin_title">类型：</span>
                  <span class="choose_con"></span>
                  <p class="choose_con closedx" onclick="close_kind()">&times;</p>
            </div>
            <div id="popdisplay">
                  <span class="choose_con margin_title">流行元素：</span>
                  <span class="choose_con"></span>
                  <p class="choose_con closedx" onclick="close_props()">&times;</p>
            </div>
          </div>
  
    <div id="container" style="width: 1200px; margin-left: 60.5px; height: 2484px;">
        <div class="box" style="opacity: 1;">
          <div class="pic props" >
            <p class="title_kindpop">
              <img src="http://www2.cn/images/marketing/star.png">当季热卖
            </p>
            <div>
                <c:if test="${caregorysMap['乐福鞋']>0}">
                  <span class="rank_click rank_kind" onclick="chose_kind('乐福鞋')">乐福鞋</span>
                </c:if>
                <c:if test="${caregorysMap['平底鞋']>0}">
                 <span class="rank_click rank_kind" onclick="chose_kind('平底鞋')">平底鞋</span>
                </c:if>
                <c:if test="${caregorysMap['1']>0}">
                  <span class="rank_click rank_kind" onclick="chose_kind('凉鞋')">凉鞋</span>
                </c:if>
                <c:if test="${caregorysMap['2']>0}">
                  <span class="rank_click rank_kind" onclick="chose_kind('拖鞋')">拖鞋</span>
                </c:if>
                <c:if test="${caregorysMap['3']>0}">
                  <span class="rank_click rank_kind" onclick="chose_kind('低帮鞋')">低帮鞋</span>
                </c:if>
                <c:if test="${caregorysMap['4']>0}">
                 <span class="rank_click rank_kind" onclick="chose_kind('靴子')">靴子</span>
                 </c:if>
                 <c:if test="${caregorysMap['5']>0}">
                  <span class="rank_click rank_kind" onclick="chose_kind('高帮鞋')">高帮鞋</span>
                </c:if>
                <c:if test="${caregorysMap['6']>0}">
                  <span class="rank_click rank_kind" onclick="chose_kind('帆布鞋')">帆布鞋</span>
                </c:if>
                <c:if test="${caregorysMap['7']>0}">
                  <span class="rank_click rank_kind" onclick="chose_kind('雨鞋')">雨鞋</span>
                </c:if>
                <c:if test="${caregorysMap['高跟鞋']>0}">
                  <span class="rank_click rank_kind" onclick="chose_kind('高跟鞋')">高跟鞋</span>
                </c:if>
                <c:if test="${caregorysMap['厚底鞋']>0}">
                  <span class="rank_click rank_kind" onclick="chose_kind('厚底鞋')">厚底鞋</span>
                </c:if>
            </div>
            <p class="title_kindpop">
              <img src="http://www2.cn/images/marketing/shoe.png">流行元素
            </p>
            <span class="rank_click rank_pop" onclick="chose_props('松糕')">松糕</span>
            <span class="rank_click rank_pop" onclick="chose_props('防水台')">防水台</span>
            <span class="rank_click rank_pop" onclick="chose_props('一字型')">一字型</span>
            <span class="rank_click rank_pop" onclick="chose_props('人字鞋')">人字鞋</span>
            <span class="rank_click rank_pop" onclick="chose_props('尖头')">尖头</span>
            <span class="rank_click rank_pop" onclick="chose_props('绑带')">绑带</span>
            <span class="rank_click rank_pop" onclick="chose_props('PU')">PU</span>
            <span class="rank_click rank_pop" onclick="chose_props('镂空')">镂空</span>
          </div>
        </div>
    
    
      <c:forEach items="${guangs}" var="guang">
        <div class="box" style="opacity: 1;">
          <div class="pic">
            <a href ="/product/${guang.productId}" target="_blank"><img class="img"  src="http://starshow.ximgs.net/images/${guang.productId}.jpg" /></a>
            <span class="pro_price">&yen;${guang.price}</span>
            <p class="pro_number">${guang.title}&amp;${guang.articleNumber}</p>
            <p class="characters">${guang.characters }</p>
            <p class="pro_props">
             <span  class="like" data_isLike='${guang.isLike}' productId='${guang.productId}'>
                <span><img src="http://www2.cn/images/xin.png" alt="" />
                   <c:if test="${guang.isLike}">已喜欢</c:if>
                   <c:if test="${!guang.isLike}">喜欢</c:if>
                </span>
              </span>
              <span  class="like_count">${guang.likeNum}</span>
            <span class="down">下载量（${guang.downCountAlltime }）</span> 
          </p>
          <div class="comment">
            <hr />
            <img class="face" src="http://www2.cn/images/face/${guang.face}" width="36" height="36" />
            <span class="name">${guang.name}</span>
            <p class="content1">${guang.content}</p>
          </div>
          </div>
        </div>
      </c:forEach>
    </div>
    <p id="loading_tips"><img src="http://www2.cn/images/guang_loading.gif"></p>
  <!-- </div> -->
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  <script type="text/javascript">
    //初始化当即热卖种类
    var init_kind = '${guang.categoryId}';
    if(!isNaN(init_kind)){
      switch(init_kind){
        case '1' :
              init_kind = '凉鞋';
          break;
        case '2' :
          init_kind = '拖鞋';
          break;
        case '3' :
          init_kind = '低帮鞋';
          break;
        case '4' :
          init_kind = '靴子';
          break;
        case '5' :
          init_kind = '高帮鞋';
          break;
        case '6' :
          init_kind = '帆布鞋';
          break;
        case '7' :
          init_kind = '雨鞋';
          break;
        case '8' :
          init_kind = '乐福鞋';
          break;
        case '9' :
          init_kind = '平底鞋';
          break;
        case '10' :
          init_kind = '高跟鞋';
          break;
        case '11' :
          init_kind = '厚底鞋';
          break;
        default :
          init_kind = '';
          break;
      }
    }

    if(init_kind){
      $(".chose").css("display","block");
      $('.rank_kind').removeClass('kind_click');
      $(".rank_kind:contains("+init_kind+")").addClass('kind_click');
      $('#kinddisplay').css('display','block');
      $(".choose_con").eq(1).text(init_kind);
    }

    //初始化流行元素
    var init_props = '${guang.props}';
    if(!isNaN(init_props)){
      switch(init_props){
        case '1' :
          init_props = '松糕';
          break;
        case '2' :
          init_props = '防水台';
          break;
        case '3' :
          init_props = '一字型';
          break;
        case '4' :
          init_props = '人字鞋';
          break;
        case '5' :
          init_props = '尖头';
          break;
        case '6' :
          init_props = '绑带';
          break;
        case '7' :
          init_props = 'PU';
          break;
        case '8' :
          init_props = '缕空';
          break;
        default :
          init_kind = '';
          break;
      }
    }
    
    if(init_props){
      $(".chose").css("display","block");
      $('.rank_pop').removeClass('pop_click');
      $(".rank_pop:contains("+init_props+")").addClass('pop_click');
      $('#popdisplay').css('display','block');
      $('#popdisplay .choose_con').eq(1).text(init_props);
    }
    
    //排序字段
    var order = '${guang.order}';
    order_case(order);
    function order_case(order){
      $('.det_message').removeClass('clicked');
      if(order=='new') {
        $('.det_message').eq(1).addClass('clicked');
      }else if(order=='like'){
        $('.det_message').eq(2).addClass('clicked');
      }else if(order=='hot'){
        $('.det_message').eq(2).addClass('clicked');
      }else{
        $('.det_message').eq(0).addClass('clicked');
      }
    }
    
    
    //价格反选
    var price_num = '0.0';
    if('${guang.price}'!=''){
      price_num = '${guang.price}';
    }
   
    $('.det_price').removeClass('pr_clicked');
    $('.det_price').eq(price_num).addClass('pr_clicked');
      
    
    //当季热卖选择
    function chose_kind(kind){
      $('.rank_kind').removeClass('kind_click');
        $(".rank_kind:contains("+kind+")").addClass('kind_click');
        $('#kinddisplay').css('display','block');
        $(".choose_con").eq(1).text(kind);
        jump();
    }

    //取消当季热卖选择
    function close_kind(){
      $('#kinddisplay').css('display','none');            
        $('.rank_kind').removeClass('kind_click');
        $(".choose_con").eq(1).text('');
        jump();
    }

    //流行元素选择
    function chose_props(props){
      $('.rank_pop').removeClass('pop_click');
        $(".rank_pop:contains("+props+")").addClass('pop_click');
        $('#popdisplay').css('display','block');
        $('#popdisplay .choose_con').eq(1).text(props);
        jump();
    }

    //取消流行元素选择
    function close_props(){
      $('#popdisplay').css('display','none');
        $('.rank_pop').removeClass('pop_click');
        $('#popdisplay .choose_con').eq(1).text('');
        jump();
    }

    
		//排序(默认，新款,热销)
    function orderby( type ){
      order_case(type);
      jump();
    }
		
		//
    function orderByType(){
      var type = $(".clicked").text();
      if(type=='默认') {
        type = 'none';
      }else if(type=='喜欢'){
        type = 'like';
      }else if(type=='新款'){
        type = 'new';
      }else{
        type = 'hot';
      }
      return type;
    }

		//价格选择
    function chose_price(num){
      $('.det_price').removeClass('pr_clicked');
        $('.det_price').eq(num).addClass('pr_clicked');
        price_num = num;
        jump();
    }

   
		//条件查询
    function jump(){
      var url = "/guang";
      var pro_kind = $("#kinddisplay .choose_con").eq(1).text();
      var pro_props = $("#popdisplay .choose_con").eq(1).text();
      pro_props = props_case(pro_props);
      pro_kind = kind_case(pro_kind);
      var order = orderByType();
      var price = price_num;
      var params = {
        categoryId:pro_kind,
        props:pro_props,
        order:order,
        price:price
      }
      var str = jQuery.param(params);
      window.location.href = url + '?' + str;
      return false;

    }

		//流行元素转换成代号
    function props_case( props ){
      switch(props){
        case '松糕' :
          props = 1;
          break;
        case '防水台' :
          props = 2;
          break;
        case '一字型' :
          props = 3;
          break;
        case '人字鞋' :
          props = 4;
          break;
        case '尖头' :
          props = 5;
          break;
        case '绑带' :
          props = 6;
          break;
        case 'PU' :
          props = 7;
          break;
        case '镂空' :
          props = 8;
          break;
        default :
          props = '';
          break;
      }
      return props;
    }

		
  //当季热卖转换成代号
    function kind_case( kind ){
      switch(kind){
        case '凉鞋' :
          kind = 1;
          break;
        case '拖鞋' :
          kind = 2;
          break;
        case '低帮鞋' :
          kind = 3;
          break;
        case '靴子' :
          kind = 4;
          break;
        case '高帮鞋' :
          kind = 5;
          break;
        case '帆布鞋' :
          kind = 6;
          break;
        case '雨鞋' :
          kind = 7;
          break;
        case '乐福鞋' :
          kind = 8;
          break;
        case '平底鞋' :
          kind = 9;
          break;
        case '高跟鞋' :
          kind = 10;
          break;
        case '厚底鞋' :
          kind = 11;
          break;
        default :
          kind = '';
          break;
      }
      return kind;
    }

    var num = 2;
    var totalCount = ${total};
    var totalNum = Math.ceil(totalCount/20);

    window.onload = function(){
      $(".box").animate({ opacity:1 },100);
      waterfall('container', 'box');
    };

    //window.onresize = loadMore;
    window.addEventListener('resize',loadMore);
    function loadMore () {
      window.removeEventListener('resize',loadMore);
      hArr = [];
      var boxs = $(".box");
      var box_w = boxs[0].offsetWidth;
      //计算显示的列
      var cols = Math.floor(document.documentElement.clientWidth/box_w);
      for(var i=0;i<cols;i++){
        boxs[i].style.position = '';
      }
      $(".box").animate({ opacity:1 },200);
      waterfall('container', 'box');
    };
    var flag = true;
    
    //窗口滚动加载瀑布流
    window.onscroll = function(){
      if ($(document).scrollTop() > 300) {
        $('#float_screen').css('display','block');
      }else{
        $('#float_screen').css('display','none');
      }
     　　var scrollTop = $(window).scrollTop();
     　　var scrollHeight = $(document).height();
     　　var windowHeight = $(window).height();
     　　if(scrollTop + windowHeight + 700 >= scrollHeight && num<=totalNum && flag){
        $('#loading_tips').css('display','block');
     　　　  	getData(num);
        num++;
        flag = false;
     	　　}
    }
    
    //设置一个1秒的等待时间
    setInterval("myInterval()",1000);
    function myInterval(){
      flag = true;
    }

    //加载数据
    function getData(num){
      var addBoxs;
      var pro_kind = $("#kinddisplay .choose_con").eq(1).text();
      var pro_props = $("#popdisplay .choose_con").eq(1).text();
      pro_props = props_case(pro_props);
      pro_kind = kind_case(pro_kind);
      var order = orderByType();
      var price = price_num;
      //console.log(pro_kind+"..."+pro_props+"..."+num+"......"+order+"....."+price)
      $.ajax({
        type:"POST",
        url:"/guang/load",
        data:"page="+num+"&categoryId="+pro_kind+"&props="+pro_props+"&order="+order+"&price="+price,
        success:function(res){
          $('#loading_tips').css('display','none');            
          addBoxs = res;
          var div = 0;
          for(var i=0;i<addBoxs.length;i++){
        	  $(getChild(addBoxs[i])).find('.img')[0].onload = function () {
        		  $("#container").append($(this).closest('.box'));
        		  div += 1;
        		  if (div == 20) {
        			  var boxs = $(".box");
        	          callNum = (boxs.length-1)/20;
        	          var box_w = boxs[0].offsetWidth;
        	          callNum = Math.ceil(callNum);
        	          if(callNum>1){
        	            for(var j=(callNum-1)*20+1;j<boxs.length;j++){
        	              var minH = Math.min.apply(null, hArr);
        	              var index = getMinIndex(hArr, minH);
        	              boxs[j].style.position = 'absolute';
        	              boxs[j].style.top = minH + 'px';
        	              boxs[j].style.left = box_w*index+'px';
        	              hArr[index] += boxs[j].offsetHeight;
        	              $(boxs[j]).animate({ opacity:1 },200);
        	            }
        	            var maxH = Math.max.apply(null, hArr);
        	            $("#container").css("height",maxH+"px");
        	          }
        	          window.addEventListener('resize',loadMore);
        		  }
        	  }
          }
        }
      });
    }
    function getChild(data){
      var str = '',down = '',like = '';
      if(data.like){
        like = data.like;
      }else{
        like = 0;
      }
      if(data.down_count_alltime){
        down = data.down_count_alltime;
      }else{
        down = 0;
      }//style="position:absolute;top:'+top+'px;left:'+Left+'px"
      if((data.characters).length > 35){
        data.characters = data.characters.substring(0, 30);
        data.characters = data.characters + '...';
      }

      str += '<div class="box">'+
            '<div class="pic">'+
              '<a href ="/product/'+data.productId+'" target="_blank"><img  class="img" src="http://starshow.ximgs.net/images/'+data.productId+'.jpg" /></a>'+
              '<span class="pro_price">&yen;'+data.price+'.00</span>'+
              '<p class="pro_number">'+data.title+'&amp;'+data.articleNumber+'</p>';
              if(data.characters){
                str += '<p class="characters">'+data.characters+'</p>';
              }
							
              
              str += '<p class="pro_props"><span class="like" data_isLike="'+data.isLike+'" productId="'+data.productId+'" >';
              
              str+='<span id="love_'+data.productId+'">';
              if(data.isLike){
                str += '已喜欢';
              }else{
                str += '<img src="http://www2.cn/images/xin.png" alt="" />喜欢';
              }
              
              var likeNum = "";
              if (typeof(data.likeNum) != "undefined") { 
                	likeNum = data.likeNum;
             }
              
              str += '</span></span><span  class="like_count">'+likeNum+'</span><span class="down">下载量（'+data.downCountAlltime+'）</span></p>';
              if(data.content){
                str += '<div class="comment">'+
                  '<hr />'+
                  '<img class="face" src="http://www2.cn/images/face/'+data.face+'" width="36" height="36" />'+
                  '<span class="name">'+data.name+'</span>'+
                  '<p class="content1">'+data.content+'</p>'+
                '</div>';
              }
            str += '</div>'+
          '</div>';
      return str;
    }
    
    //存放每一列高度的数组
    var hArr = [];

    //主函数
    function waterfall(parent, child){
      
      var parentDiv = document.getElementById(parent);
      var boxs = $("."+child);
      var box_w = boxs[0].offsetWidth;

      var cols;
      //计算显示的列
      cols = Math.floor(document.documentElement.clientWidth/box_w);
      //设置container的宽
      var offset = (document.documentElement.clientWidth-box_w*cols-40)/2+6;
      if(offset<=15){
        cols--;
        offset = (document.documentElement.clientWidth-box_w*cols-40)/2+6;
      }
      parentDiv.style.cssText = 'width:'+cols*box_w+'px;margin-left:'+offset+'px';
      
      for(var j=0;j<boxs.length;j++){
        if(j<cols){
          hArr.push(boxs[j].offsetHeight);
        }else{
          var minH = Math.min.apply(null, hArr);
          var index = getMinIndex(hArr, minH);
          boxs[j].style.position = 'absolute';
          boxs[j].style.top = minH + 'px';
          boxs[j].style.left = box_w*index+'px';
          hArr[index] += boxs[j].offsetHeight;
          $(boxs).animate({ opacity:1 },200);
        }
      }
      var maxH = Math.max.apply(null, hArr);
      $("#"+parent).css("height",maxH+"px");
      
    }

    //获取所有的box
    function getByClass(parent, className){
      var boxArr = new Array(),
        element = parent.getElementsByTagName("*");
      for(var i=0;i<element.length;i++){
        if(element[i].className==className){
          boxArr.push(element[i]);
        }
      }
      return boxArr;
    }

    //获取数组的最小值
    function getMinIndex(arr, val){
      for(var i in arr){
        if(arr[i]==val){
          return i;
        }
      }
    }

    //是否滚动到底部
    function arriveBottom(){
      var parent = document.getElementById('container');
      var allBox = getByClass(parent, 'box');
      var lastBoxH = allBox[allBox.length-1].offsetTop;
      var boxH = allBox[allBox.length-1].offsetHeight;
      //console.log(lastBoxH);
      var scrollTop = $(window).scrollTop();
      //console.log(scrollTop);
      var height = document.body.clientHeight || document.documentElement.clientHeight;
      //console.log(boxH+scrollTop);
      return (lastBoxH+height<scrollTop+boxH) ? true : false;
    }

    //ajax喜欢
    $("#container").delegate(".like","click", function (){
      var object = $(this);
      var isLike = object.attr("data_isLike");
      var productId = object.attr("productId");
      if(isLike=="false"){
        $.ajax({
          type:'GET',
          url:'/guang/like',
          data:'productId='+productId,
          success:function(res){
            if(res=='fail'){
              window.location.href="/login";
            }else if(res=="connectFail"){
              alert("请求连接超时 。。。");
            }else{
              object.parent(".pro_props").find("span.like_count").text(res);
              object.find("span").text("已喜欢");
              object.attr("data_isLike","true");
            }
          }
        });
      }
    });
  </script>
</body>
