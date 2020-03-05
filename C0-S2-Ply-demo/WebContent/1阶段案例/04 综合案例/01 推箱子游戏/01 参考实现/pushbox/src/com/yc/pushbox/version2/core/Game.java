package com.yc.pushbox.version2.core;

public class Game {
	private static int[][] map;
	private static int[][] mapOld;
	private static boolean isOver;

	public static int[][] next() {
		isOver = false;
		map = Maps.next();
		mapOld = Maps.clone(map);
		return map;
	}


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

	private static void moveMan(int ox, int oy) {
		if(isOver) {
			return;
		}
		int[] xy = findMan();
		int x = xy[0];
		int y = xy[1];
		int tx = x + ox;
		int ty = y + oy;
		if (map[ty][tx] == 1) {
			return;
		} else if (map[ty][tx] == 3) {
			moveItem(tx, ty, ox, oy);
		}
		moveItem(x, y, ox, oy);
	}

	private static void moveItem(int x, int y, int ox, int oy) {
		int tx = x + ox;
		int ty = y + oy;
		if (map[ty][tx] == 2 || map[ty][tx] == 4) {
			map[ty][tx] = map[y][x];
			map[y][x] = mapOld[y][x] == 4 ? 4 : 2;
		}
	}

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

	public static boolean isOver() {
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				if (mapOld[y][x] == 4 && map[y][x] != 3) {
					return false;
				}
			}
		}
		return true;
	}

}
