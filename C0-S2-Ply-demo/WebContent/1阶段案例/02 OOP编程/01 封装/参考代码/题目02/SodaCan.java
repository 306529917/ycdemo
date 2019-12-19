package 题目02;

/**
 * 圆柱体类
 */
public class SodaCan {
	// 常量
	public static final double PI = 3.14;
	// 高度
	private int height;
	// 半径
	private int radius;
	
	public SodaCan(int height, int radius) {
		super();
		this.height = height;
		this.radius = radius;
	}

	/**
	 * 返回圆柱体表面积
	 * @return
	 */
	public double getSurfaceArea() {
		// 上下面积 + 柱体面积
		return radius * radius * PI * 2 + radius * 2 * PI * height;
	}
	
	/**
	 * 返回体积
	 * @return
	 */
	public double getVolume() {
		// 圆面积 * 高度
		return radius * radius * PI * height;
	}

}
