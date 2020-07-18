package com.yc.zhumu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

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

}
