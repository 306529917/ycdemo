public class TestChongZai {

	public static void main(String[] args) {
		ChongZai chongzai = new ChongZai();
		System.out.println("最大值是：" + chongzai.Max(3, 5));
		System.out.println("最大值是：" + chongzai.Max(3.0, 5.3));
		System.out.println("最大值是：" + chongzai.Max(3.6, 5.4, 8.9));
		chongzai.Min(5, 9);
		chongzai.Min(7.56, 4.56);
		chongzai.Min(1.234, 2.342, 7.3212);
	}

}