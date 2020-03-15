package com.yc.game.wuzi.core;

import java.util.ArrayList;

/**
 * 五子连珠游戏
 * @author 廖彦
 *
 */
public class WuziGame {

	public static final String POINT_UP_LEFT = "左上";
	public static final String POINT_UP_RIGHT = "右上";
	public static final String POINT_UP = "上边";
	public static final String POINT_DOWN_LEFT = "左下";
	public static final String POINT_DOWN_RIGHT = "右下";
	public static final String POINT_DOWN = "下边";
	public static final String POINT_LEFT = "左边";
	public static final String POINT_RIGHT = "右边";
	public static final String POINT_CENTER = "中间";
	public static final String POINT_BLACK = "黑子上";
	public static final String POINT_WHITE = "白子上";

	// 无子
	public static final int SPACE = 0;
	// 黑子
	public static final int BLACK = 1;
	// 白子
	public static final int WHITE = 2;
	// 棋盘大小
	public static final int SIZE = 15;
	// 定义四个方向的 x , y 的变化趋势
	public static final int[][] DIRECTION = { { 1, 0 }, { 0, 1 }, { -1, -1 }, { 1, -1 } };

	// 棋盘
	private int[][] board;
	// 五子连珠的棋子坐标数组
	private int[][] wuzi;
	// 当前下子的颜色
	private int color = BLACK;

	/**
	 * 初始化游戏
	 */
	public WuziGame() {
		restart();
	}

	/**
	 * 重新开始
	 */
	public void restart() {
		board = new int[SIZE][SIZE];
		color = BLACK;
		wuzi = null;
	}

	/**
	 * 下子
	 * @param x
	 * @param y
	 */
	public void down(int x, int y) {
		if (wuzi != null) {
			return;
		}
		down(x, y, color);
		// 交换颜色
		color = color == BLACK ? WHITE : BLACK;
	}

	/**
	 * 下子
	 * @param x
	 * @param y
	 * @param color
	 */
	private void down(int x, int y, int color) {
		if (wuzi != null || color > WHITE || color < SPACE || board[y][x] != SPACE) {
			return;
		}
		board[y][x] = color;
		// 判断胜负( 四个方向 )
		for (int i = 0; i < DIRECTION.length; i++) {
			int[][] ret = count(x, y, color, DIRECTION[i][0], DIRECTION[i][1]);
			if (ret.length >= 5) {
				wuzi = ret;
			}
		}
	}

	/**
	 * 返回五子连珠的棋子坐标数组,例如: 
	 * 	{{4,4},{5,5},{6,6},{6,6},{7,7}} 
	 * 如果棋局未结束则返回 null
	 * @return
	 */
	public int[][] getWuzi() {
		return wuzi;
	}

	/**
	 * 返回赢家的颜色
	 * @return
	 */
	public int getWinner() {
		return wuzi == null ? SPACE : board[wuzi[0][1]][wuzi[0][0]];
	}

	/**
	 * 统计棋子的一个方法上的同色不间断的棋子数, 例如: 
	 * 	- 向是 	ox=1,	y=0, 
	 * 	\ 向是  	ox=-1,	y=-1
	 * 	| 向是 	ox=0,	y=1, 
	 * 	/ 向是  	ox=1,	y=-1
	 * @param x
	 * @param y
	 * @param color
	 * @param ox	x的变化值
	 * @param oy	y的变化值
	 * @return
	 */
	private int[][] count(int x, int y, int color, int ox, int oy) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(new int[] { x, y });
		// 统计正方向的棋子数
		for (int nx = x + ox, ny = y + oy; equals(nx, ny, color); nx += ox, ny += oy) {
			list.add(new int[] { nx, ny });
		}
		ox *= -1;
		oy *= -1;
		// 统计反方向的棋子数
		for (int nx = x + ox, ny = y + oy; equals(nx, ny, color); nx += ox, ny += oy) {
			list.add(new int[] { nx, ny });
		}
		return list.toArray(new int[list.size()][]);
	}

	/**
	 * 返回棋盘二维数组
	 * @return
	 */
	public int[][] getBoard() {
		return board;
	}

	/**
	 * 判断坐标值( x , y ) 的坐标值 ( 颜色 ):
	 * 	1.是否在棋盘的范围内
	 * 	2.是否与传入的棋子颜色相同
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	private boolean equals(int x, int y, int color) {
		return y < board.length && y > 0 && x < board[0].length && x > 0 && board[y][x] == color;
	}

	/**
	 * 打印棋盘, 用于调试
	 */
	public void print() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 获取当前棋子颜色( 轮谁下 )
	 * @return
	 */
	public int getColor() {
		return color;
	}

	/**
	 * 获取当前的坐标的位置名, 例如:左上角, 中间, 白子上, 黑子上
	 * @param x
	 * @param y
	 */
	public String getPointerName(int x, int y) {
		if (board[y][x] == BLACK) {
			return POINT_BLACK;
		} else if (board[y][x] == WHITE) {
			return POINT_WHITE;
		} else if (x == 0 && y == 0) {
			return POINT_UP_LEFT;
		} else if (x == SIZE - 1 && y == 0) {
			return POINT_UP_RIGHT;
		} else if (x == 0 && y == SIZE - 1) {
			return POINT_DOWN_LEFT;
		} else if (x == SIZE - 1 && y == SIZE - 1) {
			return POINT_DOWN_RIGHT;
		} else if (x == 0 && y > 0) {
			return POINT_LEFT;
		} else if (x > 0 && y == 0) {
			return POINT_UP;
		} else if (x == SIZE - 1 && y > 0) {
			return POINT_RIGHT;
		} else if (x > 0 && y == SIZE - 1) {
			return POINT_DOWN;
		} else {
			return POINT_CENTER;
		}
	}

}
