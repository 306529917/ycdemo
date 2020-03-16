package com.yc.game.pushbox.version2.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.yc.game.common.util.IOUtils;
import com.yc.game.pushbox.base.PushBoxGame;
import com.yc.game.pushbox.imgs.Imgs;
import com.yc.game.pushbox.version2.core.PushBoxGameImpl2;

/**
 * 版本2的界面加入的按钮
 * @author 廖彦
 */
public class MainWin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel[][] labels;
	private PushBoxGame game;
	private static final Icon[] IMGS = new Icon[10];

	static {
		for (int i = 0; i < IMGS.length; i++) {
			InputStream in = Imgs.class.getResourceAsStream(i + ".gif");
			IMGS[i] = new ImageIcon(IOUtils.toByteArray(in));
		}
	}

	public static void main(String[] args) {
		new MainWin(new PushBoxGameImpl2());
	}

	public MainWin(PushBoxGame game) {
		super("推箱子");
		this.game = game;
		labels = new JLabel[game.getMap().length][game.getMap()[0].length];
		// 由于右边要添加按钮,所以窗体布局改为边界布局
		setLayout(new BorderLayout());
		// 创建放置地图的面板
		JPanel mapPanel = new JPanel();
		// 面板设置网格布局
		mapPanel.setLayout(new GridLayout(game.getMap().length, game.getMap()[0].length));
		// 生成地图界面
		for (int i = 0; i < game.getMap().length; i++) {
			for (int j = 0; j < game.getMap()[i].length; j++) {
				labels[i][j] = new JLabel(IMGS[game.getMap()[i][j]]);
				mapPanel.add(labels[i][j]);
			}
		}
		// 将面板添加到窗体中
		add(mapPanel, BorderLayout.CENTER);
		// 创建右边的放置按钮的面板
		JPanel conPanel = new JPanel();
		// 设置首选大小
		conPanel.setPreferredSize(new Dimension(100, 0));
		// 设置流式布局
		conPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		// 添加显示步数的空间
		JLabel stepLabel = new JLabel("第几步");
		conPanel.add(stepLabel);

		// 添加三个按钮, 第二个参数是 lambda 表达式
		conPanel.add(buildBtn("重来一次", (ActionEvent e) -> {
			game.reset();
			// 刷新地图控件
			refresh();
		}));
		conPanel.add(buildBtn("下一关", (ActionEvent e) -> {
			game.next();
			// 刷新地图控件
			refresh();
		}));
		conPanel.add(buildBtn("退出", (ActionEvent e) -> {
			// 关闭窗口
			MainWin.this.dispose();
		}));
		add(conPanel, BorderLayout.EAST);

		// 窗体适应控件大小
		pack();
		// 关闭窗口退出程序
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 窗口居中
		center();
		// 打开窗口
		setVisible(true);

		/**
		 * 	添加键盘事件监听器( 当按下上下左右时触发的事件 )
		 */
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// 只处理4个方向键
				if (e.getKeyCode() < KeyEvent.VK_LEFT && e.getKeyCode() > KeyEvent.VK_DOWN) {
					return;
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					game.up();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					game.down();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					game.left();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					game.right();
				}
				PushBoxGameImpl2 g2 = (PushBoxGameImpl2) game;
				stepLabel.setText("第" + g2.getStepNumber() + "步");
				refresh();
				if (game.isOver()) {
					JOptionPane.showMessageDialog(null, "厉害！本关您一共移动了" + g2.getStepNumber() + "步");
					game.next();
					refresh();
				}
			}
		});
	}

	/**
	 * 	刷新地图
	 */
	public void refresh() {
		for (int i = 0; i < game.getMap().length; i++) {
			for (int j = 0; j < game.getMap()[i].length; j++) {
				labels[i][j].setIcon(IMGS[game.getMap()[i][j]]);
			}
		}
	}

	/**
	 * 	窗口居中
	 */
	public void center() {
		int screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int windowwidth = this.getSize().width;
		int windowheight = this.getSize().height;
		this.setLocation((screenwidth - windowwidth) / 2, (screenheight - windowheight) / 2);
	}

	/**
	 * 	创建按钮控件
	 * @param name	按钮名
	 * @param al	监听器
	 * @return		按钮控件
	 */
	public JButton buildBtn(String name, ActionListener al) {
		JButton ret = new JButton(name);
		ret.setPreferredSize(new Dimension(90, 30));
		ret.addActionListener(al);
		// 禁止按钮得到焦点, 避免争抢窗口的按钮事件
		ret.setFocusable(false);
		return ret;
	}

}
