function a(){
	if(event.altKey  && event.ctrlKey/* && event.shiftKey */){
		var e = event.srcElement;
		if(e.nodeName!='CHECKBOX' && e.nodeName!='RADIO'){
			var answer = e.getAttribute("answer");
			if(answer){
				e.value = answer;
			}
		}
		qs[e.getAttribute("preIndex")].test();
		event.stopPropagation();
		return;
	}
}
function Q(content, expect){
	this.content = content;
	/**
	 * 期望结果, 
	 * 未定义: 不运行, 仅验证输入,  
	 * 定义为"": 运行, 仅验证输入
	 * 定义为非"": 运行, 验证输入 + 验证结果
	 */ 
	this.expect = expect;
	this.result = false;
	this.resultText = null;
	this.test = function(){
		var script = this.content;
		var inputs = findDD(event.srcElement).querySelectorAll("input");
		var allright = true
		for( var input of inputs){
			let val;
			let isCR;
			if(input.type == 'checkbox' || input.type == 'radio'){
				val = input.checked ? input.value : "";
				isCR = true;
			} else {
				val = input.value;
			}
			script = script.replace(/<input.+?>/, val);
			
			let answer = input.getAttribute('answer');
			let regex = input.getAttribute("regex");
			// 内容判断 + 正则判断
			let ok;
			if(answer){
				answer = answer.replace(/\s/g,'');
				let v = val.replace(/\s/g,'');
				// 为定义期望值, 说明不是 js 代码,  忽略大小写
				if(this.expect == undefined ){
					answer = answer.toLowerCase();
					v = v.toLowerCase();
				}
				ok = v== answer || regex && eval(regex).test(val);
			} else {
				ok = val == "";
			}
			let changeElement = isCR ? input.nextSibling : input;
			if(val){
				changeElement.classList.remove( ok ? "cuo" : "dui" );
				changeElement.classList.add( ok ? "dui" : "cuo" );
			} else {
				changeElement.classList.remove( "cuo","dui" );
			}
			if( !ok ){
				allright = false;
			}
		}
		
		this.result = allright;
		if(this.expect != undefined){
			try{
				script = script.replace(/<.+?>[^<]+?<\/.+?>/g, "");
				script = script.replace(/<.+?>/g, "");
				script = script.replace(/&amp;/g, "&");
				console.info("========开始测试========");
				console.log(script);
				var ret = eval(script);
				this.resultText = ret ? ret.toString() : "";
				if(new RegExp("^\/.+\/$").test(this.expect)){
					var reg = eval(this.expect);
					this.result = reg.test(this.resultText);
				} else {
					this.result = this.expect == this.resultText;
				}
			} catch (e) {
				if(this.expect){
					console.error(e);
					this.result = false;
				}
			}
		}
	}
}

var pres = document.querySelectorAll("#pres>pre");
var qs = [];
for(var pre of pres){
	qs.push(new Q(pre.innerHTML,pre.getAttribute("expect")));
}
// 移除div, 避免id冲突
var pres = document.getElementById("pres");
if(pres){
	pres.parentNode.removeChild(pres);
}

function findDD(node){
	if(node && node.nodeName.toLowerCase() == 'dl'){
		return node;
	} else {
		return findDD(node.parentNode);
	}
}

function insertAfter(targetEl, newEl){
	var parentEl = targetEl.parentNode;
	if(parentEl.lastChild == targetEl){
		parentEl.appendChild(newEl);
	}else{
		parentEl.insertBefore(newEl,targetEl.nextSibling);
	}            
}

/**
 * 添加时钟
 */
var btnSmt = document.querySelector(".alist>div>div:nth-child(2)>button");
if(btnSmt){
	let span = document.createElement("div");
	span.innerText = "{{showTime}}";
	span.style.position = "fixed"; 
	span.style.top="0px";
	span.style.right="57px";
	span.style.fontWeight="bold";
	span.style.zIndex="1000";
	span.setAttribute(":style","{color:colors[time%2],fontSize:sizes[time%2]}");
	
	btnSmt.parentNode.insertBefore(span,btnSmt);
}
function fmtTime(time, mask){
	let ret = mask + time;
	return ret.substring(ret.length - mask.length);
}

/******************************** VUE ***********************************/

var vue = new Vue({
	el : "#main",
	data : {
		colors : ["#A5A552","#FF8000"],
		sizes : ["1.2em","1.5em"],
		questions : qs,
		time: 10800,
		showTime : "03:00:00"
	},
	created : function(){
		let i = setInterval(function(){
			if(vue.$data.time > 0){
				vue.$data.time -= 1;
			} else {
				clearInterval(i);
			}
		},1000);
	},
	methods : {
		a(q){
			if(event.altKey  && event.ctrlKey/* && event.shiftKey */){
				var dd = findDD(event.srcElement);
				var inputs = dd.querySelectorAll("input");
				for( var input of inputs){
					var answer = input.getAttribute("answer");
					if(input.type=='checkbox' || input.type=='radio'){
						input.checked = answer == input.value;
					} else {
						input.value = answer;
					}
				}
				q.test();
			}
		},
		commit(){
			if(hwName){
				axios.post("/user/commit",buildParams({
					name : hwName
				})).then(res=>{
					if( res.data.code == 1){
						alert("答案提交成功");
					} else {
						alert(res.data.msg || "答案提交失败");
						if( res.data.code == -1){
							location.href = "/user/myinfo.html";
						}
					}
				});
			}
		}
	},
	mounted : function(){
		document.querySelectorAll("dd pre").forEach((pre,pindex)=>{
			let index = 0;
			pre.querySelectorAll("input").forEach((ipt,iindex)=>{
				// 设置后门方法
				ipt.onclick = a;
				// 设置题目编号
				ipt.setAttribute("preIndex",pindex);
				var answer = ipt.getAttribute("answer");
				// 20 是默认值
				if(ipt.size == undefined || ipt.size == 20 && answer){
					ipt.size = answer.length * 1.7;
				}
				if(ipt.type=="checkbox" || ipt.type=="radio"){
					// 有提供 answer 但是没有值, 则默认赋值 value
					if(answer=='' && ipt.value){
						ipt.setAttribute("answer", ipt.value);
					}
					// 自动添加 label
					let ns = ipt.nextSibling;
					if(! ns || ns.nodeName != "LABEL" || ! ns.classList.contains("removeMe")){
						let id = ipt.id;
						if(! id){
							id = "l" + index++;
							ipt.id = id;
						}
						let lab = document.createElement("label");
						lab.classList.add("removeMe");
						lab.setAttribute("for",id);
						lab.innerText = ipt.value;
						lab.style.paddingRight = "22px";
						insertAfter(ipt, lab);
					}
				}
			});
		});
	},
	computed : {
		finish(){
			return this.time > 0 && this.questions.every(q=>{
				return q.result;
			});
		}
	},
	watch : {
		time(val){
			let second = val % 60;
			let minute = parseInt( val / 60 );
			let hours = parseInt( minute / 60 );
			minute = minute % 60;
			this.showTime = fmtTime(hours,"00") + ":" + fmtTime(minute,"00") + ":" + fmtTime(second,"00");
		}
	}
});

var index = location.href.lastIndexOf("/");
var hwName = location.href.substring(index+1);
hwName = decodeURIComponent(hwName);
axios.post("/user/isFinished",buildParams({
	name : hwName
})).then(res=>{
	if( res.data.code == 1){
		let span = document.createElement("span");
		span.innerText="已 完 成 !";
		span.style.position = "fixed";
		span.style.opacity = 0.7;
		span.style.top="100px";
		span.style.color="red";
		span.style.fontWeight="bold";
		span.style.fontSize="2em";
		span.style.right="100px";
		span.style.zIndex="1000";
		span.style["-webkit-transform"] = 'rotate(30deg)';
		span.style["-moz-transform"] = 'rotate(30deg)';
		span.style["-o-transform"] = 'rotate(30deg)';
		document.body.appendChild(span);
	}
});
