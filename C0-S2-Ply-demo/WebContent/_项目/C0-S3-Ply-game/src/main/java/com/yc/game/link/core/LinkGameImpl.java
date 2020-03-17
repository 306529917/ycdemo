package com.yc.game.link.core;

import com.yc.game.common.util.LangUtils;

public class LinkGameImpl extends LinkGameAbs {

	public LinkGameImpl(int width, int height, int imgCount) {
		super(width, height, imgCount);
	}

	@Override
	public void begin() {
		// 由于棋盘是Integer类型,所以初始值要赋值 0
		LangUtils.each(board, (Integer i, int[] pos) -> {
			board[pos[0]][pos[1]] = 0;
			return true;
		});

		int value = 0;
		int index = 0;
		int imgIndex = 0;
		// 成对的放置图片
		for (int y = 1; y < height - 1; y++) {
			for (int x = 1; x < width - 1; x++) {
				if (index++ % 2 == 0) {
					value = imgIndex++ % (imgCount-1) + 1 ;
				}
				board[y][x] = value;
			}
		}
		// 打乱棋盘
		for (int y = 1; y < height - 1; y++) {
			for (int x = 1; x < width - 1; x++) {
				int newx = (int) (Math.random() * (width - 2) + 1);
				int newy = (int) (Math.random() * (height - 2) + 1);
				int tmp = board[y][x];
				board[y][x] = board[newy][newx];
				board[newy][newx] = tmp;
			}
		}
	}

	@Override
	public boolean link(int x1, int y1, int x2, int y2) {
		if (board[y1][x1] != board[y2][x2] || board[y1][x1] == 0) {
			return false;
		}
		if (link0(x1, y1, x2, y2) || link1(x1, y1, x2, y2) || link2(x1, y1, x2, y2)) {
			board[y1][x1] = board[y2][x2] = 0;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 两个拐点的连接
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	private boolean link2(int x1, int y1, int x2, int y2) {
		boolean[] ret = { false };
		LangUtils.each(board, (Integer cell, int[] pos) -> {
			if (cell == 0) {
				// 将坐标1复制到棋盘上任意的一个空白点处
				board[pos[0]][pos[1]] = board[y1][x1];
				// 测试 直线连 + 1个拐点连
				boolean test0 = link0(x1, y1, pos[1], pos[0]);
				boolean test1 = link1(pos[1], pos[0], x2, y2);
				// 恢复空白点的值
				board[pos[0]][pos[1]] = 0;
				if (test0 == false || test1 == false) {
					return true;
				} else {
					ret[0] = true;
					return false;
				}
			}
			return true;
		});
		return ret[0];
	}

	/**
	 * 一个拐点连接
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	private boolean link1(int x1, int y1, int x2, int y2) {
		boolean ret = false;
		if (board[y1][x2] == 0) {
			board[y1][x2] = board[y1][x1];
			boolean ret1 = link0(x1, y1, x2, y1);
			boolean ret2 = link0(x2, y2, x2, y1);
			ret = ret1 && ret2;
			board[y1][x2] = 0;
		}
		if (ret == false && board[y2][x1] == 0) {
			board[y2][x1] = board[y1][x1];
			boolean ret1 = link0(x1, y1, x1, y2);
			boolean ret2 = link0(x2, y2, x1, y2);
			ret = ret1 && ret2;
			board[y2][x1] = 0;
		}
		return ret;
	}

	/**
	 * 直线连接
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	private boolean link0(int x1, int y1, int x2, int y2) {
		boolean[] ret = { true };
		if (x1 == x2) {
			if (Math.abs(y1 - y2) == 1) {
				return true;
			}
			LangUtils.eachIn(y1, y2, (Integer ny, int[] pos) -> {
				return board[ny][x1] == 0 ? true : (ret[0] = false);
			});
		} else if (y1 == y2) {
			if (Math.abs(x1 - x2) == 1) {
				return true;
			}
			LangUtils.eachIn(x1, x2, (Integer nx, int[] pos) -> {
				return board[y1][nx] == 0 ? true : (ret[0] = false);
			});
		} else {
			ret[0] = false;
		}
		return ret[0];
	}

}
