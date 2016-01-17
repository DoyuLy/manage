// 黑名单管理
$(function() {
  blackListModal.init();
})

var blackListModal = {
  curRow : null,
  init : function() {
    this.attachEventHandler();
  },

  attachEventHandler : function() {
    var _this = this;

    // 添加黑名单提交
    $('.sub-btn').on('click', function() {
      _this.submit();
    });
  },
  // 弹窗层
  modal : function(supplierId,supplierTitle) {
    var bh = $("body").height();
    var bw = $("body").width();

    $.ajax({
      url : '/userCenter/seller/blackListOption',
      type : 'GET',
      success : function(data) {
        if (data.length > 0) {
          $("#b").html(data);
          if (supplierTitle!=null && supplierTitle!="") {
            $('select#supplierId').attr("disabled", true);
            $('select#supplierId').replaceWith("<label for='supplier-label'>"+supplierTitle+"</label><input name='supplier-label' id='supplierId' type='hidden' value='"+supplierId+"'>");
          } else {
            $('select#supplierId').attr("disabled", false);
          }
        }
      }
    })

    $("#fullbg").css({
      height : bh,
      width : bw,
      display : "block"
    });

    $("#dialog").show();
  },

  // 数据提交层
  submit : function() {
    var supplierId = $('#supplierId').val();
    var comment = $('#comment').val();

    var addBlackList = {
      supplierId : supplierId,
      comment : comment
    };
    $.ajax({
      url : '/userCenter/seller/addBlackList',
      type : 'POST',
      data : addBlackList,
      dataType : 'json',
      contentType : "application/x-www-form-urlencoded; charset=utf-8",
      success : function(data) {
        if (data == 1) {
          location.href =location.href;
        }
      }
    })
  },

  // 关闭弹窗
  closeBox : function() {
    $("#fullbg,#dialog").hide();
  }
}
