public class Man extends Human {
	public void man() {
		if (getSex() == "男人") {
			System.out.println("I am a man.");
		} else {
			System.out.println("I am not a man.");
		}
	}

	public void run() {
		System.out.println("我是雄狮一样强壮的男人.");
	}
}