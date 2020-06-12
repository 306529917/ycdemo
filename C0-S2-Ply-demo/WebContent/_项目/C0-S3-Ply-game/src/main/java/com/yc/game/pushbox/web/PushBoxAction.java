package com.yc.game.pushbox.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.game.pushbox.version3.core.Maps;

@RestController
public class PushBoxAction {
	
	@RequestMapping("pushbox/next")
	public int[][] next(int index){
		return  Maps.next(index+1);
	}

}
