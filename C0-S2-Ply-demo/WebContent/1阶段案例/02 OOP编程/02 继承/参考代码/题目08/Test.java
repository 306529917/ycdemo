public class Test {
	public static void main(String[] args) {
		Fish f = new Fish();
		Tiger t = new Tiger();
		SouthEastTiger s = new SouthEastTiger();
		System.out.println("鱼有" + f.getFishCount() + "条");
		System.out.println("老虎有" + t.getTigerCount() + "只");
		System.out.println("东北虎有" + s.getTigerCount() + "只");
	}
}