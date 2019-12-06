package com.yc.java.exercise;

import java.util.Scanner;

public class Exercise_11_20 {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * 【程序11】 
	题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？ 
	1.程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去 掉不满足条件的排列。 
	 */
	public static void exer11() {
		int i, j, k, n = 0;
		for (i = 1; i < 5; i++)
			for (j = 1; j < 5; j++)
				for (k = 1; k < 5; k++) {
					if (i != k && i != j && j != k) {
						n++;
						System.out.println(i * 100 + j * 10 + k);
					}
				}
		System.out.println(n + "个");
	}

	/**
	 * 【程序12】 
	题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；
	利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，
	可可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；40万到60万之
	间时高于40万元的部分，可提成3%；60万到100万之间时，高于60万元的部分，可提
	成1.5%，高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润I，
	求应发放奖金总数？ 
	1.程序分析：请利用数轴来分界，定位。注意定义时需把奖金定义成长整型。
	 */
	public static void exer12() {
		double x = 123455; // 利润
		double bonus = 0; // 奖金

		if (x >= 0 && x <= 100000)
			bonus = x * 0.1;
		else if (x <= 200000)
			bonus = 10000 + (x - 100000) * 0.075;
		else if (x <= 400000)
			bonus = 17500 + (x - 200000) * 0.05;
		else if (x <= 600000)
			bonus = 27500 + (x - 400000) * 0.03;
		else if (x <= 1000000)
			bonus = 33500 + (x - 600000) * 0.015;
		else if (x > 1000000)
			bonus = 39500 + (x - 1000000) * 0.01;

		System.out.println(bonus);
	}

	/**
	 * 【程序13】 
	题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？ 
	1.程序分析：在10万以内判断，先将该数加上100后再开方，再将该数加上268后再开方，如果开方后
	的结果满足 如下条件，即是结果。请看具体分析：
	 */
	public static void exer13() {
		int i;
		double j, k;
		for (i = 1; i <= 10000; i++) {
			j = (int) Math.sqrt(i + 100);
			k = (int) Math.sqrt(i + 268);
			if (j * j == i + 100 && k * k == i + 268)
				System.out.println(i);
		}
	}

	/**
	 * 【程序14】 
	题目：输入某年某月某日，判断这一天是这一年的第几天？ 
	1.程序分析：以3月5日为例，应该先把前两个月的加起来，然后再加上5天即本年的第几天，
	特殊情况，闰年且输入月份大于3时需考虑多加一天。
	 */
	public static void exer14() {
		int year = 2020; // 年
		int month = 4; // 月
		int day = 3; // 日
		int sum = 0;

		int leap = 0; // 闰年为1, 平年为0

		switch (month) {
		case 1:
			sum = 0;
			break;
		case 2:
			sum = 31;
			break;
		case 3:
			sum = 59;
			break;
		case 4:
			sum = 90;
			break;
		case 5:
			sum = 120;
			break;
		case 6:
			sum = 151;
			break;
		case 7:
			sum = 181;
			break;
		case 8:
			sum = 212;
			break;
		case 9:
			sum = 243;
			break;
		case 10:
			sum = 273;
			break;
		case 11:
			sum = 304;
			break;
		case 12:
			sum = 334;
			break;
		default:
			System.out.println("输入日期错误，请检查!\n");
			break;
		}
		sum = sum + day;
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			leap = 1;
		else
			leap = 0;
		if (leap == 1 && month > 2)
			;
		sum++;
		System.out.println("此日期是全年的第" + sum + "天");
	}

	/**
	 * 【程序15】 
	题目：输入三个整数x,y,z，请把这三个数由小到大输出。 
	1.程序分析：我们想办法把最小的数放到x上，先将x与y进行比较，如果x>y则将x与y的值进行交换，
	然后再用x 与z进行比较，如果x>z则将x与z的值进行交换，这样能使x最小。
	 */
	public static void exer15() {
		int x = 7, y = 2, z = 5, leap;

		if (x > y) {
			leap = x;
			x = y;
			y = leap;
		}
		if (x > z) {
			leap = x;
			x = z;
			z = leap;
		}
		if (y > z) {
			leap = y;
			y = z;
			z = leap;
		}
		System.out.print(x + " " + y + " " + z);
	}

	/**
	 * 【程序16】 
	题目：输出9*9口诀。 
	1.程序分析：分行与列考虑，共9行9列，i控制行，j控制列。
	 */
	public static void exer16() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print(i + "*" + j + "=" + (i * j) + "\t");
			System.out.println("\n");
		}
	}

	/**
	 * 【程序17】 
	题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个 
	第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一
	半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。 
	1.程序分析：采取逆向思维的方法，从后往前推断。
	 */
	public static void exer17() {
		int day, x1 = 0, x2;
		day = 9; // 从第九天开始算
		x2 = 1; // 第九天结束时，只有一个桃子了
		while (day > 0) {
			x1 = (x2 + 1) * 2;/* 第一天的桃子数是第2天桃子数加1后的2倍 */
			x2 = x1;
			day--;
		}
		System.out.println("第一天有:" + x1 + "个桃子");
	}

	/**
	 * 【程序18】 
	题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。
	有人向 队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。 
	 */
	public static void exer18() {
		char a, b, c;
		for (a = 'x'; a <= 'z'; a++)
			for (b = 'x'; b <= 'z'; b++) {
				for (c = 'x'; c <= 'z'; c++) {
					if (a != c && b != c && a != b) {
						if (a != 'x' && c != 'x' && c != 'z')
							System.out.println(a + " " + b + " " + c);

					}
				}
			}
	}

	/**
	 * 【程序19】 
	题目：打印出如下图案（菱形） 
	     * 
	   	*** 
	  ****** 
	 ******** 
	  ****** 
	   *** 
	    * 
	1.程序分析：先把图形分成两部分来看待，前四行一个规律，后三行一个规律，
	利用双重 for循环，第一层控制行，第二层控制列。
	 */
	public static void exer19() {
		int i, j, k; // i控制行数 j控制空格数 k控制星号数
		int M = 4; // 夌形的上半部分的高度
		for (i = 0; i <= M; i++)/* 上半部分的行数 */
		{
			for (j = 0; j <= M - 1 - i; j++)
				/* 打印空格的个数，我是以0开始的 */
				System.out.print(" ");
			for (k = 0; k <= 2 * i; k++) {
				/* 假如除去空格外都打印“*”，则以2*i+1打印"*"个数，这是每一行的特点 */
				System.out.print("*");
			}
			System.out.print("\n");
		}
		for (i = 0; i <= (M - 1); i++)/* 下半部分比上班部分少一行 */
		{
			for (j = 0; j <= i; j++)
				System.out.print(" ");
			for (k = 0; k <= 2 * (M - 1) - 2 * i; k++) {
				/* 判断k时没有合并式子，仅供学习探究，这点判断很重要，
				 留作你自己思考了
				 */
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

	/**
	 * 【程序20】 
	题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。 
	1.程序分析：请抓住分子与分母的变化规律。 
	 */
	public static void exer20() {
		int i, x, y, a;
		float sum = 0;
		x = 2;
		y = 1;
		for (i = 1; i < 20; i++) {
			sum += (float) (x) / y;
			a = x;
			x = x + y;
			y = a;
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
	}

}
