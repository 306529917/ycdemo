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
	template : `<span class='releaseMe qspan' style="float:none">`
		+`<input v-if="!isTeach" :answer='a' :regex='r' style="text-align:center" :size='w&&w.indexOf("px")>-1?false:w' :style='{width:w&&w.indexOf("px")>-1?w:false}'>`
		+`<span v-else>{{a}}</span>`
		+`<span>`
});

// 拆解数组 + 去首尾空格
function toArray(obj,spacer){
	if(obj){
		if(Array.isArray(obj)){
			return obj;
		} else {
			obj += "";
			spacer = spacer ? spacer : "[\\|\\n]+";
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

//拆解正确和错误的题目
function getTF(text){
	var reg = /^(.*?)\s*\{\[\s*(.*?)\s*\]\[\s*(.*?)\s*\]\}\s*(.*)$/;
	if(reg.test(text)){
		let arr = reg.exec(text);
		return [ arr[1] + arr[2] + arr[4] , arr[1] + arr[3] + arr[4]];
	} else {
		return [text];
	}
}

var isTeach = location.hash == "#teach";
var	sn = "ABCDEFGHIJK";
var cNameIndex=0;
var falseAnswerReg = /^\s*[！!]\s*(.+)$/; 

chtml = `<span class='releaseMe' v-for='(r,i) in values'>`
	+`<input v-if="type" :type='type' :id='name+"-"+i' :name='name' :value='r.value' :answer='r.isTrue?r.value:false'>`
	+`<label :for='name+"-"+i' :style='{paddingRight:"22px"}' class="removeMe">{{values.length>2?sn[i]+". ":""}}{{r.value}}</label>`
	+`<br v-if='(inline === false || inline === undefined ) && i<values.length-1'>`
	+`</span></td></tr>`;
Vue.component('c',{
	data : function(){
		return {
			name : "c-" + ++cNameIndex,
			type : null,
			values : [],
			isJudge : false,
			slotText : null,
		};
	},
	// spacer:答案分隔符  noteach:非教学  inline:答案在一行中  isteach:教学案例, 错误答案不隐藏, 与noteach互斥
	props : ["w","spacer","noteach","inline","isteach"],
	methods : {
		init(){
			// 非教学题   isTeach 全局变量
			if(isTeach && this.noteach != undefined){
				return false;
			}

			// 获取slot的值, 去掉首位空格
			let v = this.$slots.default[0].text;
			v = v.replace(/(^\s+|\s+$)/g,"");
			v = toArray(v,this.spacer);
			// 内容的第一行就是题目
			let title = v.shift();

			let values = null;
			if(v.length==0){
				this.isJudge = true;
				this.inline = true;
				values = [{value:"是",isTrue:true},{value:"否",isTrue:false}];
			} else {
				values = [];
				v.forEach((val,i)=>{
					if(val){
						let isTrue = true;
						//判断是否是错误答案 值前面有 ! 号
						if(falseAnswerReg.test(val)){
							val = falseAnswerReg.exec(val)[1];
							isTrue = false;
						}
						let vobj = {};
						vobj.value = val;
						vobj.isTrue = isTrue;
						// 教学模式不添加错误答案
						if(vobj.isTrue || this.isteach != undefined || ! isTeach){
							values.push(vobj);
						}
					}
				});
				// 教学模式不生成控件, 不排序
				if(!isTeach){
					values.sort((a,b)=>{
						return Math.random() > 0.5 ? 1 : -1; 
					});
				}
			}
			
			// 拆解正确和错误的题目
			let textTF = getTF(title);
			if(isTeach){
				// 教育模式, 一律使用真题
				this.slotText = textTF[0];
			} else {
				// 非教育模式, 随机选择真假题
				let isFalse = textTF.length == 1 ? false : (Math.random() > 0.5);
				this.slotText = isFalse ? textTF[1] : textTF[0];
				values.forEach(o=>{
					if(isFalse){
						o.isTrue = !o.isTrue;
					}
				});
			}
			
			let tCount = 0;
			values.forEach(o=>{
				tCount += o.isTrue ? 1 : 0;
			});
			// 没有正确答案, 这题取消, 例如:某多选题真题全对, 假题就没有正确答案
			if(tCount == 0){
				return false;
			}
			// 教学用题 和 非教育模式, 要正常显示 选择框
			if(this.isteach != undefined || ! isTeach) {
				this.type = tCount > 1 ? "checkbox" : "radio";
			}
			this.values = values;
			
			return true;
		}
	},
	template : `<table class='releaseMe qspan' v-if="init()" :style="{width:w?w:'100%'}">`
		+`<tr v-if="isJudge"><td>{{slotText}}</td>`
		+`<td v-if="!(isJudge && isTeach) || isteach != undefined" style="width:150px;text-align:center">`
		+ chtml
		+`<tr v-if="!isJudge"><td>{{slotText}}</td></tr>`
		+`<tr v-if="!isJudge"><td>`
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