import java.util.Scanner;

public class C {
	public static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);
		String str = s.next();
		int x = str.length();
		System.out.print(x);
	}
}
//题目：写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。