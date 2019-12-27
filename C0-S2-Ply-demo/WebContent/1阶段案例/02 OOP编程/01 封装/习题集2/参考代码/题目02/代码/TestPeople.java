public class TestPeople {

	public static void main(String[] args) {
		People p = new People();
		People p2 = new People("王五", 18, "男", 1.56);
		p.setName("张三");
		p.setSex("男");
		p.setAge(18);
		p.setHeight(1.80);
		System.out.println("名叫" + p.getName() + "性别" + p.getSex() + "年龄" + p.getAge() + "岁" + "身高" + p.getHeight());
		p.shuohua();
		System.out.println("23+45=" + p.jisuan(23, 45));
		System.out.println("名字改为：" + p.gaiName("李四"));
		System.out.println("名叫" + p2.getName() + "性别" + p2.getSex() + "年龄" + p2.getAge() + "岁" + "身高" + p2.getHeight());
	}

}