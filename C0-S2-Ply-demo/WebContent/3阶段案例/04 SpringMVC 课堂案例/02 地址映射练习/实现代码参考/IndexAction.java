package com.yc.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.springmvc.bean.Result;

@Controller
public class IndexAction {

	@RequestMapping({ "/", "index" })
	public String index(@RequestParam(defaultValue = "") String order) {
		return "index" + order;
	}

	@RequestMapping({ "toTaobao", "taobao/page", "taobao/page", "*Taobao", "page/**/taobao" })
	public String taobao() {
		return "taobao";
	}

	@RequestMapping(path = "toPage", params = "flag")
	public String taobao1() {
		return "taobao";
	}

	@RequestMapping(path = "toPage", params = "type=1")
	public String taobao2() {
		return "taobao";
	}

	@RequestMapping({ "toPage", "toBaidu", "baidu/page", "form.do" })
	public String baidu() {
		return "baidu";
	}

	@RequestMapping(path = "toPage", params = {"type!=1","!flag"})
	public String baidu1() {
		return "baidu";
	}

	@RequestMapping(path = "form.do", method = RequestMethod.POST)
	public String taobao3() {
		return "taobao";
	}

	@ResponseBody
	@RequestMapping("call.do")
	public String call(int type) {
		return type == 2 ? "taobao" : "baidu";
	}

	@ResponseBody
	@RequestMapping("call1.do")
	public Result call1(int type) {
		Result r = new Result();
		r.setUrl(type == 2 ? "toTaobao" : "toBaidu");
		r.setMsg(type == 2 ? "即将跳转淘宝" : "即将跳转百度");
		return r;
	}

	@ResponseBody
	@PostMapping(path="exec.do")
	public Result exec() {
		Result r = new Result();
		r.setUrl("toBaidu");
		r.setMsg("即将跳转百度");
		return r;
	}
	
	@ResponseBody
	@GetMapping(path="exec.do")
	public Result exec1() {
		Result r = new Result();
		r.setUrl("toTaobao");
		r.setMsg("即将跳转淘宝");
		return r;
	}

}
