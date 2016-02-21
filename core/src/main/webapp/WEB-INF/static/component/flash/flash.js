/**
 * 生成flash嵌入代码
 * @since 2010-3-5 刘飞<br>
 *        版本：1.0
 * @param id 生成swf的id
 * @param value swf文件地址
 * @param width swf宽度
 * @param height swf 高度
 * @return 返回html嵌入范例代码
 */
function createSwfCode(id, value, width, height) {
    var str = '';
    str +=
	'<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="'
	    + width + '" height="' + height + '" id="' + id + '" align="middle">';
    str += '<param name="allowScriptAccess" value="always" />';
    str += '<param name="allowFullScreen" value="true" />';
    str += '<param name="wmode" value="opaque"/>';
    str +=
	'<param name="movie" value="' + value + '" /><param name="quality" value="high" /><param name="bgcolor" value="#ffffff" />';
    str +=
	'<embed src="'
	    + value
	    + '" quality="high" bgcolor="#ffffff" width="'
	    + width
	    + '" height="'
	    + height
	    + '" name="'
	    + id
	    + '" align="middle" allowScriptAccess="always" allowFullScreen="true" wmode="opaque" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer_cn" />';
    str += '</object>';
    return str;
}
/**
 * 带参数的swf控件 
 * @param id 生成swf的id
 * @param value swf文件地址
 * @param params 参数
 * @param width swf宽度
 * @param height
 * @return 返回html嵌入范例代码
 */
function createSwfCodeWithArgs(id, value, params, width, height) {
    var str = '';
    str +=
	'<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="'
	    + width + '" height="' + height + '" id="' + id + '" align="middle">';
    str += '<param name="allowScriptAccess" value="always" />';
    str += '<param name="allowFullScreen" value="true" />';
    str += '<param name="wmode" value="opaque"/>';
    str +=
	'<param name="movie" value="' + value + '?'+params+'" /><param name="quality" value="high" /><param name="bgcolor" value="#ffffff" />';
    str +=
	'<embed src="'
	    + value
	    + '?'+params+'" quality="high" bgcolor="#ffffff" width="'
	    + width
	    + '" height="'
	    + height
	    + '" name="'
	    + id
	    + '" align="middle" allowScriptAccess="always" allowFullScreen="true" wmode="opaque" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer_cn" />';
    str += '</object>';
    return str;
}
