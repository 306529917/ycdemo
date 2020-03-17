package com.yc.game.common.base;

import java.util.Arrays;

/**
 * 二维数组游戏接口
 * @author 廖彦
 *
 */
public interface TwoArrayGame extends Game {
	Integer[][] getBoard();

	default void print() {
		Integer[][] array = getBoard();
		for (int y = 0; y < array.length; y++) {
			System.out.println(Arrays.toString(array[y]));
		}
	}
}
