public class TestCircle {

	public static void main(String[] args) {
		Circle c = new Circle(3);
		System.out.println("半径为3的圆的面积是：" + c.getArea());
		System.out.println("半径为3的圆的周长是：" + c.getCircumference());
	}
}