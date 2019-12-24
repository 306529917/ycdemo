/**
 * 飞机
 */
public class Plane {
	
	// 座位数
	private int placeNum = 400;
	// 型号
	private String model;
	// 里程
	private int lengthNum;
	
	// 乘客数组
	private Client[] clients = new Client[400];
	// 当前乘客座位号
	private int index = 0;
	
	/**
	 * 给飞机添加乘客
	 * @param client
	 */
	public void add(Client client){
		
		if(index == placeNum){
			System.out.println("航班人数已满！");
			return;
		}
		
		clients[index] = client;
		index ++;
	}

	public int getPlaceNum() {
		return placeNum;
	}

	public void setPlaceNum(int placeNum) {
		this.placeNum = placeNum;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getLengthNum() {
		return lengthNum;
	}

	public void setLengthNum(int lengthNum) {
		this.lengthNum = lengthNum;
	}
	
	

}
