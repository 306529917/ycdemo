package com.yc.zhumu;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question {
	public final static SimpleDateFormat ZMD = new SimpleDateFormat("dd号aHH时会议");
	public final static SimpleDateFormat YMD = new SimpleDateFormat("yyyy-MM-dd ");
	public final static SimpleDateFormat MS = new SimpleDateFormat("mm:ss");
	public final static SimpleDateFormat HMS = new SimpleDateFormat("[HH:mm:ss]");
	public final static SimpleDateFormat YMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat YMDHMS1 = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
	private static Pattern pLine = Pattern.compile("(\\S+)\\s+(.+) : (.+)");
	private Date beginTime = new Date();
	private String sToday = YMD.format(beginTime);
	private String content;
	private String answerValue;
	private List<String> answers = new ArrayList<>();
	private HashSet<String> members = new LinkedHashSet<>();
	private HashSet<String> corrects = new LinkedHashSet<>();
	private HashSet<String> errors = new LinkedHashSet<>();

	public Question(String content, String answerValue, Collection<String> members) {
		this.content = content;
		this.answerValue = answerValue;
		this.members.addAll(members);
	}

	public Question(String content, String answerValue, String... names) {
		this(content, answerValue, Arrays.asList(names));
	}

	public void add(String line) {
		Matcher m = pLine.matcher(line);
		if (m.find()) {
			String time = m.group(1);
			time = sToday + time;
			try {
				if (YMDHMS.parse(time).getTime() > beginTime.getTime()) {
					String name = m.group(2);
					String value = m.group(3);
					name = name.replaceAll("[^\\u4E00-\\u9FA5]", "");
					value = value.trim();
					add(name, value);
				}
			} catch (ParseException e) {
				System.out.println("解析错误:" + line);
				throw new RuntimeException(e);
			}
		}
	}

	public void add(String name, String value) {
		answers.add(name + " : " + value);
		if (value.matches(answerValue + "+.?")) {
			corrects.add(name);
			errors.remove(name);
		} else if (value.matches("0+.?")) {
			errors.add(name);
			corrects.remove(name);
		} else if (corrects.contains(name) == false){
			errors.add(name);
		}
	}

	public void logs() {
		logs(false);
	}

	public void logs(boolean isShowLog) {
		logs(isShowLog, System.out);
	}

	public void logs(boolean isShowLog, PrintStream out) {
		Set<?> is = getInactions();
		Set<?> os = getOthers();
		out.println(content);
		out.println();
		// out.printf("全部(%3d): %s\n", members.size(), members);
		out.printf("完成(%3d): %s\n", corrects.size(), corrects);
		out.printf("未完(%3d): %s\n", errors.size(), errors);
		out.printf("挂机(%3d): %s\n", is.size(), is);
		out.printf("访客(%3d): %s\n", os.size(), os);
		if (isShowLog) {
			out.printf("日志(%3d): %s\n", answers.size(), answers);
		}
	}

	public Date getDate() {
		return beginTime;
	}

	public String getsToday() {
		return sToday;
	}

	public String getContent() {
		return content;
	}

	public String getAnswerValue() {
		return answerValue;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public HashSet<String> getMembers() {
		return members;
	}

	public HashSet<String> getCorrects() {
		return corrects;
	}

	public HashSet<String> getErrors() {
		return errors;
	}

	public HashSet<String> getInactions() {
		HashSet<String> ret = new LinkedHashSet<>();
		ret.addAll(members);
		ret.removeAll(corrects);
		ret.removeAll(errors);
		return ret;
	}

	public HashSet<String> getOthers() {
		HashSet<String> ret = new LinkedHashSet<>();
		ret.addAll(corrects);
		ret.addAll(errors);
		ret.removeAll(members);
		return ret;
	}

	public void setBeginTime(String sDate) {
		try {
			beginTime = YMDHMS.parse(sDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
