
public class Test {
	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		Parrot parrot = new Parrot();
		Octopus octopus = new Octopus();

		cat.setColor('黄');
		System.out.println("猫有" + cat.getNumber() + "只腿");
		cat.eat();
		cat.catchmouse();

		cat.setColor('黑');
		System.out.println("狗有" + dog.getNumber() + "只腿");
		dog.eat();
		dog.lookhome();

		parrot.setColor('红');
		System.out.println("鹦鹉有" + parrot.getNumber() + "只腿");
		parrot.eat();
		parrot.talk();
		
		octopus.setColor('灰');
		System.out.println("章鱼有" + octopus.getNumber() + "只腿");
		octopus.eat();
		octopus.swimming();
	}
}
