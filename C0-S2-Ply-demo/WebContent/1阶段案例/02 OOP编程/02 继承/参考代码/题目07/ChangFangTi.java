public class ChangFangTi extends Juxing {
	private double gao;

	public double getGao() {
		return gao;
	}

	public void setGao(double gao) {
		this.gao = gao;
	}

	public double tiji() {
		return area() * gao;
	}
}