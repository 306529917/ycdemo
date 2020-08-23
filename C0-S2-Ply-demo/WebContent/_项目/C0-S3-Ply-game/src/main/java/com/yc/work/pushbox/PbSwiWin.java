package com.yc.work.pushbox;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class PbSwiWin extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblTitle;

	ImageIcon[] imgs = { new ImageIcon(getClass().getResource("imgs/0.GIF")),
			new ImageIcon(getClass().getResource("imgs/1.GIF")),
			new ImageIcon(getClass().getResource("imgs/2.GIF")),
			new ImageIcon(getClass().getResource("imgs/3.GIF")),
			new ImageIcon(getClass().getResource("imgs/4.GIF")),
			new ImageIcon(getClass().getResource("imgs/5.GIF")),
			new ImageIcon(getClass().getResource("imgs/6.GIF")),
			new ImageIcon(getClass().getResource("imgs/7.GIF")),
			new ImageIcon(getClass().getResource("imgs/8.GIF")),
			new ImageIcon(getClass().getResource("imgs/9.GIF")) };

	// 创建与游戏地图一样大小的 图片二维数组
	JLabel[][] labels = new JLabel[20][20];

	// 创建推箱子游戏对象
	PbGame pb = new PbGame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PbSwiWin frame = new PbSwiWin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public PbSwiWin() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		// 设置网格大小
		panel.setLayout(new GridLayout(20, 20));

		// 控制按钮的面板
		JPanel panelCtrl = new JPanel();
		// 设置流式布局
		FlowLayout flowLayout = (FlowLayout) panelCtrl.getLayout();
		// 设置水平和垂直间距
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		// 设置控制按钮面板的位置
		contentPane.add(panelCtrl, BorderLayout.EAST);
		// 设置面板的宽度
		panelCtrl.setPreferredSize(new Dimension(100, 0));
		// 添加按钮
		JButton btnNewRestart = new JButton("重新开始");
		/**
		 * 点击重新开始按钮, 所触发的动作
		 */
		btnNewRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 调用pb对象restart方法
				pb.restart();
				// 刷新游戏界面
				refresh();
			}
		});

		lblTitle = new JLabel("推箱子:第几关");
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelCtrl.add(lblTitle);
		panelCtrl.add(btnNewRestart);

		JButton btnNewSave = new JButton("保存进度");
		panelCtrl.add(btnNewSave);

		JButton btnNewLoad = new JButton("加载进度");
		panelCtrl.add(btnNewLoad);
		JButton btnNewClose = new JButton("退出游戏");
		btnNewClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PbSwiWin.this.dispose();
			}
		});
		panelCtrl.add(btnNewClose);

		btnNewSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 调用pb对象restart方法
				pb.save();
			}
		});

		btnNewLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 调用pb对象restart方法
				pb.load();
				// 刷新游戏界面
				refresh();
			}
		});

		/** 设置按钮不可获取焦点, 避免小人不可操作 **/
		btnNewRestart.setFocusable(false);
		btnNewClose.setFocusable(false);
		btnNewSave.setFocusable(false);
		btnNewLoad.setFocusable(false);

		// for + alt + / 自动生成 for 语句
		for (int y = 0; y < labels.length; y++) {
			for (int x = 0; x < labels.length; x++) {
				// 创建图片对象
				labels[y][x] = new JLabel("");
				// 添加到面板中
				panel.add(labels[y][x]);
			}
		}

		refresh();
		// 重新规划窗体大小
		pack();
	
		// pb.load(1)
		// 添加键盘事件的监听器
		this.addKeyListener(new KeyAdapter() {
			// 键盘按下的事件
			@Override
			public void keyPressed(KeyEvent e) {
				// 控制小人上下左右移动
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					pb.moveUp();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					pb.moveDown();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					pb.moveLeft();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					pb.moveRight();
				}
				// 刷新界面
				refresh();
				if (pb.isYouWin()) {
					// 提示用户
					JOptionPane.showMessageDialog(null, "厉害,进入下一关!");
					// 进入下一关
					pb.next();
					pb.save();
					// 刷新界面
					refresh();
				}
			}
		});
	}

	// 刷新地图
	public void refresh() {
		lblTitle.setText("推箱子:第" + pb.getLevel() + "关");
		for (int y = 0; y < labels.length; y++) {
			for (int x = 0; x < labels.length; x++) {
				// 创建图片对象 char ==> int
				int i = Integer.valueOf("" + pb.getMap()[y][x]);
				// 设置图片
				labels[y][x].setIcon(imgs[i]);
			}
		}
	}

}
