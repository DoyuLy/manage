;(function($,_){
	var GO2 = {};
	// toolbar
	GO2.toolbar = (function(_this){
		_this.click(function(){
			console.log('zhixun');
		});
	})($('.J_ServerQQ'));
	// header
	GO2.header = (function(){
		//搜索类型切换
		var triggers= (function (_this) {
			//wraper-triggers
			_this.bind({
				mouseenter:function(){
					$(this).removeClass('tog-wraper').addClass('tog-hover').find('.trigger').removeClass('selected');
				},
				mouseleave:function(){
					$(this).removeClass('tog-hover').addClass('tog-wraper').find('.trigger').eq(0).addClass('selected');
				},
				click:function(e){
					if($(e.target).parents('.triggers') != -1 && $(e.target).index() != 0){
						$(e.target).insertBefore($('.triggers a:eq(0)'));
						//TSearchForm-type
						$('#J_SearchType').val($(e.target).attr('data-searchtype'));
						_this.removeClass('tog-hover').addClass('tog-wraper').find('.trigger').eq(0).addClass('selected');
					}
				}
			});
		})($('#J_HeaderSearchTab'));
		//搜索框模糊匹配。历史记录
		var relevances = {
			init:function(){
				this.bindings();
			},
			bindings:function(){
				//focus
				$('#J_SearchTxt').bind({
					focus:function(){
						console.log('focus')
					},
					blur:function(){
						console.log('blur')
					},
					click:function(){return false;},
					keydown:function(){
						alert('ok')
					}
				});
			},
		}
		return {
			relevances:relevances
		};
	})();

	GO2.header.relevances.init();
	
	GO2.publish = (function(selecter){
	  $(selecter).click(function(){
	    var pid = $(this).attr('data-id');
	    $.ajax({
	      url: '/publishTo/index',
	      type: 'GET',
	      data:{pid: pid},
	      dataType: 'json',
	      success: function(data){
	        console.log(data);
	        //window.open("http://localhost:8080/");调整props json转换方法，添加发布到淘宝的基本验证、跳转
	        if(data.state == 0)
	          window.location.href=data.url;
	        else
	          alter("您发布过于频繁，或者已经发布超过5次");
	      }
	    });
	  });
	})("button.publishTo");

})(jQuery,_);