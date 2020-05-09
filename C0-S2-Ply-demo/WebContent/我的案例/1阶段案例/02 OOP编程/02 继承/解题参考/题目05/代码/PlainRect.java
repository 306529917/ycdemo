public class PlainRect extends Rect {//声明属性
	private int startX;
	private int startY;

	//含参构造方法
	public PlainRect(int startX, int startY, double width, double height) {
		super(width, height); //调用父类构造方法
		this.startX = startX;
		this.startY = startY;
	}

	//不含参构造方法
	public PlainRect() {
		super(0, 0);
		this.startX = 0;
		this.startY = 0;
	}

	//成员方法  判断点与矩形位置
	public boolean isInside(double x, double y) {
		return x >= startX && x <= (startX + getWidth()) && y < startY && y >= (startY - getHeight());
	}
}