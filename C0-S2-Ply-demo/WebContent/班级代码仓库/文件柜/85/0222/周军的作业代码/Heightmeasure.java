package yc0220;
/**
 * ��߲�������
 * @author Administrator
 *
 */
public class Heightmeasure  implements IMeasure{
	

	public double measure(Object obj) {
		if(obj instanceof Person) {
			Person person=(Person)obj;
			return person.getHeight();
		}else {
		return -1;
		}
	}


	

	

}
