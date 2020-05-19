function buildParams(obj){
	var params = new URLSearchParams();
	for(var name in obj){
		if(obj[name]){
			params.append(name, obj[name]);
		}
	}
	return params;
}

Vue.component('ipt',{
	props : ["a","r"],
	template : "<input :answer='a' :regex='r'>"
});


Vue.component('cbx',{
	props : ["v","a","s"],
	template : "<span class='releaseInner'><span class='releaseInner' v-for='(r,i) in v'>" +
			"<input type='checkbox' :value='r' :answer='a.includes(i)?r:false'><br v-if='s!=undefined && i<v.length-1'>{{s}}" +
			"</span></span>"
});

var rdoNameIndex = 0;
Vue.component('rdo',{
	data : function(){
		return {
			n : "rdo-" + ++rdoNameIndex
		};
	},
	props : ["v","a","s"],
	template : "<span class='releaseInner'><span class='releaseInner' v-for='(r,i) in v'>" +
			"<input type='radio' :name='n' :value='r' :answer='a.includes(i)?r:false'><br v-if='s!=undefined && i<v.length-1'>{{s}}" +
			"</span></span>"
});

Vue.component('true',{
	data : function(){
		return {
			n : "rdo-" + ++rdoNameIndex
		};
	},
	props : ["v","w"],
	template : "<span class='releaseInner'>" +
			"<span class='releaseInner' style='display:inline-block' :style='{width:w,marginRight:w?\"\":\"30px\"}'>{{v}}</span>" +
			"<input type='radio' :name='n' value='对' answer='对'>" +
			"<input type='radio' :name='n' value='错'>" +
			"</span>"
});

Vue.component('false',{
	data : function(){
		return {
			n : "rdo-" + ++rdoNameIndex
		};
	},
	props : ["v","w"],
	template : "<span class='releaseInner'>" +
			"<span class='releaseInner' style='display:inline-block' :style='{width:w,marginRight:w?\"\":\"30px\"}'>{{v}}</span>" +
			"<input type='radio' :name='n' value='对' >" +
			"<input type='radio' :name='n' value='错' answer='错'>" +
			"</span>"
});
