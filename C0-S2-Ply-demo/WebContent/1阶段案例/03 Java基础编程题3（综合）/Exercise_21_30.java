package com.yc.java.exercise;

import java.util.Scanner;

public class Exercise_21_30 {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * 题目：求1+2!+3!+...+20!的和 
	1.程序分析：此程序只是把累加变成了累乘。 
	 */
	public static void exer21() {
		long n, s = 0, t = 1;
		for (n = 1; n <= 20; n++) {
			t *= n;
			s += t;
		}
		System.out.println(s);
	}

	/**
	 * 【程序22】 
	题目：利用递归方法求5!。 
	1.程序分析：递归公式：fn=fn_1*4! 
	 */
	public static void exer22() {
		int x = 5;
		long rs = Fac(x);
		System.out.println("" + x + "! = " + rs);
	}

	public static long Fac(int x) { /* 阶乘算法 */
		if (x > 1)
			return (x * Fac(x - 1)); /* 递归 */
		else
			return 1;
	}

	/**
	 * 【程序23】 
	题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，
	他说比第3个人大2岁。问第三个人，又说比第2人大两岁。问第2个人，说比第一个人
	大两岁。最后问第一个人，他说是10岁。请问第五个人多大？ 
	1.程序分析：利用递归的方法，递归分为回推和递推两个阶段。要想知道第五个人岁数，
	需知道第四人的岁数，依次类推，推到第一人（10岁），再往回推。
	 */
	public static void exer23() {
		System.out.println(age(5));
	}

	public static int age(int n) {
		int c;
		if (n == 1)
			c = 10;
		else
			c = age(n - 1) + 2;
		return c;
	}

	/**
	 * 【程序24】 
	题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。 
	 */
	public static void exer24() {
		int a = 345; // 要判断的数
		int i = 0;
		for (i = 0; a != 0 && a < 10000; i++) {
			int b;
			b = a % 10;
			a = a / 10;
			System.out.print(b);
			i = (i++);
		}
		System.out.print("输入整数位数为" + i);
	}

	/**
	 * 【程序25】 
	题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
	 */
	public static void exer25() {
		int a = 12391;
		int b = 0, c = a;
		while (c > 0) {
			b = b * 10 + (c % 10);
			c = c / 10;
		}
		if (a == b) {
			System.out.println(a + "是回文数");
		} else
			System.out.println(a + "不是回文数");
	}

	/**
	 * 【程序26】 
	题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续 判断第二个字母。 
	1.程序分析：用情况语句比较好，如果第一个字母一样，则判断用情况语句或if语句判断第二个字母。
	 */
	public static void exer26() {

	}

	/**
	 * 题目：求100之内的素数
	 */
	public static void exer27() {

	}

	/**
	 * 【程序28】 
	题目：对10个数进行排序 
	1.程序分析：可以利用选择法，即从后9个比较过程中，选择一个最小的与第一个元素交换，
	下次类推，即用第二个元素与后8个进行比较，并进行交换。
	 */
	public static void exer28() {
		int[] arr = { 3, 2, 6, 1, 8, 3, 2, 9, 11, 55 };
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * 【程序29】 
	题目：求一个3*3矩阵对角线元素之和 
	1.程序分析：利用双重for循环控制输入二维数组，再将a[i][i]累加后输出。 
	 */
	public static void exer29() {
		int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j || (i + j) == 2) {
					sum += nums[i][j];
				}
			}
		}
		System.out.println(sum);

	}

	/**
	 * 【程序30】 
	题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。 
	1. 程序分析：首先判断此数是否大于最后一个数，然后再考虑插入中间的数的情况，
	插入后此元素之后的数，依次后移一个位置。 
	 */
	public static void exer30() {
		int[] arr = { 3, 5, 7, 9, 11, 13, 14, 16, 66, 88 }; // 原始数组
		int num = 8; // 要插入的数
		int[] result = new int[arr.length + 1];
		result[0] = num; // 把待插入元素放到
		for (int i = 0; i < arr.length; i++)
			result[i + 1] = arr[i];
		int temp;
		// 排序
		for (int i = 0; i < result.length - 1; i++) {
			if (result[i] > result[i + 1]) {
				temp = result[i];
				result[i] = result[i + 1];
				result[i + 1] = temp;
			}
		}
		// 输出
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static void main(String[] args) {
	}

}
