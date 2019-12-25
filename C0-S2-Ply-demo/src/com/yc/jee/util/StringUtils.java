package com.yc.jee.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * 替换EL表达式的值，从 vo 中获取表达式的值
	 * @param str
	 * @param regex
	 * @param vo
	 * @return
	 */
	public static String replaceByEL(String str, String regex, Object vo) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		int index = 0;
		StringBuilder sb = new StringBuilder();
		while (m.find(index)) {
			sb.append(str.substring(index, m.start()));
			String el = m.group();
			el = el.replaceAll("^\\s*\\$\\s*\\{\\s*", "");
			el = el.replaceAll("\\s*\\}\\s*$", "");
			sb.append(BeanUtils.getValue(vo, el));
			index = m.end();
		}
		return index > 0 ? sb.toString() + str.substring(index) : str;
	}

}
