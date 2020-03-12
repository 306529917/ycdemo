package pushbox;

/**
 * 游戏类,用于操作地图 map
 */
public class Game {

	// 游戏的当前地图
	private int[][] map;

	// 设置地图
	public void setMap(int[][] map) {
		this.map = map;
	}

	// 控制小人向下移动
	public void down() {
		// 先找到小人
		int[] xy = findMan();
		// 例子: y=4, x=5 ==> y=5, x=5
		int x = xy[0];
		int y = xy[1];
		// 计算箱子的坐标
		// x 不变
		int newx = x;
		// y 坐标加一
		int newy = y + 1;
		// 计算箱子后面的坐标
		int newx1 = x;
		int newy1 = y + 2;

		/**
		 * 判断是否可以移动
		 */
		if (map[newy][newx] == 1) {
			// 前面是房子,不能移动
			return;
		} else if (map[newy][newx] == 3) {
			// 如果前面是箱子, 再判断箱子前面是什么
			if (map[newy1][newx1] == 4 || map[newy1][newx1] == 2) {
				// 如果是 绿地 2 或者第 目的 4, 那么箱子就推过去
				map[newy1][newx1] = 3;
			} else {
				return;
			}
		}

		// 移动小人
		map[newy][newx] = map[y][x];
		// 将小人原来的格子还原成绿地
		map[y][x] = 2;
	}

	// 控制小人向上移动
	public void up() {
		// 先找到小人
		int[] xy = findMan();
		// 例子: y=4, x=5 ==> y=5, x=5
		int x = xy[0];
		int y = xy[1];
		// 计算箱子的坐标
		// x 不变
		int newx = x;
		// y 坐标减一
		int newy = y - 1;
		// 计算箱子后面的坐标
		int newx1 = x;
		int newy1 = y - 2;

		/**
		 * 判断是否可以移动
		 */
		if (map[newy][newx] == 1) {
			// 前面是房子,不能移动
			return;
		} else if (map[newy][newx] == 3) {
			// 如果前面是箱子, 再判断箱子前面是什么
			if (map[newy1][newx1] == 4 || map[newy1][newx1] == 2) {
				// 如果是 绿地 2 或者第 目的 4, 那么箱子就推过去
				map[newy1][newx1] = 3;
			} else {
				return;
			}
		}

		// 移动小人
		map[newy][newx] = map[y][x];
		// 将小人原来的格子还原成绿地
		map[y][x] = 2;
	}

	// 控制小人向下移动
	public void left() {
		// 先找到小人
		int[] xy = findMan();
		// 例子: y=4, x=5 ==> y=5, x=5
		int x = xy[0];
		int y = xy[1];
		// 计算箱子的坐标
		int newx = x - 1;
		int newy = y;
		// 计算箱子后面的坐标
		int newx1 = x - 2;
		int newy1 = y;

		/**
		 * 判断是否可以移动
		 */
		if (map[newy][newx] == 1) {
			// 前面是房子,不能移动
			return;
		} else if (map[newy][newx] == 3) {
			// 如果前面是箱子, 再判断箱子前面是什么
			if (map[newy1][newx1] == 4 || map[newy1][newx1] == 2) {
				// 如果是 绿地 2 或者第 目的 4, 那么箱子就推过去
				map[newy1][newx1] = 3;
			} else {
				return;
			}
		}

		// 移动小人
		map[newy][newx] = map[y][x];
		// 将小人原来的格子还原成绿地
		map[y][x] = 2;
	}

	public void right() {
		// 先找到小人
		int[] xy = findMan();
		// 例子: y=4, x=5 ==> y=5, x=5
		int x = xy[0];
		int y = xy[1];
		// 计算箱子的坐标
		int newx = x + 1;
		int newy = y;
		// 计算箱子后面的坐标
		int newx1 = x + 2;
		int newy1 = y;

		/**
		 * 判断是否可以移动
		 */
		if (map[newy][newx] == 1) {
			// 前面是房子,不能移动
			return;
		} else if (map[newy][newx] == 3) {
			// 如果前面是箱子, 再判断箱子前面是什么
			if (map[newy1][newx1] == 4 || map[newy1][newx1] == 2) {
				// 如果是 绿地 2 或者第 目的 4, 那么箱子就推过去
				map[newy1][newx1] = 3;
			} else {
				return;
			}
		}

		// 移动小人
		map[newy][newx] = map[y][x];
		// 将小人原来的格子还原成绿地
		map[y][x] = 2;
	}

	/**
	 * 判断游戏是否结束
	 * @return
	 */
	public boolean isOver() {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				// 找到小人就返回他的坐标值
				if (map[y][x] == 4) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 找小人
	 */
	public int[] findMan() {
		// 代码复用 最简单的方式 copy
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				// 找到小人就返回他的坐标值
				if (map[y][x] == 5) {
					return new int[] { x, y };
				}
			}
		}
		return null;
	}

}
