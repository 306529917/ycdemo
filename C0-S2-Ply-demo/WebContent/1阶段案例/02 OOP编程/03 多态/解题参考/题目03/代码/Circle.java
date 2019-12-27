public class Circle implements ShapePara {
	public double radius;
	private double x;
	protected double y;

	Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public int getArea() {
		double area = Math.PI * Math.pow(radius, 2);
		return (int) area;
	}

	@Override
	public int getCircumference() {
		double ference = Math.PI * 2 * radius;
		return (int) ference;
	}
}