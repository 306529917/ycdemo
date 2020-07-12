/**
 * 客户
 */
public class Client {
	
	/**
	 * 客户姓名
	 */
	private String name;
	
	/**
	 * 身份证号
	 */
	private String id;
	
	/**
	 * 帐户余额
	 */
	private double balance;
	
	/**
	 * order 下订单(定飞机票)
	 * @param f  航班对象
	 */
	public void order(Flight f){
		// 通过航班获取飞机对象
		Plane plane = f.getPlane();
		// 将当前乘客添加到 飞机中
		plane.add(this);
		System.out.println("乘客"+name+"预订航班成！");
	}
	
	public Client(String name, String id, double balance) {
		super();
		this.name = name;
		this.id = id;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
