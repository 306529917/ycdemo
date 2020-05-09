public class Test {
	public static void main(String[] args) {
		// 第一个矩形对象
		Rect rect1 = new Rect();
		rect1.setWidth(5);
		rect1.setHeight(8);
		rect1.getArea();
		// 第二个矩形对象
		Rect rect2 = new Rect(7, 9);
		rect2.getArea();
	}
}
