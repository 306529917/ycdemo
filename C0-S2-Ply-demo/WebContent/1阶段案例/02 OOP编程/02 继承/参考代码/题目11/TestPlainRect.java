public class TestPlainRect {

	public static void main(String[] args) {
		//创建矩形
		PlainRect rect = new PlainRect(10, 10, 20, 10);
		//打印输出
		System.out.println("长为20，宽为10的矩形的面积是：" + rect.area());
		System.out.println("长为20，宽为10的矩形的周长是：" + rect.perimeter());
		if (rect.isInside(25.5, 13) == true) {
			System.out.println("点(25.5，13)在矩形内");
		} else {
			System.out.println("点(25.5，13)不在矩形内");
		}
	}

}