public class Juxx extends Shape {
	double[] bianchang = new double[4];

	Juxx() {
	}

	Juxx(double a, double b, double c, double d) {
		bianchang[0] = a;
		bianchang[1] = b;
		bianchang[2] = c;
		bianchang[3] = d;
	}

	public void zhouchang() {
		if (getBian() == 4 && bianchang[0] == bianchang[2] && bianchang[1] == bianchang[3]) {
			double sum = 0;
			for (int i = 0; i < bianchang.length; i++) {
				sum += bianchang[i];
				System.out.print(" 边长" + (i + 1) + "是" + bianchang[i]);
			}
			System.out.println(" 矩形的周长是：" + sum);
		} else {
			System.out.println("这不是一个矩形");
		}
	}
}