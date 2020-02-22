package yc0220;

public class Test {
	public static void main(String[] args) {
		System.out.println("==============================");
		Container c = new Container();
		//添加资料
		c.addObject(new Person("周军", 1.74, 58,10000,4000,2000));
		c.addObject(new Person("武松", 1.86, 60,7000,3000,1500));
		c.addObject(new Person("张飞", 1.71, 80,30000,10000,5500));
		c.addObject(new Person("宋江", 1.74, 90,5000,4000,1000));
		c.show();//得到所有人资料
		System.out.println("==============================");
		Heightmeasure hm = new Heightmeasure();
		c.setMeasur(hm);
		c.mea();//进行相应的比较
		System.out.println("身高max      " + c.getMax());
		System.out.println("身高min      " + c.getMin());
		c.showName();//得到结果
		System.out.println("==============================");
		Weightmeasure wm = new Weightmeasure();
		c.setMeasur(wm);
		c.mea();
		System.out.println("体重max      " + c.getMax());
		System.out.println("体重min      " + c.getMin());
		c.showName();
		System.out.println("==============================");
		Bmi bmi = new Bmi();
		c.setMeasur(bmi);
		c.mea();
		System.out.println("肥胖指数max      " + c.getMax());
		System.out.println("肥胖指数min      " + c.getMin());
		c.showName();
		System.out.println("==============================");
		EG eg=new EG();
		c.setMeasur(eg);
		c.mea();
		//System.out.println("恩格尔系数在59%以上为贫困，50-59%为温饱 \n 40-50%为小康，30-40%为富裕，\n 低于30%为最富裕。");
		System.out.println("恩格尔系数max      " + c.getMax());
		System.out.println("恩格尔系数min      " + c.getMin());
		c.showName();
		System.out.println("==============================");

	}

}
