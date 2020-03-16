package com.yc.game.link;

import java.util.Iterator;

import javax.swing.ImageIcon;

import com.yc.game.common.util.SwingUtils;
import com.yc.game.link.core.LinkGameImpl;
import com.yc.game.link.swing.MainWin;

public class Main {

	public static void main(String[] args) {
		ImageIcon[] cellIcons = SwingUtils.buildImageIcons(Main.class, new Iterator<String>() {
			private int i = 0;

			@Override
			public boolean hasNext() {
				return i < 10;
			}

			@Override
			public String next() {
				return "core/imgs/" + i++ + ".GIF";
			}
		});

		new MainWin(new LinkGameImpl(20, 12, cellIcons.length), cellIcons);

	}

}
