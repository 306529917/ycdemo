package com.yc.teach;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeachWin {

	private JFrame frame;
	private TeachBiz tbiz = new TeachBiz();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeachWin window = new TeachWin();
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
	public TeachWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 305, 321);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(14, 13, 124, 24);
		frame.getContentPane().add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 50, 124, 190);
		frame.getContentPane().add(scrollPane);

		JList<String> list = new JList<>();
		scrollPane.setViewportView(list);

		JButton btnNewButton = new JButton(">>");
		btnNewButton.setBounds(155, 248, 49, 27);
		frame.getContentPane().add(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(155, 50, 124, 190);
		frame.getContentPane().add(scrollPane_1);
		
				JList<String> list_1 = new JList<>();
				scrollPane_1.setViewportView(list_1);

		JButton btnNewButton_2 = new JButton("启动");
		btnNewButton_2.setBounds(209, 11, 70, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.setBounds(14, 248, 49, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("-");
		btnNewButton_3.setBounds(89, 248, 49, 27);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("-");
		btnNewButton_3_1.setBounds(230, 248, 49, 27);
		frame.getContentPane().add(btnNewButton_3_1);
		
		JButton btnNewButton_1_1 = new JButton("+");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("请输入班级!");
				tbiz.addCls(name);
			}
		});
		btnNewButton_1_1.setBounds(155, 11, 49, 27);
		frame.getContentPane().add(btnNewButton_1_1);
	}
}
