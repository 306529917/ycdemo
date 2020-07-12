public class TestJidongche {

	public static void main(String[] args) {
		Jidongche a = new Jidongche();
		System.out.println("车a车牌是：" + a.gaichepai("辽A9752"));
		System.out.println("车a加速后速度：" + a.jiansu());
		System.out.println("a车信息：" + a.getChepai() + " " + a.getChesu() + " " + a.getZaizhong());
		Jidongche b = new Jidongche("辽B5086", 150, 200);
		System.out.println("b车信息：" + b.getChepai() + " " + b.getChesu() + " " + b.getZaizhong());
		System.out.println("车b减速后速度：" + b.jiansu());
	}

}