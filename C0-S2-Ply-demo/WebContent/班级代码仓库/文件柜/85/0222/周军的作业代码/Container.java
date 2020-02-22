package yc0220;

/**
 * ������
 * 
 * @author Administrator
 *
 */
public class Container {
	private Object objects[] = new Object[100];
	private int index;
	private IMeasure measure;
	private double min;
	private double max;
	// private int count=0;

	public void addObject(Object obj) {
		if (index == 100) {
			System.out.println("����������");
			return;
		}
		if (obj == null) {
			System.out.println("������Ϊ�գ�");
			return;
		}
		objects[index] = obj;
		index++;

	}

	public void setMeasur(IMeasure m) {
		this.measure = m;
	}

	public void mea() {
		max = -1;
		min = -1;
		for (Object obj : objects) {
			double value = measure.measure(obj);

			if (obj == null) {
				break;
			} else if (min == -1 || min > value) {
				min = value;
			}

			else if (max == -1 || max < value) {
				max = value;
			}

		}

	}

	public double getMax() {
		return max;
	}

	public double getMin() {
		return min;
	}

	public void showName() {
		for (Object obj : objects) {
			Person p = (Person) obj;
			if (obj == null) {
				break;
			}
			if (p.getHeight() == max || p.getWeight() == max || (p.getWeight() / (p.getHeight() * p.getHeight())) == max
					|| (p.getFoodexpenses() / p.getExpenses() == max)) {
				System.out.println("max������" + p.getName());
			} else if (p.getHeight() == min || p.getWeight() == min
					|| (p.getWeight() / (p.getHeight() * p.getHeight())) == min
					|| (p.getFoodexpenses() / p.getExpenses() == min)) {
				System.out.println("min������" + p.getName());
			}
		}
	}
	public void show() {
		for (Object obj : objects) {
			Person p = (Person) obj;
			if (obj == null) {
				break;
			}else {
				System.out.printf("������%s��ߣ�%s���أ����룺%s֧����%sʳƷ֧����%s\n",p.getName(),p.getHeight(),p.getWeight(),p.getIncome(),p.getExpenses(),p.getFoodexpenses());
			}
			
		}
	}

}
