
public class Animal {
	/**
	 * 毛的颜色
	 */
	private char color;
	/**
	 * 腿的个数 默认是 4
	 */
	private int number = 4;
	
	/**
	 * 动物吃东西的方法
	 */
	public void eat() {
		System.out.println("呼哧呼哧！！！");
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public int getNumber() {
		return number;
	}

}
