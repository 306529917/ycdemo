
public class People {
	protected double height;
	protected double weight;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void speakHello() {
		System.out.println("你好！！！");
	}

	public void averageHeight() {
		System.out.println("平均身高是：" + height);
	}

	public void averageWeight() {
		System.out.println("平均体重是：" + weight);
	}
}