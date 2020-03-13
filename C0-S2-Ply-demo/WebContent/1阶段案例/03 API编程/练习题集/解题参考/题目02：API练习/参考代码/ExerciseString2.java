package com.yc.api.d0228;

import java.util.Arrays;

public class ExerciseString2 {
	public static void main(String[] args) {
		ExerciseString2 es2 = new ExerciseString2();
		System.out.println(es2.getISP("11170466360"));
		System.out.println(es2.getISP("112"));
		System.out.println(es2.getISP("17704663602"));
		es2.parseId("431102199710093011");
		es2.checkJunkMail("欢迎来购买我们家的减肥产品有优惠,充值会员，购买保险，欢迎致电1001");
	}

	/**
		手机号码前三位代表运营商
	中国电信	2G/3G号段：133，153， 180，181，189
			4G号段：173， 177
	中国联通	2G/3G号段：130，131，132，155，156，185，186
			3G上网卡：145
			4G号段：176，185
	中国移动	2G/3G号段：134，135，136，137，138，139，150，151，152，158，159，182，183，184
			3G上网卡：147
			4G号段：178，184
	请根据传入的电话号码, 返回对应的运营商的名称
	*/
	public String getISP(String phoneNumber) {
		if (phoneNumber.length() != 11) {
			return "输入错误";
		}
		String[] p1 = { "133", "153", "180", "181", "189", "173", "177" };
		String[] p2 = { "130", "131", "132", "155", "156", "185", "186", "145", "176" };
		String[] p3 = { "134", "135", "136", "137", "138", "139", "150", "151", "152", "158", "159", "182", "183",
				"184", "147", "178" };
		Arrays.sort(p1);
		Arrays.sort(p2);
		Arrays.sort(p3);
		String prefix = phoneNumber.substring(0, 3);
		int index1 = Arrays.binarySearch(p1, prefix);// 方式内部实现用的是二分法查找，所以在查找前需要将数组进行排序
		int index2 = Arrays.binarySearch(p2, prefix);
		int index3 = Arrays.binarySearch(p3, prefix);

		if (index1 > 0) {

			if ((prefix.equals("173")) || (prefix.equals("177"))) {

				return "中国电信4G";

			} else {
				return "中国电信2G/3G";
			}

		}
		if (index2 > 0) {
			return "中国联动??";
		}
		if (index3 > 0) {
			return "中国移动";
		}
		return "查询错误";

	}

	/**
	身份证号码规则：
		前1、2位数字表示：所在省份的代码；
		第3、4位数字表示：所在城市的代码；
		第5、6位数字表示：所在区县的代码；
		第7-14位数字表示：出生年、月、日；
		第15、16位数字表示：所在地的派出所的代码；
		第17位数字表示性别：奇数表示男性，偶数表示女性；
		第18位数字是校检码
	任意给出一个身份证号码，在控制台输所有的出个人信息，
		日期格式：xxxx年xx月xx日
		性别：显示男，女
		其他代码：显示原值
	*/
	public void parseId(String cardNo) {
		if (cardNo.length() != 18) {
			System.out.println("输入错误");
			return;
		}

		// 需求：身份证号码，地区号+生日：年+月+日+性别

		String area = ""; // 前6位，国家标准（国标GB）
		// 截串，身份证18位，固有长度
		area = cardNo.substring(0, 6);
		System.out.println("区域编码：" + area);

		String birthday = "";
		birthday = cardNo.substring(6, 14);

		int year; // 从中间变量birthday来截取
		year = Integer.parseInt(birthday.substring(0, 4)); // 字符串转成整数
		int month;
		month = Integer.parseInt(birthday.substring(4, 6));
		int day;
		day = Integer.parseInt(birthday.substring(6));
		System.out.println("生日：" + year + "年" + month + "月" + day + "日");

		// 倒数第二位
		String sex = "";
		sex = cardNo.substring(cardNo.length() - 2, cardNo.length() - 1);
		if (sex.equals("1")) {
			System.out.println("性别:" + "男");

		} else {
			System.out.println("性别:" + "女");

		}
	}

	/**
		研究网络上垃圾邮件的信息和词，请将经常在垃圾邮件中看到的30个词创建成一个列表。写一个方法，用户输入email信息，
		扫描这些词是否出现在这个邮件中，只要在信息中出现一次这些单词，就给这个词记一分，根据最后的得分，给这个邮件记一个等级，
		返回该邮件的等级
	 * @param email
	 */
	public void checkJunkMail(String email) {
		String[] rubbish = { "最优价格", "购买", "马上买", "便宜", "折扣", "优惠", "限量订购大吃一惊", "致电", "点击", "增加竞争力", "获取电邮地址", "增加你的销量",
				"营销", "会员", "每月试用优惠", "自愿参加", "订阅", "不敢置信合理价格", "大笔金钱", "账单", "现金红利", "索赔", "成本", "信用机构", "赚钱", "隐藏费用",
				"收入", "保险", "投资", "贷款" };
		int count = 0;
		for (int i = 0; i < rubbish.length; i++) {

			String b = rubbish[i];
			if (email.contains(b)) {
				count++;
			}
		}
		System.out.println(count);
		if (count > 0 && count < 5) {
			System.out.println("轻度");
		}
		if (count >= 5 && count < 10) {
			System.out.println("严重");
		}
		if (count >= 10) {
			System.out.println("非常严重");
		}

	}

}
