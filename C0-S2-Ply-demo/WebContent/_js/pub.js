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
	template : `<span class='releaseMe qspan'><input :answer='a' :regex='r' :size='w&&w.indexOf("px")>-1?false:w' :style='{width:w&&w.indexOf("px")>-1?w:false}'><span>`
});

var rdoNameIndex = 0;
Vue.component('cbx',{
	data : function(){
		return {
			n : "cor-" + ++rdoNameIndex,
			newa : "",
		};
	},
	// v=>value, a=>answer, s=>新行前导, o=>不打乱顺序
	props : ["v","a","s","o"],
	methods : {
		rand(v,a,o){
			// o有值则不打乱
			if(o!=undefined) {
				this.newa = a;
				return v;
			}
			/** 打乱顺序 */
			let answers = [];
			let astring = Array.isArray(a) ? a.join(",") : a;
			// 保存正确答案
			v.forEach((o,i)=>{
				if(astring.indexOf(i)>-1){
					answers.push(o);
				}
			});
			// 打乱数组
			v.sort(function(){
				let n = Math.random();
				return  n > 0.5 ? 1 : -1; 
			});
			astring = "";
			// 重新构建答案字符串
			v.forEach((o,i)=>{
				let pos = answers.indexOf(o);
				if(pos > -1){
					astring += i;
				}
			});
			this.newa = astring;
			return v;
		}
	},
	template : `<span class='releaseMe qspan' v-if="rand(v,a,o)"><slot></slot>`
		+`<span class='releaseMe' v-for='(r,i) in v'>`
		+`<input :type='a.length==1?"radio":"checkbox"' :id='n+"-"+i' :name='n' :value='r' :answer='newa.indexOf(i)>-1 ? r : false'>`
		+`<label :for='n+"-"+i' style='padding-right:22px' class="removeMe">{{r}}</label>`
		+`<br v-if='s!=undefined && i<v.length-1'>{{s}}`
		+`</span></span>`
});

Vue.component('judge',{
	data : function(){
		return {
			n : "jdg-" + ++rdoNameIndex
		};
	},
	props : ["t","f","w"], // w 不写=>无, 写无值=>400
	template : `<span class='releaseMe qspan'>`
			+`<span class='releaseMe' :style='{display:w==undefined?false:"inline-block",width:w==undefined?false:w?(w+(/^\d+$/.test(w)?"":"px")):"400px"}'>`
			+`<slot>{{t||f}}</slot></span>`
			+`<input type='radio' :id='n+"-0"' :name='n' value='对' :answer='t!=undefined || t==undefined && f==undefined ?"对":false'>`
			+`<label :for='n+"-0"' style='padding-right:22px' class="removeMe">对</label>`
			+`<input type='radio' :id='n+"-1"' :name='n' value='错' :answer='f!=undefined?"错":false'>`
			+`<label :for='n+"-1"' style='padding-right:22px' class="removeMe">错</label>`
			+`</span>`
});

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
	props : [ "s", "w"],
	template : `<div style="
				clear:both;
				display:inline-block;
				text-align:center;
				margin:10px;
				border-radius: 5px;
				border:1px solid #888"
				:style="{width:w?w.indexOf('px')>0?w:(w+'px'):'150px'}">`
		+`<a :href="s" class='MagicZoom'>`
		+`<img :src="s" style="background-color:#fff">`
		+`</a>`
		+`<br><slot></slot></div>`
});