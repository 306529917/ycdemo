import java.util.Scanner;

/**
 * 
 * 银行柜员机类
 *
 */
public class ATM {

	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		new ATM().start();
	}

	public void start() {
		int op = 0;
		boolean ok = false;
		while (ok == false) {
			System.out.println("******************************");
			System.out.println("*           我的银行                 *");
			System.out.println("******************************");
			System.out.println("*           1、登录                   *");
			System.out.println("*           2、开户                   *");
			System.out.println("******************************");
			System.out.print("请输入你要办理的业务编号：");
			op = sc.nextInt();
			switch (op) {
			case 1:
				if ((ok = login()) == false) {
					System.out.println("密码错误！");
				}
				break;
			case 2:
				register();
				break;
			}
		}

		while (true) {
			System.out.println("\n");
			System.out.println("******************************");
			System.out.println("*           我的银行                 *");
			System.out.println("******************************");
			System.out.println("*         1、查看余额                *");
			System.out.println("*         2、存       款                *");
			System.out.println("*         3、取       款                *");
			System.out.println("*         4、转       账                *");
			System.out.println("*         5、查询明细                *");
			System.out.println("*         0、退       出                *");
			System.out.println("******************************");
			System.out.print("请输入你要办理的业务编号：");
			op = sc.nextInt();
			switch (op) {
			case 0:
				System.exit(0);
			case 1:
				balance();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				transfer();
				break;
			case 5:
				details();
				break;
			default:
				System.out.println("输入错误，请求重新输入！");
			}
		}

	}

	/**
	 * 注册
	 */
	private void register() {
		// TODO Auto-generated method stub

	}

	/**
	 * 余额
	 */
	private void balance() {
		// TODO Auto-generated method stub

	}

	/**
	 * 转账
	 */
	private void transfer() {
		// TODO Auto-generated method stub

	}

	/**
	 * 存款
	 */
	private void deposit() {
		// TODO Auto-generated method stub

	}

	/**
	 * 取款
	 */
	private void withdraw() {
		// TODO Auto-generated method stub

	}

	/**
	 * 查询明细
	 */
	private void details() {
		// TODO Auto-generated method stub

	}

	private boolean login() {
		return false;
	}

}
