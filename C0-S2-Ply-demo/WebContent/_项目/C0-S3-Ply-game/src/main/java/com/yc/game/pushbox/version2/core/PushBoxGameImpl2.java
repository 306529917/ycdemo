package com.yc.game.pushbox.version2.core;

import com.yc.game.pushbox.version1.core.PushBoxGameImpl1;

public class PushBoxGameImpl2 extends PushBoxGameImpl1 {
	// 记录移动的步数
	protected int stepNumber = 0;

	public int[][] next() {
		stepNumber = 0;
		return super.next();
	}

	public int[][] reset() {
		stepNumber = 0;
		return super.reset();
	}

	public void up() {
		int[] xy = moveMan(0, -1);
		// 改变小人的朝向,让其向上
		map[xy[1]][xy[0]] = 8;
	}

	public void down() {
		int[] xy = moveMan(0, 1);
		// 改变小人的朝向,让其向下
		map[xy[1]][xy[0]] = 5;
	}

	public void left() {
		int[] xy = moveMan(-1, 0);
		// 改变小人的朝向,让其向左
		map[xy[1]][xy[0]] = 6;
	}

	public void right() {
		int[] xy = moveMan(1, 0);
		// 改变小人的朝向,让其向右
		map[xy[1]][xy[0]] = 7;
	}

	/**
	 * 	移动小人
	 * @param ox
	 * @param oy
	 * @return 返回小人的坐标
	 */
	private int[] moveMan(int ox, int oy) {
		// 找到小人的坐标
		int[] xy = findMan();
		if (isOver) {
			return xy;
		}
		int x = xy[0];
		int y = xy[1];
		// 计算前面格子的坐标
		int tx = x + ox;
		int ty = y + oy;
		if (map[ty][tx] == 1) {
			// 前面是地图边界，返回
			return xy;
		} else if (map[ty][tx] == 3 || map[ty][tx] == 9) {
			// 前面是箱子, 先推动箱子
			xy = moveItem(tx, ty, ox, oy);
			// 如果背箱子压住是目的地, 那么箱子颜色变成9
			if(mapOld[xy[1]][xy[0]] == 4 || mapOld[xy[1]][xy[0]] == 9) {
				map[xy[1]][xy[0]] = 9;
			} else {
				map[xy[1]][xy[0]] = 3;
			}
		}
		// 移动小人
		int[] newxy = moveItem(x, y, ox, oy);
		// 只有移动后才计算步数
		if(newxy[0] != x || newxy[1] != y) {
			stepNumber ++;
		}
		return newxy;
	}

	/**
	 * 	移动物体( 小人或箱子 )
	 * @param x
	 * @param y
	 * @param ox
	 * @param oy
	 * @return 返回移动后的物体的坐标
	 */
	private int[] moveItem(int x, int y, int ox, int oy) {
		// 计算前面格子的坐标
		int tx = x + ox;
		int ty = y + oy;
		if (map[ty][tx] == 2 || map[ty][tx] == 4) {
			// 如果前面是空格和目的地, 则移动物体
			map[ty][tx] = map[y][x];
			// 恢复移动后的空格, 要从原始地图中获取原来的格子值
			map[y][x] = mapOld[y][x] == 4 || mapOld[y][x] == 9 ? 4 : 2;
			return new int[] { tx, ty };
		}
		return new int[] { x, y };
	}

	/**
	 * 	找小人的位置, 地图中为 5,6,7,8的格子
	 * @return
	 */
	private int[] findMan() {
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				if (map[y][x] == 5 || map[y][x] == 6 || map[y][x] == 7 || map[y][x] == 8) {
					return new int[] { x, y };
				}
			}
		}
		return null;
	}

	public boolean isOver() {
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				// 地图上有3号箱子就表示还没结束了
				if (map[y][x] == 3) {
					return false;
				}
			}
		}
		// 地图上没有3号箱子就结束了
		return true;
	}

	// 返回移动的步数
	public int getStepNumber() {
		return stepNumber;
	}
}
