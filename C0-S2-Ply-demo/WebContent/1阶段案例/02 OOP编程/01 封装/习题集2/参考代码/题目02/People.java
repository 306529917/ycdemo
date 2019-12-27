public class People {
	private String name;
	private int age;
	private String sex;
	private double height;

	public void shuohua() {
		System.out.println(name + "说" + "你好！");
	}

	People() {

	}

	People(String name, int age, String sex, double height) {
		setName(name);
		setAge(age);
		setSex(sex);
		setHeight(height);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int jisuan(int a, int b) {
		return a + b;
	}

	public String gaiName(String name) {
		setName(name);
		return getName();
	}
}