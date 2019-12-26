
//  继承Person类
public class Employee extends Person {
	private String ID = "";
	private double wage = 0;
	private int age = 0;

	public Employee(String name, String address, String ID, double wage, int age) {
		super(name, address); //调用父类的构造方法
		this.ID = ID;
		this.wage = wage;
		this.age = age;
	}

	/**
	 * 加工资 
	 */
	public double add() {
		wage = wage * 1.1;
		return wage;
	}

	//设置get/set方法
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}