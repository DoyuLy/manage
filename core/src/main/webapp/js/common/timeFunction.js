//将时间转换函数
$(function() {
  timeFunction.init();
})

var timeFunction = {
  now : null,
  timeDiff : null,
  init : function() {
    this.now = new Date().getTime();
    this.attachEventHandler();
  },
  attachEventHandler : function() {
    var _this = this;
    $('.time-ago').each(function(i, obj) {
      _this.timeDiff = _this.now - Date.parse($(this).text().trim());
      $(this).text(GO2.convTimeAgo(_this.timeDiff));

    });
  }
}
