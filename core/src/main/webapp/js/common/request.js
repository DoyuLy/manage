/**
 * jquery ajax request helper
 * 2015-10-28 14:45:23
 * author du
 */

; (function (factory){
    // CommonJS
    if (typeof exports === 'object')
    	module.exports = factory();
    // AMD
    else if (typeof define === 'function' && define.amd)
    	define([], factory);
    // Browser global
    else
    	factory();
    
}(function (){
    'use strict';

    
  //ToDo ...
    function http(base, opts){
    	// ToDo show loading view
    	
    	var deferred = $.Deferred();
    	
    	var def = {cache: false, contentType: "application/json; charset=utf-8"};
    	
    	var settings = $.extend({}, def, base, opts);
    	if(settings.data != null && typeof(settings.contentType === "string" && settings.contentType.indexOf("json") !== -1)){
    		settings.data = JSON.stringify(setting.data)
    	}
    	
    	$.ajax(settings).done(function(data){
    		console.info(data);
    		if(data.status == -1 || data){
    			deferred.resolve(data);
    		}else{
    			deferred.rejectWith(deferred, [200, data]);
    			if(!deferred.handled)
    				$.prompt(data);
    		}
    		
    		//ToDo hidden loading view
    	}).fail(function(data){
    		deferred.rejectWith(deferred, [data.status, data.statusText]);
    		if(!deferred.handled){
    			if(data.status === 401){
    				location.href = 'xxx';// maybe create a file -> 'config'
    			}else if(data.status === 500){
    				console.info(data);
    				$.prompt("server error, pls retry a moment later.");
    			}
    		}
    		
    		// ToDo hidden loading view  
    	});
    	
    	return deferred.promise();
    };
    
    //
    // Fills in default values.
    //
    function merge(obj){
        for (var i = 1; i < arguments.length; i++){
            var def = arguments[i]

            for (var n in def)
                if (obj[n] === undefined) obj[n] = def[n]
        }
        return obj
    }

    
    return {
    	get: function(url, opts){
    		return http({method: "GET", url: url}, opts);
    	},
    	post: function(url, data, opts){
    		return http({method: "POST", url: url, data: data}, opts);
    	},
    	_delete: function(url, opts){
    		return http({method: "DELETE", url: url}, opts);
    	},
    	put: function(url, data, opts){
    		return http({method: "POST", url: url, data: data}, opts);
    	}
    }
    
    //for use eg
    
//    http.get(url).then(function(res){
//    	
//    })

}));
