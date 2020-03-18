package com.yc.game.link;

import javax.swing.ImageIcon;

import com.yc.game.common.util.SwingUtils;
import com.yc.game.link.core.LinkGameImpl;
import com.yc.game.link.swing.LinkGameWin;

public class LinkGameMain {

	public static void main(String[] args) {
		String path = "/com/yc/game/common/imgs/cartoon/girl/%s.jpg";
		ImageIcon[] cellIcons = SwingUtils.buildImageIcons(SwingUtils.class, 
				SwingUtils.iterator(path, 0, 20),100,100);

		new LinkGameWin(new LinkGameImpl(12, 7, cellIcons.length), cellIcons);

	}

}
