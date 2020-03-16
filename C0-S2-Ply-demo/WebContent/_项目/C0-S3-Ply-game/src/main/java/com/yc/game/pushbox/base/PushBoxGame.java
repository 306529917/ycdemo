package com.yc.game.pushbox.base;

/**
 * 	地图规则<br>
 * 	1 - 使用 int 型二维数组表示地图<br>
 * 	2 - 地图中元素对应值<br>
 * 		1	地图边界( 房子 )<br>
 * 		2	空地<br>
 * 		3	箱子<br>
 * 		4	目的地, 也就是箱子要覆盖的格子 ( 小箭头 )<br>
 * 		5	小人朝下, 初级版本中四个方法的小人统一用朝下表示<br>
 * 		6	小人朝左, 初级版本中没用<br>
 * 		7	小人朝右, 初级版本中没用<br>
 * 		8	小人朝上, 初级版本中没用<br>
 * 		9	箱子压在目的地格子上之后, 箱子显示的新的状态值, 初级版本中没用<br>
 */
public interface PushBoxGame {

	/**
	 * 进入下一关, 返回下一关游戏地图
	 * @return
	 */
	public int[][] next();

	/**
	 * 重来一次
	 * @return
	 */
	public int[][] reset();

	/**
	 * 返回当前地图
	 * @return
	 */
	public int[][] getMap();

	/**
	 * 小人上移
	 */
	public void up();
	
	/**
	 * 小人下移
	 */
	public void down();
	
	/**
	 * 小人左移
	 */
	public void left();
	
	/**
	 * 小人右移
	 */
	public void right();

	/**
	 * 	判断游戏是否结束, 就是地图上所得目的的格子( 值为4) <br>
	 *  部被箱子压住了, 就是游戏结束
	 * @return
	 */
	public boolean isOver();

}
