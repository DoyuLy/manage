$(function() {
  $('#cartPanel').click(function() {
    loadCartItem();
  });
  $('#cartTable').delegate('button.del','click', function() {
    param = {
      id : $(this).parents('tr').find('input[type="checkbox"]').attr('iid'),
      type : 'r'
    }
    url = ctx + '/app/http/adp/shoppingCartHandler/removeItem';
    $.util.ajax(url, param, function(data) {
      refreshCart();
    }, null);
    $(this).parents('tr').remove();
  });
  $('#model_submit').click(function(){
    var ids='';
    $('#cartTable tbody input[type="checkbox"]').each(function(i,o){
      if($(o).prop('checked')){
        ids+=$(o).attr('iid')+',';
      }
    });
    window.open(ctx+'/app/http/adp/applyHandler/apply?ids='+ids);   
  });
});

function refreshCart() {
  cartCookie = $.util.getCookie('cart');
  x = cartCookie.split(',');
  if (x[0]) {
    x = x.length - 1;
    $('#cartSize').text(x);
    if (x < 10) {
      $('#cartSize').css('left', '26px');
    } else {
      $('#cartSize').css('left', '19px');
    }
  }
}

function loadCartItem() {
  cartItems = $.util.getCookie('cart').replace(/"/g, "");
  array = cartItems.split(',');
  var rids = '', aids = '';
  $.each(array, function(i, o) {
    if (o.indexOf('r_') == 0) {
      rids += o.substring(2) + ',';
    } else if (o.indexOf('a_') == 0) {
      aids += o.substring(2) + ',';
    }
  });
  param = {
    rids : rids,// 资源目录的Id
    aids : aids
  // 应用的Id
  }
  url = ctx + '/app/http/adp/shoppingCartHandler/getCartList';
  $.util.json(url, param, function(data) {
    $('#cartTable tbody').empty();
    var html;
    $.each(data, function(i, o) {
      html = '<tr><td>';
      if (o.resourceId) {
        html += '<input type="checkbox" iid="' + o.resourceId + '" checked/></td>' + '<td>信息资源</td>' + '<td>' + o.resourceName + '</td>' + '<td>'
            + o.provider.orgName + '</td>' + '<td>' + (o.remark ? o.remark : "暂无描述信息") + '</td>'
            + '<td><button class="btn btn-danger del"><i class="fa fa-trash-o fa-lg"></i></button></td></tr>';
      } else {
        html += '<input type="checkbox" iid="?"/></td>' + '<td>应用</td>'
      }
      $('#cartTable tbody').append(html);
    });
    $('#myCart').modal('show');
  }, null);
}