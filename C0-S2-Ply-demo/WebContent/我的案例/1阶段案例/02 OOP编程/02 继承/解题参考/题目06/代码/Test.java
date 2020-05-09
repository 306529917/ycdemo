public class Test {
	public static void main(String[] args) {
		Monkey m = new Monkey("Toney");
		System.out.println("我是猴子" + m.getName());
		m.speak();
		People p = new People("Tom");
		System.out.println("我是人类" + p.getName());
		p.speak();
		p.think();
	}
}