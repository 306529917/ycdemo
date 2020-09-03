package com.yc.work.saolei;

import java.util.Arrays;

import javax.swing.ImageIcon;

public class BaseSaoLeiGame {
	public static final ImageIcon IMG_LEI = new ImageIcon(TestWin.class.getResource("imgs/lei.png"));
	public static final ImageIcon IMG_SIGN = new ImageIcon(TestWin.class.getResource("imgs/sign.png"));
	/**
	 * 未處理（默认值）
	 */
	public static final int STATE_NONE = -1;
	/**
	 * 判断为地雷，标记旗子
	 */
	public static final int STATE_SIGN = -2;
	/**
	 * 触雷爆炸
	 */
	public static final int STATE_FIRE = -3;

	public static final int[][] AROUNDS = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 },
			{ 1, 1 } };
	private boolean[][] map1; // true雷， false不是雷
	private int[][] map2; // -1 未處理，-2 旗子，-3 爆炸, 0~8周围的雷数 
	private int height;
	private int width;

	public BaseSaoLeiGame(int height, int width, int level) {
		this.height = height;
		this.width = width;
		start(height, width, level);
	}

	public void start(int height, int width, int level) {
		map1 = new boolean[height][width];
		map2 = new int[height][width];
		for (int i = 0; i < map2.length; i++) {
			Arrays.fill(map2[i], STATE_NONE);
		}
		int count = height * width * level / 10;
		int x, y;
		for (int i = 0; i < count; i++) {
			do {
				x = (int) (Math.random() * width);
				y = (int) (Math.random() * height);
				if (map1[y][x] == false) {
					map1[y][x] = true;
				}
			} while (map1[y][x] == false);
		}
	}

	public void print() {
		for (int y = 0; y < map1.length; y++) {
			if (y == 0) {
				System.out.print("  ");
				for (int x = 0; x < map2[y].length; x++) {
					System.out.printf("%2d", x);
				}
				System.out.println();
			}
			for (int x = 0; x < map2[y].length; x++) {
				if (x == 0) {
					System.out.printf("%STATE_SIGNd", y);
				}
				System.out.print(map2[y][x] == STATE_NONE ? "  " : ((map2[y][x] > STATE_NONE ? " " : "") + map2[y][x]));
			}
			System.out.print("\t\t");
			for (int x = 0; x < map1[y].length; x++) {
				System.out.print(map1[y][x] ? " *" : "  ");
			}
			System.out.println();
		}
	}

	public int open(int x, int y) {
		if (isValid(x, y) == false) {
			return STATE_NONE;
		} else if (map2[y][x] == STATE_NONE) {
			return map2[y][x] = map1[y][x] ? STATE_FIRE : countLei(x, y);
		} else {
			return map2[y][x];
		}
	}

	public int sign(int x, int y) {
		if (isValid(x, y) == false) {
			return STATE_NONE;
		} else if (map2[y][x] == STATE_NONE) {
			return map2[y][x] = STATE_SIGN;
		} else if (map2[y][x] == STATE_SIGN) {
			return map2[y][x] = STATE_NONE;
		} else {
			return map2[y][x];
		}
	}

	public boolean isLei(int x, int y) {
		if (isValid(x, y)) {
			return map1[y][x];
		} else {
			return false;
		}
	}

	public int getState(int x, int y) {
		if (isValid(x, y)) {
			return map2[y][x];
		} else {
			return STATE_NONE;
		}
	}

	public boolean canAutoOpen(int x, int y) {
		if (map2[y][x] == 0) {
			return true;
		} else if (map2[y][x] > 0) {
			int count = 0;
			for (int i = 0; i < AROUNDS.length; i++) {
				int xx = x + AROUNDS[i][0];
				int yy = y + AROUNDS[i][1];
				if (isValid(xx, yy) && map2[yy][xx] == STATE_SIGN) {
					count++;
					;
				}
			}
			return map2[y][x] == count;
		} else {
			return false;
		}
	}

	public boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && y < map2.length && x < map2[y].length;
	}

	/**
	 * 统计周围的雷数
	 * @param x
	 * @param y
	 * @return
	 */
	private int countLei(int x, int y) {
		int count = 0;
		for (int i = 0; i < AROUNDS.length; i++) {
			if (isLei(x + AROUNDS[i][1], y + AROUNDS[i][0])) {
				count++;
			}
		}
		return count;
	}
	
	public int countSign(int x, int y) {
		int count = 0;
		for (int i = 0; i < AROUNDS.length; i++) {
			int xx = x + AROUNDS[i][0];
			int yy = y + AROUNDS[i][1];
			if (isValid(xx,yy) && map2[yy][xx] == STATE_SIGN) {
				count++;
			}
		}
		return count;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
