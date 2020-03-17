package com.yc.game.link.swing;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.BorderUIResource;

import com.yc.game.common.swing.BoardLabel;
import com.yc.game.common.swing.BoardWin;
import com.yc.game.common.util.SwingUtils;
import com.yc.game.link.base.LinkGame;

public class MainWin extends BoardWin {

	private static final long serialVersionUID = 1L;
	protected BoardLabel point1;
	protected LinkGame game;

	MouseAdapter ma;

	public MainWin(LinkGame game, ImageIcon[] cellIcons) {
		super("连连看", game, cellIcons);
		this.game = game;
	}

	@Override
	protected void initBoardLabel(BoardLabel bl, int x, int y) {
		if (ma == null) {
			ma = new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					BoardLabel[][] bls = boardPanel.getLabels();
					for (int y = 0; y < bls.length; y++) {
						for (int x = 0; x < bls[y].length; x++) {
							BoardLabel bl = bls[y][x];
							if (bl != point1) {
								// 设置默认边框
								bl.setBorder(BorderUIResource.getEtchedBorderUIResource());
							}
						}
					}
					// 鼠标移入设置3D边框
					BoardLabel bl = (BoardLabel) e.getSource();
					bl.setBorder(BorderUIResource.getRaisedBevelBorderUIResource());
				}

				@Override
				public void mousePressed(MouseEvent e) {
					BoardLabel bl = (BoardLabel) e.getSource();
					if (point1 == null || point1 == bl) {
						// 点击并记录第一张图片
						bl.setBorder(BorderUIResource.getRaisedBevelBorderUIResource());
						point1 = bl;
					} else {
						// 点击并第二张图片, 判断是否连接成功
						game.link(bl.getBoardX() + 1, bl.getBoardY() + 1, point1.getBoardX() + 1,
								point1.getBoardY() + 1);
						point1.setBorder(BorderUIResource.getEtchedBorderUIResource());
						point1 = null;
					}
					refresh();
					// 判断游戏是否结束
					if (game.isOver()) {
						JOptionPane.showMessageDialog(null, "腻害！你赢了！！！");
						game.begin();
						refresh();
					}
				}
			};
		}
		bl.setBorder(BorderUIResource.getEtchedBorderUIResource());
		bl.addMouseListener(ma);
	}

	protected void buildButton(JPanel panel) {
		JComboBox<String> cbb = new JComboBox<>(new String[] { "卡通少女", "QQ头像" });
		cbb.setPreferredSize(new Dimension(100, 30));
		cbb.addActionListener((e) -> {
			int iconWidth = boardPanel.getCellIcons()[0].getIconWidth();
			int iconHeight = boardPanel.getCellIcons()[0].getIconHeight();
			String item = (String) cbb.getSelectedItem();
			String path;
			ImageIcon[] cellIcons;
			switch (item) {
			case "QQ头像":
				path = "/com/yc/game/common/imgs/cartoon/head/%s.jpg";
				cellIcons = SwingUtils.buildImageIcons(SwingUtils.class, 
						SwingUtils.iterator(path, 0, 20), iconWidth, iconHeight);
				break;
			case "卡通少女":
				path = "/com/yc/game/common/imgs/cartoon/girl/%s.jpg";
				cellIcons = SwingUtils.buildImageIcons(SwingUtils.class, 
						SwingUtils.iterator(path, 0, 20), iconWidth, iconHeight);
				break;
			default:
				return;
			}
			boardPanel.setCellIcons(cellIcons);
			game.begin();
			refresh();
		});
		panel.add(cbb);
		super.buildButton(panel);
	}

}
