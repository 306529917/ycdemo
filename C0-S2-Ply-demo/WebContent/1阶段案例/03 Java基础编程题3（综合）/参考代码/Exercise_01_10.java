import java.util.Scanner;

public class Exercise_01_10 {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * 【程序1】
	题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一 
	对兔子，假如兔子都不死，问每个月的兔子总数为多少？ 
	1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21.... 
	 */
	public static void exer01() {
		while (true) {
			int month;
			do {
				System.out.print("请输入月份：");
				month = scanner.nextInt();
			} while (month < 3);

			int index = 3;
			int num1 = 1, num2 = 1, sum = 0;
			while (index <= month) {
				sum = num1 + num2;
				num1 = num2;
				num2 = sum;
				index++;
			}
			System.out.println("本月兔子的个数为:" + sum * 2);
		}
	}

	/**
	 * 【程序2】 
	题目：判断101-200之间有多少个素数，并输出所有素数。 
	1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 
	则表明此数不是素数，反之是素数。
	用(int) Math.sqrt(n)求出循环上限 ， 比除2更高效
	*/
	public static boolean isPrime(int num) {
		int limit = (int) Math.sqrt(num);
		for (int i = 2; i <= limit; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return false;
	}

	/**
	 * 【程序3】 
	题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如： 
	153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。 
	1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。 
	 */
	public static void exer03() {

		for (int i = 100; i < 1000; i++) {
			int num = i;
			int rem;
			int sum = 0;
			do {
				rem = num % 10;
				sum += rem * rem * rem;
				num = num / 10;
			} while (num > 0);

			if (i == sum) {
				System.out.println("这是一个完美数：" + i);
			}
		}

	}

	/**
	 * 【程序4】 
	题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。 
	程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成： 
	(1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。 
	(2)如果n<>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。 
	(3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
	 */
	public static void exer04() {
		int n = 13;
		for (int i = 2; i <= n; i++) {
			while (n % i == 0 && n != i) {
				n /= i;
				System.out.print(i + "*");
			}
			if (n == i) {
				System.out.println(i);
				break;
			}
		}
	}

	/**
	 * 【程序5】 
	题目：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。 
	1.程序分析：(a>b)?a:b这是条件运算符的基本例子。
	 */
	public static void exer05(int score) {
		char ch = score >= 90 ? 'A' : (score >= 60 ? 'B' : 'C');
	}

	/**
	 * 【程序6】
	 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
	1.程序分析：利用辗除法。 
	 */
	public static void exer06() {
		int m = 44, n = 33;
		int oldm = m, oldn = n;

		int temp = 1;
		int yshu = 1; // 约数
		int bshu = m * n; // 倍数
		// 确保n是大数，而m是小数
		if (n < m) {
			temp = n;
			n = m;
			m = temp;
		}
		while (m != 0) {
			temp = n % m;
			n = m;
			m = temp;
		}
		yshu = n;
		bshu /= n;
		System.out.println(oldm + "和" + oldn + "的最大公约数为" + yshu);
		System.out.println(oldm + "和" + oldn + "的最小公倍数为" + bshu);
	}

	/**
	 * 【程序7】 
	题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。 
	1.程序分析：利用while语句,条件为输入的字符不为'\n'. 
	 */
	public static void exer07() {
		char[] chs = { 'a', 'b', 'c', '1', '4', ',', ' ' };
		int countNum = 0;// 统计数字的个数
		int countChar = 0;// 统计英文字母的个数
		int countSpace = 0;// 统计空格的个数
		int countOthers = 0;// 统计其它字符的个数

		for (int i = 0; i < chs.length; i++) {
			char c = chs[i];
			if (c >= '0' && (int) c <= '9') {
				countNum++;
			} else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				countChar++;
			} else if (c == ' ') {
				countSpace++;
			} else {
				countOthers++;
			}
		}

		System.out.println("数字个数:" + countNum);
		System.out.println("英文字母个数:" + countChar);
		System.out.println("空格个数:" + countSpace);
		System.out.println("其他字符个数:" + countOthers);
	}

	/**
	 * 【程序8】 
	题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
	例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
	1.程序分析：关键是计算出每一项的值。
	 */
	public static void exer08() {
		int a = 2; // 数字
		int times = 3; // 最多出现的次数
		int result = 0; // 结果

		int begin = 0;
		for (int j = 0; j < times; j++) {
			begin = 10 * begin + 1;
			result = begin * a + result;
		}
		System.out.println(result);
	}

	/**
	 * 【程序9】 
	题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程 找出1000以内的所有完数。
	 */
	public static void exer09() {
		int m, i, s;
		for (m = 2; m < 1000; m++) {
			s = 1;
			for (i = 2; i <= m / 2; i++) {
				if (m % i == 0)
					s = s + i;
			}
			if (s == m) {
				System.out.println(m + "是完数");
			}
		}
	}

	/**
	 * 【程序10】 
	题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；
	再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？ 
	 */
	public static void exer10() {
		float sn = 100.0f, hn = sn / 2;
		int n;
		for (n = 2; n <= 10; n++) {
			sn = sn + 2 * hn;/*第n次落地时共经过的米数*/
			hn = hn / 2; /*第n次反跳高度*/
		}
		System.out.println("总高度:" + sn);
		System.out.println("第10次的高度:" + hn);
	}
	
}
