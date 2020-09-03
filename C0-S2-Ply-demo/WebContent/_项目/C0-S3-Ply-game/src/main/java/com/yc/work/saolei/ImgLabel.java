package com.yc.work.saolei;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ImgLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	private int margin = 2;

	public ImgLabel() {
		super((String) null, SwingConstants.CENTER);
		setFont(new Font("黑体", Font.PLAIN, 18));
	}

	public ImgLabel(int margin) {
		this();
		this.margin = margin;
	}

	public void setText(String text) {
		if (text != null) {
			text = "<html><b>" + text + "</b></html>";
		}
		super.setText(text);
	}

	protected void paintComponent(Graphics g) {
		ImageIcon icon = (ImageIcon) this.getIcon();
		if (icon != null) {
			g.drawImage(icon.getImage(), margin, margin, getWidth() - margin - margin, getHeight() - margin - margin,
					icon.getImageObserver());
		} else {
			super.paintComponent(g);
		}
	}

}
