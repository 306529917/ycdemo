import java.util.Scanner;

public class H {
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
/*
【程序48】  
题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：每位数字 
都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。 
*/