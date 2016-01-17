<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>go2.cn(购途市场)；成都国际商贸城网销女鞋 女装批发市场，时装女鞋，真皮女鞋，厂家直供货源，提供一件代发服务</title>
<link rel="stylesheet" href="/styles/welcome/css.css" />
<link rel="stylesheet" href="/styles/tips.css" />
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<style type="text/css">
* {
  margin: 0;
  padding: 0;
  border: 0;
  text-decoration: none;
}

body {
  width: 100%;
  font-family: "微软雅黑";
}

#index_screen {
  width: 100%;
  display: block;
}

.pname:hover {
  background: #ff7e00;
}

.item {
  width: 100%;
}

.one {
  background-color: #f90848;
}

.two {
  background-color: #face37;
}

.three {
  background-color: #9f2ffb;
}

.last {
  background-color: #f90848;
}

.more {
  background-color: #face37;
}

.fl {
  float: left;
  margin-right: 10px;
}

.fr {
  float: right;
  margin-left: 10px;
}

.item {
  overflow: hidden;
}

.item .product {
  width: 1184px;
  margin: 0 auto;
  overflow: hidden;
  height: auto;
  padding-top: 20px;
  padding-bottom: 20px;
}

.wraper .line {
  display: block;
  width: 100%;
}

.item .product-last {
  width: 1184px;
  margin: 0 auto;
  overflow: hidden;
  height: auto;
  padding-top: 20px;
  padding-bottom: 20px;
}

.item .product-more {
  width: 1184px;
  margin: 0 auto;
  overflow: hidden;
  height: auto;
  padding-top: 20px;
  padding-bottom: 20px;
}

.item .product-more p:last-child {
  font-size: 0;
}

.item .product-more img {
  margin-right: 10px;
}

.item .product-more span {
  display: block;
  float: left;
  width: 50%;
  font-size: 14px;;
  height: 50px;
  line-height: 50px;
}

.item .product-more .more-lianjie {
  text-align: right;
  font-family: "宋体";
  padding-right: 20px;
}

.item .product-more .more-lianjie a {
  color: #6f6f6f;
}

.item .product-more .more-lianjie a:hover {
  color: #f90748;
  text-decoration: none;
}

.item .product-last .product-block {
  display: block;
  float: left;
  width: 286px;
  height: 405px;
  margin-right: 10px;
  margin-bottom: 10px;
}

.item .odd .product-block {
  display: block;
  float: left;
  width: 286px;
  height: 405px;
  margin-right: 10px;
  margin-bottom: 10px;
}

.item .even .product-block {
  display: block;
  float: right;
  width: 286px;
  height: 405px;
  margin-right: 10px;
  margin-bottom: 10px;
}
/*悬浮*/
.right-float {
  position: fixed;
  top: 200px;
  width: 79px;
  z-index: 99;
}

.right-float .float-img {
  width: 79px;
  height: 78px;
  position: relative;
  background: url("http://special.ximgs.net/special/50/float.png") no-repeat top;
}

.right-float .float-img i {
  position: absolute;
  top: 0px;
  right: 0px;
  cursor: pointer;
  width: 16px;
  height: 16px;
  border-radius: 8px;
  background-color: #3bcdc8;
  color: #000;
  text-align: center;
  line-height: 16px;
  font-style: normal;
}
/* Custom Styles */
ul.nav-tabs {
  width: 79px;
  margin-top: 20px;
}

ul.nav-tabs li {
  margin: 0;
  border: 1px solid #292929;
  border-top: none;
  background: #292929;
}

ul.nav-tabs li:first-child {
  border: none;
  border-bottom: 1px solid #292929;
}

ul.nav-tabs li:last-child {
  background-color: red;
}

ul.nav-tabs li a {
  margin: 0;
  text-align: center;
  font-size: 12px;
  color: #fff;
  transition: background .5s linear;
  border: none;
  border-radius: 0;
}

ul.nav-tabs li.active a,ul.nav-tabs li:hover a {
  color: #000;
  background: #fff932;
  border-radius: 0 !important;
}

ul.nav-tabs li:last-child.active a,ul.nav-tabs li:last-child:hover a {
  background: red;
  color: #fff;
  border-radius: 0 !important;
}

ul.nav-tabs.affix {
  top: 30px; /* Set the top position of pinned element */
}

.nav>li>a {
  padding: 5px 0;
}

.f12 {
  font-size: 12px !important
}

.f14 {
  font-size: 14px !important
}

.fy12 {
  font-size: 12px !important;
  font-family: "Microsoft YaHei", 微软雅黑, "Microsoft JhengHei";
}

.fy14 {
  font-size: 14px !important;
  font-family: "Microsoft YaHei", 微软雅黑, "Microsoft JhengHei";
}

.fy16 {
  font-size: 16px !important;
  font-family: "Microsoft YaHei", 微软雅黑, "Microsoft JhengHei";
}

.fy18 {
  font-size: 18px !important;
  font-family: "Microsoft YaHei", 微软雅黑, "Microsoft JhengHei";
}

.fy30 {
  font-size: 30px !important;
  font-family: "Microsoft YaHei", 微软雅黑, "Microsoft JhengHei";
}

.bold {
  font-weight: bold
}

.normal {
  font-weight: normal
}

.font_none {
  font-size: 0px;
  line-height: 0px
}

.2c2c2c {
  color: #2c2c2c;
}

.6a6a6a {
  color: #6a6a6a;
}

.float_r {
  float: right;
}

.footer {
  width: 100%;
  height: 170px;
  padding: 15px 0px;
  margin-top: 0px;
  background: #b99518;
}

.footer_b {
  width: 1195px;
  height: 170px;
  margin: 0 auto;
  overflow: hidden;
}

.footer_b_l {
  width: 760px;
  height: 170px;
  border-right: 1px #FFF solid;
  overflow: hidden;
  float: left;
}

.footer_b_l_list {
  width: 122px;
  height: 170px;
  margin: 0 15px;
  float: left;
  color: #d4d4d4;
}

.footer_b_l_list li {
  width: 122px;
  height: 34px;
  line-height: 34px;
  list-style-type: none;
}

.footer_b_l_list a {
  color: #d4d4d4;
  text-decoration: none;
}

.footer_b_l_list a:hover {
  color: #fff;
  text-decoration: none;
}

.footer_b_l_list a:visted {
  color: #d4d4d4;
  text-decoration: none;
}

.footer_b_r {
  width: 400px;
  height: 148px;
  padding: 11px 0px 11px 40px;
  float: left;
}

.footer_b_r_p {
  width: 120px;
  height: 120px;
  float: left;
}

.footer_b_r_phone {
  width: 219px;
  height: 120px;
  margin-left: 15px;
  float: left;
}

.footer_b_r_phone li {
  width: 234px;
  height: 24px;
  color: #d4d4d4;
  list-style-type: none;
}

.bottom {
  width: 100%;
  height: 60px;
  margin: 0px auto;
  padding: 10px 0px;
  background: #FFF;
}

.bottom li {
  width: 1195px;
  color: #6a6a6a;
  height: 30px;
  line-height: 30px;
  margin: 0 auto;
  text-align: center;
  list-style-type: none;
}

.bottom a {
  color: #6a6a6a;
  text-decoration: none;
}

.bottom a:hover {
  color: #6a6a6a;
  text-decoration: underline;
}

.bottom a:visted {
  color: #6a6a6a;
  text-decoration: none;
}

#footer_tail {
  position: relative;
  top: 30px;
  display: block;
  width: 100%;
}
</style>
<script>
  var _hmt = _hmt || [];
  (function() {
    var hm = document.createElement("script");
    hm.src = "//hm.baidu.com/hm.js?a3068f9bab83d3a0e1c4c87660f6bcbd";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
  })();
</script>

</head>
<body data-spy="scroll" data-target="#myScrollspy">
  <div style="width: 100%; background-color: #f5f5f5;" id="navTop">
    <div class="t1 2c2c2c fy12">
      <ul style="float: right; height: 37px; font-weight: bold; margin-bottom: 0">
        <li style="float: left; margin: 0px 5px;"><a class="qq" target="_blank" style="height: 37px;" href="#"> <img
            src="/images/unique/qqtalk.png" style="cursor: pointer; height: 26px; width: 96px; margin-top: 5px;" />
        </a> <a target="_blank" href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=cs@go2.cn" rel="nofollow"
          style="text-decoration: none;"><img src="/images/emiltalk.png" /></a></li>
        <li style="float: left">
          <ul id="user_status">
            <li style="float: left;"><a href="/user/login">登录</a> | <a href="/user/register">注册 </a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
  <div class="t2" style="position: relative;">
    <ul class="fy16 bold">
      <li style="padding: 0; border: 0px;"><a href="/"><img src="/images/img/logo.png" /></a></li>
      <li style="padding: 0;"><a href="/firsthand"><img src="/images/img/shoesmarket.png" /></a></li>
      <li class="pname" id="welcome"><a href="/">首页</a></li>
      <li class="pname" id="unique"><a href="/unique/">独家</a></li>
      <li class="pname" id="firsthand"><a href="/firsthand/">一手货源</a></li>
      <li class="pname" id="certified"><a href="/supplier/">认证商家</a></li>
      <li class="pname" id="manufacturer"><a href="/supplier/88-0-1-1-all.go">直销厂家</a></li>
      <li class="pname" id="daifa"><a href="/daifa/">一件代发</a></li>
      <li class="pname" id="cameraman"><a href="/cameraman/">摄影服务</a></li>
      <li style="border: none; color: #9a9a9a; float: right; padding: 0;"><img src="/images/supplier/phone.png"
        style="margin-top: 25px; float: left;" />
        <p style="line-height: 26px; float: left; margin-top: 25px;">400 6611 603</p></li>

    </ul>
  </div>
  <!--悬浮-->
  <div class="right-float" id="myScrollspy">

    <ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="125">
      <li class="float-img"><i>×</i></li>
      <li class="active"><a href="#section-1">皮靴</a></li>
      <li><a href="#section-2">雪地靴</a></li>
      <li><a href="#section-3">休闲鞋</a></li>
      <li><a href="#section-4">家居拖鞋</a></li>
      <li><a href="#section-5">单靴</a></li>
      <li><a href="#section-6">男鞋</a></li>
      <li><a href="#section-7">优质厂商</a></li>
      <li><a href="#section-8">更多主题</a></li>
      <li><a href="#top">返回顶部Λ</a></li>
    </ul>
  </div>
  <!--首屏-->
  <a name="top"></a>
  <img id="index_screen" src="http://special.ximgs.net/special/50/index_screen.jpg">
  <div class="wraper">
    <div class="h" id="section-1"></div>
    <div class="item one">
      <div class="product odd">
        <img src="http://special.ximgs.net/special/50/1pixue.jpg" class="fl">
      </div>
    </div>
    <img src="http://special.ximgs.net/special/50/line1.jpg" id="section-2" class="line" />
    <div class="item two">
      <div class="product even">
        <img src="http://special.ximgs.net/special/50/2xuedixue.jpg" class="fr">
      </div>
    </div>
    <img src="http://special.ximgs.net/special/50/line2.jpg" id="section-3" class="line" />
    <div class="item three">
      <div class="product odd">
        <img src="http://special.ximgs.net/special/50/3xiuxianxie.jpg" class="fl">
      </div>
    </div>
    <img src="http://special.ximgs.net/special/50/line3.jpg" id="section-4" class="line" />
    <div class="item one">
      <div class="product  even">
        <img src="http://special.ximgs.net/special/50/4tuoxie.jpg" class="fr">
      </div>
    </div>
    <img src="http://special.ximgs.net/special/50/line1.jpg" id="section-5" class="line" />
    <div class="item two">
      <div class="product odd">
        <img src="http://special.ximgs.net/special/50/5danxie.jpg" class="fl">
      </div>
    </div>
    <img src="http://special.ximgs.net/special/50/line2.jpg" id="section-6" class="line" />
    <div class="item three">
      <div class="product even">
        <img src="http://special.ximgs.net/special/50/6nanxie.jpg" class="fr">
      </div>
    </div>
    <img src="http://special.ximgs.net/special/50/line3.jpg" id="section-7" class="line" />
    <div class="item last">
      <div class="product-last">
        <img src="http://special.ximgs.net/special/50/section8.jpg" />
      </div>
    </div>
    <div class="h" id="section-8"></div>
    <div class="item more">
      <div class="product-more">

        <p>
          <span style="font-size: 24px;">更多主题</span> <span class="more-lianjie"> <a target="_blank" href="/firsthand/dc-1-0.go?w=3">低帮鞋</a>/
            <a target="_blank" href="/firsthand/dc-1-0.go?w=5">高帮鞋</a>/ <a target="_blank" href="/firsthand/dc-1-0.go?w=4">靴子</a>/ <a
            target="_blank" href="/firsthand/dc-1-0.go?w=6">帆布鞋</a>/ <a target="_blank" href="/firsthand/dc-1-0.go?w=1">凉鞋</a>/ <a
            target="_blank" href="/firsthand/dc-1-0.go?w=2">拖鞋</a>/ <a target="_blank" href="/firsthand/dc-1-0.go?w=13">童鞋</a>
          </span>
        </p>
        <p>
          <a href="/firsthand/n3-1-0.go" target="_blank"><img src="http://special.ximgs.net/special/50/1sanri.jpg" /></a> <a
            href="/firsthand/hs-1-0.go" target="_blank"><img src="http://special.ximgs.net/special/50/2qiri.jpg" /></a> <a href="/guang"
            target="_blank"><img src="http://special.ximgs.net/special/50/3juchaohuo.jpg" /></a> <a href="/supplier" target="_blank"><img
            src="http://special.ximgs.net/special/50/4renzheng.jpg" /></a>
        </p>
      </div>
      <img id="footer_tail" src="http://special.ximgs.net/special/50/tall.png">
    </div>

  </div>
  <!--Footer-->

  <div class="footer">
    <div class="footer_b">
      <div class="footer_b_l">
        <div class="footer_b_l_list f12">
          <ul>
            <li class="bold"><a href="http://www.go2.cn/help/" target="_blank">新手指南</a></li>
            <li><a href="http://www.go2.cn/help/6" target="_blank">采购入门</a></li>
            <li><a href="http://www.go2.cn/help/5" target="_blank">供应入门</a></li>
          </ul>
        </div>
        <div class="footer_b_l_list f12">
          <ul>
            <li class="bold">交易安全</li>
            <li><a href="http://www.go2.cn/manage/supplier/authtype" target="_blank">供应商实体认证</a></li>
            <li><a href="http://www.go2.cn/user/register_as_supplier" target="_blank">厂家认证</a></li>
            <li><a href="http://www.go2.cn/daifa/" target="_blank">选择代发货商</a></li>
          </ul>
        </div>
        <div class="footer_b_l_list f12">
          <ul>
            <li class="bold">采购商服务</li>
            <li><a href="http://www.go2.cn/firsthand/" target="_blank">找产品</a></li>
            <li><a href="http://www.go2.cn/supplier/" target="_blank">找厂家</a></li>
            <li><a href="#" target="_blank">电商发布分享</a></li>
          </ul>
        </div>
        <div class="footer_b_l_list f12">
          <ul>
            <li class="bold">供应商服务</li>
            <li><a href="http://www.go2.cn/supplier/" target="_blank">供应商</a>/<a href="http://www.go2.cn/supplier/88-0-1-1-all.go"
              target="_blank">厂家专区</a></li>
            <li><a href="http://www.go2.cn/manage/promotion/loading" target="_blank">广告投放</a></li>
            <li><a href="#" target="_blank">设计服务</a></li>
          </ul>
        </div>
        <div class="footer_b_l_list f12">
          <ul>
            <li class="bold">购途服务</li>
            <li><a href="http://www.go2.cn/cameraman/" target="_blank">产品摄影服务</a></li>
            <li><a href="http://www.go2.cn/user/register_as_cameraman" target="_blank">专业摄影机构认证</a></li>
            <li><a href="http://www.go2.cn/daifa/" target="_blank">免费一件代发</a></li>
          </ul>
        </div>
      </div>
      <div class="footer_b_r">
        <div class="footer_b_r_p">
          <a href="/help/qrCode" target="_blank"> <img src="http://www.go2.cn/images/unique/qr.jpg" width="120" height="120" />
          </a>
        </div>
        <div class="footer_b_r_phone">
          <ul>
            <li class="fy16 bold">服务热线：</li>
            <li class="fy30 bold" style="height: 46px; line-height: 46px; font-family: Tahoma, Geneva, sans-serif;">400 6611 603</li>
            <li class="fy12">周一到周五 09:00-24:00</li>
            <li class="fy12">周六到周日 10:00-23:00</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="bottom f12">
    <ul>
      <li>© 2010-2015 GO2.CN 购途 版权所有 | <a href="#">资质证书</a> | <a href="#">法律声明</a> | <a href="http://www.go2.cn/help/8">服务条款</a> | <a
        href="#">隐私声明</a> | <a href="#">关于购途</a> | <a href="#">联系我们</a> | <a href="#">网站导航</a></li>
      <li>服务热线：400 6611 603 / QQ客服：<a class="qq" href="#"><img style="margin-left: 5px; cursor: pointer" class="qq"
          src="http://www.go2.cn/images/qq_buttom.png" align="absmiddle"></a> ICP证号：川B2-20120145 <script language="javascript"
          type="text/javascript" src="http://js.users.51.la/4621821.js"></script>
      </li>
    </ul>
  </div>
  <script type="text/javascript" src="/scripts/public/public.js"></script>
  <script type="text/javascript">
      $(function() {
        $("#user_status a p").css("margin-bottom", "0");
        function tips() {
          var right = ((parseInt(document.body.clientWidth) - 1195) / 2) - 70;
          if (right > 0) {
            $(".right-float").css('right', right + 'px');
          } else {
            $(".right-float").css('right', '20px');
          }
          ;
        }
        ;
        tips();
        $('.right-float .float-img i').click(function() {
          $('.right-float').hide();
        })
        var link1 = new Array("http://mengzhongren.go2.cn/", "http://diteni.go2.cn/", "http://luna.go2.cn/", "http://rachel.go2.cn/",
            "http://neh.go2.cn/", "http://myqueen.go2.cn/", "http://lameizi.go2.cn/", "http://gxz.go2.cn/")
        var number = new Array(224491, 232891, 264156, 264547, 73707, 280102, 280325, 277833, 266810, 280151, 268732, 279327, 251693,
            240537, 262298, 269724, 226334, 257552, 270967, 273488, 264073, 255012, 265020, 147155, 276756, 251051, 256884, 244458, 277306,
            275521, 272895, 165684, 226584, 226056, 232247, 130686, 228869, 231123, 265939, 125546, 282345, 281419);
        var link = new Array("qqaako", "qgqsko", "qeaoce", "qeacai", "igimi", "qsmomq", "qsmgqc", "qiisgg", "qeesom", "qsmoco", "qesigq",
            "qikgqi", "qcoekg", "qamcgi", "qeqqks", "qekiqa", "qqegga", "qciccq", "qimkei", "qigass", "qeamig", "qccmoq", "qecmqm",
            "oaiocc", "qieice", "qcomco", "qcessa", "qaaacs", "qiigme", "qiccqo", "qiqskc", "oecesa", "qqecsa", "qqemce", "qgqqai",
            "ogmese", "qqssek", "qgooqg", "qeckgk", "oqccae", "qsqgac", "qsoaok");
        for ( var i = 0; i < 7; i++) {
          $('.product').append("<a class='product-block' href='#' target='_blank'></a>");
        }
        ;
        for ( var i = 0; i < 42; i++) {
          link[i] = 'http://www.go2.cn/product/' + link[i] + '.go?p=' + number[i];
        }
        ;
        for ( var i = 0; i < 42; i++) {
          $('.product-block').eq(i).css('background', 'url(http://special.ximgs.net/special/50/sp_50_' + (i + 1) + '.jpg)').attr('href',
              link[i]);
        }
        ;
        for ( var i = 0; i < 8; i++) {
          $('.product-last').append("<a class='product-block' href='#' target='_blank'></a>");
        }
        ;
        for ( var i = 0; i < 8; i++) {
          var j = i + 42;
          $('.product-block').eq(j).css('background', 'url(http://special.ximgs.net/special/50/sp_50_' + (j + 1) + '.jpg)').attr('href',
              link1[i]);
        }
        for ( var i = 1; i < 43; i++) {
          var string_k = i.toString();
          switch (string_k.length) {
          case 1:
            string_k = '00' + string_k;
            break;
          case 2:
            string_k = '0' + string_k;
            break;
          }
          var oldaddr = $('.product-block').eq(i - 1).attr('href');
          $('.product-block').eq(i - 1).attr('href', oldaddr + '&k30=0' + string_k);
        }
        ;

      })
    </script>
</body>
</html>
