package com.yc.game.link.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;

import com.yc.game.common.swing.BoardLabel;
import com.yc.game.common.swing.BoardWin;
import com.yc.game.common.util.LangUtils;
import com.yc.game.link.base.LinkGame;

public class MainWin extends BoardWin {

	private static final long serialVersionUID = 1L;

	protected LinkGame game;

	protected BoardLabel point1;

	public MainWin(LinkGame game, ImageIcon[] cellIcons) {
		super("连连看", game, cellIcons);
		MouseAdapter ma = new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				// 设置边框
				LangUtils.each(boardPanel.getLabels(), (BoardLabel bl, int[] pos) -> {
					if (bl != point1) {
						bl.setBorder(null);
					}
					return true;
				});
				BoardLabel bl = (BoardLabel) e.getSource();
				bl.setBorder(BorderUIResource.getRaisedBevelBorderUIResource());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				BoardLabel bl = (BoardLabel) e.getSource();
				if (point1 == null || point1 == bl) {
					bl.setBorder(BorderUIResource.getRaisedBevelBorderUIResource());
					point1 = bl;
				} else {
					game.link(bl.getBoardX(), bl.getBoardY(), point1.getBoardX(), point1.getBoardY());
					point1.setBorder(null);
					point1 = null;
				}
				refresh();
			}
		};
		LangUtils.each(boardPanel.getLabels(), (BoardLabel c, int[] pos) -> {
			c.addMouseListener(ma);
			return true;
		});

	}

}
