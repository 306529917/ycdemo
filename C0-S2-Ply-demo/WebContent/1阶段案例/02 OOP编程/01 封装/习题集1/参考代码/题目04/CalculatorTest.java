package 题目04;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.setNum1(145);
		cal.setNum2(55);
		System.out.println(cal.getNum1() + " + " + cal.getNum2() + " = " + cal.add());
		System.out.println(cal.getNum1() + " - " + cal.getNum2() + " = " + cal.subtract());
		System.out.println(cal.getNum1() + " * " + cal.getNum2() + " = " + cal.multiply());
		System.out.println(cal.getNum1() + " / " + cal.getNum2() + " = " + cal.divide());
	}

}
