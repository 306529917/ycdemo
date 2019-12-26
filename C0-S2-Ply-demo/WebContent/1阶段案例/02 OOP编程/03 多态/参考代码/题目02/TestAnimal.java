public class TestAnimal {
	public static void main(String[] args) {
		// 父类指向子类对象
		Animal a = new Fish();
		a.setName("Tom");
		a.setZhonglei("动物");
		a.getInfo();
		a.eat();
		a.sleep();
		// 判断类型是否正确
		if (a instanceof Fish) {
			Fish f = (Fish) a;
			f.setZhonglei("鱼类");
			f.eat();
			f.getInfo();
		} else {
			System.out.println("类型不符！");
		}
		Dog d = new Dog();
		d.setName("哮天犬");
		d.setZhonglei("哺乳动物");
		d.getInfo();
		//  强制类型转换
		Animal aa = (Dog) d;
		aa.eat();
		aa.sleep();
	}
}