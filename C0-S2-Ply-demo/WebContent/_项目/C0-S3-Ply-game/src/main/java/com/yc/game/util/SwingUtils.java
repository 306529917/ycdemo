package com.yc.game.util;

import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * Swing 工具类
 * @author 廖彦
 *
 */
public class SwingUtils {
	/**
	 * 控件居中
	 * @param component
	 */
	public static void center(Component component) {
		int screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int windowwidth = component.getSize().width;
		int windowheight = component.getSize().height;
		component.setLocation((screenwidth - windowwidth) / 2, (screenheight - windowheight) / 2);
	}

	/**
	 * 使用类路径构建图片Icon
	 * @param cls
	 * @param path
	 * @return
	 */
	public static ImageIcon getImageIcon(Class<?> cls, String path) {
		return new ImageIcon(IOUtils.toByteArray(cls.getResourceAsStream(path)));
	}
}
