package com.yc.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zhumu {

	private Pattern p = Pattern.compile(".*?([\\u4E00-\\u9FA5]+).*? : .+");
	private Properties res = new Properties();
	private String home;

	public static void main(String[] args) throws IOException {
		Zhumu z = new Zhumu("C:\\Users\\Administrator\\Documents\\zhumu");
		z.show("阳晶任,舒泽让,易帆,吴宗术,张钰婷,任中兴,黄俊捷,张韬,湛雄,苏照熙,贺子超,李贵杰,金嘉慧,杨天烨,蒋卓航,龚毅,朱炅锋,张亚楠");
	}

	public Zhumu(String home) throws IOException {
		this.home = home;
		File file = new File(home + "/" + "res.dat");
		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			res.load(fis);
			fis.close();
		}
		process();
		FileOutputStream fos = new FileOutputStream(file);
		res.store(fos, "zhumu msg count");
	}

	public void process() throws IOException {
		process(new File(home));
	}

	public void process(File dir) throws IOException {
		String last = res.getProperty("last");
		if (dir.getName().matches("\\d{4}-\\d{2}-\\d{2}.+")) {
			if (last == null || isNew(last, dir.getName())) {
				res.setProperty("last", dir.getName());
			} else {
				return;
			}
		}
		System.out.println("处理:" + dir);
		for (File file : dir.listFiles()) {
			if (file.isDirectory()) {
				process(file);
			} else if (file.getName().endsWith(".txt")) {
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while ((line = br.readLine()) != null) {
					Matcher m = p.matcher(line);
					if (m.find()) {
						String name = m.group(1);
						String cnt = res.getProperty(name);
						int count = 0;
						if (cnt != null) {
							count = Integer.parseInt(cnt);
						}
						res.put(name, count + 1 + "");
					}
				}
				fis.close();
			}
		}
	}

	public void show(String... names) {
		A a = new A();
		if (names.length == 1) {
			names = names[0].split("[;,|\\s]+");
			if (names.length > 1) {
				show(names);
			} else {
				System.out.printf("%s\t%s\n", names[0], res.getProperty(names[0]));
				a.add(names[0], res.getProperty(names[0]));
			}
		} else if (names.length > 0) {
			for (String name : names) {
				System.out.printf("%s\t%s\n", name, res.getProperty(name));
				a.add(name, res.getProperty(name));
			}
		} else {
			for (Entry<?, ?> e : res.entrySet()) {
				if (e.getKey().equals("last") == false) {
					System.out.printf("%s\t%s\n", e.getKey(), e.getValue());
					a.add((String) e.getKey(), (String) e.getValue());
				}
			}
		}
		a.showGood(" , ");
		a.showBad(" , ");
	}

	private boolean isNew(String last, String name) {
		String s1 = last.substring(0, 19);
		String s2 = name.substring(0, 19);
		return s1.compareTo(s2) < 0;
	}

	class A {
		HashMap<String, Integer> stus = new HashMap<>();
		int avg = 0;
		int sum = 0;

		void add(String name, String count) {
			Integer c = 0;
			if (count != null) {
				c = Integer.parseInt(count);
			}
			stus.put(name, c);
			sum += c;
			avg = sum / stus.size();
		}

		void showGood(String sp) {
			System.out.println("平均分:" + avg);
			for (Entry<String, Integer> e : stus.entrySet()) {
				if (e.getValue() >= avg) {
					System.out.print(e.getKey() + sp);
				}
			}
			System.out.println();
			for (Entry<String, Integer> e : stus.entrySet()) {
				if (e.getValue() >= avg) {
					System.out.printf("%s ( %s )" + sp, e.getKey(), e.getValue());
				}
			}
			System.out.println();
		}

		void showBad(String sp) {
			for (Entry<String, Integer> e : stus.entrySet()) {
				if (e.getValue() < avg) {
					System.out.print(e.getKey() + sp);
				}
			}
			System.out.println();
			for (Entry<String, Integer> e : stus.entrySet()) {
				if (e.getValue() < avg) {
					System.out.printf("%s (%s)" + sp, e.getKey(), e.getValue());
				}
			}
		}

	}

}
