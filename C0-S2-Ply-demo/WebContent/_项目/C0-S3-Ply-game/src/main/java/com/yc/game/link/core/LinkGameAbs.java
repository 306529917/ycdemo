package com.yc.game.link.core;

import com.yc.game.link.base.LinkGame;

/**
 * 连连看抽象类
 * @author 廖彦
 *
 */
public abstract class LinkGameAbs implements LinkGame {

	/**
	 * 棋盘二维数组
	 */
	protected int[][] board;

	/**
	 * 定义棋盘大小: width 宽度, height 高度
	 */
	protected int width, height;

	/**
	 * 图片的数量, 用 1 ~ imgCount, 表示图片值, 0 表示无图
	 */
	protected int imgCount;

	/**
	 * 初始化游戏
	 * @param width		棋盘宽度
	 * @param height	棋盘高度
	 * @param imgCount	图片的张数
	 */
	public LinkGameAbs(int width, int height, int imgCount) {
		if (width % 2 != 0 && height % 2 != 0) {
			throw new RuntimeException("高宽值必须至少有一个偶数");
		}
		this.width = width;
		this.height = height;
		this.imgCount = imgCount;
		board = new int[height][width];

		begin();
	}

	@Override
	public int[][] getBoard() {
		int[][] displayBoard = new int[height - 2][width - 2];
		for (int y = 1; y < height - 1; y++) {
			System.arraycopy(board[y], 1, displayBoard[y - 1], 0, width - 2);
		}
		return displayBoard;
	}

	@Override
	public boolean isOver() {
		// 判断棋盘中是否都是 0 了
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if (board[y][x] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 连连看不是对战游戏, 没有获胜方, 可以考虑做限时判断
	 */
	public Object getWinner() {
		return null;
	}

}
