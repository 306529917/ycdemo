import java.util.Scanner;

public class A {
	private static int[] arrs;
	private static int[] pIaces;
	private static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);
		System.out.print("输入N:");
		int n = s.nextInt();
		System.out.print("输入M:");
		int k = s.nextInt();
		System.out.println("请依次输入要处理的数:");
		arrs = new int[n + k];
		for (int a = 0; a < n; a++) {

			arrs[a] = s.nextInt();
		}
		System.out.print("这是已往后移了");
		System.out.print(k);
		System.out.print("位的数：");
		pIaces = new int[n + k];
		for (int j = 0; j < n; j++) {
			pIaces[j] = arrs[(j + k) % n];
			System.out.print(pIaces[j]);
			System.out.print(" ");
		}
	}
}