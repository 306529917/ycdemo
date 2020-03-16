package com.yc.game.wuzi;

import java.awt.EventQueue;

import com.yc.game.wuzi.core.WuziGame;
import com.yc.game.wuzi.core.WuziGameImpl;
import com.yc.game.wuzi.swing.MainWin;

public class Main {
	/**
	 * Launch the application.
	 * 这是自动生成的代码, 用于启动窗口
	 */
	public static void main(String[] args) {
		start(new WuziGameImpl());
	}
	
	public static void start(WuziGame game) {
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
