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
	props : ["a","r","w"],
	template : `<span class='releaseMe qspan'><input :answer='a' :regex='r' style="text-align:center" :size='w&&w.indexOf("px")>-1?false:w' :style='{width:w&&w.indexOf("px")>-1?w:false}'><span>`
});

function toArray(obj,spacer){
	if(obj){
		if(Array.isArray(obj)){
			return obj;
		} else {
			obj += "";
			spacer = spacer ? spacer : "[;,，；、]+";
			let ret = obj.split(new RegExp(spacer,"g"));
			ret.forEach((r,i)=>{
				ret[i] = r.replace(/(^\s+|\s+$)/g, "");
			});
			return ret;
		}
	} else {
		return [];
	}
}

var isTeach = location.hash == "#teach";
var	sn = "ABCDEFGHIJK";
var cNameIndex=0;
chtml = `<span class='releaseMe' v-for='(r,i) in values'>{{s}}`
	+`<input v-if="!isTeach" :type='type' :id='name+"-"+i' :name='name' :value='r.value' :answer='r.isTrue?r.value:false'>`
	+`<label :for='name+"-"+i' style='padding-right:22px' class="removeMe">{{values.length>2?sn[i]+". ":""}}{{r.value}}</label>`
	+`<br v-if='s!=undefined && i<v.length-1'>`
	+`</span></td></tr>`;
Vue.component('c',{
	data : function(){
		return {
			name : "c-" + ++cNameIndex,
			type : "radio",
			values : [],
			isJuage : false,
			slotText : null
		};
	},
	// v=>value, a=>answer 从1开始计数, s=>答案换行新行前导, spacer=>答案分隔符
	props : ["v","a","s","w","spacer","noteach"],
	methods : {
		init(v,a,s,w,spacer,noteach){
			if(noteach != undefined){
				return false;
			}
			// 获取slot的值, 去掉首位空格
			let st = this.$slots.default[0].text;
			st = st.replace(/(^\s+|\s+$)/g,"");
			this.slotText = st;
			// 默认正确答案是第一个选项
			a = a || "1";
			// v不提供, 则为判断题
			if( ! v){
				this.isJuage = true;
				let isError = a && a.indexOf("2")>-1;
				if(! isTeach){
					this.values[0] = {value:"是"};
					this.values[1] = {value:"否"};
					let tIndex = isError ? 1 : 0;
					this.values[tIndex].isTrue = true;
				} 
				if( isTeach && isError){
					// 教学模式不生错误的判断题
					return false;
				}
			} else {
				let tCount = 0;
				v = toArray(v,spacer);
				let values = [];
				v.forEach((val,i)=>{
					if(val){
						let vobj = {};
						vobj.value = val;
						vobj.isTrue = a.indexOf(i+1) > -1;
						tCount += vobj.isTrue ? 1 : 0;
						// 教学模式不添加错误答案
						if(vobj.isTrue || ! isTeach){
							values.push(vobj);
						}
					}
				});
				this.type = tCount == 1 ? "radio" : "checkbox";
				// 教学模式不生成控件, 不排序
				if(!isTeach){
					values.sort((a,b)=>{
						return Math.random() > 0.5 ? 1 : -1; 
					});
				}
				this.values = values;
			}
			return true;
		}
	},
	template : `<table class='releaseMe qspan' v-if="init(v,a,s,w,spacer,noteach)" :style="{width:w?w:'100%'}">`
		+`<tr v-if="isJuage"><td>{{slotText}}</td>`
		+`<td style="width:150px;text-align:center">`
		+ chtml
		+`<tr v-if="!isJuage"><td>{{slotText}}</td></tr>`
		+`<tr v-if="!isJuage"><td>`
		+ chtml
		+`</table>`
})

Vue.component('prompt',{
	template : `
		<div id="qlistpre">
		 	<div>
				 <h4>答题注意事项: </h4>
				 <ol>
					 <li>请删除代码中的非必要空格</li>
					 <li>定义JS的字符串请使用双引号</li>
					 <li>答题前请务必先认真阅读 "参考资料"</li>
					 <li>答题完成后, 请务必及时提交结果</li>
				 </ol>
			 </div>
			<div>
				<h4>参考资料</h4>
				<ol><slot></slot></ol>
			 </div>
		 </div>
	`
});

Vue.component('pic',{
	props : [ "s", "w", "prefix"],
	template : `<div><div v-for="p in toArray(s)" v-if="p" style="
				float:left;
				display:inline-block;
				text-align:center;
				margin:10px;
				border-radius: 5px;
				border:1px solid #888"
				:style="{width:w?w.indexOf('px')>0?w:(w+'px'):'150px'}">`
		+`<a :href="(prefix?prefix:'_images/') + p" class='MagicZoom'>`
		+`<img :src="(prefix?prefix:'_images/') + p" style="background-color:#fff">`
		+`</a>`
		+`<br>{{p.replace(/(\\d+-)*(.+)+?\\.\\w+/,"$2")}}</div></div>`
});