package com.yc.work.saolei;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaoLeiSwiWin {

	private JFrame frame;
	private static final int DEFAULT_HEIGHT = 20;
	private static final int DEFAULT_WIDTH = 30;
	private JLabel[][] labels = new JLabel[DEFAULT_HEIGHT][DEFAULT_WIDTH];
	private BaseSaoLeiGame game = new BaseSaoLeiGame(DEFAULT_HEIGHT, DEFAULT_WIDTH, 1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaoLeiSwiWin window = new SaoLeiSwiWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SaoLeiSwiWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u626B\u96F7\u6E38\u620F");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(DEFAULT_HEIGHT, DEFAULT_WIDTH));

		for (int y = 0; y < DEFAULT_HEIGHT; y++) {
			for (int x = 0; x < DEFAULT_WIDTH; x++) {
				int xx = x;
				int yy = y;
				JLabel lblNewLabel = new ImgLabel(5);
				lblNewLabel.setPreferredSize(new Dimension(30, 30));
				lblNewLabel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
				panel.add(lblNewLabel);
				labels[y][x] = lblNewLabel;
				lblNewLabel.addMouseListener(new MouseAdapter() {
					int downBtn;
					long downTime = Long.MAX_VALUE;
					@Override
					public void mouseClicked(MouseEvent e) {
						long t = System.currentTimeMillis() - downTime;
						if (downBtn != e.getButton() &&  t < 800 && t > 0 && game.countSign(xx, yy)==game.getState(xx, yy)) {
							for (int i = 0; i < BaseSaoLeiGame.AROUNDS.length; i++) {
								int xxx = xx + BaseSaoLeiGame.AROUNDS[i][0];
								int yyy = yy + BaseSaoLeiGame.AROUNDS[i][1];
								if (game.getState(xxx, yyy) == -1) {
									open(xxx, yyy);
								}
							}
						} else if (e.getButton() == MouseEvent.BUTTON1) {
							open(xx, yy);
						} else if (e.getButton() == MouseEvent.BUTTON3) {
							setLabel(labels[yy][xx], game.sign(xx, yy));
						}
						downBtn = e.getButton();
						downTime = System.currentTimeMillis();
					}
				});
			}
		}

		frame.pack();

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("游戏");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("作弊");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LeiWin(game);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
	}

	void open(int x, int y) {
		//System.out.printf("%s   %s\n", x, y);
		if (game.isValid(x, y) == false) {
			return;
		}
		int ret = game.open(x, y);
		// System.out.printf("x:%2s , y:%2s => %2s\r\n", x, y, ret);
		setLabel(labels[y][x], ret);
		if (ret == 0) {
			for (int i = 0; i < BaseSaoLeiGame.AROUNDS.length; i++) {
				int xx = x + BaseSaoLeiGame.AROUNDS[i][0];
				int yy = y + BaseSaoLeiGame.AROUNDS[i][1];
				if (game.getState(xx, yy) == -1) {
					open(xx, yy);
				}
			}
		}
	}

	void setLabel(JLabel label, int state) {
		if (state >= 0) {
			label.setBorder(new BevelBorder(BevelBorder.LOWERED));
			if (state > 0) {
				label.setText("" + state);
			}
		} else if (state == -2) {
			label.setIcon(BaseSaoLeiGame.IMG_SIGN);
		} else if (state == -1) {
			label.setIcon(null);
		} else if (state == -3) {
			label.setIcon(BaseSaoLeiGame.IMG_LEI);
		}

	}

}
