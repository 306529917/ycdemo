public class TestClock {
	public static void main(String[] args) {
		Clock a = new Clock(3, 24, 45);
		Clock b = new Clock(10, 12, 46);
		Clock c = new Clock(12, 60, 247);
		a.show();
		b.show();
		c.show();
	}
}