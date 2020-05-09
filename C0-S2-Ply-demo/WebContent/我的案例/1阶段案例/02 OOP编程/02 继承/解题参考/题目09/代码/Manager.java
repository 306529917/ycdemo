
public class Manager extends Employee {
	// 必须重写父类的构造方法，否则编译报错
	public Manager(String name, String address, String ID, double wage, int age) {
		// 执行父类构造方法
		super(name, address, ID, wage, age);
	}

	/**
	 * 加工资 
	 */
	public double add() {
		//注意这里的写法的变化： wage 属性是私有的，通过属性方法进行设值和取值
		setWage(getWage() * 1.2);
		return getWage();
	}
}