/**
 * 自助发布
 */
$(function() { selfPublishView.Init(); });

var selfPublishView = {
		
	uploadImageUrl : "",
	uploadZipfileUrl : "",
	imageSetting: null,
	zipSettings: null,
	swf_img: null,
	swf_zip: null,
	
	Init : function() {
		var _this = this;
		this.uploadImageUrl = "";
		this.uploadZipfileUrl = "";
		
		// initialize kindEditor component
		KindEditor.ready(function(K) {
			var editor = K.editor({
				allowFileManager : true
			});
			editor = K.create('textarea[name="ProductMemo"]', {
				resizeType : 0,
				allowPreviewEmoticons : false,
				allowImageUpload : false,
				uploadJson : _this.uploadImageUrl,
				filePostName : 'file',
				items : [ 'source', '|', 'forecolor', 'hilitecolor', 'fontname', 'fontsize', '|', 'bold', 'italic',
						'underline', 'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', 'link', '|', 'multiimage' ]
			});

		});
		
		this.imageSetting = {
			flash_url : "/scripts/editor/plugins/multiimage/images/swfupload.swf",
			upload_url:_this.uploadImageUrl,
			file_size_limit : "10 MB",
			file_types : "*.jpg",
			file_types_description : "图片",
			file_upload_limit : 1,
			file_queue_limit : 0,
			file_post_name :'file',
			button_window_mode:'transparent',
			custom_settings : {
				progressTarget : "fsUploadProgress"
			},
			debug: false,

			// Button settings
			button_image_url: "/images/ggdp_btn_04.gif",
			button_width: "82",
			button_height: "31",
			button_placeholder_id: "spanButtonPlaceHolder",
			button_text: '',
			button_text_style: ".theFont { font-size: 16; }",
			button_text_left_padding: 12,
			button_text_top_padding: 3,
			
			// The event handler functions are defined in handlers.js
			file_queued_handler : fileQueued,
			file_queue_error_handler : fileQueueError,
			file_dialog_complete_handler : fileDialogComplete,
			upload_start_handler : uploadStart,
			upload_progress_handler : uploadProgress,
			upload_error_handler : uploadError,
			upload_success_handler : uploadSuccess,
			upload_complete_handler : uploadComplete,
			queue_complete_handler : queueComplete	// Queue plugin event
		};
		
		this.zipSettings = {
			flash_url : "/scripts/editor/plugins/multiimage/images/swfupload.swf",
			upload_url:_this.uploadZipfileUrl,
			file_size_limit : "100 MB",
			file_types : "*.rar;*.zip;*.7z",
			file_types_description : "压缩包",
			file_upload_limit : 5,
			file_queue_limit : 0,
			file_post_name :'file',
			button_window_mode:'transparent',
			custom_settings : {
				progressTarget : "spanButtonPlaceHolder_zip"
			},
			debug: false,

			// Button settings
			button_image_url: "/images/ggdp_btn_05.gif",
			button_width: "100",
			button_height: "31",
			button_placeholder_id: "spanButtonPlaceHolder_zip",
			button_text: '',
			button_text_style: ".theFont { font-size: 16; }",
			button_text_left_padding: 12,
			button_text_top_padding: 3,
			
			// The event handler functions are defined in handlers.js
			file_queued_handler : fileQueued,
			file_queue_error_handler : fileQueueError,
			file_dialog_complete_handler : fileDialogComplete,
			upload_start_handler : uploadStart,
			upload_progress_handler : uploadProgress,
			upload_error_handler : uploadError,
			upload_success_handler : uploadSuccess,
			upload_complete_handler : uploadComplete,
			queue_complete_handler : queueComplete	// Queue plugin event
		};
		
		//initialize upload object with setting
		this.swf_img = new SWFUpload(this.imageSetting);
		this.swf_zip = new SWFUpload(this.zipSettings);
		
		this.AttachEventHandler();
	},
	
	AttachEventHandler: function(){
		var _this = this;
		//判断商品货号是否存在
		var $articleNum = $("#checkArticleNumber");
		$articleNum.focus(function(){
			$('#articleNumberSpan').attr('class','stau2').html('输入商品货号');					 
	    });
		$articleNum.blur(function(){
			var articleNumber = $articleNum.val();
			var transcode = '';
			if(articleNumber){
				//半角转换
				transcode = _this.Util.SemiangleEncode.apply(_this, [articleNumber]);
				articleNumber = transcode;
				$articleNum.val(articleNumber);
				
				//非法字符过滤
				var regex = /^[A-Za-z0-9\-]+$/gi;
				var disregex = /[^A-Za-z0-9\-]/gi;
				var advice = articleNumber;
				if(!articleNumber.match(regex)){
					advice = articleNumber.replace(disregex,'') + (Math.random()*10).toFixed(0);
					$articleNum.val(advice);
					_this.Util.ShowMsg($('#articleNumberSpan'), '商品货号'+ articleNumber +'格式不对,建议货号:'+advice);
				}
				
				
				//验证
				articleNumber = encodeURIComponent(advice);
//				post('/userCenter/supplier/selfPublish/checkArticlekNum',{articleNumber: articleNumber}, null).then(function(res){
//					
//				});
				$.post('/userCenter/supplier/checkArticlekNum', {articleNumber: articleNumber, x:Math.random()}, function(data){
					if(data == 1){
						$('#articleNumberSpan').attr('class','stau4').html('可以使用');
					}else{
						$('#articleNumberSpan').attr('class','stau3').html(data);
					 	articleNumber += (Math.random()*10).toFixed(0);
					 	_this.Util.ShowMsg($('#articleNumberSpan'),'建议货号:' + articleNumber);
					}
				});
			}else{
				$('#articleNumberSpan').attr('class','stau3').html('请输入商品货号');
			}
		});
	},
	
	Util:{
		SemiangleEncode: function(str){
			var transStr = '', transcode = '', is_q = false;
			for(var i=0; i< str.length; i++){
				transcode = str.charCodeAt(i);
				if(((transcode>65248) && transcode<65375 ) || (transcode==12288)){
					is_q = true;
					if(transcode != 12288){
						transStr += String.fromCharCode(transcode - 65248);
					}
				}else{
					transStr += String.fromCharCode(transcode);
				}
			}
			if(is_q) this.Util.ShowMsg($('#articleNumberSpan'), '全角字符已自动替换为半角字符');
			return transStr;
		},
		ShowMsg: function(obj, msg){
			obj.after('<span class="stau3 tip">' + msg + '</span>');
			setTimeout(function(){
				obj.next('.tip').remove();
			},3000);
		}
	},
	
	Submit: function(){
		/**
		 * 上传数据格式 
		 **/
		var flag = true, msg = '';
		if(modproduct.ItemID.value == ''){
			flag = false;
			msg = '请填写商品货号';
			modproduct.ItemID.focus();
		}
		if(modproduct.index_image.value == ''){
			flag = false;
			msg = '请上传商品首图';
		}else{
			//validate file format
			var format = modproduct.index_image.value.split('.')[1].toLowerCase();
			if(format != 'jpg' && format != 'png'){
				flag = false;
				msg = '商品首图格式不对';
			}
		}
		if(modproduct.Price.value == '' || modproduct.Price.value.match(/^\d+\.?\d*$/) == null){
			flag = false;
			msg = '请填写散拿价,或者散拿价格式不对';
			modproduct.Price.focus().value = '';
		}
		if(modproduct.Wholesale_price.value == '' && modproduct.Wholesale_price.value.match(/^\d+\.?\d*$/) == null){
			flag = false;
			msg = '整拿价格式不对';
			modproduct.Wholesale_price.focus().value = '';
		}
		if(parseInt(modproduct.Wholesale_price.value) > parseInt(modproduct.Price.value)) {
			flag = false;
			msg = '整拿价不能高于散拿价';
			modproduct.Wholesale_price.focus().value = "";
		}
		if(modproduct.index_image.value.indexOf("正在上传")>=0){
			flag = false;
			msg = '正在上传商品首图，等待上传完成！';
		}
		if(modproduct.file.value.indexOf("正在上传") >= 0){
			flag = false;
			msg = '正在上传商品数据包，等待上传完成！';
		}
		if(modproduct.file.value.match(/!error$/)){
			flag = false;
			msg = '您上传的产品数据包有错误，请重新上传！';
		}
		alert(msg);
		if(flag) return true;
	}
}