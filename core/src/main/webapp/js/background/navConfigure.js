/**
 * 配置导航条
 */

$(function() {
  navConfigure.init();
})

var navConfigure = {
  curTr : null,
  init : function() {

    this.attachEventHandler();
  },
  attachEventHandler : function() {
    var _this = this;
    $('.nav_del').on('click', function() {
      var id = $(this).data('id');
      var that = this;
      $.ajax({
        url : '/manage/delNavBar/' + id,
        type : 'POST',
        dataType : 'json',
        data : {
          id : id
        },
        success : function(data) {
          if (data > 0) {
            $(that).parents('tr').remove();
          }
        }
      })
    });

    $(".nav_update").on('click', function() {
      _this.curTr = $(this).parents('tr');
      var oldVal = {
        id : $(this).data('id'),
        'area' : $(this).closest("tr").find("td:nth-child(1)").text(),
        'subdomain' : $(this).closest("tr").find("td:nth-child(2)").text(),
        'name' : $(this).closest("tr").find("td:nth-child(3)").text(),
        'weights' : $(this).closest("tr").find("td:nth-child(4)").text()
      };

      var bh = $("body").height();
      var bw = $("body").width();
      var a = '';
      a += '<table><tr><td>板块: <input type="text" name="area" value="' + oldVal.area + '" ></td></tr>';
      a += '<tr><td>导航栏域名: <input type="text" name="subdomain" value="' + oldVal.subdomain + '" ></td></tr>';
      a += '<tr><td>导航栏名称: <input type="text" name="name" value="' + oldVal.name + '" ></td></tr>';
      a += '<tr><td>导航栏排序权重: <input type="text" name="weights" value="' + oldVal.weights + '" ></td></tr>';
      a += '<tr><td><input type="hidden" name="id" value="' + oldVal.id + '" ></td></tr>';
      a += '</table>';

      $("#fullbg").css({
        height : bh,
        width : bw,
        display : "block"
      });
      $("#b").html(a);
      $("#dialog").show();
    });

    $('#update').on('click', function() {
      var that = this;
      var id = $('input[name="id"]').val();
      var area = $('input[name="area"]').val();
      var subdomain = $('input[name="subdomain"]').val();
      var name = $('input[name="name"]').val();
      var weights = $('input[name="weights"]').val();

      $.ajax({
        type : "POST",
        url : "/manage/updateNavBar/",
        data : {
          id : id,
          area : area,
          subdomain : subdomain,
          name : name,
          weights : weights
        },
        dataType : 'json',
        success : function(data) {
          if (data > 0) {
            _this.curTr.find('.area').html(area);
            _this.curTr.find('.navigationSubdomain').html(subdomain);
            _this.curTr.find('.navigationName').html(name);
            _this.curTr.find('.navigationWeights').html(weights);
          }
        }
      });
      _this.closeBg();
    })
  },
  closeBg : function() {
    $("#fullbg,#dialog").hide();
  }

}
