Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds() // 毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function copyArray(src,desc,isAppend){
	if( ! isAppend ){
		desc.splice(0,desc.length); 
	}
	src.forEach(e=>{
		desc.push(e);
	});
	return desc;
}

function copy(src,desc){
	for(var n in src){
		desc[n] = src[n];
	}
	return desc;
}

/**
 * 使用easyui控件构建对象 使用方式: 1. paramByEsayUI({id:null,name:null, ...}) 2.
 * paramByEsayUI("id","name", ...);
 * 
 * @param obj
 * @returns
 */
function paramsByEasyUI(obj){
	if(obj instanceof Object){
		for(var n in obj){
			obj[n] = $("#"+n).textbox("getValue");
		}
		return obj;
	} else {
		var ret = {}
		for(var i=0; i<arguments.length; i++){
			ret[arguments[i]] = $("#"+arguments[i]).textbox("getValue");
		}
		return ret;
	}
}

/**
 * 构建 URLSearchParams 参数, axios使用
 * 
 * @param obj
 * @returns
 */
function params(obj){
	var ret = new URLSearchParams();
	for(var n in obj){
		ret.append(n, obj[n]);
	}
	return ret;
}

/**
 * 测试输入的参数是否正确, 如果不正确这alert错误信息
 * 
 * @param value
 * @param msg
 * @returns
 */
function test(value, msg){
	if(value){
		alert(msg);
	}
	return value;
}

/**
 * 测试输出参数是否都为true
 * 
 * @returns
 */
function check(){
	for(var i=0; i<arguments.length; i++){
		if( ! arguments ){
			return false;
		}
	}
	return true;
}

function trim(str){
	return str.replace(/(^\s+|\s+$)/g,"")
}

function setCookie(cname, cvalue, maxAge, path) {
    var cookie = cname + "=" + cvalue;
    if(maxAge){
    	cookie += ";max-age=" + maxAge;
    }
    if(path){
    	cookie += ";path="+path;
    }
    document.cookie = cookie;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
         }
        if (c.indexOf(name)  == 0) {
            return c.substring(name.length, c.length);
         }
    }
    return "";
}

if($ && $.messager){
	window.alert = function(msg,icon,fn){
		msg = msg.replace(/\n/g,"<br>");
		$.messager.alert('系统提示',msg,icon?icon:"info",fn);
	};
	window.show = function(msg,config){
		msg = msg.replace(/\n/g,"<br>");
		if(! config){
			config = {};
		}
		config.title = "系统提示";
		config.msg = msg;
		$.messager.show(config);
	};
	window.confirm = function(msg,fn){
		msg = msg.replace(/\n/g,"<br>");
		$.messager.confirm("系统提示", msg, fn);
	};
	window.prompt = function(msg,fn){
		msg = msg.replace(/\n/g,"<br>");
		$.messager.prompt("系统提示", msg, fn);
	};
}