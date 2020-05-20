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
	template : `<span class='releaseInner qspan' ><input :answer='a' :regex='r' :size='w.indexOf("px")>-1?"":w' :style='{width:w.indexOf("px")>-1?w:false}'><span>`
});

var rdoNameIndex = 0;
Vue.component('cbx',{
	data : function(){
		return {
			n : "cor-" + ++rdoNameIndex
		};
	},
	props : ["v","a","s"],
	template : `<span class='releaseInner qspan'><slot></slot>`
		+`<span class='releaseInner' v-for='(r,i) in v'>`
		+`<input :type='a.length==1?"radio":"checkbox"' :name='n' :value='r' :answer='a.includes(i)?r:false'>`
		+`<br v-if='s!=undefined && i<v.length-1'>{{s}}`
		+`</span></span>`
});

Vue.component('judge',{
	data : function(){
		return {
			n : "jdg-" + ++rdoNameIndex
		};
	},
	props : ["t","f","w"],
	template : `<span class='releaseInner qspan'>
			<span class='releaseInner' style='display:inline-block' :style='{width:w,marginRight:w?\"\":\"30px\"}'>
			<slot>{{t||f}}</slot></span>
			<input type='radio' :name='n' value='对' :answer='t!=undefined?"对":false'>
			<input type='radio' :name='n' value='错' :answer='f!=undefined?"错":false'>
			</span>`
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
					 <li>答题完成后, 请截图保存结果</li>
				 </ol>
			 </div>
			<div>
				<h4>参考资料</h4>
				<ol><slot></slot></ol>
			 </div>
		 </div>
	`
});