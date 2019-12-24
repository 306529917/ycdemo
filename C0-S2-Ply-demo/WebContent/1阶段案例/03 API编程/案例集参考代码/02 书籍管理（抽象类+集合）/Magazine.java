import java.util.Scanner;

/**
 * 杂志
 */
public class Magazine extends Book {

	// 期号（刊号）
	private String issue;

	/**
	 * 在原有抽象的构造方法基础之上，在增加对期号的录入
	 * @param input
	 */
	public Magazine(Scanner input) {
		super(input);
		System.out.println("请输入期号：");
		setIssue(input.next());
	}

	/**
	 * 在原有的构造方法之上扩展“期号”参数
	 * @param name
	 * @param author
	 * @param publishing_house
	 * @param price
	 * @param id
	 * @param newRate
	 * @param issue
	 */
	public Magazine(String name, String author, String publishing_house, double price, String id, int newRate,
			String issue) {
		super(name, author, publishing_house, price, id, newRate);
		this.issue = issue;
	}

	public void showInLine(int index) {
		String fmt = "%-2s%-20s%-10s%-20s%-7s%-10s%-10s%-10s\n";
		System.out.printf(fmt, index, getName(), getAuthor(), getPublishingHouse(), getPrice(), getId(), getNewRate()+"%",
				getIssue());
	}

	public void showDetail() {
		System.out.println("类别：纸质图书\n书名：" + getName() + "\n作者：" + getAuthor() + "\n出版社：" + getPublishingHouse()
				+ "\n价格：" + getPrice() + "\n编号：" + getId() + "\n折旧：" + getNewRate() + "%" + "\n期号：" + getIssue());
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

}