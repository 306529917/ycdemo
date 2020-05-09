package 题目05;

/**
 * 
5、编写一个名为Box的类，含整型的height,width,length，
volume四个属性，要求在构造方法中将其初始化，
并定义一个计算体积的calcVolume方法和一个输出
体积的print方法，在main方法中进行调用。
 *
 */
public class BoxTest {

	public static void main(String[] args) {
		// 定义第一个 Box
		Box box1 = new Box(10, 6, 8);
		// 计算体积
		box1.calcVolume();
		// 打印体积
		box1.print();
		
		// 定义第一个 Box
		Box box2 = new Box(8, 16, 28);
		// 计算体积
		box2.calcVolume();
		// 打印体积
		box2.print();

	}

}
