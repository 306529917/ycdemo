package yc0220;
/**
 * 体重测量工具
 * @author Administrator
 *
 */
public class Weightmeasure implements IMeasure{

	public double measure(Object obj) {
		if(obj instanceof Person) {
			Person person=(Person)obj;
			return person.getWeight();
		}else {
		return -1;
		}
	}

	

	
}
