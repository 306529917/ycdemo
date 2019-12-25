public class Shape {
	private int bian;
	private double zhouchang;
	private double mianji;

	public int getBian() {
		return bian;
	}

	public void setBian(int bian) {
		this.bian = bian;
	}

	public double getZhouchang() {
		return zhouchang;
	}

	public void setZhouchang(double zhouchang) {
		this.zhouchang = zhouchang;
	}

	public double getMianji() {
		return mianji;
	}

	public void setMianji(double mianji) {
		this.mianji = mianji;
	}

	public void bian() {
		System.out.println("您创建了一个" + bian + "边形！");
	}
}