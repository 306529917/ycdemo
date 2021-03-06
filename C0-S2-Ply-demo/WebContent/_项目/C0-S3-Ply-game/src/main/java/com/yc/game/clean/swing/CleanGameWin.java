package com.yc.game.clean.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.BorderUIResource;

import com.yc.game.clean.base.CleanGame;
import com.yc.game.clean.core.CleanGameImpl;
import com.yc.game.common.swing.BoardLabel;
import com.yc.game.common.swing.BoardWin;

public class CleanGameWin extends BoardWin {

	private static final long serialVersionUID = 1L;

	private CleanGame game;
	protected BoardLabel point1;
	private MouseAdapter ma;

	public CleanGameWin(CleanGame game, ImageIcon[] cellIcons) {
		super("元气少女消消乐", game, cellIcons);
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
						game.swap(bl.getBoardX(), bl.getBoardY(), point1.getBoardX(), point1.getBoardY());
						point1.setBorder(BorderUIResource.getEtchedBorderUIResource());
						point1 = null;
					}
					refresh();
				}
			};
		}
		bl.setBorder(BorderUIResource.getEtchedBorderUIResource());
		bl.addMouseListener(ma);
	}

	@Override
	protected void buildButton(JPanel panel) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		JLabel timeLabel = new JLabel(sdf.format(date));
		panel.add(timeLabel);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				date.setTime(date.getTime() + 1000);
				timeLabel.setText(sdf.format(date));
			}
		}, 1000, 1000);
		panel.add(createButton("test", (e) -> {
			CleanGameImpl g = (CleanGameImpl) game;
			g.down();
			refresh();
		}));

		super.buildButton(panel);
	}

}
