import java.util.ArrayList;
import java.util.Scanner;

public class MainView {

	private ArrayList<AbstractBook> bookList = new ArrayList<>();

	Scanner input = new Scanner(System.in);

	public MainView() {
		// 初始化数据
		bookList.add(new Book("西游记", "吴承恩", "人民教育出版社", 22.5, "AN1001", 100));
		bookList.add(new Book("三体", "刘慈欣", "机械工业出版社", 50.0, "AN1002", 80));
		bookList.add(new EBook("资治通鉴", "司马光", "清华历史出版社", 30.8, "AN1003"));
		bookList.add(new EBook("java编程", "宋鹏飞", "北京大学出版社", 12.5, "AN1004"));
		bookList.add(new Book("安卓开发", "杨青", "高等教育出版社", 110.0, "An1005", 90));
		bookList.add(new Magazine("大众软件", "小编", "清华大学出版社", 12.5, "AN1006", 100, "201901"));
		bookList.add(new Magazine("电脑世界", "小编", "高等教育出版社", 89.0, "An1007", 90, "201902"));
		// 显示主界面
		mainview();
	}

	/**
	 * 显示主界面
	 */
	public void mainview() {
		do {
			System.out.println();
			System.out.println("--------图书管理系统---------");
			System.out.println("请选择：");
			System.out.println("1 添加图书");
			System.out.println("2 移除图书");
			System.out.println("3 查找图书");
			System.out.println("4 查看所有图书");
			System.out.println("5 退出");

			int key = input.nextInt();

			switch (key) {
			case 1:
				addBooks();
				mainview();
				break;
			case 2:
				removeBooks();
				mainview();
				break;
			case 3:
				System.out.println("请选择序号：\n1 按照书名 2 按照作者");
				switch (input.nextInt()) {
				case 1:
					searchBooksByName();
					break;
				case 2:
					searchBooksByAuthor();
					break;
				default:
					System.out.println("不好意思，输入有误");
					break;
				}
				mainview();
			case 4:
				showAll();
				mainview();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("不好意思，输入有误");
				break;
			}

		} while (true);

	}

	/**
	 * 显示所有图书
	 */
	public void showAll() {
		String fmt = "%-2s%-20s%-10s%-20s%-7s%-10s%-10s%-10s%-10s\n";
		System.out.printf(fmt, "序号", "名称", "作者", "出版社", "价格", "编号", "类别", "折旧率", "期号");
		for (int i = 0; i < bookList.size(); i++) {
			AbstractBook book = bookList.get(i);
			book.showInLine(i+1);
		}
	}

	/**
	 * 添加图书
	 */
	public void addBooks() {
		System.out.println("请选择添加类型：");
		System.out.println("1：图书2：电子书3：杂志");
		int key = input.nextInt();
		AbstractBook abook;
		if (key == 1) {
			abook = new Book(input);
		} else if (key == 2) {
			abook = new EBook(input);
		} else if (key == 3) {
			abook = new Magazine(input);
		} else {
			System.out.println("输入错误！");
			return;
		}
		bookList.add(abook);
		System.out.println("添加成功");
		System.out.println("添加的信息如下");
		abook.showDetail();
	}

	/**
	 * 移除图书
	 */
	public void removeBooks() {
		System.out.println("请选择需要移除的书籍编号：");
		String id = input.next();
		for (int i = 0; i < bookList.size(); i++) {
			if (id.equals(bookList.get(i).getId())) {
				bookList.remove(i);
				System.out.println("图书删除成功！");
				return;
			}
		}
		System.out.println("没有该图书编号：" + id);
	}

	/**
	 * 按照名称查找图书
	 */
	public void searchBooksByName() {
		System.out.println("请选择需要查看的书籍名称：");
		String name = input.next();
		for (int i = 0; i < bookList.size(); i++) {
			if (name.equals(bookList.get(i).getName())) {
				bookList.get(i).showDetail();
				return;
			}
		}
		System.out.println("没有该图书名称：" + name);
	}

	/**
	 * 按照作者查找图书
	 */
	public void searchBooksByAuthor() {
		System.out.println("请选择需要查看的书籍作者：");
		String auther = input.next();
		for (int i = 0; i < bookList.size(); i++) {
			if (auther.equals(bookList.get(i).getName())) {
				bookList.get(i).showInLine(i+1);
			}
		}
		System.out.println("没有该图书作者：" + auther);
	}

	/**
	 * main 方法
	 */
	public static void main(String[] args) {
		new MainView();
	}

}