package com.yc.pushbox.version2.swing;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.yc.pushbox.version2.core.Game;

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
		setLayout(new GridLayout(map.length, map[0].length));
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				labels[i][j] = new JLabel(IMGS[map[i][j]]);
				this.add(labels[i][j]);
			}
		}
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		center();
		setVisible(true);

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
				if(Game.isOver()) {
					JOptionPane.showMessageDialog(null, "英雄住手！胜负已决！");
					map = Game.next();
					refresh();
				}
			}

		});
	}
	
	public void refresh() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				labels[i][j].setIcon(IMGS[map[i][j]]);
			}
		}
	}

	public void center() {
		int screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int windowwidth = this.getSize().width;
		int windowheight = this.getSize().height;
		this.setLocation((screenwidth - windowwidth) / 2, (screenheight - windowheight) / 2);
	}

}
