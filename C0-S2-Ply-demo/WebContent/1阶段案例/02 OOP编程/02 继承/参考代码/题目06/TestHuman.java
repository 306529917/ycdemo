public class TestHuman {
	public static void main(String[] agrs) {
		Man m = new Man();
		m.setName("Dave");
		m.setAge(28);
		m.setSex("男");
		m.getInfo();
		m.speak();
		m.run();
		m.man();
		//隐式转换
		//上转型对象
		Human h = new Woman();
		h.setName("Jude");
		h.setAge(58);
		h.setSex("女");
		h.speak();
		h.run();
		h.getInfo();
		if (h instanceof Woman) {
			Woman w = (Woman) h;
			w.woman();
		} else {
			System.out.println("类型不符！");
		}
	}
}