package 题目04;

public class Calculator {

	// 第一个数字
	private double num1;
	// 第二个数字
	private double num2;

	/**
	 * 加
	 * @return
	 */
	public double add() {
		return num1 + num2;
	}

	/**
	 * 减
	 * @return
	 */
	public double subtract() {
		return num1 - num2;
	}

	/**
	 * 乘
	 * @return
	 */
	public double multiply() {
		return num1 * num2;
	}

	/**
	 * 除
	 * @return
	 */
	public double divide() {
		return num1 / num2;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

}
