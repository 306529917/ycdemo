package 题目05;

public class Box {

	// 高度
	private int height;
	// 宽度
	private int width;
	// 长度
	private int length;
	// 体积
	private int volume;

	/**
	 * 构造方法，初始化
	 * @param height
	 * @param width
	 * @param length
	 */
	public Box(int height, int width, int length) {
		this.height = height;
		this.width = width;
		this.length = length;
		this.volume = 0;
	}

	/**
	 * 计算体积
	 */
	public void calcVolume() {
		volume = height * width * length;
	}

	/**
	 * 打印体积
	 */
	public void print() {
		System.out.println("当前 Box 的高度：" + height + "，宽度：" + width + "，长度：" + length + "，体积：" + volume);
	}

}
