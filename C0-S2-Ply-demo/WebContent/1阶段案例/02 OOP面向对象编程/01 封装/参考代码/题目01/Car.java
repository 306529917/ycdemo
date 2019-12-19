package 题目01;

public class Car {

	// 油量
	private int gas;
	// 百公里耗油率 7.4
	private double rate = 7.4;
	
	/**
	 * 构造函数
	 * @param gas 初始油量
	 */
	public Car(int gas) {
		this.gas = gas;
	}

	/**
	 * 驾驶
	 * @param range 行驶的公里数
	 */
	public void drive(int range) {
		gas -= range / 100 * rate;
	}

	/**
	 * 返回当前油量
	 * @return
	 */
	public int getGas() {
		return gas;
	}

	/**
	 * 加油
	 * @param gas
	 */
	public void addGas(int gas) {
		this.gas += gas;
	}

}
