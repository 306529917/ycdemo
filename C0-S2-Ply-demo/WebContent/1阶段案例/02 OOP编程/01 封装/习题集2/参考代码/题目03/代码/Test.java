import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入您的账号：");
		String zhanghao = sc.nextLine(); //接收输入的账号
		String panduan = "^\\d{19}$"; //正则表达式
		Account person = new Account(); //实例化对象
		if (zhanghao.matches(panduan)) { //利用正则表达式判断账号
			System.out.println("您账户余额是：" + person.Yuechaxun());
			for (int i = 1; i > 0; i++) { //死循环实现多次存取款
				person.Caozuo();
				switch (person.caozuo) { //调用操作方法执行操作命令
				case "存款": //存款时调用存款方法
					person.Shuru(); //调用输入金额方法接收存款金额
					System.out.println("您账户的余额是：" + person.Cunkuan());
					break;
				case "取款": //取款是调用取款方法
					person.Shuru();
					person.Qukuan();
					break;
				case "查询余额": //查询余额时调用查询余额方法
					System.out.println("您账户的余额是：" + person.Yuechaxun());
					break;
				default:
					System.out.println("输入有误！");
				}
				if (person.caozuo.equals("停止")) {
					break; //让死循环停止
				}
			}
		} else {
			System.out.println("输入有误！");
		}
	}
}
