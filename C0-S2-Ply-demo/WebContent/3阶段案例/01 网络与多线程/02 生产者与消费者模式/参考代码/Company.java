import java.util.*;

public class Company {

	// 
	private List<Object> list = new ArrayList<>();

	public void product() {
		new Thread("生产者") {
			public void run() {
				try {
					// 锁定 list，在同步代码块中，list 只能被一个线程操作
					synchronized (list) {
						while (true) {
							for (int i = 0; i < 10; i++) {
								System.out.println(Thread.currentThread().getName() + ": 生产1个产品！");
								Thread.sleep(200);
								list.add(new Object());
							}
							// 通知消费者可以开始消费了
							list.notify();
							// 生产者开始等待
							list.wait();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public void consume() {
		new Thread("消费者") {
			public void run() {
				try {
					// 锁定 list，在同步代码块中，list 只能被一个线程操作
					synchronized (list) {
						while (true) {
							while (list.size() > 0) {
								System.out.println(Thread.currentThread().getName() + ": 消费1个产品！");
								Thread.sleep(200);
								list.remove(0);
							}
							// 通知生产者可以开始生产了
							list.notify();
							// 等待生产者完成生产
							list.wait();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public static void main(String[] args) {

		Company company = new Company();
		// 启动生产
		company.product();
		// 启动消费
		company.consume();

	}
}
