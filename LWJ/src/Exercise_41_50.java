import java.util.Scanner;

public class H {
	
private static Scanner scanner = new Scanner(System.in);

	/**
	 * ������41�� 
	��Ŀ����̲����һ�����ӣ���ֻ�������֡���һֻ���Ӱ��������ƾ�ݷ�Ϊ��ݣ�����һ������ֻ���ӰѶ��һ 
	�����뺣�У�������һ�ݡ��ڶ�ֻ���Ӱ�ʣ�µ�������ƽ���ֳ���ݣ��ֶ���һ������ͬ���Ѷ��һ�����뺣�� 
	��������һ�ݣ����������ġ�����ֻ���Ӷ����������ģ��ʺ�̲��ԭ�������ж��ٸ����ӣ� 
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
	 * ������42�� 
	��Ŀ��809*??=800*??+9*??+1 
	����??�������λ��,8*??�Ľ��Ϊ��λ����9*??�Ľ��Ϊ3λ������??�������λ������809*??��Ľ���� 
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
	 * ������43�� 
	��Ŀ����0��7������ɵ����������� 
	 */
	public static void exer43() {

	}

	/**
	 * ������44�� 
	��Ŀ��һ��ż�����ܱ�ʾΪ��������֮�͡�
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
	 * ������45�� 
	��Ŀ���ж�һ�������ܱ�����9���� 
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
	 * ������46�� 
	��Ŀ�������ַ������ӳ��� 
	 */
	public static void exer46() {

	}

	/**
	 * ������47�� 
	��Ŀ����ȡ7������1��50��������ֵ��ÿ��ȡһ��ֵ�������ӡ����ֵ�����ģ��� 
	 */
	public static void exer47() {

	}

	/**
	 * ������48�� 
	��Ŀ��ĳ����˾���ù��õ绰�������ݣ���������λ���������ڴ��ݹ������Ǽ��ܵģ����ܹ������£�
	ÿλ���ֶ�����5,Ȼ���úͳ���10��������������֣��ٽ���һλ�͵���λ�������ڶ�λ�͵���λ������ 
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
	 * ������49�� 
	��Ŀ�������ַ������Ӵ����ֵĴ��� 
	 */
	public static void exer49() {

	}

	/**
	 * ������50�� 
	��Ŀ�������ѧ����ÿ��ѧ����3�ſεĳɼ����Ӽ��������������ݣ�����ѧ���ţ����������ſγɼ��������� 
	��ƽ���ɼ�����ԭ�е����ݺͼ������ƽ����������ڴ����ļ�"stud"�С� 
	 */
	public static void exer50() {
	}

	public static void main(String[] args) {
	}
}