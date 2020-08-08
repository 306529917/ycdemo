package com.yc.zhumu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckWin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea taResult;
	private JTextArea taStudent;
	private JTextArea taFinish;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CheckWin dialog = new CheckWin();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CheckWin() {
		setModal(true);
		setTitle("作业检查助手");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 561, 420);
		Utils.center(this);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				taFinish = new JTextArea();
				taFinish.setToolTipText("完成学生汇总");
				taFinish.addAncestorListener(new AncestorListener() {
					public void ancestorAdded(AncestorEvent event) {
						check();
					}

					public void ancestorMoved(AncestorEvent event) {
						check();
					}

					public void ancestorRemoved(AncestorEvent event) {
						check();
					}
				});
				scrollPane.setViewportView(taFinish);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				taStudent = new JTextArea();
				taStudent.setToolTipText("学生列表");
				taStudent.addAncestorListener(taFinish.getListeners(AncestorListener.class)[0]);
				scrollPane.setViewportView(taStudent);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				taResult = new JTextArea();
				taFinish.setToolTipText("完成学生列表");
				scrollPane.setViewportView(taResult);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("退出");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CheckWin.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	public void check() {
		String[] ret = Utils.check(taStudent.getText(), taFinish.getText());
		taResult.setText(String.join("\n", ret));
	}

}
