package com.yc.game.common.util;

import java.awt.Component;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	/**
	 * 使用路径迭代器创建图片
	 * @param cls
	 * @param it
	 * @return
	 */
	public static ImageIcon[] buildImageIcons(Class<?> cls, Iterator<String> it) {
		List<ImageIcon> list = new ArrayList<>();
		while (it.hasNext()) {
			String path = it.next();
			list.add(getImageIcon(cls, path));
		}
		return list.toArray(new ImageIcon[list.size()]);
	}

	/**
	 * 使用路径数组创建图片数组
	 * @param cls
	 * @param paths
	 * @return
	 */
	public static ImageIcon[] buildImageIcons(Class<?> cls, String... paths) {
		List<ImageIcon> list = new ArrayList<>();
		for (String path : paths) {
			list.add(getImageIcon(cls, path));
		}
		return list.toArray(new ImageIcon[list.size()]);
	}
}
