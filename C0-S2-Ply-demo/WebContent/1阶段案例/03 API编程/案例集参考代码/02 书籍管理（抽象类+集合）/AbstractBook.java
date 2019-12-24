import java.util.Scanner;

public abstract class AbstractBook {
	public String name; //定义书名
	public String author;//定义作者
	public String publishingHouse;//出版社
	public double price;//价格
	public String id;//编号

	public AbstractBook(Scanner input) {
		System.out.println("请输入书名：");
		setName(input.next());
		System.out.println("请输入作者：");
		setAuthor(input.next());
		System.out.println("请输入出版社名称：");
		setPublishingHouse(input.next());
		System.out.println("请输入价格：");
		setPrice(input.nextDouble());
		System.out.println("请输入编号：");
		setId(input.next());
	}

	public AbstractBook(String name, String author, String publishingHouse, double price, String id) {
		super();
		this.name = name;
		this.author = author;
		this.publishingHouse = publishingHouse;
		this.price = price;
		this.id = id;
	}

	/**
	 * 抽象方法，图书显示的方法需要子类实现，父类并不知道子类图书用什么格式显示
	 */
	/**
	 * 在一行中显示该图书，用于列表显示
	 * @param index 当前行号
	 */
	public abstract void showInLine(int index);
	/**
	 * 单独显示该图书的详细信息
	 */
	public abstract void showDetail();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}