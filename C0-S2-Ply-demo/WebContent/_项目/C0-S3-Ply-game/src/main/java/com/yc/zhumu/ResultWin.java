package com.yc.zhumu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextArea;
import java.awt.CardLayout;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ResultWin extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton button = new JButton("保存");
	private File file;
	private ZhumuBiz zb;

	public ResultWin(ZhumuBiz zb, Frame onner) {
		this(readLogs(zb), onner);
		this.zb = zb;
	}

	/**
	 * @wbp.parser.constructor
	 */
	public ResultWin(String result, Frame onner) {
		super(onner);
		setModal(true);
		setTitle("查看");
		setBounds(100, 100, 388, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, "name_12632113040062");

		JTextArea textArea = new JTextArea(result);
		scrollPane.setViewportView(textArea);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (file == null)
					return;
				try {
					if (zb != null) {
						zb.saveData();
					} else {
						PrintWriter pw = new PrintWriter(file);
						pw.print(textArea.getText());
						pw.close();
					}
					Utils.alert("文件保存成功!");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					Utils.alert("文件不存在!");
				} catch (ZhumuException e1) {
					Utils.alert(e1.getMessage());
				}
			}
		});

		button.setEnabled(false);
		buttonPane.add(button);
		JButton cancelButton = new JButton("关闭");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultWin.this.dispose();
			}
		});

		Utils.center(this);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		textArea.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				button.setEnabled(file != null);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				button.setEnabled(file != null);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				button.setEnabled(file != null);
			}
		});
	}

	public ResultWin(Frame onner, String filepath) {
		this(onner, new File(filepath));
	}

	public ResultWin(Frame onner, File file) {
		this(readfile(file), onner);
		this.setTitle("查看: " + file.getName());
		this.file = file;
		this.button.setEnabled(true);
	}

	private static String readLogs(ZhumuBiz zb) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			PrintStream ps = new PrintStream(baos);
			zb.lookup(false, ps);
			return baos.toString();
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private static String readfile(File file) {
		if (file.exists() == false) {
			return "文件不存在: " + file.getAbsolutePath();
		}
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
		}
		return sb.toString();
	}

}
