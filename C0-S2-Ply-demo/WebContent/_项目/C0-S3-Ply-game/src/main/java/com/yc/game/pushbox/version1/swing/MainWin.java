package com.yc.game.pushbox.version1.swing;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.yc.game.pushbox.imgs.Imgs;
import com.yc.game.pushbox.version1.core.PushBoxGameImpl1;
import com.yc.game.pushbox.base.PushBoxGame;
import com.yc.game.util.IOUtils;

public class MainWin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel[][] labels;
	private PushBoxGame game;
	private static final Icon[] IMGS = new Icon[10];

	static {
		for (int i = 0; i < IMGS.length; i++) {
			InputStream in = Imgs.class.getResourceAsStream( i + ".gif");
			IMGS[i] = new ImageIcon(IOUtils.toByteArray(in));
		}
	}

	public static void main(String[] args) {
		new MainWin(new PushBoxGameImpl1());
	}

	public MainWin(PushBoxGame game) {
		super("推箱子");
		this.game = game;
		labels = new JLabel[game.getMap().length][game.getMap()[0].length];
		// 窗体布局设置网格布局
		setLayout(new GridLayout(game.getMap().length, game.getMap()[0].length));
		// 生成地图界面
		for (int i = 0; i < game.getMap().length; i++) {
			for (int j = 0; j < game.getMap()[i].length; j++) {
				labels[i][j] = new JLabel(IMGS[game.getMap()[i][j]]);
				this.add(labels[i][j]);
			}
		}
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
					game.up();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					game.down();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					game.left();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					game.right();
				}
				refresh();
				if(game.isOver()) {
					JOptionPane.showMessageDialog(null, "英雄住手！胜负已决！");
					game.next();
					refresh();
				}
			}

		});
	}
	
	/**
	 * 	刷新地图
	 */
	public void refresh() {
		for (int i = 0; i < game.getMap().length; i++) {
			for (int j = 0; j < game.getMap()[i].length; j++) {
				labels[i][j].setIcon(IMGS[game.getMap()[i][j]]);
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

}