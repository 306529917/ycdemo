package com.yc.zhumu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.WindowFocusListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPopupMenu;
import javax.swing.JRootPane;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class ZhumuWin {

	private JFrame frame;
	private ZhumuBiz zb = new ZhumuBiz();
	private JButton btnLookup = new JButton("查看");
	private JButton btnCancel = new JButton("取消");
	private JButton btnClass = new JButton("上课");
	private JComboBox<String> cbbTitle = new JComboBox<String>();
	private String _oldTitle;
	private int _time = -1;
	private Date _date = new Date();
	private String[] titleItems = new String[] { "刚才讲解的内容", "刚才的这段代码", "作业完成情况", "在线的童鞋们!!!" };
	private final JPopupMenu popupMenu = new JPopupMenu();
	private final JMenuItem menuItem = new JMenuItem("本次课统计");
	private final JMenuItem menuItem_1 = new JMenuItem("回复记录文件");
	private final JMenuItem menuItem_2 = new JMenuItem("瞩目聊天文件");
	private final JMenuItem menuItem_3 = new JMenuItem("配置信息文件");
	private final JButton btnSave = new JButton("提交");
	private final JMenu menu = new JMenu("查看文件");
	private final JMenu menu_1 = new JMenu("瞩目配置");
	private final JMenuItem menuItem_4 = new JMenuItem("打开瞩目目录");
	private final JMenuItem menuItem_5 = new JMenuItem("设置瞩目目录");
	private final JMenu menu_2 = new JMenu("回复统计");
	private final JMenuItem menuItem_6 = new JMenuItem("前三次课统计");
	private final JMenuItem menuItem_7 = new JMenuItem("前十次课统计");

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
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
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
		frame.setBounds(100, 100, 284, 97);
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
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		addPopup(panel, popupMenu);

		popupMenu.add(menu_1);
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("explorer.exe /root," + ZhumuBiz.zhumuHome);
				} catch (IOException e1) {
					e1.printStackTrace();
					Utils.alert(e1.getMessage());
				}
			}
		});

		menu_1.add(menuItem_4);
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fd = new JFileChooser();
				fd.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
				fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fd.showOpenDialog(null);
				File f = fd.getSelectedFile();
				ZhumuBiz.zhumuHome = f.getAbsolutePath();
				System.out.println("目录重置为: " + ZhumuBiz.zhumuHome);
			}
		});

		menu_1.add(menuItem_5);

		popupMenu.add(menu);
		menu.add(menuItem_1);
		menu.add(menuItem_2);
		menu.add(menuItem_3);

		popupMenu.add(menu_2);
		menu_2.add(menuItem);
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				report(3);
			}
		});

		menu_2.add(menuItem_6);
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				report(10);
			}
		});

		menu_2.add(menuItem_7);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				report(0);
			}
		});
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResultWin(frame, ZhumuBiz.configFile).addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						ZhumuBiz.loadConf();
					}
				});
				;
			}
		});
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (zb.getMeetingFile() != null) {
					new ResultWin(frame, zb.getMeetingFile());
				} else {
					Utils.alert("请先开启瞩目，然后保存聊天记录!");
				}
			}
		});
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (zb.getReportFile() != null) {
					new ResultWin(frame, zb.getReportFile());
				} else {
					Utils.alert("还没开始上课!");
				}
			}
		});
		panel.add(btnClass);

		panel.add(btnLookup);
		btnLookup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lookup();
			}
		});

		btnLookup.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (Utils.confirm("请确认是否已经保存了瞩目聊天文件?")) {
						zb.commit();
						zb.saveData();
						new ResultWin(zb, frame);
						ready();
					}
				} catch (ZhumuException e1) {
					Utils.alert(e1.getMessage());
				}
			}
		});
		btnSave.setEnabled(false);

		panel.add(btnSave);

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
		cbbTitle.setPreferredSize(new Dimension(0, 30));
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
		frame.getContentPane().add(cbbTitle, BorderLayout.NORTH);

		btnClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddClassWin(frame, zb).addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						if (zb.getCls() != null) {
							ready();
						}
					}
				});
				;
			}
		});
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (_time >= 0) {
					_time += 1000;
					_date.setTime(_time);
					frame.setTitle("计时: " + Question.MS.format(_date));
				}
			}
		}, 0, 1000);
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
				Utils.alert(e.getMessage());
			}
			_time = 0;
			cbbTitle.setEnabled(false);
			btnLookup.setEnabled(true);
			btnCancel.setEnabled(true);
			btnSave.setEnabled(true);
			btnClass.setEnabled(false);
		}
	}

	public void cancel() {
		ready();
	}

	public void ready() {
		_time = -1;
		_oldTitle = null;
		btnClass.setText(zb.getCls() + "班");
		frame.setTitle(zb.getMeetingName());
		cbbTitle.setEnabled(true);
		cbbTitle.getEditor().setItem("");
		cbbTitle.setSelectedIndex(0);
		btnLookup.setText("查看");
		btnLookup.setEnabled(zb.getQuestion() != null);
		btnCancel.setEnabled(false);
		btnSave.setEnabled(false);
		btnClass.setEnabled(true);
	}

	public void lookup() {
		try {
			zb.commit();
		} catch (ZhumuException e) {
			Utils.alert(e.getMessage());
			return;
		}
		new ResultWin(zb, frame);
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

	public void report(int num) {
		if (zb.getReportFile() != null) {
			try {
				new ResultWin(zb.export(num), frame);
			} catch (ZhumuException e1) {
				Utils.alert(e1.getMessage());
			}
		} else {
			Utils.alert("至少要有一次提问记录!");
		}
	}
}
