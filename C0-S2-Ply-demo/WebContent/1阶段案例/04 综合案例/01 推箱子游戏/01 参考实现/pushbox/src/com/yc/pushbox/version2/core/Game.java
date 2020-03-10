package com.yc.pushbox.version2.core;

import com.yc.pushbox.version1.core.Maps;

/**
 * 	��ͼ����
 * 	1, ʹ�� int �Ͷ�ά�����ʾ��ͼ
 * 	2, ��ͼ��Ԫ�ض�Ӧֵ
 * 		1	��ͼ�߽�( ���� )
 * 		2	�յ�
 * 		3	����
 * 		4	Ŀ�ĵ�, Ҳ��������Ҫ���ǵĸ��� ( С��ͷ )
 * 		5	С�˳���, �����汾��û�� ( �����Ǻ����� )
 * 		6	С�˳���, �����汾��û��
 * 		7	С�˳���, �����汾��û��
 * 		8	С�˳���, �����汾���ĸ�������С��ͳһ�ó��±�ʾ
 * 		9	����ѹ��Ŀ�ĵظ�����֮��, ������ʾ���µ�״ֵ̬, �����汾��û��
 */
public class Game {
	// ��ͼ
	private static int[][] map;
	// ԭʼ��ͼ�����ڻָ��ƶ���ĵذ���ж���Ϸ����
	private static int[][] mapOld;
	// ��Ϸ������־����û����ÿ�ζ����жϵ�ͼ
	private static boolean isOver;
	// ��¼�ƶ��Ĳ���
	private static int stepNumber = 0;

	public static int[][] next() {
		stepNumber = 0;
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
		stepNumber = 0;
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
		int[] xy = moveMan(0, -1);
		map[xy[1]][xy[0]] = 8;
	}

	public static void down() {
		int[] xy = moveMan(0, 1);
		map[xy[1]][xy[0]] = 5;
	}

	public static void left() {
		int[] xy = moveMan(-1, 0);
		map[xy[1]][xy[0]] = 6;
	}

	public static void right() {
		int[] xy = moveMan(1, 0);
		map[xy[1]][xy[0]] = 7;
	}

	/**
	 * 	�ƶ�С��
	 * @param ox
	 * @param oy
	 * @return ����С�˵�����
	 */
	private static int[] moveMan(int ox, int oy) {
		// �ҵ�С�˵�����
		int[] xy = findMan();
		if (isOver) {
			return xy;
		}
		int x = xy[0];
		int y = xy[1];
		// ����ǰ����ӵ�����
		int tx = x + ox;
		int ty = y + oy;
		if (map[ty][tx] == 1) {
			// ǰ���ǵ�ͼ�߽磬����
			return xy;
		} else if (map[ty][tx] == 3 || map[ty][tx] == 9) {
			// ǰ��������, ���ƶ�����
			xy = moveItem(tx, ty, ox, oy);
			// ���������ѹס��Ŀ�ĵ�, ��ô������ɫ���9
			if(mapOld[xy[1]][xy[0]] == 4 || mapOld[xy[1]][xy[0]] == 9) {
				map[xy[1]][xy[0]] = 9;
			} else {
				map[xy[1]][xy[0]] = 3;
			}
		}
		// �ƶ�С��
		int[] newxy = moveItem(x, y, ox, oy);
		// ֻ���ƶ���ż��㲽��
		if(newxy[0] != x || newxy[1] != y) {
			stepNumber ++;
		}
		return newxy;
	}

	/**
	 * 	�ƶ�����( С�˻����� )
	 * @param x
	 * @param y
	 * @param ox
	 * @param oy
	 * @return �����ƶ�������������
	 */
	private static int[] moveItem(int x, int y, int ox, int oy) {
		// ����ǰ����ӵ�����
		int tx = x + ox;
		int ty = y + oy;
		if (map[ty][tx] == 2 || map[ty][tx] == 4) {
			// ���ǰ���ǿո��Ŀ�ĵ�, ���ƶ�����
			map[ty][tx] = map[y][x];
			// �ָ��ƶ���Ŀո�, Ҫ��ԭʼ��ͼ�л�ȡԭ���ĸ���ֵ
			map[y][x] = mapOld[y][x] == 4 || mapOld[y][x] == 9 ? 4 : 2;
			return new int[] { tx, ty };
		}
		return new int[] { x, y };
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
				// ��ͼ����3�����Ӿͱ�ʾ��û������
				if (map[y][x] == 3) {
					return false;
				}
			}
		}
		// ��ͼ��û��3�����Ӿͽ�����
		return true;
	}

	// �����ƶ��Ĳ���
	public static int getStepNumber() {
		return stepNumber;
	}
}
