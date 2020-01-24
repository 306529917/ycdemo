import java.util.Scanner;

public class H {
	
private static Scanner scanner = new Scanner(System.in);

	/**
	 * 【程序41】 
	题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一 
	个扔入海中，拿走了一份。第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中 
	，拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？ 
	 */
	public static void exer41() {
		public static void main(String[] args) {
			for (int i = 1;; i++) {
				int	peach = i;
				if ((peach - 1) % 5 == 0) {
					peach = (peach - 1) / 5 * 4;
					if ((peach - 1) % 5 == 0) {
						peach = (peach - 1) / 5 * 4;
						if ((peach - 1) % 5 == 0) {
							peach = (peach - 1) / 5 * 4;
							if ((peach - 1) % 5 == 0) {
								peach = (peach - 1) / 5 * 4;
								if ((peach - 1) % 5 == 0) {
									System.out.println(i);
									break;
								}
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
		public static void main(String[] args) {
			int a = 0;
			int b = 8;
			a = a+(b) / 2+(b - 1) * b / 2+(b - 1) * b * b / 2+(b - 1) * b * b * b / 2+(b - 1) * b * b * b * b / 2+(b - 1) * b * b * b * b * b / 2+(b - 1) * b * b * b * b * b * b / 2;
			System.out.println(a);
		}
	}

	/**
	 * 【程序43】 
	题目：求0—7所能组成的奇数个数。 
	 */
	public static void exer43() {

	}

	/**
	 * 【程序44】 
	题目：一个偶数总能表示为两个素数之和。
	 */
	public static void exer44() {
		public static void main(String[] args) {
	        int n =  ((int)(Math.random() * 1000 + 1) * 2);
	        int a = 0;
	        int b = 0;
	        for (int i = 2; i < n; i++) {
	            if (isPrime(i)) {
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
	    public static boolean isPrime(int n) {
	        for (int i = 2; i <= Math.sqrt(n); i++) {
	            if (n == 2) {
	                return true;
	            } else if (n % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	}

	/**
	 * 【程序45】 
	题目：判断一个素数能被几个9整除 
	 */
	public static void exer45() {
		private static Scanner s;

		public static void main(String[] args) {
			s=new Scanner(System.in);
			int i=s.nextInt(),num=0;
			boolean x=true;
			while(x) {
				if(i%9==0) {
					i=i/9;
					num++;
					x=true;
				}else {
					x=false;
				}
			}
			System.out.print(num);
		}
	}

	/**
	 * 【程序46】 
	题目：两个字符串连接程序 
	 */
	public static void exer46() {

	}

	/**
	 * 【程序47】 
	题目：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的＊。 
	 */
	public static void exer47() {

	}

	/**
	 * 【程序48】 
	题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：
	每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。 
	 */
	public static void exer48() {
		private static Scanner s;
		public static void main(String[] args) {
			s=new Scanner(System.in);
			int x=s.nextInt();
			int a=x%10+5;
			int b=((x-a)/10)%10+5;
			int c=((x-a-b*10)/100)%10+5;
			int d=((x-a-b*10-c*100)/1000)%10+5;
			a=(a+b+c+d)%10;
			b=(a+b+c+d)%10;
			c=(a+b+c+d)%10;
			d=(a+b+c+d)%10;
			System.out.print(d+" ");
			System.out.print(c+" ");
			System.out.print(b+" ");
			System.out.print(a+" ");
		}
	}

	/**
	 * 【程序49】 
	题目：计算字符串中子串出现的次数 
	 */
	public static void exer49() {

	}

	/**
	 * 【程序50】 
	题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），计算 
	出平均成绩，况原有的数据和计算出的平均分数存放在磁盘文件"stud"中。 
	 */
	public static void exer50() {
	}

	public static void main(String[] args) {
	}
}