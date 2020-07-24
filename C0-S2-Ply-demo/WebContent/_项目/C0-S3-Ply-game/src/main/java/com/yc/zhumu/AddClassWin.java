package com.yc.zhumu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class AddClassWin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public AddClassWin(Frame onner, ZhumuBiz zb) {
		super(onner);
		setModal(true);
		setTitle("选择班级");
		setBounds(100, 100, 388, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, "name_12632113040062");

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("确定");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);

		getRootPane().setDefaultButton(okButton);
		JButton cancelButton = new JButton("关闭");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("切换班级:");
		panel.add(lblNewLabel);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] s = ZhumuBiz.getValues((String) comboBox.getSelectedItem(), new String[0]);
				textArea.setText(String.join("\n", s));
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<>(ZhumuBiz.getValues("clss", null)));
		comboBox.setEditable(true);
		comboBox.setPreferredSize(new Dimension(240, 21));
		if (comboBox.getModel().getSize() > 0) {
			if (zb.getCls() != null) {
				comboBox.setSelectedItem(zb.getCls());
			} else {
				comboBox.setSelectedIndex(0);
			}
		}
		panel.add(comboBox);

		JLabel label = new JLabel("学生姓名用逗号或换行符隔开");
		panel.add(label);
		panel.setPreferredSize(new Dimension(100, 50));

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					zb.init((String) comboBox.getSelectedItem());
					ZhumuBiz.addClass(zb.getCls(), textArea.getText());
					AddClassWin.this.dispose();
				} catch (ZhumuException e1) {
					Utils.alert(e1.getMessage());
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddClassWin.this.dispose();
			}
		});

		Utils.center(this);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
