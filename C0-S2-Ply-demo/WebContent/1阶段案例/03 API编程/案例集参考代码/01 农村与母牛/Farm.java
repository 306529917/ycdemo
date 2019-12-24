
/**
1.分析：
	1.1农场开始有一头具有生育能力（年龄大于5岁）的母牛，以后每年都会生小母牛，而小母牛5年长大后又能生小母牛，从面向对象的角度分析，生小母牛的能力，
	属于母牛对象，我们可以把它定义为一个内部方法；农场容纳着母牛及生产的小母牛，我们可以在农场内部维护一个长度可变的容器（集合），存储所有的母牛；
	随着时间的变化，母牛的年龄在变化，农场的母牛数量也在变化，我们可以在农场中定义一个随着时间变化，而同时改变农场属性（母牛数量）和母牛属性（年龄）
	功能的方法。
	1.2对象：农场和母牛（属性：年龄）
	1.3对象的关系，农场和母牛是组合关系
 
2.把对象转换为类
	2.1母牛对象（年龄属性age及生育小母牛方法produceCow）
 */
import java.util.ArrayList;
import java.util.List;

public class Farm {
	private static List<Cows> cows;
	//新建农场时的初始化，初始化一头具有生育能力的母牛(年纪5岁以上)
	static {
		cows = new ArrayList<Cows>();
		Cows cow = new Cows(5);
		cows.add(cow);
	}

	//获取第year年母牛对象集合
	public static List<Cows> getCows(int year) {
		for (int i = 0; i < year; i++) {
			//新一年的变化，统计牛场奶牛数量时，重新建一个临时奶牛圈，圈住已有的奶牛和新生的奶牛
			List<Cows> tempCows = new ArrayList<Cows>();
			for (Cows cow1 : cows) {//遍历已有奶牛圈
				tempCows.add(cow1);//把原有奶牛加入新奶牛圈
				cow1.setAge(cow1.getAge() + 1);//原奶牛年纪+1
				Cows newCow = cow1.produceCow();//原奶牛自己判断自己年纪，如果到了生育期，自动生成一头小牛，没到5岁，返回null
				if (newCow != null) {
					tempCows.add(newCow);//将小牛加入新奶牛圈
				}
			}
			cows = tempCows;//将临时奶牛圈里的所有奶牛赶入奶牛圈，原奶牛圈会越来越多的
			System.out.printf("第%d年奶牛数量：%d%n", i + 1, cows.size());
			tempCows = null;//撤掉临时 的奶牛圈

		}
		return cows;
	}
	
	public static void main(String[] args) {
		getCows(20);
	}
}