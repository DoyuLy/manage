$(function() {
  sellerList.init();
})

var sellerList = {
  ids : [],
  init : function() {
    this.attachEventHandler();
  },

  attachEventHandler : function() {
    var _this = this;
    $(".select-all").change(function() {
      var flag = $(this).prop("checked");
      if(flag){
        $('.id-checkbox').each(function() {
          _this.ids.push($(this).val());
        });
      }else{
        _this.ids = [];
      }
      $(".id-checkbox").prop('checked', flag);
    });
  },
  deleteItem : function(url) {
    GO2.json(url, {ids :this.ids}, function(data) {
      if (data > 0) {
        location.href = location.href;
      }
    })
  }
}
