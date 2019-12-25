public class Aodi extends Car {
	private double jiage;
	private String xinghao;

	public double getJiage() {
		return jiage;
	}

	public void setJiage(double jiage) {
		this.jiage = jiage;
	}

	public String getXinghao() {
		return xinghao;
	}

	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}

	public double biansu() {
		double sudu = super.getSudu() + 10;
		return sudu;
	}

}