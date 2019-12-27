
public class Test {

	public static void main(String[] args) {
		//  新建对象
		Employee normal = new Employee("武松", "清河", "123456", 1000, 2);
		Manager manager = new Manager("宋江", "郓城", "000000", 10000, 10);
		//  传入职位，Manager类型的对象没有add()方法，所以自动搜寻其父类，调用add()方法
		normal.add();
		manager.add();

		System.out.println("员工"+normal.getName()+"的工资:" + normal.getWage());
		System.out.println("经理"+manager.getName()+"的工资:" + manager.getWage());
	}
}