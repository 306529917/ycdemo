import java.util.Scanner;

/**
 * 电子书
 */
public class EBook extends AbstractBook {

	public EBook(Scanner input) {
		super(input);
	}

	public EBook(String name, String author, String publishing_house, double price, String id) {
		super(name, author, publishing_house, price, id);
	}
	
	public void showInLine(int index) {
		String fmt = "%-2s%-20s%-10s%-20s%-7s%-10s\n";
		System.out.printf(fmt, index, getName(), getAuthor(), getPublishingHouse(), getPrice(), getId());
	}

	public void showDetail() {
		System.out.println("类别：电子书\n书名：" + getName() + "\n作者：" + getAuthor() + "\n出版社：" + getPublishingHouse()
				+ "\n价格：" + getPrice() + "\n编号：" + getId());
	}

}
