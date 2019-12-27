package com.yc.jee.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

public class WebHelper {

	public static void executeSqlAtJsp(String pathname, ServletContext application)
			throws UnsupportedEncodingException {
		executeSqlAtJsp(pathname, null, application);
	}

	public static void executeSqlAtJsp(String filename, HttpServletRequest request, ServletContext application)
			throws UnsupportedEncodingException {
		String path = filename;
		if (request != null && filename.startsWith("/") == false) {
			path = request.getServletPath();
			path = path.substring(0, path.lastIndexOf("/") + 1);
			path += filename;
		}
		path = URLDecoder.decode(path, "utf-8");
		path = application.getRealPath(path);
		DBHelper.executeByFile(path);
	}

	/**
	 * 遍历指定目录下的文件（正则表达式判断文件名），循环生成 jspcode
	 * 循环变量名是 file 循环变量的值就是遍历到的文件名
	 * @param htmlcode
	 * @param path
	 * @param regex
	 * @param page
	 * @throws IOException
	 */
	public static int buildHtmlByFiles(String html, String path, String regex, PageContext page) throws IOException {
		File dir = getRealFile(path, (HttpServletRequest) page.getRequest());
		File[] files = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().matches(regex);
			}
		});
		if (files != null && files.length > 0) {
			Arrays.sort(files);
			for (File f : files) {
				page.getOut().print(StringUtils.replaceByEL(html, "\\$\\{.+\\}", f));
			}
			return files.length;
		}
		return 0;
	}

	public static File getRealFile(String webpath, HttpServletRequest req) {
		File file;
		if (webpath.startsWith("/")) {
			webpath = req.getServletContext().getRealPath(webpath);
			file = new File(webpath);
		} else {
			File pFile = new File(req.getServletContext().getRealPath(req.getServletPath())).getParentFile();
			file = new File(pFile, webpath);
		}
		return file;
	}

}
