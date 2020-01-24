import java.util.Scanner;

public class Exercise_31_40 {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * ������31�� 
	��Ŀ����һ��������������� 
	1.����������õ�һ�������һ��������
	 */
	public static void exer31() {
		int[] a = { 7, 3, 4, 8, 1 };
		int s = a.length - 1;
		while (s >= 0) {
			System.out.println(a[s]);
			s--;
		}
	}

	/**
	 * ������32�� 
	��Ŀ��ȡһ������a���Ҷ˿�ʼ��4��7λ�� 
	��������������������ǣ� 
	(1)��ʹa����4λ�� 
	(2)����һ����4λȫΪ1,����ȫΪ0����������~(~0<<4) 
	(3)��������߽���&���㡣 
	 */
	public static void exer32() {
	}

	/**
	 * ������33�� 
	��Ŀ����ӡ����������Σ�Ҫ���ӡ��10������ͼ�� 
	1.��������� 
	        1 
	       1 1 
	     1 2 1 
	    1 3 3 1 
	   1 4 6 4 1 
	 1 5 10 10 5 1
	 */
	public static void exer33() {
		int a = 10;
		int b[][];
		b = new int[a][];
		for (int i = 1; i <= 10; i++) {
			b[i - 1] = new int[i];
		}
		for (int j = 0; j < 10; j++) {
			for (int k = 0; k <= j; k++) {
				if (j == 0 || k == 0 || k == j)// ��֧
				{
					b[j][k] = 1;// ����1��
					continue;
				} else {
					b[j][k] = b[j - 1][k - 1] + b[j - 1][k];// ����ֵ
				}
			}
		}
		for (int m = 0; m < 10; m++) {
			for (int n = 0; n <= m; n++) {
				System.out.print(b[m][n] + " ");// ѭ�����
			}
			System.out.println(" ");
		}
	}

	/**
	 * ������34�� 
	��Ŀ������3����a,b,c������С˳������� 
	1.�������������ָ�뷽���� 
	 */
	public static void exer34() {
		int a = 345; // Ҫ�жϵ���
		int i = 0;
		for (i = 0; a != 0 && a < 10000; i++) {
			int b;
			b = a % 10;
			a = a / 10;
			System.out.print(b);
			i = (i++);
		}
		System.out.print("��������λ��Ϊ" + i);
	}

	/**
	 * ������35�� 
	��Ŀ���������飬�������һ��Ԫ�ؽ�������С�������һ��Ԫ�ؽ�����������顣 
	 */
	public static void exer35() {
		int arr[] = { 4, 3, 8, 22, 76 };

		int num = arr.length;

		int max = arr[0];
		int min = arr[0];
		int index1 = 0;
		int index2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				index1 = i;
			}
			if (arr[i] < min) {
				min = arr[i];
				index2 = i;
			}
		}
		if (index1 != 0) {
			int temp = arr[0];
			arr[0] = arr[index1];
			arr[index1] = temp;
		}
		if (index2 != num - 1) {
			int temp = arr[num - 1];
			arr[num - 1] = arr[index2];
			arr[index2] = temp;
		}
		System.out.print("����������Ϊ:");
		for (int i = 0; i < num; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * ������36�� 
	��Ŀ����n��������ʹ��ǰ�����˳�������m��λ�ã����m���������ǰ���m���� 
	 */
	public static void exer36() {
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

	/**
	 * ������37�� 
	��Ŀ����n����Χ��һȦ��˳���źš��ӵ�һ���˿�ʼ��������1��3��������������3�����˳�Ȧ�ӣ�
	��������µ���ԭ���ڼ��ŵ���λ�� 
	 */
	public static void exer37() {
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

	/**
	 * ������38�� 
	��Ŀ��дһ����������һ���ַ����ĳ��ȣ���main�����������ַ�����������䳤�ȡ�
	 */
	public static void exer38() {
		public static Scanner s;

		public static void main(String[] args) {
			s = new Scanner(System.in);
			String str = s.next();
			int x = str.length();
			System.out.print(x);
		}
	}

	/**
	 * ������39�� 
	��Ŀ����дһ������������nΪż��ʱ�����ú�����1/2+1/4+...+1/n,������nΪ����ʱ�����ú��� 
	1/1+1/3+...+1/n(����ָ�뺯��) 
	 */
	public static void exer39() {
		private static Scanner s;
		public static float jisuanjieguo(int z) {
			float i = 0;
			if (z % 2 == 0) {
				for (int q = z; q >= 2; q--) {
					i += (float) 1 / q;
					q--;
				}
			} else {
				for (int q = z; q >= 1; q--) {
					i += (float) 1 / q;
					q--;
				}
			}
			return i;
		}
		public static void main(String[] args) {
			s = new Scanner(System.in);
			int g = s.nextInt();
			System.out.print(jisuanjieguo(g));
		}
	}

	/**
	 * ������40�� 
	��Ŀ���ַ������� 
	 */
	public static void exer40() {
	}
		
	public static void main(String[] args) {
	}
		return;
}