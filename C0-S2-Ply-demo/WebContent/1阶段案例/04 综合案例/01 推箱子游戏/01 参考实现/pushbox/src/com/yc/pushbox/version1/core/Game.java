package com.yc.pushbox.version1.core;

/**
 * 	��ͼ����
 * 	1, ʹ�� int �Ͷ�ά�����ʾ��ͼ
 * 	2, ��ͼ��Ԫ�ض�Ӧֵ
 * 		1	��ͼ�߽�( ���� )
 * 		2	�յ�
 * 		3	����
 * 		4	Ŀ�ĵ�, Ҳ��������Ҫ���ǵĸ��� ( С��ͷ )
 * 		5	С�˳���, �����汾���ĸ�������С��ͳһ�ó��±�ʾ
 * 		6	С�˳���, �����汾��û��
 * 		7	С�˳���, �����汾��û��
 * 		8	С�˳���, �����汾��û��
 * 		9	����ѹ��Ŀ�ĵظ�����֮��, ������ʾ���µ�״ֵ̬, �����汾��û��
 */
public class Game {
	// ��ͼ
	private static int[][] map;
	// ԭʼ��ͼ�����ڻָ��ƶ���ĵذ���ж���Ϸ����
	private static int[][] mapOld;
	// ��Ϸ������־����û����ÿ�ζ����жϵ�ͼ
	private static boolean isOver;

	public static int[][] next() {
		isOver = false;
		map = Maps.next();
		mapOld = Maps.clone(map);
		return map;
	}

	/**
	 * 	����һ��
	 * @return
	 */
	public static int[][] reset() {
		isOver = false;
		map = Maps.clone(mapOld);
		return map;
	}

	/**
	 * 	���ص�ǰ��ͼ
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
	 * 	�ƶ�С��
	 * @param ox
	 * @param oy
	 */
	private static void moveMan(int ox, int oy) {
		if(isOver) {
			return;
		}
		// �ҵ�С�˵�����
		int[] xy = findMan();
		int x = xy[0];
		int y = xy[1];
		// ����ǰ����ӵ�����
		int tx = x + ox;
		int ty = y + oy;
		if (map[ty][tx] == 1) {
			// ǰ���ǵ�ͼ�߽磬���� 
			return;
		} else if (map[ty][tx] == 3) {
			// ǰ��������, ���ƶ�����
			moveItem(tx, ty, ox, oy);
		}
		// �ƶ�С��
		moveItem(x, y, ox, oy);
	}

	/**
	 * 	�ƶ�����( С�˻����� )
	 * @param x
	 * @param y
	 * @param ox
	 * @param oy
	 */
	private static void moveItem(int x, int y, int ox, int oy) {
		// ����ǰ����ӵ�����
		int tx = x + ox;
		int ty = y + oy;
		if (map[ty][tx] == 2 || map[ty][tx] == 4) {
			// ���ǰ���ǿո��Ŀ�ĵ�, ���ƶ�����
			map[ty][tx] = map[y][x];
			// �ָ��ƶ���Ŀո�, Ҫ��ԭʼ��ͼ�л�ȡԭ���ĸ���ֵ
			map[y][x] = mapOld[y][x] == 4 ? 4 : 2;
		}
	}

	/**
	 * 	��С�˵�λ��, ��ͼ��Ϊ 5,6,7,8�ĸ���
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
	 * 	�ж���Ϸ�Ƿ����, ���ǵ�ͼ������Ŀ�ĵĸ���( ֵΪ4) ȫ���������滻��, ��Ҫ��ԭʼ��ͼ���ж�
	 * @return
	 */
	public static boolean isOver() {
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[y].length; x++) {
				// Ԫ�ص�ͼ��Ŀ��, �������ڲ�������, ��ô˵��������δ����
				if (mapOld[y][x] == 4 && map[y][x] != 3) {
					return false;
				}
			}
		}
		// ��ͼ�ϵ�Ŀ�ĵ�( 4 ),�������Ӹ�����, �ͽ�����
		return true;
	}

}
