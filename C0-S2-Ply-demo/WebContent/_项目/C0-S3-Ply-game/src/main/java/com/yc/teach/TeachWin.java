package com.yc.teach;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class TeachWin {

	private JFrame frame;

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
		frame.setBounds(100, 100, 450, 300);
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
		btnNewButton.setBounds(152, 80, 49, 27);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.setBounds(152, 120, 49, 27);
		frame.getContentPane().add(btnNewButton_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(215, 50, 124, 190);
		frame.getContentPane().add(scrollPane_1);

		JList<String> list_1 = new JList<>();
		scrollPane_1.setViewportView(list_1);

		JButton btnNewButton_2 = new JButton("启动");
		btnNewButton_2.setBounds(215, 12, 124, 27);
		frame.getContentPane().add(btnNewButton_2);
	}
}
