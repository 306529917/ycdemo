package pushbox;

// 导入类
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 游戏界面类, 继承 Swing (图形编程框架) 的 JFrame 窗口类
 */
public class MainWin extends JFrame {

	/**
	 * 载入地图
	 */
	private int[][] map = Maps.next();

	/**
	 * 定义图片控件数组, 实现地图map与图片控件的映射, 与 map 的大小一致
	 */
	private JLabel[][] labelMap = new JLabel[10][10];

	// 定义图标数组
	private Icon[] imgs = new Icon[10];

	public static void main(String[] args) {
		// 创建主窗体对象
		MainWin mainWin = new MainWin();
	}

	// MainWin 构造方法( 初始化 )
	public MainWin() {

		// 读入10个图片
		loadImg();

		// 设置布局管理器, 使用网格布局
		this.setLayout(new GridLayout(10, 10));

		// 初始化图片控件
		initLabel();
		
		// 创建游戏对象
		Game game = new Game();
		// 给游戏对象设置地图
		game.setMap(map);
		
		/**
		 * 添加键盘事件监听
		 */
		this.addKeyListener(new KeyAdapter() {
			/**
			 * 监听键盘按下的事件
			 */
			public void keyPressed(KeyEvent e) {
				// 判断是否按下"上下左右"键
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					game.down();
				} else if(e.getKeyCode() == KeyEvent.VK_UP) {
					game.up();
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					game.left();
				} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					game.right();
				}
				// 将地图的内容同步到图片控件上
				updateLabel();
				// 判断游戏是否结束
				if( game.isOver()) {
					// 先试试提示框窗口
					JOptionPane.showMessageDialog(null, "英雄!你赢了!");
				}
			}
		});

		// 初始化窗口
		initWindow();

	}

	/**
	 * 载入图片
	 */
	public void loadImg() {
		for (int i = 0; i < 10; i++) {
			imgs[i] = new ImageIcon(MainWin.class.getResource("/imgs/" + i + ".gif"));
		}
	}

	/**
	 * 在窗口中输出地图控件
	 */
	public void initLabel() {
		// 嵌套循环遍历 map 数组,生成 label
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				// 根据地图当前坐标值, 取对应的图片
				int index = map[y][x];
				// 获取地图坐标值对应的图片
				Icon icon = imgs[index];
				// 创建标签对象
				JLabel label = new JLabel(icon);
				// 将标签放入窗口中
				this.add(label);
				// 将图片放入到图片控件数组中
				labelMap[y][x] = label;
			}
		}
	}

	/**
	 * 将地图的内容同步到图片控件上
	 */
	public void updateLabel() {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				// 根据地图当前坐标值, 取对应的图片
				int index = map[y][x];
				// 获取地图坐标值对应的图片
				Icon icon = imgs[index];
				// 重新设置控件的图片
				labelMap[y][x].setIcon(icon);
			}
		}
	}

	/**
	 * 初始化窗口
	 */
	public void initWindow() {
		// 控制窗体大小, 自动适应内部元素
		this.pack();
		// 显示窗体
		this.setVisible(true);

		/**
		 * 窗口居中, 计算窗口的位置, 然后重新设置窗口位置
		 */
		// 获取屏幕宽度
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		// 获取屏幕高度
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		// 获取窗口的宽度
		int selfWidth = this.getSize().width;
		// 获取窗口的高度
		int selfHeight = this.getSize().height;
		// 计算窗口的居中位置
		int x = (screenWidth - selfWidth) / 2;
		int y = (screenHeight - selfHeight) / 2;
		// 重新设置窗口位置
		this.setLocation(x, y);

		// 设置窗体关闭既是退出程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
