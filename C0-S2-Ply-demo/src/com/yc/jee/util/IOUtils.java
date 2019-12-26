package com.yc.jee.util;

import java.io.File;

public class IOUtils {

	public static void close(AutoCloseable... cs) {
		for (AutoCloseable c : cs) {
			if (c != null)
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

	public static boolean rename(File file, String newname) {
		if(file.getName().equals(newname)) {
			return true;
		}
		File newfile = new File(file.getParentFile(), newname);
		if (newfile.exists() == false) {
			return file.renameTo(newfile);
		} else {
			return false;
		}
		// TODO 未完待续，如果减少目录，会出现问题
	}

}
