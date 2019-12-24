import java.util.Scanner;

/**
 * 纸质图书
 */
public class Book extends AbstractBook {

	// 折旧率 0~100 0为报废，100为全新
	private int newRate;

	/**
	 * 在原有抽象的构造方法基础之上，在增加对折旧率的录入
	 * @param input
	 */
	public Book(Scanner input) {
		super(input);
		System.out.println("请输入折旧率：");
		setNewRate(input.nextInt());
	}

	/**
	 * 在原有的构造方法之上扩展“折旧率”参数
	 * @param name
	 * @param author
	 * @param publishing_house
	 * @param price
	 * @param id
	 * @param newRate
	 */
	public Book(String name, String author, String publishing_house, double price, String id, int newRate) {
		super(name, author, publishing_house, price, id);
		this.newRate = newRate;
	}

	public void showInLine(int index) {
		String fmt = "%-2s%-20s%-10s%-20s%-7s%-10s%-10s\n";
		System.out.printf(fmt, index, getName(), getAuthor(), getPublishingHouse(), getPrice(), getId(), getNewRate()+"%");
	}

	public void showDetail() {
		System.out.println("类别：纸质图书\n书名：" + getName() + "\n作者：" + getAuthor() + "\n出版社：" + getPublishingHouse()
				+ "\n价格：" + getPrice() + "\n编号：" + getId() + "\n折旧：" + getNewRate() + "%");
	}

	public int getNewRate() {
		return newRate;
	}

	public void setNewRate(int newRate) {
		this.newRate = newRate;
	}

}
