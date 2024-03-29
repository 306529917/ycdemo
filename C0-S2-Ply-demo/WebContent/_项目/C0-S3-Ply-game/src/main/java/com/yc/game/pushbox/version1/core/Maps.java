package com.yc.game.pushbox.version1.core;

public class Maps {
	
	// 当前的关数
	private static int index = 0;
	
	// 地图数组, 是三维数组, 内部的二维数组是游戏地图, 现在只有三关
	private static int[][][] maps = {
		{ 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 4, 1, 0, 0, 0 }, 
			{ 0, 1, 1, 1, 1, 3, 1, 0, 0, 0 }, 
			{ 0, 1, 4, 2, 3, 5, 1, 1, 1, 0 },
			{ 0, 1, 1, 1, 3, 2, 3, 4, 1, 0 }, 
			{ 0, 0, 0, 1, 2, 1, 1, 1, 1, 0 }, 
			{ 0, 0, 0, 1, 4, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
		},
		{ 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 }, 
			{ 0, 0, 1, 2, 5, 4, 4, 4, 1, 0 },
			{ 0, 0, 1, 2, 2, 2, 2, 2, 1, 1 }, 
			{ 0, 1, 1, 1, 3, 2, 2, 2, 2, 1 },
			{ 0, 1, 2, 2, 2, 2, 2, 2, 2, 1 }, 
			{ 0, 1, 2, 3, 2, 1, 3, 1, 2, 1 },
			{ 0, 1, 2, 2, 2, 1, 2, 2, 2, 1 }, 
			{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		},
		{
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
			{ 0, 1, 2, 2, 5, 1, 0, 0, 0, 0 }, 
			{ 0, 1, 2, 3, 3, 1, 0, 1, 1, 1 },
			{ 0, 1, 2, 3, 2, 1, 0, 1, 4, 1 }, 
			{ 0, 1, 1, 1, 2, 1, 1, 1, 4, 1 },
			{ 0, 0, 1, 1, 2, 2, 2, 2, 4, 1 }, 
			{ 0, 0, 1, 2, 2, 2, 1, 2, 2, 1 },
			{ 0, 0, 1, 2, 2, 2, 1, 1, 1, 1 }, 
			{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 }
			
		},
		{
			{0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,0,0},
			{0,1,2,2,2,2,2,1,1,1},
			{1,1,3,1,1,1,2,2,2,1},
			{1,5,2,2,3,2,2,3,2,1},
			{1,2,4,4,1,2,3,2,1,1},
			{1,1,4,4,1,2,2,2,1,0},
			{0,1,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0}
		},
		{
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,1,1,0,0,0},
			{0,0,1,1,2,2,1,0,0,0},
			{0,0,1,5,3,2,1,0,0,0},
			{0,0,1,1,3,2,1,1,0,0},
			{0,0,1,1,2,3,2,1,0,0},
			{0,0,1,4,3,2,2,1,0,0},
			{0,0,1,4,4,9,4,1,0,0},
			{0,0,1,1,1,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0}
		}
	};

	
	public static int[][] next() {
		// 只有三关, 但是 index 会不断增加, 所以用了取余来循环获取关数
		int i = index++ % maps.length;
		return clone(maps[i]);
	}
	
	/**
		数组克隆的特殊性: 请参考 https://blog.csdn.net/diyinqian/article/details/83279457
		一维数组：深克隆；（重新分配空间，并将元素复制过去）
		二维数组：浅克隆。（只传递引用）
	 */
	public static int[][] clone(int[][] array) {
		int[][] ret = array.clone();
		for (int i = 0; i < ret.length; i++) {
			ret[i] = array[i].clone();
		}
		return ret;
	} 
	
}
