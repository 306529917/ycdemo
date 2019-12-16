package com.yc.java.exercise;

import java.util.Scanner;

/**
 * Java 基础练习题1
 */
@SuppressWarnings("resource")
public class Exercise1 {
	/**
	 * 给定3个数a,b和c,输出最大的数。
	 */
	public static void exer01() {
		int a = 3, b = 5, c = 1;

		// 解法一：if 语句判断
		int max;
		if (a > b) {
			max = a;
		} else {
			max = b;
		}
		
		if (max < c) {
			max = c;
		}
		
		System.out.println("最大值:" + max);

		// 解法二：条件运算符（三元表达式）判断
		max = a > b ? a : b;
		max = max > c ? max : c;
		System.out.println("最大值:" + max);
	}

	/**
	 * 某电信公司的市内通话费计算标准如下：
	  三分钟内0.2元，三分钟后每增加一分钟增加0.1元，不足一分钟的按一分钟计算。
	  要求编写程序，给定一个通话时间（单位：秒），计算出应收费金额。
	 */
	public static void exer02() {
		// Scanner 是 java 的屏幕录入类，用于从屏幕录入数据
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个通话时间：（单位：秒）");
		int val = input.nextInt();
		double sum = 0;
		if (val <= 180)
			sum = 0.2;
		else if (val % 60 == 0) {
			sum = 0.2 + ((val - 180) / 60) * 0.1;
		} else {
			sum = 0.2 + ((val - 180) / 60 + 1) * 0.1;
		}
		System.out.println("该通话时长的消费金额为：" + sum);
	}

	/**
	 * 某市的出租车计费标准为：3公里以内10元，3公里以后每加0.5公里加收1元；每等待
	 *2.5分钟加收1元；超过15公里的加收原价的50%为空驶费。要求编写程序，对于任意
	 *给定的里程数（单位：公里）和等待时间（单位：秒）计算出应付车费，车费直接截去小
	 *数位，只取整数。
	 */
	public static void exer03() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入行驶里程数:");
		double miles = input.nextDouble();
		System.out.println("请输入等待时间:");
		int waitime = input.nextInt();
		double total = 0;
		if (miles < 3) {
			total += 10;
		} else {
			total += 10 + (miles - 3) / 0.5;
		}
		total += waitime / 150;

		if (miles > 15) {
			total += total * 0.5;
		}
		System.out.println("车费为:" + (int) total);
	}

	/**
	 * 编写程序，判断给定的某个年份是否是闰年。
	  闰年的判断规则如下：
	  （1）若某个年份能被4整除但不能被100整除，则是闰年。
	  （2）若某个年份能被400整除，则也是闰年。
	 */
	public static void exer04() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入年份:");
		// if 判断是这么写的
		int year = input.nextInt();
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			System.out.println(year + "是闰年");
		} else {
			System.out.println(year + "不是闰年");
		}
		// 条件运算符（三元表达式）是这么写的
		String is = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ? "是" : "不是";
		System.out.println(year + is + "闰年");
	}

	/**
	 * 给定一个百分制的分数，输出相应的等级。
	  90分以上     		 A级
	  80~89          B级
	  70~79          C级
	  60~69          D级
	  60分以下    		 E级
	 */
	public static void exer05() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入分数:");
		int score = input.nextInt();
		if (score >= 90) {
			System.out.println("A级");
		} else if (score >= 80) {
			System.out.println("B级");
		} else if (score >= 70) {
			System.out.println("C级");
		} else if (score >= 60) {
			System.out.println("D级");
		} else {
			System.out.println("E级");
		}
	}

	/**
	 * 编写程序求 1+3+5+7+……+99 的和值。
	 */
	public static void exer06() {
		int sum = 0;
		for (int i = 1; i < 100; i++) {
			if (i % 2 != 1) {
				continue;
			}
			sum += i;
		}
		System.out.println("和为:" + sum);
	}

	/**
	 * 编写程序输出1-100之间所有能被7整除的偶数。
	 */
	public static void exer07() {
		for (int i = 1; i < 100; i++) {
			if (i % 7 == 0 && i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	/**
	 * 求所有满足如下条件的四位数：
	  千位上的数字大于百位数字，百位数字大于十位数字，十位数字大于个位数字，并
	  且千位数字是其他三位数字的和。
	 */
	public static void exer08() {
		int qian = 0, bai = 0, shi = 0, ge = 0;
		for (int i = 1000; i <= 9999; i++) {
			qian = i / 1000;
			bai = i % 1000 / 100;
			shi = i % 100 / 10;
			ge = i % 10;
			if (qian > bai && bai > shi && shi > ge && qian == (bai + shi + ge)) {
				System.out.println(i);
			}
		}
	}

	/**
	 * 给定两个任意的正整数,求它们之间的所有完全平方数，完全平方数是指这个数是 
	  某个整数的平方，例如 16，25，36等都是完全平方数。
	 */
	public static void exer09() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入A:");
		int a = input.nextInt();
		System.out.println("请输入B:");
		int b = input.nextInt();
		int n;
		for (; a < b; a++) {
			n = (int) Math.sqrt(a);
			if (n * n == a) {
				System.out.println(a + "的完全平方数:" + (a * a));
			}
		}
	}

	/**
	 * 编写程序求下列多项式的前50项的和：
	    1-1/3+1/5-1/7+1/9-…… 
	 */
	public static void exer10() {
		double sum = 0;
		double x = 1;
		double y = x;
		int count = 1;
		for (int i = 1; i <= 50; i++) {
			if (count % 2 == 0) {
				sum -= x / y;
			} else {
				sum += x / y;
			}
			y += 2;
			count++;
		}
		System.out.println(sum);
	}

	/**
	 * 请编写程序输出九九乘法表。
	 */
	public static void exer11() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + (i * j) + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * 编写程序输出1-100之间的所有素数。
	 */
	public static void exer12() {
		for (int a = 2; a <= 100; a++) {
			int k = a / 2; // 该数的一半
			int i = 2; // 从2开始
			boolean isPrime = true;// 素数标记
			for (; i <= k; i++) {// 判断是否素数
				if (a % i == 0)
					isPrime = false; // 不是素数
			}
			if (isPrime) // 输出
				System.out.println(a + " is  prime");
			else
				System.out.println(a + " is not  prime");
		}
	}

	/**
	 * 在屏幕上输出一个n行的金字塔图案，例如，若n=5,则图案如下： 
	 */
	public static void exer13() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个值:");
		int n = input.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int z = 1; z <= (i * 2) - 1; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	/**
	 * 求斐波那契数列前n项的和值,斐波那契数列如下： 
	   1，1，2，3，5，8，13，21……
	 前两位数是1，从第三位开始每位数都是前两位数之和 
	 */
	public static void exer14() {
		int num1 = 1, num2 = 1;
		int num = num1 + num2;
		System.out.print("  " + num1 + "  " + num2 + "  " + num);
		for (int i = 3; i < 20; i++) {
			int num3 = num + num2;
			num2 = num;
			num = num3;
			System.out.print("  " + num3);

		}
	}

	/**
	 * 给定一个整数，把它的各位数字倒排过来形成一个新的整数
	例如：给定12345   输出54321  ；给定 9870  输出789
	 */
	public static void exer15() {
		long src = 123456;
		long rs = 0;
		do {
			rs = rs * 10 + src % 10;
			src /= 10;
		} while (src > 0);
		System.out.println(rs);
	}

	public static void main(String[] args) {
		/**
		 * 在这里统一运行练习题方法
		 */
		System.out.println("\n======== 第01题 ========");
		exer01();
		System.out.println("\n======== 第02题 ========");
		exer02();
		System.out.println("\n======== 第03题 ========");
		exer03();
		System.out.println("\n======== 第04题 ========");
		exer04();
		System.out.println("\n======== 第05题 ========");
		exer05();
		System.out.println("\n======== 第06题 ========");
		exer06();
		System.out.println("\n======== 第07题 ========");
		exer07();
		System.out.println("\n======== 第08题 ========");
		exer08();
		System.out.println("\n======== 第09题 ========");
		exer09();
		System.out.println("\n======== 第10题 ========");
		exer10();
		System.out.println("\n======== 第11题 ========");
		exer11();
		System.out.println("\n======== 第12题 ========");
		exer12();
		System.out.println("\n======== 第13题 ========");
		exer13();
		System.out.println("\n======== 第14题 ========");
		exer14();
		System.out.println("\n======== 第15题 ========");
		exer15();
	}

}
