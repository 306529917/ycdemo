
public class FlightTest {
	
	public static void main(String[] args) {
		// 创建航班
		Flight flight = new Flight();
		// 创建飞机
		Plane plane = new Plane();
		// 设置使用飞机
		flight.setPlane(plane);
		
		// 创建乘客
		Client c1 = new Client("武松","430403xxxxxxx1",5000);
		Client c2 = new Client("李逵","430403xxxxxxx2",7000);
		Client c3 = new Client("宋江","430403xxxxxxx3",8000);
		Client c4 = new Client("林冲","430403xxxxxxx4",3000);
		
		// 乘客预订航班
		c1.order(flight);
		c2.order(flight);
		c3.order(flight);
		c4.order(flight);
	}

}
