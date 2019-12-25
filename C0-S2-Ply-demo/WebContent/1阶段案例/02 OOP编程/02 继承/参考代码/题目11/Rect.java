public class Rect {
	//声明属性
	private double width;
	private double height;

	//带参数构造方法
	public Rect(double width, double height) {
		this.width = width;
		this.height = height;
	}

	//无参的构造方法
	public Rect() {
		this.width = 10;
		this.height = 10;
	}

	//成员方法       周长
	public double perimeter() {
		double perimeter;
		perimeter = (width + height) * 2;
		return perimeter;
	}

	//成员方法      面积
	public double area() {
		double area;
		area = width * height;
		return area;
	}

	//getter/setter方法
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
}