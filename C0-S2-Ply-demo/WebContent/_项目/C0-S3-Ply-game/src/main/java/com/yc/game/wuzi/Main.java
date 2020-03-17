package com.yc.game.wuzi;

import com.yc.game.wuzi.core.WuziGameImpl;
import com.yc.game.wuzi.swing.MainWin;

/**
 * 五子棋主程序
 * @author 廖彦
 */

public class Main {
	public static void main(String[] args) {
		// 传入游戏实现类对象
		new MainWin(new WuziGameImpl()).start();
	}

}
