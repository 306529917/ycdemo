package com.yc.pushbox.version2.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.yc.pushbox.version1.core.Game;

public class MainWin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int map[][] = Game.next();
	private JLabel[][] labels = new JLabel[map.length][map[0].length];
	private static final Icon[] IMGS = new Icon[10];

	static {
		for (int i = 0; i < IMGS.length; i++) {
			IMGS[i] = new ImageIcon(MainWin.class.getResource("/imgs/" + i + ".gif"));
		}
	}

	public static void main(String[] args) {
		new MainWin();
	}

	public MainWin() {
		super("������");
		// �����ұ�Ҫ��Ӱ�ť,���Դ��岼�ָ�Ϊ�߽粼��
		setLayout(new BorderLayout());
		// �������õ�ͼ�����
		JPanel mapPanel = new JPanel();
		// ����������񲼾�
		mapPanel.setLayout(new GridLayout(map.length, map[0].length));
		// ���ɵ�ͼ����
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				labels[i][j] = new JLabel(IMGS[map[i][j]]);
				mapPanel.add(labels[i][j]);
			}
		}
		// �������ӵ�������
		add(mapPanel, BorderLayout.CENTER);
		// �����ұߵķ��ð�ť�����
		JPanel conPanel = new JPanel();
		// ������ѡ��С
		conPanel.setPreferredSize(new Dimension(100, 0));
		// ������ʽ����
		conPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// ���������ť, �ڶ��������� lambda ���ʽ
		conPanel.add(buildBtn("����һ��", (ActionEvent e) -> {
			map = Game.reset();
			// ˢ�µ�ͼ�ؼ�
			refresh();
		}));
		conPanel.add(buildBtn("��һ��", (ActionEvent e) -> {
			map = Game.next();
			// ˢ�µ�ͼ�ؼ�
			refresh();
		}));
		conPanel.add(buildBtn("�˳�", (ActionEvent e) -> {
			// �رմ���
			MainWin.this.dispose();
		}));
		add(conPanel, BorderLayout.EAST);
		
		// ������Ӧ�ؼ���С
		pack();
		// �رմ����˳�����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ���ھ���
		center();
		// �򿪴���
		setVisible(true);
		
		/**
		 * 	��Ӽ����¼�������( ��������������ʱ�������¼� )
		 */
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					Game.up();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					Game.down();
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					Game.left();
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					Game.right();
				}
				refresh();
				if (Game.isOver()) {
					JOptionPane.showMessageDialog(null, "Ӣ��ס�֣�ʤ���Ѿ���");
					map = Game.next();
					refresh();
				}
			}
		});
	}

	/**
	 * 	ˢ�µ�ͼ
	 */
	public void refresh() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				labels[i][j].setIcon(IMGS[map[i][j]]);
			}
		}
	}

	/**
	 * 	���ھ���
	 */
	public void center() {
		int screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int windowwidth = this.getSize().width;
		int windowheight = this.getSize().height;
		this.setLocation((screenwidth - windowwidth) / 2, (screenheight - windowheight) / 2);
	}

	/**
	 * 	������ť�ؼ�
	 * @param name	��ť��
	 * @param al	������
	 * @return		��ť�ؼ�
	 */
	public JButton buildBtn(String name, ActionListener al) {
		JButton ret = new JButton(name);
		ret.setPreferredSize(new Dimension(90, 30));
		ret.addActionListener(al);
		// ��ֹ��ť�õ�����, �����������ڵİ�ť�¼�
		ret.setFocusable(false);
		return ret;
	}

}
