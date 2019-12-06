package com.yc.java.exercise;

import java.util.Scanner;

public class Exercise_31_40 {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * 【程序31】 
	题目：将一个数组逆序输出。 
	1.程序分析：用第一个与最后一个交换。
	 */
	public static void exer31() {
		int[] a = { 7, 3, 4, 8, 1 };
		int s = a.length - 1;
		while (s >= 0) {
			System.out.println(a[s]);
			s--;
		}
	}

	/**
	 * 【程序32】 
	题目：取一个整数a从右端开始的4～7位。 
	程序分析：可以这样考虑： 
	(1)先使a右移4位。 
	(2)设置一个低4位全为1,其余全为0的数。可用~(~0<<4) 
	(3)将上面二者进行&运算。 
	 */
	public static void exer32() {
	}

	/**
	 * 【程序33】 
	题目：打印出杨辉三角形（要求打印出10行如下图） 
	1.程序分析： 
	        1 
	       1 1 
	     1 2 1 
	    1 3 3 1 
	   1 4 6 4 1 
	 1 5 10 10 5 1
	 */
	public static void exer33() {
		int a = 10;
		int b[][];
		b = new int[a][];
		for (int i = 1; i <= 10; i++) {
			b[i - 1] = new int[i];
		}
		for (int j = 0; j < 10; j++) {
			for (int k = 0; k <= j; k++) {
				if (j == 0 || k == 0 || k == j)// 分支
				{
					b[j][k] = 1;// 等于1的
					continue;
				} else {
					b[j][k] = b[j - 1][k - 1] + b[j - 1][k];// 计算值
				}
			}
		}
		for (int m = 0; m < 10; m++) {
			for (int n = 0; n <= m; n++) {
				System.out.print(b[m][n] + " ");// 循环输出
			}
			System.out.println(" ");
		}
	}

	/**
	 * 【程序34】 
	题目：输入3个数a,b,c，按大小顺序输出。 
	1.程序分析：利用指针方法。 
	 */
	public static void exer34() {
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
	 * 【程序35】 
	题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。 
	 */
	public static void exer35() {
		int arr[] = { 4, 3, 8, 22, 76 };

		int num = arr.length;

		int max = arr[0];
		int min = arr[0];
		int index1 = 0;
		int index2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				index1 = i;
			}
			if (arr[i] < min) {
				min = arr[i];
				index2 = i;
			}
		}
		if (index1 != 0) {
			int temp = arr[0];
			arr[0] = arr[index1];
			arr[index1] = temp;
		}
		if (index2 != num - 1) {
			int temp = arr[num - 1];
			arr[num - 1] = arr[index2];
			arr[index2] = temp;
		}
		System.out.print("交换后数组为:");
		for (int i = 0; i < num; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * 【程序36】 
	题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数 
	 */
	public static void exer36() {

	}

	/**
	 * 【程序37】 
	题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，
	问最后留下的是原来第几号的那位。 
	 */
	public static void exer37() {

	}

	/**
	 * 【程序38】 
	题目：写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。
	 */
	public static void exer38() {
	}

	/**
	 * 【程序39】 
	题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数 
	1/1+1/3+...+1/n(利用指针函数) 
	 */
	public static void exer39() {

	}

	/**
	 * 【程序40】 
	题目：字符串排序。 
	 */
	public static void exer40() {
	}

	public static void main(String[] args) {
	}

}
