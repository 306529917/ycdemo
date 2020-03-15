package com.yc.game.wuzi.swing;

import javax.swing.Icon;
import javax.swing.JLabel;

public class MyLabel extends JLabel{

	private static final long serialVersionUID = 1L;
	
	private int x, y;

	public int getBoardX() {
		return x;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getBoardY() {
		return y;
	}

	public MyLabel(Icon image, int x, int y) {
		super(image);
		this.x = x;
		this.y = y;
	}

}
