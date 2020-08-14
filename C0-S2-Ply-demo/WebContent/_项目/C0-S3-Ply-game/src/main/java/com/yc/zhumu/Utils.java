package com.yc.zhumu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.stream.Stream;

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

	public static void alert(String msg) {
		JOptionPane.showConfirmDialog(null, msg, "系统提示", JOptionPane.CLOSED_OPTION);
	}

	public static boolean confirm(String msg) {
		int ret = JOptionPane.showConfirmDialog(null, msg, "系统提示", JOptionPane.YES_NO_OPTION);
		return ret == 0;
	}

	public static String readLine(File file, int lineNumber) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			int i = 0;
			while ((line = br.readLine()) != null && i++ < lineNumber) {
			}
			return line;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static String[] check(String a, String b) {
		String[] as = a.split("\\n");
		String[] bs = b.split("\\s*[,;；，\n]\\s*");
		as = Stream.of(as).filter(p -> {
			return p.matches("\\d+\\s+(.+?)\\s.+");
		}).map((line) -> {
			return line.replaceAll("\\d+\\s+(.+?)\\s.+", "$1");
		}).toArray(String[]::new);
		bs = Stream.of(bs).filter(p -> {
			return !p.trim().isEmpty();
		}).toArray(String[]::new);
		return check(as, bs);
	}

	public static String[] check(String[] a, String[] b) {
		Arrays.sort(b);
		for (int i = 0; i < a.length; i++) {
			if (Arrays.binarySearch(b, a[i]) < 0) {
				a[i] = "";
			}
			a[i] = i + 1 + "\t" + a[i];
		}
		return a;
	}

	public static void main(String[] args) {
		String a = "编号  姓名  到勤状态  备注\n" + "1 方伟  已到   迟到   病假   请假   旷课   早退   未打卡\n"
				+ "2 李炜城 已到   迟到   病假   请假   旷课   早退   未打卡\n" + "3 周燕伟 已到   迟到   病假   请假   旷课   早退   未打卡\n"
				+ "4 潘振国 已到   迟到   病假   请假   旷课   早退   未打卡\n" + "5 苏运泉 已到   迟到   病假   请假   旷课   早退   未打卡\n"
				+ "6 彭玉阳 已到   迟到   病假   请假   旷课   早退   未打卡\n" + "7 向思达 已到   迟到   病假   请假   旷课   早退   未打卡\n"
				+ "8 夏可浩 已到   迟到   病假   请假   旷课   早退   未打卡\n" + "9 彭业成 已到   迟到   病假   请假   旷课   早退   未打卡\n"
				+ "10  胡鹰飞 已到   迟到   病假   请假   旷课   早退   未打卡\n" + "11  贺井龙 已到   迟到   病假   请假   旷课   早退   未打卡\n"
				+ "12  李航宇 已到   迟到   病假   请假   旷课   早退   未打卡\n" + "13  彭凯  已到   迟到   病假   请假   旷课   早退   未打卡";
		String b = "邝原原, 彭业成, 周军, 李航宇, 李赣, 夏可浩, 曹舒婕, 王嘉怡, 苏运泉, 李玲芝, 胡娟秀, 罗幸, 严玥, 曹浩林, 刘浪, 张宁, 喻学峰, 戴梦涛, 谭奔, 付淑婷, 邹蔓, 罗艳, 高航, 黄慧超, 李炜城, 王磊";

		String[] res = check(a, b);
		for (String s : res) {
			System.out.println(s);
		}
	}

}
