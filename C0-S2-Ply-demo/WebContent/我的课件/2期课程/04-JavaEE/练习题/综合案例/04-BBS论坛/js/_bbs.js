function test(value, msg){
	if(value){
		alert(msg);
	}
	return value;
}

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

function setCookie(cname, cvalue, time) {
    var d = new Date();
    d.setTime(d.getTime() + time * 1000);
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
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

// axios.defaults.withCredentials = true;
axios.defaults.baseURL = "http://" + location.hostname + ":1113/bbs/"
var sid = getCookie("sid");

axios.interceptors.request.use(
	config=>{
		var i = config.url.indexOf("?");
		if(i==-1){
			config.url += ";jsessionid=" + sid;
		} else {
			config.url = config.url.substring(0,i) 
				+ ";jsessionid=" + sid 
				+ config.url.substring(0,i+1);
		}
		return config;
	},
	err => {
		return Promise.reject(err);
	}
);

/**
 * 页头公共模板
 */ 
Vue.component("bbshead",{
	data(){
		return {loginedUser : null}
	},
	template : `
	<div>
		<DIV>
			<IMG src="image/logo.gif">
		</DIV>
		<!--      用户信息、登录、注册        -->
		<DIV class="h">
			<span v-if="loginedUser">欢迎 {{loginedUser.uname}}</span>
			<span v-else>您尚未　<a href="_login.html">登录</a></span>
			&nbsp;| &nbsp; <A href="_reg.html">注册</A> |
		</DIV>
	</div>
	`,
	created(){
		sid = getCookie("sid");
		axios.get("getLoginedUser").then( res => {
			// 获取登录的用户名, 服务器会返回 null 字符串值
			this.loginedUser = res.data;
		});
	}
});

/**
 * 页头公共模板
 */ 
Vue.component("bbsfoot",{
	template : `
	<div class="gray" style="text-align: center;">
		<a href="http://www.hyycinfo.com" target="_blank">源辰信息</a>
	</div>
	`
});

Vue.component("page",{
	data() {
		return { data : {}};
	},
	props : ["data"],
	template : `
	<!--            翻 页          -->
	<DIV>
		<a v-if="data.pageNum>1" @click="$parent.load(data.pageNum-1)">上一页</a>
		<a v-else >已是首页</a>
		|
		<a v-if="data.pageNum<data.pages" @click="$parent.load(data.pageNum+1)">下一页</a>
		<a v-else >已是尾页</a>
	</DIV>
	`
});

function params(obj){
	var ret = new URLSearchParams();
	for(var n in obj){
		ret.append(n, obj[n]);
	}
	return ret;
}

