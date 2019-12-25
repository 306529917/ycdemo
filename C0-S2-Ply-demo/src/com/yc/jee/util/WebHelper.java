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
	public static void buildHtmlByFiles(String jspcode, String path, String regex, PageContext page)
			throws IOException {
		File dir;
		if (path.startsWith("/")) {
			path = page.getServletContext().getRealPath(path);
			dir = new File(path);
		} else {
			HttpServletRequest req = (HttpServletRequest) page.getRequest();
			File pFile = new File(req.getServletContext().getRealPath(req.getServletPath())).getParentFile();
			dir = new File(pFile, path);
		}
		File[] files = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().matches(regex);
			}
		});
		Arrays.sort(files);
		if (files != null && files.length > 0) {
			for(File f : files) {
				page.getOut().print(StringUtils.replaceByEL(jspcode, "\\$\\{.+\\}", f));
			}
		}

	}

}
