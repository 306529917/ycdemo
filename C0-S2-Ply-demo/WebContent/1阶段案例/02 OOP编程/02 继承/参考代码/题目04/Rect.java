public class Rect extends Shape {
	private double width;
	private double height;

	Rect(double a, double b) {
		this.width = a;
		this.height = b;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void getArea() {
		System.out.println("面积是：" + (width * height));
	}
}