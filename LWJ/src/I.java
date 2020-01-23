import java.util.Scanner;

public class I {
	public static boolean j(int x) {
		int y=(int) Math.sqrt(x);//计算平方根
		boolean e=true;
		for(int i=1;i<y;i++) {
			if(x%i==0) { 
				e=false;
			}
		}
		return e;
	}
	private static Scanner s;
	public static void main(String[] args) {
		s=new Scanner(System.in);
		int x=s.nextInt();
		for(int i=1;i<x;i++) {
			if(j(i)==true&&j(x-i)==true&&i!=1&&(x-i)!=1) {
				int o=x-i;
				System.out.print(i+" ");
				System.out.print(o);
				return;
			}
		}
	}
}
//题目：一个偶数总能表示为两个素数之和。 