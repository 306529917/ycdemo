package com.yc.teach;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.LinkedHashSet;

import com.yc.util.Utils;

public class TeachBiz {

	private TeachInfo info;
	{
		load();
	}

	public void addCls(String name) {
		info.getClsMap().put(name, new LinkedHashSet<String>());
	}

	public void addApp(String name, String cmd) {
		info.getAppMap().put(name, cmd);
	}

	public void delApp(String name) {
		info.getAppMap().remove(name);
		info.getClsMap().values().stream().forEach(set -> set.remove(name));
	}

	public void addClassApp(String cls, String name) {
		info.getClsMap().get(cls).add(name);
	}

	public void delClassApp(String cls, String name) {
		info.getClsMap().get(cls).remove(name);
	}

	public void save() {
		Utils.tex(() -> new ObjectOutputStream(new FileOutputStream("teach.dat")), oos -> {
			oos.writeObject(info);
		});
	}

	public void load() {
		Utils.tex(() -> new ObjectInputStream(new FileInputStream("teach.dat")), ois -> {
			info = (TeachInfo) ois.readObject();
		}, e -> {
			e.printStackTrace();
			info = new TeachInfo();
		});
	}

}
