package com.yc.zhumu;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZhumuBiz {
	public static String zhumuHome = System.getProperty("user.home") + "/Documents/zhumu";
	public static String classHome = "D:\\文件柜";
	private static String cls;
	private static File clsDir;
	public static Timer classHomeTimer;
	public static File configFile = new File(zhumuHome, "zhumu.ini");
	private static Properties conf = new Properties();
	private Set<String> members = new LinkedHashSet<>();
	private Question question;
	private File reportFile;
	private File meetingFile;
	private File meetingDir;
	private Random rand = new Random();
	private long skipSize;

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
			System.out.println("配置文件：" + datafile);
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

	private void setCls(String cls) {
		ZhumuBiz.cls = cls;
		String sMember = conf.getProperty(cls);
		if (sMember != null) {
			members.clear();
			String[] sMembers = sMember.split("[\\s,;，；|]+");
			members.addAll(Arrays.asList(sMembers));
		}
	}

	public void ready() throws ZhumuException {
		if (cls == null) {
			throw new ZhumuException("请选择班级!");
		}
		if (meetingFile == null) {
			throw new ZhumuException("瞩目会议还未开始!");
		}
	}

	/**
	 * 	使用当天最新的一个会议目录
	 */
	public void init(String cls) throws ZhumuException {
		String sDate = Question.YMD.format(new Date());
		File homeDir = new File(zhumuHome);
		File[] files = homeDir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory() && pathname.getName().startsWith(sDate);
			}
		});
		if (files.length == 0) {
			throw new ZhumuException("会议还没开始!");
		}
		init(cls, files[files.length - 1]);
	}

	public void init(String cls, File file) throws ZhumuException {
		if (file == null || file.exists() == false) {
			throw new ZhumuException("会议还没开始!");
		}
		meetingDir = file;
		meetingFile = new File(meetingDir, "meeting_saved_chat.txt");
		skipSize = meetingFile.length();
		reportFile = new File(zhumuHome, meetingFile.getParentFile().getName() + ".txt");
		setCls(cls);
		// 创建班级上课目录
		clsDir = new File(classHome, cls);
		if (clsDir.exists()) {
			clsDir = new File(clsDir, Question.MD.format(new Date()));
			if (clsDir.exists() == false) {
				clsDir.mkdir();
			}
		}
	}

	public Question start(String content) throws ZhumuException {
		ready();
		String value = rand.nextInt(9) + 1 + "";
		return start(content, value);
	}

	public Question start(String content, String value) throws ZhumuException {
		ready();
		content = Question.HMS.format(new Date()) + " " + content;
		content += "\n已完成的请回复：" + value + "\n未完成的请回复：0\n不回复的算挂机：)";
		question = new Question(content, value, members);
		toClipboard("========================\n" + content + "\n========================");
		return question;
	}

	public void lookup(boolean isShowLog, PrintStream out) {
		if (question == null)
			return;
		question.logs(isShowLog, out);
	}

	public void commit() throws ZhumuException {
		if (question == null)
			return;
		ready();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(meetingFile);
			fis.skip(skipSize);
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				question.add(line);
			}
			fis.close();
			skipSize = meetingFile.length();
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

	public String export(int num) throws ZhumuException {
		ready();
		File[] reportFiles;
		if (num < 1) {
			reportFiles = new File[] { reportFile };
		} else {
			reportFiles = new File(zhumuHome).listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (pathname.equals(reportFile) || pathname.isDirectory()
							|| pathname.getName().endsWith(".txt") == false) {
						return false;
					}
					String topLine = Utils.readLine(pathname, 1);
					return topLine.matches(cls + "班.+");
				}
			});
			Arrays.sort(reportFiles, (a, b) -> {
				return (int) (b.lastModified() - a.lastModified());
			});
		}

		CharArrayWriter sb = new CharArrayWriter();
		PrintWriter pw = new PrintWriter(sb);
		String line = null;
		String names[] = { "完成", "未完", "挂机", "访客" };
		Pattern cp = Pattern.compile("完成.+?:\\s+\\[(.+)\\]");
		Pattern ep = Pattern.compile("未完.+?:\\s+\\[(.+)\\]");
		Pattern op = Pattern.compile("挂机.+?:\\s+\\[(.+)\\]");
		Pattern gp = Pattern.compile("访客.+?:\\s+\\[(.+)\\]");
		Pattern ps[] = { cp, ep, op, gp };
		@SuppressWarnings("unchecked")
		TreeMap<String, Integer>[] tms = new TreeMap[] { new TreeMap<>(), new TreeMap<>(), new TreeMap<>(),
				new TreeMap<>() };

		for (int j = 0; j < reportFiles.length && (num < 1 || j < num); j++) {
			System.out.println("分析文件: " + reportFiles[j].getName());
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(reportFiles[j]));
				while ((line = br.readLine()) != null) {
					for (int i = 0; i < ps.length; i++) {
						Matcher m = ps[i].matcher(line);
						if (m.find()) {
							String sMember = m.group(1);
							String members[] = sMember.split("[\\s,;，；|]+");
							TreeMap<String, Integer> tm = tms[i];
							for (String member : members) {
								if (this.members.contains(member)) {
									Integer cnt = tm.get(member);
									cnt = cnt == null ? 1 : (cnt + 1);
									tm.put(member, cnt);
								}
							}
							break;
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		pw.println("========================");
		for (int i = 0; i < names.length; i++) {
			pw.printf(names[i] + "统计(共%d人):\n", tms[i].size());
			// 对 value 排序
			List<Entry<String, Integer>> list = new ArrayList<>(tms[i].entrySet());
			Collections.sort(list, new Comparator<Entry<String, Integer>>() {
				// 升序排序
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
			});
			for (Entry<String, Integer> e : list) {
				pw.printf("%s:\t%d\n", e.getKey(), e.getValue());
			}
			pw.println("========================");
		}
		return sb.toString();
	}

	public static void addClass(String cls, String names) {
		addClass(cls, names.split("[\\s,;，；|]+"));
	}

	public static void addClass(String cls, String[] names) {
		Set<String> members = new LinkedHashSet<>();
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
		if (value == null) {
			conf.setProperty(key, defaultValue);
			return defaultValue;
		} else {
			return value;
		}
	}

	public static String[] getValues(String key, String[] defaultValues) {
		String value = conf.getProperty(key);
		if (value == null) {
			conf.setProperty(key, String.join(",", defaultValues));
			return defaultValues;
		} else {
			return value.split("[\\s,;，；|]+");
		}
	}

	public static void saveConf() {
		FileOutputStream fos = null;
		try {

			if (configFile.exists() == false) {
				configFile.createNewFile();
			}
			fos = new FileOutputStream(configFile);
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

	public void saveData() throws ZhumuException {
		if (question == null)
			return;
		commit();
		PrintStream ps = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(reportFile, true);
			ps = new PrintStream(fos);
			if (reportFile.length() == 0) {
				ps.println("========================");
				ps.printf("%s班(共%d人): %s\n", cls, members.size(), members);
				ps.println("========================");
			}
			ps.println("\n========================");
			question.logs(false, ps);
			ps.println("========================");
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null)
				ps.close();
		}
	}

	public Set<String> getMembers() {
		return members;
	}

	public Question getQuestion() {
		return question;
	}

	public String getCls() {
		return cls;
	}

	public File getMeetingFile() {
		return meetingFile;
	}

	public File getMeetingDir() {
		return meetingDir;
	}

	public File getReportFile() {
		return reportFile;
	}

	public String getMeetingName() {
		return cls + "班" + buildMeetingName(meetingDir.lastModified()) + "（" + getMembers().size() + "人）";
	}

	public static String buildMeetingName(long time) {
		Date date = new Date(time);
		String ret = Question.ZMD.format(date);
		String sh = ret.replaceAll("\\d{2}.{3}(\\d{2}).{3}", "$1");
		int h = Integer.valueOf(sh);
		if (h >= 18) {
			ret = ret.replaceAll("下午", "晚上");
		}
		return ret;
	}

	public static String getLastFilename() {
		File[] fs = ZhumuBiz.clsDir.listFiles();
		if (fs != null && fs.length > 0) {
			Arrays.sort(fs, (o1, o2) -> {
				return (int) (o1.lastModified() - o2.lastModified());
			});
			return fs[fs.length - 1].getName().replaceAll("(.+?)\\d*\\..+", "$1");
		}
		return null;
	}

	public static void toClipboard(String content) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// 封装文本内容
		Transferable trans = new StringSelection(content);
		// 把文本内容设置到系统剪贴板
		clipboard.setContents(trans, null);
	}

}
