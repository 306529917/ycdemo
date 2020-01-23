import java.util.Scanner;

public class F {
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
/*
[程序45] <--
题目：判断一个素数能被几个9整除 
*/