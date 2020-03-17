package com.yc.game.link;

import javax.swing.ImageIcon;

import com.yc.game.common.util.SwingUtils;
import com.yc.game.link.core.LinkGameImpl;
import com.yc.game.link.swing.MainWin;

public class Main {

	public static void main(String[] args) {
		ImageIcon[] cellIcons = SwingUtils.buildImageIcons(Main.class, 
				SwingUtils.iterator("core/imgs/%s.jpg", 0, 15),100,100);

		new MainWin(new LinkGameImpl(10, 6, cellIcons.length), cellIcons);

	}

}
