package yc0220;
/**
 * ·ÊÅÖÖ¸Êı
 * @author Administrator
 *
 */
public class Bmi implements IMeasure{
	public double measure(Object obj) {
		if(obj instanceof Person) {
			Person person=(Person)obj;
			return (person.getWeight()/(person.getHeight()*person.getHeight()));
		}else {
		return -1;
		}
	}

	
	

}
