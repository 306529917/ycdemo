public class Clock {
	int h;
	int miu;
	int s;

	Clock(int hour, int minut, int secend) {
		h = hour;
		miu = minut;
		s = secend;
	}

	public void show() {
		if (h >= 0 && h <= 23) {
			if (miu >= 0 && miu <= 59) {
				if (s >= 0 && s <= 59) {
					System.out.println("时间是：" + h + "时" + miu + "分" + s + "秒");
				} else {
					System.out.println("时间不合法！");
				}
			} else {
				System.out.println("时间不合法！");
			}
		} else {
			System.out.println("时间不合法！");
		}
	}
}