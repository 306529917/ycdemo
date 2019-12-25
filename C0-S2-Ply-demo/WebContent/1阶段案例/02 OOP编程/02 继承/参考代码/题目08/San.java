public class San extends Shape {
	double[] bianchang = new double[3];

	San() {

	}

	San(double a, double b, double c) {
		bianchang[0] = a;
		bianchang[1] = b;
		bianchang[2] = c;
	}

	public void zhouchang() {
		if (getBian() == 3 && bianchang[0] + bianchang[1] > bianchang[2]
				&& bianchang[0] - bianchang[1] < bianchang[2]) {
			double sum = 0;
			for (int i = 0; i < bianchang.length; i++) {
				sum += bianchang[i];
				System.out.print(" 边长" + (i + 1) + "是" + bianchang[i]);
			}
			System.out.println(" 三角形的周长是：" + sum);
		} else {
			System.out.println("这不是一个三角形");
		}
	}
}