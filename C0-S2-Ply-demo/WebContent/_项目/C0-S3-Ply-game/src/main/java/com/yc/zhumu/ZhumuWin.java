package com.yc.zhumu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.WindowFocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class ZhumuWin {

	private JFrame frame;
	private ZhumuBiz zb = new ZhumuBiz();
	private JButton btnCommit = new JButton("提交");
	private JButton btnCancel = new JButton("取消");
	private JButton btnClass = new JButton("上课");
	private JComboBox<String> cbbTitle = new JComboBox<String>();
	private String _oldTitle;
	private String[] titleItems = new String[] { "刚才讲解的内容", "刚才的这段代码", "作业完成情况", "在线的童鞋们!!!" };

	private final JButton btnLookup = new JButton("查看");
	private final JPopupMenu popupMenu = new JPopupMenu();
	private final JMenuItem menuItem = new JMenuItem("回复统计");
	private final JMenuItem menuItem_1 = new JMenuItem("回复记录文件");
	private final JMenuItem menuItem_2 = new JMenuItem("瞩目聊天文件");
	private final JMenuItem menuItem_3 = new JMenuItem("配置信息文件");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZhumuWin window = new ZhumuWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ZhumuWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
			}

			public void windowLostFocus(WindowEvent e) {
				start();
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ZhumuBiz.setValues("xy", frame.getLocation().x + "", frame.getLocation().y + "");
				ZhumuBiz.saveConf();
				if (zb != null) {
					try {
						zb.saveData();
					} catch (ZhumuException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		frame.setTitle("瞩目助手");
		frame.setBounds(100, 100, 284, 103);
		frame.setPreferredSize(frame.getSize());
		frame.setMinimumSize(frame.getSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		String[] xy = ZhumuBiz.getValues("xy", new String[0]);
		if (xy.length > 0) {
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			frame.setLocation(x, y);
		} else {
			Utils.center(frame);
		}
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setAlignmentY(0.0f);
		panel.setAlignmentX(0.0f);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		addPopup(panel, popupMenu);
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (zb.getReportFile() != null) {
					new ResultWin(frame, zb.getReportFile());
				} else {
					Utils.alert(frame, "至少要有一次提问记录!");
				}
			}
		});
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (zb.getReportFile() != null) {
					new ResultWin(zb.export(), frame);
				} else {
					Utils.alert(frame, "至少要有一次提问记录!");
				}
			}
		});

		popupMenu.add(menuItem);

		popupMenu.add(menuItem_1);
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (zb.getMeetingFile() != null) {
					new ResultWin(frame,zb.getMeetingFile());
				} else {
					Utils.alert(frame, "请先开启瞩目保存聊天记录!");
				}
			}
		});

		popupMenu.add(menuItem_2);
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResultWin(frame,ZhumuBiz.configFile)
				.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						ZhumuBiz.loadConf();
					}
				});;
			}
		});

		popupMenu.add(menuItem_3);
		panel.add(btnClass);

		panel.add(btnCommit);
		btnCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commit();
			}
		});

		btnCommit.setEnabled(false);
		btnLookup.setEnabled(false);
		btnLookup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lookup();
			}
		});

		panel.add(btnLookup);

		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		btnCancel.setEnabled(false);
		cbbTitle.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.isShiftDown() && e.getKeyCode() > 111 && e.getKeyCode() < 125) {
					int index = e.getKeyCode() - 111;
					if (index < cbbTitle.getItemCount()) {
						cbbTitle.setSelectedIndex(index);
					}
				}
			}
		});
		cbbTitle.setEnabled(false);
		String[] items = ZhumuBiz.getValues("titles", null);
		if (items == null) {
			ZhumuBiz.setValues("titles", titleItems);
			items = titleItems;
		}
		cbbTitle.setModel(new DefaultComboBoxModel<>(Utils.add(items, "", 0)));
		cbbTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});

		cbbTitle.setEditable(true);
		frame.getContentPane().add(cbbTitle, BorderLayout.CENTER);

		btnClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddClassWin(frame, zb).addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						if (zb.getCls() != null) {
							btnClass.setText(zb.getCls() + "班");
							frame.setTitle(zb.getCls() + "班["
									+ zb.getMeetingDir().getName().replaceAll(".+(\\d{2}\\.\\d{2})\\.\\d{2}.+", "$1")
									+ "]");
							ready();
						}
					}
				});
				;
			}
		});
	}

	public void start() {
		if (zb == null)
			return;
		String title = (String) cbbTitle.getSelectedItem();
		if (title == null || title.trim().isEmpty()) {
			title = (String) cbbTitle.getEditor().getItem();
		}
		if (title != null && title.trim().isEmpty() == false && _oldTitle != title) {
			_oldTitle = title;
			try {
				zb.start(title, "1");
			} catch (ZhumuException e) {
				Utils.alert(frame, e.getMessage());
			}
			cbbTitle.setEnabled(false);
			btnCommit.setEnabled(true);
			btnCancel.setEnabled(true);
			btnLookup.setEnabled(true);
		}
	}

	public void commit() {
		Question q = null;
		try {
			if (Utils.confirm(frame, "请确认是否已经提交瞩目聊天记录?")) {
				q = zb.saveData();
			}
		} catch (ZhumuException e1) {
			Utils.alert(frame, e1.getMessage());
		}
		ready();
		lookup();
	}

	public void cancel() {
		zb.cancel();
		ready();
	}

	public void ready() {
		_oldTitle = null;
		cbbTitle.setEnabled(true);
		cbbTitle.getEditor().setItem("");
		cbbTitle.setSelectedIndex(0);
		btnCommit.setText("提交");
		btnCommit.setEnabled(false);
		btnLookup.setEnabled(false);
		btnCancel.setEnabled(false);
	}

	public void lookup() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		zb.getQuestion().logs(false, ps);
		new ResultWin(baos.toString(), frame);
		try {
			baos.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
