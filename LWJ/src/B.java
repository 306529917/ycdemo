import java.util.Scanner;

public class B {
	public static Scanner s1;

	public static void main(String[] args) {
		int n, i, o, count = 0;
		s1 = new Scanner(System.in);
		int[] a = new int[10000];
		n = s1.nextInt();
		o = n;
		for (i = 0; i < n; i++) {
			a[i] = i + 1;
		}
		i = 0;
		while (n > 1) {
			if (a[i] != 0) {
				count++;
			}
			if (count == 3) {
				a[i] = 0;
				count = 0;
				n--;
			}
			i++;
			if (i == o) {
				i = 0;
			}
		}
		for (i = 0; i < o; i++) {
			if (a[i] != 0) {
				System.out.print(a[i]);
			}
		}
	}
}
/* 
��Ŀ����n����Χ��һȦ��˳���źš��ӵ�һ���˿�ʼ��������1��3��������������3�����˳�Ȧ�ӣ���������� 
����ԭ���ڼ��ŵ���λ�� 
*/
