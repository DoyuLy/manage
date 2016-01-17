function challs_flash_update(){
	var a={};
	a.title = "上传图片包或产品数据包";
	a.FormName = "file";							//设置Form表单的文本域的Name属性
	a.url= '/userCenter/supplier/upload'; 			//设置服务器接收代码文件
	a.parameter = 'c=image_upload&usage=publish&type=zipfile&sub_dir=supplier&signature=ce39601160b826fa7fa9cb4fc7a082de';
	//a.typefile=["压缩文件(*.7z,*.rar,*.zip,*.kz)","*.7z;*.rar;*.zip;*.kz"];		//设置可以上传文件 数组类型
	a.UpSize=0;										//可限制传输文件总容量，0或负数为不限制，单位MB
	a.fileNum=0;									//可限制待传文件的数量，0或负数为不限制
	a.size=1000;									//上传单个文件限制大小，单位MB，可以填写小数类型
	//a.FormID=['UserID','uptype'];					//设置每次上传时将注册了ID的表单数据以POST形式发送到服务器
	a.autoClose=0;									//上传完成条目，将自动删除已完成的条目，值为延迟时间，以秒为单位，当值为 -1 时不会自动关闭，注意：当参数CompleteClose为false时无效
	a.CompleteClose=true;							//设置为true时，上传完成的条目，将也可以取消删除条目，这样参数 UpSize 将失效, 默认为false
	a.repeatFile=true;								//设置为true时，可以过滤用户已经选择的重复文件，否则可以让用户多次选择上传同一个文件，默认为false
	a.returnServer=false;							//设置为true时，组件必须等到服务器有反馈值了才会进行下一个步骤，否则不会等待服务器返回值，直接进行下一步骤，默认为false
	return a ;
}
function challs_flash_onComplete(a){}
function challs_flash_onError(a){}
function challs_flash_onCompleteData(a){
    console.log(a);
}
function challs_flash_onStart(a){}
function challs_flash_onCompleteAll(a){
	if(a==0){
		alert('上传图片成功! 您的商品将在24小时内在网站显示,请勿重复上传。')
	}else{
		alert("已经收到您传过来的图片包！其中有"+a+"个上传失败，请取消并重新上传！");
	}
}

//使用FormID参数时必要函数
function challs_flash_FormData(a){ 
	try{
		var value = '';
		var id=document.getElementById(a);
		if(id.type == 'radio'){
			var name = document.getElementsByName(id.name);
			for(var i = 0;i<name.length;i++){
				if(name[i].checked){
					value = name[i].value;
				}
			}
		}else if(id.type == 'checkbox'){
			if(id.checked){
				value = id.value;
			}
		}else{
			value = id.value;
		}
		return value;
	 }catch(e){
		return '';
	 }
}


$(function(){ fastPublishView.init(); });

var fastPublishView = {
		
	flashOpts: null,
	uploadUrl: '/userCenter/supplier/upload',
	uploadUri: 'c=image_upload&usage=publish&type=zipfile&sub_dir=supplier&signature=ce39601160b826fa7fa9cb4fc7a082de',
	format_error: false,
	init: function(){
		
		this.uploadUri = '';
		
		this.flashOpts = {
			title: '上传图片包或产品数据包',
			FormName: 'file',              //Form表单的文本域的Name属性
			url: this.uploadUrl,           //设置服务器接收代码文件
			parameter: this.uploadUri,	   //get方式提交
			//typefile: ["压缩文件(*.7z,*.rar,*.zip,*.kz)","*.7z;*.rar;*.zip;*.kz"],
			UpSize: 0,                     //限制传输文件总容量，0或负数为不限制，单位MB
			fileNum: 0,                    //限制待传文件的数量，0或负数为不限制
			size: 1024,                    //传单个文件限制大小，单位MB，可以填写小数类型
			autoClose: 0,                  //上传完成条目，将自动删除已完成的条目，值为延迟时间，以秒为单位，当值为 -1 时不会自动关闭，注意：当参数CompleteClose为false时无效
			CompleteClose: true,           //设置为true时，上传完成的条目，将也可以取消删除条目，这样参数 UpSize 将失效, 默认为false
			repeatFile: true,			   //设置为true时，可以过滤用户已经选择的重复文件，否则可以让用户多次选择上传同一个文件，默认为false
			returnServer: false			   //设置为true时，组件必须等到服务器有反馈值了才会进行下一个步骤，否则不会等待服务器返回值，直接进行下一步骤，默认为false
		}
	},
	challs_flash_onComplete: function(a){
		console.log(a.fileName+'/'+a.fileSize+'/'+a.updateTime/1000+'/'+a.fileType)
	},
	challs_flash_onError: function(a){
		console.log(a.textErr);
		console.log(a.fileName);
		console.log(a.fileSize);
		console.log(a.fileType);
	},
	challs_flash_onCompleteData: function(a){
		console.info(a);
		if(msg.error==1) {
	    	alert(msg.message); 
	    	this.format_error = true;
	  	}
	},
	challs_flash_onStart: function(a){},
	challs_flash_deleteAllFiles: function(){return confirm("你确定要清空列表吗?");},
	challs_flash_onCompleteAll: function(a){
		if(a==0){
			alert('上传图片成功! 您的商品将在24小时内在网站显示,请勿重复上传。')
		}else{
			alert("已经收到您传过来的图片包！其中有"+a+"个上传失败，请取消并重新上传！");
		}
	},
	// 使用FormID参数时必要函数
	challs_flash_FormData: function(a){
		try{
			var value = '';
			var id=document.getElementById(a);
			if(id.type == 'radio'){
				var name = document.getElementsByName(id.name);
				for(var i = 0;i<name.length;i++){
					if(name[i].checked){
						value = name[i].value;
					}
				}
			}else if(id.type == 'checkbox'){
				if(id.checked){
					value = id.value;
				}
			}else{
				value = id.value;
			}
			return value;
		 }catch(e){
			return '';
		 }
	}
}
