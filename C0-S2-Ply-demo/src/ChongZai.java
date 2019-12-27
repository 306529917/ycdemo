public class ChongZai {
	public int Max(int a, int b) {
		return (a >= b) ? a : b;
	}

	public double Max(double a, double b) {
		return (a >= b) ? a : b;
	}

	public double Max(double a, double b, double c) {
		return Max(Max(a, b), c);
	}

	public void Min(int a, int b) {
		int c = (a >= b) ? a : b;
		System.out.println(c);
	}

	public void Min(double a, double b) {
		double c = (a >= b) ? a : b;
		System.out.println(c);
	}

	public void Min(double a, double b, double c) {
		double sum = a + b + c;
		System.out.println(sum);
	}
}