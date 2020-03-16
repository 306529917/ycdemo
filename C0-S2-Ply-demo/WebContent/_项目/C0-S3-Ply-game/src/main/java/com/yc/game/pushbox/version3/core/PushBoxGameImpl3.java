package com.yc.game.pushbox.version3.core;

import com.yc.game.pushbox.version2.core.PushBoxGameImpl2;
import com.yc.game.pushbox.version3.core.Maps;

/**
 * 	使用了新的 Maps 类, 从文件中读取地图
 */
public class PushBoxGameImpl3 extends PushBoxGameImpl2 {
	
	public int[][] next() {
		stepNumber = 0;
		isOver = false;
		map = Maps.next();
		mapOld = Maps.clone(map);
		return map;
	}

	public int[][] reset() {
		stepNumber = 0;
		isOver = false;
		map = Maps.clone(mapOld);
		return map;
	}

}
