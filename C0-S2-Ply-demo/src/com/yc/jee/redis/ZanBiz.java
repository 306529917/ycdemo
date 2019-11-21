package com.yc.jee.redis;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class ZanBiz {
	// 需要 commons-pool2 slf4j 支持
	private static JedisPool jp = new JedisPool();

	public void addZan(int userid, int friendid) {

		Jedis jedis = jp.getResource();
		try {
			// 添加点赞人
			long l = jedis.sadd("zan:" + userid, "" + friendid);
			if (l > 0) {
				// 添加点赞数
				jedis.zincrby("zanCnt:", 1, "" + userid);
			}
		} finally {
			jedis.close();
		}

	}

	public void delZan(int userid, int friendid) {

		Jedis jedis = jp.getResource();
		try {
			// 删除点赞人
			long l = jedis.srem("zan:" + userid, "" + friendid);
			if (l > 0) {
				// 点赞数减一
				jedis.zincrby("zanCnt:", -1, "" + userid);
			}
		} finally {
			jedis.close();
		}

	}

	public Set<String> getZan(int userid) {

		Jedis jedis = jp.getResource();
		try {
			return jedis.smembers("zan:" + userid);
		} finally {
			jedis.close();
		}

	}

	public long getZanCount(int userid) {
		Jedis jedis = jp.getResource();
		try {
			return jedis.scard("zan:" + userid);
		} finally {
			jedis.close();
		}
	}

	public long getZanCount1(int userid) {
		Jedis jedis = jp.getResource();
		try {
			return jedis.zscore("zanCnt:", "" + userid).longValue();
		} finally {
			jedis.close();
		}
	}

	public String[] getZanTop(int num) {
		Jedis jedis = jp.getResource();
		try {
			if (num > 0) {
				return jedis.zrevrange("zanCnt:", 0, num - 1).toArray(new String[0]);
			} else if (num < 0) {
				return jedis.zrange("zanCnt:", 0, num * -1).toArray(new String[0]);
			} else {
				return jedis.zrevrange("zanCnt:", 0, -1).toArray(new String[0]);
			}
		} finally {
			jedis.close();
		}
	}

	public static void main(String[] args) {
		int max = 100;
		ZanBiz zb = new ZanBiz();
		// 随机移除 n 个赞
		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= (int) (Math.random() * max); j++) {
				int r = (int) (Math.random() * max) + 1;
				if (r != i) {
					zb.addZan(i, r);
				}
			}
		}

		// 随机移除 n/2 个赞
		for (int i = 1; i <= max; i++) {
			for (int j = 1; j <= (int) (Math.random() * max / 2); j++) {
				zb.delZan(i, (int) (Math.random() * max) + 1);
			}
		}

		System.out.println("============== 点赞 ================");
		for (int i = 1; i <= max; i++) {
			System.out.println("user " + i + ": " + zb.getZan(i));
		}

		System.out.println("============== 排名前十 ================");
		String[] users = zb.getZanTop(10);
		int i = 1;
		for (String userid : users) {
			long c = zb.getZanCount(Integer.parseInt(userid));
			long c1 = zb.getZanCount1(Integer.parseInt(userid));
			System.out.println(i++ + " ==> " + userid + " : " + c + " : " + c1);
		}

		System.out.println("============== 排名后十 ================");
		users = zb.getZanTop(-10);
		i = 1;
		for (String userid : users) {
			long c = zb.getZanCount(Integer.parseInt(userid));
			long c1 = zb.getZanCount1(Integer.parseInt(userid));
			System.out.println(i++ + " ==> " + userid + " : " + c + " : " + c1);
		}

		System.out.println("============== 全部排名 ================");
		users = zb.getZanTop(0);
		i = 1;
		for (String userid : users) {
			long c = zb.getZanCount(Integer.parseInt(userid));
			long c1 = zb.getZanCount1(Integer.parseInt(userid));
			System.out.println(i++ + " ==> " + userid + " : " + c + " : " + c1);
		}
	}

}
