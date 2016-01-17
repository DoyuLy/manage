
/**
 * 创建GUID
 * @param null
 * @return GUID
 */
jQuery.fn.NewGuid = function () {
    function G() {
        return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
    }
    var guid = (G() + G() + "-" + G() + "-" + G() + "-" + G() + "-" + G() + G() + G()).toUpperCase();
    return guid;
};

/**
 * 判断是否日期格式
 * @param string
 * @return boolean
 */
jQuery.fn.isDate = function (value) {//形如 2008-07-22
    if (!value) return false;
    var r = value.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/); //形如 2008-07-22
    if (r == null) return false;
    var d = new Date(r[1], r[3] - 1, r[4]);
    return (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d.getDate() == r[4]);
};

/**
 * 比较日期大小
 * @param 日期1
 * @param 日期2
 * @return boolean
 */
jQuery.fn.compareDate = function (value1, value2) {
    if (!value1 || !value2) return false;
    var r1 = value1.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
    var r2 = value2.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
    if (r1 == null || r2 == null) return false;
    var d1 = new Date(r1[1], r1[3] - 1, r1[4]);
    var d2 = new Date(r2[1], r2[3] - 1, r2[4]);
    return (d1<=d2);
};

/**
 * 是否日期(全格式)
 * @param string
 * @return boolean
 */
jQuery.fn.isDateTime = function (str) {//形如 (2008-07-22 13:04:06)
    if (!str) return false;
    var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
    var r = str.match(reg);
    if (r == null) return false;
    var d = new Date(r[1], r[3] - 1, r[4], r[5], r[6], r[7]);
    return (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d.getDate() == r[4] && d.getHours() == r[5] && d.getMinutes() == r[6] && d.getSeconds() == r[7]);
};

/**
 * 是否IP地址
 * @param string
 * @return boolean
 */
jQuery.fn.isIpAddress = function (ip) {
    if (ip == "")
        return false;
   var  ip_ip = '(25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d|\\d)';
   var ip_ipdot = ip_ip + '\\.';
   var isIPaddress = new RegExp('^' + ip_ipdot + ip_ipdot + ip_ipdot + ip_ip + '$');
    if (ip.match(isIPaddress) == null) {
        return false;
    }
    return true;
};

/**
 * 获取HASH值
 * @param string key
 * @return string value
 */
jQuery.fn.getHashValue = function(name) {
    var nameRegExp = new RegExp("(?:\#|&|^)" + name + "=([^&]*)");
    var value = location.hash.match(nameRegExp);
    return value === null ? '' : decodeURI(value[1]);
};


/**
 * 截取指定长度字符串
 * @param 要截取的字符串
 * @param 要截取的长度
 * @return 截取后的字符串
 */
jQuery.fn.cutString = function (str, len) { //截取
    if (typeof (str) != "string") { return null; };
    if (!(/^[0-9]*[1-9][0-9]*$/).test(len)) { return str; };
    if (len == 0) { return str; };
    var sum = 0, newStr = "";
    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) > 255) {
            sum += 2;
        } else {
            sum++;
        };
        if (sum <= len - 2) {
            newStr += str.charAt(i);
        } else {
            if (i == str.length - 1) {
                newStr += str.charAt(i);
            } else {
                newStr += "...";
            };
            break;
        };
    };
    return newStr;
};


/**
 * 获取URL参数
 * @param 要取出的参数
 * @return 取出的值
 */
jQuery.fn.QueryString = function (val) { //截取
    var uri = window.location.search;
    var re = new RegExp("" + val + "=([^&?]*)", "ig");
    return ((uri.match(re)) ? (uri.match(re)[0].substr(val.length + 1)) : "");
};

/**
 * Byte 单位转换(byte)
 * @param 数值大小
 * @return 1GB 2MB 3KB
 */
jQuery.fn.TransferSize = function (size) {
    if (isNaN(size) || size < 0) return "0 bytes";
    var val = parseFloat(1.0 * size / 1024);
    if (val > 1024) {
        val = parseFloat(1.0 * val / 1024);
        if (val > 1024) {
            val = parseFloat(1.0 * val / 1024);
            return Math.round(val * Math.pow(10, 2)) / Math.pow(10, 2) + " GB";
        }
        return Math.round(val * Math.pow(10, 2)) / Math.pow(10, 2) + " MB";
    }
    return Math.round(val * Math.pow(10, 2)) / Math.pow(10, 2) + " KB";
};

/**
 * 检查浏览器是否支持HTML5本地存储
 * @param null
 * @return boolean
 */
jQuery.fn.checkSupport = function(){
	if(typeof localStorage != "undefined") {
		return true;
	}else if(typeof sessionStorage != "undefined"){
		return true;
	}else{
		return false;
	}
};

/**
 * SessionStorage 更新/保存值
 * @param key
 * @param value
 * @return null
 */
jQuery.fn.sessionSaveOrUpdate = function(key,value){
	var hasValue = sessionStorage.getItem(key);
	if(hasValue == null || typeof hasValue == "undefined"){
		sessionStorage.setItem(key,value);
	}else{
		sessionStorage.removeItem(key);
		sessionStorage.setItem(key,value);
	}
};

/**
 * SessionStorage 取值
 * @param key
 * @return value
 */
jQuery.fn.sessionGetValue = function(key){
	var result = sessionStorage.getItem(key);
	if(result == null || typeof result == "undefined"){
		return "";
	}else{
		return result;
	}
};

/**
 * SessionStorage 删除 
 * @param key
 * @return null
 */
jQuery.fn.sessionRemove = function(key){
	var result = sessionStorage.getItem(key);
	if(result == null || typeof result == "undefined"){
		return;
	}else{
		sessionStorage.removeItem(key);
	}
};

/**
 * LocalStorage 存值或更新
 * @param key
 * @param value
 * @return null
 */
jQuery.fn.localSaveOrUpdate = function(key,value){
	var hasValue = localStorage.getItem(key);
	if(hasValue == null || typeof hasValue == "undefined"){
		localStorage.setItem(key,value);
	}else{
		localStorage.removeItem(key);
		localStorage.setItem(key,value);
	}
};

/**
 * LocalStorage 取值
 * @param key
 * @return value
 */
jQuery.fn.localGetValue = function(key){
	var result = localStorage.getItem(key);
	if(result == null || typeof result == "undefined"){
		return "";
	}else{
		return result;
	}
};

/**
 * LocalStorage 删除
 * @param key
 * @return null
 */
jQuery.fn.localRemove = function(key){
	var result = localStorage.getItem(key);
	if(result == null || typeof result == "undefined"){
		return;
	}else{
		localStorage.removeItem(key);
	}
};

/**
 * LocalStorage 清除所有
 * @param null
 * @return null
 */
jQuery.fn.localClose = function() {
    localStorage.clear();
};

/**
 * 经度转换
 * @param 精度数值
 * @return 格式化值
 */
jQuery.fn.TransformLongitude = function (longitude) {
    var longitudeSuffix = longitude > 0 ? "E" : "W";
    longitude = Math.abs(longitude);
    //度
    var degreex = Math.floor(longitude);
    //分
    var pointsx = Math.floor((longitude - degreex) * 60);
    //秒
    var secondsx = Math.round(((longitude - degreex) * 60 - pointsx) * 60, 2);
    return degreex + '°' + pointsx + "'" + secondsx + '\"' + longitudeSuffix;
};

/**
 * 纬度换算
 * @param 精度数值
 * @return 格式化值
 */
jQuery.fn.TransformLatitude = function (latitude) {
    var latitudeSuffix = latitude > 0 ? "N" : "S";
    latitude = Math.abs(latitude);
    //度
    var degreey = Math.floor(latitude);
    //分
    var pointsy = Math.floor((latitude - degreey) * 60);
    //秒
    var secondsy = Math.round(((latitude - degreey) * 60 - pointsy) * 60, 2);
    return degreey + '°' + pointsy + "'" + pointsy + '\"' + latitudeSuffix;

};

/**
 * 去除换行
 * @param HTML
 * @return 去除换行后的HTML
 */
jQuery.fn.breakNtoBr = function (str) {
    if (!str) return str;
    str = str.replace(/\\\\n/g, "⊕₰▆₮～");
    str = str.replace(/\n/g, "<br/>");
    str = str.replace(/\⊕₰▆₮～/g, "\n");
    return str;
};

/**
 * 字符串中阿拉伯数字转中文
 * @param string
 * @return 转换后的string
 */
$.fn.ToChinese = function (str) {
    var cn = ["零", "一", "二", "三", "四", "五", "六", "七", "八", "九"];
    var result = "";
    for (var i = 0; i < str.length; i++) {
        var n = str.charCodeAt(i) - 48;
        result = result + cn[Number(n)];
    }
    return result;
};

/**
 * 去除集合中重复的项
 */
$.fn.ToUnique = function (data) {
    data = data || [];
    var a = {};
    for (var i = 0; i < data.length; i++) {
        var v = data[i];
        if (typeof (a[v]) == 'undefined') {
            a[v] = 1;
        }
    }
    data.length = 0;
    for (var i in a) {
        data[data.length] = i;
    }
    return data;
};


/**
 * 字符串格式化
 */
String.prototype.format = function () {
    var result = this;
    if (arguments.length > 0) {
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                if (args[key] != undefined) {
                    var reg = new RegExp("({" + key + "})", "g");
                    result = result.replace(reg, args[key]);
                }
            }
        }
        else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] != undefined) {
                    //var reg = new RegExp("({[" + i + "]})", "g");
                    var reg = new RegExp("({)" + i + "(})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
    }
    return result;
}