public class Test {
	public static void main(String[] args) {
		ChangFangTi a = new ChangFangTi();
		a.setChang(12);
		a.setKuan(10);
		a.setGao(5);
		System.out.println("长方体的底面积是：" + a.area());
		System.out.println("长方体的体积是：" + a.tiji());
	}
}