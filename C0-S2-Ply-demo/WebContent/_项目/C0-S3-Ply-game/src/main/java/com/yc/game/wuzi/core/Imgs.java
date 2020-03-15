package com.yc.game.wuzi.core;

import java.util.HashMap;

import javax.swing.Icon;

import com.yc.game.util.SwingUtils;

public class Imgs {

	public static final Icon SPACE = icon("space.png");
	public static final Icon BLACK = icon("black.png");
	public static final Icon WHITE = icon("white.png");
	public static final Icon BOARD = icon("chessboard.png");

	public static final Icon[] CHESS = { SPACE, BLACK, WHITE };

	private static final HashMap<String, Icon> POINT_IMG_MAP = new HashMap<String, Icon>();

	static {
		POINT_IMG_MAP.put(WuziGame.POINT_UP, icon("hover_up.png"));
		POINT_IMG_MAP.put(WuziGame.POINT_UP_LEFT, icon("hover_up_left.png"));
		POINT_IMG_MAP.put(WuziGame.POINT_UP_RIGHT, icon("hover_up_right.png"));
		POINT_IMG_MAP.put(WuziGame.POINT_DOWN, icon("hover_down.png"));
		POINT_IMG_MAP.put(WuziGame.POINT_DOWN_LEFT, icon("hover_down_left.png"));
		POINT_IMG_MAP.put(WuziGame.POINT_DOWN_RIGHT, icon("hover_down_right.png"));
		POINT_IMG_MAP.put(WuziGame.POINT_LEFT, icon("hover_left.png"));
		POINT_IMG_MAP.put(WuziGame.POINT_RIGHT, icon("hover_right.png"));
		POINT_IMG_MAP.put(WuziGame.POINT_BLACK, icon("black_last.png"));
		POINT_IMG_MAP.put(WuziGame.POINT_WHITE, icon("white_last.png"));
		POINT_IMG_MAP.put(WuziGame.POINT_CENTER, icon("hover.png"));
	}

	/**
	 *  获取位置图片,用于鼠标悬停在棋盘上显示的图片
	 * @param pointName 位置名: 左上,右上,白子上...
	 * @return
	 */
	public static Icon getPointIcon(String pointName) {
		return POINT_IMG_MAP.get(pointName);
	}

	private static Icon icon(String path) {
		return SwingUtils.getImageIcon(Imgs.class, "imgs/" + path);
	}

}
