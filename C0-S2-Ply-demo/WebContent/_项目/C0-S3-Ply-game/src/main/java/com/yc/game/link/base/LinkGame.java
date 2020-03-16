package com.yc.game.link.base;

import com.yc.game.common.base.TwoArrayGame;

public interface LinkGame extends TwoArrayGame{
	
	/**
	 * 返回棋盘二维数组
	 * @return
	 */
	Integer[][] getBoard();
	
	/**
	 * 检查2个坐标点是否可以连接<br>
	 * 	x1,y1 表示第1个点<br>
	 * 	x2,y2 表示第2个点<br>
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	boolean link(int x1, int y1, int x2, int y2);

}
