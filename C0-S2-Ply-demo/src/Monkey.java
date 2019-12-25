public class Monkey {
	private String name; //声明属性name
	//getter、setter方法

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//构造方法    
	Monkey(String s) {
		this.name = s;
	}

	//成员方法
	public void speak() {
		System.out.println("咿咿呀呀.........");
	}
}