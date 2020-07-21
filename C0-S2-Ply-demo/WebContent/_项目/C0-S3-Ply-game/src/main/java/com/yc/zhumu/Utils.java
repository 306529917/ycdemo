package com.yc.zhumu;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JOptionPane;

public class Utils {

	public static void center(Window win) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		int w = win.getWidth();
		int h = win.getHeight();
		win.setLocation((width - w) / 2, (height - h) / 2);
	}

	public static <T> T[] add(T[] ts, T t) {
		Set<T> s = new LinkedHashSet<>();
		s.addAll(Arrays.asList(ts));
		s.add(t);
		return s.toArray(ts);
	}

	public static <T> T[] add(T[] ts, T t, int index) {
		Set<T> s = new LinkedHashSet<>();
		for (int i = 0; i < ts.length; i++) {
			if (i == index) {
				s.add(t);
			}
			s.add(ts[i]);
		}
		if (s.size() == ts.length) {
			s.add(t);
		}
		return s.toArray(ts);
	}

	public static void alert(Component frame, String msg) {
		JOptionPane.showConfirmDialog(frame, msg, "系统提示", JOptionPane.CLOSED_OPTION);
	}

	public static boolean confirm(Component frame, String msg) {
		int ret = JOptionPane.showConfirmDialog(frame, msg, "系统提示", JOptionPane.YES_NO_OPTION);
		return ret == 0;
	}

}
