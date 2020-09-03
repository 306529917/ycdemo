package com.yc.work.saolei;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class LeiWin {

	private JFrame frame;
	private BaseSaoLeiGame game;

	public LeiWin(BaseSaoLeiGame game) {
		this.game = game;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(new GridLayout(game.getHeight(), game.getWidth()));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		for (int y = 0; y < game.getHeight(); y++) {
			for (int x = 0; x < game.getWidth(); x++) {
				JLabel lblNewLabel = new ImgLabel();
				lblNewLabel.setPreferredSize(new Dimension(20, 20));
				lblNewLabel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
				if(game.isLei(x, y)) {
					lblNewLabel.setIcon(BaseSaoLeiGame.IMG_LEI);
				}
				panel.add(lblNewLabel);
			}
		}
		frame.pack();
	}

}
