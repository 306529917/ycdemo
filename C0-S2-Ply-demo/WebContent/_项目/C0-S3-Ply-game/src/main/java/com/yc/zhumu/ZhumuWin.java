package com.yc.zhumu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowFocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ZhumuWin {

	private JFrame frame;
	private ZhumuBiz zb;
	private JButton btnCommit = new JButton("提交");
	private JButton btnCancel = new JButton("取消");
	private JButton btnAddClass = new JButton("班级");
	private JComboBox<String> cbbClss = new JComboBox<>();
	private JComboBox<String> cbbTitle = new JComboBox<String>();
	private String _oldTitle;
	private String[] titleItems = new String[] { "刚才讲解的内容", "刚才的这段代码", "作业完成情况", "在线的童鞋们!!!" };

	Timer timer;

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
					zb.saveData();
				}
			}
		});
		frame.setTitle("瞩目助手");
		frame.setBounds(100, 100, 273, 103);
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

		cbbClss.setPreferredSize(new Dimension(57, 25));
		panel.add(cbbClss);
		cbbClss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cls = (String) cbbClss.getSelectedItem();
					if (cls.isEmpty()) {
						zb = null;
					} else {
						zb = new ZhumuBiz(cls);
						frame.setTitle(
								"瞩目:" + zb.getZhumuDir().getName().replaceAll(".+(\\d{2}\\.\\d{2})\\.\\d{2}.+", "$1"));
						btnAddClass.setEnabled(true);
					}
					ready();
				} catch (Exception ex) {
					cbbClss.setSelectedIndex(0);
					ex.printStackTrace();
					JOptionPane.showConfirmDialog(frame, ex.getMessage(), "系统提示", JOptionPane.CLOSED_OPTION);
				}
			}
		});
		setClsItems();

		btnAddClass.setEnabled(false);
		panel.add(btnAddClass);

		panel.add(btnCommit);
		btnCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commit();
			}
		});

		btnCommit.setEnabled(false);

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

		btnAddClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddClassWin(frame, cbbClss.getSelectedIndex() - 1).addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						ZhumuBiz.loadConf();
						setClsItems();
					}
				});
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
			zb.start(title, "1");
			cbbTitle.setEnabled(false);
			btnCommit.setEnabled(true);
			btnCancel.setEnabled(true);
			timer = new Timer();
			timer.schedule(new TimerTask() {
				int i = 30;

				@Override
				public void run() {
					if (i == 0) {
						commit();
						btnCommit.setText("提交");
						timer.cancel();
					} else {
						btnCommit.setText("" + i);
						i--;
					}
				}
			}, 0, 1000);
		}
	}

	public void commit() {
		int ret = JOptionPane.showConfirmDialog(frame, "请确认是否已经提交瞩目聊天记录?", "系统提示", JOptionPane.YES_NO_OPTION);
		if (ret != 0) {
			return;
		}
		Question q = zb.commit();
		if (q == null) {
			return;
		}
		ready();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		q.logs(false, ps);
		new ResultWin(baos.toString(), frame);
		try {
			baos.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void cancel() {
		zb.cancel();
		ready();
	}

	public void ready() {
		_oldTitle = null;
		if (timer != null) {
			timer.cancel();
		}
		cbbTitle.setEnabled(true);
		cbbTitle.getEditor().setItem("");
		cbbTitle.setSelectedIndex(0);
		btnCancel.setEnabled(false);
		btnCommit.setText("提交");
		btnCommit.setEnabled(false);
	}

	public void setClsItems() {
		String[] clsItems = ZhumuBiz.getValues("clss", new String[0]);
		clsItems = Utils.add(clsItems, "", 0);
		int index = cbbClss.getSelectedIndex();
		cbbClss.setModel(new DefaultComboBoxModel<>(clsItems));
		if (index > 0 && index < cbbClss.getItemCount()) {
			cbbClss.setSelectedIndex(index);
		}
	}
}
