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

	public static boolean rename(File file, String prefix, int index, int length) {
		String newname = prefix + buildSN(index, length);
		if (file.getName().equals(newname)) {
			return true;
		}
		File newfile = new File(file.getParentFile(), newname);
		if (newfile.exists()) {
			if (rename(newfile, prefix, index + 1, length)) {
				return rename(file, prefix, index, length);
			} else {
				return false;
			}
		} else {
			return file.renameTo(newfile);
		}
	}

	private static String buildSN(int index, int length) {
		String numstr = "" + index;
		while (numstr.length() < length) {
			numstr = "0" + numstr;
		}
		return numstr;
	}

}
