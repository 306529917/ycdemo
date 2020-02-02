import java.util.Scanner;

import Exercise_41_50.Student;

public class Exercise_41_50 {

	private static Scanner s = new Scanner(System.in);

	/**
	 * 【程序41】 
	题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一 
	个扔入海中，拿走了一份。第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中 
	，拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？ 
	 */
	public void exer41() {
		for (int i = 1;; i++) {//原理是将i一个个试出来...
			int peach = i;
			if ((peach - 1) % 5 == 0) {
				peach = (peach - 1) / 5 * 4;
				if ((peach - 1) % 5 == 0) {
					peach = (peach - 1) / 5 * 4;
					if ((peach - 1) % 5 == 0) {
						peach = (peach - 1) / 5 * 4;
						if ((peach - 1) % 5 == 0) {
							peach = (peach - 1) / 5 * 4;
							if ((peach - 1) % 5 == 0) {
								System.out.print(i);
								break;
							}
						}
					}
				}
			}
		}
	}
	/**
	 * 【程序42】 
	题目：809*??=800*??+9*??+1 
	其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。求??代表的两位数，及809*??后的结果。 
	 */
	public static void exer42() {
		
	}

	/**
	 * 【程序43】 
	题目：求0—7所能组成的奇数个数。 
	 */
	public void exer43()
	{
			int count = 0;
			boolean y = true;
			for (int i = 0; i < 7777777; i++) {
				if (String.valueOf(i).contains("8") || String.valueOf(i).contains("9") || i % 2 == 0) {//如果数字中含有8,9且不为偶数,则为false
					y = false;
				}
				if (y)
					count++;
				y = true;//默认为true
			}
			System.out.println(count);//System.out.println为System.out.print的改良版，可自动换行(在输出完后!!!)
		}

	/**
	 * 【程序44】 
	题目：一个偶数总能表示为两个素数之和。
	 */
	public void exer44() {
		int n = s.nextInt();
		int a = 0;
		int b = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) { //isPrime:判断是否是素数,具体见下
				a = i;
			}
			for (int j = 2; j < n; j++) {
				if (isPrime(j)) {
					b = j;
					if (n == (a + b)) {
						System.out.println(n + "=" + a + "+" + b);
						return;
					}
				}

			}
		}
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n == 2) {
				return true;
			} else if (n % i == 0) {
				return false;
			}
		}
		return false;
	}

	/**
	 * 【程序45】 
	题目：判断一个素数能被几个9整除 
	 */
	public void exer45() {
		Scanner s = new Scanner(System.in);
		int i = s.nextInt(), num = 0;
		boolean x = true;
		while (x) { //while:true执行，flase不执行
			if (i % 9 == 0) {
				i = i / 9;
				num++;
				x = true;
			} else {
				x = false;
			}
			System.out.print(num);
		}
	}

	/**
	 * 【程序46】 
	题目：两个字符串连接程序 
	 */
	public void exer46() {
		String a, b, c;
		c = a + b;
		c = a.concat(b);
	}

	/**
	 * 【程序47】 
	题目：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的＊。 
	 */
	public void exer47(){
		for (int j = 0; j < 7; j++) {
			int x = s.nextInt();
			for (int i = 0; i < x; i++) {
				System.out.print("＊");
			}
			System.out.print("\n");
		}
	}

	/**
	 * 【程序48】 
	题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：
	每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。 
	 */
	public void exer48() {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int a = x % 10 + 5;
		int b = ((x - a) / 10) % 10 + 5;
		int c = ((x - a - b * 10) / 100) % 10 + 5;
		int d = ((x - a - b * 10 - c * 100) / 1000) % 10 + 5;//算出个，十，百，千...
		a = (a + b + c + d) % 10;//用和除以10的余数代替...
		b = (a + b + c + d) % 10;
		c = (a + b + c + d) % 10;
		d = (a + b + c + d) % 10;
		System.out.print(d + " ");//倒序输出
		System.out.print(c + " ");
		System.out.print(b + " ");
		System.out.print(a + " ");
	}

	/**
	 * 【程序49】 
	题目：计算字符串中子串出现的次数 
	 */
	public void exer49() {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		String str1 = s.next();
		int count = 0;
		int start = 0;
		while (str.indexOf(str1, start) >= 0 && start < str.length()) {
			count++;
			start = str.indexOf(str1, start) + str1.length();
		}
		System.out.println(str1 + "在" + str + "出现的次数为" + count);
	}

	/**
	 * 【程序50】 
	题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），计算 
	出平均成绩，况原有的数据和计算出的平均分数存放在磁盘文件"stud"中。 
	 */
	public void exer50() {
		Student[] stus = new Student[5];
		for(int i=0;i<5;i++) {
		stus[i].name = s.next();
		stus[i].sn   = s.next();
		stus[i].score1=s.nextInt();
		stus[i].score2=s.nextInt();
		stus[i].score3=s.nextInt();
		stus[i].pj=(stus[i].score1+stus[i].score2+stus[i].score3)/3;//算平均
		}
		for(int i=0;i<5;i++) {
			System.out.print("姓名:"+stus[i].name);
			System.out.print("学号:"+stus[i].sn);
			System.out.print("平均分:"+stus[i].pj);
		}
	}

	/**
	 * 学生类
	 */
	public class Student {
		String name;
		String sn;
		int score1;
		int score2;
		int score3;
		int pj;
	}

	public static void main(String[] args) {
		
	}
}