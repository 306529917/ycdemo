package com.yc.game.wuzi;

import java.awt.EventQueue;

import com.yc.game.wuzi.core.WuziGame;
import com.yc.game.wuzi.core.WuziGameImpl;
import com.yc.game.wuzi.swing.MainWin;

/**
 * 五子棋主程序
 * @author 廖彦
 */

public class Main {
	public static void main(String[] args) {
		// 传入游戏实现类对象
		start(new WuziGameImpl());
	}
	
	/**
	 * 开始游戏
	 * @param game
	 */
	public static void start(WuziGame game) {
		/**
		 * 这是自动生成的代码, 用于启动窗口
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin frame = new MainWin(game);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
