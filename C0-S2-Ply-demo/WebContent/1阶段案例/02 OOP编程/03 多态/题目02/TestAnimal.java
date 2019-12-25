public class TestAnimal {
	public static void main(String[] args) {
		Animal a = new Fish();
		a.setName("Tom");
		a.setZhonglei("动物");
		a.getInfo();
		a.eat();
		a.sleep();
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
		Animal aa = (Dog) d;
		aa.eat();
		aa.sleep();
	}
}