public class Test {
	public static void main(String[] args) {
		Faculty a = new Faculty();
		a.setName("张三");
		a.setTelphone("123456788");
		a.setDegree("本科");
		a.setLevel("一级");
		a.setEmail("12345877@qq.com");
		System.out.println("员工姓名：" + a.getName() + " 电话" + a.getTelphone() + " 学位" + a.getDegree() + " 级别"
				+ a.getLevel() + " 邮箱" + a.getEmail());
		Employee b = new Employee();
		b.setName("张三");
		b.setTelphone("123456788");
		b.setEmail("12345877@qq.com");
		b.setOffice("A座407");
		b.setWage(20000);
		System.out.println("员工姓名：" + b.getName() + " 电话" + b.getTelphone() + " 邮箱" + a.getEmail() + " 办公室"
				+ b.getOffice() + " 工资" + b.getWage());
	}
}