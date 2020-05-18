function a(){
	if(event.altKey  && event.ctrlKey/* && event.shiftKey */){
		var e = event.srcElement;
		var answer = e.getAttribute("answer");
		if(answer){
			e.value = answer;
		}
		event.stopPropagation();
		return;
	}
}
function Q(content, expect){
	this.content = content;
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
			
			if( ! this.expect){
				let answer = input.getAttribute('answer');
				let regex = input.getAttribute("regex");
				// 内容判断 + 正则判断
				let ok = answer && val.replace(/\s/g,'') == answer.replace(/\s/g,'')
						|| regex && eval(regex).test(val);
				if(isCR){
					if(val){
						input.nextSibling.classList.remove(ok ? "cuo" : "dui");
						input.nextSibling.classList.add(ok ? "dui" : "cuo");
					} else {
						input.nextSibling.classList.remove("cuo","dui");
					}
				} else {
					if(val){
						input.classList.remove(ok ? "cuo" : "dui");
						input.classList.add(ok ? "dui" : "cuo");
					} else {
						input.classList.remove("cuo","dui");
					}
				}
				if((answer || regex ) && ! ok){
					allright = false;
				}
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
				console.error(e);
				this.result = false;
			}
		}
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

var pres = document.querySelectorAll("div>pre");
var qs = [];
for(var pre of pres){
	qs.push(new Q(pre.innerHTML,pre.getAttribute("expect")));
}
function findDD(node){
	if(node && node.nodeName.toLowerCase() == 'dl'){
		return node;
	} else {
		return findDD(node.parentNode);
	}
}
new Vue({
	el : "#main",
	data : {
		questions : qs
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
			var index = location.href.lastIndexOf("/");
			var hwName = location.href.substring(index+1);
			hwName = decodeURIComponent(hwName);
			if(hwName){
				axios.post("/hw/commit",buildParams({
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
		document.querySelectorAll("dd pre input").forEach((o,index)=>{
			o.onclick = a;
			var answer = o.getAttribute("answer");
			// 20 是默认值
			if(o.size == undefined || o.size == 20 && answer){
				o.size = answer.length * 1.7;
			}
			if(o.type=="checkbox" || o.type=="radio"){
				let label = o.getAttribute("label");
				let id = o.id;
				// 有提供 answer 但是没有值, 则默认赋值 value
				if(answer=='' && o.value){
					o.setAttribute("answer", o.value);
				}
				// 自动添加 label
				label = label || o.value;
				if(! id){
					id = "l" + index;
					o.id = id;
				}
				let lab = document.createElement("label");
				lab.setAttribute("for",id);
				lab.innerText = label;
				insertAfter(o, lab);
				lab.style.width = lab.offsetWidth + 22 + "px";
			}
		});
	},
	computed : {
		finish(){
			return this.questions.every(q=>{
				return q.result;
			});
		}
	}
});