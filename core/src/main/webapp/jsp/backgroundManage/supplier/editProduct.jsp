<%@page import="java.awt.PageAttributes"%>
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!-- JSTL===========================================-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<head>
<link rel="stylesheet" href="/css/userCenter/supplier/subNav.css" />
<link rel="stylesheet" href="/css/userCenter/supplier/productList.css" />
<link href="/css/backgroundManage/supplier/upinfopassmobile.css" rel="stylesheet" />
<style type="text/css">
#mbox_right {
  float: left;
  margin-left: -1px;
  width: 819px;
  padding-top: 5px;
  border-left: 1px solid #C0C0C0;
  overflow: hidden;
}

#mbox_right #errmsg {
  float: left;
  font-size: 14px;
  width: 611px;
  line-height: 24px;
  padding: 5px 20px;
  margin: 0;
  margin-bottom: 1px;
  background: #333;
  color: #FFF;
}

#mbox_right #errmsg strong {
  float: none;
  font-weight: bold;
  font-size: 16px;
  color: #ff0;
}

#mbox_right p {
  float: left;
  width: 785px;
  padding: 5px;
  padding-left: 10px;
  margin: 0;
}

#mbox_right #pshow {
  float: left;
  width: 785px;
  padding: 5px;
  padding-bottom: 10px;
  padding-left: 10px;
  margin: 0;
  border-bottom: 1px solid #C0C0C0;
}

#mbox_right .domainbox {
  float: left;
  width: 671px;
  padding: 10px;
  padding-left: 10px;
  margin: 0;
  margin-bottom: 1px;
  background: #F7E7E7;
}

#mbox_right label {
  float: left;
  font-size: 15px;
  font-weight: bold;
  width: 700px;
}

#mbox_right label em {
  font-style: normal;
  font-weight: normal;
  font-size: 12px;
  color: #666;
  margin-left: 10px;
}

#mbox_right p span {
  float: left;
  margin: 3px 0;
  margin-left: 10px;
}

#mbox_right p span em {
  float: left;
  width: auto;
  margin-top: 2px;
  margin-right: 5px;
}

#mbox_right p .btnimgbox {
  float: left;
  width: 82px;
  height: 31px;
  margin-top: 2px;
  background: url(/img/backgroundManage/supplier/ggdp_btn_01.gif) no-repeat;
}

#mbox_right p .btnimgbox iframe {
  width: 82px;
  height: 31px;
  filter: alpha(opacity =                                                   0);
  -moz-opacity: 0;
  opacity: 0;
}

#mbox_right p .btnrarbox {
  float: left;
  width: 100px;
  height: 31px;
  margin-top: 2px;
  background: url(/img/backgroundManage/supplier/ggdp_btn_02.gif) no-repeat;
}

#mbox_right p .btnrarbox iframe {
  width: 100px;
  height: 31px;
  filter: alpha(opacity =                                                   0);
  -moz-opacity: 0;
  opacity: 0;
}

#mbox_right span em {
  float: left;
  margin-right: 5px;
  font-style: normal;
}

#mbox_right span input {
  font-size: 12px;
  font-weight: bold;
  padding: 3px;
  font-family: "Tahoma", "微软雅黑";
}

#mbox_right span #ProductMemo {
  width: 771px;
  height: 550px;
}

#mbox_right .domaintable {
  font-size: 16px;
  font-weight: bold;
  color: #666;
}

#mbox_right .domaintable em {
  color: #B20F0A;
}

#mbox_right strong {
  float: left;
  width: 650px;
  font-weight: normal;
  color: #666;
}

#mbox_right .btnbox {
  float: left;
  padding: 5px;
  padding-left: 10px;
  margin: 0;
  text-align: left;
}

#mbox_right .btnbox #preview_btn {
  margin: 0;
  border: 0px;
  width: 161px;
  height: 40px;
  background: url(/img/backgroundManage/supplier/preview_btn.gif) no-repeat;
}

.regbutton {
  margin: 0;
  margin-top: 8px;
  padding: 0;
  border: 0;
  background: url(/img/backgroundManage/supplier/ggdp_btn_03.gif) no-repeat;
  width: 161px;
  height: 40px;
}
</style>

<!-- 私有js -->
<script charset="utf-8" src="/js/background/supplier/editor/kindeditor-min.js"></script>
<script charset="utf-8" src="/js/background/supplier/zh_CN.js"></script>
<script type="text/javascript" src="/js/background/supplier/swfupload.js"></script>
<script type="text/javascript" src="/js/background/supplier/handlers.js"></script>
<script type="text/javascript" src="/js/common/jquery-1.9.1.min.js"></script>

<!-- 页面标题==========================================-->
<title>用户中心-产品列表</title>

<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.min.js"></script>
      <script src="/resources/js/respond.min.js"></script>
      <script src="/resources/js/jquery.js"></script>
      <script src="/js/userCenter/productListView.js"></script>
    <![endif]-->
</head>
<body>

  <!-- 导航==========================================-->
  <%@include file="/jsp/common/nav.jsp"%>

  <!-- 内容==========================================-->
  <div class="content">

    <!-- 二级导航和左侧导航==========================================-->
    <%@include file="/jsp/userCenter/supplier/subNav.jsp"%>

    <div id="sitebody">

      <div id="mbox_right">

        <form action="" method="post" data-pid="${product.id}" name="modproduct" id="modproduct" onsubmit="return checksubmit();">
          <input type="hidden" name="ID" value="${product.id}" id="product_id" /> <input type="hidden" id="index_image" name="index_image"
            value="${product.indexImage}" />
          <p>
            <label>人气状态<em>(当前人气：${product.productStats.downCountAlltime+product.productStats.taobaoCountAlltime}下载${product.productStats.downCountAlltime}/发布到淘宝：${product.productStats.taobaoCountAlltime})，此项目设置隐藏或显示产品详情页面上的下载及发布到淘宝人气数据。</em></label>
            <c:choose>
              <c:when test="${product.isHideStats  eq 1}">
                <span style="width: 400px;"><em> <input type="radio" id="is_hide_stats" name="is_hide_stats" value="0" />显示下载人气
                </em> <em style="margin-left: 20px;"><input type="radio" id="is_hide_stats" name="is_hide_stats" value="1" checked />隐藏下载人气</em></span>
              </c:when>
              <c:otherwise>
                <span style="width: 400px;"><em><input type="radio" id="is_hide_stats" name="is_hide_stats" value="0" checked />显示下载人气</em><em
                  style="margin-left: 20px;"><input type="radio" name="is_hide_stats" value="1" />隐藏下载人气</em></span>
              </c:otherwise>
            </c:choose>
          </p>

          <p>
            <label>商品货号<em>请注意商品货号的唯一性！</em></label> <span><em><input type="text" name="ItemID" size="15" maxlength="15"
                value="${product.articleNumber}" id='checkArticleNumber' disabled="disabled" readonly="readonly" /></em></span><span class="stau1"
              id="checkspan"></span>
          </p>
          <p>
            <label>材质特点<em>请尽量简短，如：真皮！</em></label> <span><em><input id="characters" type="text" name="goods" size="30"
                maxlength="30" value="${product.characters}" /></em></span>
          </p>
          <p>
            <label>尺码范围<em>每个尺码用逗号隔开，如：34,35,36,37,38,39</em></label> <span><em><input id="size" type="text" name="size"
                size="40" maxlength="150" value="${product.size}" /></em></span>
          </p>
          <p>
            <label>产品首图<em>尺寸推荐800*800，用于淘宝商品首图！只支持jpg格式</em></label> <span> <em><img
                <c:choose>
            <c:when test="${product.indexImage ne '' }">
                src="http://thumb.ximgs.net${fn:substringBefore(product.indexImage, '.')}_160x160.jpg"
                </c:when>
                <c:otherwise>
                src="/img/load_img.gif"
                </c:otherwise>
                </c:choose>
                id="iPicture" style="border: 1px solid #ccc; max-width: 160px; max-height: 160px;" /></em> <span id="spanButtonPlaceHolder"></span>
            </span>
          </p>
          <p>
            <label>批发价格</label> <span><em><input type="text" id="price" name="Price" size="16" value="${product.price}" /> 元</em></span>
          </p>
          <p>
            <label>产品数据包<em>压缩文件格式，所有本产品图片打包！</em></label> <span style="padding-left: 0;"> <em><input id="file" type="text"
                name="file" size="35" value="${product.file}" id="rar_focus" /></em> <span id="spanButtonPlaceHolder"></span>
            </span>
          </p>
          <div id="pshow">
            <label>商品详情<em>商品基本信息描述！也可以上传图片方便买家察看！</em></label> <span style="float: left; margin: 6px 0;"><textarea
                name="ProductMemo" id="ProductMemo" style="width: 774px;">${product.productMeta.descriptionBin}</textarea></span>
          </div>
          <div class="btnbox">
            <!--保存产品  -->
            <span><input type="button" class="regbutton" /></span>
            <!--预览产品页面  -->
            <span><input id="preview_btn" type="button" /></span>
          </div>
        </form>
      </div>

    </div>
  </div>
</body>

<script>
  $(function() {
    productEditPage.init();
  });
  var productEditPage = {

    init : function() {
      this.attachEventHandle();
    },
    /* HTML在线编辑器 */
    attachEventHandle : function() {
      var fullHtml;
      var editor;
      KindEditor.ready(function(K) {
        editor = K.create('textarea[name="ProductMemo"]', {
          resizeType : 0,
          allowPreviewEmoticons : false,
          allowImageUpload : false,
          filePostName : 'file',
          items : [ 'source', '|', 'forecolor', 'hilitecolor', 'fontname', 'fontsize', '|', 'bold', 'italic', 'underline', 'removeformat',
              '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist', 'insertunorderedlist', 'link', '|', 'multiimage' ]
        });
      });

      /* 保存产品编辑数据 */
      $('.regbutton').click(function() {
        fullHtml = editor.html();
        var pid = $("#modproduct").data('pid');
        $.ajax({
          type : "POST",
          url : "/manage/supplier/saveEditProduct/" + pid,
          dataType : 'json',
          data : {
            is_hide_stats : $('#is_hide_stats').val(),
            checkArticleNumber : $('#checkArticleNumber').val(),
            characters : $('#characters').val(),
            size : $('#size').val(),
            price : $('#price').val(),
            rar_focus : $('#rar_focus').val(),
            fullHtml : fullHtml
          },
          success : function(data) {
            if (data == 1) {
              alert('修改产品信息成功。');
            } else {
              alert('修改产品信息失败！！！');
            }
          }
        });
      });

      /* 预览产品 */
      $('#preview_btn').click(function() {
        fullHtml = editor.html();
        var pid = $("#modproduct").data('pid');
        var data = {
          is_hide_stats : $('#is_hide_stats').val(),
          checkArticleNumber : $('#checkArticleNumber').val(),
          characters : $('#characters').val(),
          size : $('#size').val(),
          price : $('#price').val(),
          fullHtml : fullHtml
        };
        if (is_hide_stats && checkArticleNumber && characters && size && price && fullHtml && pid) {
          $.ajax({
            type : "POST",
            url : "/getPreview/" + pid,
            //dataType : 'json',
            data : {
              is_hide_stats : $('#is_hide_stats').val(),
              checkArticleNumber : $('#checkArticleNumber').val(),
              characters : $('#characters').val(),
              size : $('#size').val(),
              price : $('#price').val(),
              rar_focus : $('#rar_focus').val(),
              fullHtml : fullHtml
            },
            complete: function() {
              location.href = "/getPreview/" + pid;
            },
            error : function(error) {
              alert("失败" + error);
            }
          });
        } else {
          alert('请检查参数,不能为空！')
        }
      });
    }
  }

  /* 产品图片包 */
  $("#rar_focus").focus();
  $("#rar_focus").select();
  var swfu_img, swfu_zip;

  window.onload = function() {
    var img_settings = {
      flash_url : "/js/background/supplier/swfupload.swf",
      file_size_limit : "10 MB",
      file_types : "*.jpg",
      file_types_description : "图片",
      file_upload_limit : 1,
      file_queue_limit : 0,
      file_post_name : 'file',
      button_window_mode : 'transparent',
      custom_settings : {
        progressTarget : "fsUploadProgress"
      },
      debug : false,

      // Button settings
      button_image_url : "/img/backgroundManage/supplier/ggdp_btn_04.gif",
      button_width : "82",
      button_height : "31",
      button_placeholder_id : "spanButtonPlaceHolder",
      button_text : '',
      button_text_style : ".theFont { font-size: 16; }",
      button_text_left_padding : 12,
      button_text_top_padding : 3,

      // The event handler functions are defined in handlers.js
      file_queued_handler : fileQueued,
      file_queue_error_handler : fileQueueError,
      file_dialog_complete_handler : fileDialogComplete,
      upload_start_handler : uploadStart,
      upload_progress_handler : uploadProgress,
      upload_error_handler : uploadError,
      upload_success_handler : uploadSuccess,
      upload_complete_handler : uploadComplete,
      queue_complete_handler : queueComplete
    // Queue plugin event
    };
    var zip_settings = {
      flash_url : "/js/background/supplier/swfupload.swf",
      file_size_limit : "100 MB",
      file_types : "*.rar;*.zip;*.7z",
      file_types_description : "压缩包",
      file_upload_limit : 5,
      file_queue_limit : 0,
      file_post_name : 'file',
      button_window_mode : 'transparent',
      custom_settings : {
        progressTarget : "spanButtonPlaceHolder_zip"
      },
      debug : false,

      // Button settings
      button_image_url : "/img/backgroundManage/supplier/ggdp_btn_05.gif",
      button_width : "100",
      button_height : "31",
      button_placeholder_id : "spanButtonPlaceHolder",
      button_text : '',
      button_text_style : ".theFont { font-size: 16; }",
      button_text_left_padding : 12,
      button_text_top_padding : 3,

      // The event handler functions are defined in handlers.js
      file_queued_handler : fileQueued,
      file_queue_error_handler : fileQueueError,
      file_dialog_complete_handler : fileDialogComplete,
      upload_start_handler : uploadStart,
      upload_progress_handler : uploadProgress,
      upload_error_handler : uploadError,
      upload_success_handler : uploadSuccess,
      upload_complete_handler : uploadComplete,
      queue_complete_handler : queueComplete
    // Queue plugin event
    };
    swfu_img = new SWFUpload(img_settings);
    swfu_zip = new SWFUpload(zip_settings);
  };
  function checksubmit() {
    var mycs = "true";
    if (modproduct.ItemID.value == "") {
      mycs = "false";
      alert("请填写商品货号！");
      modproduct.ItemID.focus();
      return false;
    }
    if (modproduct.index_image.value == "") {
      mycs = "false";
      alert("请上传商品首图！");
      return false;
    } else {
      var arr = modproduct.index_image.value.split(".");
      var image_ext_name = arr[arr.length - 1].toLowerCase();
      if (image_ext_name != 'jpg') {
        mycs = "false";
        alert("商品首图格式不对！");
        return false;
      }
    }
    if (modproduct.Price.value == "" || modproduct.Price.value.match(/^\d+\.?\d*$/) == null) {
      mycs = "false";
      alert("请填写批发价格,或者批发价格格式不对");
      modproduct.Price.focus();
      modproduct.Price.value = '';
      return false;
    }
    if (modproduct.index_image.value.indexOf("正在上传") >= 0) {
      mycs = "false";
      alert("正在上传商品首图，等待上传完成！");
      return false;
    }
    ;
    if (modproduct.file.value.indexOf("正在上传") >= 0) {
      mycs = "false";
      alert("正在上传商品数据包，等待上传完成！");
      return false;
    }
    ;
    if (modproduct.file.value.match(/!error$/)) {
      mycs = "false";
      alert("您上传的产品数据包有错误，请重新上传！");
      return false;
    }
    if (mycs == "true") {
      return true;
    }
  }

  var isApply = $
  {
    isApply
  };
  function form_submit(path, act) {
    editor.sync('#ProductMemo');
    $('#modproduct').attr('action', path);
    if (act == 'pre') {
      $('#modproduct').attr('target', '_blank');
    }
    if (isApply) {
      alert('该产品参加活动中，暂时无法编辑');
      return false;
    }
    $('#modproduct').submit();
  }
</script>