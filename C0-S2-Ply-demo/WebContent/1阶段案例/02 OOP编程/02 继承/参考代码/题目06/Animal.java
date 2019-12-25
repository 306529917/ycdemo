
public class Animal {
	private String zhonglei;
	private String name;

	public String getZhonglei() {
		return zhonglei;
	}

	public void setZhonglei(String zhonglei) {
		this.zhonglei = zhonglei;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println("我需要觅食！");
	}

	public void sleep() {
		System.out.println("我需要睡觉！");
	}

	public void getInfo() {
		System.out.println("我的名字是：" + getName() + " 我的种类是：" + getZhonglei());
	}
}