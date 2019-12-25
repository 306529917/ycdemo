
public class Music {
	public static void tune(Instrument i) {
		i.play();
	}

	public static void main(String[] args) {
		Wind w = new Wind();
		Brass b = new Brass();
		tune(w);
		tune(b);
	}
}