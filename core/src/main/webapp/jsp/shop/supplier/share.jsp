<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html mlns:wb="http://open.weibo.com/wb">
<head>
<meta charset="UTF-8">
<title></title>
<style>
{
literal












}
* {
  padding: 0;
  margin: 0
}

li {
  list-style: none
}

.outer {
  margin: 0 auto;
  padding: 10px;
  width: 455px;
  height: 480px;
  overflow-y: scroll
}

.share {
  overflow: auto;
  margin-bottom: 15px;
}

.share span.title {
  float: left;
  line-height: 28px;
}

.share ul {
  float: left;
}

.share ul li {
  float: left;
  margin: 0 15px;
}

.share ul li input {
  vertical-align: middle
}

.share ul li i {
  background: url("/images/icons_0_32.png");
  width: 32px;
  height: 32px;
  display: inline-block;
  vertical-align: middle
}

.share ul .wechat-item i {
  background-position: 0 -1612px;
}

.share ul .sina-item i {
  background-position: 0 -104px;
}

.share ul .qq-item i {
  background-position: 0 -52px;
}

.share_to_where .bds_weixin {
  margin: 0
}

.poster-img {
  width: 440px;
  height: 110px;
  display: block
}

textarea {
  border: 1px solid #ccc;
  border-radius: 2px;
  display: block;
  height: 110px;
  margin-top: 10px;
  padding: 10px;
  resize: none;
  width: 418px;
}

.shop-info {
  border-bottom: 1px solid #ccc;
  margin-top: 10px;
  overflow: auto;
  padding-bottom: 6px;
}

.shop-info img {
  width: 119px;
  height: 110px;
  float: left;
  margin-right: 10px;
}

.shop-info ul {
  float: left;
  line-height: 27px;
  width: 308px;
  font-size: 15px;
}

.shop-info ul li {
  
}

.btn-box {
  margin-top: 20px;
  text-align: center;
}

.btn-box a {
  background: #ff6000 none repeat scroll 0 0;
  border-radius: 2px;
  color: #fff;
  display: inline-block;
  font-size: 15px;
  height: 20px;
  padding: 7px 12px;
  text-align: center;
  text-decoration: none;
  width: 43px;
}

.btn-box .copy-btn {
  margin-right: 30px
}

.btn-box .share-btn {
  
}
{/
literal












}
</style>
<script type="text/javascript" src="/js/shop/lib/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/js/shop/ZeroClipboard.js"></script>
</head>
<body>
  <div class="outer">
    <div class="share">
      <span class="title">分享到:</span>
      <ul class="share_to_where">
        <li style="height: auto; overflow: hidden;" class="wechat-item">
          <div class="bdsharebuttonbox">
            <a href="javascript:;" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
          </div>
        </li>
        <li class="sina-item"><input type="checkbox" value="2" class="sina" /> <i></i></li>
        <li class="qq-item"><input type="checkbox" value="3" class="qq" /> <i></i></li>
      </ul>
    </div>
    <div id="j_share">
      <img width="440" height="110" src="/img/supplier/gift.gif" class="poster-img" />
      <textarea class="j_content">#优质厂商推荐# {$title}   {$link}  上万厂家一手货源，热销爆款一网打尽，上go2赚大买卖！发布任意商品赢大奖，赶紧行动吧!</textarea>
      <div class="shop-info">
        <ul>
          <li>店铺网址：{$subdomain}</li>
          <li>拿货地址：{$address}</li>
          <li>联系电话：{$phone}</li>
          <li>联系QQ：{$qq}</li>
        </ul>
      </div>
    </div>
    <div class="btn-box">
      <a href="javascript:;" data-clipboard-target="j_share" class="copy-btn">复制</a> <a href="javascript:;" class="share-btn">分享</a>
    </div>
  </div>
  <script type="text/javascript">
    var link = "{$link}";
</script>
  {literal}
  <script type="text/javascript">
    window._bd_share_config=
    {
        "common":
        {
            "bdSnsKey":{},
            "bdText":"",
            "bdMini":"1",
            "bdMiniList":
                    [
                        "weixin",
                    ],
            "bdPic":"",
            "bdStyle":"0",
            "bdSize":"32",
            "bdUrl":link,
        },
        "share":{}
    };
    with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
</script>
  {/literal}
  <script type="text/javascript">
    ZeroClipboard.config( { swfPath: "/scripts/ZeroClipboard.swf" } );
    var client = new ZeroClipboard($(".copy-btn"));
    client.on("ready", function(readyEven) {
        client.on("aftercopy", function(event) {
            alert('复制成功');
        });
    });

    $(function(){
        $(".share-btn").on('click', function(){
            var i = 0;
            $(".share_to_where li").each(function(index, value){
                var obj = $(this).find("input:checkbox");
                i++;
                if(obj.is(":checked")) {
                    if( obj.val() == 3 ){
                        qq();
                    } else if( obj.val() == 2 ) {
                        sina();
                    }
                }
            });
        });
    });

    function qq(){
        var p = {
            url:"{$link}",
            showcount:'0',
            desc:"#优质厂商推荐# {$title}   {$link}  上万厂家一手货源，热销爆款一网打尽，上go2赚大买卖！发布任意商品赢大奖，赶紧行动吧!",
            summary:"#优质厂商推荐# {$title}   {$link}  上万厂家一手货源，热销爆款一网打尽，上go2赚大买卖！发布任意商品赢大奖，赶紧行动吧!",
            title:"#优质厂商推荐# {$title}   {$link}  上万厂家一手货源，热销爆款一网打尽，上go2赚大买卖！发布任意商品赢大奖，赶紧行动吧!",
            site:'http://www.go2.cn',
            pics:'{if $index_image|strpos:'ttp' eq 1}{'/\.([a-zA-Z]*)$/'|preg_replace:'_750x750.$1':$index_image}{else}{$smarty.const.STATIC_IMAGE_URL_PREFIX}{'/\.([a-zA-Z]*)$/'|preg_replace:'_310x310.$1':$index_image}{/if}',
                style:'201',
                width:39,
                height:39
    };
    var s = [];
    for(var i in p){
        s.push(i + '=' + encodeURIComponent(p[i]||''));
    }
    var qqUrl = "http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?"+s.join('&');
    window.open(qqUrl);
    }

    function sina(){
        var sinaUrl = "http://service.weibo.com/share/share.php?url={urlencode($link)}" + "&type=button&language=zh_cn&appkey=1376463117" + "&title=%23优质厂商推荐%23 {$title}   {$link}  上万厂家一手货源，热销爆款一网打尽，上go2赚大买卖！发布任意商品赢大奖，赶紧行动吧!&pic=&searchPic=false&style=simple";
        window.open(sinaUrl);
    }
</script>
  <script src="http://qzonestyle.gtimg.cn/qzone/app/qzlike/qzopensl.js#jsdate=20111201" charset="utf-8"></script>
  <script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>