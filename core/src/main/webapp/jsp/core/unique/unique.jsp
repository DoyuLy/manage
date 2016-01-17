<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<link href="/css/core/unique/unique.css" rel="stylesheet" type="text/css" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<!-- 页面标题==========================================-->
<title>独家</title>

<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.min.js"></script>
      <script src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>

<body onload="sale()">
  <!-- 一级级导航==========================================-->
  <%@include file="/jsp/common/nav.jsp"%>
  <!-- 内容==========================================-->
  <div class="content">
    <!-- 二级导航==========================================-->
    <!--T5 Menu-->
    <div class="t5">
      <ul class="fy18">
        <li class="second-nav active" style="margin-left: 0px;"><a href="/unique/0-0">所有独款</a></li>
        <li class="second-nav"><a href="/unique/c4-${sortId }">靴子</a></li>
        <li class="second-nav"><a href="/unique/c3-${sortId }">低帮鞋</a></li>
        <li class="second-nav"><a href="/unique/c5-${sortId }">高帮鞋</a></li>
        <li class="second-nav"><a href="/unique/c1-${sortId }">凉鞋</a></li>
        <li class="second-nav"><a href="/unique/c2-${sortId }">拖鞋</a></li>
        <li><a class="second-nav" href="/specialTopic/themeProduct" target="_blank">主题选货</a></li>
      </ul>
      <c:if test="${categoryId == '0'}"><%@include file="/jsp/common/propStatic_c1.html"%></c:if>
      <c:if test="${categoryId == 'c1'}"><%@include file="/jsp/common/propStatic_c1.html"%></c:if>
      <c:if test="${categoryId == 'c2'}"><%@include file="/jsp/common/propStatic_c2.html"%></c:if>
      <c:if test="${categoryId == 'c3'}"><%@include file="/jsp/common/propStatic_c3.html"%></c:if>
      <c:if test="${categoryId == 'c4'}"><%@include file="/jsp/common/propStatic_c4.html"%></c:if>
      <c:if test="${categoryId == 'c5'}"><%@include file="/jsp/common/propStatic_c5.html"%></c:if>

      <!--.Attribute-->
      <p class="f14 rank-box">
        <a href="/unique/${categoryId}-0" class="rankall" onclick="rankin(0)"> 综合 </a> <a href="/unique/${categoryId}-1" class="rankall"
          onclick="rankin(1)"> 新品 </a> <a href="/unique/${categoryId}-2" class="rankall" onclick="rankin(2)">发布</a> <a
          href="/unique/${categoryId}-3" class="rankall" onclick="rankin(3)">下载</a> <a href="/unique/${categoryId}-4" class="rankall"
          onclick="rankin(4)">人气</a> <a href="/unique/${categoryId}-5" class="rankall" onclick="rankin(5)">价格从低到高</a> <a
          href="/unique/${categoryId}-6" class="rankall" onclick="rankin(6)">价格从高到低</a>
      </p>
    </div>
    <!--div l1 产品展示-->
    <div class="l1 pro-show">
      <c:forEach var="product" items="${ paginationData.list}" varStatus="status">
        <div
          class="list <c:if test='${((status.index + 1) mod 5) eq 0 }'>list-end</c:if> <c:if test='${((status.index + 1) mod 6) eq 0 }'>list-ends</c:if>">
          <a class="pro-img" href="/product/${product.id }" target="_blank"> <img class="lazy"
            <c:choose>
              	<c:when test="${status.index lt 12}">src="http://thumb.ximgs.net${fn:substringBefore(product.indexImage, '.')}_160x160.jpg" </c:when>
              	<c:otherwise>src="/img/f_loading.png" data-url="http://thumb.ximgs.net${fn:substringBefore(product.indexImage, '.')}_160x160.jpg"
              </c:otherwise>
              </c:choose>
            alt="${product.supplier.brand}&${ product.articleNumber}" />
          </a>
          <ul>
            <li class="list01 fy18 bold ${product.id }_price">&yen;${product.price}.00</li>
            <li class="list02 fy12 clear ${product.id }_characters" style="font-size: 12px;"><c:if test="${product.characters != null}">${product.characters}</c:if></li>
            <li class="list03"><a class="art-no" href="/product/${product.id }"
              title="${product.supplier.brand}&amp;${ product.articleNumber}" target="_blank"> <span class="factory">${product.supplier.brand}</span>
                <span class="pro-number">${ product.articleNumber}</span>
            </a>
              <div class="auth-icon pull-right">
                <img alt="" src="/img/common/pho_i.png"> <img alt="" src="/img/common/qua_i.png"> <img alt=""
                  src="/img/common/fac_i.png">
              </div></li>
          </ul>
        </div>
      </c:forEach>
    </div>
    <input type="hidden" id="url" value="/unique/{$cat}-{$page}" />

    <!--------分页条-------->
    <%@include file="/jsp/common/pagination.jsp"%>
    <!--------分页条-------->

  </div>

  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>

  <!-- 私有js==========================================-->
  <script type="text/javascript" src="/resources/js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="/resources/js/jquery.scrollLoading.js"></script>
  <script type='text/javascript' src='/resources/js/searchbox.js'></script>
  <script type='text/javascript' src='/resources/js/public.js'></script>
  <script type="text/javascript">
      var channel = "{if $channel}{$channel}{else}firsthand{/if}";
      var cid = "{if $cid}c{$cid}{else}{$cat}{/if}";
      var keyword = '{$keyword}';
      var props = '{$props}';
      var w = "{if $cid|is_numeric}{$cid}{else}{$smarty.get.w}{/if}";

      function rankin(val) {
        if (val == '5') {
          val = 6;
        } else if (val == 6) {
          val = 5;
        }

        var u = $("#url").val();
        m = u;
        u = u.replace(/-[0-9]+$/, '');
        window.location = u + '-1-' + val;
      }

      function sale() {
        var number = Math.ceil($(".list_02").length / 6);
        var bgwidth = number * parseInt($(".l2").css("width"));
        $(".list_02").eq($(".list_02").length - 1).css("border-right", "1px solid #d3d3d3");
        for ( var i = 0; i < $(".list_02").length - 1; i++) {
          if ((i + 1) % 6 == 0) {
            $(".list_02").eq(i).css("border-right", "1px solid #d3d3d3")
          }
          ;
        }
        ;
        $(".l2_bigback").css("right", 0);
        $(".l2_bigback").css("width", bgwidth);
        setInterval("goods(0)", 5000);
      }

      function goods(x) {
        var slidedis = parseInt($(".l2").css("width"));
        var right = parseInt($(".l2_bigback").css("right"));
        var max = (Math.ceil($(".list_02").length / 6) - 1) * parseInt($(".l2").css("width"));
        if (x == 0) {
          if (right < max) {
            $(".l2_bigback").css("right", "+=" + slidedis);
          } else {
            $(".l2_bigback").css("right", 0);
          }
        } else {
          if (right > 0) {
            $(".l2_bigback").css("right", "-=" + slidedis);
          } else {
            $(".l2_bigback").css("right", max);
          }
        }
      }

      function mouseon(_attr) {
        var lis = _attr.getElementsByTagName("img");
        lis[0].setAttribute("src", "/images/img/attr_on.png");
        $(_attr).css("color", "#FF6600");
      }

      function mouseoff(_attr) {
        var lis = _attr.getElementsByTagName("img");
        lis[0].setAttribute("src", "/images/img/attr_off.png");
        $(_attr).css("color", "#909090");
      }

      function searchcon(_search) {
        $(".search_bg").val($(_search).html());
        var _parentElement = _search.parentNode;
        $(_parentElement).html('');
      }

      $(function() {

        //加载图片
        $("img.lazy").scrollLoading();

        //漂浮快处理
        $(".effect_01").mouseover(function() {
          $(this).children('span').css("display", "block");
        });
        $(".effect_01").mouseout(function() {
          $(this).children('span').css("display", "none");
        });
        var distop = parseInt(document.body.clientHeight);

        function tips() {
          var right = ((parseInt(document.body.clientWidth) - 1195) / 2) - 55;
          if (right > 0) {
            $("#tips").css('right', right + 'px');
          } else {
            $("#tips").css('right', '20px');
          }
          ;
          var aa = document.body.scrollHeight - $(window).height();
          var scrolltop = $(document).scrollTop();
          if (aa - scrolltop < 300) {
            var disbottom = 310 - (aa - scrolltop);
            $("#tips").css('bottom', disbottom + 'px');
          } else {
            $("#tips").css('bottom', '20px');
          }
          ;
        }
        ;
        tips();
        window.onscroll = tips;
        window.onresize = tips;

        // 广告前十个产品的四个标签图标控制
        $('.tips-icon').each(function() {
          var product = $(this);
          $.post('/ajax/firsthand/gettipsicon/' + product.attr('data-product'), function(data) {
            var str = '';
            if (data.is_manufacturer) {
              str += '<img src="/images/img/icon01.png" title="生产厂家"/>';
            }
            if (data.certified_type) {
              str += '<img src="/images/img/icon02.png" title="高级认证"/>';
            }
            if (data.material) {
              str += '<img src="/images/img/icon04.png" title="真皮"/>';
            }
            product.html(str);
          }, 'json');
        });

        // 加载属性选项
        $('.attrchoose').load('/ajax/firsthand/attr/' + w, function(data) {
          $(this).html(data);
        }).on('click', '.para', function() {
          props = $(this).attr('prop');
          $('#searchbutton').click();
          event.preventDefault();
        });

        $("#searchbutton").click(
            function() {
              var searchType = $("#searchType").attr("data-type");
              var url = '{$smarty.const.SEARCH_URL}/search/unique-' + cid + '-'
                  + encodeURIComponent($('#searchinput').val().replace(/-/g, '~')) + '-' + props + '-1-0';
              if (searchType == 1) {
                url = url + '?searchType=' + searchType;
                window.location.href = url;
              } else
                window.location.href = url + '?w=' + w;
              return false;
            });

        $("#searchinput").keypress(function(event) {
          if (event.which == 13) {
            $("#searchbutton").click();
            event.preventDefault();
          }
        });

        $('.slider').mouseover(function() {
          $('.t4_sr,.t4_sl').css('display', 'inline');
        }).mouseout(function() {
          $('.t4_sr,.t4_sl').css('display', 'none');
        });

        //页面跳转
        $(".sure").click(function() {
          var page = $(".page").val();
          var url = '/unique/{$cat}-' + page + '-{$sort}';
          window.location.href = url;
        });

        // 排序箭头显示
        $('.arrow').mouseover(function() {
          if ($(this).hasClass('rankcont1')) {
            $(this).removeClass('rankcont1');
            $(this).addClass('rankcont2');
          } else if ($(this).hasClass('rankcont2')) {
            $(this).removeClass('rankcont2');
            $(this).addClass('rankcont3');
          } else if ($(this).hasClass('rankcont3')) {
            $(this).removeClass('rankcont3');
            $(this).addClass('rankcont2');
          }
        }).mouseout(function() {
          if ($(this).hasClass('rankcont2') && !$(this).hasClass('rankall')) {
            $(this).removeClass('rankcont2');
            $(this).addClass('rankcont1');
          } else if ($(this).hasClass('rankcont3') && $(this).hasClass('rankall')) {
            $(this).removeClass('rankcont3');
            $(this).addClass('rankcont2');
          } else if ($(this).hasClass('rankcont2') && $(this).hasClass('rankall')) {
            $(this).removeClass('rankcont2');
            $(this).addClass('rankcont3');
          }
        });
        //搜索下拉框
        $(".search-box .show").click(function() {
          $(".search-box i").addClass("active-one");
          $(".search-select").slideDown(50);
        });
        $(".search-select p").click(function() {
          $(".search-select").slideUp(50);
          $(".search-box i").removeClass("active-one");
          $(".search-box .show").find("p").text($(this).text());
          $(".search-box .show").find("p").attr('data-type', $(this).attr("data-type"));
        });
        $(".search-select").mouseleave(function() {
          $(".search-select").slideUp(50);
          $(".search-box i").removeClass("active-one");
        });
      });
    </script>
</body>

</html>
