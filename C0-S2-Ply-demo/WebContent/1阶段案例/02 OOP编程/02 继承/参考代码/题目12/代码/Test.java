public class Test {
	public static void main(String[] args) {
		Aodi aodi = new Aodi();
		aodi.setJiage(500000);
		aodi.setXinghao("奥迪A6");
		System.out.println("奥迪车的型号是：" + aodi.getXinghao() + " 价格是：" + aodi.getJiage());
		System.out.println(aodi.drive());
		System.out.println("启动后的速度为：" + aodi.biansu());
		Benchi benchi = new Benchi();
		benchi.setJiage(800000);
		benchi.setXinghao("奔驰2000");
		System.out.println("奔驰车的型号是：" + benchi.getXinghao() + " 价格是：" + benchi.getJiage());
		System.out.println(benchi.drive());
		System.out.println("启动后的速度为：" + benchi.biansu());

	}
}