package yc0220;

public class Test {
	public static void main(String[] args) {
		System.out.println("==============================");
		Container c = new Container();
		//�������
		c.addObject(new Person("�ܾ�", 1.74, 58,10000,4000,2000));
		c.addObject(new Person("����", 1.86, 60,7000,3000,1500));
		c.addObject(new Person("�ŷ�", 1.71, 80,30000,10000,5500));
		c.addObject(new Person("�ν�", 1.74, 90,5000,4000,1000));
		c.show();//�õ�����������
		System.out.println("==============================");
		Heightmeasure hm = new Heightmeasure();
		c.setMeasur(hm);
		c.mea();//������Ӧ�ıȽ�
		System.out.println("���max      " + c.getMax());
		System.out.println("���min      " + c.getMin());
		c.showName();//�õ����
		System.out.println("==============================");
		Weightmeasure wm = new Weightmeasure();
		c.setMeasur(wm);
		c.mea();
		System.out.println("����max      " + c.getMax());
		System.out.println("����min      " + c.getMin());
		c.showName();
		System.out.println("==============================");
		Bmi bmi = new Bmi();
		c.setMeasur(bmi);
		c.mea();
		System.out.println("����ָ��max      " + c.getMax());
		System.out.println("����ָ��min      " + c.getMin());
		c.showName();
		System.out.println("==============================");
		EG eg=new EG();
		c.setMeasur(eg);
		c.mea();
		//System.out.println("�����ϵ����59%����Ϊƶ����50-59%Ϊ�±� \n 40-50%ΪС����30-40%Ϊ��ԣ��\n ����30%Ϊ�ԣ��");
		System.out.println("�����ϵ��max      " + c.getMax());
		System.out.println("�����ϵ��min      " + c.getMin());
		c.showName();
		System.out.println("==============================");

	}

}
