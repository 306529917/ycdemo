import java.util.Scanner;

public class D {
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
//��Ŀ����дһ������������nΪż��ʱ�����ú�����1/2+1/4+...+1/n,������nΪ����ʱ�����ú��� 
//1/1+1/3+...+1/n
