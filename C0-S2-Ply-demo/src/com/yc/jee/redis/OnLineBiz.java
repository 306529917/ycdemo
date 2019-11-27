package com.yc.jee.redis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import redis.clients.jedis.BitOP;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class OnLineBiz {

	private static final String ON_LINE = "ON_LINE_";

	private static final String YYYYMMDD = "yyyyMMdd";

	private static final SimpleDateFormat DF = new SimpleDateFormat(YYYYMMDD);

	private JedisPool jp = new JedisPool();

	/**
	 * 添加用户当日的在线记录
	 * 
	 * @param userid
	 */
	public void online(long userid) {
		Jedis jedis = jp.getResource();
		try {
			jedis.setbit(getKey(), userid, true);
		} finally {
			jedis.close();
		}
	}

	/**
	 * 添加用户指定日期的在线记录
	 * 
	 * @param date
	 * @param userid
	 */
	public void online(Date date, long userid) {
		Jedis jedis = jp.getResource();
		try {
			jedis.setbit(getKey(date), userid, true);
		} finally {
			jedis.close();
		}
	}

	/**
	 * 返回连续在线人数
	 * 
	 * @param dates
	 * @return
	 */
	public long getSerialOnline(Date... dates) {
		Jedis jedis = jp.getResource();
		String[] srcKeys = new String[dates.length];
		for (int i = 0; i < dates.length; i++) {
			srcKeys[i] = getKey(dates[i]);
		}
		try {
			jedis.bitop(BitOP.AND, "ON_LINE_COUNT", srcKeys);
			return jedis.bitcount("ON_LINE_COUNT");
		} finally {
			jedis.close();
		}
	}
	
	/**
	 * 返回曾经在线人数
	 * 
	 * @param dates
	 * @return
	 */
	public long getOnceOnline(Date... dates) {
		Jedis jedis = jp.getResource();
		String[] srcKeys = new String[dates.length];
		for (int i = 0; i < dates.length; i++) {
			srcKeys[i] = getKey(dates[i]);
		}
		try {
			jedis.bitop(BitOP.OR, "ON_LINE_COUNT", srcKeys);
			return jedis.bitcount("ON_LINE_COUNT");
		} finally {
			jedis.close();
		}
	}

	/**
	 * 删除几天前的在线数据
	 * 
	 * @param days
	 */
	public void delOnlineByEarly(int days) {
		Jedis jedis = jp.getResource();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -days);
		try {
			long delNum;
			do {
				String key = getKey(c.getTime());
				c.add(Calendar.DAY_OF_MONTH, -1);
				delNum = jedis.del(key);
			} while (delNum > 0);
		} finally {
			jedis.close();
		}
	}

	/**
	 * 生成从今天开始,过去的连续几天的日期数组
	 * 
	 * @param num
	 * @return
	 */
	private static Date[] getDates(int num) {
		Date[] ret = new Date[num];
		Calendar c = Calendar.getInstance();
		for (int i = 0; i < num; i++) {
			ret[i] = c.getTime();
			c.add(Calendar.DAY_OF_MONTH, -1);
		}
		return ret;
	}

	private static String getKey() {
		return ON_LINE + DF.format(new Date());
	}

	private static String getKey(Date date) {
		return ON_LINE + DF.format(date);
	}

	public static void main(String[] args) {

		Date[] dates = getDates(7);

		OnLineBiz ob = new OnLineBiz();

		// 随机添加10天内100个用户上线的记录
		for (int i = 0; i < dates.length; i++) {
			for (int j = 0; j < 100; j++) {
				if (Math.random() * 2 > 1) {
					ob.online(dates[i], j);
				}
			}
		}

		// 删除7天前的上线记录
		// ob.delOnlineByEarly(3);
		System.out.print("连续上线人数: ");
		System.out.println(ob.getSerialOnline(dates));
		System.out.print("上线过的人数: ");
		System.out.println(ob.getOnceOnline(dates));
		
		System.out.print("连续上线用户列表: ");

	}

}
