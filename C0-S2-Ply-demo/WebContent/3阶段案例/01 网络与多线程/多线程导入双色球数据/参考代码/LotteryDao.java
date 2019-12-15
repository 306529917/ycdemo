import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.yc.jee.util.DBHelper;

/**
 * 使用最快的方式实现：读取数据文件（双色球数据文件.txt），添加大量双色球数据
 */
public class LotteryDao {

	public static void main(String[] args) throws IOException {
		//init();
		//singleThread1(); 	// 时间太长，没法测
		init();
		singleThread2(); // 大概耗时 500 毫秒
		init();
		multiThread1(); // 大概耗时 46000 毫秒
		init();
		multiThread2(); // 大概耗时 300 毫秒
	}

	public static void init() {
		DBHelper.update("delete from lottery");
		System.out.println("清空数据完成！");
	}

	/**
	 * 单线程单独insert方式
	 * @throws IOException
	 */
	public static void singleThread1() throws IOException {
		long time = System.currentTimeMillis();
		// 读取数据文件
		InputStream is = LotteryDao.class.getClassLoader().getResourceAsStream("双色球数据文件.txt");
		// 转成字符流（可以按字符读取）
		InputStreamReader isr = new InputStreamReader(is);
		// 转成缓冲字符流（可以按行读取）
		BufferedReader br = new BufferedReader(isr);
		try {
			String line;
			while ((line = br.readLine()) != null) {
				String[] items = line.split("\\s+");
				String sql = "insert into lottery values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
				DBHelper.update(sql, items);
			}
		} finally {
			br.close();
		}
		System.out.println("单线程单独insert方式   共耗时：" + (System.currentTimeMillis() - time) + "毫秒");
	}

	/**
	 * 单线程批量insert方式
	 * @throws IOException
	 */
	public static void singleThread2() throws IOException {
		long time = System.currentTimeMillis();
		// 读取数据文件
		InputStream is = LotteryDao.class.getClassLoader().getResourceAsStream("双色球数据文件.txt");
		// 转成字符流（可以按字符读取）
		InputStreamReader isr = new InputStreamReader(is);
		// 转成缓冲字符流（可以按行读取）
		BufferedReader br = new BufferedReader(isr);
		try {
			String line;
			StringBuffer sb = new StringBuffer("insert into lottery values ");
			ArrayList<Object> params = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				String[] items = line.split("\\s+");
				//构建语句
				sb.append("(null,?,?,?,?,?,?,?,?,?,?,?,?),");
				//添加参数
				params.addAll(Arrays.asList(items));
			}
			String sql = sb.toString().substring(0, sb.length() - 1);
			DBHelper.update(sql, params.toArray());
		} finally {
			br.close();
		}
		System.out.println("单线程批量insert方式  共耗时：" + (System.currentTimeMillis() - time) + "毫秒");
	}

	/**
	 * 多线程单独insert方式
	 * @throws IOException
	 */
	public static void multiThread1() throws IOException {
		// 读取数据文件
		InputStream is = LotteryDao.class.getClassLoader().getResourceAsStream("双色球数据文件.txt");
		// 转成字符流（可以按字符读取）
		InputStreamReader isr = new InputStreamReader(is);
		// 转成缓冲字符流（可以按行读取）
		BufferedReader br = new BufferedReader(isr);
		try {
			String line;
			ArrayList<String[]> dataList = new ArrayList<>();
			// 将所有的数据保存到集合中，每一个集合元素是一行数据
			while ((line = br.readLine()) != null) {
				String[] items = line.split("\\s+");
				dataList.add(items);
			}
			// 每1000行数据启动一个线程，执行 insert 操作
			for (int i = 0; i * 1000 < dataList.size(); i++) {
				int begin = i * 1000;
				int end = begin + 1000;
				// 线程编号，内部类中不能访问 i 变量，所以重新定义 index 赋值为 i
				int index = i;
				new Thread() {
					public void run() {
						long time = System.currentTimeMillis();
						for (int i = begin; i < end && i < dataList.size(); i++) {
							String sql = "insert into lottery values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
							DBHelper.update(sql, dataList.get(i));
						}
						System.out.println(
								"多线程单独insert方式  线程" + index + "共耗时：" + (System.currentTimeMillis() - time) + "毫秒");
					}
				}.start();
			}
		} finally {
			br.close();
		}
	}

	/**
	 * 多线程批量insert方式
	 * @throws IOException
	 */
	public static void multiThread2() throws IOException {
		// 读取数据文件
		InputStream is = LotteryDao.class.getClassLoader().getResourceAsStream("双色球数据文件.txt");
		// 转成字符流（可以按字符读取）
		InputStreamReader isr = new InputStreamReader(is);
		// 转成缓冲字符流（可以按行读取）
		BufferedReader br = new BufferedReader(isr);
		try {
			String line;
			ArrayList<String[]> dataList = new ArrayList<>();
			// 将所有的数据保存到集合中，每一个集合元素是一行数据
			while ((line = br.readLine()) != null) {
				String[] items = line.split("\\s+");
				dataList.add(items);
			}
			// 每1000行数据启动一个线程，执行 insert 操作
			for (int i = 0; i * 1000 < dataList.size(); i++) {
				int begin = i * 1000;
				int end = begin + 1000;
				// 线程编号，内部类中不能访问 i 变量，所以重新定义 index 赋值为 i
				int index = i;
				new Thread() {
					public void run() {
						long time = System.currentTimeMillis();
						StringBuffer sb = new StringBuffer("insert into lottery values ");
						ArrayList<Object> params = new ArrayList<>();
						for (int i = begin; i < end && i < dataList.size(); i++) {
							String[] items = dataList.get(i);
							//构建语句
							sb.append("(null,?,?,?,?,?,?,?,?,?,?,?,?),");
							//添加参数
							params.addAll(Arrays.asList(items));
						}
						String sql = sb.toString().substring(0, sb.length() - 1);
						DBHelper.update(sql, params.toArray());
						System.out.println(
								"多线程批量insert方式  线程" + index + "共耗时：" + (System.currentTimeMillis() - time) + "毫秒");
					}
				}.start();
			}
		} finally {
			br.close();
		}
	}

}
