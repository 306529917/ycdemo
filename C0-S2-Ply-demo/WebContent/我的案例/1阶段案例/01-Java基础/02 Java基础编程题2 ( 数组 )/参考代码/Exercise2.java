package com.yc.java.exercise;

// 随机类，用于生成随机数
import java.util.Random;

/**
 * Java 基础练习题2（数组）
 */
public class Exercise2 {
	/**
	 * 定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，然后求出所有元素
	的最大值，最小值，平均值，和值，并输出出来。(Arrays - > sort)
	 */
	public static void exer01() {
		Random r = new Random();
		int[] x = new int[10];
		int sum = 0, avg = 0, max, min;
		for (int i = 0; i < x.length; i++) {
			x[i] = r.nextInt(10000);
			System.out.print(x[i] + "  ");
			sum += x[i];
		}
		min = max = x[0];
		for (int i = 0; i < x.length; i++) {
			if (max < x[i]) {
				max = x[i];
			}
			if (min > x[i]) {
				min = x[i];
			}
		}
		avg = sum / x.length;
		System.out.println("最大值:" + max + "\t最小值:" + min + "\t平均值:" + avg + "\t和:" + sum);
	}

	/**
	 * 定义一个int型的一维数组，包含10个元素，分别赋值为1~10， 然后将数组中的元素
	都向前移一个位置，即，a[0]=a[1],a[1]=a[2],…最后一个元素的值是原来第一个元素
	的值，然后输出这个数组。
	 */
	public static void exer02() {
		int[] x = new int[10];
		for (int i = 0; i < x.length; i++) {
			x[i] = i + 1;
		}
		int temp = x[0];
		for (int i = 0; i < x.length - 1; i++) {
			x[i] = x[i + 1];
		}
		x[x.length - 1] = temp;
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + "  ");
		}
	}

	/**
	 * 定义一个int型的一维数组，包含40个元素，用来存储每个学员的成绩，
	 * 循环产生40个 0~100之间的随机整数，将它们存储到一维数组中，然后
	 * 统计成绩低于平均分的学员的人数，并输出出来。
	 */
	public static void exer03() {
		int[] x = new int[40];
		Random r = new Random();
		int total = 0;
		int avg = 0;
		for (int i = 0; i < x.length; i++) {
			x[i] = r.nextInt(100);
			total += x[i];
		}
		avg = total / x.length;
		int count = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] < avg) {
				count++;
			}
		}
		System.out.println("统计人数:" + count);
	}

	/**
	 * （选做）承上题，将这40个成绩按照从高到低的顺序输出出来。
	 */
	public static void exer04() {
		int[] x = new int[40];
		Random r = new Random();
		for (int i = 0; i < x.length; i++) {
			x[i] = r.nextInt(100);
		}
		int temp = 0;
		for (int i = 0; i < x.length - 1; i++) {
			for (int j = i + 1; j < x.length; j++) {
				if (x[i] < x[j]) {
					temp = x[j];
					x[j] = x[i];
					x[i] = temp;
				}
			}
		}
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}

	/**
	 * （选做）编写程序，将一个数组中的元素倒排过来。例如原数组为1，2，3，4，5；
	则倒排后数组中的值为5，4，3，2，1。
	 */
	public static void exer05() {
		int[] x = { 1, 2, 3, 4, 5 };
		for (int i = x.length - 1; i >= 0; i--) {
			System.out.print(x[i] + "  ");
		}
	}

	/**
	 * 定义一个20*5的二维数组，用来存储某班级20位学员的5门课的成绩；这5门课
	按存储顺序依次为：core C++，coreJava，Servlet，JSP和EJB。
	（1）循环给二维数组的每一个元素赋0~100之间的随机整数。
	（2）按照列表的方式输出这些学员的每门课程的成绩。
	（3）要求编写程序求每个学员的总分，将其保留在另外一个一维数组中。
	（4）要求编写程序求所有学员的某门课程的平均分。
	 */
	public static void exer06() {
		int[][] score = new int[20][5];
		Random r = new Random();
		long sum = 0;
		int[] total = new int[20];
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				score[i][j] = r.nextInt(100);
				sum += score[i][j];
				System.out.print(score[i][j] + " ");
				total[i] += score[i][j];
			}
			System.out.println();
			System.out.println("第" + (i + 1) + "个学员的总成绩:" + total[i]);
			System.out.println("第" + (i + 1) + "个学员的平均成绩:" + total[i] / 5);
		}
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
	}

}
