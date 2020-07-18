package com.yc.zhumu;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;

public class ZhumuBiz {
	private static String zhumuHome = "C:/Users/Administrator/Documents/zhumu";
	private static Properties conf = new Properties();
	private Set<String> members = new HashSet<>();
	private List<Question> qList = new ArrayList<>();
	private Question question;
	private File zhumuFile;
	private Random rand = new Random();
	private String cls;

	static {
		loadConf();
	}

	public static void loadConf() {
		FileInputStream fis = null;
		try {
			File datafile = new File(zhumuHome, "zhumu.ini");
			if (datafile.exists() == false) {
				datafile.createNewFile();
			}
			fis = new FileInputStream(datafile);
			conf.load(new InputStreamReader(fis, "UTF-8"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String[] args) {
		ZhumuBiz zb = new ZhumuBiz("91", "2020-07-12 ");
		zb.start("test", "1").setDate("2020-07-12 19:20:20");
		zb.saveData();
	}

	public ZhumuBiz(String cls, String date) {
		this.cls = cls;
		File zhumuDir = new File(zhumuHome);
		File[] files = zhumuDir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory() && pathname.getName().startsWith(date);
			}

		});
		String sMember = conf.getProperty(cls);
		if (sMember != null) {
			String[] sMembers = sMember.split("[\\s,;，；|]+");
			members.addAll(Arrays.asList(sMembers));
		}
		if (files.length == 0) {
			throw new RuntimeException("会议还没开始!");
		}
		zhumuDir = files[files.length - 1];
		zhumuFile = new File(zhumuDir, "meeting_saved_chat.txt");
	}

	public ZhumuBiz(String cls) {
		this(cls, Question.YMD.format(new Date()));
	}

	public Question start(String content) {
		String value = rand.nextInt(9) + 1 + "";
		return start(content, value);
	}

	public Question start(String content, String value) {
		if (question != null) {
			commit();
		}
		content += "\n已完成的请回复：" + value + "\n未完成的请回复：0";
		question = new Question(content, value, members);
		// 获取系统剪贴板
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// 封装文本内容
		Transferable trans = new StringSelection(
				"=========================\n" + content + "\n=========================");
		// 把文本内容设置到系统剪贴板
		clipboard.setContents(trans, null);
		return question;
	}

	public void cancel() {
		question = null;
	}

	public Question commit() {
		if (question == null) {
			return null;
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(zhumuFile);
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				question.add(line);
			}
			fis.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		// question.logs(true);
		qList.add(question);
		Question ret = question;
		question = null;
		return ret;
	}

	public static void addClass(String cls, String names) {
		addClass(cls, names.split("[\\s,;，；|]+"));
	}

	public static void addClass(String cls, String[] names) {
		HashSet<String> members = new LinkedHashSet<>();
		members.addAll(Arrays.asList(names));
		members.removeIf(new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t == null || t.matches("\\s*");
			}
		});
		String[] clss = getValues("clss", new String[0]);
		clss = Utils.add(clss, cls);
		setValues("clss", clss);
		setValues(cls, members.toArray(names));
		saveConf();
	}

	public static String getZhumuHome() {
		return zhumuHome;
	}

	public static void setZhumuHome(String zhumuHome) {
		ZhumuBiz.zhumuHome = zhumuHome;
	}

	public static void setValue(String key, String value) {
		conf.setProperty(key, value);
	}

	public static void setValues(String key, String... values) {
		conf.setProperty(key, String.join(",", values));
	}

	public static String getValue(String key, String defaultValue) {
		String value = conf.getProperty(key);
		return value == null ? defaultValue : value;
	}

	public static String[] getValues(String key, String[] defaultValues) {
		String value = conf.getProperty(key);
		return value == null ? defaultValues : value.split("[\\s,;，；|]+");
	}

	public static void saveConf() {
		FileOutputStream fos = null;
		try {
			File datafile = new File(zhumuHome, "zhumu.ini");
			if (datafile.exists() == false) {
				datafile.createNewFile();
			}
			fos = new FileOutputStream(datafile);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			conf.store(osw, "save config");
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void saveData() {
		commit();
		PrintStream ps = null;
		try {
			if (qList.size() == 0)
				return;
			File file = new File(zhumuHome, zhumuFile.getParentFile().getName() + ".txt");
			ps = new PrintStream(file);
			ps.println("=========================");
			ps.println(cls + "班: " + members);
			ps.println("=========================");
			for (Question q : qList) {
				q.logs(false, ps);
				ps.println("=========================\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null)
				ps.close();
		}
	}

}
