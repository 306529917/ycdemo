package com.yc.pushbox.version1.core;

/**
 * 	地图规则
 * 	1, 使用 int 型二维数组表示地图
 * 	2, 地图中元素对应值
 * 		1	地图边界( 房子 )
 * 		2	空地
 * 		3	箱子
 * 		4	目的地, 也就是箱子要覆盖的格子 ( 小箭头 )
 * 		5	小人朝下, 初级版本中四个方法的小人统一用朝下表示
 * 		6	小人朝左, 初级版本中没用
 * 		7	小人朝右, 初级版本中没用
 * 		8	小人朝上, 初级版本中没用
 * 		9	箱子压在目的地格子上之后, 箱子显示的新的状态值, 初级版本中没用
 */
public class Game {
	// 地图
	private static int[][] map;
	// 原始地图，用于恢复移动后的地板和判断游戏结束
	private static int[][] mapOld;
	// 游戏结束标志，如没有则每次都需判断地图
	private static boolean isOver;

	public static int[][] next() {
		isOver = false;
		map = Maps.next();
		mapOld = Maps.clone(map);
		return map;
	}

	/**
	 * 	重来一次
	 * @return
	 */
	public static int[][] reset() {
		isOver = false;
		map = Maps.clone(mapOld);
		return map;
	}

	/**
	 * 	返回当前地图
	 * @return
	 */
	public static int[][] getMap() {
		return map;
	}

	public static void up() {
		moveMan(0, -1);
	}

	public static void down() {
		moveMan(0, 1);
	}

	public static void left() {
		moveMan(-1, 0);
	}

	public static void right() {
		moveMan(1, 0);
	}

	/**
	 * 	移动小人
	 * @param ox
	 * @param oy
	 */
	private static void moveMan(int ox, int oy) {
		if(isOver) {
			return;
		}
		// 找到小人的坐标
		int[] xy = findMan();
		int x = xy[0];
		int y = xy[1];
		// 计算前面格子的坐标
		int tx = x + ox;
		int ty = y + oy;
		if (map[ty][tx] == 1) {
			// 前面是地图边界，返回 
			return;
		} else if (map[ty][tx] == 3) {
			// 前面是箱子, 先推动箱子
			moveItem(tx, ty, ox, oy);
		}
		// 移动小人
		moveItem(x, y, ox, oy);
	}

	/**
	 * 	移动物体( 小人或箱子 )
	 * @param x
	 * @param y
	 * @param ox
	 * @param oy
	 */
	private static void moveItem(int x, int y, int ox, int oy) {
		// 计算前面格子的坐标
		int tx = x + ox;
		int ty = y + oy;
		if (map[ty][tx] == 2 || map[ty][tx] == 4) {
			// 如果前面是空格和目的地, 则移动物体
			map[ty][tx] = map[y][x];
			// 恢复移动后的空格, 要从原始地图中获取原来的格子值
			map[y][x] = mapOld[y][x] == 4 ? 4 : 2;
		}
	}

	/**
	 * 	找小人的位置, 地图中为 5,6,7,8的格子
	 * @return
	 */
	private static int[] findMan() {
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				if (map[y][x] == 5 || map[y][x] == 6 || map[y][x] == 7 || map[y][x] == 8) {
					return new int[] { x, y };
				}
			}
		}
		return null;
	}

	/**
	 * 	判断游戏是否结束, 就是地图上所得目的的格子( 值为4) 全部被箱子替换了, 这要用原始地图来判断
	 * @return
	 */
	public static boolean isOver() {
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				// 元素地图是目的, 并且现在不是箱子, 那么说明游侠还未结束
				if (mapOld[y][x] == 4 && map[y][x] != 3) {
					return false;
				}
			}
		}
		// 地图上的目的地( 4 ),都被箱子覆盖了, 就结束了
		return true;
	}

}
