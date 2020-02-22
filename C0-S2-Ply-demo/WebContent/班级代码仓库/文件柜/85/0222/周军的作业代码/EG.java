package yc0220;

public class EG implements IMeasure{

	public double measure(Object obj) {
		if(obj instanceof Person) {
			Person p=(Person)obj;
			return (p.getFoodexpenses()/p.getExpenses());
		}
		return 0;
	}

}
