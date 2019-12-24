/**
8、写以下类：
	飞机：	型号，最大座位数，最大航程。
	航班：	航班号，航空公司名称，航空公司代号，航班日期，出发地，目的地，起飞时间，
      		到达时间，里程，使用飞机，剩余座位，全价，折扣率。
			方法：setPlane(Plane  p);
	客户：	姓名，身份证号，帐户余额。
			方法：order(Flight  f);
 */
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
