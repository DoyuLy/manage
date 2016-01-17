$(function() {
  var form = $("#ajax-form");
  var formMessages = $("#form-messages");

  $(form).submit(function(e)){
    e.preventDefault();

    var formData=$(form).serialize();
    // formData {navigationSubdomain: '', ...}
    
    $.ajax({
      url: '/navigationBar/saveNavigationBar',
      type: 'POST',
      data: formData
    })
    .done(function(response) {
      $(formMessages).removeClass('error');
      $(formMessages).addClass('success');
      $(formMessages).text(response);
      $("area").val("");
      $("navigationSubdomain").val("");
      $("navigationName").val("");
      $("navigationWeights").val("");

    })
    .fail(function(data) {
      $(formMessages).removeClass('error');
      $(formMessages).addClass('success');
    if (data.responseText!=="") {
      $(formMessages).text(data.responseText);
    }else{
      $(formMessages).text("信息提交失败");
    };
    );
    
  }
})