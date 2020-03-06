package com.yc.pushbox.version2.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.yc.pushbox.version1.core.Game;

public class MainWin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int map[][] = Game.next();
	private JLabel[][] labels = new JLabel[map.length][map[0].length];
	private static final Icon[] IMGS = new Icon[10];

	static {
		for (int i = 0; i < IMGS.length; i++) {
			IMGS[i] = new ImageIcon(MainWin.class.getResource("/imgs/" + i + ".gif"));
		}
	}

	public static void main(String[] args) {
		new MainWin();
	}

	public MainWin() {
		super("推箱子");
		// 由于右边要添加按钮,所以窗体布局改为边界布局
		setLayout(new BorderLayout());
		// 创建放置地图的面板
		JPanel mapPanel = new JPanel();
		// 面板设置网格布局
		mapPanel.setLayout(new GridLayout(map.length, map[0].length));
		// 生成地图界面
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				labels[i][j] = new JLabel(IMGS[map[i][j]]);
				mapPanel.add(labels[i][j]);
			}
		}
		// 将面板添加到窗体中
		add(mapPanel, BorderLayout.CENTER);
		// 创建右边的放置按钮的面板
		JPanel conPanel = new JPanel();
		// 设置首选大小
		conPanel.setPreferredSize(new Dimension(100, 0));
		// 设置流式布局
		conPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// 添加三个按钮, 第二个参数是 lambda 表达式
		conPanel.add(buildBtn("重来一次", (ActionEvent e) -> {
			map = Game.reset();
			// 刷新地图控件
			refresh();
		}));
		conPanel.add(buildBtn("下一关", (ActionEvent e) -> {
			map = Game.next();
			// 刷新地图控件
			refresh();
		}));
		conPanel.add(buildBtn("退出", (ActionEvent e) -> {
			// 关闭窗口
			MainWin.this.dispose();
		}));
		add(conPanel, BorderLayout.EAST);
		
		// 窗体适应控件大小
		pack();
		// 关闭窗口退出程序
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 窗口居中
		center();
		// 打开窗口
		setVisible(true);
		
		/**
		 * 	添加键盘事件监听器( 当按下上下左右时触发的事件 )
		 */
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					Game.up();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					Game.down();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					Game.left();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					Game.right();
				}
				refresh();
				if (Game.isOver()) {
					JOptionPane.showMessageDialog(null, "英雄住手！胜负已决！");
					map = Game.next();
					refresh();
				}
			}
		});
	}

	/**
	 * 	刷新地图
	 */
	public void refresh() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				labels[i][j].setIcon(IMGS[map[i][j]]);
			}
		}
	}

	/**
	 * 	窗口居中
	 */
	public void center() {
		int screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int windowwidth = this.getSize().width;
		int windowheight = this.getSize().height;
		this.setLocation((screenwidth - windowwidth) / 2, (screenheight - windowheight) / 2);
	}

	/**
	 * 	创建按钮控件
	 * @param name	按钮名
	 * @param al	监听器
	 * @return		按钮控件
	 */
	public JButton buildBtn(String name, ActionListener al) {
		JButton ret = new JButton(name);
		ret.setPreferredSize(new Dimension(90, 30));
		ret.addActionListener(al);
		// 禁止按钮得到焦点, 避免争抢窗口的按钮事件
		ret.setFocusable(false);
		return ret;
	}

}
