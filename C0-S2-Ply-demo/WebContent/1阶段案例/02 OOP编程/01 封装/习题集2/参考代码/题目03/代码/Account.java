import java.util.Scanner;

/**
 * 编写Java应用程序。首先定义一个描述银行账户的Account类，包括成员变
量“账号”和“存款余额”，成员方法有“存款”、“取款”和“余额查询”。其次，
编写一个主类，在主类中测试Account类的功能。
 * @author Administrator
 *
 */
public class Account {
	//属性
	long zhanghao;
	long cunkuanyue;
	int shuru;
	String caozuo;

	//操作命令输入方法
	String Caozuo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入操作指令：");
		caozuo = sc.nextLine();
		return caozuo;
	}

	//存取款金额输入方法
	int Shuru() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入金额：");
		shuru = sc.nextInt();
		return shuru;
	}

	//存款方法
	long Cunkuan() {
		cunkuanyue = cunkuanyue + shuru;
		return cunkuanyue;
	}

	//取款方法
	long Qukuan() {
		if (cunkuanyue > 0) {
			cunkuanyue = cunkuanyue - shuru;
			if (cunkuanyue < 0) {
				System.out.println("您的账户余额不足，无法取款！" + (cunkuanyue += shuru));
			} else {
				System.out.println("您的账户余额是：" + cunkuanyue);
			}
		} else {
			System.out.println("您的账户余额不足，无法取款！");
		}
		return cunkuanyue;
	}

	//查询余额方法
	long Yuechaxun() {
		return cunkuanyue;
	}
}