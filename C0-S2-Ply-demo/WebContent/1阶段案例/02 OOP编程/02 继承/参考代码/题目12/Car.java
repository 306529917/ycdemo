public class Car {
	private String pinpa; //品牌属性
	private double sudu;

	public String getPinpa() {
		return pinpa;
	}

	public void setPinpa(String pinpa) {
		this.pinpa = pinpa;
	}

	public double getSudu() {
		return sudu;
	}

	public void setSudu(double sudu) {
		this.sudu = sudu;
	}

	public String drive() {
		return "汽车已启动！";
	}

}