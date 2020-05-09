public class Jidongche {
	private String chepai;
	private int chesu;
	private double zaizhong;

	//构造方法 对属性赋值
	Jidongche() {
		chepai = "XX1234";
		chesu = 100;
		zaizhong = 100;
	}

	//构造方法带形参 将实例化对象的参数用setter方法传给属性
	Jidongche(String chepai, int chesu, double zaizhong) {
		setChepai(chepai);
		setChesu(chesu);
		setZaizhong(zaizhong);
	}

	//getter 、setter方法
	public String getChepai() {
		return chepai;
	}

	public void setChepai(String chepai) {
		this.chepai = chepai;
	}

	public int getChesu() {
		return chesu;
	}

	public void setChesu(int chesu) {
		this.chesu = chesu;
	}

	public double getZaizhong() {
		return zaizhong;
	}

	public void setZaizhong(double zaizhong) {
		this.zaizhong = zaizhong;
	}

	//成员方法 加速
	public int jiasu() {
		return chesu += 10;
	}

	//成员方法 减速
	public int jiansu() {
		if (chesu <= 0) {
			System.out.println("车停了!");
			return chesu;
		} else {
			return chesu -= 10;
		}
	}

	//成员方法 改车牌
	public String gaichepai(String chepai) {
		setChepai(chepai);
		return getChepai();
	}

	//成员方法 查询载重
	public double chaxunzaizhong() {
		return getZaizhong();
	}
}