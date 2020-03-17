package com.yc.game.wuzi.swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.yc.game.common.base.TwoArrayGame;
import com.yc.game.common.swing.BoardLabel;
import com.yc.game.common.swing.BoardPanel;
import com.yc.game.common.swing.BoardWin;
import com.yc.game.wuzi.base.WuziGame;
import com.yc.game.wuzi.core.Imgs;

/**
 * 游戏主窗口，创建时必须传入游戏对象（参数是接口）
 * @author 廖彦
 *
 */
public class MainWin extends BoardWin {

	// 不解释
	private static final long serialVersionUID = 1L;
	private MouseAdapter ma;
	private WuziGame game;

	/**
	 * 构建窗体
	 */
	public MainWin(WuziGame game) {
		super("开森五子棋", game, Imgs.CHESS);
		this.game = game;
	}

	@Override
	protected BoardPanel customCreateBoard(TwoArrayGame game, ImageIcon[] cellIcons) {
		return new BoardPanel(game, cellIcons, Imgs.BOARD);
	}

	@Override
	protected void initBoardLabel(BoardLabel bl, int x, int y) {
		if (ma == null) {
			ma = new MouseAdapter() {
				@Override
				// 鼠标移动事件
				public void mouseEntered(MouseEvent e) {
					refresh();
					BoardLabel ml = (BoardLabel) e.getSource();
					String pointName = game.getPointerName(ml.getBoardX(), ml.getBoardY());
					Icon icon = Imgs.getPointIcon(pointName);
					ml.setIcon(icon);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					if (game.getWuzi() != null) {
						return;
					}
					BoardLabel ml = (BoardLabel) e.getSource();
					game.down(ml.getBoardX(), ml.getBoardY());
					refresh();
					if (game.getWuzi() != null) {
						String color = (int) game.getWinner() == WuziGame.BLACK ? "黑" : "白";
						JOptionPane.showMessageDialog(null, color + "棋赢了!");
					}
				}
			};
		}
		bl.addMouseListener(ma);
	}

}
