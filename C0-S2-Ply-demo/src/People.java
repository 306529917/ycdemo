public class People extends Monkey {

	People(String s) {
		super(s);
	}

	//重写speak()方法
	public void speak() {
		System.out.println("小样的，不错嘛！会说话了！");
	}

	void think() {
		System.out.println("别说话！认真思考！");
	}
}