package com.yc.game.pushbox.version3.swing;

import com.yc.game.pushbox.base.PushBoxGame;
import com.yc.game.pushbox.version3.core.PushBoxGameImpl3;

/**
 * 版本3的界面和版本2没有变化
 * @author 廖彦
 */
public class MainWin extends com.yc.game.pushbox.version2.swing.MainWin {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new MainWin(new PushBoxGameImpl3());
	}
	
	public MainWin(PushBoxGame game) {
		super(game);
	}

}
