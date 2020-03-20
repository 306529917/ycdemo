package com.yc.game.clean;

import javax.swing.ImageIcon;

import com.yc.game.clean.core.CleanGameImpl;
import com.yc.game.clean.swing.CleanGameWin;
import com.yc.game.common.util.SwingUtils;

public class LinkGameMain {

	public static void main(String[] args) {
		String path = "/com/yc/game/common/imgs/cartoon/girl/%s.jpg";
		ImageIcon[] cellIcons = SwingUtils.buildImageIcons(SwingUtils.class, SwingUtils.iterator(path, 0, 3), 100, 100);
		CleanGameImpl game = new CleanGameImpl(3, 4, cellIcons.length);
		CleanGameWin win = new CleanGameWin(game, cellIcons);
		game.setBcl(()->{
			win.refresh();
		});

	}

}
