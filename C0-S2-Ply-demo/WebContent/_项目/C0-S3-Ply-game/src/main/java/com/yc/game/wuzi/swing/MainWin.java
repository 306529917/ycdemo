package com.yc.game.wuzi.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.yc.game.util.SwingUtils;
import com.yc.game.wuzi.core.Imgs;
import com.yc.game.wuzi.core.WuziGame;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 游戏主窗口，创建时必须传入游戏对象（参数是接口）
 * @author 廖彦
 *
 */
public class MainWin extends JFrame {

	// 不解释
	private static final long serialVersionUID = 1L;
	// 游戏对象
	private WuziGame game;
	// 棋盘面板
	private JPanel boardPanel;
	// 图片控件二维数组
	private MyLabel[][] labels = new MyLabel[WuziGame.SIZE][WuziGame.SIZE];

	/**
	 * 开始游戏
	 * @param game
	 */
	public static void start(WuziGame game) {
		/**
		 * 这是自动生成的代码, 用于启动窗口
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin frame = new MainWin(game);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 构建窗体
	 */
	public MainWin(WuziGame game) {
		super("开森五子棋");
		this.game = game;
		// 设置关闭窗口既是退出程序, 不设置默认是隐藏窗口
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置边界布局
		setLayout(new BorderLayout(0, 0));
		// 构建棋盘面板
		buildBoard();
		// 构建控制面板
		buildControll();
		// 初始化棋盘图片控件
		initBoard();
		// 窗体适应控件大小
		pack();
		// 窗体居中
		SwingUtils.center(this);
	}

	/**
	 * 构建控制面板
	 */
	private void buildControll() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panel.setPreferredSize(new Dimension(150, 0));
		panel.add(buildBtn("重新开始", (ActionEvent e) -> {
			game.restart();
			refreshBoard();
		}));
		panel.add(buildBtn("不玩了", (ActionEvent e) -> {
			MainWin.this.dispose();
		}));
		add(panel, BorderLayout.EAST);
	}

	/**
	 * 创建按钮控件
	 * @param string
	 * @return
	 */
	private JButton buildBtn(String name, ActionListener al) {
		JButton ret = new JButton(name);
		ret.setPreferredSize(new Dimension(100, 30));
		ret.addActionListener(al);
		return ret;
	}

	/**
	 * 构建棋盘面板
	 */
	private void buildBoard() {
		// 创建放置棋盘面板的面板
		JPanel panel = new JPanel();
		// 设置流式布局
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// 创建棋盘面板
		boardPanel = new JPanel() {
			private static final long serialVersionUID = 1L;

			// 画棋盘
			protected void paintComponent(Graphics g) {
				// 获取棋盘图片
				ImageIcon icon = (ImageIcon) Imgs.BOARD;
				Image img = icon.getImage();
				// 定义棋盘坐标( 棋盘图片略小于棋盘大小, 让其居中)
				int x = (getBoardSize() - icon.getIconWidth()) / 2;
				int y = (getBoardSize() - icon.getIconHeight()) / 2;
				// 将棋盘图片画到面板上, 实现类似桌面的效果
				g.drawImage(img, x, y, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
			}
		};
		// 设置网格布局
		boardPanel.setLayout(new GridLayout(WuziGame.SIZE, WuziGame.SIZE));
		// 设置首选大小
		boardPanel.setPreferredSize(new Dimension(getBoardSize(), getBoardSize()));
		// 添加棋盘面板
		panel.add(boardPanel);
		// 将面板)放入窗体
		add(panel, BorderLayout.CENTER);
	}

	/**
	 * 获取棋盘面板的大小，空格图片 * 棋盘大小
	 * @return
	 */
	private int getBoardSize() {
		return Imgs.SPACE.getIconWidth() * WuziGame.SIZE;
	}

	/**
	 * 初始化棋盘图片控件
	 */
	private void initBoard() {
		// 创建鼠标监听器
		MouseAdapter ma = new MouseAdapter() {
			@Override
			// 鼠标移动事件
			public void mouseEntered(MouseEvent e) {
				refreshBoard();
				MyLabel ml = (MyLabel) e.getSource();
				String pointName = game.getPointerName(ml.getBoardX(), ml.getBoardY());
				Icon icon = Imgs.getPointIcon(pointName);
				ml.setIcon(icon);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (game.getWuzi() != null) {
					return;
				}
				MyLabel ml = (MyLabel) e.getSource();
				game.down(ml.getBoardX(), ml.getBoardY());
				refreshBoard();
				if (game.getWuzi() != null) {
					String color = game.getWinner() == WuziGame.BLACK ? "黑" : "白";
					JOptionPane.showMessageDialog(null, color + "棋赢了!");
				}
			}
		};
		// 创建与游戏棋盘同步的棋盘控件( JLabel 二维数组 )
		for (int y = 0; y < WuziGame.SIZE; y++) {
			for (int x = 0; x < WuziGame.SIZE; x++) {
				// MyLabel 是 JLabel 的子类, 添加了棋盘坐标熟悉, 方便定位对应的棋子坐标
				labels[y][x] = new MyLabel(Imgs.SPACE, x, y);
				// 添加鼠标事件
				labels[y][x].addMouseListener(ma);
				// 将Label控件添加到面板中
				boardPanel.add(labels[y][x]);
			}
		}
	}

	/**
	 * 刷新棋盘控件
	 */
	private void refreshBoard() {
		for (int y = 0; y < WuziGame.SIZE; y++) {
			for (int x = 0; x < WuziGame.SIZE; x++) {
				// 获取当前棋盘坐标的颜色: 黑 1 , 白 2, 空 0
				int color = game.getColorByXY(x, y);
				// 获取演示对应图片
				Icon icon = Imgs.CHESS[color];
				// 重新设置label的图片
				labels[y][x].setIcon(icon);
			}
		}
		// 重画窗口
		this.repaint();
	}

}
