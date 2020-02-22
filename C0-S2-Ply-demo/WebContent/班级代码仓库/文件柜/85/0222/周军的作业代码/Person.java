package yc0220;

public class Person {
	private String name;
	private double height;
	private double weight;
	private double income;//收入
	private double expenses;//支出
	private double foodexpenses;

	public Person(String name, double height, double weight, double income, double expenses, double foodexpenses) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.income = income;
		this.expenses = expenses;
		this.foodexpenses = foodexpenses;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		if (name == null) {
			System.out.println("请输入用户名：");
			return;
		}
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height == 0) {
			System.out.println("请输入身高：");
			return;
		}
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (height == 0) {
			System.out.println("请输入体重：");
			return;
		}
		this.weight = weight;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getExpenses() {
		return expenses;
	}

	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}

	public double getFoodexpenses() {
		return foodexpenses;
	}

	public void setFoodexpenses(double foodexpenses) {
		this.foodexpenses = foodexpenses;
	}
	

}
