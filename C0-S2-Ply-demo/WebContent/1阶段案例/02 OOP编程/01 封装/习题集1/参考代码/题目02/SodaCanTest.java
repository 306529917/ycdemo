package 题目02;

/**
2、实现一个SodaCan类，它有getSurfaceArea()和getVolume()
方法.在构造函数中，提供圆柱的高和半径.
*/
public class SodaCanTest {

	public static void main(String[] args) {

		// 定义第一个圆柱体
		SodaCan sc1 = new SodaCan(7, 10);
		// 定义第一个圆柱体
		SodaCan sc2 = new SodaCan(9, 5);
		// 定义第一个圆柱体
		SodaCan sc3 = new SodaCan(15, 20);

		System.out.println("第一个圆柱体面积：" + sc1.getSurfaceArea() + "，体积：" + sc1.getVolume());

		System.out.println("第二个圆柱体面积：" + sc2.getSurfaceArea() + "，体积：" + sc2.getVolume());

		System.out.println("第三个圆柱体面积：" + sc3.getSurfaceArea() + "，体积：" + sc3.getVolume());
	}

}
