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
������48��  
��Ŀ��ĳ����˾���ù��õ绰�������ݣ���������λ���������ڴ��ݹ������Ǽ��ܵģ����ܹ������£�ÿλ���� 
������5,Ȼ���úͳ���10��������������֣��ٽ���һλ�͵���λ�������ڶ�λ�͵���λ������ 
*/