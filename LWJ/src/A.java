import java.util.Scanner;

public class A {
	private static int[] arrs;
	private static int[] pIaces;
	private static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);
		System.out.print("����N:");
		int n = s.nextInt();
		System.out.print("����M:");
		int k = s.nextInt();
		System.out.println("����������Ҫ�������:");
		arrs = new int[n + k];
		for (int a = 0; a < n; a++) {

			arrs[a] = s.nextInt();
		}
		System.out.print("��������������");
		System.out.print(k);
		System.out.print("λ������");
		pIaces = new int[n + k];
		for (int j = 0; j < n; j++) {
			pIaces[j] = arrs[(j + k) % n];
			System.out.print(pIaces[j]);
			System.out.print(" ");
		}
	}
}